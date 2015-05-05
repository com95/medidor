/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package medidor.controlador;

import javax.swing.JList;
import javax.swing.JTextArea;

/**
 *
 * @author Yuli
 */
public interface IMain {
    public void mostrarDescripcion(JList jlist, JTextArea jtextarea);
    public void evaluar(JList jlist);
}
