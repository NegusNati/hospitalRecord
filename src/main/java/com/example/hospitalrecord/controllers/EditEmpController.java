package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import com.example.hospitalrecord.controllers.Jdbc;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.regex.Pattern;



public class EditEmpController {
    private Scene scene;
    private Stage stage;
    Connection con = null;
    Statement stmt = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String s;
    Alert a;
    Alert b;
    @FXML
    private TextField age;

    @FXML
    private TextField availablity;

    @FXML
    private Button back;

    @FXML
    private Button back1;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField email;

    @FXML
    private TextField firstName;

    @FXML
    private TextField id;

    @FXML
    private TextField lastName;

    @FXML
    private TextField role;

    @FXML
    private TextField salary;

    @FXML
    private TextField special;

    public void updateEmpMethod() throws ClassNotFoundException {
        try{
            Jdbc database = new Jdbc();// DATABASE CLASS
            con = database.connMethod(); // CREATING A CONNECTION
//             System.out.println("AFTER CONNECTION IS CREATED");
            String dateFromDataBase ="SELECT * FROM EMPLOYEE WHERE EMPLOYEEID ='"+id.getText()+"'";
            Statement stt = con.createStatement();
            ResultSet rr = stt.executeQuery(dateFromDataBase);
            rr.next(); //LIFE THE POINTER TO 1 FROM 0
            String pastDate = rr.getString("DATEOFHIRE");
            String pastSex = rr.getString("SEX");
//            System.out.println(pastSex);

//        System.out.println(" date and time ");
        String sql = "UPDATE EMPLOYEE SET firstName = '"+firstName.getText()+"',lastName ='"+lastName.getText()+"',sex ='"+pastSex+"',age = '"+age.getText()+"',contactNumber ='"+contactNumber.getText()+"',DATEOFHIRE = '"+pastDate+"',email = '"+email.getText()+"',role ='"+role.getText()+"',SPECIALIZATION ='"+special.getText()+"', AVAILABILITY ='"+availablity.getText()+"',salary ='"+salary.getText()+"' WHERE  EMPLOYEEID= '"+id.getText()+"'";
        PreparedStatement ptst = con.prepareStatement(sql);
//        System.out.println(" before ex ");

// Validation
        String fn = firstName.getText().toString();
        String ln = lastName.getText().toString();
        String ag = age.getText().toString();
        String md = email.getText().toString();
        String cno = contactNumber.getText().toString();
        String sta = availablity.getText().toString();
        String salar = salary.getText().toString();
        b = new Alert(Alert.AlertType.INFORMATION);

         if(fn.equals("")){
            b.setContentText("FIRST NAME OF EMPLOYEE IS MANDATORY, PLEASE INSERT AGAIN ");
            b.showAndWait(); }
        else if(ln.equals("")){
            b.setContentText("LAST NAME OF EMPLOYEE IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait(); }
        else if(ag.equals("")){
            b.setContentText("AGE IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(cno.equals("")){
            b.setContentText("CONTACT NUMBER IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(md.equals("")){
            email.setText(" NOT PROVIDED ");}
        else if(sta.equals("")){
            availablity.setText(" ACTIVE ");}
        else if((!Pattern.matches("^[0-9]*$", cno))||(cno.length()!=10)){
            b.setContentText("PHONE NUMBER EITHER INCLUDE CHARACTER OR IS ABOVE OR LESS THAN 10 DIGITS,PLEASE INSERT AGAIN, use the format 0911****** ");
            b.showAndWait();}
        else if(!Pattern.matches("[a-zA-Z]+", fn)){
            b.setContentText(" FIRST NAME INCLUDE NUMBER OR SYMBOLS,PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(!Pattern.matches("[a-zA-Z]+", ln)){
            b.setContentText(" LAST NAME INCLUDE NUMBER OR SYMBOLS,PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(!Pattern.matches("^[0-9]*$", ag)){
            b.setContentText(" AGE EITHER INCLUDE CHARACTER OR SYMBOLS ,PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(!Pattern.matches("^[0-9]*$", salar)){
            b.setContentText(" SALARY EITHER INCLUDE CHARACTER OR SYMBOLS,PLEASE INSERT AGAIN");
            b.showAndWait();}

        else {
//            System.out.println("ELSE  ex ");
            ptst.executeQuery();
//            System.out.println("AFTER ex ");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" EMPLOYEE DATA UPDATED SUCCESSFULLY!! ");
            a.showAndWait();
            con.close();
            firstName.setText(""); lastName.setText(""); id.setText(""); role.setText(""); age.setText("");contactNumber.setText(""); availablity.setText("");
            salary.setText(""); special.setText(""); email.setText(""); }} catch(Exception e){
            firstName.setText(""); lastName.setText(""); id.setText(""); role.setText(""); age.setText("");contactNumber.setText(""); availablity.setText("");
            salary.setText(""); special.setText(""); email.setText("");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" NO EMPLOYEE DATA WITH THAT ID !! ");
            a.showAndWait();
            e.printStackTrace();
        }
    }
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader BACK = new FXMLLoader(HospitalRecord.class.getResource("admin-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(BACK.load());
        stage.setTitle("ADMIN PAGE");
        stage.setScene(scene);
        stage.show();
    }
    @FXML
    void update(ActionEvent event) throws ClassNotFoundException {
        updateEmpMethod();
    }
}
