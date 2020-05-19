package UI;

import dao.JpaLocalisationDao;
import dao.JpaUtilisateurDao;
import metier.UtilisateurEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inscription extends JDialog {

    public JTextField jTextFieldEmail;
    public JPasswordField jPasswordFieldPassword;
    public JPasswordField jPasswordFieldPasswordConfirm;
    public JTextField jTextFieldVille;
    public JTextField jTextFieldRue;
    public JTextField jTextFieldNumRue;
    public JTextField jTextFieldNumTel;
    public JButton jButtonConfirm;

    public Inscription(Frame owner, boolean modal) {
        super(owner, modal);

        this.setSize(600, 600);
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setPreferredSize(new Dimension(500, 50));


        jPasswordFieldPassword = new JPasswordField();
        jPasswordFieldPassword.setPreferredSize(new Dimension(500, 50));

        jPasswordFieldPasswordConfirm = new JPasswordField();
        jPasswordFieldPasswordConfirm.setPreferredSize(new Dimension(500, 50));

        jTextFieldVille = new JTextField();
        jTextFieldVille.setPreferredSize(new Dimension(500, 50));

        jTextFieldRue = new JTextField();
        jTextFieldRue.setPreferredSize(new Dimension(500, 50));

        jTextFieldNumRue = new JTextField();
        jTextFieldNumRue.setPreferredSize(new Dimension(500, 50));

        jTextFieldNumTel = new JTextField();
        jTextFieldNumTel.setPreferredSize(new Dimension(500, 50));

        jButtonConfirm = new JButton("Confirmer");
        jButtonConfirm.setPreferredSize(new Dimension(500, 50));
        jButtonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String password = new String(jPasswordFieldPassword.getPassword());
                String confirmPassword = new String(jPasswordFieldPasswordConfirm.getPassword());

                if (password.equals(confirmPassword)) {

                    String email = jTextFieldEmail.getText();
                    String ville = jTextFieldVille.getText();
                    String rue = jTextFieldRue.getText();
                    int numRue = Integer.parseInt(jTextFieldNumRue.getText());
                    String numTel = jTextFieldNumTel.getText();

                    UtilisateurEntity user = new UtilisateurEntity();
                    user.setLogin(email);
                    user.setPassword(password);
                    user.setVille(ville);
                    user.setRue(rue);
                    user.setNumRue(numRue);
                    user.setNumTel(numTel);

                    JpaLocalisationDao localisationDao = new JpaLocalisationDao();
                    JpaUtilisateurDao userDao = new JpaUtilisateurDao();


                    try {
                        user.setIdLocalisationUtilisateur(localisationDao.find(Integer.parseInt(ville)));
                        if (userDao.create(user)) {
                            System.out.println("reussi");
                            dispose();
                        } else
                            System.out.println("echec");

                    } catch (Exception e) {
                        System.out.println("code postal faux");
                    }


                }

            }
        });


        jPanel.add(jTextFieldEmail);
        jPanel.add(jPasswordFieldPassword);
        jPanel.add(jPasswordFieldPasswordConfirm);
        jPanel.add(jTextFieldVille);
        jPanel.add(jTextFieldRue);
        jPanel.add(jTextFieldNumRue);
        jPanel.add(jTextFieldNumTel);
        jPanel.add(jButtonConfirm);

        this.add(jPanel, BorderLayout.CENTER);
    }

}
