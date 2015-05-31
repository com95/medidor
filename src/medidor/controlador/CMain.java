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
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Font;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Date;

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
                    generarReporte(0);

                    JOptionPane.showMessageDialog(null, "Reporte generado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("cmd /c start reporte.pdf");
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
                    generarReporte(1);

                    JOptionPane.showMessageDialog(null, "Reporte generado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("cmd /c start reporte.pdf");
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
                    generarReporte(2);

                    JOptionPane.showMessageDialog(null, "Reporte generado.", "Listo", JOptionPane.INFORMATION_MESSAGE);
                    Runtime.getRuntime().exec("cmd /c start reporte.pdf");
                    break;
            }

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Uno o más archivos solicitados no existen.", "Error", ERROR_MESSAGE);
        } catch (BiffException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.ClassCastException e)
        {
            JOptionPane.showMessageDialog(null, "Faltan completar datos. Intente de nuevo", "Error", ERROR_MESSAGE);
        } catch (DocumentException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
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

    private void generarReporte(int i) throws DocumentException, FileNotFoundException
    {
        Modelo m = modelos.get(i);
        
        Document doc = new Document();
        PdfWriter.getInstance(doc, new FileOutputStream("reporte.pdf"));
        doc.open();

        Paragraph titulo = new Paragraph("INFORME DE RESULTADOS\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 18, Font.BOLD));
        titulo.setAlignment(Element.ALIGN_CENTER);
        doc.add(titulo);
        
        Paragraph texto = new Paragraph("Modelo de Calidad: " + m.getNombreModelo(), FontFactory.getFont(FontFactory.TIMES_BOLD, 13, Font.PLAIN));
        doc.add(texto);
        
        Paragraph parrafo = new Paragraph("");
        switch(i)
        {
            case 0:
                parrafo = new Paragraph("Es un estándar internacional para la evaluación de la calidad del software. Considerando las siguientes características: Funcionalidad, Fiabilidad, Usabilidad, Eficiencia, Mantenibilidad y Portabilidad.\n\n",  FontFactory.getFont(FontFactory.TIMES, 13, Font.PLAIN));
                break;
            case 1:
                parrafo = new Paragraph("Se focaliza en el producto final identificando atributos claves desde el punto de vista del cliente. Estos atributos se denominan factores de calidad.\n\n",  FontFactory.getFont(FontFactory.TIMES, 13, Font.PLAIN));
                break;
            case 2:
                parrafo = new Paragraph("Basado en la norma ISO9126 y la IEC, especifica características para la calidad interna, externa y de uso. \n\n",  FontFactory.getFont(FontFactory.TIMES, 13, Font.PLAIN));
                break;
        
        }
        
        doc.add(parrafo);
        
        Paragraph fecha = new Paragraph("Fecha: " + (new Date().toString()), FontFactory.getFont(FontFactory.TIMES_BOLD, 13, Font.PLAIN));
        doc.add(fecha);
        
        
        for(int j = 0; j < m.getCaracteristicas().size(); j++)
        {
            Caracteristica c = m.getCaracteristicas().get(j);
            
            Paragraph caracteristica = new Paragraph((j + 1) + ". CARACTERISTICA: " + c.getNombreCaracteristica() + "\n\n", FontFactory.getFont(FontFactory.TIMES_BOLD, 13, Font.PLAIN) );
            doc.add(caracteristica);
            for(int k = 0; k < c.getSubcaracteristicas().size(); k++)
            {
                SubCaracteristica s = c.getSubcaracteristicas().get(k);
                
                Paragraph subcaracteristica = new Paragraph((j + 1) + "." + (k + 1) + ". SUBCARACTERISTICA: " + s.getNombreSubCaracteristica()  + "\n\n", FontFactory.getFont(FontFactory.TIMES, 13, Font.PLAIN) );
                doc.add(subcaracteristica);
                
                PdfPTable tabla = new PdfPTable(4);
                tabla.addCell("Nombre de la Metrica");
                tabla.addCell("Propósito");
                tabla.addCell("Valor Referencial");
                tabla.addCell("Valor Obtenido");
                
                for(int l = 0; l < s.getMetricas().size(); l++)
                {
                    Metrica mt = s.getMetricas().get(l);

                    tabla.addCell(mt.getNombreMetrica());
                    tabla.addCell(mt.getProposito());
                    tabla.addCell(String.valueOf(mt.getValorOptimo()));
                    tabla.addCell(mt.getValor());
                }
                
                doc.add(tabla);
            }
        }
        doc.close();
    }

}
