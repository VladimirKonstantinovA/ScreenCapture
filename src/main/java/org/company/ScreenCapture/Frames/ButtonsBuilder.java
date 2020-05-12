package org.company.ScreenCapture.Frames;

import javax.swing.*;

public final class ButtonsBuilder {
    public static final JButton bExit(JFrame owner) {
        JButton button = new JButton("Close");
        try {
            button.addActionListener(ActionListenerBuilder.alExit(owner));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return button;
    }

    public static final JButton bSave(JTextField tfPath) {
        JButton button = new JButton("Save");
        try {
            button.addActionListener(ActionListenerBuilder.alSave(tfPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return button;
    }

    public static final JButton bChoosePath(JFrame owner, JTextField tfPath) {
        JButton button = new JButton("Choose path...");
        try {
            button.addActionListener(ActionListenerBuilder.alChoosePath(owner, tfPath));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return button;
    }
}
