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
public class testEstacionamiento {

    public static void main(String[] args) {
        Estacionamiento estacion = new Estacionamiento();
        EntradaAuto entradaSur = new EntradaAuto(estacion, "Entrada Sur");
        EntradaAuto entradaNorte = new EntradaAuto(estacion, "Entrada Norte");
        EntradaMoto entradaMoto = new EntradaMoto(estacion, "Entrada Moto");
        SalidaAuto salidaAuto = new SalidaAuto(estacion, "Salida Auto");
        SalidaMoto salidaMoto = new SalidaMoto(estacion, "Salida Moto");

        Thread ESur = new Thread(entradaSur);
        Thread ENorte = new Thread(entradaNorte);
        Thread EMoto = new Thread(entradaMoto);
        Thread SalidaAuto = new Thread(salidaAuto);
        Thread SalidaMoto = new Thread(salidaMoto);
        
        ESur.start();ENorte.start();EMoto.start();SalidaAuto.start();SalidaMoto.start();

    }

}
