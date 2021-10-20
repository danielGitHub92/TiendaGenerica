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
import com.example.TiendaGenericaVO.*;
import com.example.TiendaGenericaDA.*;
@RestController
public class ClienteController {
	
	@RequestMapping("/cargarArchivo")
	public String cargarArchivo(MultipartFile archivoCSV) {
	File archivoNew;
	String salida="";
	FileReader fuente = null;
	String linea="";
	ArrayList<ClienteVO1> listado= new ArrayList<ClienteVO1>();
	try {
	archivoNew = deMultiPartAFile(archivoCSV);
	fuente = new FileReader(archivoNew.getName());
	BufferedReader archivo = new BufferedReader(fuente);
	do {
	linea = archivo.readLine();
	if (linea!=null) {
	String tmpLinea = linea.replace("\"","'");
	ArrayList<String> miLista = new ArrayList<String>(Arrays.asList(tmpLinea.split(";")));
	ClienteVO1 cliente = new ClienteVO1();
	cliente.setCedula(Long.parseLong(miLista.get(0)));
	cliente.setDireccion(miLista.get(1).replace("'",""));
	cliente.setEmail(miLista.get(2).replace("'",""));
	cliente.setNombre(miLista.get(3).replace("'",""));
	cliente.setTelefono(miLista.get(4).replace("'",""));
	listado.add(cliente);
	}
	}while (linea!=null);
	archivo.close();
	fuente.close();
	boolean secreo= false;
	for(ClienteVO1 registro:listado) {
	secreo=true;
	salida = salida + "**"+secreo+"**" + registro.getCedula() + "---" +
			registro.getDireccion() + "---"+
			registro.getEmail() + "---" +
			registro.getNombre() + " ---"+
			registro.getTelefono() + "<br>";
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
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			return convFile;
			}
			
			@RequestMapping("/listaClientes")
			public ArrayList<ClienteVO1> listaDeClientes(){
			ClienteDAO dao = new ClienteDAO();
			ArrayList<ClienteVO1> listado = dao.listaDeClientes();
			return listado;
			}
			
		

}
