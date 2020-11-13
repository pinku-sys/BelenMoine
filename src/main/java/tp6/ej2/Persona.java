/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp6.ej2;

/**
 *
 * @author Pinku
 */
public abstract class Persona implements Runnable {
    protected String nombre;
    protected Museo sm;

    public Persona(String nombre, Museo sm) {
        this.nombre = nombre;
        this.sm = sm;
    }
    
}
