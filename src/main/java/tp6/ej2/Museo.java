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
public class Museo {
    int sala = 50; //cantidad
    int salaReducida = 35; //numero sala Reducida
    int quiereJubilado; 
    int cantidadActual; //cantidadPersonas actual 
    int tempActual; //temperaturaActual
    int tUmbral = 30;
    int cantidadSalaMax = 50;
    /**
     * CASO ESPECIAL SOLO PARA JUBILADOS
     * @throws InterruptedException 
     */
    public synchronized void entrarSalaJubilado() throws InterruptedException {
        quiereJubilado++;
        while (cantidadActual > sala) {
            this.wait();
        }
        notifyAll(); //despierta a todos los que estan esperando
        //se supone que ya puede ingresar porque la cantidad actual es menor entonces ingresa y resta 1.
        quiereJubilado--; 
        this.cantidadActual++;
    }
    
    /**
     * CASO GENERAL
     */
    public synchronized void entrarSala() throws InterruptedException {
        //si hay un jubilado esperando y la sala esta llena entonces, podria ser un or?. preguntar.
        while (quiereJubilado > 0  && cantidadActual > sala)  {
            this.wait();
        }
        cantidadActual++;
        //no despierto a nadie porque todavia tengo que salir... o deberia notificar?. preguntar.
    }
    
    /**
     * CASO GENERAL (INCLUYE JUBILADOS AL SALIR
     */
    public synchronized void salirSala() {
        //egreso de un visitante.
        cantidadActual--;
        notifyAll();
        
    }
    
    /**
     * METODO QUE CONTROLA LA TEMPERATURA. en realidad la cambia. cada un cierto tiempo. cON UN HILO termostato.
     */
    public synchronized void notificarTemperatura (int temperatura) {
        //si la temperatura que viene por parametro es mayor, cambio la cantidad d personas en la sala, si no, la mantengo (30)
        if (temperatura >= tUmbral) {
            sala = salaReducida;
        } else {
            sala = cantidadSalaMax;
        }
        notifyAll();
        
    }
}
