$(document).ready(function(){
	$(document).ready(function() {
  $('#limpiar').click(function() {
    $('input[type="text"]').val('');
  });
});
	$("#listarU").click(function(){	
		$.get("http://localhost:8080/listausuarios",function(data,status){
			if(status=="success"){
				let longitud=data.length;
				let salida="<table border='1'>";
				salida=salida+"<tr><th>Cedula</th><th>Email</th><th>Nombre</th><th>Password</th><th>Usuario</th></tr>";
				for(let i=0;i<longitud;i++){
					salida=salida+"<tr>";
					salida=salida+"<td>"+data[i].cedula+"</td>";
					salida=salida+"<td>"+data[i].email+"</td>";
					salida=salida+"<td>"+data[i].nombre+"</td>";
					salida=salida+"<td>"+data[i].clave+"</td>";
					salida=salida+"<td>"+data[i].usuario+"</td>";
					salida=salida+"</tr>";				
			}
			salida=salida+"</table>";
			$("#mensaje").html(salida);
		}	
	});
		
});
$("#buscarU").click(function(){
	let elid=$("#cedula").val();
	$.post("http://localhost:8080/buscarusuarioID",{cedula:elid},function(data,status){
	let longitud=data.length;
	if(longitud>0){
		
		$("#cedula").val(data[0].cedula);
		$("#email").val(data[0].email);
		$("#nombre").val(data[0].nombre);
		$("#clave").val(data[0].clave);
		$("#usuario").val(data[0].usuario);
		
	}else{
		$("#mensaje").html("<b style='color:red;'>USUARIO NO EXISTENTE!</b>")
		
	}
	});
	});
	
	$("#agregarU").click(function(){
		
		let elid=$("#cedula").val();
		let elemail=$("#email").val();
		let elnombre=$("#nombre").val();
		let laclave=$("#clave").val();
		let elusuario=$("#usuario").val();
		$.post("http://localhost:8080/crearusuario",{cedula:elid, email:elemail, nombre:elnombre,clave:laclave, usuario:elusuario},function(data,status){
	if(data==true){
		$("#mensaje").html("El Usuario Fue Creado con Exito")
	}else{
		$("#mensaje").html("<b style='color:red;'>Error Al crear Usuario!</b>")
		}
		
	});
	});
		
	$("#actualizarU").click(function(){
		
		let elid=$("#cedula").val();
		let elemail=$("#email").val();
		let elnombre=$("#nombre").val();
		let laclave=$("#clave").val();
		let elusuario=$("#usuario").val();
		$.post("http://localhost:8080/actualizarusuario",{cedula:elid, email:elemail, nombre:elnombre,clave:laclave, usuario:elusuario},function(data,status){
	if(data==true){
		$("#mensaje").html("El Usuario Fue Actualizado con Exito")
	}else{
		$("#mensaje").html("<b style='color:red;'>Error Al Actualizar Usuario!</b>")
		}
		
	});
	});
	
	$("#eliminarU").click(function(){
		let elid=$("#cedula").val();
		
		$.post("http://localhost:8080/borrarusuario",{cedula:elid},function(data,status){
	if(data==true){
		$("#mensaje").html("El Usuario Fue Eliminado con Exito")
	}else{
		$("#mensaje").html("<b style='color:red;'>Error Al crear Usuario!</b>")
		}
		
	});
	});


	
	
	
	
});
