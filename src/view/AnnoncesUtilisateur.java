package view;

import metier.UtilisateurEntity;
import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;

public class AnnoncesUtilisateur extends JDialog {

    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    private JPanel jPanel;
    private UtilisateurEntity utilisateurEntity;

    public AnnoncesUtilisateur(Frame owner, boolean modal, UtilisateurEntity utilisateurEntity) {
        super(owner, modal);
        this.utilisateurEntity = utilisateurEntity;

        setComponent();
        showComponent();

        this.setContentPane(jPanel);
        this.setTitle("Mes annonces");
        this.setSize(new Dimension(1000, 1200));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    private void setComponent() {

    }

    private void showComponent() {
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

    }
}
