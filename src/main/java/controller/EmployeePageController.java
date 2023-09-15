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
import model.EmplyeeModel;

import java.io.IOException;
import java.net.URL;
import java.util.List;
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
    private EmplyeeModel emplyeeModel=new EmplyeeModel();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new PropertyValueFactory<>("employee_id"));
        tele.setCellValueFactory(new PropertyValueFactory<>("tele"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        address.setCellValueFactory(new PropertyValueFactory<>("address"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));

        setTableData();
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
    public void setTableData(){
        List<EmployDTO> all = emplyeeModel.getAll();
        emp.getItems().clear();
        emp.refresh();
        for (EmployDTO dto : all) {
            emp.getItems().add(dto);
        }


    }
}
