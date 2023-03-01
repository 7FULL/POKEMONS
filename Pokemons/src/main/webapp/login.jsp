<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" type="text/css" href="sty/formulariosderegistro.css">
    <link rel="shortcut icon" href="img/favicon.ico">
</head>
<body>
<div class="container">
    <a href="index.jsp"><img src="img/home.png" alt="alt" class="casa"/></a>
         <h1>Iniciar Sesion</h1>
         	<div class="form-box" id="forms">
         		<div class="formmov">
                            
                            
                            <!-- Usar enctype= multipart/form-data si se sube un archivo-->
                            
                            
         		<form action="LoginServlet" method="post" class="input-group">
                            <h2>Admin</h2>
					<input type="text" name="usuario" placeholder="Usuario" class="input-field" required>
					<input type="text" name="contr" placeholder="Contraseña" class="input-field" required>
                                        <div class="bajar"><input type="submit" value="Submir" class="submit-btn"></div>
				</form>
         		</div>
         	</div>         	
         </div>
</body>
</html>
