/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.controlador;

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
    
}
