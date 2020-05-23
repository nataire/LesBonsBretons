package view;

import dao.JpaAnnonceDao;
import metier.AnnonceEntity;
import metier.CategorieEntity;
import metier.LocalisationEntity;
import metier.UtilisateurEntity;
import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;

public class Header extends JPanel {

    public static Dimension dimension = new Dimension(200, 25);
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    public Header() {
        this.setLayout(new GridBagLayout());
        setComponent();
    }

    private void setComponent() {
        JLabel jLabelTitle = new JLabel("<html><h1>Les Bons Bretons</h1></html>");

        JButton jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(dimension);

        JButton jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(dimension);

        designJPanelUtils.addComponent(this, jLabelTitle, 0, 0, 1, null, 10d, 1d, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE, 0, 25, 0, 0, null, null);
        designJPanelUtils.addComponent(this, jButtonConnexion, 1, 0, 1, null, 0.1, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, null, null, null, null, null, null);
        designJPanelUtils.addComponent(this, jButtonInscription, 2, 0, 1, null, 0.1, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, 0, 0, 0, 5, null, null);

        jButtonInscription.addActionListener(actionEvent -> {

            AnnonceEntity annonce = new AnnonceEntity();

            CategorieEntity categorie = new CategorieEntity();
            categorie.setIdCategorie(2);

            //categorie.setIdSurCategorie(surCategory);
            annonce.setCategorie(categorie);

            annonce.setDescriptionAnnonce("mes descritption");
            annonce.setTitreAnnonce("mon titre");

            LocalisationEntity maLocalisation = new LocalisationEntity();
            maLocalisation.setIdVille(17000);
            annonce.setIdAnnonceLocalisation(maLocalisation);


            annonce.setPrix(32);
            UtilisateurEntity utilisateur = new UtilisateurEntity();

            utilisateur.setIdUtilisateur(1);

            annonce.setIdUtilisateurAnnonce(utilisateur);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            annonce.setDateAnnonce(timestamp);
            JpaAnnonceDao monAnnonce = new JpaAnnonceDao();
            if (monAnnonce.create(annonce)) {
                System.out.println("succes");
            } else {
                System.out.println("echec");

            }
/*
            AnnonceEntity annonce = new AnnonceEntity();
            annonce.setIdAnnonce(5);
            JpaAnnonceDao monAnnonce = new JpaAnnonceDao();
            if(monAnnonce.delete(annonce))
            {
                System.out.println("succes");
            }
            else
            {
                System.out.println("echec");

            }*/


        });
    }
}
