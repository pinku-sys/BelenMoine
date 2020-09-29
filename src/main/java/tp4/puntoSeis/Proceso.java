/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp4.puntoSeis;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Proceso implements Runnable {

    //nombre del proceso
    public char nombre;
    //turno es el recurso compartido que controla los turnos de los procesos
    public Turno miTurno;
    //repet es repeticion, la cantidad de veces que quiero escribir cada letra
    private int repet;
    //con esta variable el proceso sabe cual es su posicion al escribirse
    private int miposicion;

    /**
     *
     * @param nombre
     * @param miTurno
     * @param repet
     *
     * crear el proceso con 2 semaforos el mio + y siguiente y pasarlo por
     * parametro a un metodo en turno // desventaja: el proceso conoce el
     * mecanismo, pero no uso switch (en turno)tener arreglo de semaforos y que
     * cada objeto conozca la pos de su semaforo y el sg ? ventaja: el proceso
     * no se entera del mecanismo de sincr, pero debo usar switch
     */
    public Proceso(char nombre, Turno miTurno, int repet, int pos) {
        this.nombre = nombre;
        this.miTurno = miTurno;
        this.repet = repet;
        this.miposicion = pos;
    }

    @Override
    public void run() {
        while (true) {
            try {
                miTurno.escribe(nombre, repet, miposicion);
            } catch (InterruptedException ex) {
                Logger.getLogger(Proceso.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

}
