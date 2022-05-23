module viewer.viewer {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens viewer.controllers to javafx.fxml;
    exports viewer.controllers;
    exports viewer;
    opens viewer to javafx.fxml;

}