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
    public JFXButton employeeBtn;
    public JFXButton manageInstrumentBtn;
    public JFXButton center_Wise_Data;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        selectCss(dashboardBtn);
        Node node = null;
        try {
            node = FXMLLoader.load(getClass().getResource("/viwe/homePage.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    private void selectCss(JFXButton dashboardBtn) {
        //remo
        this.dashboardBtn.getStyleClass().remove("select_button");
        this.employeeBtn.getStyleClass().remove("select_button");
        this.manageInstrumentBtn.getStyleClass().remove("select_button");
        this.center_Wise_Data.getStyleClass().remove("select_button");


        //add
        this.employeeBtn.getStyleClass().add("default_button");
        this.dashboardBtn.getStyleClass().add("default_button");
        this.manageInstrumentBtn.getStyleClass().add("default_button");
        this.center_Wise_Data.getStyleClass().add("default_button");

        //select
        dashboardBtn.getStyleClass().remove("default_button");
        dashboardBtn.getStyleClass().add("select_button");


    }

    public void btnDashbordOnAction(ActionEvent actionEvent) throws IOException {
        selectCss(dashboardBtn);
        Node node = FXMLLoader.load(getClass().getResource("/viwe/homePage.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    public void btnMangeEmployeeOnAction(ActionEvent actionEvent) throws IOException {
        selectCss(employeeBtn);
        Node node = FXMLLoader.load(getClass().getResource("/viwe/employee_page.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);
    }

    public void btnMangeInstrumentOnAction(ActionEvent actionEvent) throws IOException {
        selectCss(manageInstrumentBtn);
        Node node = FXMLLoader.load(getClass().getResource("/viwe/InstrumentDetails_fxml.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);

    }

    public void btnCenterWiseDataOnAction(ActionEvent actionEvent) throws IOException {
        selectCss(center_Wise_Data);
        Node node = FXMLLoader.load(getClass().getResource("/viwe/CenterWiseData_Form.fxml"));
        lode_page.getChildren().clear();
        lode_page.getChildren().add(node);


    }

    public void btnMyProfileOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/viwe/ProfileDetailForm.fxml"))));
        stage.centerOnScreen();
        stage.show();
    }
}
