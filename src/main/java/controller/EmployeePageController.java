package controller;

import dto.EmployDTO;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class EmployeePageController implements Initializable {
    public TableView<EmployDTO> emp;
    @FXML
    private TableColumn<?, ?> id;

    @FXML
    private TableColumn<?, ?> tele;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TableColumn<?, ?> address;

    @FXML
    private TableColumn<?, ?> email;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        tele.setCellValueFactory(new PropertyValueFactory<>("tele"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

    }

    public void addOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/viwe/addEmployee.fxml"));
        stage.setScene(new Scene(fxmlLoader.load()));
        AddEmployeeController controller = fxmlLoader.getController();
        controller.employeeControoler=this;
        stage.centerOnScreen();
        stage.show();
    }
    public void setTableData(EmployDTO employDTO){
        emp.getItems().add(employDTO);
        emp.refresh();
    }
}
