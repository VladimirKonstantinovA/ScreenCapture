package org.company.ScreenCapture.UserSettings;

import org.company.ScreenCapture.File.FileManager;

import java.util.prefs.Preferences;

public class UserSystemPreferences {
    private static final String PREF_PATH = "ScreenshotsPath";

    private static final Preferences userNodePackage() {
        return Preferences.userNodeForPackage(org.company.ScreenCapture.App.class);
    }

    public static final String getPath() {
        String defaultPath = UserSettingsManager.getDefaultPath();
        Preferences preferences = userNodePackage();
        return FileManager.canonicalPath(preferences.get(PREF_PATH, defaultPath));
    }

    public static final void setPath(String path) {
        if (path.equals("")) return;
        Preferences preferences = userNodePackage();
        preferences.put(PREF_PATH, path);
    }
}
