package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class DoctorController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private AnchorPane acnc;

    @FXML
    private Button btn_home;

    @FXML
    private Button edit_patient;

    @FXML
    private Label label_doc;

    @FXML
    private Button view_patient;

    @FXML
    void editPatient(ActionEvent event) {

    }

    @FXML
    void home(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("HOSPITAL RECORD MANAGEMENT SYSTEM ");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void viewPatient(ActionEvent event) {

    }

}
