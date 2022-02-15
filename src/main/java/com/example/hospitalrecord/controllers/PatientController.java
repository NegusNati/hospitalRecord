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
import javafx.stage.Stage;

import java.io.IOException;

public class PatientController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_home;

    @FXML
    private Label label_doc;

    @FXML
    private Button view_patient;

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
    void viewDoc(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("docPatient.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(" DOCTOR INFORMATION TABLE ");
        stage.setScene(scene);
        stage.show();


    }

}
