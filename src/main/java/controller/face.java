package controller;

import com.github.sarxos.webcam.Webcam;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import util.webCam.WebCamView;
import util.webCam.WebcamService;

public class face {
    public Rectangle main;
    public Rectangle second;
    @FXML
    private AnchorPane pane;

    @FXML
    private ImageView imageView;


    @FXML
    private JFXButton btnStart;

    @FXML
    private JFXButton btnStop;
    private WebcamService service;


    @FXML
    void startBtnOnAction(ActionEvent event) {
        service.restart();

        btnStart.setDisable(true);
    }

    @FXML
    void stopBtnOnAction(ActionEvent event) {
        service.cancel();

        btnStart.setDisable(false);
    }

    public void initialize() {

        Webcam cam = Webcam.getWebcams().get(0);
        service = new WebcamService(cam);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        WebCamView view = new WebCamView(service, imageView);
        pane.getChildren().add(view.getView());

        service.progressProperty().addListener((a, b, c) -> {
            String s = String.valueOf(c);
            if (s.equals("1.0")) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(c);
                service.cancel();
                service.getT1().stop();
                imageView.getScene().getWindow().hide();
                String readBarCodeId = service.getReadBarCodeId();
            }
            second.setWidth(main.getWidth() * c.doubleValue());
        });
        startRead();
    }

    private void startRead() {
        service.restart();
        //progress.setVisible(true);
        btnStart.setDisable(true);
    }

    public WebcamService getService() {
        return service;
    }


}
