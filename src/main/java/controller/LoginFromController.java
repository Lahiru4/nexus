package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginFromController implements Initializable {

    public AnchorPane page;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


    public void loginOnAction(ActionEvent actionEvent) throws IOException {
       /* page.getChildren().clear();
        Stage stage = (Stage) page.getScene().getWindow();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viwe/Dashboard_Forme.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.centerOnScreen();*/
        page.getScene().getWindow().hide();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/Dashboard_Forme.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }

    public void forgetOnAction(MouseEvent mouseEvent) {

    }

    public void registerOnAction(MouseEvent mouseEvent) {

    }
}
