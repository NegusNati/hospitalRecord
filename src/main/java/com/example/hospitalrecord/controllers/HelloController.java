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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.Objects;

public class HelloController {

    int return_value;
    private Parent root;
    private Stage stage;
    private Scene scene;
    Alert a;
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    private AnchorPane anc_a;

    @FXML
    private Label lable1;

    @FXML
    private Label log;

    @FXML
    private Button login_btn;

    @FXML
    private TextField password;

    @FXML
    private TextField user_name;

    void let() throws ClassNotFoundException, SQLException {
        Jdbc database = new Jdbc();// DATABASE CLASS
        con = database.connMethod(); // CREATING A CONNECTION
        System.out.println("AFTER CONNECTION IS CREATED");
        String query = "select * from LOGIN_ROLE where USER_NAME=? and PASSWORD=?"; // THE SELECT QUERY
        pst = con.prepareStatement(query);
        pst.setString(1, user_name.getText());
        pst.setString(2, password.getText());
        rs = pst.executeQuery(); //QUERY EXECUTION
        System.out.println(password.getText());
        if (user_name.getText().equals("") && password.getText().equals("")) { //IF NO INPUT IS DETECTED
            a = new Alert(Alert.AlertType.WARNING);
            a.setContentText(" PLEASE FILL IN BOTH THE FIELDS PLEASE! ");
            a.showAndWait();
            user_name.setText("");
            password.setText("");// SETTING THE TEXT-FIELD TO NULL (CLEARING)
        } else if (rs.next()) { //IF ACTUALLY THE FORM IS FILLED
            String role_of_user = rs.getString("role"); //GET THE ROLE OF THAT USER
//            String role = "SELECT role FROM login_role where USER_NAME=? and PASSWORD=?";
//            pst = con.prepareStatement(role);
//            pst.setString(1, user_name.getText());
//            pst.setString(2,  password.getText());
//            rs = pst.executeQuery();
//            String role_of_user = rs.getString("role");
            System.out.println("AFTER RESULT SET IS TURE");
            System.out.println(role_of_user);
            String doc = "doctor";
            String nur = "nurse";
            String admin = "admin";
            String lab = "lab";
            String record = "record";
            String pharma = "pharma";

            if (doc.equals(role_of_user)) { // FOR DOCTOR CASE
                return_value = 1; // CHANGE THE GLOBAL VARIABLE TO 1
            } else if (role_of_user.equals(nur)) {// FOR NURSE CASE
                return_value = 2;// CHANGE THE GLOBAL VARIABLE TO 2
            } else if (admin.equals(role_of_user)) {
                return_value = 3;
            } else if (lab.equals(role_of_user)) {
                return_value = 4;
            } else if (role_of_user.equals(pharma)) {
                return_value = 5;
            } else if (role_of_user.equals(record)){
                return_value = 6;
            }else { //IF THERE IS NO USER LIKE THAT OR JUST ONE FIELD IS INCORRECT
                System.out.println("no privilage");}} else {
                        a = new Alert(Alert.AlertType.WARNING);
                        a.setContentText("INCORRECT USER NAME OR PASSWORD");
                        a.showAndWait();
                        user_name.setText("");
                        password.setText("");

        }

    }
    @FXML
    void login(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
        this.let();
        System.out.println(return_value);// FOR DEV
    if(return_value==1){
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("doc-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("DOCTOR PAGE ");
        stage.setScene(scene);
        stage.show();}
    else if (return_value==2){

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("nurse-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("NURSE PAGE ");
        stage.setScene(scene);
        stage.show();}
    else if (return_value==3){

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("admin-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("ADMIN PAGE ");
        stage.setScene(scene);
        stage.show();}
    else if (return_value==4){

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("lab-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("LABORATORY PAGE ");
        stage.setScene(scene);
        stage.show();}
    else if (return_value==5){

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("pharma-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("PHARMACY PAGE ");
        stage.setScene(scene);
        stage.show();}
    else if (return_value==6) {

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("record-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("RECORD OFFICE PAGE ");
        stage.setScene(scene);
        stage.show();}
    else{
       System.out.println("just stop");}

//        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("doc-page.fxml")));
//        scene = new Scene(root);
//        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
////        scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

}
