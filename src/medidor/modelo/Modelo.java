/* CAMBIO */
/*NUEVO CAMBIO COM95

asdad*/
package medidor.modelo;

import java.util.ArrayList;
import java.util.Vector;

public class Modelo {
    private int codigoModelo;
    private String nombreModelo;
    private ArrayList <Caracteristica> caracteristicas;

    public Modelo() {
        this(-1, "NULL", null);
    }

    public Modelo(int codigoModelo, String nombreModelo, ArrayList<Caracteristica> caracteristicas) {
        this.codigoModelo = codigoModelo;
        this.nombreModelo = nombreModelo;
        this.caracteristicas = caracteristicas;
    }

    public int getCodigoModelo() {
        return codigoModelo;
    }

    public void setCodigoModelo(int codigoModelo) {
        this.codigoModelo = codigoModelo;
    }

    public String getNombreModelo() {
        return nombreModelo;
    }

    public void setNombreModelo(String nombreModelo) {
        this.nombreModelo = nombreModelo;
    }

    public ArrayList<Caracteristica> getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(ArrayList<Caracteristica> carateristicas) {
        this.caracteristicas = carateristicas;
    }

    public void toStrings()
    {
        System.out.println("Modelo (" + codigoModelo + ", " + nombreModelo +  ")");
        for(int i = 0; i < caracteristicas.size(); i++)
        {
            caracteristicas.get(i).toStrings();
        }
    }   
}
