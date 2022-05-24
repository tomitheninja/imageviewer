package viewer.controllers;

import javafx.fxml.FXML;
import viewer.ViewerStart;
import viewer.imageactions.*;
import viewer.services.HistoryService;
import viewer.services.ImageConverterService;
import viewer.services.ImageIOService;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class ViewerController {
    ImageIOService fileService;
    HistoryService history = new HistoryService();
    ImageConverterService converterService = new ImageConverterService();
    private BufferedImage img;

    public ViewerController() {
        fileService = new ImageIOService(ViewerStart.stage);
    }

    public BufferedImage getImage() {
        return img;
    }

    public void setImage(BufferedImage img) {
        this.img = img;
        var result = converterService.fromBufferedImage(img);
        ViewerStart.imgv.setImage(result);
    }

    public void performAction(ImageAction action) {
        BufferedImage img = getImage();
        if (img != null) {
            history.push(img);
            setImage(action.performAction(img));
        }
    }

    @FXML
    protected void btnKilepesClick() {
        System.exit(0);
    }

    @FXML
    protected void btnMegnyitClick() {
        try {
            if (fileService.askOpenFileLocation()) {
                history.clear();
                setImage(fileService.loadImage());
                history.push(img);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void btnMentesMaskentClick() {
        try {
            if (fileService.askSaveFileLocation()) fileService.saveImage(img);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void btnForgatBalraClick() {
        performAction(new RotateCCW());
    }

    @FXML
    protected void btnTukrozesClick() {
        performAction(new ImageFlipH());
    }

    @FXML
    protected void btnForgatJobbraClick() {
        performAction(new RotateCW());
    }


    @FXML
    protected void btnSzurkearnyalatClick() {
        performAction(new GrayScale());
    }

    @FXML
    protected void btnVisszavonClick() {
        setImage(history.pop());
    }

    @FXML
    protected void btnTorolClick() {
        fileService.delete();
        history.clear();
    }
}