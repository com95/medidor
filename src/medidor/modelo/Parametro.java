/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.modelo;

/**
 *
 * @author Yuli
 */
public class Parametro {
    private int codigoParametro;
    private double valor;

    public Parametro() {
        this(-1, 0);
    }
                
    public Parametro(int codigoParametro, double valor) {
        this.codigoParametro = codigoParametro;
        this.valor = valor;
    }

    public int getCodigoParametro() {
        return codigoParametro;
    }

    public void setCodigoParametro(int codigoParametro) {
        this.codigoParametro = codigoParametro;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
    
    public void toStrings()
    {
        System.out.println("\t\t\t\tParametro (" + codigoParametro + ", " + valor + ")");
    }
    
}
