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
import javax.swing.JList;
import javax.swing.JTextArea;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;

/**
 *
 * @author Yuli
 */

public class CMain implements IMain{
    private UIMain ventanaPrincipal;
    
    public CMain()
    {
        ventanaPrincipal = new UIMain(this);
    }
    
    public void mostrarDescripcion(JList jlist, JTextArea jtextarea)
    {
        switch(jlist.getLeadSelectionIndex())
        {
            case 0:
                jtextarea.setText("  Estándar internacional para la"
                                + "\n  evaluación de la calidad del"
                                + "\n  software. Considera las siguientes"
                                + "\n  características:"
                                + "\n      - Funcionalidad"
                                + "\n      - Fiabilidad"
                                + "\n      - Usabilidad"
                                + "\n      - Eficiencia"
                                + "\n      - Mantenibilidad"
                                + "\n      - Portabilidad");
                break;
            case 1:
                jtextarea.setText("  Se focaliza en el producto final\n"
                                + "  identificando atributo claves\n"
                                + "  desde el punto de vista del\n"
                                + "  Cliente. Esto atributos se\n"
                                + "  denominan factores de calidad.");
                break;
            case 2:
                jtextarea.setText("  Basada sobre la norma  ISO 9126\n"
                                + "  y la IEC. La primera parte del\n"
                                + "  modelo especifica características\n"
                                + "  para calidad interna y externa.\n"
                                + "  La segunda parte del modelo,\n"
                                + "  especifica características para\n"
                                + "  la calidad en uso.");
                break;
        }
    }
}
