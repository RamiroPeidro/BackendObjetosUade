package views;

import com.sun.tools.javac.Main;
import model.Practica;
import model.RangoValor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class MainView extends JFrame {
    private JButton btnAdministrador;
    private JButton btnLaboratorista;
    private JButton btnRecepcionista;


    //lista que guarda las practicas harcodeadas
    private List<Practica> harcodedPracticas = new ArrayList<>();

    public MainView() {
        setTitle("Main View");
        setSize(400, 300);
        setLayout(null);

        btnAdministrador = new JButton("Administrador");
        btnAdministrador.setBounds(50, 50, 200, 30);
        add(btnAdministrador);

        btnLaboratorista = new JButton("Laboratorista");
        btnLaboratorista.setBounds(50, 100, 200, 30);
        add(btnLaboratorista);

        btnRecepcionista = new JButton("Recepcionista");
        btnRecepcionista.setBounds(50, 150, 200, 30);
        add(btnRecepcionista);

        btnAdministrador.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdministradorView();
            }
        });

        btnLaboratorista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LaboratoristaView();
            }
        });

        btnRecepcionista.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new RecepcionView();
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        //esto es un harcodeo del practicas que creo que va en el MAIN pero probando cosas lo deje aca, no se ya estoy quemada
        RangoValor rango1 = new RangoValor(5, 10, 30);
        RangoValor rango2 = new RangoValor(20, 40, 80);
        RangoValor rango3 = new RangoValor(300, 600, 100);
        RangoValor rango4 = new RangoValor(1100, 2200, 3000);
        Practica practica1 = new Practica(1, "Hemograma Completo", "Hematología", rango1, 24.0f, true);
        Practica practica2 = new Practica(2, "Perfil Lipídico", "Química Clínica", rango2, 48.0f, true);
        Practica practica3 = new Practica(3, "Protrombina", "Coagulación", rango3, 60.0f, true);
        Practica practica4 = new Practica(4, "Panel de Hormonas Tiroideas", "Endocrinología", rango4, 80.0f, true);
        harcodedPracticas.add(practica1);
        harcodedPracticas.add(practica2);
        harcodedPracticas.add(practica3);
        harcodedPracticas.add(practica4);
    }

    public static void main(String[] args) {
        new MainView();
    }
}
