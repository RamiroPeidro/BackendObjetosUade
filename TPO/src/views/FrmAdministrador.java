package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import Dtos.PracticaDTO;
import Dtos.RangoValorDTO;
import Dtos.UsuarioDTO;
import controller.AdministradorController;
import Dtos.SucursalDTO;

public class FrmAdministrador extends JFrame {
    private JPanel pnlSucursales;
    private JPanel pnlUsuarios;
    private JPanel pnlPracticas;

    private JTextField txtNumeroSucursal;
    private JTextField txtDireccionSucursal;
    private JTextField txtDniSucursal;

    private JTextField txtNombreUsuario;
    private JTextField txtMailUsuario;
    private JTextField txtPasswordUsuario;
    private JTextField txtNombre;
    private JTextField txtDomicilio;
    private JTextField txtDniUsuario;
    private JTextField txtFechaNacimiento;

    private JTextField txtCodigoPractica;
    private JTextField txtNombrePractica;
    private JTextField txtGrupoPractica;
    private JTextField txtMinValor;
    private JTextField txtMaxValor;
    private JTextField txtCantHorasResultados;
    private JCheckBox chkHabilitada;
    private JCheckBox chkReservada;

    private AdministradorController administradorController;

    public FrmAdministrador(Window owner, String titulo) {
        super(titulo);
        administradorController = AdministradorController.getInstance();

        // Inicializar componentes
        initComponents();

        // Configuración del JFrame
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();

        pnlSucursales = new JPanel(new GridBagLayout());
        pnlUsuarios = new JPanel(new GridBagLayout());
        pnlPracticas = new JPanel(new GridBagLayout());

        // Inicializar componentes de Sucursales, Usuarios y Prácticas
        initSucursalesComponents();
        initUsuariosComponents();
        initPracticasComponents();

        tabbedPane.addTab("Sucursales", pnlSucursales);
        tabbedPane.addTab("Usuarios", pnlUsuarios);
        tabbedPane.addTab("Prácticas", pnlPracticas);

        this.add(tabbedPane);
    }

    private void initSucursalesComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlSucursales.add(new JLabel("Número:"), gbc);

