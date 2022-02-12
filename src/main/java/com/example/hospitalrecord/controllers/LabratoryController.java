package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;

public class LabratoryController {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private Button btn_home;

    @FXML
    private Button edit;

    @FXML
    private Button patient;

    @FXML
    void edit(ActionEvent event) throws IOException {
        FXMLLoader ff = new FXMLLoader(HospitalRecord.class.getResource("status-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(ff.load());
        stage.setTitle(" PATIENT STATUS UPDATE ");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void home(ActionEvent event) throws IOException,Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
//        Image iconPicture = new Image("src/main/java/com/example/hospitalrecord/zzz.png");
//        stage.getIcons().add(iconPicture);
        stage.setTitle("HOSPITAL RECORD MANAGEMENT SYSTEM ");
        //        Image iconPic =new Image("hossssssss.jpg");
        stage.setScene(scene);
        stage.setResizable(false);
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

