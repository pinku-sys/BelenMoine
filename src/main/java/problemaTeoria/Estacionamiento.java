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
public class Estacionamiento {
    //recurso compartido con 2 objetos y sus locks propios para que no se bloqueen entre si
    private Object maxAuto; //lock propio AUTO 
    private Object maxMoto; //lock propio MOTO
    private final int maxAutoInt = 5; 
    private final int maxMotoInt = 5;
    private int actualMoto=0;
    private int actualAuto=0;
    
    public void sumarMoto() {
        //utiliza el lock de  objeto moto
        synchronized (maxMoto) {
            if(actualMoto <maxMotoInt) {
            actualMoto++;
                System.out.println("Ingreso una moto nueva");
            } else {
                System.out.println("Estacionamiento motos lleno");
            }
        }
    }
    
    public void sumarAuto() {
          synchronized (maxAuto) {
              if(actualAuto <maxAutoInt) {
            actualAuto++;
                System.out.println("Ingreso un auto");
            } else {
                System.out.println("Estacionamiento autos lleno");
            }
            
        }
    }
    
    public void restarAuto() {
          synchronized (maxAuto) {
              //??
                if(actualAuto > 0) {
            actualAuto--;
                System.out.println("Salida un auto");
            } else {
                System.out.println("Nadie entro para salir ?? // ");
            }      
        }
    }
    
    public void restarMoto () {
          synchronized (maxMoto) {
                    if(actualMoto > 0) {
            actualMoto--;
                System.out.println("Salida una moto");
            } else {
                System.out.println("Nadie entro para salir ?? // ");
            }    
        }
    }
}
