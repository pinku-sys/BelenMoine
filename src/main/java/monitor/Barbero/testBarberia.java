/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Barbero;



/**
 *
 * @author Pinku
 */
public class testBarberia {

    public static void main(String[] args) {
        int maximoSillas = 3;
        Barberia br = new Barberia(maximoSillas);
        Barbero barb = new Barbero(br);
        Thread hiloBarbero = new Thread(barb);       
        for (int i = 0; i< 5; i++) {
            new Thread(new Cliente(br), "cliente "+(i+1)).start();
        }
        hiloBarbero.start();
    }

}
