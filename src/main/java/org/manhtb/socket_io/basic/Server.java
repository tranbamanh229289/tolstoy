package org.manhtb.socket_io.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void connect() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            System.out.println("Server ready");
            System.out.println("====================");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String messageRequest = "";
            String messageResponse = "";
            while (true) {
                messageResponse = dataInputStream.readUTF();
                if(messageResponse.equals(":q")) {
                    break;
                }
                System.out.println(messageResponse);
                messageRequest = bufferedReader.readLine();
                dataOutputStream.writeUTF(messageRequest);
                if(messageRequest.equals(":q")) {
                    break;
                }
                dataOutputStream.flush();
            }
            serverSocket.close();
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.connect();
    }
}
