package UI;

import dao.JpaAnnonceDao;
import dao.JpaCategorieDao;
import dao.JpaUtilisateurDao;
import metier.AnnonceEntity;
import metier.CategorieEntity;
import metier.UtilisateurEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

public class Acceuil extends JFrame {

    public JTextField jTextFieldEmail;
    public JTextField jTextFieldPassword;
    public JButton jButtonConnexion;
    public JButton jButtonInscription;
    public JTextField jTextFieldRecherche;
    public JButton jButtonRecherche;
    public JComboBox jComboBox;
    public JList<AnnonceEntity> jListAnnonce;
    public AnnonceEntity AnnonceE;

    private JpaAnnonceDao JpaAn;
    private JpaCategorieDao JpaCat;

    public Acceuil() {
        this.setSize(600, 600);
        this.setLayout(new GridLayout(1, 2));

        JPanel jPanelOptions = new JPanel();
        JPanel jPanelAnnonce = new JPanel();
        JpaAn = new JpaAnnonceDao();
        jPanelAnnonce.setBackground(Color.BLUE);
        AnnonceE = new AnnonceEntity();
        JpaCat = new JpaCategorieDao();

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setPreferredSize(new Dimension(500, 50));

        jTextFieldPassword = new JPasswordField();
        jTextFieldPassword.setPreferredSize(new Dimension(500, 50));

        jTextFieldRecherche = new JTextField();
        jTextFieldRecherche.setPreferredSize(new Dimension(500, 30));

        jComboBox = new JComboBox();
        jComboBox.addItem("");
        Collection<CategorieEntity> categorie = JpaCat.findAll();
        for (CategorieEntity c : categorie) {
            jComboBox.addItem(c);
        }

        jButtonRecherche = new JButton("Recherche");
        jButtonRecherche.setPreferredSize(new Dimension(250, 30));
        jButtonRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Collection<AnnonceEntity> mesAnnonces = null;
                if (jComboBox.getSelectedIndex() != 0) {
                    mesAnnonces = JpaAn.findAnnonce(jTextFieldRecherche.getText(), (CategorieEntity) jComboBox.getItemAt(jComboBox.getSelectedIndex()));
                } else {
                    mesAnnonces = JpaAn.findAnnonce(jTextFieldRecherche.getText());
                }
                //jComboBox.getSelectedItem().toString()
                //Collection<AnnonceEntity> mesAnnonces = JpaAn.findAll();
                System.out.println(mesAnnonces);// a continuer
                for (AnnonceEntity an : mesAnnonces) {
                    System.out.println(an.getIdAnnonce());
                    JLabel anText = new JLabel();
                    anText.setPreferredSize(new Dimension(250, 30));
                    anText.setText(an.getTitreAnnonce());
                    jPanelAnnonce.add(anText);
                }
            }
        });

        jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(new Dimension(500, 50));
        jButtonConnexion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    JpaUtilisateurDao utilisateurDao = new JpaUtilisateurDao();
                    UtilisateurEntity user = utilisateurDao.connexionUser(jTextFieldEmail.getText(), jTextFieldPassword.getText());
                    System.out.println(user.toString());
                } catch (javax.persistence.NoResultException e) {
                    System.out.println("Non trouvé");
                }

            }
        });


        jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(new Dimension(500, 50));
        jButtonInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Acceuil acc = new Acceuil();
                Inscription inscription = new Inscription(acc, true);
                inscription.setVisible(true);
            }
        });

        jPanelOptions.add(jTextFieldEmail);
        jPanelOptions.add(jTextFieldPassword);
        jPanelOptions.add(jButtonConnexion);
        jPanelOptions.add(jButtonInscription);

        jPanelAnnonce.add(jTextFieldRecherche);
        jPanelAnnonce.add(jButtonRecherche);
        jPanelAnnonce.add(jComboBox);

        this.add(jPanelAnnonce);
        this.add(jPanelOptions);


    }
}
