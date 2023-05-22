package org.manhtb.socket_io.chatroom;

import java.io.*;
import java.net.Socket;

public class Client {
    public void connect() {
        try {
            Socket socket = new Socket("localhost", 1234);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            Thread readerThread = new Thread() {
                @Override
                public void run() {
                    String s = "";
                    while (true) {
                        try {
                            s = bufferedReader.readLine();
                            dataOutputStream.writeUTF(s);
                        } catch (IOException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            };

            Thread writerThread = new Thread() {
                String res = "";
                @Override
                public void run() {
                    while (true) {
                        try {
                            res = dataInputStream.readUTF();
                            System.out.println(res);
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            };
            readerThread.start();
            writerThread.start();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }
}
