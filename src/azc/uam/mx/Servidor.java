/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azc.uam.mx;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase Servidor
 * @author Alvarez Perez Ulises
 * @version 11/2025
 */
public class Servidor {
    public static void main(String[] args) {
        
        ServerSocket servidor;
        Socket s1;
        Consulta consulta = null;
        MiniBot bot;
        ObjectOutputStream out;
        ObjectInputStream in;
        
        try{
            servidor = new ServerSocket(12345);
            while (true) {
                System.out.println("\nServidor en espera de conexiones...");
                
                // Aceptar conexión del cliente
                s1 = servidor.accept();
                System.out.println("Conexión aceptada desde: " + s1.getInetAddress());
                
                // Deserializar el objeto Consulta recibido
                in = new ObjectInputStream(s1.getInputStream());
                consulta = (Consulta) in.readObject();
                System.out.println("Objeto Deserializado...");
                System.out.println("Mensaje recibido: " + consulta.getTexto());
                
                // Procesar la consulta con el MiniBot
                bot = new MiniBot(consulta);
                String respuesta = bot.respuesta(consulta);
                System.out.println("Respuesta generada");
                
                // Enviar la respuesta al cliente
                System.out.println("Enviando respuesta...");
                out = new ObjectOutputStream(s1.getOutputStream());
                out.writeObject(respuesta);
                
                // Cerrar streams y socket del cliente
                out.close();
                in.close();
                s1.close();
                System.out.println("Conexión cerrada");
            }
            
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
