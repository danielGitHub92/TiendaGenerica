<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tienda Informatica</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="provedor.js"></script>
</head>
<body>
<center>
<h1>Registro Proveedores</h1>

<div style="border:1px solid black; width:50%">
	<form>
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
	<div id="mensaje"></div>
	</center>

</body>
</html>