package medidor.controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextArea;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;


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
    
    public void evaluar()
    {
        File archivoProducto = null;
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            archivoProducto = new File ("resultado_SM.csv");
            fr = new FileReader (archivoProducto);
            br = new BufferedReader(fr);
            /* GET DATOS RELEVANTES
            String linea;
            while((linea = br.readLine()) != null)
            {   
                System.out.println(linea);
            } */
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(null, "El archivo 'resultados_SM.csv' no existe.", "Error", ERROR_MESSAGE);
        }
        finally
        { 
            if( null != fr )
            {   
                try
                {     
                    fr.close();
                } catch (IOException ex) {
                    
                }
            }                  
        }
        
    }
    
}
