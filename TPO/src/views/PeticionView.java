package views;

import model.Practica;
import model.RangoValor;
import model.Resultado;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class PeticionView extends JFrame {

    private static List<Resultado> listaResultadosPeticion = new ArrayList<>();

    public PeticionView() {
        setTitle("Resultados");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nombre Practica", "Valor Resultado", "Rango Valores"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Resultado resultado : listaResultadosPeticion) {
            Object[] rowData = {
                    resultado.getPractica().getNombrePractica(),
                    resultado.getValor(),
                    resultado.getPractica().getRangoValores()
            };
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        //Crear una lista de resultados para probar
        Practica practica1 = new Practica(1,"Hematograma","Hematocritos",new RangoValor(10,20),24f,true,false);

        /*Resultado resultado1 = new Resultado(5.2, practica1);
        Resultado resultado2 = new Resultado(180, practica2);
        listaResultadosPeticion.add(resultado1);
        listaResultadosPeticion.add(resultado2);*/

        SwingUtilities.invokeLater(() -> {
            PeticionView vista = new PeticionView();
            vista.setVisible(true);
        });
    }
}









