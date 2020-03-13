package UI;

import dao.JpaAnnonceDao;
import metier.AnnonceEntity;

import javax.swing.*;
import java.util.Collection;

public class Accueil extends JFrame {
    private JTextField textFieldRecherche;
    private JButton rechercheButton;
    private JButton connexionButton;
    private JPanel panel;
    private JList list1;
    private JButton inscriptionButton;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JpaAnnonceDao JpaAnnconce;
    private Collection<AnnonceEntity> Annonce;
    private Inscription is;

    public Accueil() {

      /* this.setSize(600,600);
       this.setLayout(new BorderLayout());
       inscriptionButton = new JButton("test");
       this.add(inscriptionButton, BorderLayout.CENTER);

        inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new Inscription();
            }
        });*/
        //Annonce.add(JpaAnnconce.findAll());
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

   /*private void $$$setupUI$$$() {
       /*JFrame frame = new JFrame("App");
       frame.setContentPane(new Accueil().panel);
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.pack();
       frame.setVisible(true);
        createUIComponents();

    }*/


}
