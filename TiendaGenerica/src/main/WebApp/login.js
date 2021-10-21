
$(document).ready(function(){
 $("#btn_Enviaru").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
 let elUsuario = document.getElementById("name").value;//cada control de la pagina tiene un Id
 let laClave = document.getElementById("password").value; //esta varialbe contine el valor del campo cedula
$.post("http://localhost:8080/loginusuario2",{ usuario: elUsuario, clave: laClave },

function(data, status){// data1 = $.parseJSON( data );

if(data.existe==true)
{
alert("Bienvenido "+elUsuario);
window.location.href ="cliente.jsp";
}
else
{
alert("No existe el Usuario");
 $('input[type="text"]').val('');
$('input[type="password"]').val('');
}
 });
 });
 function mostrarUno(item, index) {
 let valores = Object.values(item);

$("#usuario").val(valores[0]);
$("#clave").val(valores[1]);
}

$("#btn_Registraru").click(function(){//El evento callback no tiene cuerpo solo se ejecuta en el momento
 let elcedula = document.getElementById("cedula").value;//cada control de la pagina tiene un Id
let elemail = document.getElementById("email").value; //esta varialbe contine el valor del campo cedula
 let elnombre = document.getElementById("nombre").value;//cada control de la pagina tiene un Id
let laClave = document.getElementById("clave").value; //esta varialbe contine el valor del campo cedula
 let elUsuario = document.getElementById("usuario").value;//cada control de la pagina tiene un Id

$.post("http://localhost:8080/loginusuario2",{cedula:elcedula, email:elemail,nombre:elnombre , clave: laClave, usuario: elUsuario },

function(data, status){// data1 = $.parseJSON( data );

if(data.existe==true)
{
alert("Registro con Cedula "+elcedula+" Guardado Con Exito");

window.location.href ="cliente.jsp";
}
else
{
alert("No existe el Usuario");
}
 });
 });
 function mostrarUno(item, index) {
 let valores = Object.values(item);

$("#cedula").val(valores[0]);
$("#email").val(valores[1]);
$("#nombre").val(valores[2]);
$("#clave").val(valores[3]);
$("#usuario").val(valores[4]);

}


});

// document.querySelectorAll( 'input' )[0].focus();