package org.company.ScreenCapture.Frames;

import org.company.ScreenCapture.File.FileManager;
import org.company.ScreenCapture.UserSettings.UserSettingsManager;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public final class ActionListenerBuilder {
    public static final ActionListener alExit(Frame ownerFrame) {
        return e -> {
            ownerFrame.setVisible(false);
            ownerFrame.dispose();
        };
    }

    public static final ActionListener alSave(JTextField tfPath) {
        return e -> {
            String path = tfPath.getText();
            if (!FileManager.isValidPath(path)) {
                JOptionPane.showMessageDialog(null, "Invalid path!");
                return;
            }
            UserSettingsManager.setPath(FileManager.canonicalPath(path));
        };
    }

    public static final ActionListener alChoosePath(Frame ownerFrame, JTextField tfPath) {
        return e -> {
            JFileChooser fcPathChooser = FileChooserBuilder.fcPathChooser();
            fcPathChooser.setDialogTitle("Save screenshots to...");
            fcPathChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fcPathChooser.setAcceptAllFileFilterUsed(false);
            if (fcPathChooser.showOpenDialog(ownerFrame)==JFileChooser.APPROVE_OPTION) {
                String path = FileManager.canonicalPath(fcPathChooser.getSelectedFile().getPath());
                tfPath.setText(path);
            }
        };
    }
}
