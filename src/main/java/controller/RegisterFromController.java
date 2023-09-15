package controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class RegisterFromController {
    public AnchorPane page;

    public void registerOnAction(ActionEvent actionEvent) {

    }

    public void faceScaneOnAction(MouseEvent mouseEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viwe/face/BarcodeRead.fxml"));
        Parent load = fxmlLoader.load();
        stage.setScene(new Scene(load));
        face controller = fxmlLoader.getController();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.initOwner(page.getScene().getWindow());
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent windowEvent) {
                controller.getService().cancel();
            }
        });
        stage.show();
    }

    public void back(MouseEvent mouseEvent) throws IOException {
        page.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/login_from.fxml"))));
        stage.centerOnScreen();
        stage.show();

    }
}
