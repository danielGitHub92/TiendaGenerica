package com.example.TiendaGenericaDA;
import java.sql.Statement;
 import java.sql. PreparedStatement;
import java.sql. ResultSet;
 import java.sql.SQLException;
import java.util.ArrayList;
import com.example.TiendaGenericaVO.clienteVO;


public class proveedorDAO {
	//Mostrar Usuarios
		public ArrayList<clienteVO> listausuarios(){
			
		ArrayList<clienteVO> misusuarios=new  ArrayList<clienteVO>();
		Conexion conex=new Conexion();
		try{
			 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM usuarios");
			 ResultSet res= consulta.executeQuery();
			 while(res.next()) {
				 clienteVO user=new clienteVO();
				 user.setCedula(res.getLong("cedula_usuario"));
				 user.setEmail(res.getString("email_usuario"));
				 user.setNombre(res.getString("nombre_usuario"));
				 user.setClave(res.getString("password"));
				 user.setUsuario(res.getString("usuario"));
				 misusuarios.add(user);
				 
			 }
			 res.close();
			 consulta.close();
			 conex.desconectar();
		}catch(Exception ex) {
			System.out.println("No se pudo conectar");
		}

		return misusuarios;
		}

		
		// Buscar Cedula Usuarios
		
		public ArrayList<clienteVO> buscarusuarios(long pcedula ){
			
		ArrayList<clienteVO> misusuarios=new  ArrayList<clienteVO>();
		Conexion conex=new Conexion();
		try{
			
			 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM usuarios where cedula_usuario=?");
			 consulta.setLong(1, pcedula);
			 
			 ResultSet res= consulta.executeQuery();
			 while(res.next()) {
				 clienteVO user=new clienteVO();
				 user.setCedula(res.getLong("cedula_usuario"));
				 user.setEmail(res.getString("email_usuario"));
				 user.setNombre(res.getString("nombre_usuario"));
				 user.setClave(res.getString("password"));
				 user.setUsuario(res.getString("usuario"));
				 misusuarios.add(user);
				 
			 }
			 res.close();
			 consulta.close();
			 conex.desconectar();
			
		}catch(Exception ex) {
			
			System.out.println("No se pudo conectar");
		}

		return misusuarios;
		}
		
		//ExisteUsuario
		public boolean existeusuario(Long pcedula) {
		
		boolean  existe=false;
		Conexion conex=new Conexion();
		try {
			String cadenaSQL="SELECT * FROM usuarios where cedula_usuario=? ";
			 PreparedStatement consulta =conex.getConnection().prepareStatement(cadenaSQL);
			 
			 consulta.setLong(1, pcedula);
			 ResultSet res=consulta.executeQuery();
			 if(res.next()) {
				 existe=true;
			 }
			 res.close();
			 consulta.close();
			 conex.desconectar();
			
			
		}catch(Exception e) {
			System.out.println("No se pudo verificar si existe el usuario");
			
		}
		return existe;
			
	}

		//Registrar usuarios

		public boolean registrarusuario(clienteVO Usuario) {
			boolean swcrear = false;
			if (!existeusuario(Usuario.getCedula())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta= (Statement) conex.getConnection().createStatement();
			
					String cadenaSQL="INSERT INTO usuarios (cedula_usuario, email_usuario, nombre_usuario, password, usuario) values ("+Usuario.getCedula()+",'"+Usuario.getEmail()+"','"+Usuario.getNombre()+"','"+Usuario.getClave()+"','"+Usuario.getUsuario()+"'); ";
					((java.sql.Statement)consulta).executeUpdate(cadenaSQL);
					((java.sql.Statement)consulta).close();
					conex.desconectar();
					swcrear=true;

				} catch (SQLException e) {
					System.out.println("No se pudo verificar el usuario");

				}
			}else {
				System.out.println("El Usuario Ya existe");

			}
		return swcrear;

	}

		//Eliminar usuario
		
		public boolean borrarusuario(long cedula) {
			boolean sweliminar = false;
			if (existeusuario(cedula)) {
				Conexion conex = new Conexion();
				try {
					Statement consulta= (Statement) conex.getConnection().createStatement();
					
					String cadenaSQL="Delete from usuarios where cedula_usuario="+cedula;
						
					consulta.executeUpdate(cadenaSQL);
					consulta.close();
					conex.desconectar();
					sweliminar=true;

				} catch (SQLException e) {
					System.out.println("No se pudo eliminar el usuario");

				}
			}else {
				System.out.println("El Usuario No existe");

			
			}
		return sweliminar;
		
		}

		//Actualizar usuario
		public boolean actualizarusuario(clienteVO Usuario) {
			boolean swactualizar = false;
			if (existeusuario(Usuario.getCedula())) {
				Conexion conex = new Conexion();
				try {
					Statement consulta= (Statement) conex.getConnection().createStatement();
					
					String cadenaSQL="UPDATE usuarios set email_usuario='"+Usuario.getEmail()+"',"+" nombre_usuario='"+Usuario.getNombre()+"',"+" password='"+Usuario.getClave()+"', "+" usuario='"+Usuario.getUsuario()+"' where cedula_usuario="+Usuario.getCedula();
							
					((java.sql.Statement)consulta).executeUpdate(cadenaSQL);
					((java.sql.Statement)consulta).close();
					conex.desconectar();
					swactualizar=true;

				} catch (SQLException e) {
					System.out.println("No se pudo actualizar el usuario");

				}
			}else {
				System.out.println("El Usuario  No existe");

			
			}
		return swactualizar;
			
			
		}
		
		
		
		
		
		
}
