package com.example.TiendaGenericaDA;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.example.TiendaGenericaVO.*;
public class ClienteDAO {
	public boolean registrarCliente(ClienteVO1 cliente) {
		boolean creado=false;
		if(!existeCliente(cliente.getCedula())) {
		Conexion conex = new Conexion();
		try {
		Statement consulta = conex.getConnection().createStatement();
		String sql = "INSERT INTO cliente (cedula_cLiente, direccion_cliente, email_cliente, nombre_cliente, telefono_cliente) VALUES "+
		"("+cliente.getCedula()+",'"+cliente.getDireccion()+
		"','"+cliente.getEmail()+"','"+cliente.getNombre()+
		"','"+cliente.getTelefono()+"');";
		consulta.executeUpdate(sql);
		consulta.close();
		conex.desconectar();
		creado = true;
		}catch(SQLException e) {
		System.out.println("No se pudo crear el cliente.");
		}
		}else {
		System.out.println("El cliente ya exite.");
		}
		return creado;
		}
		public boolean existeCliente(Long cedula) {
		boolean existe = false;
		Conexion conex = new Conexion();
		try {
		PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente WHERE cedula_cliente = ?");
		consulta.setLong(1,cedula);
		ResultSet res = consulta.executeQuery();
		if (res.next()) {
		existe = true;
		}
		res.close();
		consulta.close();
		conex.desconectar();
		}catch(Exception e) {
		System.out.println("No se pudo conectar");
		}
		return existe;
		}
		public ArrayList<ClienteVO1> listaDeClientes(){
		ArrayList<ClienteVO1> misClientes = new ArrayList<ClienteVO1>(); Conexion conex = new Conexion();
		try { PreparedStatement consulta = conex.getConnection().prepareStatement("SELECT * FROM cliente");
		ResultSet res = consulta.executeQuery();
		while(res.next()){
		ClienteVO1 cliente = new ClienteVO1();
		cliente.setCedula(res.getLong("cedula_cliente"));
		cliente.setDireccion(res.getString("direccion_cliente"));
		cliente.setEmail(res.getString("email_cliente"));
		cliente.setNombre(res.getString("nombre_cliente"));
		cliente.setTelefono(res.getString("telefono_cliente"));
		misClientes.add(cliente);
		}
		res.close();
		consulta.close(); conex.desconectar();
		}catch(Exception e) {
		System.out.println("No se pudo conectar");
		}
		return misClientes;
		
		}
}
