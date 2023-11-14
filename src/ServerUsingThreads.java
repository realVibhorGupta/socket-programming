import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerUsingThreads {
    public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8080);

        // Start a new thread to handle each incoming client connection
        while (true) {
            Socket socket = serverSocket.accept();

            // Create a new thread to handle the client connection
            new Thread(() -> {
                try {
                    // Create an input stream to receive data from the client
                    InputStream inputStream = socket.getInputStream();

                    // Create an output stream to send data to the client
                    OutputStream outputStream = socket.getOutputStream();

                    // Receive data from the client
                    byte[] data = new byte[1024];
                    int length = inputStream.read(data);

                    // Send data to the client
                    outputStream.write(data, 0, length);

                    // Close the socket
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
