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

        JPanel jPanel = new JPanel(new GridBagLayout());

        this.setTitle("Inscription");
        this.setSize(1000, 400);

        JLabel jLabelEmail = new JLabel("E-Mail :");
        JLabel jLabelPassword = new JLabel("Mot de passe :");
        JLabel jLabelPasswordConfirm = new JLabel("Confirmer le mot de passe :");
        JLabel jLabelVille = new JLabel("Ville :");
        JLabel jLabelRue = new JLabel("Rue :");
        JLabel jLabelNumRue = new JLabel("Numéro dans la rue :");
        JLabel jLabelNumTel = new JLabel("Numéro de téléphone :");
        JLabel[] arrayLabel = {
                jLabelEmail, jLabelPassword, jLabelPasswordConfirm,
                jLabelVille, jLabelRue, jLabelNumRue, jLabelNumTel
        };

        JTextField jTextFieldEmail = new JTextField();
        JPasswordField jTextFieldPassword = new JPasswordField();
        JPasswordField jTextFieldPasswordConfirm = new JPasswordField();
        JTextField jTextFieldVille = new JTextField();
        JTextField jTextFieldRue = new JTextField();
        JTextField jTextFieldNumRue = new JTextField();
        JTextField jTextFieldNumTel = new JTextField();
        JTextField[] arrayTextField = {
                jTextFieldEmail, jTextFieldPassword, jTextFieldPasswordConfirm,
                jTextFieldVille, jTextFieldRue, jTextFieldNumRue, jTextFieldNumTel
        };

        JLabel jLabelTitle = new JLabel("Inscrivez vous içi");

        JButton jButton = new JButton("Inscription");

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                String password = new String(jTextFieldPassword.getPassword());
                String confirmPassword = new String(jTextFieldPasswordConfirm.getPassword());

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


        GridBagConstraints gridBagConstraints = new GridBagConstraints();
        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;

        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new Insets(0, 200, 32, 320);
        gridBagConstraints.anchor = GridBagConstraints.CENTER;
        jPanel.add(jLabelTitle, gridBagConstraints);

        for (int y = 0; y < arrayLabel.length; y++) {
            for (int x = 0; x < 2; x++) {
                gridBagConstraints.gridx = x;
                gridBagConstraints.gridy = y + 1;
                if (x == 0) {
                    gridBagConstraints.insets = new Insets(0, 32, 8, 16);
                    gridBagConstraints.weightx = 0.10;
                    jPanel.add(arrayLabel[y], gridBagConstraints);
                } else {
                    gridBagConstraints.insets = new Insets(0, 16, 8, 32);
                    gridBagConstraints.weightx = 0.20;
                    jPanel.add(arrayTextField[y], gridBagConstraints);
                }
            }
        }

        gridBagConstraints.fill = GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = GridBagConstraints.LINE_END;
        gridBagConstraints.insets = new Insets(0, 128, 0, 320);
        gridBagConstraints.weightx = 0.10;
        gridBagConstraints.gridy++;

        jPanel.add(jButton, gridBagConstraints);

        this.setContentPane(jPanel);
        this.setVisible(true);


    }

}
