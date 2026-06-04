module ru.zelmex.demo1alex {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.zelmex.demo1alex to javafx.fxml;
    exports ru.zelmex.demo1alex;
}