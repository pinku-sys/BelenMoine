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
public class Vida {

    private int mivida = 10;

    public synchronized int obtener() {
        return this.mivida;
    }

    public synchronized void quitar(int cantidad) {

        this.mivida = this.mivida - cantidad;
        System.out.print(Thread.currentThread().getName() + " TE PEGUÉ Y ");
        System.out.println("TE DEJE CON : " + mivida + " VIDA ");

    }

    public synchronized void curar(int cantidad) {

        this.mivida = this.mivida + cantidad;
        System.out.print(Thread.currentThread().getName() + " TE ESTOY CURANDO ");
        System.out.println(" Y TE DEJE CON: " + mivida + " VIDA ");

    }

}
