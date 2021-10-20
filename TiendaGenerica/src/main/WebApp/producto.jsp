<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Producto</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

</head>
<body>
<form method="POST" action="./cargarArchivo" enctype="multipart/form-data">
 	<label>Seleccione el archivo .csv </label><input type="file" name="archivoCSV" accept=".csv">
 	<input type="submit" value="Enviar">
 </form>

</body>
</html>