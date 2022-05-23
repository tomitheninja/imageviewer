package viewer.imageactions;

import java.awt.image.BufferedImage;

public class GrayScale implements ImageAction {
    @Override
    public BufferedImage performAction(BufferedImage image) {
        // https://stackoverflow.com/a/32111242
        if (image == null) return null;
        int w = image.getWidth();
        int h = image.getHeight();
        byte[] data = new byte[w * h];

        // Create a smooth gradient
        for (int y = 0; y < h; y++) {
            int off = y * w;

            for (int x = 0; x < w; x++) {
                int rgb = image.getRGB(x, y);
                int r = (rgb >> 16) & 0xff;
                int g = (rgb >> 8) & 0xff;
                int b = rgb & 0xff;
                int gray = (r + g + b) / 3;
                data[off + x] = (byte) gray;
            }
        }
        final BufferedImage result = new BufferedImage(w, h, BufferedImage.TYPE_BYTE_GRAY);
        result.getRaster().setDataElements(0, 0, image.getWidth(), image.getHeight(), data);
        return result;
    }
}
