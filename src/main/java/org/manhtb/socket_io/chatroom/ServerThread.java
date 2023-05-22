package org.manhtb.socket_io.chatroom;

import java.io.*;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket;
    private int idClient;
    private IPublish publish;

    ServerThread(Socket socket, int idClient, IPublish publish) {
        this.socket = socket;
        this.idClient = idClient;
        this.publish = publish;
    }

    @Override
    public void run() {
        try {
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            while (true){
                String response = dataInputStream.readUTF();
                if (response.equals(":q")) {
                    break;
                }
                String message = "Client " + idClient + ": " + response;
                publish.publishMessage(message, this.socket);
            }
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
