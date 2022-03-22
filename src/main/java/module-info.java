module com.example.lab2javafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lab2javafx to javafx.fxml;
    exports com.example.lab2javafx;
}