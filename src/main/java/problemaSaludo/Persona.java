/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo;

/**
 *
 * @author Pinku
 */
public abstract class Persona implements Runnable{
    protected String nombre;
    protected Saludo saludo;

    public Persona(String nombre, Saludo saludo) {
        this.nombre = nombre;
        this.saludo = saludo;
    }
    
    
}
