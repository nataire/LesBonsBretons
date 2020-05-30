package view;

import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;

public class Compte extends JDialog {

    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    private JPanel jPanel;
    private JLabel jLabelTitle;
    private JLabel[] labels;
    private JComponent[] components;

    public Compte(Frame owner, boolean modal) {
        super(owner, modal);

        setComponent();
        showComponent();

        this.setContentPane(jPanel);
        this.setTitle("Mon compte");
        this.setSize(new Dimension(500, 500));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void setComponent() {
        jLabelTitle = new JLabel("Voici les informations concernant votre compte");

        JLabel jLabelLogin = new JLabel("Pseudo :");
        JLabel jLabelEmail = new JLabel("E-mail :");
        JLabel jLabelPassword = new JLabel("Mot de passe :");
        JLabel jLabelVille = new JLabel("Ville :");
        JLabel jLabelRue = new JLabel("Rue :");
        JLabel jLabelNumRue = new JLabel("Numéro de la rue :");
        JLabel jLabelNumTel = new JLabel("Numéro de téléphone :");
        labels = new JLabel[]{
                jLabelEmail, jLabelPassword
        };
    }

    private void showComponent() {

    }
}
