package Sockets.Send_Any_File.UDP;

import javax.xml.crypto.Data;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Server {
    static final int PORT = 44_444;
    static final int PACKET_SIZE = 4096;

    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)) {
            System.out.println("UDP Server is running on port: " + PORT + "...");

            byte[] buffer = new byte[PACKET_SIZE];

            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            datagramSocket.receive(packet);

            String fileName = new String(packet.getData(), 0, packet.getLength());
            System.out.println("File received: " + fileName);
            datagramSocket.receive(packet);
            long fileSize = Long.parseLong(new String(packet.getData(), 0, packet.getLength()));
            System.out.println("File size: " + fileSize);

            try (FileOutputStream fileOutputStream = new FileOutputStream("received_" + fileName)) {
                long totalBytesReceived = 0;
                while (totalBytesReceived < fileSize) {
                    packet = new DatagramPacket(buffer, buffer.length);
                    datagramSocket.receive(packet);
                    fileOutputStream.write(packet.getData(), 0, packet.getLength());
                    totalBytesReceived += packet.getLength();
                    System.out.println("Packed received. Total bytes received so far: " + totalBytesReceived);
                }
                System.out.println("File received");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
