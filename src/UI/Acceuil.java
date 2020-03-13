package UI;

import dao.JpaAnnonceDao;
import metier.AnnonceEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acceuil extends JFrame {

    public JTextField jTextFieldEmail;
    public JTextField jTextFieldPassword;
    public JButton jButtonConnexion;
    public JButton jButtonInscription;
    public JTextField jTextFieldRecherche;
    public JButton jButtonRecherche;
    public JList<AnnonceEntity> jListAnnonce;
    private Acceuil acc;
    private JpaAnnonceDao JpaAn;

    public Acceuil() {
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());


        JPanel jPanel = new JPanel();
        JPanel jPanelAnnonce = new JPanel();

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setPreferredSize(new Dimension(500, 50));

        jTextFieldPassword = new JTextField();
        jTextFieldPassword.setPreferredSize(new Dimension(500, 50));

        jTextFieldRecherche = new JTextField();
        jTextFieldRecherche.setPreferredSize(new Dimension(500, 30));

        jButtonRecherche = new JButton("Recherche");
        jButtonRecherche.setPreferredSize(new Dimension(250, 30));
        jButtonRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (jTextFieldRecherche.getText() != "") {
                    JpaAn.findAnnonce(jTextFieldRecherche.getText()); // a continuer
                }
            }
        });

        jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(new Dimension(500, 50));

        jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(new Dimension(500, 50));
        jButtonInscription.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Inscription inscription = new Inscription(acc, true);
                inscription.setVisible(true);
            }
        });

        jPanel.add(jTextFieldEmail);
        jPanel.add(jTextFieldPassword);
        jPanel.add(jButtonConnexion);
        jPanel.add(jButtonInscription);

       /* jPanelAnnonce.add(jTextFieldRecherche);
        jPanelAnnonce.add(jButtonRecherche);*/


        this.add(jPanel, BorderLayout.CENTER);
        //this.add(jPanelAnnonce, BorderLayout.CENTER);
    }
}
