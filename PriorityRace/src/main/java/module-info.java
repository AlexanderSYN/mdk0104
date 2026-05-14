module com.zelmex.priorityrace {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.priorityrace to javafx.fxml;
    exports com.zelmex.priorityrace;
}