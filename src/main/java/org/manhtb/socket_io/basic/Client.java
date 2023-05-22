package org.manhtb.socket_io.basic;

import java.io.*;
import java.net.Socket;

public class Client {
    public void connect() {
        try {
            Socket socket = new Socket("localhost", 1234);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());

            String messageRequest = "";
            String messageResponse = "";

            while (true) {
                messageRequest = bufferedReader.readLine();
                dataOutputStream.writeUTF(messageRequest);
                if(messageRequest.equals(":q")) {
                    break;
                }
                messageResponse = dataInputStream.readUTF();
                if(messageResponse.equals(":q")) {
                    break;
                }
                System.out.println(messageResponse);
                dataOutputStream.flush();
            }
            socket.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }
}
