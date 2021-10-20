package com.example.TiendaGenericaDA;
import java.sql.Statement;
import java.sql. PreparedStatement;
import java.sql. ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import com.example.TiendaGenericaVO.provedorVO;
public class DAOproveedor {
	//Mostrar Usuarios
	public ArrayList<provedorVO> listausuarios(){
		
	ArrayList<provedorVO> misusuarios=new  ArrayList<provedorVO>();
	Conexion conex=new Conexion();
	try{
		 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM proveedores");
		 ResultSet res= consulta.executeQuery();
		 while(res.next()) {
			 provedorVO user=new provedorVO();
			 user.setNit(res.getLong("nit_proveedor"));
			 user.setCiudad(res.getString("ciudad_proveedor"));
			 user.setDireccion(res.getString("direccion_proveedor"));
			 user.setNombre(res.getString("nombre_proveedor"));
			 user.setTelefono(res.getString("telefono_proveedor"));
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
	
	public ArrayList<provedorVO> buscarusuarios(long pcedula ){
		
	ArrayList<provedorVO> misusuarios=new  ArrayList<provedorVO>();
	Conexion conex=new Conexion();
	try{
		
		 PreparedStatement consulta =conex.getConnection().prepareStatement("SELECT * FROM proveedores where nit_proveedor=?");
		 consulta.setLong(1, pcedula);
		 
		 ResultSet res= consulta.executeQuery();
		 while(res.next()) {
			 provedorVO user=new provedorVO();
			 user.setNit(res.getLong("nit_proveedor"));
			 user.setCiudad(res.getString("ciudad_proveedor"));
			 user.setDireccion(res.getString("direccion_proveedor"));
			 user.setNombre(res.getString("nombre_proveedor"));
			 user.setTelefono(res.getString("telefono_proveedor"));
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
		String cadenaSQL="SELECT * FROM proveedores where nit_proveedor=? ";
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

	public boolean registrarusuario(provedorVO Usuario) {
		boolean swcrear = false;
		if (!existeusuario(Usuario.getNit())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta= (Statement) conex.getConnection().createStatement();
		
				String cadenaSQL="INSERT INTO proveedores (nit_proveedor, ciudad_proveedor, direccion_proveedor, nombre_proveedor, telefono_proveedor) values ("+Usuario.getNit()+",'"+Usuario.getCiudad()+"','"+Usuario.getDireccion()+"','"+Usuario.getNombre()+"','"+Usuario.getTelefono()+"'); ";
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
				
				String cadenaSQL="Delete from proveedores where nit_proveedor="+cedula;
					
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
	public boolean actualizarusuario(provedorVO Usuario) {
		boolean swactualizar = false;
		if (existeusuario(Usuario.getNit())) {
			Conexion conex = new Conexion();
			try {
				Statement consulta= (Statement) conex.getConnection().createStatement();
				
				String cadenaSQL="UPDATE proveedores set ciudad_proveedor='"+Usuario.getCiudad()+"',"+" direccion_proveedor='"+Usuario.getDireccion()+"',"+" nombre_proveedor='"+Usuario.getNombre()+"', "+" telefono_proveedor='"+Usuario.getTelefono()+"' where nit_proveedor="+Usuario.getNit();
						
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
