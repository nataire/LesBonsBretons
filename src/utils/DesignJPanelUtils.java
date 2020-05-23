package utils;

import javax.swing.*;
import java.awt.*;

public class DesignJPanelUtils {

    public Color getHSBFromRGB(int[] color) {
        float[] hsb = new float[3];
        Color.RGBtoHSB(color[0], color[1], color[2], hsb);
        // brightness
        hsb[2] *= 1f;
        // saturation
        hsb[1] *= 1f;
        return Color.getHSBColor(hsb[0], hsb[1], hsb[2]);
    }

    public void addComponent(JPanel jPanel, JComponent jComponent,
                             int gridx, int gridy, Integer gridwith, Integer gridheight,
                             Double weightx, Double weighty,
                             Integer anchor, Integer fill,
                             Integer insets_top, Integer insets_left, Integer insets_bottom, Integer inserts_right,
                             Integer ipadx, Integer ipady
    ) {
        GridBagConstraints gridBagConstraints = new GridBagConstraints();

        gridBagConstraints.gridx = gridx;
        gridBagConstraints.gridy = gridy;

        if (gridwith != null) gridBagConstraints.gridwidth = gridwith;
        if (gridheight != null) gridBagConstraints.gridheight = gridheight;
        if (weightx != null) gridBagConstraints.weightx = weightx;
        if (weighty != null) gridBagConstraints.weighty = weighty;
        if (anchor != null) gridBagConstraints.anchor = anchor;
        if (fill != null) gridBagConstraints.fill = fill;

        if (insets_top != null && insets_left != null && insets_bottom != null && inserts_right != null) {
            gridBagConstraints.insets = new Insets(insets_top, insets_left, insets_bottom, inserts_right);
        }

        if (ipadx != null) gridBagConstraints.ipadx = ipadx;
        if (ipady != null) gridBagConstraints.ipady = ipady;

        jPanel.add(jComponent, gridBagConstraints);
    }

}
