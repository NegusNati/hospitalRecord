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

public class AdminController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_home;

    @FXML
    private Button doc;

    @FXML
    private Button lab;

    @FXML
    private Button nurse;

    @FXML
    private Button other;

    @FXML
    private Button patient;

    @FXML
    private Button pharma;

    @FXML
    private Button record;

    @FXML
    void doc(ActionEvent event) {

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
    void lab(ActionEvent event) {

    }

    @FXML
    void nurse(ActionEvent event) {

    }

    @FXML
    void other(ActionEvent event) {

    }

    @FXML
    void patient(ActionEvent event) {

    }

    @FXML
    void pharma(ActionEvent event) {

    }

    @FXML
    void record(ActionEvent event) {

    }

}

