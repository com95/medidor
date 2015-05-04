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
import medidor.modelo.Modelo;
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
        Statement stat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/metricas","root", "123456");

            // Creamos un Statement para poder hacer peticiones a la bd
            stat = (Statement) con.createStatement();

            // Seleccionar todos los datos ordenados por potencia
            String seleccionar = "SELECT * FROM MODELOS";
            ResultSet rs = stat.executeQuery(seleccionar);

            // Recorrer todas las filas de la tabla Motor
            while (rs.next()) {
                Modelo m = new Modelo();
                m.setCodigoModelo(Integer.parseInt(rs.getString("CodigoModelo")));
                m.setNombreModelo(rs.getString("Nombre"));
                
                modelos.add(m);
            }
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {         
            if (stat != null) stat.close();
            if (con != null) con.close();    
        }
        
        new Main();
    }
}
