package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AdmitPateint implements Initializable {
    private Scene scene;
    private Stage stage;
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @FXML
    private TextField age;

    @FXML
    private TextField cardNumber;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField contactNumber1;

    @FXML
    private TextField date;

    @FXML
    private TextField firstName;

    @FXML
    private TextField id;

    @FXML
    private TextField lastName;

    @FXML
    private ComboBox<String> sexComboBox;

    @FXML
    private TextArea status;

    @FXML
    private TextField time;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexComboBox.setItems(FXCollections.observableArrayList("MALE","FEMALE"));

    }

    public void sqlMethod() throws ClassNotFoundException {
        Jdbc database = new Jdbc();// DATABASE CLASS
        con = database.connMethod(); // CREATING A CONNECTION
        System.out.println("AFTER CONNECTION IS CREATED");




    }
    @FXML
    void admit(ActionEvent event) {


    }

    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlback = new FXMLLoader(HospitalRecord.class.getResource("record-page.fxml"));
        stage =(Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlback.load());
        stage.setTitle("RECORD OFFICE PAGE");
        stage.setScene(scene);
        stage.show();
    }
}
