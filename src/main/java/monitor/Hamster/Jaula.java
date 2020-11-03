/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package monitor.Hamster;

/**
 *
 * @author Pinku
 */
public class Jaula {
    /**
     * No podes poner toda la logica en una sola clase usando monitores
     * puees deberias sincronizar todos los metodos. Lo que podes hacer
     * es utilizar esta clase para redireccionar a las clases donde se encuentra
     * el mecanismo de sincronizacion
     */
    private Rueda ruedita;
    private Plato platito;

    public Jaula(Rueda ruedita, Plato platito) {
        this.ruedita = ruedita;
        this.platito = platito;
    }
      
    public void comer () {
        platito.empezarAComer();
        platito.terminarDeComer();
    }
    
    public  void rodar () {
        ruedita.rodar();
    }

}
