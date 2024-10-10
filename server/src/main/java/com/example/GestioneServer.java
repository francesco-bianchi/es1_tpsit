package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class GestioneServer extends Thread{

    Socket socket;

    GestioneServer(Socket socket){
        this.socket = socket;
    }

    public void run() {
        try{
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
            
            System.out.println("thread terminato!");
        }
        catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
