package org.company.ScreenCapture.Frames;

import org.company.ScreenCapture.File.FileManager;
import org.company.ScreenCapture.UserSettings.UserSettingsManager;

import javax.swing.*;

public final class TextFieldsBuilder {
    public static final JTextField tfPath() {
        return new JTextField(FileManager.canonicalPath(UserSettingsManager.getPath()), 50);
    }
}
