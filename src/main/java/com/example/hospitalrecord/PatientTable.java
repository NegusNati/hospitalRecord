package com.example.hospitalrecord;

import com.example.hospitalrecord.controllers.Jdbc;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.util.Callback;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class PatientTable {

    @FXML
    private TableView<ObservableList> tbl;

    Alert al;
    private ObservableList<ObservableList> data;


    void showMethod(){
        Jdbc database = new Jdbc();
        data = FXCollections.observableArrayList();
        try {
            System.out.println("in try block");
            Connection conn = database.connMethod();
            Statement stmt = conn.createStatement();
            String query =  "SELECT * from patient ";
            ResultSet rs = conn.createStatement().executeQuery(query);
            System.out.println(" connection created and executed");


            for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                final int j = i;
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
                //TableColumn col = new TableColumn(rsmd.getColumnLabel(i));
                col.setCellValueFactory((Callback<TableColumn.CellDataFeatures<ObservableList, String>,
                                        ObservableValue<String>>) param -> new SimpleStringProperty(param.getValue().get(j).toString()));

                tbl.getColumns().addAll(col);

            }
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                    //Iterate Column
                    row.add(rs.getString(i));
                }

                data.add(row);

            }
            tbl.setItems(data);
        }catch(Exception e){
            al = new Alert(Alert.AlertType.INFORMATION);
            al.setContentText("you are not connected to Database");

        }


    }
    @FXML
    private void showPatient(){
        showMethod();

    }
}
