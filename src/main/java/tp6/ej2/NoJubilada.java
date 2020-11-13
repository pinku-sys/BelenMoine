/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

import java.util.logging.Level;
import java.util.logging.Logger;
import utiles.Aleatorio;

/**
 *
 * @author Pinku
 */
public class NoJubilada extends Persona {

    public NoJubilada(String nombre, Museo sm) {
        super(nombre, sm);
    }

    @Override
    public void run() {
        while(true) {
            try {
                this.sm.entrarSala();
                System.out.println(this.nombre + " ENTRO A LA SALA");
                int tiempoEspera = Aleatorio.intAleatorio(1000,2000);
                Thread.sleep(tiempoEspera);
                System.out.println(this.nombre + " SALE DE LA SALA");
                this.sm.salirSala();
            } catch (InterruptedException ex) {
                Logger.getLogger(NoJubilada.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
    
}
