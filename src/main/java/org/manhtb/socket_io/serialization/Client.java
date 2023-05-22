package socket.serialization;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client {
    public void connect() {
        try {
            Socket socket = new Socket("localhost", 1234);
            Book book = new Book("Miserables", "Victor Hugo", true, 300000d);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectOutputStream.writeObject(book);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.connect();
    }
}
