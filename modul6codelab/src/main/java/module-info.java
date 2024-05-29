module com.example.modul6codelab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.modul6codelab to javafx.fxml;
    exports com.example.modul6codelab;
}