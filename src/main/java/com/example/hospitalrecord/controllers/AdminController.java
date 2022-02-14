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
    private Button add;

    @FXML
    private Button btn_home;

    @FXML
    private Button edit;

    @FXML
    private Button view;

    @FXML
    private Button viewp;

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
    void addEmp(ActionEvent event) throws IOException {
       FXMLLoader fx = new FXMLLoader(HospitalRecord.class.getResource("addEmp-page.fxml"));
       stage = (Stage)((Node)event.getSource()).getScene().getWindow();
       Scene scene = new Scene(fx.load());
       stage.setTitle("ADD EMPLOYEE PAGE");
       stage.setScene(scene);
       stage.show();

    }

    @FXML
    void editEmp(ActionEvent event) throws IOException {

        System.out.println("AFTER CONNECTION IS CREATED");
        FXMLLoader k = new FXMLLoader(HospitalRecord.class.getResource("editEmp-page.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        System.out.println("AFTER CONNECTION IS CREATED");
        Scene scene2 = new Scene(k.load());
        System.out.println("AFTER CONNECTION IS CREATED");
        stage.setTitle(" UPDATE EMPLOYEE PAGE ");
        stage.setScene(scene2);
        stage.show();
//        FXMLLoader LL = new FXMLLoader(HospitalRecord.class.getResource("editEmp-page.fxml"));
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(LL.load());
//        stage.setTitle(" UPDATE AN EMPLOYEE PAGE ");
//        stage.setScene(scene);
//        stage.show();
    }


    @FXML
    void viewEmp(ActionEvent event) throws IOException {

        FXMLLoader fxa = new FXMLLoader(HospitalRecord.class.getResource("empTable-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxa.load());
        stage.setTitle(" EMPLOYEE RECORD PAGE");
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void viewPatient(ActionEvent event) {

    }

}

