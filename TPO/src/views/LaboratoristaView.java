package views;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import controller.LaboratoristaController;

public class LaboratoristaView extends JFrame {
    private JTextField txtValor, txtIdPeticion, txtIdPractica;
    private JCheckBox chkFinalizado, chkValorCritico, chkValorReservado;
    private JButton btnCargarResultado, btnEliminarResultado, btnModificarResultado;

    private LaboratoristaController laboratoristaController;

    public LaboratoristaView() {
        laboratoristaController = LaboratoristaController.getInstance();
        setTitle("Laboratorista");
        setSize(800, 600);
        setLayout(null);

        JLabel lblValor = new JLabel("Valor:");
        lblValor.setBounds(50, 50, 100, 30);
        add(lblValor);

        txtValor = new JTextField();
        txtValor.setBounds(150, 50, 200, 30);
        add(txtValor);

        JLabel lblIdPeticion = new JLabel("ID Petición:");
        lblIdPeticion.setBounds(50, 100, 100, 30);
        add(lblIdPeticion);

        txtIdPeticion = new JTextField();
        txtIdPeticion.setBounds(150, 100, 200, 30);
        add(txtIdPeticion);

        JLabel lblIdPractica = new JLabel("ID Práctica:");
        lblIdPractica.setBounds(50, 150, 100, 30);
        add(lblIdPractica);

        txtIdPractica = new JTextField();
        txtIdPractica.setBounds(150, 150, 200, 30);
        add(txtIdPractica);

        chkFinalizado = new JCheckBox("Finalizado");
        chkFinalizado.setBounds(50, 200, 200, 30);
        add(chkFinalizado);

        btnCargarResultado = new JButton("Cargar Resultado");
        btnCargarResultado.setBounds(50, 350, 200, 30);
        add(btnCargarResultado);

        btnEliminarResultado = new JButton("Eliminar Resultado");
        btnEliminarResultado.setBounds(50, 400, 200, 30);
        add(btnEliminarResultado);

        btnModificarResultado = new JButton("Modificar Resultado");
        btnModificarResultado.setBounds(50, 450, 200, 30);
        add(btnModificarResultado);

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
                float valor = Float.parseFloat(txtValor.getText());
                int idPeticion = Integer.parseInt(txtIdPeticion.getText());
                int idPractica = Integer.parseInt(txtIdPractica.getText());
                boolean finalizado = chkFinalizado.isSelected();
                boolean valorCritico = chkValorCritico.isSelected();
                boolean valorReservado = chkValorReservado.isSelected();
                laboratoristaController.modificarResultado(idPeticion, idPractica, valor, finalizado);
                JOptionPane.showMessageDialog(null, "Resultado modificado exitosamente");
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new LaboratoristaView();
    }
}
