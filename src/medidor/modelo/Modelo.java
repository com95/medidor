/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.modelo;

import java.util.Vector;

/**
 *
 * @author Yuli
 */
public class Modelo {
    private String nombreModelo;
    private Vector <Caracteristica> carateristicas;

    public Modelo() {
        this("NULL", null);
    }

    public Modelo(String nombreModelo, Vector<Caracteristica> carateristicas) {
        this.nombreModelo = nombreModelo;
        this.carateristicas = carateristicas;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public Vector<Caracteristica> getCarateristicas() {
        return carateristicas;
    }

    public void setCarateristicas(Vector<Caracteristica> carateristicas) {
        this.carateristicas = carateristicas;
    }
    
    
}
