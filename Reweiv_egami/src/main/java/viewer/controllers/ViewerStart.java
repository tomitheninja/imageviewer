package viewer.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class ViewerStart extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(ViewerStart.class.getResource("viewer.fxml"));
        //double width = Screen.getPrimary().getBounds().getWidth();
        Scene scene = new Scene(fxmlLoader.load(), 1280, 720);
        stage.setTitle("Reweiv egami");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}