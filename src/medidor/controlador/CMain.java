
package medidor.controlador;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import medidor.vista.UIMain;

public class CMain implements IMain {
    
    private UIMain ventanaPrincipal;
    
    public CMain()
    {
        ventanaPrincipal = new UIMain(this);
        
    }
    
    public void mostrarMedidorCalidad() {
        try {
            CCalidad calidad = new CCalidad();
            ventanaPrincipal.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(CMain.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public void mostrarDimensionamiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void mostrarRiesgos() {
        /* CODIGO DE PANDA */
    }
        
}
