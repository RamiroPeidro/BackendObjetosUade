package views;

import model.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PeticionView extends JFrame {

    //private static List<Resultado> listaResultadosPeticion = new ArrayList<>();
    //private static List<Peticion> listaPeticiones = new ArrayList<>();
    //private static List<Practica> listaPracticas = new ArrayList<>();
    //private static Date fechaInicio;
    //private static Date fechaFin;

    private static List<Resultado> resultados;


    public PeticionView(List<Resultado> resultados) {

        this.resultados = resultados;

        setTitle("Resultados");
        setSize(1000, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String[] columnNames = {"Nombre Practica", "Valor Resultado", "Valor Referencia Minimo", "Valor Referencia Maximo"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);

        for (Resultado resultado : resultados) {
            String valorResultado;

            if (resultado.getPractica().getEsReservada()) {
                valorResultado = "valor reservado, buscar en recepcion";
            } else {
                valorResultado = String.valueOf(resultado.getValor());
            }
            Object[] rowData = {
                    resultado.getPractica().getNombrePractica(),
                    valorResultado,
                    resultado.getPractica().getRangoValores().getMinValor(),
                    resultado.getPractica().getRangoValores().getMaxValor()
            };
            tableModel.addRow(rowData);
        }

        JTable table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        /*//Crear una lista de resultados para probar
        Practica practica1 = new Practica(1,"Hematograma","Hematocritos",new RangoValor(10,20),24f,true,false);
        Practica practica2 = new Practica(2, "Bioquímica", "Glucosa", new RangoValor(70, 110), 85.5f, true, false);

        listaPracticas.add(practica1);
        listaPracticas.add(practica2);

        Paciente paciente1 = new Paciente("Julia",42390780,"Juramento 3409",new Email("julia@gmail.com"),"femenino",24,listaPeticiones);
        Sucursal sucursal1 = new Sucursal();

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date fechaInicio = sdf.parse("28/05/2024");
            Date fechaFin = sdf.parse("01/06/2024");

        } catch (ParseException e) {
            e.printStackTrace();
        }

        Peticion peticion1 = new Peticion(1, paciente1, "Osde", fechaInicio, fechaFin, sucursal1, listaPracticas, listaResultadosPeticion);


        Resultado resultado1 = new Resultado(5.2f, practica1);
        Resultado resultado2 = new Resultado(180, practica2);
        listaResultadosPeticion.add(resultado1);
        listaResultadosPeticion.add(resultado2);*/

        SwingUtilities.invokeLater(() -> {
            PeticionView vista = new PeticionView(resultados);
            vista.setVisible(true);
        });
    }
}









