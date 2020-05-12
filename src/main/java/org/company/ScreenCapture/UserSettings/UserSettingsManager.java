package org.company.ScreenCapture.UserSettings;

import org.company.ScreenCapture.File.FileManager;

public final class UserSettingsManager {

    public static final String getDefaultPath() {
        return FileManager.canonicalPath("C:/");
    }

    public static final String getPath() {
        return UserSystemPreferences.getPath();
    }

    public static final void setPath(String path) {
        UserSystemPreferences.setPath(FileManager.canonicalPath(path));
    }
}
