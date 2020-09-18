/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoDos;

/**
 *
 * @author Pinku
 */
public class Juego {
    public static void main(String[] args) throws InterruptedException {
        Vida recursoCompartido = new Vida();
        Orco orco = new Orco(recursoCompartido);
        Curandero curandero = new Curandero(recursoCompartido);
        Thread orco1 = new Thread(orco,"orco");
        Thread curandero1 = new Thread(curandero,"curandero");
        orco1.start();
        curandero1.start();
        orco1.join();
        curandero1.join();
        System.out.println("Vida final: " + recursoCompartido.obtener());
    }
    
}
