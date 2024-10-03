package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException {
        System.out.println("client partito!");

        Socket socket = new Socket("localhost", 3000);

        BufferedReader in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        
        Scanner sc = new Scanner(System.in);
        String tastiera = sc.nextLine();
        out.writeBytes(tastiera + '\n');

        String stringaRic = in.readLine();
        System.out.println("La stringa ricevuta: " + stringaRic);

        

        System.out.println("client terminato!");
    }
}