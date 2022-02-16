package com.example.hospitalrecord;

import com.example.hospitalrecord.controllers.Jdbc;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

import static com.example.hospitalrecord.HospitalRecord.dateMain;


public class addEmpController implements Initializable {
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
    private Button admit;

    @FXML
    private TextField age;

    @FXML
    private TextField availablity;

    @FXML
    private Button back;

    @FXML
    private TextField contactNumber;

    @FXML
    private TextField date;

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
    private ComboBox<String> sexComboBox;

    @FXML
    private TextField special;
    @FXML
    private TextField salary;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sexComboBox.setItems(FXCollections.observableArrayList("MALE","FEMALE"));
        date.setText(dateMain);
        s = String.valueOf(sexComboBox.getValue());
    }
    int condition ;
    public void addEmpMethod() throws ClassNotFoundException, SQLException {
        Jdbc database = new Jdbc();// DATABASE CLASS
        con = database.connMethod(); // CREATING A CONNECTION
//        System.out.println("AFTER CONNECTION IS CREATED");
        String d =dateMain;
        b = new Alert(Alert.AlertType.INFORMATION);
//        System.out.println(" date and time ");
        s = String.valueOf(sexComboBox.getValue());
        String sql = "INSERT INTO EMPLOYEE values ( ?,?,?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement ptst = con.prepareStatement(sql);
        ptst.setString(1, firstName.getText());
        ptst.setString(2, lastName.getText());
        ptst.setString(3, s);
        ptst.setString(4, age.getText());
        ptst.setString(5, contactNumber.getText());
        ptst.setString(6, d);
        ptst.setString(7, email.getText());
        ptst.setString(8, role.getText());
        ptst.setString(9, special.getText());
        ptst.setString(10, availablity.getText());
        ptst.setString(11, id.getText());
        ptst.setString(12, salary.getText());
//        System.out.println(" before ex ");
 // check for similar id
        String query = "SELECT * FROM EMPLOYEE";
        Connection cons = database.connMethod();
        Statement stmts = cons.createStatement();
        ResultSet rss = stmts.executeQuery(query);
        while (rss.next()){
            String iii = rss.getString("EMPLOYEEID");
            System.out.println(iii);
            if( iii.equals(id.getText())){
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
        String md = email.getText().toString();
        String sexxx = s;

        String cno = contactNumber.getText().toString();
        String sta = availablity.getText().toString();
        String salar = salary.getText().toString();


        if(i.equals("")){
            b.setContentText("EMPLOYEE ID IS MANDATORY, PLEASE INSERT AGAIN ");
            b.showAndWait();}
        else if(fn.equals("")){
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
        else if(condition == 1){
            b.setContentText("EMPLOYEE WITH SIMILAR ID IS ALREADY IN THE SYSTEM, PLEASE INSERT AGAIN");
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
        else if(!Pattern.matches("^[0-9]*$", salar)){
            b.setContentText(" SALARY EITHER INCLUDE CHARACTER OR SYMBOLS,PLEASE INSERT AGAIN");
            b.showAndWait();}

        else {
//            System.out.println("ELSE  ex ");
            ptst.executeQuery();
//            System.out.println("AFTER ex ");
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" EMPLOYEE DATA INSERTED SUCCESSFULLY!! ");
            a.showAndWait();
            con.close();
            firstName.setText(""); lastName.setText(""); id.setText(""); role.setText(""); age.setText("");contactNumber.setText(""); availablity.setText("");
            salary.setText(""); special.setText(""); email.setText(""); }
    }
    @FXML
    void admit(ActionEvent event) throws SQLException, ClassNotFoundException {
        addEmpMethod();
    }

    @FXML
    void back(ActionEvent event) throws IOException {

        FXMLLoader fx = new FXMLLoader(HospitalRecord.class.getResource("admin-page.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fx.load());
        stage.setTitle("ADMIN PAGE");
        stage.setScene(scene);
        stage.show();
    }
}
