package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import controller.RecepcionController;
import Dtos.PacienteDTO;
import Dtos.PeticionDTO;
import Dtos.ResultadoDTO;
import model.Practica;
import model.RangoValor;

public class RecepcionView extends JFrame {
    private JTextField txtNombre, txtDNI, txtDomicilio, txtEmail, txtSexo, txtEdad;
    private JTextField txtPeticionId, txtObraSocial, txtSucursalId, txtPracticaId, txtResultadoIdPeticion, txtResultadoIdPractica;
    private JButton btnGuardar, btnListar, btnCargarPeticion, btnModificarPeticion, btnDarBajaPeticion, btnConsultarResultados;
    private JButton btnRecibirPaciente, btnDarAltaPaciente, btnModificarPaciente, btnDarBajaPaciente, btnListarPeticionesCriticas;
    private JTextField txtDarBajaPaciente, txtPaciente, txtFechaCarga, txtFechaCalculadaEntrega, txtSucursal;
    private RecepcionController recepcionController;
    private JComboBox<String> practicaComboBox;


    public RecepcionView() {
        recepcionController = RecepcionController.getInstance();
        setTitle("Recepcionista");
        setSize(1000, 800);
        setLayout(null);

        // Campos para cargar un paciente nuevo
        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(50, 50, 100, 30);
        add(lblDNI);
        txtDNI = new JTextField();
        txtDNI.setBounds(150, 50, 200, 30);
        add(txtDNI);
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 75, 100, 30);
        add(lblNombre);
        txtNombre = new JTextField();
        txtNombre.setBounds(150, 75, 200, 30);
        add(txtNombre);
        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(50, 100, 100, 30);
        add(lblDomicilio);
        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(150, 100, 200, 30);
        add(txtDomicilio);
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 125, 100, 30);
        add(lblEmail);
        txtEmail = new JTextField();
        txtEmail.setBounds(150, 125, 200, 30);
        add(txtEmail);
        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 150, 100, 30);
        add(lblSexo);
        txtSexo = new JTextField();
        txtSexo.setBounds(150, 150, 200, 30);
        add(txtSexo);
        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 175, 100, 30);
        add(lblEdad);
        txtEdad = new JTextField();
        txtEdad.setBounds(150, 175, 200, 30);
        add(txtEdad);

        //botones que catita tdv no entendio que hacen
        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(100, 225, 150, 30);
        add(btnGuardar);
        btnListar = new JButton("Listar");
        btnListar.setBounds(100, 250, 150, 30);
        add(btnListar);

        //botones de paciente
        btnRecibirPaciente = new JButton("Recibir Paciente");
        btnRecibirPaciente.setBounds(100, 275, 150, 30);
        add(btnRecibirPaciente);
        btnDarAltaPaciente = new JButton("Dar Alta Paciente");
        btnDarAltaPaciente.setBounds(100, 300, 150, 30);
        add(btnDarAltaPaciente);
        btnModificarPaciente = new JButton("Modificar Paciente");
        btnModificarPaciente.setBounds(100, 325, 150, 30);
        add(btnModificarPaciente);
        JLabel lblDarBajaPaciente = new JLabel("DNI Paciente a dar de baja:");
        lblDarBajaPaciente.setBounds(100, 350, 200, 30);
        add(lblDarBajaPaciente);
        txtDarBajaPaciente = new JTextField();
        txtDarBajaPaciente.setBounds(100, 375, 200, 30);
        add(txtDarBajaPaciente);
        btnDarBajaPaciente = new JButton("Dar Baja Paciente");
        btnDarBajaPaciente.setBounds(100, 400, 150, 30);
        add(btnDarBajaPaciente);

        // Campos para gestionar peticiones
        JLabel lblPeticionId = new JLabel("ID Petición:");
        lblPeticionId.setBounds(400, 50, 100, 30);
        add(lblPeticionId);
        txtPeticionId = new JTextField();
        txtPeticionId.setBounds(500, 50, 200, 30);
        add(txtPeticionId);
        JLabel lblObraSocial = new JLabel("Obra Social:");
        lblObraSocial.setBounds(400, 75, 100, 30);
        add(lblObraSocial);
        txtObraSocial = new JTextField();
        txtObraSocial.setBounds(500, 75, 200, 30);
        add(txtObraSocial);
        JLabel lblSucursalId = new JLabel("ID Sucursal:");
        lblSucursalId.setBounds(400, 100, 100, 30);
        add(lblSucursalId);
        txtSucursalId = new JTextField();
        txtSucursalId.setBounds(500, 100, 200, 30);
        add(txtSucursalId);
        JLabel lblPaciente = new JLabel("Paciente:");
        lblPaciente.setBounds(400, 125, 100, 30);
        add(lblPaciente);
        txtPaciente = new JTextField();
        txtPaciente.setBounds(500, 125, 200, 30);
        add(txtPaciente);
        JLabel lblFechaCarga = new JLabel("FechaCarga:");
        lblFechaCarga.setBounds(400, 150, 100, 30);
        add(lblFechaCarga);
        txtFechaCarga = new JTextField();
        txtFechaCarga.setBounds(500, 150, 200, 30);
        add(txtFechaCarga);
        JLabel lblFechaCalculadaEntrega = new JLabel("Fecha Calculada Entrega:");
        lblFechaCalculadaEntrega.setBounds(400, 175, 100, 30);
        add(lblFechaCalculadaEntrega);
        txtFechaCalculadaEntrega = new JTextField();
        txtFechaCalculadaEntrega.setBounds(500, 175, 200, 30);
        add(txtFechaCalculadaEntrega);
        JLabel lblSucursal = new JLabel("Sucursal:");
        lblSucursal.setBounds(400, 200, 100, 30);
        add(lblSucursal);
        txtSucursal = new JTextField();
        txtSucursal.setBounds(500, 200, 200, 30);
        add(txtSucursal);
        JLabel lblPracticaId = new JLabel("Prácticas:");
        lblPracticaId.setBounds(400, 225, 100, 30);
        add(lblPracticaId);
        //esto es una picklist de practicas!!!!!
