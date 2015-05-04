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
public class SubCaracteristica {
    private int codigoSubCaracteristica;
    private String nombreSubCaracteristica;
    private Vector <Metrica> metricas;

    public SubCaracteristica() {
        this(-1, "NULL", null);
    }    
    
    public SubCaracteristica(int codigoSubCaracteristica, String nombreSubCaracteristica, Vector<Metrica> metricas) {
        this.codigoSubCaracteristica = codigoSubCaracteristica;
        this.nombreSubCaracteristica = nombreSubCaracteristica;
        this.metricas = metricas;
    }

    public int getCodigoSubCaracteristica() {
        return codigoSubCaracteristica;
    }

    public void setCodigoSubCaracteristica(int codigoSubCaracteristica) {
        this.codigoSubCaracteristica = codigoSubCaracteristica;
    }

    public String getNombreSubCaracteristica() {
        return nombreSubCaracteristica;
    }

    public void setNombreSubCaracteristica(String nombreSubCaracteristica) {
        this.nombreSubCaracteristica = nombreSubCaracteristica;
    }

    public Vector<Metrica> getMetricas() {
        return metricas;
    }

    public void setMetricas(Vector<Metrica> metricas) {
        this.metricas = metricas;
    }

    
}
