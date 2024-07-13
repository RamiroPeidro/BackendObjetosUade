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
    }

    public static void main(String[] args) {
        new MainView();
    }
}