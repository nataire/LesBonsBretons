package view;

import metier.AnnonceEntity;
import utils.DesignJPanelUtils;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class AnnonceList extends JPanel {

    public static int[] grayLight = new int[]{215, 219, 211};
    public static int[] red = new int[]{255, 87, 51};
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    private ArrayList<AnnonceEntity> annonceEntities;

    public AnnonceList(ArrayList<AnnonceEntity> list) {
        this.setLayout(new GridBagLayout());
        this.annonceEntities = list;
        setComponent();
    }

    private void setComponent() {

        for (int i = 0; i < annonceEntities.size(); i++) {
            AnnonceEntity currentAnnonceEntity = annonceEntities.get(i);

            JPanel tmpJPanel = new JPanel();
            tmpJPanel.setBorder(
                    BorderFactory.createTitledBorder(
                            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                            annonceEntities.get(i).getDateAnnonce().toString(), TitledBorder.RIGHT, TitledBorder.BOTTOM,
                            new Font("Comic Sans Ms", Font.BOLD + Font.ITALIC, 12), designJPanelUtils.getHSBFromRGB(red))
            );
            tmpJPanel.setBackground(designJPanelUtils.getHSBFromRGB(grayLight));
            tmpJPanel.setLayout(new GridBagLayout());

            addComponentInPanel(tmpJPanel, new JLabel(new ImageIcon(getImage("https://urlz.fr/cKIJ"))), 0, 0, 1, 2, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 0}, 10, 10);
            addComponentInPanel(tmpJPanel, new JLabel(currentAnnonceEntity.getTitreAnnonce() + " - " + currentAnnonceEntity.getCategorie().getNomCategorie()), 1, 0, 1, 1, 0.5, 0.01, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 0}, 10, 10);
            addComponentInPanel(tmpJPanel, new JLabel("100€"), 2, 0, 1, 1, 0.5, 0.01, GridBagConstraints.LINE_END, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 0}, 10, 10);
            addComponentInPanel(tmpJPanel, new JLabel(currentAnnonceEntity.getDescriptionAnnonce()), 1, 1, 3, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new int[]{0, 0, 0, 0}, 10, 10);

            addComponentInPanel(this, tmpJPanel, 0, i, 1, 1, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, new int[]{0, 0, 5, 0}, 0, 0);
        }
        addComponentInPanel(this, new JLabel(), 0, annonceEntities.size(), 1, 1, 0, 100, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 0}, 0, 0);
    }

    private void addComponentInPanel(JPanel jPanel, JComponent jComponent, int gridx, int gridy, int gridwith, int gridheigth, double weightx, double weighty, int anchor, int fill, int[] insets, int ipadx, int ipady) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = fill;
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.gridwidth = gridwith;
        gridBagConstraints.gridheight = gridheigth;
        if (weightx != 0) gridBagConstraints.weightx = weightx;
        if (weighty != 0) gridBagConstraints.weighty = weighty;
        gridBagConstraints.anchor = anchor;
        gridBagConstraints.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);
        gridBagConstraints.ipadx = ipadx;
        gridBagConstraints.ipady = ipady;
        jPanel.add(jComponent, gridBagConstraints);
    }

    private Image getImage(String url) {

        try {
            Image icon = ImageIO.read(new URL(url));
            return icon.getScaledInstance(100, 150, Image.SCALE_DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
