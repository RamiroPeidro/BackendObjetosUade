package views;

import controller.RecepcionController;
import Dtos.PacienteDTO;
import Dtos.PeticionDTO;
import Dtos.ResultadoDTO;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.Formatter;
import java.util.List;

public class FrmRecepcionista extends JFrame {
    private JPanel pnlPacientes;
    private JPanel pnlPeticiones;
    private JPanel pnlResultados;
    private JTextField txtNombrePaciente;
    private JTextField txtDniPaciente;
    private JTextField txtDomicilioPaciente;
    private JTextField txtEmailPaciente;
    private JTextField txtSexoPaciente;
    private JTextField txtEdadPaciente;
    private JTextField txtIdPeticion;
    private JTextField txtDniPeticion;
    private JTextField txtObraSocialPeticion;
    private JTextField txtSucursalIdPeticion;
    private JTextField txtIdPeticionPractica;
    private JTextField txtPracticaId;
    private JTextField txtIdPeticionResultados;
    private JTextArea txtResultados;
    private RecepcionController recepcionController;

    public FrmRecepcionista(Window owner, String titulo) {
        super(titulo);
        recepcionController = RecepcionController.getInstance();

        // Inicializar componentes
        initComponents();

        // Configuración del JFrame
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        JTabbedPane tabbedPane = new JTabbedPane();

        pnlPacientes = new JPanel(new GridBagLayout());
        pnlPeticiones = new JPanel(new GridBagLayout());
        pnlResultados = new JPanel(new GridBagLayout());

        // Inicializar componentes de Pacientes, Peticiones y Resultados
        initPacientesComponents();
        initPeticionesComponents();
        initResultadosComponents();

        tabbedPane.addTab("Pacientes", pnlPacientes);
        tabbedPane.addTab("Peticiones", pnlPeticiones);
        tabbedPane.addTab("Resultados", pnlResultados);

        this.add(tabbedPane);
    }

    private void initPacientesComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlPacientes.add(new JLabel("Nombre:"), gbc);

        gbc.gridx = 1;
        txtNombrePaciente = new JTextField(10);
        pnlPacientes.add(txtNombrePaciente, gbc);

        gbc.gridx = 2;
        pnlPacientes.add(new JLabel("DNI:"), gbc);

