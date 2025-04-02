package com.main.chatty;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class ServerInitializer extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/Server.fxml")));
        stage.setScene(new Scene(parent));
        stage.setTitle("Server");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args){
        launch(args);
    }
}
