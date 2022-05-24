package viewer.fileformatum;

import javafx.stage.FileChooser;

import java.util.Arrays;

public abstract class FileFormatum {
    public static String[] getExtensions() {
        return new String[]{new Png().getExtension(), new Jpg().getExtension(), new Jpeg().getExtension(),};
    }

    public static FileChooser.ExtensionFilter getExtensionFilter() {
        return new FileChooser.ExtensionFilter("Image files", Arrays.stream(FileFormatum.getExtensions()).map(s -> "*." + s).toArray(String[]::new));
    }

    public abstract String getExtension();
}
