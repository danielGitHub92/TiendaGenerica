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
<script src="Usuario.js"></script>
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
		    <li class="t-tab"><a  href="provedor.jsp" style="text-decoration:none; color:white;">Proveedores</a></li> 
		    <li class="t-tab"><a  href="producto.jsp" style="text-decoration:none; color:white;">Productos</a></li>
		    <li class="t-tab"><a href="reporte.jsp" style="text-decoration:none; color:white;">Reportes</a></li>
		    <br/> 
		    <br/> 
		    
		   
		  </ul>
		</div>
		   
		<center>

<div>
<center>
<form>
<h1>Registro Ventas</h1>
		<table >
		<tr>
				<td><label>Cedula:</label></td>
				<td><input Id="cedula" type="text" value=""></td>
			<td><input type="button" value="Consultar" id="buscarU"></td>
              <td><label>Cliente:</label></td>
              <td><input Id="cedula" type="text" value=""></td>
              <td><label>Consec.:</label></td>
				<td><input Id="cedula" type="text" value=""></td>
			</tr>
			
			<table>
			<tr>
				<td >Cod. Producto</td>
				<td></td>
				<td>Nombre Producto</td>
				<td>Cant. </td>
				<td>Vlr. Total</td>
				
				
		</tr>
		
		
			<tr>
			<td><input Id="cedula" type="text" value=""></td>
			<td><input type="button" value="Consultar" id="buscarU"></td>
				<td><input Id="cedula" type="text" value=""></td>
					<td><input Id="cedula" type="text" value=""></td>
					<td><input Id="cedula" type="text" value=""></td>
			
			</tr>
			<tr>
			<td><input Id="cedula" type="text" value=""></td>
			<td><input type="button" value="Consultar" id="buscarU"></td>
				<td><input Id="cedula" type="text" value=""></td>
				<td><input Id="cedula" type="text" value=""></td>
				<td><input Id="cedula" type="text" value=""></td>
			</tr>
			<tr>
			<td><input Id="cedula" type="text" value=""></td>
			<td><input type="button" value="Consultar" id="buscarU"></td>
			<td><input Id="cedula" type="text" value=""></td>
				<td><input Id="cedula" type="text" value=""></td>
				<td><input Id="cedula" type="text" value=""></td>
			</tr>
			<br/>
			<tr>
			<td></td>
			<td></td>
			<td></td>
			<td>Total Venta:</td>
			<td><input Id="cedula" type="text" value=""></td>
			</tr>
			<tr>
				<td></td>
				<td></td>
				<td></td>
				
				<td>Total IVA:</td>
				<td><input Id="cedula" type="text" value=""></td>
			</tr>
			<tr>
			<td></td>
			<td><input type="button" value="Confirmar" id="buscarU"></td>
			<td></td>
			<td>Total con IVA:</td>
			<td><input Id="cedula" type="text" value=""></td>
			</tr>
			
			</table>
			
		
		</table>
	</form>	
	<br/>
		<br/>
	</div>
	<div id="mensaje"></div>
	</center>


</body>
</html>