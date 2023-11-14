import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) {
        System.out.println("Client Started");
        try {
            Socket  clientSocket =  new Socket("127.0.0.1",9000);

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
