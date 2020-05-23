package view;

import dao.JpaAnnonceDao;
import dao.JpaCategorieDao;
import dao.JpaSurCategorieDao;
import metier.AnnonceEntity;
import metier.CategorieEntity;
import metier.SurCategorieEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

public class Acceuil extends JFrame {

    Collection<AnnonceEntity> annonceEntities = null;
    JComboBox<AnnonceEntity> annonceEntityJComboBox = new JComboBox<>();

    private JPanel jPanelParent;
    private JPanel jPanelHeader;
    private JPanel jPanelBody;
    private JPanel jPanelListAnnonce = new JPanel();
    private JPanel jPanelFooter;

    public Acceuil() {

        jPanelParent = new JPanel();

        setjPanelHeader();
        jPanelHeader.setPreferredSize(new Dimension(1000, 75));
        jPanelHeader.setBackground(getHSBFromRGB(255, 87, 51));

        setjPanelBody();
        jPanelBody.setPreferredSize(new Dimension(1000, 900));

        jPanelFooter = new JPanel();
        jPanelFooter.setPreferredSize(new Dimension(1000, 25));
        jPanelFooter.setBackground(getHSBFromRGB(255, 87, 51));

        jPanelParent.setLayout(new BorderLayout());
        jPanelParent.add(jPanelHeader, BorderLayout.NORTH);
        jPanelParent.add(jPanelBody, BorderLayout.CENTER);
        jPanelParent.add(jPanelFooter, BorderLayout.SOUTH);

        this.setContentPane(jPanelParent);
        this.setSize(1000, 1000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    private void setjPanelHeader() {

        jPanelHeader = new JPanel();
        jPanelHeader.setLayout(new GridBagLayout());

        JLabel jLabelTitle = new JLabel("<html><h1>Les Bons Bretons</h1></html>");

        JButton jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(new Dimension(200, 25));
        JButton jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(new Dimension(200, 25));


        addComponentInPanel(jPanelHeader, jLabelTitle, 0, 0, 1, 10, 1, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE, new int[]{0, 25, 0, 0});
        addComponentInPanel(jPanelHeader, jButtonConnexion, 1, 0, 1, 0.1, 1, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 0});
        addComponentInPanel(jPanelHeader, jButtonInscription, 2, 0, 1, 0.1, 1, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, new int[]{0, 0, 0, 5});
    }

    private void setjPanelBody() {
        jPanelBody = new JPanel();
        jPanelBody.setLayout(new GridBagLayout());

        JTextField jTextFieldRecherche = new JTextField();
        jTextFieldRecherche.setPreferredSize(new Dimension(200, 25));

        JTextField jTextFieldPrix = new JTextField();
        jTextFieldPrix.setPreferredSize(new Dimension(200, 25));

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
        SurCategorieEntity test = (SurCategorieEntity) jComboBoxSurCat.getItemAt(jComboBoxSurCat.getSelectedIndex());
        Collection<CategorieEntity> categorie = (Collection<CategorieEntity>) jpaCategorieDao.find(test);
        for (CategorieEntity c : categorie) {
            jComboBoxCat.addItem(c);
        }


        JButton jButtonRecherche = new JButton("Rechercher");
        jButtonRecherche.setPreferredSize(new Dimension(200, 25));
        jButtonRecherche.addActionListener(actionEvent -> {
            JpaAnnonceDao jpaAnnonceDao = new JpaAnnonceDao();
            annonceEntities = jpaAnnonceDao.findAnnonce(
                    jTextFieldRecherche.getText(),
                    (CategorieEntity) jComboBoxCat.getItemAt(jComboBoxCat.getSelectedIndex())
            );
            setAnnonceList();
        });

        addComponentInPanel(jPanelBody, jTextFieldRecherche, 0, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 0, 0, 10});
        addComponentInPanel(jPanelBody, jComboBoxSurCat, 1, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 10});
        addComponentInPanel(jPanelBody, jComboBoxCat, 2, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 10});
        addComponentInPanel(jPanelBody, jButtonRecherche, 3, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 0});
        // addComponentInPanel(jPanelBody, jTextFieldPrix, 4, 0, 1, 0, 0.01, GridBagConstraints.NORTH, GridBagConstraints.BASELINE, new int[]{25, 10, 0, 0});

        setAnnonceList();

        jComboBoxSurCat.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SurCategorieEntity test = (SurCategorieEntity) jComboBoxSurCat.getItemAt(jComboBoxSurCat.getSelectedIndex());
                JpaCategorieDao jpaCategorieDao = new JpaCategorieDao();
                Collection<CategorieEntity> categories = (Collection<CategorieEntity>) jpaCategorieDao.find(test);
                jComboBoxCat.removeAllItems();
                for (CategorieEntity c : categories) {
                    jComboBoxCat.addItem(c);
                }
            }
        });

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
