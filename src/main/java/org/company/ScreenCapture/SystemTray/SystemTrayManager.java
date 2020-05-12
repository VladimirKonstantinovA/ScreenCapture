package org.company.ScreenCapture.SystemTray;

import org.company.ScreenCapture.Images.ImageManager;
import org.company.ScreenCapture.Listener.ListenerManager;

import java.awt.*;
import java.io.IOException;

public final class SystemTrayManager {
    private static final String trayName = "Screen capture";

    public static final void init() {
        if (!SystemTray.isSupported()) {
            System.out.println("SystemTray is not supported!");
            return;
        }
        SystemTray systemTray = SystemTray.getSystemTray();
        TrayIcon trayIcon = getTrayIcon();
        if (trayIcon ==null) {
            System.out.println("Error setup tray icon!");
            return;
        }
        try {
            systemTray.add(trayIcon);
            trayIcon.displayMessage(trayIcon.getToolTip(), trayName + " activated", TrayIcon.MessageType.INFO);
        } catch (AWTException e) {
            e.printStackTrace();
            return;
        }

        ListenerManager.enable(trayIcon);
    }

    private static final TrayIcon getTrayIcon() {
        Image image;
        try {
            image = ImageManager.getAppImage();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        PopupMenu popupMenu = getPopupMenu();
        try {
            TrayIcon trayIcon = new TrayIcon(image, trayName, popupMenu);
            trayIcon.setImageAutoSize(true);
            return trayIcon;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static final PopupMenu getPopupMenu() {
        return PopupMenuBuilder.getPopupMenu(trayName);
    }
}
