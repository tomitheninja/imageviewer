package viewer.services;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import viewer.fileformatum.FileFormatum;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImageIOService {
    private final Stage stage;
    public File file;

    public ImageIOService(Stage stage) {
        this.stage = stage;
    }

    public boolean askOpenFileLocation() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open File");
        fileChooser.getExtensionFilters().add(FileFormatum.getExtensionFilter());
        if (file != null) {
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        File newFile = fileChooser.showOpenDialog(stage);
        if (newFile == null) return false;
        this.file = newFile;
        return true;
    }

    public boolean delete() {
        try {
            if (file.delete()) file = null;
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean askSaveFileLocation() {
        final FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save File");
        fileChooser.getExtensionFilters().add(FileFormatum.getExtensionFilter());
        if (file != null) {
            fileChooser.setInitialFileName(file.getName());
            fileChooser.setInitialDirectory(file.getParentFile());
        }
        File newFile = fileChooser.showSaveDialog(stage);
        if (newFile == null) return false;
        this.file = newFile;
        return true;
    }

    public boolean saveImage(BufferedImage image) throws IOException {
        String path = file.getPath();
        String extension = path.substring(path.lastIndexOf('.') + 1);
        return ImageIO.write(image, extension, file);
    }

    public BufferedImage loadImage() throws IOException {
        return ImageIO.read(file);
    }
}
