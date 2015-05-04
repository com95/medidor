/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.controlador;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
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
    
    public static void main(String args [])
    {
        new Main();
        Connection con = null;
        Statement stat = null;
        
    }
}
