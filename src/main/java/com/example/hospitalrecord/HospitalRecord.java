package com.example.hospitalrecord;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;


public class HospitalRecord extends Application {

    public static String dateMain;
    public static String timeMain;
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(HospitalRecord.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle(" HOSPITAL RECORD MANAGMENT SYSTEM");
        stage.setScene(scene);
        stage.show();}

    public static void main(String[] args) {
        Date date = new Date();
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd ");
        dateMain = String.valueOf(java.time.LocalDate.now());
        SimpleDateFormat formatTime = new SimpleDateFormat("hh.mm aa");
        String time = formatTime.format(date);
        timeMain = time;

        launch(args);}
}