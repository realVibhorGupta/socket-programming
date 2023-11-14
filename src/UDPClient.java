import java.io.IOException;
import java.net.*;

public class UDPClient {

    public static void main(String[] args){

        try {
            DatagramSocket socketClient = new DatagramSocket();
            System.out.println("Client getting Started");

            String message = "Hey I am client";
            byte[] b =  message.getBytes();
            InetAddress inetAddress = InetAddress.getByName("localhost");
//            InetAddress inetAddress4 = Inet4Address.getByName("localhost");
//            InetAddress inetAddress6 = Inet6Address.getByName("localhost");
            DatagramPacket datagramPacket =  new DatagramPacket(b,b.length,inetAddress,4000);
            socketClient.send(datagramPacket);
            System.out.println("Packet Sent....");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
