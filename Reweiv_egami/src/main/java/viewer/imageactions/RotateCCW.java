package viewer.imageactions;

import org.imgscalr.Scalr;

import java.awt.image.BufferedImage;

public class RotateCCW implements ImageAction {
    public BufferedImage performAction(BufferedImage image) {
        return Scalr.rotate(image, Scalr.Rotation.CW_270);
    }
}
