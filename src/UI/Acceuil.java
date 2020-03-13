package UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Acceuil extends JFrame implements ActionListener {

    public JTextField jTextFieldEmail;
    public JTextField jTextFieldPassword;
    public JButton jButtonConnexion;
    public JButton jButtonInscription;

    public Acceuil() {
        this.setSize(600, 600);
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setPreferredSize(new Dimension(500, 50));

        jTextFieldPassword = new JTextField();
        jTextFieldPassword.setPreferredSize(new Dimension(500, 50));

        jButtonConnexion = new JButton("Connexion");
        jButtonConnexion.setPreferredSize(new Dimension(500, 50));

        jButtonInscription = new JButton("Inscription");
        jButtonInscription.setPreferredSize(new Dimension(500, 50));
        jButtonInscription.addActionListener(this);

        jPanel.add(jTextFieldEmail);
        jPanel.add(jTextFieldPassword);
        jPanel.add(jButtonConnexion);
        jPanel.add(jButtonInscription);

        this.add(jPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        Inscription inscription = new Inscription(this, true);
        inscription.setVisible(true);
    }
}
