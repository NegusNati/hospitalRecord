package com.example.hospitalrecord;

import com.example.hospitalrecord.controllers.EmpSearchClass;
import com.example.hospitalrecord.controllers.Jdbc;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class EmployeeTable implements Initializable {
    private Parent root;
    private Stage stage;
    private Scene scene;
    @FXML
    private TableColumn<EmpSearchClass, String> age;

    @FXML
    private TableColumn<EmpSearchClass, String> availability;

    @FXML
    private Button backk;

    @FXML
    private TableColumn<EmpSearchClass, String> contactNumber;

    @FXML
    private TableColumn<EmpSearchClass, String> dateOfHire;

    @FXML
    private TableColumn<EmpSearchClass, String> email0;

    @FXML
    private TableColumn<EmpSearchClass, String> firstName;

    @FXML
    private TableColumn<EmpSearchClass, String> id;

    @FXML
    private TableColumn<EmpSearchClass, String> lastName;

    @FXML
    private TableColumn<EmpSearchClass, String> role;

    @FXML
    private TableColumn<EmpSearchClass, String> salary;

    @FXML
    private TextField searchTextField;

    @FXML
    private TableColumn<EmpSearchClass, String> sex;

    @FXML
    private TableColumn<EmpSearchClass, String> specialization;

    @FXML
    private TableView<EmpSearchClass> tbl;

    ObservableList<EmpSearchClass> employeeTableobservableList = FXCollections.observableArrayList();




    @FXML
    void back(ActionEvent event) throws IOException {
        FXMLLoader fxmlBack = new FXMLLoader(HospitalRecord.class.getResource("admin-page.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(fxmlBack.load());
        stage.setTitle(" ADMIN PAGE ");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        String query = "SELECT FIRSTNAME,LASTNAME,SEX,AGE,CONTACTNUMBER,DATEOFHIRE,EMAIL,ROLE,SPECIALIZATION,AVAILABILITY,EMPLOYEEID,SALARY FROM EMPLOYEE";

        try{
            Jdbc database = new Jdbc();
            Connection con = database.connMethod();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()){
                String First = rs.getString("FIRSTNAME");
                String Last = rs.getString("LASTNAME");

                String sss = rs.getString("SEX");
                String Ag = rs.getString("AGE");
                String Contact = rs.getString("CONTACTNUMBER");
                String ADate = rs.getString("DATEOFHIRE");
                String eee = rs.getString("EMAIL");
                String roro = rs.getString("ROLE");
                String Sta = rs.getString("SPECIALIZATION");
                String availll = rs.getString("AVAILABILITY");
                String Ident = rs.getString("EMPLOYEEID");
                String sallll = rs.getString("SALARY");

                // POPULATE THE OBSERVABLE LIST
                employeeTableobservableList.add(new EmpSearchClass(First,Last,sss,Ag,Contact,ADate,eee,roro,Sta,availll,Ident,sallll));
                System.out.println(" populated ");
            }
            System.out.println(" set to it ");
            firstName.setCellValueFactory(new PropertyValueFactory<>("fname"));
            lastName.setCellValueFactory(new PropertyValueFactory<>("lname"));
            sex.setCellValueFactory(new PropertyValueFactory<>("sexx"));
            age.setCellValueFactory(new PropertyValueFactory<>("agee"));
            contactNumber.setCellValueFactory(new PropertyValueFactory<>("connumber"));
            dateOfHire.setCellValueFactory(new PropertyValueFactory<>("dateofh"));
            email0.setCellValueFactory(new PropertyValueFactory<>("ema"));
            role.setCellValueFactory(new PropertyValueFactory<>("ro"));
            specialization.setCellValueFactory(new PropertyValueFactory<>("spec"));
            availability.setCellValueFactory(new PropertyValueFactory<>("avail"));
            id.setCellValueFactory(new PropertyValueFactory<>("empi"));
            salary.setCellValueFactory(new PropertyValueFactory<>("salary1"));

// set the items from the observable list to the table
            tbl.setItems(employeeTableobservableList);
            System.out.println(" after table insert ");
            // now lets use the FilteredList class for our Dynamic search.
            //intalize here
            FilteredList<EmpSearchClass> fileterdListTableForEmp = new FilteredList<>(employeeTableobservableList, b -> true);

           //use our textfield data to search
            searchTextField.textProperty().addListener((observable, oldValue , newValue) -> {
                fileterdListTableForEmp.setPredicate(searchClass -> {

                    if ( newValue.isEmpty() || newValue.isBlank() ||newValue == null){
                        return true;
                    }
                    String searchKey = newValue.toLowerCase();
                    if(EmpSearchClass.getFname().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    } else if (EmpSearchClass.getLname().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (EmpSearchClass.getSexx().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (EmpSearchClass.getAgee().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (EmpSearchClass.getConnumber().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (EmpSearchClass.getDateofh().toLowerCase().indexOf(searchKey) > -1 ){
                        return true;
                    }else if (EmpSearchClass.getEma().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (EmpSearchClass.getRo().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (EmpSearchClass.getSpec().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (EmpSearchClass.getAvail().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (EmpSearchClass.getEmpi().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    }else if (EmpSearchClass.getSalary1().toLowerCase().indexOf(searchKey) > -1){
                        return true;
                    } else
                        return false; // no match
                });
            });

            SortedList<EmpSearchClass> sortedData1 = new SortedList<>(fileterdListTableForEmp);
            //bind sorted result with our table view
            sortedData1.comparatorProperty().bind(tbl.comparatorProperty());

            // after dynamic search, the sorted data is displayed
            tbl.setItems(sortedData1);



        }catch(Exception e){

            e.printStackTrace();
        }





    }
}
