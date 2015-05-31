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
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.ERROR_MESSAGE;
import javax.swing.JTextArea;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;

public class CMain implements IMain {

    private UIMain ventanaPrincipal;
    private ArrayList<Modelo> modelos;

    public CMain(ArrayList<Modelo> modelos) {
        ventanaPrincipal = new UIMain(this);
        this.modelos = modelos;
        
    }

    public void mostrarDescripcion(JList jlist, JTextArea jtextarea) {
        switch (jlist.getLeadSelectionIndex()) {
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

    public void evaluar(JList jlist) {
        try {
            ArrayList<Double> p = new ArrayList<Double>();
            switch(jlist.getSelectedIndex())
            {
                case 0:
                    Runtime.getRuntime().exec("cmd /c start ISO.xls");
                    
                    int opt0 = JOptionPane.showConfirmDialog(null, 
                                  "Clic en Aceptar cuando termine de completar y guardar los datos solicitados", 
                                  "Datos",
                                  JOptionPane.OK_CANCEL_OPTION); 
                    
                    if(opt0 == 0)
                    {
                        Workbook workbook = Workbook.getWorkbook(new File("ISO.xls"));
                        Sheet sheet = workbook.getSheet(0);
                        
                        for (int i = 0; i < sheet.getRows(); i++)
                                p.add(((NumberCell)sheet.getCell(1, i)).getValue());
                    }
                    calcularMetricas(0, p);
                    for(int i = 0; i < modelos.size(); i++)
                    {
                        modelos.get(i).toStrings();
                    }
                    break;
                case 1:
                    Runtime.getRuntime().exec("cmd /c start McCall.xls");
                    int opt1 = JOptionPane.showConfirmDialog(null, 
                                  "Clic en Aceptar cuando termine de completar y guardar los datos solicitados", 
                                  "Datos",
                                  JOptionPane.OK_CANCEL_OPTION); 
                    
                    if(opt1 == 0)
                    {
                        Workbook workbook = Workbook.getWorkbook(new File("McCall.xls"));
                        Sheet sheet = workbook.getSheet(0);
                        
                        for (int i = 0; i < sheet.getRows(); i++)
                                p.add(((NumberCell)sheet.getCell(1, i)).getValue());
                    }
                    calcularMetricas(1, p);
                    for(int i = 0; i < modelos.size(); i++)
                    {
                        modelos.get(i).toStrings();
                    }
                    break;
                case 2:
                    Runtime.getRuntime().exec("cmd /c start Peruano.xls");
                    int opt2 = JOptionPane.showConfirmDialog(null, 
                                  "Clic en Aceptar cuando termine de completar y guardar los datos solicitados", 
                                  "Datos",
                                  JOptionPane.OK_CANCEL_OPTION); 
                    
                    if(opt2 == 0)
                    {
                        Workbook workbook = Workbook.getWorkbook(new File("Peruano.xls"));
                        Sheet sheet = workbook.getSheet(0);
                        
                        for (int i = 0; i < sheet.getRows(); i++)
                                p.add(((NumberCell)sheet.getCell(1, i)).getValue());
                    }
                    calcularMetricas(2, p);
                    for(int i = 0; i < modelos.size(); i++)
                    {
                        modelos.get(i).toStrings();
                    }
                    break;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Uno o más archivos solicitados no existen.", "Error", ERROR_MESSAGE);
        } catch (BiffException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.ClassCastException e)
        {
            JOptionPane.showMessageDialog(null, "Faltan completar datos. Intente de nuevo", "Error", ERROR_MESSAGE);
        }
    }

    private void calcularMetricas(int i, ArrayList<Double> p) {
        Modelo m = modelos.get(i);
        int count = 0;
        Calculadora calc = new Calculadora();
        for(int j = 0; j < m.getCaracteristicas().size(); j++)
        {
            Caracteristica c = m.getCaracteristicas().get(j);
            for(int k = 0; k < c.getSubcaracteristicas().size(); k++)
            {
                SubCaracteristica s = c.getSubcaracteristicas().get(k);
                for(int l = 0; l < s.getMetricas().size(); l++)
                {
                    Metrica mt = s.getMetricas().get(l);
                    String resolver = mt.getFormula();
                    while(resolver.indexOf("$") != -1)
                    {
                        int pos = resolver.indexOf("$");
                        resolver = resolver.substring(0, pos) + String.valueOf(p.get(count)) + resolver.substring(pos + 1, resolver.length());
                        count++;
                    }
                    
                    mt.setValor(calc.calcular(resolver));
                }
            }
        }
    }

}
