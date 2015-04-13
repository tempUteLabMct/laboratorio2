/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.negocio;

import com.basededatos.MysqlConnect;
import java.sql.ResultSet;

/**
 *
 * @author tutor
 */
public class Consulta {
    public boolean consulta_Codestudiante(String cod){
        
         MysqlConnect instmysql = new MysqlConnect();
         return instmysql.consulta_Codestudiante(cod);
     }
    public ResultSet consulta_elementos(String txto){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.consulta_elementos(txto);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
    
    public ResultSet consulta_elemCod(String cod){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.consulta_elemCod(cod);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
    
    public ResultSet consulta_estudiante(String cedula){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.consulta_estudiante(cedula);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
    
    public ResultSet realiza_Consulta(String tabla){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.realiza_consulta(tabla);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
     public ResultSet numero_Registro(String cedula){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.numero_Registros(cedula);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
    
     public ResultSet consulta_prestamos(String cedula){
                
        MysqlConnect instmysql = new MysqlConnect();
        
        try 
        { 
            return instmysql.consulta_prestamos(cedula);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}
    }
    
    public int borra_prestamos(String cedula){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.borra_prestamos(cedula);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
    
    public int borra_estudiante(String cedula){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.borra_registro(cedula);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
    
    public int borra_Recordatorio(String fecha){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.borra_Recordatorio(fecha);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
    
    public int borra_Elemento(String cod){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.borra_Elemento(cod);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
    
    public int ingresa_Recordatorio(String fecha, String recordatorio){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.ingresa_Recordatorio(fecha, recordatorio);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
     
    public int ingresa_Est(String cedula, String nombre,String codigo){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.ingresa_Estudiante(cedula, nombre, codigo);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
    
     public int ingresa_Prest(String codigo, String nombre,String descripcion,
                                String observacion, String fecha, String cedula_Estudiante){
        MysqlConnect instmysql = new MysqlConnect();
        try 
        { 
            return instmysql.ingresa_Prestamos(codigo, nombre, descripcion, observacion, fecha, cedula_Estudiante);
        }        
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return -1;
	}
        
    }
     
      public int actualiza_Inventario(String codigo, String destino,String nombre,
             String descripcion, String unidades,String cantidad,String observacion)
        {
            MysqlConnect instmysql = new MysqlConnect();
            try 
            { 
                return instmysql.actualiza_Inventario(codigo, destino, nombre, descripcion, unidades, cantidad, observacion);
            }        
            catch (Exception e) 
            {
                System.out.println("Error inesperado: " + e.getMessage());
                return -1;
            }
        }
      
            public int escribe_Inventario(String codigo, String destino,String nombre,
             String descripcion, String unidades,String cantidad,String observacion)
        {
            MysqlConnect instmysql = new MysqlConnect();
            try 
            { 
                return instmysql.escribe_Inventario(codigo, destino, nombre, 
                        descripcion, unidades, cantidad, observacion);
            }        
            catch (Exception e) 
            {
                System.out.println("Error inesperado: " + e.getMessage());
                return -1;
            }
        }
    
}
