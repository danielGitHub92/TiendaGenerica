package com.example.TiendaGenericaDA;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import com.example.TiendaGenericaVO.*;
public class loginDAO {
	
	
	public ArrayList<loginVO> consultarUsuario(String usuario, String clave) {
		 ArrayList<loginVO> miusuario = new ArrayList<loginVO>();//Crea el objeto arryList
		 Conexion conex= new Conexion();
		 try {
			 String cadenaSQL="SELECT * FROM usuarios where password =? and usuario=?";
		 PreparedStatement consulta =conex.getConnection().prepareStatement(cadenaSQL);

		 consulta.setString(1, clave);//el orden de los ?
		 consulta.setString(2, usuario);
		 
		 ResultSet res = consulta.executeQuery();

		 if(res.next()){
		 loginVO usuario1= new loginVO();
		 usuario1.setUsuario(res.getString("usuario"));//leela BD
		 usuario1.setClave(res.getString("password"));
		 miusuario.add(usuario1);//agregar a la lista el usuario encontrado en la BD
		 }
		 res.close();
		 consulta.close();
		 conex.desconectar();
		 } catch (Exception e) {
		 JOptionPane.showMessageDialog(null, "no se pudo consultar El usuario\n"+e);
		 }
		 return miusuario;
		}

}
