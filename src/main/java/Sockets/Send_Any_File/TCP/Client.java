package Sockets.Send_Any_File.TCP;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class Client {
    private static final String HOST = "localhost";
    private static final int PORT = 44_444;

    public static void main(String[] args) {
        File file = new File("C:\\DAM\\ImageRep\\halloweenPumpkin.png");

        try (Socket connectionSocket = new Socket(HOST, PORT);
             DataOutputStream dataOutputStream = new DataOutputStream(connectionSocket.getOutputStream());
             FileInputStream fileInputStream = new FileInputStream(file)) {

            dataOutputStream.writeUTF(file.getName());
            dataOutputStream.writeLong(file.length());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                dataOutputStream.write(buffer, 0, bytesRead);
            }
            System.out.println("File sent");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
