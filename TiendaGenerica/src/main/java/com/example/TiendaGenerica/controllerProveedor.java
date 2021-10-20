package com.example.TiendaGenerica;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.json.GsonJsonParser;
import org.springframework.boot.json.JsonParser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.TiendaGenericaDA.*;
import com.example.TiendaGenericaVO.*;
import com.fasterxml.jackson.databind.JsonNode;

@RestController
public class controllerProveedor {
	
	
@RequestMapping("/listausuarios")
public ArrayList<clienteVO> listadeusuario(){
	proveedorDAO dao= new proveedorDAO();
	return dao.listausuarios();
}

@RequestMapping("/buscarusuarioID")
public ArrayList<clienteVO>buscarusuario(String cedula){
	proveedorDAO dao= new proveedorDAO();
	return dao.buscarusuarios(Long.parseLong(cedula));
}

@RequestMapping("/crearusuario")
public boolean registrarusuario (String cedula, String email, String nombre, String clave, String usuario){
	proveedorDAO dao= new proveedorDAO();
	clienteVO cliente=new clienteVO();
	
	cliente.setCedula(Long.parseLong(cedula));
	cliente.setEmail(email);
	cliente.setNombre(nombre);
	cliente.setClave(clave);
	cliente.setUsuario(usuario);
	return dao.registrarusuario(cliente);
}

@RequestMapping("/borrarusuario")
public boolean eliminarusuario (String cedula){
	proveedorDAO dao= new proveedorDAO();
	return dao.borrarusuario(Long.parseLong(cedula));
}

@RequestMapping("/actualizarusuario")
public boolean actualizararusuario (String cedula, String email, String nombre, String clave,String usuario){
	proveedorDAO dao= new proveedorDAO();
	clienteVO cliente=new clienteVO();
	cliente.setCedula(Long.parseLong(cedula));
	cliente.setEmail(email);
	cliente.setNombre(nombre);
	cliente.setClave(clave);
	cliente.setUsuario(usuario);
	
	return dao.actualizarusuario(cliente);
}
	
}

