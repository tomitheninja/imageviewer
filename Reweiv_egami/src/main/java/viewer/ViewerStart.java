package viewer;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;



public class ViewerStart extends Application {
    @FXML
    public static ImageView imgv;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewerStart.class.getResource("fxmls/Viewer.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Reweiv egami");
        stage.setScene(scene);
        imgv = (ImageView) scene.lookup("#imgv");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}