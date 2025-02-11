package Sockets.Send_Any_File.UDP;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    static final int PORT = 44_444;
    static final String HOST = "localhost";
    static final int PACKET_SIZE = 4096;

    public static void main(String[] args) {
        //File file = new File("C:\\DAM\\ImageRep\\HalloweenBackGroundSignIn.jpg");
        File file = new File("C:\\DAM\\ImageRep\\halloweenPumpkin.png");

        try (DatagramSocket datagramSocket = new DatagramSocket();
             FileInputStream fileInputStream = new FileInputStream(file)) {

            InetAddress serverAddress = InetAddress.getByName(HOST);

            sendString(datagramSocket, file.getName(), serverAddress);
            sendString(datagramSocket, Long.toString(file.length()), serverAddress);

            byte[] buffer = new byte[PACKET_SIZE];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);
                datagramSocket.send(packet);
            }
            System.out.println("File sent from client to server");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void sendString(DatagramSocket datagramSocket, String message, InetAddress serverAddress) {
        byte[] buffer = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, serverAddress, PORT);
        try {
            datagramSocket.send(packet);
        } catch (IOException e) {}
    }
}