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
public class provedorController {

	
@RequestMapping("/listausuarios3")
public ArrayList<provedorVO> listadeusuario(){
	DAOproveedor dao= new DAOproveedor();
	return dao.listausuarios();
}

@RequestMapping("/buscarusuarioID1")
public ArrayList<provedorVO>buscarusuario(String cedula){
	DAOproveedor dao= new DAOproveedor();
	return dao.buscarusuarios(Long.parseLong(cedula));
}

@RequestMapping("/crearusuario12")
public boolean registrarusuario (String cedula, String email, String nombre, String clave, String usuario){
	DAOproveedor dao= new DAOproveedor();
	provedorVO cliente=new provedorVO();
	
	cliente.setNit(Long.parseLong(cedula));
	cliente.setCiudad(email);
	cliente.setDireccion(nombre);
	cliente.setNombre(clave);
	cliente.setTelefono(usuario);
	return dao.registrarusuario(cliente);
}

@RequestMapping("/borrarusuario1l83985")
public boolean eliminarusuario (String cedula){
	DAOproveedor dao= new DAOproveedor ();
	return dao.borrarusuario(Long.parseLong(cedula));
}

@RequestMapping("/actualizarusuario1p")
public boolean actualizararusuario (String cedula, String email, String nombre, String clave,String usuario){
	DAOproveedor dao= new DAOproveedor();
	provedorVO cliente=new provedorVO();
	
	cliente.setNit(Long.parseLong(cedula));
	cliente.setCiudad(email);
	cliente.setDireccion(nombre);
	cliente.setNombre(clave);
	cliente.setTelefono(usuario);
	
	return dao.actualizarusuario(cliente);
}
}
