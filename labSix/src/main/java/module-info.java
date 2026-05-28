module com.zelmex.labsix {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.labsix to javafx.fxml;
    exports com.zelmex.labsix;
}