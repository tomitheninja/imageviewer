package viewer.controllers;

import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import viewer.ViewerStart;
import viewer.muveletek.Betoltes;

import java.net.MalformedURLException;
import java.net.URL;

public class ViewerController {
    public ViewerController() throws MalformedURLException {
    }

    @FXML
    protected void btnKilepesClick() {
        System.exit(0);
    }
    @FXML
    protected void btnMegnyitClick() {
        //TODO
    }
    @FXML
    protected void btnMentesMaskentClick() {
        //TODO
    }
    @FXML
    protected void btnForgatBalraClick() throws MalformedURLException{
        Image img = new Image("https://i2.wp.com/mora.u-szeged.hu/wp-content/uploads/2018/07/IMG_9366.jpg?fit=491736&ssl=1");
        ViewerStart.imgv.setImage(img);
    }
    @FXML
    protected void btnTukrozesClick() {
        //TODO
    }
    @FXML
    protected void btnForgatJobbraClick() {
        //TODO
    }
    @FXML
    protected void btnKicsinyitClick() {
        //TODO
    }
    @FXML
    protected void btnSzurkearnyalatClick() {
        //TODO
    }
    @FXML
    protected void btnNagyitClick() {
        //TODO
    }







}