package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;


public class Client {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            try {

                System.out.println("Client start");
                //remote socket
                Socket socket = new Socket("localhost", 3000);

                //request to the server
                System.out.println("Message from client : ");
                String message = scanner.nextLine();

                //send the data
                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message);
                dataOutputStream.flush();

                System.out.println("Message sent!");


                //catch message send by server

                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message1 = dataInputStream.readUTF();
                System.out.println("Message received!" + message1);

                socket.close();

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}