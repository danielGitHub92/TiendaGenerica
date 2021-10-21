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
public class reporteController {
	@RequestMapping("/CAPODAO")
	public ArrayList<clienteVO> listadeusuario(){
		proveedorDAO dao= new proveedorDAO();
		return dao.listausuarios();
	}
	
	@RequestMapping("/CAPADEO")
	public ArrayList<usuarioVO> listadeusuario2(){
		usuarioDAO dao= new usuarioDAO();
		return dao.listausuarios();
	}
	
	
}
