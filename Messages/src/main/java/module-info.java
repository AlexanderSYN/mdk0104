module com.zelmex.putmessage {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.messages to javafx.fxml;
    exports com.zelmex.messages;
}