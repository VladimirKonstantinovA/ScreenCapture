package org.company.ScreenCapture.Images;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Objects;

public final class ImageManager {
    private static final String trayIconResource = "org/company/ScreenCapture/Images/TrayIcon.jpg";

    public static final Image getAppImage() throws IOException {
        return ImageIO.read(Objects.requireNonNull(Thread.currentThread().getContextClassLoader().getResourceAsStream(trayIconResource)));
    }

    public static final BufferedImage toBufferedImage(Image img)
    {
        if (img instanceof BufferedImage)
        {
            return (BufferedImage) img;
        }
        BufferedImage biImage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
        Graphics2D bGr = biImage.createGraphics();
        bGr.drawImage(img, 0, 0, null);
        bGr.dispose();
        return biImage;
    }
}