        gbc.gridx = 1;
        txtNumeroSucursal = new JTextField(10);
        pnlSucursales.add(txtNumeroSucursal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlSucursales.add(new JLabel("Dirección:"), gbc);

        gbc.gridx = 1;
        txtDireccionSucursal = new JTextField(10);
        pnlSucursales.add(txtDireccionSucursal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlSucursales.add(new JLabel("DNI Responsable Técnico:"), gbc);

        gbc.gridx = 1;
        txtDniSucursal = new JTextField(10);
        pnlSucursales.add(txtDniSucursal, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnAltaSucursal = new JButton("Dar de Alta Sucursal");
        btnAltaSucursal.addActionListener(e -> altaSucursal());
        pnlSucursales.add(btnAltaSucursal, gbc);

        gbc.gridy = 4;
        JButton btnBajaSucursal = new JButton("Dar de Baja Sucursal");
        btnBajaSucursal.addActionListener(e -> bajaSucursal());
        pnlSucursales.add(btnBajaSucursal, gbc);

        gbc.gridy = 5;
        JButton btnModificarSucursal = new JButton("Modificar Sucursal");
        btnModificarSucursal.addActionListener(e -> modificarSucursal());
        pnlSucursales.add(btnModificarSucursal, gbc);
    }

    private void initUsuariosComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlUsuarios.add(new JLabel("Nombre de Usuario:"), gbc);

        gbc.gridx = 1;
        txtNombreUsuario = new JTextField(10);
        pnlUsuarios.add(txtNombreUsuario, gbc);

        gbc.gridx = 2;
        pnlUsuarios.add(new JLabel("Mail:"), gbc);

        gbc.gridx = 3;
        txtMailUsuario = new JTextField(10);
        pnlUsuarios.add(txtMailUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlUsuarios.add(new JLabel("Password:"), gbc);

        gbc.gridx = 1;
        txtPasswordUsuario = new JTextField(10);
        pnlUsuarios.add(txtPasswordUsuario, gbc);

        gbc.gridx = 2;
        pnlUsuarios.add(new JLabel("Domicilio:"), gbc);

        gbc.gridx = 3;
        txtDomicilio = new JTextField(10);
        pnlUsuarios.add(txtDomicilio, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlUsuarios.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        txtNombre = new JTextField(10);
        pnlUsuarios.add(txtNombre, gbc);

        gbc.gridx = 2;
        pnlUsuarios.add(new JLabel("DNI:"), gbc);

        gbc.gridx = 3;
        txtDniUsuario = new JTextField(10);
        pnlUsuarios.add(txtDniUsuario, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlUsuarios.add(new JLabel("Fecha de Nacimiento (dd/MM/yyyy):"), gbc);

        gbc.gridx = 1;
        txtFechaNacimiento = new JTextField(10);
        pnlUsuarios.add(txtFechaNacimiento, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnAltaUsuario = new JButton("Dar de Alta Usuario");
        btnAltaUsuario.addActionListener(e -> altaUsuario());
        pnlUsuarios.add(btnAltaUsuario, gbc);

        gbc.gridy = 5;
        JButton btnBajaUsuario = new JButton("Dar de Baja Usuario");
        btnBajaUsuario.addActionListener(e -> bajaUsuario());
        pnlUsuarios.add(btnBajaUsuario, gbc);

        gbc.gridy = 6;
        JButton btnModificarUsuario = new JButton("Modificar Usuario");
        btnModificarUsuario.addActionListener(e -> modificarUsuario());
        pnlUsuarios.add(btnModificarUsuario, gbc);
    }

    private void initPracticasComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlPracticas.add(new JLabel("Código (solo para modificación y baja):"), gbc);

        gbc.gridx = 1;
        txtCodigoPractica = new JTextField(10);
        // No deshabilitamos el campo aquí, quedará habilitado para modificación y baja
        pnlPracticas.add(txtCodigoPractica, gbc);

        gbc.gridx = 2;
        pnlPracticas.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 3;
        txtNombrePractica = new JTextField(10);
        pnlPracticas.add(txtNombrePractica, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlPracticas.add(new JLabel("Grupo:"), gbc);

        gbc.gridx = 1;
        txtGrupoPractica = new JTextField(10);
        pnlPracticas.add(txtGrupoPractica, gbc);

        gbc.gridx = 2;
        pnlPracticas.add(new JLabel("Min Valor:"), gbc);

        gbc.gridx = 3;
        txtMinValor = new JTextField(10);
        pnlPracticas.add(txtMinValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlPracticas.add(new JLabel("Max Valor:"), gbc);

        gbc.gridx = 1;
        txtMaxValor = new JTextField(10);
        pnlPracticas.add(txtMaxValor, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        pnlPracticas.add(new JLabel("Cant Horas Resultados:"), gbc);

        gbc.gridx = 1;
        txtCantHorasResultados = new JTextField(10);
        pnlPracticas.add(txtCantHorasResultados, gbc);

        gbc.gridx = 2;
        gbc.gridy = 4;

        pnlPracticas.add(new JLabel("Habilitada:"), gbc);

        gbc.gridx = 3;
        gbc.gridy = 4;

        chkHabilitada = new JCheckBox();
        pnlPracticas.add(chkHabilitada, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        pnlPracticas.add(new JLabel("Con valores reservados:"), gbc);

        gbc.gridx = 1;
        chkReservada = new JCheckBox();
        pnlPracticas.add(chkReservada, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnAltaPractica = new JButton("Dar de Alta Practica");
        btnAltaPractica.addActionListener(e -> altaPractica());
        pnlPracticas.add(btnAltaPractica, gbc);

        gbc.gridy = 6;
        JButton btnBajaPractica = new JButton("Dar de Baja Practica");
        btnBajaPractica.addActionListener(e -> bajaPractica());
        pnlPracticas.add(btnBajaPractica, gbc);

        gbc.gridy = 7;
        JButton btnModificarPractica = new JButton("Modificar Practica");
        btnModificarPractica.addActionListener(e -> modificarPractica());
        pnlPracticas.add(btnModificarPractica, gbc);
    }




    private void altaSucursal() {
        try {
            int numero = Integer.parseInt(txtNumeroSucursal.getText().trim());
            String direccion = txtDireccionSucursal.getText().trim();
            int dniResponsableTecnico = Integer.parseInt(txtDniSucursal.getText().trim());

            if (direccion.isEmpty()) {
                throw new IllegalArgumentException("La dirección no puede estar vacía.");
            }

            SucursalDTO sucursalDTO = new SucursalDTO(numero, direccion, null, null);
            administradorController.darDeAltaSucursal(sucursalDTO, dniResponsableTecnico);
            JOptionPane.showMessageDialog(this, "Sucursal dada de alta exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos de número de sucursal y DNI deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta la sucursal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }



    private void bajaSucursal() {
        try {
            int numero = Integer.parseInt(txtNumeroSucursal.getText().trim());
            administradorController.darBajaSucursal(numero, 0); // Considera agregar campo para la sucursal destino de las peticiones
            JOptionPane.showMessageDialog(this, "Sucursal dada de baja exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo de número de sucursal debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja la sucursal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void modificarSucursal() {
        try {
            int numero = Integer.parseInt(txtNumeroSucursal.getText().trim());
            String direccion = txtDireccionSucursal.getText().trim();
            int dniResponsableTecnico = Integer.parseInt(txtDniSucursal.getText().trim());

            if (direccion.isEmpty()) {
                throw new IllegalArgumentException("La dirección no puede estar vacía.");
            }

            SucursalDTO sucursalDTO = new SucursalDTO(numero, direccion, null, null);
            administradorController.modificarSucursal(sucursalDTO, dniResponsableTecnico);
            JOptionPane.showMessageDialog(this, "Sucursal modificada exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos de número de sucursal y DNI deben ser numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar la sucursal: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void altaUsuario() {
        try {
            String nombreUsuario = txtNombreUsuario.getText().trim();
            String mail = txtMailUsuario.getText().trim();
            String password = txtPasswordUsuario.getText().trim();
            String nombre = txtNombre.getText().trim();
            String domicilio = txtDomicilio.getText().trim();
            int dni = Integer.parseInt(txtDniUsuario.getText().trim());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNacimiento = sdf.parse(txtFechaNacimiento.getText().trim());

            if (nombreUsuario.isEmpty() || mail.isEmpty() || password.isEmpty() || nombre.isEmpty() || domicilio.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos deben estar completos.");
            }

            UsuarioDTO usuarioDTO = new UsuarioDTO(nombreUsuario, mail, password, nombre, domicilio, dni, fechaNacimiento);
            administradorController.darAltaUsuario(usuarioDTO);
            JOptionPane.showMessageDialog(this, "Usuario dado de alta exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo DNI debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe estar en el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void bajaUsuario() {
        try {
            int dni = Integer.parseInt(txtDniUsuario.getText().trim());
            administradorController.darBajaUsuario(dni);
            JOptionPane.showMessageDialog(this, "Usuario dado de baja exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo DNI debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void modificarUsuario() {
        try {
            String nombreUsuario = txtNombreUsuario.getText().trim();
            String mail = txtMailUsuario.getText().trim();
            String password = txtPasswordUsuario.getText().trim();
            String nombre = txtNombre.getText().trim();
            String domicilio = txtDomicilio.getText().trim();
            int dni = Integer.parseInt(txtDniUsuario.getText().trim());
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaNacimiento = sdf.parse(txtFechaNacimiento.getText().trim());

            if (nombreUsuario.isEmpty() || mail.isEmpty() || password.isEmpty() || nombre.isEmpty() || domicilio.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos deben estar completos.");
            }

            UsuarioDTO usuarioDTO = new UsuarioDTO(nombreUsuario, mail, password, nombre, domicilio, dni, fechaNacimiento);
            administradorController.modificarUsuario(usuarioDTO);
            JOptionPane.showMessageDialog(this, "Usuario modificado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo DNI debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(this, "La fecha de nacimiento debe estar en el formato dd/MM/yyyy.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar el usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void altaPractica() {
        try {
            String codigoPracticaStr = txtCodigoPractica.getText().trim();
            if (!codigoPracticaStr.isEmpty()) {
                throw new IllegalArgumentException("No se debe completar el campo código de práctica en un alta ya que se autogenera.");
            }

            String nombre = txtNombrePractica.getText().trim();
            String grupo = txtGrupoPractica.getText().trim();
            float minValor = Float.parseFloat(txtMinValor.getText().trim());
            float maxValor = Float.parseFloat(txtMaxValor.getText().trim());
            float cantHorasResultados = Float.parseFloat(txtCantHorasResultados.getText().trim());
            boolean habilitada = chkHabilitada.isSelected();
            boolean reservada = chkReservada.isSelected();

            if (nombre.isEmpty() || grupo.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos deben estar completos.");
            }

            RangoValorDTO rangoValorDTO = new RangoValorDTO(minValor, maxValor);
            PracticaDTO practicaDTO = new PracticaDTO(0, nombre, grupo, rangoValorDTO, cantHorasResultados, habilitada, reservada); // 0 para que se genere automáticamente
            int codigoGenerado = administradorController.darAltaPractica(practicaDTO);
            JOptionPane.showMessageDialog(this, "Práctica dada de alta exitosamente. Código generado: " + codigoGenerado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos numéricos deben contener valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de alta la práctica: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }





    private void bajaPractica() {
        try {
            int codigo = Integer.parseInt(txtCodigoPractica.getText().trim());
            administradorController.darBajaPractica(codigo);
            JOptionPane.showMessageDialog(this, "Práctica dada de baja exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo código debe ser numérico.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al dar de baja la práctica: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarPractica() {
        try {
            int codigo = Integer.parseInt(txtCodigoPractica.getText().trim());
            String nombre = txtNombrePractica.getText().trim();
            String grupo = txtGrupoPractica.getText().trim();
            float minValor = Float.parseFloat(txtMinValor.getText().trim());
            float maxValor = Float.parseFloat(txtMaxValor.getText().trim());
            float cantHorasResultados = Float.parseFloat(txtCantHorasResultados.getText().trim());
            boolean habilitada = chkHabilitada.isSelected();
            boolean reservada = chkReservada.isSelected();

            if (nombre.isEmpty() || grupo.isEmpty()) {
                throw new IllegalArgumentException("Todos los campos deben estar completos.");
            }

            RangoValorDTO rangoValorDTO = new RangoValorDTO(minValor, maxValor);
            PracticaDTO practicaDTO = new PracticaDTO(codigo, nombre, grupo, rangoValorDTO, cantHorasResultados, habilitada, reservada);
            administradorController.modificarPractica(practicaDTO);
            JOptionPane.showMessageDialog(this, "Práctica modificada exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Los campos numéricos deben contener valores válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error al modificar la práctica: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    public static void main(String[] args) {
        AdministradorController.getInstance(); // Instanciar AdministradorController para cargar datos de prueba
        new FrmAdministrador(null, "Administrador").setVisible(true);
    }
}
