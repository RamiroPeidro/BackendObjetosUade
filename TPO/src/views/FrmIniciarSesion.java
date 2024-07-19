package views;

import Dtos.UsuarioDTO;
import controller.AdministradorController;
import model.TipoDeUsuario;
import service.UsuarioService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmIniciarSesion extends JFrame {

    private AdministradorController administradorController;
    private static String botonSeleccionado;

    public FrmIniciarSesion(String botonSeleccionado) {

        this.administradorController = AdministradorController.getInstance();
        this.botonSeleccionado = botonSeleccionado;

        setTitle("Inicio de Sesión");
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame

        JLabel userLabel = new JLabel("Usuario:");
        JTextField userText = new JTextField(20);
        JLabel passwordLabel = new JLabel("Contraseña:");
        JPasswordField passwordText = new JPasswordField(20);
        JButton loginButton = new JButton("Iniciar Sesión");

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Padding

        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(userLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(userText, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(passwordText, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(loginButton, gbc);

        add(panel);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = userText.getText();
                String password = new String(passwordText.getPassword());
                try {
                    UsuarioDTO usuario = administradorController.iniciarSesion(nombreUsuario, password, botonSeleccionado);

                    // Verificar si el usuario tiene permiso para la sección seleccionada
                    if (usuario != null) {
                        boolean accesoPermitido = false;
                        switch (botonSeleccionado) {
                            case "Recepcionista":
                                if (usuario.getTipoDeUsuario() == TipoDeUsuario.Recepcionista || usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador) {
                                    accesoPermitido = true;
                                }
                                break;
                            case "Laboratorista":
                                if (usuario.getTipoDeUsuario() == TipoDeUsuario.Laboratorista || usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador) {
                                    accesoPermitido = true;
                                }
                                break;
                            case "Administrador":
                                if (usuario.getTipoDeUsuario() == TipoDeUsuario.Administrador) {
                                    accesoPermitido = true;
                                }
                                break;
                            default:
                                throw new IllegalArgumentException("El rol especificado no es válido.");
                        }

                        // Mostrar el mensaje de inicio de sesión exitoso y cerrar la ventana solo si el acceso es permitido
                        if (accesoPermitido) {
                            JOptionPane.showMessageDialog(null, "Inicio de sesión exitoso", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                            dispose();

                            // Abrir la ventana correspondiente según el tipo de usuario
                            switch (botonSeleccionado) {
                                case "Recepcionista":
                                    FrmRecepcionista frmRecepcionista = new FrmRecepcionista(null, "Recepcionista");
                                    frmRecepcionista.setVisible(true);
                                    break;
                                case "Laboratorista":
                                    FrmLaboratorista frmLaboratorista = new FrmLaboratorista(null, "Laboratorista");
                                    frmLaboratorista.setVisible(true);
                                    break;
                                case "Administrador":
                                    FrmAdministrador frmAdministrador = new FrmAdministrador(null, "Administrador");
                                    frmAdministrador.setVisible(true);
                                    break;
                            }
                        } else {
                            throw new IllegalArgumentException("No tienes permiso para acceder a esta sección.");
                        }
                    }
                } catch (UsuarioService.InvalidPasswordException ex) {
                    JOptionPane.showMessageDialog(null, "La contraseña no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (UsuarioService.UserNotFoundException ex) {
                    JOptionPane.showMessageDialog(null, "El nombre de usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmIniciarSesion(botonSeleccionado).setVisible(true);
            }
        });
    }
}
