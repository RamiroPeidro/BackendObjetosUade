package views;

import controller.AdministradorController;
import controller.RecepcionController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton administradorButton;
    private JButton recepcionButton;
    private JButton laboratoristaButton;
    private FrmPrincipal self;

    public FrmPrincipal(String titulo) {
        super(titulo);
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (UnsupportedLookAndFeelException e) {
            throw new RuntimeException(e);
        }
        this.setContentPane(pnlPrincipal);
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.asociarEventos();
        this.self = this;
    }

    private void asociarEventos() {
        laboratoristaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmLaboratorista frmLaboratorista = new FrmLaboratorista(self, "Laboratorista");
                frmLaboratorista.setVisible(true);
            }
        });

        administradorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmAdministrador frmAdministrador = new FrmAdministrador(self, "Administrador");
                frmAdministrador.setVisible(true);
            }
        });

        recepcionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FrmRecepcionista frmRecepcionista = new FrmRecepcionista(self, "Recepcionista");
                frmRecepcionista.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        FrmPrincipal frame = new FrmPrincipal("Sistema de Laboratorio");
    }


}
