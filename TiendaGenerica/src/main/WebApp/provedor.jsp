<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Gaming </title>
<link rel="shortcut icon" href="https://w7.pngwing.com/pngs/266/950/png-transparent-information-technology-computer-icons-avid-cpu-angle-electronics-text.png">
<link rel="stylesheet" href="styleForm.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="provedor.js"></script>
</head>
<body>
<center>
<header>Tienda Gaming</header>
 <br/> 
		    <br/> 

</center>

		<div class="t-container">
		  <ul class="t-tabs">  

		    <li class="t-tab"><a href="cliente.jsp" style="text-decoration:none; color:white;" >Usuarios</a></li> 
		    <li class="t-tab"><a href="Usuario.jsp" style="text-decoration:none; color:white;">Clientes</a></li>   
		    <li class="t-tab"><a  href="producto.jsp" style="text-decoration:none; color:white;">Productos</a></li>
		    <li class="t-tab"><a  href="ventas.jsp" style="text-decoration:none; color:white;">Ventas</a></li>
		    <li class="t-tab"><a href="reporte.jsp" style="text-decoration:none; color:white;">Reportes</a></li>
		    <br/>
		    <br/> 
		    
		   
		  </ul>
		</div>
		   
		<center>

<div>
<form >
<center>
<h1>Registro Proveedores</h1>
		<table >
			<tr>
				<td><label>Nit:</label></td>
				<td><input Id="cedula" type="text" value=""></td>
			<td><input type="button" value="Consultar" id="buscarU"></td>
              
			</tr>
			<tr>
				<td><label>Ciudad:</label></td>
				<td><input Id="email" type="text" value=""></td>
				<td><input type="button" value="Limpiar" id="limpiar"></td>
			</tr>
			<tr>
				<td><label>Direccion:</label></td>
				<td><input Id="nombre" type="text" value=""></td>
			</tr>
			<tr>
				<td><label>Nombre:</label></td>
				<td><input Id="clave" type="text" value=""></td>
			</tr>
			<tr>
				<td><label>Telefono:</label></td>
				<td><input Id="usuario" type="text" value=""></td>
			</tr>
			<tr>
			  <td><input type="button" value="Agregar" id="agregarU"></td>
                <td><input type="button" value="Eliminar" id="eliminarU"></td>
                <td><input type="button" value="Actualizar" id="actualizarU"></td>
                <td><input type="button" value="Listar" id="listarU"></td>
            </tr>
		
		</table>
	</form>	
	</div>
	<br/>
		<br/>
	<div id="mensaje"></div>
	</center>

</body>
</html>