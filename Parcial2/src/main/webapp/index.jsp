<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<head>

<meta charset="ISO-8859-1">
<title>Parcial 2</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">

</head>
<%
//Retomando sesion
HttpSession sesion = (HttpSession) request.getSession();
String usuSesion= String.valueOf(sesion.getAttribute("usuario"));
System.out.print( "Nombre usuario: "+usuSesion+" ");

if(usuSesion.equals(null)||usuSesion.equals("null")){
	%>
	<input type="hidden" name="usuario" id="usu" value="0">
	<%
}else{
	%>
	<input type="hidden" name="usuario" id="usu" value="<% out.print(usuSesion); %>">
	<%
}
%>
<body>
	<div class="container ">
		<div class="row margen">
			<div class="col-md-12">
				<div class="card">
			  		<div class="card-body">
			  			<div class="centrar">
			  			<form action="ControllerConsulta" method="post">
		  					<input type="submit" name="btncerrar" value="Cerrar Sesión" class="btn btn-info">
		  				</form>
			  			<h1></h1>
			  			<a class="btn btn-info" href="login.jsp">Iniciar Sesión</a>
			  			
			  				<script type="text/javascript">
			  					$(document).ready(function (){
		  							$.post('ControllerConsulta',{
		  								//Esta seccion es para enviar peticiones al servidor
		  								
		  							}, function (response){
		  								//Esta seccion es para recibir informacion
		  								let datos = JSON.parse(response);
		  								console.log(datos);
		  								//HACIENDO LA UNION DE CODIGO PARA MOSTRAR LOS DATOS
		  								var tabla = document.getElementById('tablaDatos');
		  								for(let item of datos){
		  									tabla.innerHTML += `
		  										<tr>
		  											<td> ${item.Apellido} </td>
		  											<td> ${item.Nombre} </td>
		  											<td id="idU"> ${item.Id} </td>
		  											<td> <a class="btn btn-warning"<% if(usuSesion.equals(null)||usuSesion.equals("null")){%> onclick="sms();" <%}else{%>href="ControllerConsulta?Id=${item.Id}&Eliminar=btne"<%}%>>Eliminar </a></td>
		  											</tr>
		  									`
		  									console.log(item.Pass);
		  								}
		  							});
		  						});
			  					function sms() {
									alert('Debe iniciar Sesión');
								}
			  				</script>
			  				
			  				
			  				<table id="tablaDatos" class="table table-dark table-striped">
			  					<thead>
			  						<tr>
			  							<th>Apellido</th>
			  							<th>Nombre</th>
			  							<th>Id</th>
			  							<th>Acciones</th>
			  						</tr>
			  					</thead>
			  					<tbody>
			  						
			  					</tbody>
			  				</table>
			  			</div>
			  		</div>
	  			</div>
			</div>
		</div>
	</div>
</body>
</html>