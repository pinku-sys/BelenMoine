/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaTeoria;

/**
 *
 * @author Pinku
 */
public class SalidaAuto extends EySAbstracto {

    public SalidaAuto(Estacionamiento estacion, String nombre) {
        super(estacion, nombre);
    }

    
    @Override
    public void run() {
         int i = 0;
        while (i < 10) {
            this.estacion.restarAuto();
            i++;
        }

        
        
    }
    
}
