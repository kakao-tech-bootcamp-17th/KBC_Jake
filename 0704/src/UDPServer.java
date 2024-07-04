import java.io.*;
import java.net.*;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket socket = new DatagramSocket(8080);
            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            System.out.println("UDP 서버가 8080 포트에서 대기 중입니다.");
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            System.out.println("수신된 데이터: " + received);

            String response = "Hello, UDP Client!";
            DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.getBytes().length, packet.getAddress(), packet.getPort());
            socket.send(responsePacket);

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
