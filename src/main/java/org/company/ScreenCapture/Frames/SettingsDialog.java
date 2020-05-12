package org.company.ScreenCapture.Frames;

import javax.swing.*;
import java.awt.*;

public final class SettingsDialog extends JFrame {

    public SettingsDialog(String title) {
        super(title);
        setupDialog();
    }

    public final void setupDialog() {
        setFramePrefferedSize();
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        centeredFrame();

        JTextField tfPath;
        JButton bChoosePath;
        JButton bSave;
        JButton bExit;
        try {
            tfPath = TextFieldsBuilder.tfPath();
            bChoosePath = ButtonsBuilder.bChoosePath(this, tfPath);
            bSave = ButtonsBuilder.bSave(tfPath);
            bExit = ButtonsBuilder.bExit(this);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        JPanel panel = new JPanel();
        panel.add(tfPath);
        panel.add(bChoosePath);
        panel.add(bSave);
        panel.add(bExit);
        getContentPane().add(panel);
        setResizable(false);
        pack();
        setVisible(true);
    }

    public final void centeredFrame() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }

    public final void setFramePrefferedSize() {
        setSize(450, 200);
    }
}
