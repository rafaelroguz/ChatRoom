package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {

    private final static int PORT = 5000;

    private static ArrayList<ChatRoom> chatRooms;

    public ChatServer () {
        this.chatRooms = new ArrayList<>();
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);

            System.out.println("Se inicio el servidor en el puerto " + PORT);

            while (true) {
                Socket clientSocket = serverSocket.accept();

                System.out.println("Nuevo cliente " + clientSocket.getInetAddress());

                ClientThread client = new ClientThread(clientSocket, chatRooms);
                client.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}