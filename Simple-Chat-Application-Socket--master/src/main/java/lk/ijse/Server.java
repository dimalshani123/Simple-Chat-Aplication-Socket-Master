package lk.ijse;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {

            //server socket
            ServerSocket serverSocket = new ServerSocket(3000);

            while (true) {


                //local socket
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                //data reading option
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String message1 = dataInputStream.readUTF();

                //sout
                System.out.println("Message from client : " + message1);


                //server send message

                System.out.println("Message from server : ");
                String message2 = scanner.nextLine();

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataOutputStream.writeUTF(message2);
                dataOutputStream.flush();

                System.out.println("Message send successfully!");

                socket.close();
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }


}