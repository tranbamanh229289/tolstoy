package socket.serialization;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public void connect() {
        try {
            ServerSocket serverSocket = new ServerSocket(1234);
            Socket socket = serverSocket.accept();
            System.out.println("Server ready");
            System.out.println("========================");

            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());
            Book book = (Book) objectInputStream.readObject();
            System.out.println(book.toString());

        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Server server = new Server();
        server.connect();
    }
}
