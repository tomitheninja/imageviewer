package viewer.imageactions;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ScaleImage implements ImageAction {

    final double width;
    final double height;

    public ScaleImage(double width, double height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public BufferedImage performAction(BufferedImage image) {
        int w = (int) width * image.getWidth();
        int h = (int) height * image.getHeight();
        return Scalr.resize(image, Scalr.Method.ULTRA_QUALITY, w, h);
    }

}
