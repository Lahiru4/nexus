package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardFormController implements Initializable {
    public AnchorPane lode_page;
    public JFXButton dashboardBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        dashboardBtn.getStyleClass().remove("defolt_button");
        dashboardBtn.getStyleClass().add("select_button");
        Node node= null;
        try {
            node = FXMLLoader.load(getClass().getResource("/viwe/homePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    public void btnDashbordOnAction(ActionEvent actionEvent) throws IOException {
        Node node= FXMLLoader.load(getClass().getResource("/viwe/homePage.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    public void btnMangeEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        Node node= FXMLLoader.load(getClass().getResource("/viwe/employeedetails_form.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    public void btnMangeInstrumentOnAction(ActionEvent actionEvent) {

    }

    public void btnCenterWiseDataOnAction(ActionEvent actionEvent) {

    }

    public void btnMyProfileOnAction(ActionEvent actionEvent) {

    }
}
