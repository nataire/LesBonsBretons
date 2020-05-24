package view;

import metier.AnnonceEntity;
import utils.DesignJPanelUtils;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.ArrayList;

public class AnnonceList extends JPanel {

    public static int[] grayLight = new int[]{215, 219, 211};
    public static int[] red = new int[]{255, 87, 51};
    public static Font font = new Font("Comic Sans Ms", Font.BOLD + Font.ITALIC, 12);
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    private final ArrayList<AnnonceEntity> annonceEntities;

    public AnnonceList(ArrayList<AnnonceEntity> list) {
        this.setLayout(new GridBagLayout());
        this.annonceEntities = list;
        setComponent();
    }

    private void setComponent() {

        for (int i = 0; i < annonceEntities.size(); i++) {
            AnnonceEntity currentAnnonceEntity = annonceEntities.get(i);

            JPanel tmpJPanel = new JPanel();
            tmpJPanel.setPreferredSize(new Dimension(800, 200));
            tmpJPanel.setBorder(
                    BorderFactory.createTitledBorder(
                            BorderFactory.createEtchedBorder(EtchedBorder.LOWERED),
                            annonceEntities.get(i).getDateAnnonce().toString(), TitledBorder.RIGHT, TitledBorder.BOTTOM,
                            font, designJPanelUtils.getHSBFromRGB(red))
            );
            tmpJPanel.setBackground(designJPanelUtils.getHSBFromRGB(grayLight));
            tmpJPanel.setLayout(new GridBagLayout());

            JLabel currentImage = new JLabel(new ImageIcon(designJPanelUtils.getImage(currentAnnonceEntity.getLienImage())));
            JLabel currentTitle = new JLabel(currentAnnonceEntity.getTitreAnnonce() + " - " + currentAnnonceEntity.getCategorie().getNomCategorie());
            JLabel currentPrice = new JLabel(currentAnnonceEntity.getPrix() + "€");

            JLabel currentDescription = new JLabel(designJPanelUtils.convertToMultiline(currentAnnonceEntity.getDescriptionAnnonce()));
            JScrollPane jScrollPaneDescription = new JScrollPane(currentDescription);
            jScrollPaneDescription.setBackground(designJPanelUtils.getHSBFromRGB(grayLight));

            designJPanelUtils.addComponent(tmpJPanel, currentImage, 0, 0, 1, 2, null, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, null, null, null, null, 10, 10);
            designJPanelUtils.addComponent(tmpJPanel, currentTitle, 1, 0, 1, 1, 0.5, 0.01, GridBagConstraints.NORTHWEST, GridBagConstraints.BASELINE, 0, 0, 10, 0, 10, 10);
            designJPanelUtils.addComponent(tmpJPanel, currentPrice, 2, 0, 1, 1, 0.5, 0.01, GridBagConstraints.NORTHEAST, GridBagConstraints.BASELINE, 0, 0, 10, 0, 10, 10);
            designJPanelUtils.addComponent(tmpJPanel, jScrollPaneDescription, 1, 1, 3, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BOTH, null, null, null, null, 10, 10);

            designJPanelUtils.addComponent(this, tmpJPanel, 0, i, 1, 1, 1d, 1d, GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL, 0, 0, 5, 0, null, null);
        }
        designJPanelUtils.addComponent(this, new JLabel(), 0, annonceEntities.size(), 1, 1, null, 100d, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, null, null, null, null, null, null);
    }

}
