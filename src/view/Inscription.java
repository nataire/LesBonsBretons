package view;

import dao.JpaLocalisationDao;
import metier.LocalisationEntity;
import utils.DesignJPanelUtils;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class Inscription extends JDialog {

    public static Dimension componentDimension = new Dimension(300, 50);
    public static int[] orange = new int[]{255, 87, 51};
    public static int[] grayLight = new int[]{215, 219, 211};
    public static Font font = new Font("Comic Sans Ms", Font.BOLD + Font.ITALIC, 12);
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();
    private JLabel jLabelTitle;
    private JLabel[] labels;
    private JComponent[] components;
    private JButton jButtonConfirmer;
    private JPanel jPanel;

    public Inscription(Frame owner, boolean modal) {
        super(owner, modal);

        setComponent();
        showComponent();

        this.setContentPane(jPanel);
        this.setTitle("Inscription");
        this.setSize(new Dimension(500, 700));
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    private void setComponent() {
        jLabelTitle = new JLabel("Rentrer les informations de votre nouveau compte");

        JLabel jLabelEmail = new JLabel("E-mail :");
        JLabel jLabelPassword = new JLabel("Mot de passe :");
        JLabel jLabelPasswordConfirm = new JLabel("Confirmer le mot de passe :");
        JLabel jLabelCodePostal = new JLabel("Code postal :");
        JLabel jLabelVille = new JLabel("Ville :");
        JLabel jLabelRue = new JLabel("Rue :");
        JLabel jLabelNumRue = new JLabel("Numéro dans la rue :");
        JLabel jLabelNumTel = new JLabel("Numéro de téléphone :");
        labels = new JLabel[]{
                jLabelEmail, jLabelPassword, jLabelPasswordConfirm, jLabelCodePostal,
                jLabelVille, jLabelRue, jLabelNumRue, jLabelNumTel
        };

        JTextField jTextFieldEmail = new JTextField();
        JPasswordField jPasswordFieldPassword = new JPasswordField();
        JPasswordField jPasswordFieldPasswordConfirm = new JPasswordField();
        JTextField jTextFieldCodePostal = new JTextField();
        JComboBox<LocalisationEntity> jComboBoxLocalisation = new JComboBox<>();
        JTextField jTextFieldRue = new JTextField();
        JTextField jTextFieldNumRue = new JTextField();
        JTextField jTextFieldNumTel = new JTextField();
        components = new JComponent[]{
                jTextFieldEmail, jPasswordFieldPassword, jPasswordFieldPasswordConfirm, jTextFieldCodePostal,
                jComboBoxLocalisation, jTextFieldRue, jTextFieldNumRue, jTextFieldNumTel
        };

        jTextFieldCodePostal.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                JpaLocalisationDao jpaLocalisationDao = new JpaLocalisationDao();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {

            }

            @Override
            public void changedUpdate(DocumentEvent e) {

            }
        });

        jButtonConfirmer = new JButton("Confirmer l'inscription");
    }

    private void showComponent() {
        jPanel = new JPanel();
        jPanel.setLayout(new GridBagLayout());

        designJPanelUtils.addComponent(jPanel, jLabelTitle, 0, 0, 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, null, null, null, null, null, null);

        for (int i = 0; i < labels.length; i++) {
            designJPanelUtils.addComponent(jPanel, labels[i], 0, (i * 2) + 1, 1, 1, 1d, 0.01, GridBagConstraints.LINE_START, GridBagConstraints.BASELINE, 0, 32, 8, 0, null, null);
            designJPanelUtils.addComponent(jPanel, components[i], 0, (i * 2) + 2, 1, 1, 1d, 0.01, GridBagConstraints.CENTER, GridBagConstraints.HORIZONTAL, 0, 48, 16, 48, null, null);
        }

        designJPanelUtils.addComponent(jPanel, jButtonConfirmer, 0, (labels.length * 2) + 1, 1, 1, 1d, 1d, GridBagConstraints.CENTER, GridBagConstraints.BASELINE, null, null, null, null, null, null);

    }

}
