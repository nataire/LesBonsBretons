
package UI;

import dao.JpaUtilisateurDao;
import metier.UtilisateurEntity;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Inscription extends JDialog implements ActionListener {

    public JTextField jTextFieldEmail;
    public JPasswordField jPasswordFieldPassword;
    public JPasswordField jPasswordFieldPasswordConfirm;
    public JButton jButtonConfirm;

    public Inscription(Frame owner, boolean modal) {
        super(owner, modal);

        this.setSize(1920, 1080);
        this.setLayout(new BorderLayout());

        JPanel jPanel = new JPanel();

        jTextFieldEmail = new JTextField();
        jTextFieldEmail.setPreferredSize(new Dimension(500, 50));

        jPasswordFieldPassword = new JPasswordField();
        jPasswordFieldPassword.setPreferredSize(new Dimension(500, 50));

        jPasswordFieldPasswordConfirm = new JPasswordField();
        jPasswordFieldPasswordConfirm.setPreferredSize(new Dimension(500, 50));

        jButtonConfirm = new JButton("Confirmer");
        jButtonConfirm.setPreferredSize(new Dimension(500, 50));
        jButtonConfirm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String password = jPasswordFieldPassword.getPassword().toString();
                String confirmPassword = jPasswordFieldPassword.getPassword().toString();

                if (password.equals(confirmPassword)) {

                    String email = jTextFieldEmail.getText();
                    UtilisateurEntity user = new UtilisateurEntity();
                    user.setLogin(email);
                    user.setPassword(password);
                    JpaUtilisateurDao userDao = new JpaUtilisateurDao();
                    userDao.inscriptionUser(user);

                }

            }
        });


        jPanel.add(jTextFieldEmail);
        jPanel.add(jPasswordFieldPassword);
        jPanel.add(jPasswordFieldPasswordConfirm);
        jPanel.add(jButtonConfirm);

        this.add(jPanel, BorderLayout.CENTER);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {

        String password = jPasswordFieldPassword.getPassword().toString();
        String confirmPassword = jPasswordFieldPassword.getPassword().toString();

        if (password.equals(confirmPassword)) {

            String email = jTextFieldEmail.getText();
            UtilisateurEntity user = new UtilisateurEntity();
            user.setLogin(email);
            user.setPassword(password);

            this.setVisible(false);
            this.dispose();

            JpaUtilisateurDao userDao = new JpaUtilisateurDao();
            if (true) {
                dispose();
            }
        }
    }
}
