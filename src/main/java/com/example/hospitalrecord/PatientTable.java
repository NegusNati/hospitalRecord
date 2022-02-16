package com.example.hospitalrecord;

import com.example.hospitalrecord.controllers.Jdbc;
import com.example.hospitalrecord.controllers.searchClass;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class PatientTable implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TextField searchTextField;

    @FXML
    private TableView<searchClass> tbl;
    @FXML
    private TableColumn<searchClass, String>firstName;
    @FXML
    private TableColumn<searchClass, String>lastName;
    @FXML
    private TableColumn<searchClass, String>id;
    @FXML
    private TableColumn<searchClass, String>cardNo;
    @FXML
    private TableColumn<searchClass, String>age;
    @FXML
    private TableColumn<searchClass, String>sex;
    @FXML
    private TableColumn<searchClass, String>contactNo;
    @FXML
    private TableColumn<searchClass, String>addDate;
    @FXML
    private TableColumn<searchClass, String>addTime;
    @FXML
    private TableColumn<searchClass, String>status;
    @FXML
    private TableColumn<searchClass, String>moneyDue;

    ObservableList<searchClass> patientTable = FXCollections.observableArrayList();
    Alert a;
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlBack = new FXMLLoader(HospitalRecord.class.getResource("hello-view.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlBack.load());
        stage.setTitle(" RECORD OFFICE PAGE ");
        stage.setScene(scene);
        stage.show();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String query = "SELECT FIRSTNAME,LASTNAME,ID,CARDNUMBER,AGE,SEX,CONTACTNUMBER,ADMITIONDATE,ADMITIONTIME,STATUS,MONEYDUE FROM PATIENT";
        try {
            Jdbc database = new Jdbc();
            Connection con = database.connMethod();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String First = rs.getString("FIRSTNAME");
                String Last = rs.getString("LASTNAME");
                String Ident = rs.getString("ID");
                String Card = rs.getString("CARDNUMBER");
                String Ag = rs.getString("AGE");
                String Se = rs.getString("SEX");
                String Contact = rs.getString("CONTACTNUMBER");
                String ADate = rs.getString("ADMITIONDATE");
                String ATime = rs.getString("ADMITIONTIME");
                String Sta = rs.getString("STATUS");
                String Money = rs.getString("MONEYDUE");


                // POPULATE THE OBSERVABLE LIST
                patientTable.add(new searchClass(First,Last,Ident,Card,Ag,Se,Contact,ADate,ATime,Sta,Money));
//                System.out.println(" populated ");
            }
//            System.out.println(" set to it ");
            firstName.setCellValueFactory(new PropertyValueFactory<>("fname"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lname"));
            id.setCellValueFactory(new PropertyValueFactory<>("id"));
            cardNo.setCellValueFactory(new PropertyValueFactory<>("cnumber"));
            age.setCellValueFactory(new PropertyValueFactory<>("agee"));
            sex.setCellValueFactory(new PropertyValueFactory<>("sexx"));
            contactNo.setCellValueFactory(new PropertyValueFactory<>("connumber"));
            addDate.setCellValueFactory(new PropertyValueFactory<>("addate"));
            addTime.setCellValueFactory(new PropertyValueFactory<>("adtime"));
            status.setCellValueFactory(new PropertyValueFactory<>("statuss"));
            moneyDue.setCellValueFactory(new PropertyValueFactory<>("modue"));
// set the items from the observable list to the table
            tbl.setItems(patientTable);
//            System.out.println(" after table insert ");
            // now lets use the FilteredList class for our Dynamic search.
            //intalize here
            FilteredList<searchClass> fileterdListTable = new FilteredList<>(patientTable, b -> true);
            //use our textfield data to search
            searchTextField.textProperty().addListener((observable, oldValue , newValue) -> {
                fileterdListTable.setPredicate(searchClass -> {

                    if ( newValue.isEmpty() || newValue.isBlank() ||newValue == null){
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if(searchClass.getFname().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    } else if (searchClass.getLname().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (searchClass.getId().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (searchClass.getCnumber().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (searchClass.getAgee().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (searchClass.getSexx().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (searchClass.getConnumber().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (searchClass.getAddate().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (searchClass.getAdtime().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (searchClass.getStatuss().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (searchClass.getModue().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    } else
                        return false; // no match
                });
            });

            SortedList<searchClass> sortedData = new SortedList<>(fileterdListTable);
            //bind sorted result with our table view
            sortedData.comparatorProperty().bind(tbl.comparatorProperty());

            // after dynamic search, the sorted data is displayed
            tbl.setItems(sortedData);
        } catch (ClassNotFoundException | SQLException e) {
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" NO PATIENT ADDED TO THE SYSTEM !! ");
            a.showAndWait();
            e.printStackTrace();
        }

    }
}
