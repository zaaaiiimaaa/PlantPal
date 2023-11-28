module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;
    requires java.mail;
    requires quartz;
    requires java.desktop;

    opens com.example.demo6 to javafx.fxml;
    exports com.example.demo6;
}