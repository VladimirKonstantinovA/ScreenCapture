package org.company.ScreenCapture.Screenshot;

import org.company.ScreenCapture.File.FileManager;

import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

public final class ScreenshotManager {

    public static final String screenshot() throws IOException {
        Image image = null;
        try {
            image = getImage();
        } catch (UnsupportedFlavorException e) {
            e.printStackTrace();
        }
        if (image == null) throw new IOException("Unable get screenshot!");
        return FileManager.saveImage(image);
    }

    private static final Image getImage() throws IOException, UnsupportedFlavorException {
        Transferable t = Toolkit.getDefaultToolkit().getSystemClipboard().getContents(null);
        return (Image) t.getTransferData(DataFlavor.imageFlavor);
    }
}
