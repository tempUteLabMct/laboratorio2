/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
/**
 *
 * @author tutor
 */
public class Archivo {
       
    public void escribir_linea(String cedula ,String texto)
    {
        try
        {
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo=new File(cedula+".txt");
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir=new FileWriter(archivo,true);
            //Escribimos en el archivo con el metodo write
            escribir.write(texto);
            //Cerramos la conexion
            escribir.close();
        }
        //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }
       
    }
        public String leer_pass()
    {
        //Creamos un String que va a contener todo el texto del archivo
        String texto="";
        try
        {
            String path="C:/Users/tutor/cts.txt";
            System.out.println(path.replaceAll("file:/", ""));
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader(path.replaceAll("file:/", ""));// ClassLoader.getSystemResource devuelve un url con la cadena 'file:/' al inicio esta funcion la borra
            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido=new BufferedReader(lector);
            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            texto=contenido.readLine();
            return texto;
        }
        //Si se causa un error al leer cae aqui
        catch(Exception e)
        {
            System.out.println("Error al leer "+e);
            return null;
        }
    }
    
    public void escribir_pass(String cts)
    {
        try
        {
            String path="C:/Users/tutor/cts.txt";
            //Crear un objeto File se encarga de crear o abrir acceso a un archivo que se especifica en su constructor
            File archivo = new File(path.replaceAll("file:/", ""));
            archivo.delete();
            archivo.createNewFile();
            //Crear objeto FileWriter que sera el que nos ayude a escribir sobre archivo
            FileWriter escribir=new FileWriter(archivo,true);
            //Escribimos en el archivo con el metodo write
            escribir.write(cts);
            //Cerramos la conexion
            escribir.close();
        }
        //Si existe un problema al escribir cae aqui
        catch(Exception e)
        {
            System.out.println("Error al escribir");
        }
       
    }   
    
    public String leer(String cedula)
    {
        //Creamos un String que va a contener todo el texto del archivo
        String texto="";
        try
        {
            //Creamos un archivo FileReader que obtiene lo que tenga el archivo
            FileReader lector=new FileReader(cedula+".txt");
            //El contenido de lector se guarda en un BufferedReader
            BufferedReader contenido=new BufferedReader(lector);
            //Con el siguiente ciclo extraemos todo el contenido del objeto "contenido" y lo mostramos
            while((texto=contenido.readLine())!=null)
            {
                System.out.println(texto);
            }
            return texto;
        }
        //Si se causa un error al leer cae aqui
        catch(Exception e)
        {
            System.out.println("Error al leer");
            return null;
        }
    }
}
