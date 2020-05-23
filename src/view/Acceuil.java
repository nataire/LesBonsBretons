package view;

import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;

public class Acceuil extends JFrame {

    public static int[] orange = new int[]{255, 87, 51};
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    public Acceuil() {

        JPanel jPanelParent = new JPanel();

        JPanel jPanelHeader = new Header();
        jPanelHeader.setPreferredSize(new Dimension(1000, 75));
        jPanelHeader.setBackground(designJPanelUtils.getHSBFromRGB(orange));

        JPanel jpanelBody1 = new Body();
        jpanelBody1.setPreferredSize(new Dimension(1000, 900));

        JPanel jPanelFooter = new Footer();
        jPanelFooter.setPreferredSize(new Dimension(1000, 25));
        jPanelFooter.setBackground(designJPanelUtils.getHSBFromRGB(orange));

        jPanelParent.setLayout(new BorderLayout());
        jPanelParent.add(jPanelHeader, BorderLayout.NORTH);
        jPanelParent.add(jpanelBody1, BorderLayout.CENTER);
        jPanelParent.add(jPanelFooter, BorderLayout.SOUTH);

        this.setContentPane(jPanelParent);
        this.setSize(1000, 1000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }


        JComboBox jComboBoxSurCat = new JComboBox();
        jComboBoxSurCat.setPreferredSize(new Dimension(200, 25));
        JpaSurCategorieDao jpaSurCategorieDao = new JpaSurCategorieDao();
        Collection<SurCategorieEntity> surCategorie = jpaSurCategorieDao.findAll();
        for (SurCategorieEntity c : surCategorie) {
            jComboBoxSurCat.addItem(c);
        }
        JComboBox jComboBoxCat = new JComboBox();
        jComboBoxCat.setPreferredSize(new Dimension(200, 25));
        JpaCategorieDao jpaCategorieDao = new JpaCategorieDao();
        Collection<CategorieEntity> categorie = jpaCategorieDao.findAll();
        for (CategorieEntity c : categorie) {
            jComboBoxCat.addItem(c);
        }

        JButton jButtonRecherche = new JButton("Rechercher");
        jButtonRecherche.setPreferredSize(new Dimension(200, 25));
        jButtonRecherche.addActionListener(actionEvent -> {
            JpaAnnonceDao jpaAnnonceDao = new JpaAnnonceDao();
            annonceEntities = jpaAnnonceDao.findAnnonce(
                    jTextFieldRecherche.getText(),
                    (SurCategorieEntity) jComboBoxSurCat.getItemAt(jComboBoxSurCat.getSelectedIndex())
            );
            setAnnonceList();
        });

        addComponentInPanel(jPanelBody, jTextFieldRecherche, 0, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 0, 0, 10});
        addComponentInPanel(jPanelBody, jComboBoxSurCat, 1, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 10});
        addComponentInPanel(jPanelBody, jComboBoxCat, 2, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 10});
        addComponentInPanel(jPanelBody, jButtonRecherche, 3, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 0});

        setAnnonceList();

    }

    private void setAnnonceList() {
        if (jPanelBody.getComponentCount() > 4) jPanelBody.remove(4);

        if (annonceEntities != null) {
            addComponentInPanel(jPanelBody, new AnnonceList(new ArrayList<>(annonceEntities)), 0, 1, 4, 0, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new int[]{0, 0, 25, 0});
        }

        jPanelBody.updateUI();
    }

    private Color getHSBFromRGB(int red, int green, int blue) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(red, green, blue, hsb);
        // brightness
        hsb[2] *= 1f;
        // saturation
        hsb[1] *= 1f;
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }

    private void addComponentInPanel(JPanel jPanel, JComponent jComponent, int gridx, int gridy, int gridwith, double weightx, double weighty, int anchor, int fill, int[] insets) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = fill;
        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;
        gridBagConstraints.gridwidth = gridwith;
        if (weightx != 0) gridBagConstraints.weightx = weightx;
        if (weighty != 0) gridBagConstraints.weighty = weighty;
        gridBagConstraints.anchor = anchor;
        gridBagConstraints.insets = new Insets(insets[0], insets[1], insets[2], insets[3]);
        jPanel.add(jComponent, gridBagConstraints);
    }
}
