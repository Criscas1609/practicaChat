module com.example.practicasocket {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires java.logging;
    requires java.desktop;

    opens com.example.practicasocket to javafx.fxml;
    exports com.example.practicasocket;
    opens com.example.practicasocket.controller to javafx.fxml;
    opens com.example.practicasocket.service to javafx.fxml;
    opens com.example.practicasocket.utils to javafx.fxml;
}