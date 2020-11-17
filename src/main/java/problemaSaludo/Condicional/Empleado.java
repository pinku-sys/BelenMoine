/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemaSaludo.Condicional;

import problemaSaludo.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Empleado extends Persona {

    public Empleado(String nombre, SaludoConditions saludo) {
        super(nombre, saludo);
    }

    
    @Override
    public void run() {
        try {
            this.saludo.saludaEmpleado(nombre);
        } catch (InterruptedException ex) {
            Logger.getLogger(Empleado.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
