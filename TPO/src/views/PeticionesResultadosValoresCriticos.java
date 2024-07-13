package views;

import model.Peticion;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class PeticionesResultadosValoresCriticos extends JFrame {

    private JTable table;
    private static List<Peticion> peticionesCriticas;
    public PeticionesResultadosValoresCriticos(List<Peticion> peticionesCriticas){
        this.peticionesCriticas = peticionesCriticas;

        setTitle("Peticiones con Resultados Críticos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"ID Peticion", "Estado"};

        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
        for (Peticion peticion : peticionesCriticas) {
            Object[] rowData = {peticion.getIdPeticion(), "Crítica"};
            tableModel.addRow(rowData);
        }

        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }
    public void mostrar() {
        setVisible(true);
    }

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            PeticionesResultadosValoresCriticos vista = new PeticionesResultadosValoresCriticos(peticionesCriticas);
            vista.mostrar();
        });
    }

}
