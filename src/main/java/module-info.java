module com.example.wikimon_app {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.wikimon_app to javafx.fxml;
    exports com.example.wikimon_app;
}