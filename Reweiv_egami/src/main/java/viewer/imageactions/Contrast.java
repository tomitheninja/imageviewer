package viewer.imageactions;

import java.awt.image.BufferedImage;

public class Contrast implements ImageAction {
    private final double dContrast;

    public Contrast(int dContrast) {
        this.dContrast = dContrast;
    }

    @Override
    public BufferedImage performAction(BufferedImage image) {
        // https://stackoverflow.com/a/32111242
        if (image == null) return null;
        int w = image.getWidth();
        int h = image.getHeight();
        byte[] data = new byte[w * h * 3];

        // Create a smooth gradient
        int off = 0;
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                byte rb = (byte) Math.min(Math.max(r + r * dContrast, 0), 255);
                byte gb = (byte) Math.min(Math.max(g + r * dContrast, 0), 255);
                byte bb = (byte) Math.min(Math.max(b + r * dContrast, 0), 255);
                data[off++] = rb;
                data[off++] = gb;
                data[off++] = bb;
            }
        }
        final BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        result.getRaster().setDataElements(0, 0, image.getWidth(), image.getHeight(), data);
        return result;
    }
}
