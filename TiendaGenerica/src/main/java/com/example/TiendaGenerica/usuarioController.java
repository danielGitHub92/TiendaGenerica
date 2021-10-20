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
public class usuarioController {

@RequestMapping("/listausuarios2")
public ArrayList<usuarioVO> listadeusuario(){
	usuarioDAO dao= new usuarioDAO();
	return dao.listausuarios();
}

@RequestMapping("/buscarusuarioID2")
public ArrayList<usuarioVO>buscarusuario(String cedula){
	usuarioDAO dao=new usuarioDAO();
	return dao.buscarusuarios(Long.parseLong(cedula));
}

@RequestMapping("/crearusuario2")
public boolean registrarusuario (String cedula, String email, String nombre, String clave, String usuario){
	usuarioDAO dao= new usuarioDAO();
	usuarioVO cliente=new usuarioVO();
	
	cliente.setCedula(Long.parseLong(cedula));
	cliente.setDireccion(email);
	cliente.setEmail(nombre);
	cliente.setNombre(clave);
	cliente.setTelefono(usuario);
	return dao.registrarusuario(cliente);
}

@RequestMapping("/borrarusuario2")
public boolean eliminarusuario (String cedula){
	usuarioDAO dao= new usuarioDAO();
	return dao.borrarusuario(Long.parseLong(cedula));
}

@RequestMapping("/actualizarusuario2")
public boolean actualizararusuario (String cedula, String email, String nombre, String clave,String usuario){
	usuarioDAO dao= new usuarioDAO();
	usuarioVO cliente=new usuarioVO();
	cliente.setCedula(Long.parseLong(cedula));
	cliente.setDireccion(email);
	cliente.setEmail(nombre);
	cliente.setNombre(clave);
	cliente.setTelefono(usuario);
	return dao.actualizarusuario(cliente);
}
}
