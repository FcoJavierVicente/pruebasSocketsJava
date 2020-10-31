/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author bitde
 */
public class UserInputClient {  
    public static void main(String args[]) throws Exception{
        ClientLogic client;
        Scanner sc = new Scanner(System.in);
        System.out.print("Direccion del servidor: ");
        String dir = sc.nextLine();
        //establecer comunicacion con el servidor
        if(dir.equals(""))
            client = new ClientLogic();
        else
            client = new ClientLogic(80,dir);
        client.connect();
        
        String output = "";
        String str = "";
        while(!"adios".equals(str)){
            System.out.println("INtroduce un mensaje: ");
            str = sc.nextLine();
            //manda mensaje
            client.send(str);
            //recibe respuesta
            output = client.receive();
            System.out.println(output);
        }
        
        client.disconect();
    }
    
    
    
}
