package views;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import controller.RecepcionController;
import Dtos.PacienteDTO;
import Dtos.PeticionDTO;
import Dtos.ResultadoDTO;
import model.Practica;
import datos.PracticaManager;

public class RecepcionView extends JFrame {

    //txt y btn Paciente
    private JTextField txtNombre, txtDNI, txtDomicilio, txtEmail, txtSexo, txtEdad, txtDarBajaPaciente;
    private JButton btnDarAltaPaciente, btnModificarPaciente, btnDarBajaPaciente, btnListarPeticionesCriticas;

    //txt y btn Peticion
    private JTextField txtPeticionId, txtObraSocial, txtSucursalId, txtIDPeticionAConsultar, txtDNIPaciente, txtFechaCarga, txtSucursal;
    private JButton btnCargarPeticion, btnModificarPeticion, btnDarBajaPeticion, btnConsultarResultados;
    private JList<String> practicaList;

    private RecepcionController recepcionController;

    public RecepcionView() {
        recepcionController = RecepcionController.getInstance();
        setTitle("Recepcionista");
        setSize(800, 800);
        setLayout(null);


        initComponents();

        // Acciones de los botones
        btnCargarPeticion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //cargarPeticion();
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
                solicitarResultados();
            }
        });

        setVisible(true);
    }

    private void initComponents() {

        JLabel lblTituloPaciente = new JLabel("PACIENTE");
        lblTituloPaciente.setBounds(140, 15, 200, 30);
        add(lblTituloPaciente);

        addLabelAndTextField("DNI:", 50, 50, txtDNI = new JTextField());
        addLabelAndTextField("Nombre:", 50, 75, txtNombre = new JTextField());
        addLabelAndTextField("Domicilio:", 50, 100, txtDomicilio = new JTextField());
        addLabelAndTextField("Email:", 50, 125, txtEmail = new JTextField());
        addLabelAndTextField("Sexo:", 50, 150, txtSexo = new JTextField());
        addLabelAndTextField("Edad:", 50, 175, txtEdad = new JTextField());

        btnDarAltaPaciente = addButton("Dar Alta Paciente", 100, 250);
        btnModificarPaciente = addButton("Modificar Paciente", 100, 275);

        JLabel lblDarBajaPaciente = new JLabel("DNI Paciente a dar de baja:");
        lblDarBajaPaciente.setBounds(95, 320, 200, 30);
        add(lblDarBajaPaciente);
        txtDarBajaPaciente = new JTextField();
        txtDarBajaPaciente.setBounds(100, 350, 150, 30);
        add(txtDarBajaPaciente);
        btnDarBajaPaciente = addButton("Dar Baja Paciente", 100, 375);


        JLabel lblTituloPeticion = new JLabel("PETICION");
        lblTituloPeticion.setBounds(520, 15, 200, 30);
        add(lblTituloPeticion);

//        addLabelAndTextField("ID Petición:", 400, 50, txtPeticionId = new JTextField());
        addLabelAndTextField("Obra Social:", 400, 75, txtObraSocial = new JTextField());
        addLabelAndTextField("ID Sucursal:", 400, 100, txtSucursalId = new JTextField());
        addLabelAndTextField("DNI Paciente:", 400, 125, txtDNIPaciente = new JTextField());
        addLabelAndTextField("FechaCarga:", 400, 150, txtFechaCarga = new JTextField());
        JLabel lblPracticaId = new JLabel("Prácticas:");
        lblPracticaId.setBounds(400, 200, 100, 30);
        add(lblPracticaId);

        //picklist de prácticas
        List<Practica> practicas = PracticaManager.getHarcodedPracticas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Practica practica : practicas) {
            listModel.addElement(practica.getNombrePractica());
        }
        practicaList = new JList<>(listModel);
        practicaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(practicaList);
        scrollPane.setBounds(500, 205, 200, 100);
        add(scrollPane);

        btnCargarPeticion = addButton("Cargar Petición", 500, 325);
        btnModificarPeticion = addButton("Modificar Petición", 500, 350);
        btnDarBajaPeticion = addButton("Dar Baja Petición", 500, 375);

        JLabel lblResultadoIdPeticion = new JLabel("ID Petición a consultar:");
        lblResultadoIdPeticion.setBounds(500, 475, 160, 30);
        add(lblResultadoIdPeticion);
        txtIDPeticionAConsultar = new JTextField();
        txtIDPeticionAConsultar.setBounds(500, 500, 150, 30);
        add(txtIDPeticionAConsultar);
        btnConsultarResultados = addButton("Resultados Petición", 500, 525);


        btnListarPeticionesCriticas = addButton("Peticiones Criticas", 500, 600);
    }

    private JButton addButton(String text, int x, int y) {
        JButton button = new JButton(text);
        button.setBounds(x, y, 150, 30);
        add(button);
        return button;
    }

    private void addLabelAndTextField(String labelText, int x, int y, JTextField textField) {
        JLabel label = new JLabel(labelText);
        label.setBounds(x, y, 100, 30);
        add(label);
        textField.setBounds(x + 100, y, 200, 30);
        add(textField);
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


    /*private void cargarPeticion() {
        int dni = Integer.parseInt(txtDNI.getText());
        String obraSocial = txtObraSocial.getText();
        int sucursalId = Integer.parseInt(txtSucursalId.getText());

        // Obtener las prácticas seleccionadas
        List<String> selectedPracticas = practicaList.getSelectedValuesList();
        List<Practica> practicasSeleccionadas = new ArrayList<>();
        for (String practicaNombre : selectedPracticas) {
            practicasSeleccionadas.add(PracticaManager.getPracticaByName(practicaNombre));
        }

        recepcionController.cargarPeticion(dni, obraSocial, sucursalId, practicasSeleccionadas);
        JOptionPane.showMessageDialog(this, "Petición cargada exitosamente");
    }*/

    private void modificarPeticion () {
        int peticionId = Integer.parseInt(txtPeticionId.getText());
        recepcionController.modificarPeticion(peticionId);
        JOptionPane.showMessageDialog(this, "Petición modificada exitosamente");
    }

    private void eliminarPeticion () {
        int peticionId = Integer.parseInt(txtPeticionId.getText());
        recepcionController.darBajaPeticion(peticionId);
        JOptionPane.showMessageDialog(this, "Petición eliminada exitosamente");
    }

    private void solicitarResultados () {
        int peticionId = Integer.parseInt(txtIDPeticionAConsultar.getText());
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

    public static void main (String[]args){
        new RecepcionView();
    }
}