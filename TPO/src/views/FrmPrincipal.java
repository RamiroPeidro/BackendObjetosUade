package views;

import javax.swing.*;

public class FrmPrincipal extends JFrame {

    private JPanel pnlPrincipal;
    private JPanel pnlMenu;
    private JButton administradorButton;
    private JButton recepcionButton;
    private JButton laboratoristaButton;

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
//        this.pack();
    }

    public static void main(String[] args) {
        FrmPrincipal frame = new FrmPrincipal("Primer programa Swing");
    }
}
