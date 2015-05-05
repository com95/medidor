package medidor.modelo;

import java.util.Vector;

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

    public void toStrings()
    {
        System.out.println("\t\tSubCaracteristica (" + codigoSubCaracteristica + ", " + nombreSubCaracteristica +  ")");
        for(int i = 0; i < metricas.size(); i++)
        {
            metricas.get(i).toStrings();
        }
    }
    
}
