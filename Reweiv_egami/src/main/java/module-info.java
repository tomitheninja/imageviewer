module viewer.viewer {
    requires javafx.controls;
    requires javafx.fxml;


    opens viewer.controllers to javafx.fxml;
    exports viewer.controllers;
    exports viewer;
    opens viewer to javafx.fxml;

}