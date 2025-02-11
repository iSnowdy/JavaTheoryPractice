package Sockets.Basic.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Server {
    static final int PORT = 44_444;

    public static void main(String[] args) {

        // Represents the connection between Server - Client. Through this, we will send the information (packets)
        try (DatagramSocket datagramSocket = new DatagramSocket(PORT)) {
            byte[] buffer = new byte[1024];
            System.out.println("Initializing UDP server...");
            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                datagramSocket.receive(receivedPacket);
                System.out.println("Packet received");
                String receivedMessageAsString = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Received message: " + receivedMessageAsString);
                System.out.println("Client Port: " + receivedPacket.getPort());
                System.out.println("Client IP: " + receivedPacket.getAddress());

                // Now, if we want to answer to the client, we need their address
                InetAddress clientAddress = receivedPacket.getAddress();
                int clientPort = receivedPacket.getPort();
                String responseToClient = "Hey there! Your information is: " + clientAddress + ":" + clientPort;
                buffer = responseToClient.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length, clientAddress, clientPort);
                datagramSocket.send(responsePacket);
                System.out.println("Response sent to client");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}