package Sockets.Send_Any_File.TCP;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    static final int PORT = 44_444;
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            boolean isFinished = false;
            System.out.println("TCP Server is running on port: " + PORT + "...");

            while (!isFinished) {
                Socket connectionSocket = serverSocket.accept();
                System.out.println("Client connected: " + connectionSocket.getInetAddress());

                try (DataInputStream dataInputStream = new DataInputStream(connectionSocket.getInputStream());
                     FileOutputStream fileOutputStream = new FileOutputStream("received_" + dataInputStream.readUTF())) {

                    // Structure of the package: String | Size | Information
                    long fileSize = dataInputStream.readLong();
                    System.out.println("File size: " + fileSize);
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    long totalBytesRead = 0;
                    while (totalBytesRead < fileSize && (bytesRead = dataInputStream.read(buffer)) != -1) {
                        fileOutputStream.write(buffer, 0, bytesRead);
                        totalBytesRead += bytesRead;
                    }
                    System.out.println("File received");
                    isFinished = true;
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
