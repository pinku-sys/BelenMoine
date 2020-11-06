/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp5.ejercicio3;

/**
 *
 * @author Pinku
 */
public class testTren {

    public static void main(String[] args) {

        int cantidadT = 3;
        int cantidadV = 1;
        int cantidadP = 9;
        int i = 0;
        Tren trencito = new Tren(cantidadT);
        new Thread(new controlTren(trencito), "Controlcito").start();
        for (i = 1; i <= cantidadV; i++) {
            new Thread ( new vendedorTickets (trencito, "Vendedor "+ i), "Vendedor "+i).start();
        }
        for (i = 1; i <= cantidadP; i++) {
            new Thread( new Pasajero (trencito, "Pasajero " + i), "Pasajero " + i).start();
        }
    }

}
