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
    //txt y btn Usuario
    private JTextField txtNombreUsuario, txtMailUsuario, txtPassword, txtNombre, txtDomicilio, txtDni, txtFechaNacimiento;
    private JButton btnAltaUsuario, btnBajaUsuario, btnModificarUsuario;

    //txt y btn Sucursal
    private JTextField txtNumeroSucursal, txtDireccion, txtResponsableTecnico, txtNumeroSucursalBaja, txtNumeroSucursalDestionPeticiones;
    private JButton btnAltaSucursal, btnBajaSucursal, btnModificarSucursal;

    //txt y btn Practica
    private JTextField txtCodigoPractica, txtNombrePractica, txtGrupo, txtMinValor, txtMaxValor, txtUmbral, txtCantHoras, txtHabilitada;
    private JButton btnAltaPractica, btnBajaPractica, btnModificarPractica;

    private AdministradorController adminController;

    public AdministradorView() {
        adminController = AdministradorController.getInstance();
        setTitle("Administrador");
        setSize(1300, 1200);
        setLayout(null);

        //USUARIO
        JLabel lblUsuario = new JLabel("USUARIO");
        lblUsuario.setBounds(200, 50, 200, 30);
        add(lblUsuario);

        JLabel lblNombreUsuario = new JLabel("Nombre Usuario:");
        lblNombreUsuario.setBounds(100, 100, 150, 30);
        add(lblNombreUsuario);
        txtNombreUsuario = new JTextField();
        txtNombreUsuario.setBounds(220, 100, 200, 30);
        add(txtNombreUsuario);
        JLabel lblMailUsuario = new JLabel("Mail Usuario:");
        lblMailUsuario.setBounds(100, 125, 150, 30);
        add(lblMailUsuario);
        txtMailUsuario = new JTextField();
        txtMailUsuario.setBounds(220, 125, 200, 30);
        add(txtMailUsuario);
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(100, 150, 150, 30);
        add(lblPassword);
        txtPassword = new JTextField();
        txtPassword.setBounds(220, 150, 200, 30);
        add(txtPassword);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(100, 175, 150, 30);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(220, 175, 200, 30);
        add(txtNombre);
        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(100, 200, 150, 30);
        add(lblDomicilio);
        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(220, 200, 200, 30);
        add(txtDomicilio);
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(100, 225, 150, 30);
        add(lblDNI);
        txtDni = new JTextField();
        txtDni.setBounds(220, 225, 200, 30);
        add(txtDni);
        JLabel lblFechaNacimiento = new JLabel("Fecha Nacimiento:");
        lblFechaNacimiento.setBounds(100, 250, 150, 30);
        add(lblFechaNacimiento);
        txtFechaNacimiento = new JTextField();
        txtFechaNacimiento.setBounds(220, 250, 200, 30);
        add(txtFechaNacimiento);

        btnAltaUsuario = new JButton("Dar Alta Usuario");
        btnAltaUsuario.setBounds(150, 400, 200, 30);
        add(btnAltaUsuario);
        btnModificarUsuario = new JButton("Modificar Usuario");
        btnModificarUsuario.setBounds(150, 425, 200, 30);
        add(btnModificarUsuario);
        btnBajaUsuario = new JButton("Dar Baja Usuario");
        btnBajaUsuario.setBounds(150, 450, 200, 30);
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


        //SUCURSAL
        JLabel lblSucursal = new JLabel("SUCURSAL");
        lblSucursal.setBounds(600, 50, 200, 30);
        add(lblSucursal);

        JLabel lblNumeroSucursal = new JLabel("Numero Sucursal:");
        lblNumeroSucursal.setBounds(500, 100, 150, 30);
        add(lblNumeroSucursal);
        txtNumeroSucursal = new JTextField();
        txtNumeroSucursal.setBounds(650, 100, 200, 30);
        add(txtNumeroSucursal);
        JLabel lblDireccion = new JLabel("Direccion:");
        lblDireccion.setBounds(500, 125, 150, 30);
        add(lblDireccion);
        txtDireccion = new JTextField();
        txtDireccion.setBounds(650, 125, 200, 30);
        add(txtDireccion);
        JLabel lblResponsableTecnico = new JLabel("Responsable Tecnico:");
        lblResponsableTecnico.setBounds(500, 150, 150, 30);
        add(lblResponsableTecnico);
        txtResponsableTecnico = new JTextField();
        txtResponsableTecnico.setBounds(650, 150, 200, 30);
        add(txtResponsableTecnico);

        btnAltaSucursal = new JButton("Dar Alta Sucursal");
        btnAltaSucursal.setBounds(550, 400, 200, 30);
        add(btnAltaSucursal);
        btnModificarSucursal = new JButton("Modificar Sucursal");
        btnModificarSucursal.setBounds(550, 425, 200, 30);
        add(btnModificarSucursal);
        JLabel lblNumeroSucursalBaja = new JLabel("Numero Sucursal Baja:");
        lblNumeroSucursalBaja.setBounds(580, 475, 200, 30);
        add(lblNumeroSucursalBaja);
        txtNumeroSucursalBaja = new JTextField();
        txtNumeroSucursalBaja.setBounds(550, 500, 200, 30);
        add(txtNumeroSucursalBaja);
        JLabel lblNumeroSucursalDestionPeticiones = new JLabel("Numero Sucursal Destion Peticiones:");
        lblNumeroSucursalDestionPeticiones.setBounds(535, 525, 250, 30);
        add(lblNumeroSucursalDestionPeticiones);
        txtNumeroSucursalDestionPeticiones = new JTextField();
        txtNumeroSucursalDestionPeticiones.setBounds(550, 550, 200, 30);
        add(txtNumeroSucursalDestionPeticiones);
        btnBajaSucursal = new JButton("Dar Baja Sucursal");
        btnBajaSucursal.setBounds(550, 575, 200, 30);
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

        //PRACTICA
        JLabel lblPractica = new JLabel("PRACTICA");
        lblPractica.setBounds(1000, 50, 200, 30);
        add(lblPractica);

        JLabel lblCodigoPractica = new JLabel("Codigo Practica:");
        lblCodigoPractica.setBounds(900, 100, 150, 30);
        add(lblCodigoPractica);
        txtCodigoPractica = new JTextField();
        txtCodigoPractica.setBounds(1020, 100, 200, 30);
        add(txtCodigoPractica);
        JLabel lblNombrePractica = new JLabel("Nombre Practica:");
        lblNombrePractica.setBounds(900, 125, 150, 30);
        add(lblNombrePractica);
        txtNombrePractica = new JTextField();
        txtNombrePractica.setBounds(1020, 125, 200, 30);
        add(txtNombrePractica);
        JLabel lblGrupo = new JLabel("Grupo:");
        lblGrupo.setBounds(900, 150, 100, 30);
        add(lblGrupo);
        txtGrupo = new JTextField();
        txtGrupo.setBounds(1020, 150, 200, 30);
        add(txtGrupo);
        JLabel lblMinValor = new JLabel("Min Valor:");
        lblMinValor.setBounds(900, 175, 100, 30);
        add(lblMinValor);
        txtMinValor = new JTextField();
        txtMinValor.setBounds(1020, 175, 200, 30);
        add(txtMinValor);
        JLabel lblMaxValor = new JLabel("Max Valor:");
        lblMaxValor.setBounds(900, 200, 100, 30);
        add(lblMaxValor);
        txtMaxValor = new JTextField();
        txtMaxValor.setBounds(1020, 200, 200, 30);
        add(txtMaxValor);
        JLabel lblUmbral = new JLabel("Umbral:");
        lblUmbral.setBounds(900, 225, 100, 30);
        add(lblUmbral);
        txtUmbral = new JTextField();
        txtUmbral.setBounds(1020, 225, 200, 30);
        add(txtUmbral);
        JLabel lblCantHoras = new JLabel("Cant Horas:");
        lblCantHoras.setBounds(900, 250, 100, 30);
        add(lblCantHoras);
        txtCantHoras = new JTextField();
        txtCantHoras.setBounds(1020, 250, 200, 30);
        add(txtCantHoras);
        JLabel lblHabilitada = new JLabel("Habilitada:");
        lblHabilitada.setBounds(900, 275, 100, 30);
        add(lblHabilitada);
        txtHabilitada = new JTextField();
        txtHabilitada.setBounds(1020, 275, 200, 30);
        add(txtHabilitada);

        btnAltaPractica = new JButton("Dar Alta Práctica");
        btnAltaPractica.setBounds(950, 400, 200, 30);
        add(btnAltaPractica);
        btnModificarPractica = new JButton("Modificar Práctica");
        btnModificarPractica.setBounds(950, 425, 200, 30);
        add(btnModificarPractica);
        btnBajaPractica = new JButton("Dar Baja Práctica");
        btnBajaPractica.setBounds(950, 450, 200, 30);
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