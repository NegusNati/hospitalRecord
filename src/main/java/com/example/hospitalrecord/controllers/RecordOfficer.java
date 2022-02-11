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

public class RecordOfficer {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button edit;

    @FXML
    private Button home;

    @FXML
    private Button reg;

    @FXML
    private Button retrive;

    @FXML
    void edit(ActionEvent event) {

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
    void register(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(HospitalRecord.class.getResource("admit-page.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxml.load());
        stage.setTitle("ADMISSION PAGE");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void retrive(ActionEvent event) throws IOException {
        FXMLLoader fx = new FXMLLoader(HospitalRecord.class.getResource("patient-table-page.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fx.load());
        stage.setTitle("ADMISSION PAGE");
        stage.setScene(scene);
        stage.show();
    }

}
