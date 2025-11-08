/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azc.uam.mx;

/**
 * Clase Cliente
 * @author Alvarez Perez Ulises
 * @version 11/2025
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        
        Socket cliente;
        Consulta consulta;
        String mensaje;
        String respuesta;
        ObjectOutputStream out;
        ObjectInputStream in;
        Scanner sc;
        
        try {
            cliente = new Socket("localhost", 12345);
            System.out.println("Conectado al servidor");
            
            sc = new Scanner(System.in);
            System.out.print("Escribe tu consulta: ");
            mensaje = sc.nextLine();
            
            // Crear objeto Consulta
            consulta = new Consulta(mensaje);
            System.out.println("Objeto Consulta creado");
            
            // Serializar y enviar la consulta
            System.out.println("Enviando consulta...");
            out = new ObjectOutputStream(cliente.getOutputStream());
            out.writeObject(consulta);
            
            // Recibir respuesta del servidor
            System.out.println("Esperando respuesta...");
            in = new ObjectInputStream(cliente.getInputStream());
            respuesta = (String) in.readObject();
            System.out.println("Respuesta recibida:");
            System.out.println(respuesta);
            
            // Cerrar streams y socket
            out.close();
            in.close();
            cliente.close();
            sc.close();
            System.out.println("Conexión cerrada");
            
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
}
