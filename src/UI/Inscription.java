package UI;

import javax.swing.*;

public class Inscription {
    private JButton validerButton;
    private JPanel panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;

    public static void main(final String[] args) throws Exception {
        JFrame frame = new JFrame("Test");
        frame.setContentPane(new Inscription().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here

    }

    private void $$$setupUI$$$() {
        createUIComponents();
      /*  inscriptionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame inscritpion = new JFrame("Inscription");
                new Inscription();
            }
        });
        Annonce.addAll(JpaAnnconce.findAll());*/
    }
}
