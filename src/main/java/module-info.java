module com.example.handman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.handman to javafx.fxml;
    exports com.example.handman;
}