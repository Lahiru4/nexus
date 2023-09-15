package controller;

import dto.EmployDTO;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;
import model.EmplyeeModel;
import org.controlsfx.control.Notifications;

public class AddEmployeeController {
    public TextField id;
    public TextField tele;
    public TextField name;
    public TextField address;
    public TextField email;
    public EmployeePageController employeeControoler;
    public EmplyeeModel emplyeeModel = new EmplyeeModel();

    public void saveOnAction(ActionEvent actionEvent) {
        boolean save = emplyeeModel.save(getEmployee());
        if (save) {
            Notifications position = Notifications.create()
                    .graphic(new ImageView(new Image("/viwe/image/icons8-ok-48.png")))
                    .text(" Success")
                    .title("Success")
                    .hideAfter(Duration.seconds(3))
                    .position(Pos.TOP_RIGHT);
            name.getScene().getWindow().hide();
            position.show();

        }



        /*Notifications position = Notifications.create()
                .graphic(new ImageView(new Image("/viwe/image/icons8-ok-48.png")))
                .text("Order Success")
                .title("Success")
                .hideAfter(Duration.seconds(3))
                .position(Pos.TOP_RIGHT);
        position.show();
        name.getScene().getWindow().hide();*/

    }

    private EmployDTO getEmployee() {
        return new EmployDTO(id.getText(),tele.getText(),name.getText(),address.getText(),email.getText());
    }
}
