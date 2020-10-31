/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author bitde
 */
public class ClientLogic {
    private int port = 0;
    private String dir = "";
    private Socket server;
    private ObjectOutputStream oos;
    private ObjectInputStream ois;
    
    public ClientLogic() {
        this.port = 80;
        this.dir = "localhost";
    }
    
    public ClientLogic(int port, String dir) {
        this.port = port;
        this.dir = dir;
    }
    
    public void connect() throws IOException {
        //establecer comunicacion con el servidor
        this.server = new Socket(dir, this.port);
        //canal de salida de datos hacia servidor
        this.oos = new ObjectOutputStream(server.getOutputStream());
        //canal de entrada de datos desde servidor
        this.ois = new ObjectInputStream(server.getInputStream());
    }
    
    public void send(String str) throws IOException{
        this.oos.writeObject(str);
    }
    public String receive() throws IOException, ClassNotFoundException{
        return (String) this.ois.readObject();
    }
    
    public void disconect() throws IOException{
        //cierra canal de salida
        this.oos.close();
        //cierra canal de entrada
        this.ois.close();
        //cierra comunicacion
        this.server.close();
    }
}
