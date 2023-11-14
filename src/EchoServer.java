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
            ServerSocket socketServer = new ServerSocket(9000);

            Socket serverSocket = socketServer.accept();
            System.out.println("Connection established");

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(serverSocket.getInputStream()));
            String string =  bufferedReader.readLine();
            PrintWriter printWriter = new PrintWriter(serverSocket.getOutputStream(),true);
            printWriter.println("Server Says:" + string );

        } catch (IOException e) {
            throw new SecurityException(e);
        }
    }
}
