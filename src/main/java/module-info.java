module com.example.semesterprojektfebruar2024 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires java.sql;

    opens com.example.semesterprojektfebruar2024 to javafx.fxml;
    exports com.example.semesterprojektfebruar2024;
}