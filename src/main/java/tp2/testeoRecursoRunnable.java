/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

/**
 *
 * @author Pinku
 */
public class testeoRecursoRunnable {
     public static void main(String[] args) {
         //creo el objeto runnable (esta mal crear uno solo?)
        ClienteRunnable obj = new ClienteRunnable();
        
        //creo dos hilos con el mismo objeto runnablem (preguntar)
        Thread juan = new Thread(obj, "Juan Lopez");
        Thread ines = new Thread(obj, "Ines Garcia");
        
        //inicio los hilos
        juan.start();
        ines.start();
    }
    
}
