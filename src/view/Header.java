package view;

import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;

public class Header extends JPanel {

    public static Dimension dimension = new Dimension(200, 25);
    public static String title = "<html><h1>Les Bons Bretons</h1></html>";
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    private JFrame acceuil;

    public Header(JFrame parent) {
        this.setLayout(new GridBagLayout());
        this.acceuil = parent;
        setComponent();
    }

    private void setComponent() {
        JLabel jLabelTitle = new JLabel(title);

        JButton jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(dimension);

        JButton jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(dimension);

        designJPanelUtils.addComponent(this, jLabelTitle, 0, 0, 1, null, 10d, 1d, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE, 0, 25, 0, 0, null, null);
        designJPanelUtils.addComponent(this, jButtonConnexion, 1, 0, 1, null, 0.1, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, null, null, null, null, null, null);
        designJPanelUtils.addComponent(this, jButtonInscription, 2, 0, 1, null, 0.1, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, 0, 0, 0, 5, null, null);

        jButtonInscription.addActionListener(actionEvent -> {
            Inscription inscription = new Inscription(acceuil, true);
        });
    }
}
