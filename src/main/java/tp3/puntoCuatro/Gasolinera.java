/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoCuatro;

/**
 *
 * @author Pinku
 */
public class Gasolinera {
    private Object surtidor; //preguntar
    private int capacidad;

    public Gasolinera(int capacidad) {
        this.capacidad = capacidad;
    }
    
    public synchronized void cargandoNafta(Auto autito, int deseado) {
        //settie 300 como cantidad maxima que se llena.
        if(capacidad > deseado) {
        System.out.println("El auto: " + autito.getMarca() + " se esta recargando");
        autito.setKM(deseado);
        this.capacidad = capacidad -deseado;
        } else {
            System.out.println("No hay mas nafta en el surtidor");
        }
    }
    
}
