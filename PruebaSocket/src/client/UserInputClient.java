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
        Scanner sc = new Scanner(System.in);
        Socket server;
        int portNumber = 80;
        System.out.print("Direccion del servidor: ");
        String dir = sc.nextLine();
        //establecer comunicacion con el servidor
        if(dir.equals(""))
            server = new Socket(InetAddress.getLocalHost(), portNumber);
        else
            server = new Socket(dir, portNumber);
        //canal de salida de datos hacia servidor
        ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
        //canal de entrada de datos desde servidor
        ObjectInputStream ois = new ObjectInputStream(server.getInputStream()); 
        
        String output = "";
        String str = "";
        while(!"adios".equals(str)){
            System.out.println("INtroduce un mensaje: ");
            str = sc.nextLine();
            //manda mensaje
            oos.writeObject(str);    
            //recibe respuesta
            output = (String) ois.readObject();
            System.out.println(output);
        }
        
        //cierra canal de salida
        oos.close();
        //cierra canal de entrada
        ois.close();
        //cierra comunicacion
        server.close();
        
        
    }
    
}
