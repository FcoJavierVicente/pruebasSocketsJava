/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author bitde
 */
public class SimpleSocketServer {
    public static void main(String args[]) throws Exception {
    ServerSocket serverSocket;
    int portNumber = 1777;
    Socket socket;
    String str;

    str = " <?xml version=\"1.0\" encoding=\"UTF-8\"?>";
    str += "<ticketRequest><customer custID=\"1\">";
    str += "</ticketRequest>";

    serverSocket = new ServerSocket(portNumber);

    System.out.println("Waiting for a connection on " + portNumber);

    socket = serverSocket.accept();

    ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

    oos.writeObject(str);

    oos.close();

    socket.close();

  }
}
