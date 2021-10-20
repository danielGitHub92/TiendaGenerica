package com.example.TiendaGenericaDA;

import java.sql.Statement;
import java.sql. PreparedStatement;
import java.sql. ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.TiendaGenericaVO.usuarioVO;

public class usuarioDAO {
	
	//Mostrar Usuarios
			public ArrayList<usuarioVO> listausuarios(){
				
			ArrayList<usuarioVO> misusuarios=new  ArrayList<usuarioVO>();
			Conexion conex=new Conexion();
			try{
				 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM clientes");
				 ResultSet res= consulta.executeQuery();
				 while(res.next()) {
					 usuarioVO user=new usuarioVO();
					 user.setCedula(res.getLong("cedula_cliente"));
					 user.setDireccion(res.getString("direccion_cliente"));
					 user.setEmail(res.getString("email_cliente"));
					 user.setNombre(res.getString("nombre_cliente"));
					 user.setTelefono(res.getString("telefono_cliente"));
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
			
			public ArrayList<usuarioVO> buscarusuarios(long pcedula ){
				
			ArrayList<usuarioVO> misusuarios=new  ArrayList<usuarioVO>();
			Conexion conex=new Conexion();
			try{
				
				 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM clientes where cedula_cliente=?");
				 consulta.setLong(1, pcedula);
				 
				 ResultSet res= consulta.executeQuery();
				 while(res.next()) {
					 usuarioVO user=new usuarioVO();
					 user.setCedula(res.getLong("cedula_cliente"));
					 user.setDireccion(res.getString("direccion_cliente"));
					 user.setEmail(res.getString("email_cliente"));
					 user.setNombre(res.getString("nombre_cliente"));
					 user.setTelefono(res.getString("telefono_cliente"));
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
				String cadenaSQL="SELECT * FROM clientes where cedula_cliente=? ";
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

			public boolean registrarusuario(usuarioVO Usuario) {
				boolean swcrear = false;
				if (!existeusuario(Usuario.getCedula())) {
					Conexion conex = new Conexion();
					try {
						Statement consulta= (Statement) conex.getConnection().createStatement();
				
						String cadenaSQL="INSERT INTO clientes (cedula_cliente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente ) values ("+Usuario.getCedula()+",'"+Usuario.getDireccion()+"','"+Usuario.getEmail()+"','"+Usuario.getNombre()+"','"+Usuario.getTelefono()+"'); ";
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
						
						String cadenaSQL="Delete from clientes where cedula_cliente="+cedula;
							
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
			public boolean actualizarusuario(usuarioVO Usuario) {
				boolean swactualizar = false;
				if (existeusuario(Usuario.getCedula())) {
					Conexion conex = new Conexion();
					try {
						Statement consulta= (Statement) conex.getConnection().createStatement();
						
						String cadenaSQL="UPDATE clientes set direccion_cliente='"+Usuario.getDireccion()+"',"+" email_cliente='"+Usuario.getEmail()+"',"+" nombre_cliente='"+Usuario.getNombre()+"', "+" telefono_cliente='"+Usuario.getTelefono()+"' where cedula_cliente="+Usuario.getCedula();
								
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



