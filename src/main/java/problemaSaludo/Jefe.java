/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Jefe extends Persona {

    public Jefe(String nombre, Saludo saludo) {
        super(nombre, saludo);
    }

    @Override
    public void run() {
        try {
            saludo.saludaJefe();
        } catch (InterruptedException ex) {
            Logger.getLogger(Jefe.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
