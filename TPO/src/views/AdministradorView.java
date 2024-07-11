package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.AdministradorController;
import Dtos.SucursalDTO;
import Dtos.UsuarioDTO;
import Dtos.PracticaDTO;
import Dtos.RangoValorDTO;

public class AdministradorView extends JFrame {
    private JTextField txtNombreUsuario, txtMail, txtPassword, txtNombre, txtDomicilio, txtDni;
    private JButton btnAltaUsuario, btnBajaUsuario, btnModificarUsuario;

    private JTextField txtNumeroSucursal, txtDireccion;
    private JButton btnAltaSucursal, btnBajaSucursal, btnModificarSucursal;

    private JTextField txtCodigoPractica, txtNombrePractica, txtGrupo, txtMinValor, txtMaxValor, txtUmbral, txtCantHoras, txtHabilitada;
    private JButton btnAltaPractica, btnBajaPractica, btnModificarPractica;

    private AdministradorController adminController;

    public AdministradorView() {
        adminController = AdministradorController.getInstance();
        setTitle("Administrador");
        setSize(800, 600);
        setLayout(null);

        // Gestión de Usuarios
        JLabel lblUsuario = new JLabel("Gestión de Usuarios");
        lblUsuario.setBounds(50, 50, 200, 30);
        add(lblUsuario);

        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setBounds(150, 100, 200, 30);
        add(txtNombreUsuario);
        // Añadir más campos según sea necesario...

        btnAltaUsuario = new JButton("Dar Alta Usuario");
        btnAltaUsuario.setBounds(150, 200, 200, 30);
        add(btnAltaUsuario);
        btnModificarUsuario = new JButton("Modificar Usuario");
        btnModificarUsuario.setBounds(150, 225, 200, 30);
        add(btnModificarUsuario);
        btnBajaUsuario = new JButton("Dar Baja Usuario");
        btnBajaUsuario.setBounds(150, 250, 200, 30);
        add(btnBajaUsuario);

        btnAltaUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioDTO usuarioDTO = new UsuarioDTO();
                // Rellenar usuarioDTO con los datos de los campos
                adminController.darAltaUsuario(usuarioDTO);
                JOptionPane.showMessageDialog(null, "Usuario dado de alta exitosamente");
            }
        });

        // Gestión de Sucursales
//        JLabel lblSucursal = new JLabel("Gestión de Sucursales");
//        lblSucursal.setBounds(50, 250, 200, 30);
//        add(lblSucursal);
//
//        txtNumeroSucursal = new JTextField();
//        txtNumeroSucursal.setBounds(150, 300, 200, 30);
//        add(txtNumeroSucursal);
        // Añadir más campos según sea necesario...

        btnAltaSucursal = new JButton("Alta Sucursal");
        btnAltaSucursal.setBounds(150, 300, 200, 30);
        add(btnAltaSucursal);
        btnModificarSucursal = new JButton("Modificar Sucursal");
        btnModificarSucursal.setBounds(150, 325, 200, 30);
        add(btnModificarSucursal);
        btnBajaSucursal = new JButton("Baja Sucursal");
        btnBajaSucursal.setBounds(150, 350, 200, 30);
        add(btnBajaSucursal);

        btnAltaSucursal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SucursalDTO sucursalDTO = new SucursalDTO();
                // Rellenar sucursalDTO con los datos de los campos
                adminController.darDeAltaSucursal(sucursalDTO, new UsuarioDTO()); // Asumimos que se pasa un UsuarioDTO vacío
                JOptionPane.showMessageDialog(null, "Sucursal dada de alta exitosamente");
            }
        });


        //Practicas
        JLabel lblCodigoPractica = new JLabel("Codigo Practica:");
        lblCodigoPractica.setBounds(50, 530, 100, 30);
        add(lblCodigoPractica);
        txtCodigoPractica = new JTextField();
        txtCodigoPractica.setBounds(150, 530, 200, 30);
        add(txtCodigoPractica);
        JLabel lblNombrePractica = new JLabel("Nombre Practica:");
        lblNombrePractica.setBounds(50, 560, 100, 30);
        add(lblNombrePractica);
        txtNombrePractica = new JTextField();
        txtNombrePractica.setBounds(150, 560, 200, 30);
        add(txtNombrePractica);
        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setBounds(50, 590, 100, 30);
        add(lblGrupo);
        txtGrupo = new JTextField();
        txtGrupo.setBounds(150, 590, 200, 30);
        add(txtGrupo);
        JLabel lblMinValor = new JLabel("Min Valor:");
        lblMinValor.setBounds(50, 620, 100, 30);
        add(lblMinValor);
        txtMinValor = new JTextField();
        txtMinValor.setBounds(150, 620, 200, 30);
        add(txtMinValor);
        JLabel lblMaxValor = new JLabel("Max Valor:");
        lblMaxValor.setBounds(50, 650, 100, 30);
        add(lblMaxValor);
        txtMaxValor = new JTextField();
        txtMaxValor.setBounds(150, 650, 200, 30);
        add(txtMaxValor);
        JLabel lblUmbral = new JLabel("Umbral:");
        lblUmbral.setBounds(50, 680, 100, 30);
        add(lblUmbral);
        txtUmbral = new JTextField();
        txtUmbral.setBounds(150, 680, 200, 30);
        add(txtUmbral);
        JLabel lblCantHoras = new JLabel("Cant Horas:");
        lblCantHoras.setBounds(50, 710, 100, 30);
        add(lblCantHoras);
        txtCantHoras = new JTextField();
        txtCantHoras.setBounds(150, 710, 200, 30);
        add(txtCantHoras);

        txtHabilitada = new JTextField();
        txtHabilitada.setBounds(150, 710, 200, 30);
        add(txtHabilitada);

        btnAltaPractica = new JButton("Dar Alta Práctica");
        btnAltaPractica.setBounds(150, 740, 200, 30);
        add(btnAltaPractica);
        btnModificarPractica = new JButton("Modificar Práctica");
        btnModificarPractica.setBounds(150, 765, 200, 30);
        add(btnModificarPractica);
        btnBajaPractica = new JButton("Dar Baja Práctica");
        btnBajaPractica.setBounds(150, 790, 200, 30);
        add(btnBajaPractica);

        btnAltaPractica.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigoPractica = Integer.parseInt(txtCodigoPractica.getText());
                String nombrePractica = txtNombrePractica.getText();
                String grupo = txtGrupo.getText();
                float minValor = Float.parseFloat(txtMinValor.getText());
                float maxValor = Float.parseFloat(txtMaxValor.getText());
                float umbral = Float.parseFloat(txtUmbral.getText());
                float cantHorasResultados = Float.parseFloat(txtCantHoras.getText());
                boolean habilitada = Boolean.parseBoolean(txtHabilitada.getText());

                RangoValorDTO rangoValorDTO = new RangoValorDTO(minValor, maxValor, umbral);
                PracticaDTO practicaDTO = new PracticaDTO(codigoPractica, nombrePractica, grupo, rangoValorDTO, cantHorasResultados, habilitada);

                adminController.darAltaPractica(practicaDTO);
                JOptionPane.showMessageDialog(null, "Práctica dada de alta exitosamente");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new AdministradorView();
    }
}
