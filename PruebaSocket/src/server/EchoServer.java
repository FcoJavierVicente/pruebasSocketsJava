/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bitde
 */
public class EchoServer {
    public static void main(String args[]) throws Exception{
        ServerSocket serverSocket;
        int port = 80;
        Socket client;
        String str = "ECHO: ";
        serverSocket = new ServerSocket(port);
        System.out.println("Esperando conexion en: "+ InetAddress.getLocalHost()+"...");
        client = serverSocket.accept();
        System.out.println("Conectado.");
        
        String input = "";
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        while(!"adios".equals(input)){
            input = (String) ois.readObject();
            System.out.println(input);
            oos.writeObject(str+input);
        }
        
        ois.close();
        oos.close();
        client.close();
    }
}
