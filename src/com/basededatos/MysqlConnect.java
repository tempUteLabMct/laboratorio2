
package com.basededatos;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MysqlConnect 
{
    public Connection realiza_conexion()
    {
          System.out.println("MySQL Connect Example.");
          Connection conn = null;
          String url = "jdbc:mysql://localhost:3306/";
          String dbName = "laboratorio";
          String driver = "com.mysql.jdbc.Driver";
          String userName = "root"; 
          String password = "pasantia";
          try 
          {
              Class.forName(driver).newInstance();
              conn = DriverManager.getConnection(url+dbName,userName,password);
              System.out.println("Connected to the database");                                          
              return conn;
             
          } 
          catch (Exception e) 
          {
              e.printStackTrace();
              return null;
          }
    }
    
    public ResultSet consulta_elementos(String texto)
    {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="SELECT * FROM inventario WHERE Nombre LIKE '%"+texto+"%'";
	    ResultSet resultado = stmt.executeQuery(lsentencia);             
            return resultado;            
	} 
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    }
    
    public ResultSet consulta_elemCod(String cod)
    {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="SELECT * FROM inventario WHERE Codigo LIKE '"+cod+"'";
	    ResultSet resultado = stmt.executeQuery(lsentencia);             
            return resultado;
	} 
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    }
    
    public boolean consulta_Codestudiante(String cod){
        boolean consulta=false;
        Connection conexion=realiza_conexion();
        Statement stmt;
        try {
            stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="SELECT * FROM registro WHERE Codigo LIKE '"+cod+"'";
            ResultSet resultado = stmt.executeQuery(lsentencia);
            consulta=resultado.last();            
         } catch (SQLException ex) {
            Logger.getLogger(MysqlConnect.class.getName()).log(Level.SEVERE, null, ex);
        }   
        if(consulta==true)
            return consulta;
        else
            return false;
    }
    
    public ResultSet consulta_estudiante(String cedula)
    {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="SELECT * FROM registro WHERE Cedula LIKE '"+cedula+"'";
	    ResultSet resultado = stmt.executeQuery(lsentencia);             
            return resultado;            
	} 
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    }
    public ResultSet consulta_prestamos(String cedula)
    {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="SELECT * FROM prestamos WHERE Cedula_Estudiante LIKE '"+cedula+"'";
	    ResultSet resultado = stmt.executeQuery(lsentencia);             
            return resultado;            
	} 
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    }
    
    public int borra_prestamos(String cedula)
    {
       
        try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="DELETE FROM prestamos WHERE Cedula_Estudiante LIKE '"+cedula+"'";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }

    }
        
    public int borra_registro(String cedula)
    {
       
        try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="DELETE FROM registro WHERE Cedula LIKE '"+cedula+"'";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }

    }
    
    public ResultSet realiza_consulta(String tabla)
        {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";            
            lsentencia="SELECT * FROM "+tabla;            
	    ResultSet resultado = stmt.executeQuery(lsentencia); 
            
            return resultado;
            
	}
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    }
    
    public ResultSet numero_Registros(String cedula)
        {
       
        try 
        {           
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";  
            //Sentencia Genera 2 columnas de registros el primero es la cedula y el segundo el numero de registros q existen en la tabla
            lsentencia="SELECT Cedula_Estudiante, COUNT(*) FROM prestamos WHERE Cedula_Estudiante LIKE '"+cedula+"' GROUP BY Cedula_Estudiante;";            
	    ResultSet resultado = stmt.executeQuery(lsentencia); 
            
            return resultado;
            
	}
        catch (SQLException e) 
        {
	    System.out.println("Error de MySQL: " + e.getMessage());
            return null;
            
	} 
        catch (Exception e) 
        {
	    System.out.println("Error inesperado: " + e.getMessage());
            return null;
	}

    } 
    
    public int borra_Recordatorio(String fecha)
    {
       
        try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="DELETE FROM recordatorios WHERE Hora LIKE '"+fecha+"'";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }

    }
    public int ingresa_Recordatorio(String fecha, String recordatorio)
        {    
            try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="insert into recordatorios values('"+fecha+"','"+recordatorio+"')";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }       
        }
    
     public int ingresa_Estudiante(String cedula, String nombre,String codigo)
        {    
            try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="insert into registro values('"+cedula+"','"+nombre+"','"+
                           codigo+"')";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }       
        }
    
     public int ingresa_Prestamos(String codigo, String nombre,String descripcion,
                                String observacion, String fecha, String cedula_Estudiante)
        {    
            try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="insert into prestamos values('"+codigo+"','"+nombre+"','"+
                           descripcion+"','"+observacion+"','"+fecha+"','"+cedula_Estudiante+"')";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
            } 
            catch (Exception e) 
            {
              System.out.println("Error inesperado: " + e.getMessage());
              return -1;
            }       
        }
     
     public int borra_Elemento(String cod)
    {
       
        try 
            {
                Connection conexion=realiza_conexion();
                Statement stmt = conexion.createStatement();
                String lsentencia="";
                lsentencia="DELETE FROM inventario WHERE Codigo LIKE '"+cod+"'";
                int registrosAfectados = stmt.executeUpdate(lsentencia);
                System.out.println("Registros afectados: " + registrosAfectados + " registros");

      //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
      //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
                return registrosAfectados;
            } 
            catch (SQLException e) 
            {
              System.out.println("Error de MySQL: " + e.getMessage());
              return -1;
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
        try 
        {
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="UPDATE inventario set Destino='"+destino+"',"+
                    "Nombre='"+nombre+"',"+
                    "Descripcion='"+descripcion+"',"+
                    "Unidades='"+unidades+"',"+
                    "Observacion='"+observacion+"',"+
                    "Cantidad_Actual='"+cantidad+"' where Codigo='"+codigo.trim()+"'";                           
            int registrosAfectados = stmt.executeUpdate(lsentencia);
            System.out.println("Registros afectados: " + registrosAfectados + " registros");

  //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
  //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
            return registrosAfectados;
	} 
        catch (SQLException e) 
        {
	  System.out.println("Error de MySQL: " + e.getMessage());
          return -1;
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
        try 
        {
            Connection conexion=realiza_conexion();
            Statement stmt = conexion.createStatement();
            String lsentencia="";
            lsentencia="INSERT INTO inventario VALUES('"+codigo+"','"+destino+"',"
                    + "'"+nombre+"','"+descripcion+"','"+unidades+"','','1','','0','',"
                    + "'0','','"+cantidad+"','','','"+observacion+"','')";                           
            int registrosAfectados = stmt.executeUpdate(lsentencia);
            System.out.println("Registros afectados: " + registrosAfectados + " registros");

  //	  registrosAfectados = stmt.executeUpdate("INSERT INTO usuarios (nombre, clave) VALUES ('Homero', '123')");
  //	  System.out.println("Registros afectados: " + registrosAfectados+ " registros");
            return registrosAfectados;
	} 
        catch (SQLException e) 
        {
	  System.out.println("Error de MySQL: " + e.getMessage());
          return -1;
	} 
        catch (Exception e) 
        {
	  System.out.println("Error inesperado: " + e.getMessage());
          return -1;
	}       
    }
    
    
    
}
