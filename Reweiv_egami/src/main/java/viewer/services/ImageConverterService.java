package viewer.services;

import javafx.scene.image.ImageView;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.image.WritablePixelFormat;

import java.awt.image.BufferedImage;
import java.nio.IntBuffer;

public class ImageConverterService {
    public javafx.scene.image.Image fromBufferedImage(BufferedImage image) {
        // https://stackoverflow.com/a/57552025
        WritableImage wr = null;
        if (image != null) {
            wr = new WritableImage(image.getWidth(), image.getHeight());
            PixelWriter pw = wr.getPixelWriter();
            for (int x = 0; x < image.getWidth(); x++) {
                for (int y = 0; y < image.getHeight(); y++) {
                    pw.setArgb(x, y, image.getRGB(x, y));
                }
            }
        }

        return new ImageView(wr).getImage();
    }

    public BufferedImage fromFxImage(javafx.scene.image.Image image) {
        // https://stackoverflow.com/a/72114722
        int width = (int) image.getWidth();
        int height = (int) image.getHeight();
        int[] pixels = new int[width * height];

        // Load the image's data into an array
        // You need to MAKE SURE the image's pixel format is compatible with IntBuffer
        image.getPixelReader().getPixels(0, 0, width, height, (WritablePixelFormat<IntBuffer>) image.getPixelReader().getPixelFormat(), pixels, 0, width);

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // There may be better ways to do this
                // You'll need to make sure your image's format is correct here
                var pixel = pixels[y * width + x];
                int r = (pixel & 0xFF0000) >> 16;
                int g = (pixel & 0xFF00) >> 8;
                int b = (pixel & 0xFF);

                bufferedImage.getRaster().setPixel(x, y, new int[]{r, g, b});
            }
        }
        return bufferedImage;
    }
}
