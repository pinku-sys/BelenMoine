/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaFilosofos;

/**
 *
 * @author Pinku
 */
public class testMesa {

    public static void main(String[] args) {
        int cantidadFilosofos = 5;
        int cantidadTenedores = 5;
        Mesa m = new Mesa(cantidadTenedores);
        Thread [] filosofos = new Thread[cantidadFilosofos];
        for (int i = 0; i < cantidadFilosofos; i++) {
            filosofos[i] = new Thread(new Filosofo("Filosofo "+(i+1),m));
        }
        
        for (int i = 0; i < cantidadFilosofos; i++) {
            filosofos[i].start();
        }
    }

}
