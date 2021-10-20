package com.example.TiendaGenerica;

import java.io.BufferedReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.example.TiendaGenericaDA.*;
import com.example.TiendaGenericaVO.clienteVO;
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
public class ControllerUser {
	
	@RequestMapping("/cargaarchivo")
	public String cargarArchivo(MultipartFile archivoCSV) {
	File archivoNew;
	String salida="";
	FileReader fuente = null;
	String linea="";
	
	ArrayList<clienteVO> listado= new ArrayList<clienteVO>();
	try {
		archivoNew = deMultiPartAFile(archivoCSV);
		fuente = new FileReader(archivoNew.getName());
		BufferedReader archivo = new BufferedReader(fuente);
	do {
	linea = archivo.readLine();
	if (linea!=null) {
	String tmpLinea = linea.replace("\"","'");
	ArrayList<String> miLista = new ArrayList<String>(Arrays.asList(tmpLinea.split(";")));
	clienteVO cliente = new clienteVO();
	cliente.setCedula(Long.parseLong(miLista.get(0)));
	cliente.setEmail(miLista.get(1));
	cliente.setNombre(miLista.get(2));
	cliente.setClave(miLista.get(3));
	cliente.setUsuario(miLista.get(4));
	listado.add(cliente);
	}
	}while (linea!=null);
	archivo.close();
	fuente.close();
	boolean secreo= false;
	for(clienteVO registro:listado) {
		secreo=true;
	salida = salida + "**"+secreo+"**" + registro.getCedula() + "---" +
	registro.getEmail() + "---"+
	registro.getNombre() + "---" +
	registro.getClave() + " ---"+
	 registro.getUsuario()+ "<br>";
	}
	salida = salida + " RTA: " + (secreo?"Ok":"No se pudo insertar el listadio");
	}catch(FileNotFoundException e) {
	System.out.println(e.getMessage());
	}catch(IOException e2) {
	System.out.println(e2.getMessage());
	}
	return salida;
	}

	 private File deMultiPartAFile(MultipartFile archivo) {
	File convFile = new File(archivo.getOriginalFilename());
	FileOutputStream salida;
	try {
	salida = new FileOutputStream(convFile);
	salida.write(archivo.getBytes());
	salida.close();
	} catch (IOException e) {
	e.printStackTrace();
	}
	return convFile;
	}

	
}
