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
        server = new Socket(InetAddress.getLocalHost(), portNumber);
        
        ObjectOutputStream oos = new ObjectOutputStream(server.getOutputStream());
        ObjectInputStream ois = new ObjectInputStream(server.getInputStream()); 
        
        String output = "";
        String str = "";
        while(!"adios".equals(str)){
            System.out.println("INtroduce un mensaje: ");
            str = sc.nextLine();
            oos.writeObject(str);    
            output = (String) ois.readObject();
            System.out.println(output);
        }
        
        
        oos.close();
        ois.close();
        server.close();
        
        
    }
    
}
