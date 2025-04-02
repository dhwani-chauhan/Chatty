package com.main.chatty.Controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerController {
    @FXML
    private AnchorPane root;
    @FXML
    private TextArea txtChat;
    @FXML
    private Button btnSend;
    @FXML
    private TextField txtMessage;

    ServerSocket serverSocket;
    Socket socket;
    DataInputStream dataInputStream;
    DataOutputStream dataOutputStream;
    String message = "";
    String reply = "";

    public void initialize(){
        new Thread(() -> {
            try{
                serverSocket = new ServerSocket(4002);
                txtChat.appendText("Server is Started.");
                socket = serverSocket.accept();
                txtChat.appendText("\nClient is Accepted.");
                dataInputStream = new DataInputStream(socket.getInputStream());
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                while (!message.equals("bye")){
                    message = dataInputStream.readUTF();
                    txtChat.appendText("\nClient: " + message);
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }).start();
    }

    public void btnSendOnAction(javafx.event.ActionEvent actionEvent) throws IOException{
        dataOutputStream.writeUTF(txtMessage.getText().trim());
        dataOutputStream.flush();
        String message = txtMessage.getText();
        txtChat.appendText("\nServer: " + message);
        txtMessage.clear();
    }

}
