package Sockets.Basic.TCP;

import javax.sound.sampled.Port;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 44_444;
    public static void main(String[] args) {
        ServerSocket serverSocket = null; // This is the server's socket
        Socket socket = null; // This is the client's socket
        boolean listening = true;

        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            serverSocket = new ServerSocket(PORT); // By default, as a Server it listens to localhost or public IP
            System.out.println("Server is running on port: " + PORT + "...");

            while (listening) {
                // When we call accept(), program will stop here and wait for a client connection
                socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress());

                // We need to create a "bridge", a connection between the Client and the Server.
                // Client -> Server (InputStream) | Server -> Client (OutputStream)
                dataInputStream = new DataInputStream(socket.getInputStream()); // Receives client messages
                dataOutputStream = new DataOutputStream(socket.getOutputStream()); // Sends to client

                String clientMessage = dataInputStream.readUTF();
                System.out.println("Client's message: " + clientMessage);

                String serverMessage = "Hello Client!";
                dataOutputStream.writeUTF(serverMessage);
                System.out.println("Sending message to client: " + serverMessage);

                // This closes the client's connection; not the server!
                socket.close();
                System.out.println("Client connection closed");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
