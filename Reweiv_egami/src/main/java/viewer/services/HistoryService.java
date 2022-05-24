package viewer.services;

import java.awt.image.BufferedImage;

public class HistoryService {
    protected BufferedImage[] history = new BufferedImage[15];

    public void push(BufferedImage image) {
        System.arraycopy(history, 0, history, 1, 14);
        history[0] = image;
    }

    public BufferedImage pop() {
        BufferedImage image = history[0];
        System.arraycopy(history, 1, history, 0, 14);
        return image;
    }

    public BufferedImage latest() {
        return history[0];
    }

    public void clear() {
        history = new BufferedImage[15];
    }
}
