import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {

        try {
            DatagramSocket socketServer = new DatagramSocket(4000);

            System.out.println("Server getting Started");
            byte[] b = new byte[1000];

            DatagramPacket datagramPacket =  new DatagramPacket(b,b.length);
            socketServer.receive(datagramPacket);
            String string =  new String(datagramPacket.getData());
            System.out.println("Received: " + string);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
