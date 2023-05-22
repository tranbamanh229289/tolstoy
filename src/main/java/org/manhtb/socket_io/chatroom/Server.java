package org.manhtb.socket_io.chatroom;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {
    private static List<Socket> sockets = new ArrayList<>();
    public void connect() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Integer id = 0;
            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println(String.format("Client %d is joined", id));
                sockets.add(socket);
                new Thread(new ServerThread(socket, id, Server::publishMessage)).start();
                id ++;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void publishMessage(String message, Socket currentSocket) {
        sockets.forEach(item -> {
            System.out.println(message);
            if (!item.equals(currentSocket)) {
                try {
                    DataOutputStream dataOutputStream = new DataOutputStream(item.getOutputStream());
                    dataOutputStream.writeUTF(message);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        });
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.connect();
    }
}
