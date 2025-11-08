/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azc.uam.mx;

import java.io.Serializable;
import java.time.LocalTime;

/**
 * Clase consulta
 * @author Alvarez Perez Ulises
 * @version 11/2025
 */
public class Consulta implements Serializable {
    
    private String texto;
    private LocalTime tiempo;

    /**
     * Metodo constructor por omision de la clase consulta
     */
    public Consulta() {
    }
    
    /**
     * Metodo constructor por parametros de la clase consulta
     * @param texto correspondiente al texto ingresado por el usuario
     */
    public Consulta(String texto) {
        this.texto = texto;
        this.tiempo = LocalTime.now();
    }

    /**
     * Metodo de acceso de la clase consulta que permite obtener el valor del atributo "texto"
     * @return 
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Metodo de acceso de la clase consulta que permite modificar el valor del atributo "texto"
     * @param texto 
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * Metodo de acceso de la clase consulta que permite obtener el valor del atributo "tiempo"
     * @return 
     */
    public LocalTime getTiempo() {
        return tiempo;
    }

    /**
     * Metodo de acceso de la clase consulta que permite modificar el valor del atributo "tiempo"
     * @param tiempo 
     */
    public void setTiempo(LocalTime tiempo) {
        this.tiempo = tiempo;
    } 
    
}
