/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Model;

/**
 *
 * @author Estefanía Neitzky
 */

import java.sql.*;
import java.util.ArrayList;
public class DAOGrupo {
    static Conexion  con;
    
    public DAOGrupo(){
        con=new Conexion();
    }
    
    public void insertar(Grupo g)throws Exception{
     Connection cone=   con.conectarse();
   CallableStatement callate=  cone.prepareCall("{call insertar_usuario(?,?,?)}");
   callate.setInt(1,g.getId());
   callate.setString(2,g.getLogin());
   callate.setString(3, g.getPassword());
   callate.executeUpdate();
   callate.close();
   cone.close();
   System.out.println("Se inserto el registro con exito");
    
 }
    
    public static  ArrayList<Grupo> buscarTodos()throws Exception {
       ArrayList<Grupo> grupos=new ArrayList<Grupo>();  
       //Primero nos conectamos a la base de datos
    Connection conexion= con.conectarse();
    //Crear un Statement de sql
     Statement st=  conexion.createStatement();
       ResultSet res=st.executeQuery("select * from usuario1 order by login");
       while(res.next()){
         int id=  res.getInt(1);
         String login=res.getString(2);
         String password=res.getString(3);
         Grupo u=new Grupo(id,login,password); 
         grupos.add(u);
       }
       return grupos;
    }
}

  
