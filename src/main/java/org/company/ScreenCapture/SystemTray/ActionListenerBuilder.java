package org.company.ScreenCapture.SystemTray;

import org.company.ScreenCapture.Frames.SettingsDialog;
import org.company.ScreenCapture.Listener.ListenerManager;

import java.awt.event.ActionListener;

public final class ActionListenerBuilder {
    public static final ActionListener al_Exit() {
        return e -> { ListenerManager.disable();
            System.exit(0);
        };
    }

    public static final ActionListener al_Settings(String title) {
        return e -> new SettingsDialog(title + " settings");
    }
}
