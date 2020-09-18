/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoTres;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Proceso implements Runnable {
    
    //id sirve para conocer la posicion en la que quiero escribir
    public int identificador;
    //nombre del proceso
    public char nombre;
    //turno es el recurso compartido que controla los turnos de los procesos
    public Turno miTurno;
    //repet es repeticion, la cantidad de veces que quiero escribir
    private int repet;

    public Proceso(int id, char nombre, Turno miTurno, int repeticion) {
        this.identificador = id;
        this.nombre = nombre;
        this.miTurno = miTurno;
        this.repet = repeticion;
    }

    public void run() {
        int i = 0;
        //agregue un while para que escriba 5 veces cada letra, si no  es mucho tiempo.
        while (i < 2) {
            //si turno esta en la misma posicion que mi identificador entonces me escribo
            if (miTurno.getTurno() == this.identificador) {
                try {
                    for (int j = 0; j < this.repet; j++) {
                        System.out.print(this.nombre);
                    }
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
                }
                //esta verificacion sirve para que no se pase de C. esta sentencia deberia modificarse en un futuro si agrego otra letra
                if (!(identificador == 3)) {
                    //incremento
                    miTurno.incremetar();
                } else {
                    //si ya escribimos C, reseteamos el turno y vuelve a 1
                    miTurno.resetear();
                }
                i++;
            } //7ifgrande
            
        }//while
    }

}
