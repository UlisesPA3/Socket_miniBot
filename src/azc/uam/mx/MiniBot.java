/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azc.uam.mx;

import java.time.Duration;
import java.time.LocalTime;

/**
 * Clase MiniBot
 * @author Alvarez Perez Ulises
 * @version 11/2025
 */
public class MiniBot {
    
    private Consulta cons;
    

     /**
     * Constructor por defecto de la clase MiniBot.
     * Crea una instancia de MiniBot sin una consulta asociada.
     */
    public MiniBot() {
    }

    /**
     * Constructor que inicializa el MiniBot con una consulta específica.
     * 
     * @param consulta objeto de tipo Consulta que contiene el mensaje a procesar
     *                 y la hora en que se realizó la consulta
     */
    public MiniBot(Consulta consulta) {
        this.cons = consulta;
    }
    
    
    /**
     * Metodo que elimina los signos de puntuacion(“,” “.” “¡” “!” “¿” “?” “(” “)”) de un texto
     * @param texto un String correspondiente al texto ingresado por el usuario
     * @return devuelve un String correspondiente al texto ingresado pero eliminando los signos de puntuacion
     */
    public String eliminarSignosPuntuacion(String texto){
        String res="";
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) != ',' && texto.charAt(i) != '.'&& texto.charAt(i) != '¡'&& texto.charAt(i) != '!'&& texto.charAt(i) != '?'&& texto.charAt(i) != '¿'&&texto.charAt(i) != '('&&texto.charAt(i) != ')')
                res+=texto.charAt(i);
        }
        return res;
    }
    /**
     * Metodo que permite contar el numero de signos de puntuacion(“,” “.” “¡” “!” “¿” “?” “(” “)”) existentes en el texto
     * @param texto un String correspondiente al texto ingresado por el usuario
     * @return devuelve un entero que corresponde al numero de signos de puntuacion encontrados en el texto
     */
    public int contarSignosPuntuacion(String texto){
        int contador = 0;
        for (int i = 0; i < texto.length(); i++) {
            if(texto.charAt(i) == ',' || texto.charAt(i) == '.'|| texto.charAt(i) == '¡' || texto.charAt(i) == '!' || texto.charAt(i) == '?' || texto.charAt(i) == '¿' || texto.charAt(i) == '(' || texto.charAt(i) == ')')
                contador++;
        }
        return contador;
    }
    
    /**
     * Metodo que elimina las palabras vacias("la", "de", "el", "del", "para", "este", "los", "a", "cuando", "son", "con", "al", "como", "cual", "que", "y") de un texto
     * @param texto un String correspondiente al texto ingresado por el usuario
     * @return devuelve un String correspondiente al texto ingresado pero eliminando las palabras vacias
     */
    public String textoLimpio(String texto){
        String textoSinSignosPuntuacion = eliminarSignosPuntuacion(texto);
        String[] palabras = textoSinSignosPuntuacion.split(" ");
        String textoLimpio= "";
        for(int i = 0; i < palabras.length; i++){
        String palabra = palabras[i];
            if(palabra.equalsIgnoreCase("la")|| palabra.equalsIgnoreCase("de")||palabra.equalsIgnoreCase("el")||palabra.equalsIgnoreCase("del")||palabra.equalsIgnoreCase("para")||palabra.equalsIgnoreCase("este")||palabra.equalsIgnoreCase("los")||palabra.equalsIgnoreCase("a")||palabra.equalsIgnoreCase("cuando")||palabra.equalsIgnoreCase("son")||palabra.equalsIgnoreCase("con")||palabra.equalsIgnoreCase("al")||palabra.equalsIgnoreCase("como")||palabra.equalsIgnoreCase("cual")||palabra.equalsIgnoreCase("que")||palabra.equalsIgnoreCase("y")){
            } else {
            textoLimpio += palabra + " ";
            }
        }  
        return textoLimpio;
    }

    
    /**
     * Metodo que permite contar el numero de palabras vacias("la", "de", "el", "del", "para", "este", "los", "a", "cuando", "son", "con", "al", "como", "cual", "que", "y") eliminadas de un texto
     * @param texto un String correspondiente al texto ingresado por el usuario
     * @return devuelve un entero que corresponde al numero de palabras vacias eliminadas en el texto ingresado
     */
    public int palabrasVacias(String texto){
        String textoSinSignosPuntuacion = eliminarSignosPuntuacion(texto);
        String[] palabras = textoSinSignosPuntuacion.split(" ");
        int palabrasVacias = 0;
        for(int i = 0; i < palabras.length; i++){
        String palabra = palabras[i];
            if(palabra.equalsIgnoreCase("la")|| palabra.equalsIgnoreCase("de")||palabra.equalsIgnoreCase("el")||palabra.equalsIgnoreCase("del")||palabra.equalsIgnoreCase("para")||palabra.equalsIgnoreCase("este")||palabra.equalsIgnoreCase("los")||palabra.equalsIgnoreCase("a")||palabra.equalsIgnoreCase("cuando")||palabra.equalsIgnoreCase("son")||palabra.equalsIgnoreCase("con")||palabra.equalsIgnoreCase("al")||palabra.equalsIgnoreCase("como")||palabra.equalsIgnoreCase("cual")||palabra.equalsIgnoreCase("que")||palabra.equalsIgnoreCase("y")){
                palabrasVacias++;
            } 
        }  
        return palabrasVacias;
    }

    
    /**
     * Metodo que permite contar el numero de palabras clave(palabras no vacias) que contiene un texto
     * @param texto un String correspondiente al texto ingresado por el usuario
     * @return devuelve un entero que corresponde al numero de palabras clave existentes en el texto 
     */
    public int palabrasClave(String texto){
        String textoSinSignosPuntuacion = eliminarSignosPuntuacion(texto);
        String[] palabras = textoSinSignosPuntuacion.split(" ");
        int palabrasClave = 0;
        for(int i = 0; i < palabras.length; i++){
        String palabra = palabras[i];
            if(palabra.equalsIgnoreCase("la")|| palabra.equalsIgnoreCase("de")||palabra.equalsIgnoreCase("el")||palabra.equalsIgnoreCase("del")||palabra.equalsIgnoreCase("para")||palabra.equalsIgnoreCase("este")||palabra.equalsIgnoreCase("los")||palabra.equalsIgnoreCase("a")||palabra.equalsIgnoreCase("cuando")||palabra.equalsIgnoreCase("son")||palabra.equalsIgnoreCase("con")||palabra.equalsIgnoreCase("al")||palabra.equalsIgnoreCase("como")||palabra.equalsIgnoreCase("cual")||palabra.equalsIgnoreCase("que")||palabra.equalsIgnoreCase("y")){
            } else {
            palabrasClave ++;
            }
        }  
        return palabrasClave;
    }
    
    /**
    * Método que busca y devuelve la respuesta adecuada según las palabras clave
    * encontradas en el texto limpio (sin palabras vacías).
    * 
    * <p>Evalúa el texto en el siguiente orden de prioridad:</p>
    * <ol>
    *   <li>Si contiene "uam" y "azcapotzalco" - Información de UAM Azcapotzalco</li>
    *   <li>Si contiene "uam" - Información general de UAM</li>
    *   <li>Si contiene "servicio" y "medico" - Información de servicio médico</li>
    *   <li>Si contiene "servicios" y "escolares" - Información de servicios escolares</li>
    *   <li>Si contiene "covid" o "coviuam" - Información de CoviUAM</li>
    *   <li>Si tiene al menos 3 palabras clave pero ninguna coincidencia - Mensaje de sin información</li>
    *   <li>Si tiene menos de 3 palabras clave - Mensaje de consulta no entendida</li>
    * </ol>
    * 
    * @param textoLimpio String con el texto de la consulta sin palabras vacías
    * @return String con la respuesta apropiada según las palabras clave encontradas
    */
    public String buscarRespuesta(String textoLimpio) {
        
        String textoMinusculas = textoLimpio.toLowerCase();

        // Contar palabras clave del texto limpio
        int numPalabrasClave = palabrasClave(textoLimpio);
        
        if (textoMinusculas.contains("uam") && textoMinusculas.contains("azcapotzalco")) {
            return "La Universidad Autónoma Metropolitana Unidad Azcapotzalco actualmente cuenta con 17 " +
                   "licenciaturas, divididas en 3 áreas de estudio.\n" +
                   "Visita: https://www.azc.uam.mx/";
        }
        if (textoMinusculas.contains("uam")) {
            return "Fundada en 1974 y con más de 200 mil personas egresadas, la UAM es una institución pública que " +
                   "ofrece en sus cinco unidades académicas.\n" +
                   "Visita: https://www.uam.mx/";
        }
        if (textoMinusculas.contains("servicio") && textoMinusculas.contains("medico")) {
            return "Proporcionamos atención médica a los miembros de la comunidad universitaria. Contamos con 5 " +
                   "médicos y 4 consultorios, solo debes presentar tu credencial de la UAM.\n" +
                   "Visita: https://csu.azc.uam.mx/medicos/";
        }
        if (textoMinusculas.contains("servicios") && textoMinusculas.contains("escolares")) {
            return "La Coordinación de Sistemas Escolares, administra los procesos, entre los que se encuentran el " +
                   "registro, seguimiento y control del ingreso, permanencia y egreso de los alumnos de Licenciatura y " +
                   "Posgrado.\n" +
                   "Visita: http://cse.azc.uam.mx/";
        }
        if (textoMinusculas.contains("covid") || textoMinusculas.contains("coviuam")) {
            return "Es una nueva aplicación para conocer el estado de salud de la comunidad UAM en el regreso " +
                   "presencial.\n" +
                   "Visita: https://coviuam.uam.mx/";
        }
        if (numPalabrasClave >= 3) {
            return "No tengo información acerca de esa consulta";
        }

        return "No entiendo tu consulta :(";
    }


    /**
     * Metodo que prepara la respuesta final del MiniBot
     * @param consulta un objeto que representa la consulta del usuario
     * @return devuelve un String con la diferente informacion de respuesta
     */
   public String respuesta(Consulta consulta){
    String texto = consulta.getTexto();
    LocalTime inicio = consulta.getTiempo();
    
    // Primero eliminar palabras vacías para obtener el texto limpio
    String textoLimpio = textoLimpio(texto);
    
    int palabrasVacias = palabrasVacias(texto);
    int palabrasClave = palabrasClave(textoLimpio);
    int signosPuntuacion = contarSignosPuntuacion(texto);
    
    // Obtener la respuesta adecuada según las palabras clave
    String respuestaBot = buscarRespuesta(textoLimpio);
    
    LocalTime fin = LocalTime.now();
    Duration duracion = Duration.between(inicio, fin);
    long tiempo = duracion.toMillis();
    
    String res = "El numero de palabras vacias: " + palabrasVacias + "\n" + 
                 "El numero de palabras clave: " + palabrasClave + "\n" + 
                 "El numero de signos de puntuacion: " + signosPuntuacion + "\n" + 
                 "Respuesta: " + respuestaBot + "\n" + 
                 "Tiempo en responder: " + tiempo;
    
    return res;
    }
}
