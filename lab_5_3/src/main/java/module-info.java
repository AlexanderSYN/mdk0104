module ru.zelmex.lab_5_3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.zelmex.lab_5_3 to javafx.fxml;
    exports ru.zelmex.lab_5_3;
}