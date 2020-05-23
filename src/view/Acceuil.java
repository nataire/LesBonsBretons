package view;

import utils.DesignJPanelUtils;

import javax.swing.*;
import java.awt.*;

public class Acceuil extends JFrame {

    public static int[] orange = new int[]{255, 87, 51};
    public DesignJPanelUtils designJPanelUtils = new DesignJPanelUtils();

    public Acceuil() {

        JPanel jPanelParent = new JPanel();

        JPanel jPanelHeader = new Header();
        jPanelHeader.setPreferredSize(new Dimension(1000, 75));
        jPanelHeader.setBackground(designJPanelUtils.getHSBFromRGB(orange));

        JPanel jpanelBody1 = new Body();
        jpanelBody1.setPreferredSize(new Dimension(1000, 900));

        JPanel jPanelFooter = new Footer();
        jPanelFooter.setPreferredSize(new Dimension(1000, 25));
        jPanelFooter.setBackground(designJPanelUtils.getHSBFromRGB(orange));

        jPanelParent.setLayout(new BorderLayout());
        jPanelParent.add(jPanelHeader, BorderLayout.NORTH);
        jPanelParent.add(jpanelBody1, BorderLayout.CENTER);
        jPanelParent.add(jPanelFooter, BorderLayout.SOUTH);

        this.setContentPane(jPanelParent);
        this.setSize(1000, 1000);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }



}
