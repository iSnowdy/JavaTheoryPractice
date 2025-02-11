package Sockets.Basic.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    static final int SERVER_PORT = 44_444;

    public static void main(String[] args) {

        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] sendBuffer = new byte[1024];
            byte[] receiveBuffer = new byte[1024];

            System.out.println("Initializing UDP client...");
            // When we create a DatagramSocket without specifying a port, Java automatically
            // generates a port for us. And we do not need it since we won't be answering per se to the server.
            // The server, using the packet we send, can find out the client's IP and port
            InetAddress serverAddress = InetAddress.getByName("localhost");

            String messageToSend = "Hello Server!";
            sendBuffer = messageToSend.getBytes();
            DatagramPacket packetToSend = new DatagramPacket(sendBuffer, sendBuffer.length, serverAddress, SERVER_PORT);
            datagramSocket.send(packetToSend);
            System.out.println("Message sent to server");

            System.out.println("Waiting for response from server...");
            DatagramPacket responsePacket = new DatagramPacket(receiveBuffer, receiveBuffer.length);
            datagramSocket.receive(responsePacket);
            String responseFromServer = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Response from server: " + responseFromServer);

            datagramSocket.close();
            System.out.println("UDP client closed");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
