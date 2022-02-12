package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class StatusController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button ba;
    @FXML
    private TextField textField;

    @FXML
    private TextArea textArea;
    Alert a;
    String toTheTextArea;
    @FXML
    void search(ActionEvent event) throws ClassNotFoundException, SQLException {
//        String text = textField.getText();
//        String x = textField.getText();
        Jdbc database = new Jdbc();
        String query = "SELECT STATUS FROM PATIENT WHERE ID ='" + textField.getText() + "' ";
        System.out.println(" before connection ");
        if(textField.getText().length() > 0){
        Connection con = database.connMethod();
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        System.out.println(" 111111 ");

        if (rs.next()) {
            System.out.println("toTheTextArea");
            toTheTextArea = rs.getString("Status");
            System.out.println(toTheTextArea);
            textArea.setText(toTheTextArea);
        } else {
            textArea.setText("");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" THERE IS NO SUCH PATIENT IN THE HOSPITAL RECORD" );
            a.showAndWait();

        }

    }else {
            textArea.setText("");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" PLEASE FILL IN THE ID SPACE " );
            a.showAndWait();

        }

    }
    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fx = new FXMLLoader(HospitalRecord.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fx.load());
        stage.setTitle(" HOSPITAL RECORD MANAGEMENT SYSTEM ");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void update(ActionEvent event) throws ClassNotFoundException, SQLException {
//        String query = "SELECT STATUS FROM PATIENT WHERE ID = '" +textField.getText()+"' ";

        Jdbc database = new Jdbc();
        Connection con = database.connMethod();


        String updateStatus = "UPDATE PATIENT SET STATUS = '" +textArea.getText()+"' WHERE ID ='"+textField.getText()+"' ";
        if(textField.getText().length() > 0){
        PreparedStatement ptst = con.prepareStatement(updateStatus);
        ptst.execute();
        textField.setText("");
        textArea.setText("");
        a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" SUCCESSFULLY UPDATED " );
        a.showAndWait();}else{

            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" PLEASE FILL IN THE ID SPACE " );
            a.showAndWait();
            textArea.setText("");
        }

    }

}
