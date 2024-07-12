package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import controller.LaboratoristaController;
import datos.PracticaManager;
import model.Practica;

public class LaboratoristaView extends JFrame {
    private JTextField txtValor, txtIdPeticion, txtIdPractica;
    private JButton btnCargarResultado, btnEliminarResultado, btnModificarResultado;

    private JList<String> practicaList;

    private LaboratoristaController laboratoristaController;

    public LaboratoristaView() {
        laboratoristaController = LaboratoristaController.getInstance();
        setTitle("Laboratorista");
        setSize(800, 600);
        setLayout(null);

        //RESULTADO
        JLabel lblResultado = new JLabel("RESULTADO");
        lblResultado.setBounds(350, 50, 200, 30);
        add(lblResultado);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(250, 100, 150, 30);
        add(lblValor);
        txtValor = new JTextField();
        txtValor.setBounds(370, 100, 200, 30);
        add(txtValor);
        JLabel lblPeticion = new JLabel("Peticion:");
        lblPeticion.setBounds(250, 125, 150, 30);
        add(lblPeticion);
        txtIdPeticion = new JTextField();
        txtIdPeticion.setBounds(370, 125, 200, 30);
        add(txtIdPeticion);
        JLabel lblPractica = new JLabel("Practica:");
        lblPractica.setBounds(250, 150, 150, 30);
        add(lblPractica);

        //picklist de prácticas
        List<Practica> practicas = PracticaManager.getHarcodedPracticas();
        DefaultListModel<String> listModel = new DefaultListModel<>();
        for (Practica practica : practicas) {
            listModel.addElement(practica.getNombrePractica());
        }
        practicaList = new JList<>(listModel);
        practicaList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        JScrollPane scrollPane = new JScrollPane(practicaList);
        scrollPane.setBounds(370, 160, 200, 100);
        add(scrollPane);

        btnCargarResultado = new JButton("Cargar Resultado");
        btnCargarResultado.setBounds(300, 400, 200, 30);
        add(btnCargarResultado);
        btnModificarResultado = new JButton("Modificar Resultado");
        btnModificarResultado.setBounds(300, 425, 200, 30);
        add(btnModificarResultado);
        btnEliminarResultado = new JButton("Eliminar Resultado");
        btnEliminarResultado.setBounds(300, 450, 200, 30);
        add(btnEliminarResultado);


        btnCargarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                float valor = Float.parseFloat(txtValor.getText());
                int idPeticion = Integer.parseInt(txtIdPeticion.getText());
                int idPractica = Integer.parseInt(txtIdPractica.getText());
                laboratoristaController.cargarResultado(valor, idPeticion, idPractica);
                JOptionPane.showMessageDialog(null, "Resultado cargado exitosamente");
            }
        });

        btnEliminarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int idPeticion = Integer.parseInt(txtIdPeticion.getText());
                int idPractica = Integer.parseInt(txtIdPractica.getText());
                laboratoristaController.eliminarResultado(idPeticion, idPractica);
                JOptionPane.showMessageDialog(null, "Resultado eliminado exitosamente");
            }
        });

        btnModificarResultado.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                /*float valor = Float.parseFloat(txtValor.getText());
                int idPeticion = Integer.parseInt(txtIdPeticion.getText());
                int idPractica = Integer.parseInt(txtIdPractica.getText());
                boolean finalizado = chkFinalizado.isSelected();
                boolean valorCritico = chkValorCritico.isSelected();
                boolean valorReservado = chkValorReservado.isSelected();
                laboratoristaController.modificarResultado(idPeticion, idPractica, valor, finalizado);
                JOptionPane.showMessageDialog(null, "Resultado modificado exitosamente");*/
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LaboratoristaView();
    }
}
