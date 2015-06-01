package medidor.controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UICalidad;

public class Main {
    
    private CMain inicio;
    
    public Main()
    {
        inicio = new CMain();
    }
    
    public static void main(String args []) throws SQLException
    {
        new Main();
    }
    
}