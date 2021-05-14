<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div class="container">
	    <div class="row">
	        <div class="col-md-6">
	            <div class="card">
	                <form action="ControllerLogin" method="post" class="box">
	                    <h1>Parcial 2</h1>
	                    <p class="text-muted"> Ingresa tus credenciales para Acceder!</p> 
	                    <input type="text" required name="user" autocomplete="false" placeholder="Usuario"> 
	                    <input type="password" required name="pass" placeholder="Contrase&ntilde;a"> 
	                    <input type="submit" name="" value="Acceder">
	                </form>
	            </div>
	        </div>
	    </div>
	</div>
</body>
</html>