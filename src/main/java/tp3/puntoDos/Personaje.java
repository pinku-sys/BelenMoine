/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoDos;


/**
 *
 * @author Pinku
 */
public abstract class Personaje implements Runnable {
//personaje con clases concretas y estetiene un metodo abstracto
    protected Vida recurso; //recurso compartido

    public Personaje(Vida recurso) {
        //esta bien?
        this.recurso = recurso;
    }

    @Override
    abstract public void run(); 
        }
