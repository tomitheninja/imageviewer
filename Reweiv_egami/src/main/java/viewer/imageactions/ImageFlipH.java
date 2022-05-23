package viewer.imageactions;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class ImageFlipH implements ImageAction {
    @Override
    public BufferedImage performAction(BufferedImage image) {
        return Scalr.rotate(image, Scalr.Rotation.FLIP_HORZ);
    }
}
