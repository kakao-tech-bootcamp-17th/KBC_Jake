import java.io.*;
import java.net.*;

public class UDPClient {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket();
            String message = "Hello, UDP Server!";
            InetAddress address = InetAddress.getByName("localhost");
            DatagramPacket packet = new DatagramPacket(message.getBytes(), message.getBytes().length, address, 8080);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String received = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("수신된 데이터: " + received);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
