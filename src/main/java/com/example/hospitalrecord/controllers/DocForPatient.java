package com.example.hospitalrecord.controllers;

import com.example.hospitalrecord.HospitalRecord;
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
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import static com.example.hospitalrecord.controllers.SearchDoc.*;

public class DocForPatient implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<SearchDoc, String> availability;

    @FXML
    private Button backk;

    @FXML
    private TableColumn<SearchDoc, String> contactNumber;

    @FXML
    private TableColumn<SearchDoc, String> email0;

    @FXML
    private TableColumn<SearchDoc, String> firstName;

    @FXML
    private TableColumn<SearchDoc, String> id;

    @FXML
    private TableColumn<SearchDoc, String> lastName;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<SearchDoc, String> sex;

    @FXML
    private TableColumn<SearchDoc, String> specialization;

    @FXML
    private TableView<SearchDoc> tbl;

    ObservableList<SearchDoc> DocTableobservableList = FXCollections.observableArrayList();
    Alert a;
    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("patient-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(" PATIENT PAGE ");
        stage.setScene(scene);
        stage.show();

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String query = "SELECT FIRSTNAME,LASTNAME,SEX,CONTACTNUMBER,EMAIL,SPECIALIZATION,AVAILABILITY,EMPLOYEEID FROM EMPLOYEE where ROLE = 'DOC'";



        try{
            Jdbc database = new Jdbc();
            Connection con = database.connMethod();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String First = rs.getString("FIRSTNAME");
                String Last = rs.getString("LASTNAME");

                String sss = rs.getString("SEX");
                String Contact = rs.getString("CONTACTNUMBER");
                String eee = rs.getString("EMAIL");
                String Sta = rs.getString("SPECIALIZATION");
                String availll = rs.getString("AVAILABILITY");
                String Ident = rs.getString("EMPLOYEEID");


                // POPULATE THE OBSERVABLE LIST
                DocTableobservableList.add(new SearchDoc(First,Last,sss,Contact,eee,Sta,availll,Ident));
                System.out.println(" populated ");
            }
            System.out.println(" set to it ");
            firstName.setCellValueFactory(new PropertyValueFactory<>("fname1"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lname1"));
            sex.setCellValueFactory(new PropertyValueFactory<>("sexx1"));
            contactNumber.setCellValueFactory(new PropertyValueFactory<>("connumber1"));
            email0.setCellValueFactory(new PropertyValueFactory<>("ema1"));
            specialization.setCellValueFactory(new PropertyValueFactory<>("spec1"));
            availability.setCellValueFactory(new PropertyValueFactory<>("avail1"));
            id.setCellValueFactory(new PropertyValueFactory<>("empi1"));

// set the items from the observable list to the table
            tbl.setItems(DocTableobservableList);
            System.out.println(" after table insert ");
            // now lets use the FilteredList class for our Dynamic search.
            //intalize here
            FilteredList<SearchDoc> fileterdListTableForDoc = new FilteredList<>(DocTableobservableList, b -> true);

            //use our textfield data to search
            searchTextField.textProperty().addListener((observable, oldValue , newValue) -> {
                fileterdListTableForDoc.setPredicate(SearchDoc -> {

                    if ( newValue.isEmpty() || newValue.isBlank() ||newValue == null){
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if(SearchDoc.getFname1().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    } else if (SearchDoc.getLname1().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (SearchDoc.getSexx1().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (SearchDoc.getConnumber1().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (SearchDoc.getEma1().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (SearchDoc.getSpec1().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (SearchDoc.getAvail1().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (SearchDoc.getEmpi1().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else
                        return false; // no match
                });
            });

            SortedList<SearchDoc> sortedData2 = new SortedList<>(fileterdListTableForDoc);
            //bind sorted result with our table view
            sortedData2.comparatorProperty().bind(tbl.comparatorProperty());

            // after dynamic search, the sorted data is displayed
            tbl.setItems(sortedData2);



        }catch(Exception e){
            a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText(" NO 'DOC' ADDED TO THE SYSTEM !! ");
            a.showAndWait();
            e.printStackTrace();
        }

    }
}
