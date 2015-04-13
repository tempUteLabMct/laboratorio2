/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

/**
 *
 * @author Kuidsh
 */
import java.awt.event.*;
import java.awt.*;
import javax.swing.JOptionPane;

public class MakeEnterDoAction extends KeyAdapter {

    @Override
    public void keyPressed(KeyEvent ke)
    {
        if (ke.getKeyCode() == KeyEvent.VK_ENTER)
        {
            Object src = ke.getSource();
            Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(
            new ActionEvent(src,
            ActionEvent.ACTION_PERFORMED,
            "Enter"));
        }
    } // end keyPressed()

} // end class
