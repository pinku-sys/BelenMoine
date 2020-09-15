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
public abstract class EySAbstracto implements Runnable{
      protected Estacionamiento estacion;
    protected String nombre;

    public EySAbstracto(Estacionamiento estacion, String nombre) {
        this.estacion = estacion;
        this.nombre = nombre;
    }
    
}
