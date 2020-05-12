package org.company.ScreenCapture.SystemTray;

import java.awt.*;

public final class PopupMenuBuilder {
    public static final PopupMenu getPopupMenu(String trayName) {
        PopupMenu popupMenu = new PopupMenu(trayName);
        addItem_Settings(popupMenu);
        addSeparator(popupMenu);
        addItem_Exit(popupMenu);
        return popupMenu;
    }

    private static final void addItem_Settings(PopupMenu popupMenu) {
        popupMenu.add(MenuItemBuilder.getItem_Settings(popupMenu.getLabel()));
    }

    private static final void addItem_Exit(PopupMenu popupMenu) {
        popupMenu.add(MenuItemBuilder.getItem_Exit());
    }

    private static final void addSeparator(PopupMenu popupMenu) {
        popupMenu.addSeparator();
    }
}
