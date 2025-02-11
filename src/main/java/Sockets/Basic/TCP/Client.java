package Sockets.Basic.TCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    static final String HOST = "localhost"; // 127.0.0.1
    static final int PORT = 44_444;
    public static void main(String[] args) {
        Socket socket = null;
        // When use different types of Streams? DataInput, BufferedReader...
        DataInputStream dataInputStream = null;
        DataOutputStream dataOutputStream = null;

        try {
            socket = new Socket(HOST, PORT);

            dataInputStream = new DataInputStream(socket.getInputStream());
            dataOutputStream = new DataOutputStream(socket.getOutputStream()); // why not use a serversocket for client?

            // We first write a message out to the server. The server is waiting a message, so we must first establish
            // connection and send a message so we can get an answer from it
            String messageToServer = "Hello Server!";
            dataOutputStream.writeUTF(messageToServer);
            System.out.println("Sending message to server: " + messageToServer);

            String messageFromServer = dataInputStream.readUTF();
            System.out.println("Message from server: " + messageFromServer);

            socket.close();
            System.out.println("Connection closed");


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
