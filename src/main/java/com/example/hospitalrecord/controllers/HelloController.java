package com.example.hospitalrecord.controllers;

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
import java.sql.*;

import java.io.IOException;

import static javafx.fxml.FXMLLoader.*;

public class HelloController {

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

    private Parent root;
    private Stage stage;
    private Scene scene;
    Alert a;
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    @FXML
    void login(ActionEvent event) throws IOException, SQLException, ClassNotFoundException {
      System.out.println(user_name.getText());
        System.out.println(password.getText());


        Jdbc database = new Jdbc();
        con = database.connMethod();
        System.out.println(password.getText());
        String query = "select * from LOGIN_ROLE where USER_NAME=? and PASSWORD=?";
        pst = con.prepareStatement(query);
        pst.setString(1, user_name.getText());
        pst.setString(2, password.getText());
        rs = pst.executeQuery();
        System.out.println(password.getText());
        if (user_name.getText().equals("") &&  password.getText().equals("")) {
            a= new Alert(Alert.AlertType.WARNING);
            a.setContentText("PLEASE FILL IN BOTH THE FIELDS !");
            user_name.setText("");
            password.setText("");
        }else if(rs.next()){
            String role_of_user = rs.getString("role");
//            String role = "SELECT role FROM login_role where USER_NAME=? and PASSWORD=?";
//            pst = con.prepareStatement(role);
//            pst.setString(1, user_name.getText());
//            pst.setString(2,  password.getText());
//            rs = pst.executeQuery();
//            String role_of_user = rs.getString("role");
            System.out.println("did it get from rs?");
            System.out.println(role_of_user);
            String doc = "doctor";
            if(doc.equals(role_of_user)){
                System.out.println("in doc case");
                try{
                root = FXMLLoader.load(getClass().getResource("hello-view.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                }catch(Exception e){
                    e.printStackTrace();
                }

            }else {
                System.out.println("not equal to doc");

            }
        }else{
            System.out.println("nope  2");

        }


    }

}
