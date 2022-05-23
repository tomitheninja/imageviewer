package viewer.imageactions;

import java.awt.image.BufferedImage;

public interface ImageAction {
    BufferedImage performAction(BufferedImage image);
}
