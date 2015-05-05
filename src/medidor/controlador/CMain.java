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
import medidor.modelo.Parametro;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;


public class CMain implements IMain{
    private UIMain ventanaPrincipal;
    private Vector <Parametro> p;
    
    public CMain()
    {
        ventanaPrincipal = new UIMain(this);
        p = new Vector <Parametro>();
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
    
    public void evaluar(JList jlist)
    {
        File archivo1 = null;
        File archivo2 = null;
        File archivo3 = null;
        File archivo4 = null;
        File archivo5 = null;
        File archivo6 = null;

                
        FileReader fr1 = null;
        FileReader fr2 = null;
        FileReader fr3 = null;
        FileReader fr4 = null;
        FileReader fr5 = null;
        FileReader fr6 = null;
        
        BufferedReader br1 = null;
        BufferedReader br2 = null;
        BufferedReader br3 = null;
        BufferedReader br4 = null;
        BufferedReader br5 = null;
        BufferedReader br6 = null;
        
        try {
            
            archivo1 = new File ("resultado_GA.csv");
            archivo2 = new File ("resultado_GC.csv");
            archivo3 = new File ("resultado_MA.xls");
            archivo4 = new File ("resultado_KW.xls");
            archivo5 = new File ("resultado_SM.xml");
            archivo6 = new File ("resultado_SQ.xls");
            
            fr1 = new FileReader (archivo1);
            fr2 = new FileReader (archivo2);
            fr3 = new FileReader (archivo3);
            fr4 = new FileReader (archivo4);
            fr5 = new FileReader (archivo5);
            fr6 = new FileReader (archivo6);
            
            br1 = new BufferedReader(fr1);
            br2 = new BufferedReader(fr2);
            br3 = new BufferedReader(fr3);
            br4 = new BufferedReader(fr4);
            br5 = new BufferedReader(fr5);
            br6 = new BufferedReader(fr6);
            
            /* GA*/
            String linea1;
            Vector <String> Efiles = new Vector <String>();
            while((linea1 = br1.readLine()) != null)
            {
                String tok = "a";
                int fin = linea1.lastIndexOf(",");
                if(linea1.length() > 6)
                {
                    if(linea1.substring(fin - 5, fin).equals(".java"))
                    {
                        linea1 = linea1.substring(0, fin);
                        int fin2 = linea1.lastIndexOf(",");
                        tok = linea1.substring(fin2 + 1, linea1.length());
                        
                        boolean rep = true;
                        
                        for(int i = 0; i < Efiles.size(); i++)
                        {
                            if(Efiles.get(i).equals(tok))
                                rep = false;
                        }
                        
                        if(rep)
                            Efiles.add(tok);
                    }
                }
            }

            p.add(new Parametro(1, Efiles.size()));
            
            /* SM*/
            
            String linea5;
            int count = 0;
            while((linea5 = br5.readLine()) != null)
            {
                if(count == 27)
                {
                    linea5 = linea5.substring(linea5.indexOf("checkpoint_files") + 18, linea5.length() - 2);
                    p.add(new Parametro(2, Integer.parseInt(linea5)));
                }
                
                if(count == 29)
                {
                    linea5 = linea5.substring(linea5.indexOf("M0") + 4, linea5.lastIndexOf("<"));
                    p.add(new Parametro(3, Integer.parseInt(linea5)));
                }
                count++;
            }
            
            /* GC */
            
            String linea2;
            int count2 = 0;
            
            while((linea2 = br2.readLine()) != null)
            {
                if(count2 == 6)
                {
                    linea2 = linea2.substring(linea2.length() - 4, linea2.length());
                    p.add(new Parametro(4, Double.parseDouble(linea2)));
                }
                
                if(count2 == 61)
                {
                    linea2 = linea2.substring(linea2.lastIndexOf(",")+1, linea2.length());
                    p.add(new Parametro(5, Integer.parseInt(linea2)));
                }
                
                count2++;
            }
            
            
            
            //jlist.getSelectedIndex();
            
   
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "Uno o más archivos solicitados no existen.", "Error", ERROR_MESSAGE);
        }
        finally
        { 
            if( null != fr1 )
            {   
                try
                {     
                    fr1.close();
                } catch (IOException ex1) {

                }
            } 
            if( null != fr2 )
            {   
                try
                {     
                    fr2.close();
                } catch (IOException ex2) {

                }
            }
            if( null != fr3 )
            {   
                try
                {     
                    fr3.close();
                } catch (IOException ex3) {

                }
            }
            if( null != fr4 )
            {   
                try
                {     
                    fr4.close();
                } catch (IOException ex4) {

                }
            }
            if( null != fr5 )
            {   
                try
                {     
                    fr5.close();
                } catch (IOException ex5) {

                }
            }
            if( null != fr6 )
            {   
                try
                {     
                    fr6.close();
                } catch (IOException ex6) {

                }
            }
            
        }
        
    }
    
}
