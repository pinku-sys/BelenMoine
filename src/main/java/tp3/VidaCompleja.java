/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3;

/**
 *
 * @author Pinku
 */
public class VidaCompleja {

    private int mivida = 10;

    public synchronized int obtener() {
        return this.mivida;
    }

    public synchronized boolean quitar(int cantidad) {
        boolean ok = true;
        //hacer un -3. simplificar
        if (mivida > 0) {
            this.mivida = this.mivida - cantidad;
            System.out.print(Thread.currentThread().getName() + "TE PEGUÉ Y");
            System.out.println("TE DEJE CON : "+mivida+" VIDA ");
            if (this.mivida < 0) {
                System.out.println("Te mataron.");
            }
        } else {
            ok = false;
        }
        return ok;
    }

    public synchronized boolean curar(int cantidad) {
       boolean ok=false;
       //hacer un +3. simplificar
        if (mivida > 0) //significa que no estoy muerto
        {
            this.mivida = this.mivida + cantidad;
            System.out.print(Thread.currentThread().getName()+ "TE ESTOY CURANDO");
            System.out.println(" Y TE DEJE CON: " + mivida + " VIDA ");
          ok=true;
            
        } else {
            System.out.println("No se puede curar. Estas muerto.");
        }
        return ok;
    }
}
