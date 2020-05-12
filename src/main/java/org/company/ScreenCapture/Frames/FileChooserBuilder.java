package org.company.ScreenCapture.Frames;

import org.company.ScreenCapture.UserSettings.UserSettingsManager;

import javax.swing.*;

public final class FileChooserBuilder {
    public static final JFileChooser fcPathChooser() {
        return new JFileChooser(UserSettingsManager.getPath());
    }
}
