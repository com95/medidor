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
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import medidor.modelo.Caracteristica;
import medidor.modelo.Metrica;
import medidor.modelo.Modelo;
import medidor.modelo.Parametro;
import medidor.modelo.SubCaracteristica;
import medidor.vista.UIMain;

public class CMain implements IMain {

    private UIMain ventanaPrincipal;
    private Vector<Parametro> p;

    public CMain() {
        ventanaPrincipal = new UIMain(this);
        p = new Vector<Parametro>();
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
            
            switch(jlist.getSelectedIndex())
            {
                case 0:
                    Runtime.getRuntime().exec("cmd /c start ISO.xls");
                    
                    break;
                case 1:
                    Runtime.getRuntime().exec("cmd /c start McCall.xls");
                    break;
                case 2:
                    Runtime.getRuntime().exec("cmd /c start Peruano.xls");
                    break;
            }
            /*

            archivo1 = new File("ISO.xls");
            archivo2 = new File("McCall.xls");
            archivo3 = new File("Peruano.xls");

            fr1 = new FileReader(archivo1);
            fr2 = new FileReader(archivo2);
            fr3 = new FileReader(archivo3);

            br1 = new BufferedReader(fr1);
            br2 = new BufferedReader(fr2);
            br3 = new BufferedReader(fr3);

            int cod = 6;
            
            Workbook workbook4 = Workbook.getWorkbook(new File("resultado_KW.xls"));
            Sheet sheet4 = workbook4.getSheet(0);

            for (int i = 0; i < sheet4.getRows(); i++)
            {
                p.add(new Parametro(cod, ((NumberCell)sheet4.getCell(1, i)).getValue()));
                cod++;
            }

            Workbook workbook6 = Workbook.getWorkbook(new File("resultado_SQ.xls"));
            Sheet sheet6 = workbook6.getSheet(0);

            String linea6;

            for (int i = 0; i < sheet4.getRows(); i++)
            {
                p.add(new Parametro(cod + i + 1, ((NumberCell)sheet4.getCell(1, i)).getValue()));
            }

            Workbook workbook3 = Workbook.getWorkbook(new File("resultado_MA.xls"));
            Sheet sheet3 = workbook3.getSheet(0);

            String linea3;

            for (int i = 0; i < sheet3.getRows(); i++) {
                linea3 = sheet3.getCell(1, i).getContents();
                p.add(new Parametro(21 + i, Double.parseDouble(linea3)));
            }

            for (int i = 0; i < p.size(); i++) {
                p.get(i).toStrings();
            }*/
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Uno o más archivos solicitados no existen.", "Error", ERROR_MESSAGE);
        }/* catch (BiffException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (null != fr1) {
                try {
                    fr1.close();
                } catch (IOException ex1) {

                }
            }
            if (null != fr2) {
                try {
                    fr2.close();
                } catch (IOException ex2) {

                }
            }
            if (null != fr3) {
                try {
                    fr3.close();
                } catch (IOException ex3) {

                }
            }
            if (null != fr4) {
                try {
                    fr4.close();
                } catch (IOException ex4) {

                }
            }
            if (null != fr5) {
                try {
                    fr5.close();
                } catch (IOException ex5) {

                }
            }
            if (null != fr6) {
                try {
                    fr6.close();
                } catch (IOException ex6) {

                }
            }

        }*/

    }

}
