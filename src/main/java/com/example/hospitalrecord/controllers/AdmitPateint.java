package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static com.example.hospitalrecord.HospitalRecord.dateMain;
import static com.example.hospitalrecord.HospitalRecord.timeMain;

public class AdmitPateint implements Initializable {
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
    private TextField cardNumber;

    @FXML
    private TextField contactNumber;
    @FXML
    private TextField moneyDue;

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

    int condition = 2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexComboBox.setItems(FXCollections.observableArrayList("MALE","FEMALE"));
        date.setText(dateMain);
        time.setText(timeMain);
//        s = String.valueOf(sexComboBox.getValue());
    }

    public void sqlMethod1() throws ClassNotFoundException, SQLException {
        Jdbc database = new Jdbc();// DATABASE CLASS
        con = database.connMethod(); // CREATING A CONNECTION
        System.out.println("AFTER CONNECTION IS CREATED");
         String t= timeMain;
         String d =dateMain;
//        System.out.println(" gotten date and time ");
        s = String.valueOf(sexComboBox.getValue());
        String sql = "INSERT INTO patient values ( ?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ptst = con.prepareStatement(sql);
        ptst.setString(1, firstName.getText());
        ptst.setString(2, lastName.getText());
        ptst.setString(3, id.getText());
        ptst.setString(4, cardNumber.getText());
        ptst.setString(5, age.getText());
        ptst.setString(6, s);
        ptst.setString(7, contactNumber.getText());
        ptst.setString(8, d);
        ptst.setString(9, t);
        ptst.setString(10, status.getText());
        ptst.setString(11, moneyDue.getText());
//        System.out.println(" before ex ");

        String query = "SELECT * FROM patient";
        Connection cons = database.connMethod();
        Statement stmts = cons.createStatement();
        ResultSet rss = stmts.executeQuery(query);
        while (rss.next()){
            String iii = rss.getString("CARDNUMBER");
//            System.out.println(iii);
            if( iii.equals(cardNumber.getText())){
                condition = 1;
//               System.out.println(" 000 ");
            }else{
                System.out.println(" 2 ");}
        }
// Validation
        String fn = firstName.getText().toString();
        String ln = lastName.getText().toString();
        String i = id.getText().toString();
        String ag = age.getText().toString();
        String cn = cardNumber.getText().toString();
        String md = moneyDue.getText().toString();
        String sexxx = s;

        String cno = contactNumber.getText().toString();
        String sta = status.getText().toString();

        b = new Alert(Alert.AlertType.INFORMATION);

        if(i.equals("")){
            b.setContentText("ID IS MANDATORY, PLEASE INSERT AGAIN ");
            b.showAndWait();}
        else if(fn.equals("")){
            b.setContentText("FIRST NAME IS MANDATORY, PLEASE INSERT AGAIN ");
            b.showAndWait(); }
        else if(ln.equals("")){
            b.setContentText("LAST NAME IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait(); }
        else if(ag.equals("")){
            b.setContentText("AGE IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(cno.equals("")){
            b.setContentText("CONTACT NUMBER IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(cn.equals("")){
            b.setContentText("CARD NUMBER IS MANDATORY, PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(md.equals("")){
            moneyDue.setText("00");}
        else if(sta.equals("")){
            status.setText(" UNDIAGNOSED  ");}
        else if(condition == 1){
            b.setContentText("EMPLOYEE WITH SIMILAR CARDNUMBER IS ALREADY IN THE SYSTEM, PLEASE INSERT AGAIN");
            b.showAndWait(); }
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
        else if(!Pattern.matches("^[0-9]*$", cn)){
            b.setContentText(" CARD NUMBER EITHER INCLUDE CHARACTER OR SYMBOLS,PLEASE INSERT AGAIN");
            b.showAndWait();}
        else if(!Pattern.matches("^[0-9]*$", md)){
            b.setContentText(" MONEY-DUE EITHER INCLUDE CHARACTER OR SYMBOLS ,PLEASE INSERT AGAIN");
            b.showAndWait();}

        else {
        ptst.executeQuery();
        a = new Alert(Alert.AlertType.INFORMATION);
        a.setContentText(" PATIENT DATA INSERTED SUCCESSFULLY!! ");
        a.showAndWait();
        con.close();
        firstName.setText(""); lastName.setText(""); id.setText(""); cardNumber.setText(""); age.setText("");contactNumber.setText(""); status.setText("");
        moneyDue.setText("");}
    }
    @FXML
    void admit(ActionEvent event) throws SQLException, ClassNotFoundException {
        sqlMethod1();
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
