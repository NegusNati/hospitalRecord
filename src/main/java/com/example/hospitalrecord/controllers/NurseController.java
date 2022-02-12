package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

public class NurseController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button home;

    @FXML
    private Button patient;

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
    void patient(ActionEvent event) throws IOException {
        FXMLLoader ff = new FXMLLoader(HospitalRecord.class.getResource("patient-table-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(ff.load(),1100,600);
        stage.setResizable(false);
        stage.setTitle("PATIENT DETAIL TABLE PAGE");
        stage.setScene(scene);
        stage.show();

    }

}
