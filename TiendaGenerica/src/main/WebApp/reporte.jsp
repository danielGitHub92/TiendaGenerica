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
<script src="reporte.js"></script>
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
		    <li class="t-tab"><a  href="ventas.jsp" style="text-decoration:none; color:white;">Ventas</a></li>
		    <br/> 
		    <br/> 
		    
		   
		  </ul>
		</div>
		   
		<center>

<div>
<center>
<form>
		<table >
			<tr>
			  <td><input type="button" value="Lstado de Usuarios" id="lucas"></td>
                
            </tr>
            
            <tr>
             <td><input type="button" value="Listado de Clientes" id="LC"></td>
            </tr>
            <tr>
            <td><input type="button" value="Ventas por Cliente" id="VC"></td>
            </tr>
		
		</table>
	</form>	
	<br/>
		<br/>
		
	</div>
	<div id="mensaje"></div>

</body>
</html>