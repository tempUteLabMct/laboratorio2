/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

/**
 *
 * @author tutor
 */
public class Contrasena {

    /**
     *
     */
   
    public void cambiar_pass(String pass2)
    {
        Archivo archi=new Archivo();
        archi.escribir_pass(pass2);
        
    }
    public  String devolver_pss()
    {
        Archivo archi=new Archivo();
        String pss=archi.leer_pass();
        return pss;
    }
}
