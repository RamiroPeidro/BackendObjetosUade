package views;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.LaboratoristaController;
import Dtos.PeticionDTO;

public class FrmLaboratorista extends JDialog {
    private JPanel PnlPrincipal;
    private JTextField txtPeticionId;
    private JButton btnBuscarPeticion;
    private JList<String> lstPracticas;
    private JTextField txtResultado;
    private JButton btnCargarResultado;

    private JButton btnEliminarResultado;
    private DefaultListModel<String> practicaListModel;

    private LaboratoristaController laboratoristaController;

    public FrmLaboratorista(Window owner, String titulo) {
        super(owner, titulo);
        laboratoristaController = LaboratoristaController.getInstance();

        // Inicializar componentes
        initComponents();

        // Configuración del diálogo
        this.setSize(800, 600);
        this.setContentPane(PnlPrincipal);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setModal(true);

        // Configuración de eventos
        btnBuscarPeticion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarPeticion();
            }
        });

        btnCargarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cargarOModificarResultado();
            }
        });

        btnEliminarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                eliminarResultado();
            }
        });

        lstPracticas.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                // Lógica para manejar la selección de una práctica
                mostrarResultadoExistente();
            }
        });
    }

    private void initComponents() {
        PnlPrincipal = new JPanel(new BorderLayout());

        // Panel de búsqueda
        JPanel pnlBusqueda = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlBusqueda.add(new JLabel("ID Petición:"), gbc);

        gbc.gridx = 1;
        txtPeticionId = new JTextField(10);
        pnlBusqueda.add(txtPeticionId, gbc);

        gbc.gridx = 2;
        btnBuscarPeticion = new JButton("Buscar");
        pnlBusqueda.add(btnBuscarPeticion, gbc);

        PnlPrincipal.add(pnlBusqueda, BorderLayout.NORTH);

        // Panel de prácticas
        JPanel pnlPracticas = new JPanel(new BorderLayout());
        pnlPracticas.add(new JLabel("Prácticas asociadas:"), BorderLayout.NORTH);
        practicaListModel = new DefaultListModel<>();
        lstPracticas = new JList<>(practicaListModel);
        pnlPracticas.add(new JScrollPane(lstPracticas), BorderLayout.CENTER);

        PnlPrincipal.add(pnlPracticas, BorderLayout.CENTER);

        // Panel de resultado
        JPanel pnlResultado = new JPanel(new GridBagLayout());
        gbc.gridx = 0;
        gbc.gridy = 0;
        pnlResultado.add(new JLabel("Resultado:"), gbc);

        gbc.gridx = 1;
        txtResultado = new JTextField(10);
        pnlResultado.add(txtResultado, gbc);

        gbc.gridx = 2;
        btnCargarResultado = new JButton("Cargar/Modificar Resultado");
        pnlResultado.add(btnCargarResultado, gbc);

        gbc.gridx = 3;
        btnEliminarResultado = new JButton("Eliminar Resultado");
        pnlResultado.add(btnEliminarResultado, gbc);

        PnlPrincipal.add(pnlResultado, BorderLayout.SOUTH);
    }

    private void buscarPeticion() {
        String idPeticionStr = txtPeticionId.getText().trim();
        if (idPeticionStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo ID Petición no puede estar vacío");
            return;
        }

        try {
            int idPeticion = Integer.parseInt(idPeticionStr);
            PeticionDTO peticion = laboratoristaController.getPeticionById(idPeticion);

            if (peticion != null) {
                practicaListModel.clear();
                List<Integer> practicasIds = peticion.getListaPracticasIds();
                for (Integer practicaId : practicasIds) {
                    String practicaNombre = laboratoristaController.getPracticaNombreById(practicaId);
                    practicaListModel.addElement(practicaNombre);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Petición no encontrada");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "ID Petición debe ser un número entero válido");
        }
    }

    private void cargarOModificarResultado() {
        String selectedPractica = lstPracticas.getSelectedValue();
        String resultadoStr = txtResultado.getText().trim();

        if (selectedPractica == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una práctica");
            return;
        }

        int idPeticion = Integer.parseInt(txtPeticionId.getText());
        int idPractica = laboratoristaController.getPracticaIdByName(selectedPractica);

        if (idPractica == -1) {
            JOptionPane.showMessageDialog(this, "Práctica no encontrada");
            return;
        }

        if (resultadoStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "El campo Resultado no puede estar vacío");
            return;
        }

        try {
            float resultado = Float.parseFloat(resultadoStr);
            Float resultadoExistente = laboratoristaController.getResultadoDePractica(idPeticion, idPractica);
            if (resultadoExistente != null) {
                laboratoristaController.modificarResultado(idPeticion, idPractica, resultado, true);
                JOptionPane.showMessageDialog(this, "Resultado modificado exitosamente");
            } else {
                laboratoristaController.cargarResultado(resultado, idPeticion, idPractica);
                JOptionPane.showMessageDialog(this, "Resultado cargado exitosamente");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "El campo Resultado debe ser un número válido");
        }
    }

    private void eliminarResultado() {
        String selectedPractica = lstPracticas.getSelectedValue();

        if (selectedPractica == null) {
            JOptionPane.showMessageDialog(this, "Seleccione una práctica");
            return;
        }

        int idPeticion = Integer.parseInt(txtPeticionId.getText());
        int idPractica = laboratoristaController.getPracticaIdByName(selectedPractica);

        if (idPractica == -1) {
            JOptionPane.showMessageDialog(this, "Práctica no encontrada");
            return;
        }

        laboratoristaController.eliminarResultado(idPeticion, idPractica);
        JOptionPane.showMessageDialog(this, "Resultado eliminado exitosamente");
        txtResultado.setText("");
    }

    private void mostrarResultadoExistente() {
        String selectedPractica = lstPracticas.getSelectedValue();
        if (selectedPractica == null) {
            return;
        }

        int idPeticion = Integer.parseInt(txtPeticionId.getText());
        int idPractica = laboratoristaController.getPracticaIdByName(selectedPractica);

        if (idPractica != -1) {
            Float resultadoExistente = laboratoristaController.getResultadoDePractica(idPeticion, idPractica);
            if (resultadoExistente != null) {
                txtResultado.setText(String.valueOf(resultadoExistente));
            } else {
                txtResultado.setText("");
            }
        }
    }

    public static void main(String[] args) {
        new FrmLaboratorista(null, "Laboratorista").setVisible(true);
    }
}
