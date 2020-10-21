/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;



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
        //abrir canal para conexiones entrantes
        serverSocket = new ServerSocket(port);
        System.out.println("Esperando conexion en: "+ InetAddress.getLocalHost()+"...");
        //aceptar conexion entrante
        client = serverSocket.accept();
        System.out.println("Conectado.");
        
        String input = "";
        //abrir entrada de datos para la conexion
        ObjectInputStream ois = new ObjectInputStream(client.getInputStream());
        //abrir salida de datos para la conexion
        ObjectOutputStream oos = new ObjectOutputStream(client.getOutputStream());
        while(!"adios".equals(input)){
            //recibir mensaje
            input = (String) ois.readObject();
            System.out.println(input);
            //mandar respuesta
            oos.writeObject(str+input);
        }
        //cerrar canal de entada
        ois.close();
        //cerrar canal de salida
        oos.close();
        //cerrar comunicacion
        client.close();
    }
}
