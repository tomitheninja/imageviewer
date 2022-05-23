package viewer.imageactions;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageFlipV implements ImageAction {
    public BufferedImage performAction(BufferedImage image) {
        return Scalr.rotate(image, Scalr.Rotation.FLIP_VERT);
    }
}
