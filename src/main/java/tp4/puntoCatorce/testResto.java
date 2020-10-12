/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoCatorce;

/**
 *
 * @author Pinku
 */
public class testResto {
    /**
     * el ejercicio 14 es asi (segun lo que dijo Silvia): hay lugar para 2 empleados, 
     * 1 mozo que SOLO se encarga de las bebidas, 1 cocinero que SOLO se encarga de la comida. 
     * Cuando el empleado entra si quiere bebida, le pide al mozo. Si quiere comida, le pide al cocinero. 
     * Si quiere bebida y comida, al mozo y al cocinero. Nada mas
     */
    
    public static void main(String[] args) {
         Restoran resto = new Restoran();
         int i = 0;
        for ( i = 0; i < 6; i++) {
            new Thread(new Cliente(resto,"Cliente  " + i), "Cliente  " + i).start();
        }
        new Thread(new Mozo(resto)).start();
        new Thread(new Cocinero(resto)).start();
    }
    
}