        gbc.gridx = 3;
        txtDniPaciente = new JTextField(10);
        pnlPacientes.add(txtDniPaciente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlPacientes.add(new JLabel("Domicilio:"), gbc);

        gbc.gridx = 1;
        txtDomicilioPaciente = new JTextField(10);
        pnlPacientes.add(txtDomicilioPaciente, gbc);

        gbc.gridx = 2;
        pnlPacientes.add(new JLabel("Email:"), gbc);

        gbc.gridx = 3;
        txtEmailPaciente = new JTextField(10);
        pnlPacientes.add(txtEmailPaciente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlPacientes.add(new JLabel("Sexo:"), gbc);

        gbc.gridx = 1;
        txtSexoPaciente = new JTextField(10);
        pnlPacientes.add(txtSexoPaciente, gbc);

        gbc.gridx = 2;
        pnlPacientes.add(new JLabel("Edad:"), gbc);

        gbc.gridx = 3;
        txtEdadPaciente = new JTextField(10);
        pnlPacientes.add(txtEdadPaciente, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnAltaPaciente = new JButton("Dar de Alta Paciente");
        btnAltaPaciente.addActionListener(e -> altaPaciente());
        pnlPacientes.add(btnAltaPaciente, gbc);

        gbc.gridy = 4;
        JButton btnBajaPaciente = new JButton("Dar de Baja Paciente");
        btnBajaPaciente.addActionListener(e -> bajaPaciente());
        pnlPacientes.add(btnBajaPaciente, gbc);

        gbc.gridy = 5;
        JButton btnModificarPaciente = new JButton("Modificar Paciente");
        btnModificarPaciente.addActionListener(e -> modificarPaciente());
        pnlPacientes.add(btnModificarPaciente, gbc);
    }

    private void initPeticionesComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlPeticiones.add(new JLabel("ID Petición (para baja/modificación):"), gbc);

        gbc.gridx = 1;
        txtIdPeticion = new JTextField(10);
        pnlPeticiones.add(txtIdPeticion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        pnlPeticiones.add(new JLabel("DNI Paciente:"), gbc);

        gbc.gridx = 1;
        txtDniPeticion = new JTextField(10);
        pnlPeticiones.add(txtDniPeticion, gbc);

        gbc.gridx = 2;
        pnlPeticiones.add(new JLabel("Obra Social:"), gbc);

        gbc.gridx = 3;
        txtObraSocialPeticion = new JTextField(10);
        pnlPeticiones.add(txtObraSocialPeticion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        pnlPeticiones.add(new JLabel("ID Sucursal:"), gbc);

        gbc.gridx = 1;
        txtSucursalIdPeticion = new JTextField(10);
        pnlPeticiones.add(txtSucursalIdPeticion, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnAltaPeticion = new JButton("Dar de Alta Petición");
        btnAltaPeticion.addActionListener(e -> altaPeticion());
        pnlPeticiones.add(btnAltaPeticion, gbc);

        gbc.gridy = 4;
        JButton btnBajaPeticion = new JButton("Dar de Baja Petición");
        btnBajaPeticion.addActionListener(e -> bajaPeticion());
        pnlPeticiones.add(btnBajaPeticion, gbc);

        gbc.gridy = 5;
        JButton btnModificarPeticion = new JButton("Modificar Petición");
        btnModificarPeticion.addActionListener(e -> modificarPeticion());
        pnlPeticiones.add(btnModificarPeticion, gbc);

        gbc.gridy = 6;
        gbc.gridwidth = 1;
        pnlPeticiones.add(new JLabel("ID Petición:"), gbc);

        gbc.gridx = 1;
        txtIdPeticionPractica = new JTextField(10);
        pnlPeticiones.add(txtIdPeticionPractica, gbc);

        gbc.gridx = 2;
        pnlPeticiones.add(new JLabel("ID Práctica:"), gbc);

        gbc.gridx = 3;
        txtPracticaId = new JTextField(10);
        pnlPeticiones.add(txtPracticaId, gbc);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;
        JButton btnAsociarPractica = new JButton("Asociar Práctica a Petición");
        btnAsociarPractica.addActionListener(e -> asociarPracticaAPeticion());
        pnlPeticiones.add(btnAsociarPractica, gbc);
    }

    private void initResultadosComponents() {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlResultados.add(new JLabel("ID Petición:"), gbc);

        gbc.gridx = 1;
        txtIdPeticionResultados = new JTextField(10);
        pnlResultados.add(txtIdPeticionResultados, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        JButton btnSolicitarResultados = new JButton("Solicitar Resultados");
        btnSolicitarResultados.addActionListener(e -> solicitarResultados());
        pnlResultados.add(btnSolicitarResultados, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        txtResultados = new JTextArea(10, 50); // Cambiado el ancho de 30 a 50
        txtResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtResultados);
        pnlResultados.add(scrollPane, gbc);

        gbc.gridy = 3;
        gbc.gridwidth = 1;
        JButton btnListarPeticionesCriticas = new JButton("Listar Peticiones Críticas");
        btnListarPeticionesCriticas.addActionListener(e -> listarPeticionesCriticas());
        pnlResultados.add(btnListarPeticionesCriticas, gbc);
    }

    private void altaPaciente() {
        String nombre = txtNombrePaciente.getText().trim();
        String dniStr = txtDniPaciente.getText().trim();
        String domicilio = txtDomicilioPaciente.getText().trim();
        String email = txtEmailPaciente.getText().trim();
        String sexo = txtSexoPaciente.getText().trim();
        String edadStr = txtEdadPaciente.getText().trim();

        if (nombre.isEmpty() || dniStr.isEmpty() || domicilio.isEmpty() || email.isEmpty() || sexo.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);
            List<Integer> peticiones = new ArrayList<>();
            PacienteDTO pacienteDTO = new PacienteDTO(nombre, dni, domicilio, email, sexo, edad, peticiones);
            try {
                recepcionController.darAltaPaciente(pacienteDTO);
                JOptionPane.showMessageDialog(this, "Paciente dado de alta exitosamente.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI y Edad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void bajaPaciente() {
        String dniStr = txtDniPaciente.getText().trim();

        if (dniStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo DNI es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int dni = Integer.parseInt(dniStr);
            recepcionController.darBajaPaciente(dni);
            JOptionPane.showMessageDialog(this, "Paciente dado de baja exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarPaciente() {
        String nombre = txtNombrePaciente.getText().trim();
        String dniStr = txtDniPaciente.getText().trim();
        String domicilio = txtDomicilioPaciente.getText().trim();
        String email = txtEmailPaciente.getText().trim();
        String sexo = txtSexoPaciente.getText().trim();
        String edadStr = txtEdadPaciente.getText().trim();

        if (nombre.isEmpty() || dniStr.isEmpty() || domicilio.isEmpty() || email.isEmpty() || sexo.isEmpty() || edadStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int dni = Integer.parseInt(dniStr);
            int edad = Integer.parseInt(edadStr);
            List<Integer> peticiones = new ArrayList<>();
            PacienteDTO pacienteDTO = new PacienteDTO(nombre, dni, domicilio, email, sexo, edad, peticiones);
            recepcionController.modificarPaciente(pacienteDTO);
            JOptionPane.showMessageDialog(this, "Paciente modificado exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI y Edad deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void altaPeticion() {
        String idPeticionStr = txtIdPeticion.getText().trim(); // Verificar si se ingresó un ID
        String dniStr = txtDniPeticion.getText().trim();
        String obraSocial = txtObraSocialPeticion.getText().trim();
        String sucursalIdStr = txtSucursalIdPeticion.getText().trim();

        if (dniStr.isEmpty() || obraSocial.isEmpty() || sucursalIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!idPeticionStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Al dar de alta una petición, no debe completar el campo ID Petición, se autogenera.", "Error", JOptionPane.ERROR_MESSAGE);
            return; // Salir del método si se ingresó un ID
        }

        try {
            int dni = Integer.parseInt(dniStr);
            int sucursalId = Integer.parseInt(sucursalIdStr);
            int nuevoIdPeticion = recepcionController.cargarPeticion(dni, obraSocial, sucursalId);
            JOptionPane.showMessageDialog(this, "Petición dada de alta exitosamente. ID Petición: " + nuevoIdPeticion, "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "DNI y ID de Sucursal deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }


    private void bajaPeticion() {
        String idPeticionStr = txtIdPeticion.getText().trim();

        if (idPeticionStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID Petición es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idPeticion = Integer.parseInt(idPeticionStr);
            recepcionController.darBajaPeticion(idPeticion);
            JOptionPane.showMessageDialog(this, "Petición dada de baja exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Petición debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void modificarPeticion() {
        String idPeticionStr = txtIdPeticion.getText().trim();

        if (idPeticionStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID Petición es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idPeticion = Integer.parseInt(idPeticionStr);
            recepcionController.modificarPeticion(idPeticion);
            JOptionPane.showMessageDialog(this, "Petición modificada exitosamente.");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Petición debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void asociarPracticaAPeticion() {
        String idPeticionStr = txtIdPeticionPractica.getText().trim();
        String practicaIdStr = txtPracticaId.getText().trim();

        if (idPeticionStr.isEmpty() || practicaIdStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idPeticion = Integer.parseInt(idPeticionStr);
            int practicaId = Integer.parseInt(practicaIdStr);
            try {
                recepcionController.asociarPracticaAPeticion(idPeticion, practicaId);
                JOptionPane.showMessageDialog(this, "Práctica asociada a la petición exitosamente.");
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Petición y ID Práctica deben ser números válidos.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void solicitarResultados() {
        String idPeticionStr = txtIdPeticionResultados.getText().trim();

        if (idPeticionStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID Petición es obligatorio.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            int idPeticion = Integer.parseInt(idPeticionStr);
            List<ResultadoDTO> resultados = recepcionController.solicitarResultados(idPeticion);

            if (resultados.isEmpty()) {
                txtResultados.setText("No se encontraron resultados para la petición ID: " + idPeticion);
                return;
            }

            StringBuilder sb = new StringBuilder();
            ResultadoDTO primerResultado = resultados.get(0);

            sb.append("Paciente: ").append(primerResultado.getNombrePaciente()).append("\n");
            sb.append("Sexo: ").append(primerResultado.getSexoPaciente()).append("\n");
            sb.append("Edad: ").append(primerResultado.getEdadPaciente()).append("\n");
            sb.append("Mail: ").append(primerResultado.getMailPaciente()).append("\n\n");

            Formatter formatter = new Formatter(sb);
            formatter.format("%-20s %-20s %-20s\n", "Practica", "Resultado", "Rango Valores");
            formatter.format("%-20s %-20s %-20s\n", "--------------------", "--------------------", "--------------------");

            for (ResultadoDTO resultado : resultados) {
                formatter.format("%-20s %-20s %-20s\n",
                        resultado.getNombrePractica(),
                        resultado.getValor(),
                        resultado.getRangoValores());
            }

            txtResultados.setText(sb.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Petición debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void listarPeticionesCriticas() {
        List<PeticionDTO> peticionesCriticas = recepcionController.listarPeticionesCriticas();
        txtResultados.setText("");
        for (PeticionDTO peticion : peticionesCriticas) {
            txtResultados.append("Petición ID: " + peticion.getIdPeticion() + "\n");
        }
    }

    public static void main(String[] args) {
        RecepcionController.getInstance(); // Instanciar RecepcionController para cargar datos de prueba
        new FrmRecepcionista(null, "Recepcionista").setVisible(true);
    }
}