//        practicaComboBox = new JComboBox<>();
//        for (Practica practica : harcodedPracticas) {
//            practicaComboBox.addItem(practica.getNombrePractica());
//        }
//        add(practicaComboBox);


        btnCargarPeticion = new JButton("Cargar Petición");
        btnCargarPeticion.setBounds(500, 275, 150, 30);
        add(btnCargarPeticion);
        btnModificarPeticion = new JButton("Modificar Petición");
        btnModificarPeticion.setBounds(500, 300, 150, 30);
        add(btnModificarPeticion);
        btnDarBajaPeticion = new JButton("Dar Baja Petición");
        btnDarBajaPeticion.setBounds(500, 325, 150, 30);
        add(btnDarBajaPeticion);
        btnConsultarResultados = new JButton("Consultar Resultados Peticion");
        btnConsultarResultados.setBounds(500, 375, 220, 30);
        add(btnConsultarResultados);
        JLabel lblResultadoIdPeticion = new JLabel("ID Petición a consultar:");
        lblResultadoIdPeticion.setBounds(400, 350, 160, 30);
        add(lblResultadoIdPeticion);
        txtResultadoIdPeticion = new JTextField();
        txtResultadoIdPeticion.setBounds(545, 350, 150, 30);
        add(txtResultadoIdPeticion);
        btnListarPeticionesCriticas = new JButton("Listar Peticiones Criticas");
        btnListarPeticionesCriticas.setBounds(500, 400, 180, 30);
        add(btnListarPeticionesCriticas);

        /*JLabel lblResultadoIdPractica = new JLabel("ID Práctica:");
        lblResultadoIdPractica.setBounds(400, 400, 100, 30);
        add(lblResultadoIdPractica);

        txtResultadoIdPractica = new JTextField();
        txtResultadoIdPractica.setBounds(500, 400, 200, 30);
        add(txtResultadoIdPractica);*/

        // Acciones de los botones
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPaciente();
            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listarPacientes();
            }
        });

        btnCargarPeticion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarPeticion();
            }
        });

        btnModificarPeticion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarPeticion();
            }
        });

        btnDarBajaPeticion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarPeticion();
            }
        });

        btnConsultarResultados.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                consultarResultados();
            }
        });

        setVisible(true);
    }

    private void guardarPaciente() {
        String nombre = txtNombre.getText();
        int dni = Integer.parseInt(txtDNI.getText());
        String domicilio = txtDomicilio.getText();
        String email = txtEmail.getText();
        String sexo = txtSexo.getText();
        int edad = Integer.parseInt(txtEdad.getText());

        PacienteDTO pacienteDTO = new PacienteDTO(nombre, dni, domicilio, email, sexo, edad, new ArrayList<>());
        recepcionController.darAltaPaciente(pacienteDTO);
        JOptionPane.showMessageDialog(this, "Paciente guardado exitosamente");
    }

    private void listarPacientes() {
        List<PacienteDTO> pacientes = recepcionController.getPacientes();
        String[] columnNames = {"Nombre", "DNI", "Domicilio", "Email", "Sexo", "Edad"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (PacienteDTO paciente : pacientes) {
            Object[] row = {
                    paciente.getNombre(),
                    paciente.getDni(),
                    paciente.getDomicilio(),
                    paciente.getMail(),
                    paciente.getSexo(),
                    paciente.getEdad()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 400, 500, 150);
        add(scrollPane);
    }

    private void cargarPeticion() {
        int dni = Integer.parseInt(txtDNI.getText());
        String obraSocial = txtObraSocial.getText();
        int sucursalId = Integer.parseInt(txtSucursalId.getText());

        recepcionController.cargarPeticion(dni, obraSocial, sucursalId);
        JOptionPane.showMessageDialog(this, "Petición cargada exitosamente");
    }

    private void modificarPeticion() {
        int peticionId = Integer.parseInt(txtPeticionId.getText());
        recepcionController.modificarPeticion(peticionId);
        JOptionPane.showMessageDialog(this, "Petición modificada exitosamente");
    }

    private void eliminarPeticion() {
        int peticionId = Integer.parseInt(txtPeticionId.getText());
        recepcionController.darBajaPeticion(peticionId);
        JOptionPane.showMessageDialog(this, "Petición eliminada exitosamente");
    }

    private void consultarResultados() {
        int peticionId = Integer.parseInt(txtResultadoIdPeticion.getText());
        List<ResultadoDTO> resultados = recepcionController.solicitarResultados(peticionId);

        String[] columnNames = {"Valor", "ID Práctica", "Crítico", "Reservado"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (ResultadoDTO resultado : resultados) {
            Object[] row = {
                    resultado.getValor(),
                    resultado.getPracticaId(),
                    resultado.isValorCritico(),
                    resultado.isValorReservado()
            };
            model.addRow(row);
        }

        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 600, 900, 150);
        add(scrollPane);
    }

    public static void main(String[] args) {
        new RecepcionView();
    }
}
