package UI;

import dao.JpaAnnonceDao;
import metier.AnnonceEntity;

import javax.swing.*;
import java.util.Collection;

public class Accueil {
    private JTextField textFieldRecherche;
    private JButton rechercheButton;
    private JButton connexionButton;
    private JPanel panel;
    private JButton button1;
    private JList list1;
    private JpaAnnonceDao JpaAnnconce;
    private Collection<AnnonceEntity> Annonce;

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    public static void main(final String[] args) throws Exception {
        JFrame frame = new JFrame("App");
        frame.setContentPane(new Accueil().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void $$$setupUI$$$() {
        createUIComponents();
        Annonce.addAll(JpaAnnconce.findAll());
    }
}
