package viewer.imageactions;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ResizeImage implements ImageAction {

    final int width;
    final int height;

    public ResizeImage(int width, int height) {
        this.width = Math.max(width, 0);
        this.height = Math.max(height, 0);
    }

    @Override
    public BufferedImage performAction(BufferedImage image) {
        return Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, width, height);
    }

}
