<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%--

<%@page import="java.sql.*" %>
                		<%@ page import="BBDD.BDDConnector" %>
                		<%String query ="SELECT * FROM `tipo`";
                  		ResultSet rs = BDDConnector.recibirQuery(query);
                  		while (rs.next()){
                      		out.println("<option value="+rs.getString("nombre")+">"+rs.getString("nombre")+"</option>");
                  		}
                		%>

<%@page import="java.sql.*" %>

<%
 
    if(request.getParameter("submit")!=null)
    {
        String usuario = request.getParameter("Usuario");
        String contraseña = request.getParameter("con");
        
        Connection con;
        ResultSet rs = null;
        
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost/pruebas","pi","678041577");
        
        String query = "SELECT * FROM `admins` WHERE `usuario` LIKE '"+usuario+"'";
        Statement st = con.createStatement();
                
            rs =  st.executeQuery(query);
            
        while(rs.next()){
            if(!rs.getString("contraseña").equals(contraseña)){
                //out.println("<script>alert('Denegado')</script>");
                
            }else{
                //out.println("<script>alert('Aceptado')</script>");
                
            }
        } 
       
    }
   %>
BDDConnector.cerrarConexion(rs.getStatement(),rs.getStatement().getConnection());
   --%>
   
   
<!DOCTYPE html>
<html lang="es">
    <head>
        <title>Pokemons</title>
        <link rel="shortcut icon" href="img/favicon.ico">
    </head>
    <body>    
        <link rel="stylesheet" type="text/css" href="sty/formulariosderegistro.css">
        <script src="js/jsontipo.js"></script>
         <div class="container">
             <a href="index.jsp"><img src="img/home.png" alt="alt" class="casa"/></a>
         <h1>Nuevos Registros</h1>
         	<div class="form-box" id="forms">
         		<div class="button-box">
         			<div id="elegir"></div>
         			<button type="button" class="toggle-btn">Pokemon</button>
         			<button type="button" class="toggle-btn">Tipo</button>
         		</div>
         		<form action="registerpokemon" method="post" id="pokemon" class="input-group" enctype="multipart/form-data">

            		<input type="text" name="nombre" placeholder="Nombre" class="input-field" required>

            		<input type="number" min="1" step="1" name="defensa" placeholder="Defensa" class="input-field" required>

            		<input type="number" min="1" step="1" name="ataque" placeholder="Ataque" class="input-field" required>

            		<input type="number" min="1" step="1" name="velocidad" placeholder="Velocidad" class="input-field" required>

            		<input type="number" min="1" step="1" name="vida" placeholder="Vida" class="input-field" required>
                        
                        <div class="fotos">Foto de frente<input type="file" name="fotof" required></div>
                        
                        <div class="fotos">Foto de espaldas<input type="file" name="fotod" required></div>

            		<label for="tipo">Tipo:</label>
            		<select name="tipo" id="tipo" class="dropdown">
                		
            		</select>
                        <% 
                            if(session.getAttribute("admin") != null)
                            {
                                if((Boolean)session.getAttribute("admin"))
                                {
                                    out.println("<input type='submit' value='Submit' class='submit-btn'>");
                                }
                            }else{
                                out.println("<p>NO TIENES PERMISOS</p>");
                            }
                        %>                     
        	</form>
        	<form action="registertype" method="post" id="tipos" class="input-group">
        		<input type="text" name="nombre" class="input-field" placeholder="Tipo" required>
        		<% 
                            if(session.getAttribute("admin") != null)
                            {
                                if((Boolean)session.getAttribute("admin"))
                                {
                                    out.println("<input type='submit' value='Submit' class='submit-btn'>");
                                }
                            }else{
                                out.println("<p>NO TIENES PERMISOS</p>");
                            }
                        %> 
        	</form>  
         	</div>         	
         </div>
         <script src="js/formulario.js"></script>
    </body>
</html>
