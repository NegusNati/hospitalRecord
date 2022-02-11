module com.example.hospitalrecord {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires ojdbc14;
    requires java.sql;
    requires java.desktop;

    exports com.example.hospitalrecord.controllers;
    opens com.example.hospitalrecord.controllers to javafx.fxml;
    exports com.example.hospitalrecord;
    opens com.example.hospitalrecord to javafx.fxml;
}