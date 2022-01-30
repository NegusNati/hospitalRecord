package record;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;

public class Controller {

public void notify (ActionEvent e){

    Alert a = new Alert(Alert.AlertType.INFORMATION);
    a.setContentText("Controller connected! ");

}
}

