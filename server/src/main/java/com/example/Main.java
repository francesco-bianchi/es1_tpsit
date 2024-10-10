package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("server partito!");

        ServerSocket serverSocket = new ServerSocket(3000);
        Socket socket = serverSocket.accept();
        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        String stringaRic = "";

        do {
            System.out.println("un client è entrato!");

            stringaRic = in.readLine();
            System.out.println("La stringa ricevuta: " + stringaRic);

            if(!stringaRic.equals("?")){
                String stringMaiusc = stringaRic.toUpperCase();
                out.writeBytes(stringMaiusc + '\n');
            }

        } while (!stringaRic.equals("?"));
        
        System.out.println("server terminato!");
        serverSocket.close();
        socket.close();
    }
}