module com.zelmex.lab4_2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.lab4_2 to javafx.fxml;
    exports com.zelmex.lab4_2;
}