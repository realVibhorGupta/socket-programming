import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class DetermineActivePorts {

    public static void main(String[] args) {
        Socket portCheck;
        String host = "localhost";

        // Defining the hostName to check for port
        // availability
        if (args.length > 0) {
            host = args[0];
        }
        for (int portNumber = 0; portNumber < 1024; portNumber++) {
            try {
                System.out.println("Looking for " + portNumber);
                portCheck = new Socket(host, portNumber);
                System.out.println(
                        "There is a server running on port "
                                + portNumber);
                System.out.println(portCheck);
            }
            catch (UnknownHostException e) {
                System.out.println("Exception occurred" + e);
                break;
            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
