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
public class Caracteristica {
    private int codigoCaracteristica;
    private String nombreCaracteristica;
    private Vector <SubCaracteristica> subcaracteristicas;

    public Caracteristica() {
        this(-1, "NULL", null);
    }
    
    public Caracteristica(int codigoCaracteristica, String nombreCaracteristica, Vector<SubCaracteristica> subcaracteristicas) {
        this.codigoCaracteristica = codigoCaracteristica;
        this.nombreCaracteristica = nombreCaracteristica;
        this.subcaracteristicas = subcaracteristicas;
    }

    public int getCodigoCaracteristica() {
        return codigoCaracteristica;
    }

    public void setCodigoCaracteristica(int codigoCaracteristica) {
        this.codigoCaracteristica = codigoCaracteristica;
    }

    public String getNombreCaracteristica() {
        return nombreCaracteristica;
    }

    public void setNombreCaracteristica(String nombreCaracteristica) {
        this.nombreCaracteristica = nombreCaracteristica;
    }

    public Vector<SubCaracteristica> getSubcaracteristicas() {
        return subcaracteristicas;
    }

    public void setSubcaracteristicas(Vector<SubCaracteristica> subcaracteristicas) {
        this.subcaracteristicas = subcaracteristicas;
    }
        
}
