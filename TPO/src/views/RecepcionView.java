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

public class RecepcionView extends JFrame {
    private JTextField txtNombre, txtDNI, txtDomicilio, txtEmail, txtSexo, txtEdad;
    private JTextField txtPeticionId, txtObraSocial, txtSucursalId, txtPracticaId, txtResultadoIdPeticion, txtResultadoIdPractica;
    private JButton btnGuardar, btnListar, btnCargarPeticion, btnModificarPeticion, btnEliminarPeticion, btnConsultarResultados;
    private RecepcionController recepcionController;

    public RecepcionView() {
        recepcionController = RecepcionController.getInstance();
        setTitle("Gestionar Pacientes y Peticiones");
        setSize(1000, 800);
        setLayout(null);

        // Campos para gestionar pacientes
        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setBounds(50, 50, 100, 30);
        add(lblNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 50, 200, 30);
        add(txtNombre);

        JLabel lblDNI = new JLabel("DNI:");
        lblDNI.setBounds(50, 100, 100, 30);
        add(lblDNI);

        txtDNI = new JTextField();
        txtDNI.setBounds(150, 100, 200, 30);
        add(txtDNI);

        JLabel lblDomicilio = new JLabel("Domicilio:");
        lblDomicilio.setBounds(50, 150, 100, 30);
        add(lblDomicilio);

        txtDomicilio = new JTextField();
        txtDomicilio.setBounds(150, 150, 200, 30);
        add(txtDomicilio);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setBounds(50, 200, 100, 30);
        add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setBounds(150, 200, 200, 30);
        add(txtEmail);

        JLabel lblSexo = new JLabel("Sexo:");
        lblSexo.setBounds(50, 250, 100, 30);
        add(lblSexo);

        txtSexo = new JTextField();
        txtSexo.setBounds(150, 250, 200, 30);
        add(txtSexo);

        JLabel lblEdad = new JLabel("Edad:");
        lblEdad.setBounds(50, 300, 100, 30);
        add(lblEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 300, 200, 30);
        add(txtEdad);

        btnGuardar = new JButton("Guardar");
        btnGuardar.setBounds(50, 350, 150, 30);
        add(btnGuardar);

        btnListar = new JButton("Listar");
        btnListar.setBounds(200, 350, 150, 30);
        add(btnListar);

        // Campos para gestionar peticiones
        JLabel lblPeticionId = new JLabel("ID Petición:");
        lblPeticionId.setBounds(400, 50, 100, 30);
        add(lblPeticionId);

        txtPeticionId = new JTextField();
        txtPeticionId.setBounds(500, 50, 200, 30);
        add(txtPeticionId);

        JLabel lblObraSocial = new JLabel("Obra Social:");
        lblObraSocial.setBounds(400, 100, 100, 30);
        add(lblObraSocial);

        txtObraSocial = new JTextField();
        txtObraSocial.setBounds(500, 100, 200, 30);
        add(txtObraSocial);

        JLabel lblSucursalId = new JLabel("ID Sucursal:");
        lblSucursalId.setBounds(400, 150, 100, 30);
        add(lblSucursalId);

        txtSucursalId = new JTextField();
        txtSucursalId.setBounds(500, 150, 200, 30);
        add(txtSucursalId);

        JLabel lblPracticaId = new JLabel("ID Práctica:");
        lblPracticaId.setBounds(400, 200, 100, 30);
        add(lblPracticaId);

        txtPracticaId = new JTextField();
        txtPracticaId.setBounds(500, 200, 200, 30);
        add(txtPracticaId);

        btnCargarPeticion = new JButton("Cargar Petición");
        btnCargarPeticion.setBounds(400, 250, 150, 30);
        add(btnCargarPeticion);

        btnModificarPeticion = new JButton("Modificar Petición");
        btnModificarPeticion.setBounds(550, 250, 150, 30);
        add(btnModificarPeticion);

        btnEliminarPeticion = new JButton("Eliminar Petición");
        btnEliminarPeticion.setBounds(400, 300, 150, 30);
        add(btnEliminarPeticion);

        btnConsultarResultados = new JButton("Consultar Resultados");
        btnConsultarResultados.setBounds(550, 300, 150, 30);
        add(btnConsultarResultados);

        // Campos para consultar resultados
        JLabel lblResultadoIdPeticion = new JLabel("ID Petición:");
        lblResultadoIdPeticion.setBounds(400, 350, 100, 30);
        add(lblResultadoIdPeticion);

        txtResultadoIdPeticion = new JTextField();
        txtResultadoIdPeticion.setBounds(500, 350, 200, 30);
        add(txtResultadoIdPeticion);

        JLabel lblResultadoIdPractica = new JLabel("ID Práctica:");
        lblResultadoIdPractica.setBounds(400, 400, 100, 30);
        add(lblResultadoIdPractica);

        txtResultadoIdPractica = new JTextField();
        txtResultadoIdPractica.setBounds(500, 400, 200, 30);
        add(txtResultadoIdPractica);

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

        btnEliminarPeticion.addActionListener(new ActionListener() {
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
