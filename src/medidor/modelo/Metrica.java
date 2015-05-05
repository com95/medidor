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
public class Metrica {
    private int codigoMetrica;
    private String nombreMetrica;
    private String proposito;
    private String escalaMedicion;
    private String tipoMedida;
    private double valor;
    private boolean estado;
    private String formula;
    private double valorOptimo;
    private Vector <Parametro> parametros;

    public Metrica() {
        this(-1, "NULL", "NULL", "NULL", "NULL", 0, false, "", 0, null);
    }

    
    
    public Metrica(int codigoMetrica, String nombreMetrica, String proposito, String escalaMedicion, String tipoMedida, double valor, boolean estado, String formula, double valorOptimo, Vector<Parametro> parametros) {
        this.codigoMetrica = codigoMetrica;
        this.nombreMetrica = nombreMetrica;
        this.proposito = proposito;
        this.escalaMedicion = escalaMedicion;
        this.tipoMedida = tipoMedida;
        this.valor = valor;
        this.estado = estado;
        this.formula = formula;
        this.valorOptimo = valorOptimo;
        this.parametros = parametros;
    }

    public int getCodigoMetrica() {
        return codigoMetrica;
    }

    public void setCodigoMetrica(int codigoMetrica) {
        this.codigoMetrica = codigoMetrica;
    }

    public String getNombreMetrica() {
        return nombreMetrica;
    }

    public void setNombreMetrica(String nombreMetrica) {
        this.nombreMetrica = nombreMetrica;
    }

    public String getProposito() {
        return proposito;
    }

    public void setProposito(String proposito) {
        this.proposito = proposito;
    }

    public String getEscalaMedicion() {
        return escalaMedicion;
    }

    public void setEscalaMedicion(String escalaMedicion) {
        this.escalaMedicion = escalaMedicion;
    }

    public String getTipoMedida() {
        return tipoMedida;
    }

    public void setTipoMedida(String tipoMedida) {
        this.tipoMedida = tipoMedida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public double getValorOptimo() {
        return valorOptimo;
    }

    public void setValorOptimo(double valorOptimo) {
        this.valorOptimo = valorOptimo;
    }

    public Vector<Parametro> getParametros() {
        return parametros;
    }

    public void setParametros(Vector<Parametro> parametros) {
        this.parametros = parametros;
    }
    
    public void toStrings()
    {
        System.out.print("\t\t\tMetrica (" + codigoMetrica + ", " + nombreMetrica + ", " + escalaMedicion + ", " + tipoMedida + ", " + valor + ", " + estado + ", " + formula + ", " + valorOptimo + ")");
        for(int i = 0; i < parametros.size(); i++)
        {
            parametros.get(i).toStrings();
        }
    }
    
}
