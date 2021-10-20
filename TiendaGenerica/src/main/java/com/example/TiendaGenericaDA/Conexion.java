package com.example.TiendaGenericaDA;
import java.sql.*;
public class Conexion {
	
	static String bd = "grupo16_equipo10";
	static String login = "admin";
	static String password = "tiendagenericamaoe2";
	static String url = "jdbc:mysql://tiendagenericamaoe2.czo3ixoe3xoe.us-east-1.rds.amazonaws.com:3306/"+bd;
	Connection connection = null;
	/** Constructor de DbConnection */
	public Conexion() {
	try{
	//obtenemos el driver de para mysql
	Class.forName("com.mysql.cj.jdbc.Driver");
	//obtenemos la conexión
	connection = DriverManager.getConnection(url,login,password);
	if (connection!=null){
	System.out.println("Conexión a base de datos "+bd+" OK\n");
	}
	}
	catch(SQLException e){
	System.out.println(e);
	}catch(ClassNotFoundException e){
	System.out.println(e);
	}catch(Exception e){
	System.out.println(e);
	}
	}
	/**Permite retornar la conexión*/
	public Connection getConnection(){
	return connection;
	}
	public void desconectar(){
	connection = null;
	}
}

