/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoTres;

/**
 *
 * @author Pinku
 */
public class Turno {
    int contador = 1;
    
    public synchronized void incremetar () {
        contador++;
    }
    
    public synchronized void resetear () {
        contador=1;
    }
    
    public synchronized int getTurno() {
        return contador;
    }
    
    public synchronized boolean comparar (int nro) {
        return (contador == nro);
    }
    
}
