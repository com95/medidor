package medidor.modelo;

import java.util.ArrayList;
import java.util.Vector;

public class Caracteristica {
    private int codigoCaracteristica;
    private String nombreCaracteristica;
    private ArrayList <SubCaracteristica> subcaracteristicas;

    public Caracteristica() {
        this(-1, "NULL", null);
    }
    
    public Caracteristica(int codigoCaracteristica, String nombreCaracteristica, ArrayList<SubCaracteristica> subcaracteristicas) {
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

    public ArrayList<SubCaracteristica> getSubcaracteristicas() {
        return subcaracteristicas;
    }

    public void setSubcaracteristicas(ArrayList<SubCaracteristica> subcaracteristicas) {
        this.subcaracteristicas = subcaracteristicas;
    }
    
    public void toStrings()
    {
        System.out.println("\tCaracteristica (" + codigoCaracteristica + ", " + nombreCaracteristica +  ")");
        for(int i = 0; i < subcaracteristicas.size(); i++)
        {
            subcaracteristicas.get(i).toStrings();
        }
    }
        
}
