package org.company.ScreenCapture.Listener;

import org.company.ScreenCapture.Screenshot.ScreenshotManager;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class ListenerManager {
    private static TrayIcon trayIcon;

    public static final void enable(TrayIcon ti) {
        trayIcon = ti;
        try {
            Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
            logger.setLevel(Level.OFF);
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            ex.printStackTrace();
        }
        GlobalScreen.addNativeKeyListener(new NativeKeyListener()
        {
            @Override
            public void nativeKeyReleased(NativeKeyEvent nativeEvent)
            {
                if (nativeEvent.getKeyCode() == NativeKeyEvent.VC_PRINTSCREEN) {
                    try {
                        String pathToImage = ScreenshotManager.screenshot();
                        trayIcon.displayMessage(trayIcon.getToolTip(), "Screenshot saved to: " + pathToImage, TrayIcon.MessageType.INFO);
                    } catch (IOException e) {
                        e.printStackTrace();
                        trayIcon.displayMessage(trayIcon.getToolTip(), "Error create and save screenshot!", TrayIcon.MessageType.ERROR);
                    }
                }
            }

            @Override
            public void nativeKeyTyped(NativeKeyEvent nativeEvent)
            {
            }

            @Override
            public void nativeKeyPressed(NativeKeyEvent nativeEvent)
            {
            }
        });

    }

    public static final void disable() {
        try {
            GlobalScreen.unregisterNativeHook();
        } catch (NativeHookException e) {
            e.printStackTrace();
        }
    }
}
