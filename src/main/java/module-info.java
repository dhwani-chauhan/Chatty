module com.main.chatty {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;

    opens com.main.chatty to javafx.fxml;
    exports com.main.chatty;
    exports com.main.chatty.Controller;
    opens com.main.chatty.Controller to javafx.fxml;
}