import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class EchoServer {

    public static void main(String[] args) {
        System.out.println("Waiting for the Clients");

        //It contains port Number
        try {
            // Create server Socket

            ServerSocket socketServer = new ServerSocket(9000);
            // connect it to client socket
            Socket serverSocket = socketServer.accept();
            System.out.println("Connection established");
            // to read data coming from the client
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            String string =  bufferedReader.readLine();
            // to send data to the client
            PrintWriter printWriter = new PrintWriter(serverSocket.getOutputStream(),true);
            printWriter.println("Server Says:" + string );
// close connection
            printWriter.close();
            bufferedReader.close();
            socketServer.close();
            serverSocket.close();

            // terminate application
            System.exit(0);
        } catch (IOException e) {
            throw new SecurityException(e);
        }
    }
}
