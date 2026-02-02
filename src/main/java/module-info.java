module org.example.csc311_assignment01_gettingstarted {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.csc311_assignment01_gettingstarted to javafx.fxml;
    exports org.example.csc311_assignment01_gettingstarted;
}