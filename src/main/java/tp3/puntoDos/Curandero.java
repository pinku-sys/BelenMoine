/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoDos;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Curandero extends Personaje {

    public Curandero(Vida recurso) {
        super(recurso);
    }

    @Override
    public void run() {

            recurso.curar(3);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Curandero.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

