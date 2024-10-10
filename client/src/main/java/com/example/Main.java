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
        String tastiera = "";
        Scanner sc = new Scanner(System.in);

        do {
            System.out.println("Inserire una parola:");
            tastiera = sc.nextLine();
            
            if(tastiera.equals("exit")){
                out.writeBytes("?" + '\n');
            }
            else{
                out.writeBytes(tastiera + '\n');
                String stringaRic = in.readLine();
                System.out.println("La stringa ricevuta: " + stringaRic);
            }
            
        } while (!tastiera.equals("exit"));

        System.out.println("client terminato!");
    }
}