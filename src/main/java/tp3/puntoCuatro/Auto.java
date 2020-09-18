/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp3.puntoCuatro;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Pinku
 */
public class Auto extends Vehiculo {

    /**
     * Implemente la clase Auto, subclase de Vehículo con los atributos
     * representativos de auto (patente, modelo, marca,
     * kmFaltantesParaElService, etc).Defina el main en donde se detalle el
     * movimiento del auto una determinada cantidad de km, hasta que llegue a la
     * reserva, para después ir a cargar nafta y continúe andado.Considere ahora
     * que tenemos varios autos funcionando a la vez. Cómo representaría la
     * situación, realice un prueba del programa con 5 autos como mínimo.
     * Considere que sólo se dispone de un surtidor que despacha combustible.
     *
     */
    private int patente;
    private int modelo;
    private String marca;
    private int kmFaltantesParaElService;
    private int tanqueNafta;
    private int kmReserva = 20;
    private Gasolinera abastecedor;

    public void setKM(int cantidad) {
        tanqueNafta = tanqueNafta + cantidad;
    }

    public String getMarca() {
        return this.marca;
        
    }

    public Auto(int patente, int modelo, String marca, int tanqueNafta, Gasolinera abastecedor) {
        //pongo en el constructor las variables que vaya a utilizar para este ejericio
        this.patente = patente;
        this.modelo = modelo;
        this.marca = marca;
        this.tanqueNafta = tanqueNafta;
        this.abastecedor = abastecedor;
    }

    @Override
    public void run() {
        try {
            System.out.println(" Soy el auto: " + this.marca + " estoy andando ");
            while (tanqueNafta > kmReserva) {
                //simula que esta andando hasta llegar a reserva
                this.tanqueNafta = this.tanqueNafta - 10;

                if (tanqueNafta <= kmReserva) {
                    System.out.println(" Soy el auto: " + this.marca + " me quede sin nafta, voy a recargar ");
                    //el 300 es estandar pero se podria cambiar
                    abastecedor.cargandoNafta(this, 300);
                    Thread.sleep(1000);
                }
            }
        } catch (InterruptedException ex) {
            Logger.getLogger(Auto.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
