package org.company.ScreenCapture.SystemTray;

import java.awt.*;

public final class MenuItemBuilder {
    public static final String mi_Settings = "Settings";
    public static final String mi_Exit = "Exit";

    public static final MenuItem getItem_Settings(String title) {
        MenuItem menuItem = new MenuItem(mi_Settings);
        menuItem.addActionListener(ActionListenerBuilder.al_Settings(title));
        return menuItem;
    }

    public static final MenuItem getItem_Exit() {
        MenuItem menuItem = new MenuItem(mi_Exit);
        menuItem.addActionListener(ActionListenerBuilder.al_Exit());
        return menuItem;
    }
}
