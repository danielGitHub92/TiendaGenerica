$(document).ready(function(){
	$(document).ready(function() {
  $('#limpiar').click(function() {
    $('input[type="text"]').val('');
  });
});
	$("#lucas").click(function(){	
		$.get("http://localhost:8080/CAPODAO",function(data,status){
			if(status=="success"){
				let longitud=data.length;
				let salida="<h1>Listado de Usuarios</h1>";
				salida=salida+"<table border='1'>";
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

$("#LC").click(function(){	
		$.get("http://localhost:8080/CAPADEO",function(data,status){
			if(status=="success"){
				let longitud=data.length;
				let salida="<h1>Listado de Clientes</h1>";
				salida= salida+"<table border='1'>";
				salida=salida+"<tr><th>Cedula</th><th>Direccion</th><th>Email</th><th>Nombre</th><th>Telefono</th></tr>";
				for(let i=0;i<longitud;i++){
					salida=salida+"<tr>";
					salida=salida+"<td>"+data[i].cedula+"</td>";
					salida=salida+"<td>"+data[i].direccion+"</td>";
					salida=salida+"<td>"+data[i].email+"</td>";
					salida=salida+"<td>"+data[i].nombre+"</td>";
					salida=salida+"<td>"+data[i].telefono+"</td>";
					salida=salida+"</tr>";				
			}
			salida=salida+"</table>";
			$("#mensaje").html(salida);
		}	
	});
		
});

$("#VC").click(function(){	
		$.get("http://localhost:8080/CAPODIO",function(data,status){
			if(status=="success"){
				let longitud=data.length;
				let salida="<h1>Total Ventas por Cliente</h1>";
				salida=salida+"<table border='1'>";
				salida=salida+"<tr><th>Cedula</th><th>Nombre</th><th>ValorTotalVentas</th></tr>";
				for(let i=0;i<longitud;i++){
					salida=salida+"<tr>";
					salida=salida+"<td>"+data[i].cedula+"</td>";
					salida=salida+"<td>"+data[i].nombre+"</td>";
					salida=salida+"<td>"+data[i].valor+"</td>";
					salida=salida+"</tr>";
					
								
			}
			salida=salida+"</table>";
			salida=salida+"<table>";
			salida=salida+"<tr>";
			salida=salida+"<td>Total Venta $</td>";
			salida=salida+"<td>"+data[i].nombre+"</td>";
	
			salida=salida+"</tr>";
			
			$("#mensaje").html(salida);
		}	
	});
		
});
	
	
	
	
});
