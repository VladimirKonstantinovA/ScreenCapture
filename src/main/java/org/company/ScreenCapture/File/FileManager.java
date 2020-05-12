package org.company.ScreenCapture.File;

import org.company.ScreenCapture.Images.ImageManager;
import org.company.ScreenCapture.UserSettings.UserSettingsManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class FileManager {
    private static final String imageFilePrefix = "ScreenCapture_screenshot_";
    private static final String imageFileNameFormat = "yyyMMdd_hhmmss";
    private static final String imageFileExtension = "jpg";

    public static final String saveImage(Image image) throws IOException {
        BufferedImage bufferedImage = ImageManager.toBufferedImage(image);
        String pathForImage = getDestinationForImage();
        File file = new File(pathForImage);
        ImageIO.write(bufferedImage, imageFileExtension, file);
        return pathForImage;
    }

    private static final String getDestinationForImage() {
        String fileName = getFileName();
        return canonicalPath(getDestinationPath()
                .concat("/")
                .concat(fileName));
    }

    private static final String getDestinationPath() {
        return UserSettingsManager.getPath();
    }

    private static final String getFileName() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(imageFileNameFormat);
        return imageFilePrefix
                .concat("_")
                .concat(simpleDateFormat.format(new Date()))
                .concat(".")
                .concat(imageFileExtension);
    }

    public static final Boolean isValidPath(String path) {
        String canonicalPath = canonicalPath(path);
        return canonicalPath != null;
    }

    public static final String canonicalPath(String path) {
        File file = new File(path);
        try {
            if (!file.isDirectory() && !file.isFile() && !file.mkdir()) return null;
            return file.getCanonicalPath();
        } catch (IOException e) {
            return null;
        }
    }
}
