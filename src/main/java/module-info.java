module com.example.hospitalrecord {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.hospitalrecord to javafx.fxml;
    exports com.example.hospitalrecord;
}