package com.example.hospitalrecord;

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

public class HelloController {
private Stage stage;
private Scene scene;
private Parent root;

    @FXML
    private Button btn_admin;

    @FXML
    private Button btn_doc;

    @FXML
    private Button btn_lab;

    @FXML
    private Button btn_nurse;

    @FXML
    private Button btn_patient;

    @FXML
    private Button btn_pharma;

    @FXML
    private Button btn_rec;

    @FXML
    private Label lable1;

    @FXML
    void admin(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("admin-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void doc(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("doc-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
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
    void patient(ActionEvent event) {

    }

    @FXML
    void pharma(ActionEvent event) {

    }

    @FXML
    void record(ActionEvent event) {

    }

}
