module com.zelmex.lab {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.lab to javafx.fxml;
    exports com.zelmex.lab;
}