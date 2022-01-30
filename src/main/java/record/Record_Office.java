package record;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;


import java.util.Objects;


public class Record_Office extends Application {



    @Override
    public void start(Stage stage)  {
       try{
           Parent root =  FXMLLoader.load(getClass().getResource("record.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Record !");
        stage.setScene(scene);
        stage.show();}catch(Exception e){
           e.printStackTrace();
       }
    }
    public static void main(String[] args) {
        launch(args);
    }
}
