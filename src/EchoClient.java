import java.io.*;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("Client Started");
        try {
            Socket  clientSocket =  new Socket("127.0.0.1",9000);
            // to send data to the server
            DataOutputStream dos
                    = new DataOutputStream(
                    clientSocket.getOutputStream());

            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a string");
            String string =  userInput.readLine();
            PrintWriter printWriter = new PrintWriter(clientSocket.getOutputStream(),true);
            printWriter.println(string);


            BufferedReader bR = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println(bR.readLine());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
