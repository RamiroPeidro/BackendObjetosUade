package views;

import controller.AdministradorController;
import service.UsuarioService;

import javax.swing.*;
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

        // Add the panel to the frame
        add(panel);

        // Add action listener to the button
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombreUsuario = userText.getText();
                String password = new String(passwordText.getPassword());
                try{
                    administradorController.iniciarSesion(nombreUsuario,password,botonSeleccionado);
                }
                catch (UsuarioService.InvalidPasswordException ex){
                    JOptionPane.showMessageDialog(null, "La contraseña no es correcta", "Error", JOptionPane.ERROR_MESSAGE);
                }
                catch (UsuarioService.UserNotFoundException ex){
                    JOptionPane.showMessageDialog(null, "El nombre de usuario no existe", "Error", JOptionPane.ERROR_MESSAGE);

                }

            }
        });
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmIniciarSesion().setVisible(true);
            }
        });
    }*/
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmIniciarSesion(botonSeleccionado).setVisible(true);
            }
        });
    }

    /*public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Aquí deberías pasar una instancia válida de AdministradorController
            new FrmIniciarSesion(AdministradorController.getInstance()).setVisible(true);
        });
    }*/


}
