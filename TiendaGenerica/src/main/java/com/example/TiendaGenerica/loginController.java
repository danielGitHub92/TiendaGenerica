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
public class loginController {
				// devuelve true o false si existe el usuario
	@RequestMapping("/loginusuario2")
	public Map<String, Boolean> validarlogin2(String usuario, String clave)//recibe esta cadena y convierte en un objeto de tipo cliente
	{
	 ArrayList<loginVO> miusuario = new ArrayList<loginVO>();//Crea el objeto arryList

	 //pasa la peteción al servicio
	loginDAO Dao=new loginDAO(); //cargamos el objeto y se pasa al DAOy valida el usuario
	 miusuario= Dao.consultarUsuario(usuario, clave);
	 
	 if(miusuario.isEmpty())
	 {
	 return Collections.singletonMap("existe", false);
	 }
	 else
	 {
	 return Collections.singletonMap("existe", true);
	 
	 }


	}
}

