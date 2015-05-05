/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;

/**
 *
 * @author Yuli
 */
public class Main {
    
    private CMain inicio;
    
    public Main()
    {
        inicio = new CMain();
    }
    
    public static void main(String args []) throws SQLException
    {
        Vector <Modelo> modelos = new Vector <Modelo> ();
        
        Connection con = null;
        Statement stat1 = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/IngSoft","root", "123456");

            stat1 = (Statement) con.createStatement();
            String consultaMod = "SELECT * FROM MODELOS";
            ResultSet resultadoC1 = stat1.executeQuery(consultaMod);
            
            
            // Recorrer todas las filas de la tabla Motor
            while (resultadoC1.next()) {
                
                Modelo m = new Modelo();
                String codModelo = resultadoC1.getString("CodigoModelo");
                m.setCodigoModelo(Integer.parseInt(codModelo));
                m.setNombreModelo(resultadoC1.getString("Nombre"));
                
                Statement stat2 = null;
                stat2 = (Statement) con.createStatement();
                
                String consultaCar = "SELECT * FROM CARACTERISTICAS WHERE CodigoModelo = '" + codModelo + "'";
                ResultSet resultadoC2 = stat2.executeQuery(consultaCar);
                Vector <Caracteristica> vCaracteristica = new Vector <Caracteristica>();
                
                while (resultadoC2.next()) {
                    Caracteristica c = new Caracteristica();
                    String codCaracteristica = resultadoC2.getString("CodigoCaracteristica");
                    c.setCodigoCaracteristica(Integer.parseInt(codCaracteristica));
                    c.setNombreCaracteristica(resultadoC2.getString("Nombre"));
                    
                    Statement stat3 = null;
                    stat3 = (Statement) con.createStatement();
                    
                    String consultaSub = "SELECT * FROM SUBCARACTERISTICAS WHERE CodigoCaracteristica = '" + codCaracteristica + "'";
                    ResultSet resultadoC3 = stat3.executeQuery(consultaSub);                                      
                    Vector <SubCaracteristica> vSubCaracteristicas = new Vector <SubCaracteristica> ();
                    
                    while (resultadoC3.next()) {
                        SubCaracteristica s = new SubCaracteristica();
                        String codSubCaracteristica = resultadoC3.getString("CodigoSubCaracteristica");
                        s.setCodigoSubCaracteristica(Integer.parseInt(codSubCaracteristica));
                        s.setNombreSubCaracteristica(resultadoC3.getString("Nombre"));
                        
                        Statement stat4 = null;
                        stat4 = (Statement) con.createStatement();
                        
                        String consultaMet = "SELECT * FROM METRICAS WHERE CodigoSubCaracteristica = '" + codSubCaracteristica + "'";
                        ResultSet resultadoC4 = stat4.executeQuery(consultaMet); 
                        Vector <Metrica> vMetricas = new Vector <Metrica> ();
                        
                        while (resultadoC4.next())
                        {
                            Metrica mt = new Metrica ();
                            
                            mt.setCodigoMetrica(Integer.parseInt(resultadoC4.getString("CodigoMetrica")));
                            mt.setNombreMetrica(resultadoC4.getString("Nombre"));
                            mt.setProposito(resultadoC4.getString("Proposito"));
                            mt.setEscalaMedicion(resultadoC4.getString("EscalaMedicion"));
                            mt.setTipoMedida(resultadoC4.getString("TipoMedida"));
                            mt.setEstado(Boolean.parseBoolean(resultadoC4.getString("Estado")));
                            mt.setFormula(resultadoC4.getString("Formula"));
                            mt.setValorOptimo(Double.parseDouble(resultadoC4.getString("ValorOptimo")));
                            
                            vMetricas.add(mt);
                        }

                        s.setMetricas(vMetricas);
                        vSubCaracteristicas.add(s);
                    }
                    c.setSubcaracteristicas(vSubCaracteristicas);
                    vCaracteristica.add(c);
                }
                m.setCaracteristicas(vCaracteristica);
                modelos.add(m);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {         
            if (stat1 != null) stat1.close();
            if (con != null) con.close();    
        }
        
        for(int i = 0; i < modelos.size(); i++)
        {
            modelos.get(i).toStrings();
        }
        new Main();
    }
    
}