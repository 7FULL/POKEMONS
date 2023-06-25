<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title class="titulo">Pokemon</title>
    <link rel="shortcut icon" href="img/favicon.ico">
    </head>
    <body> 
        <audio id="comenzarBatalla" controls loop>
            <source src="clips/pokemon-battle.mp3" type="audio/mpeg">
        </audio>
        <link rel="stylesheet" href="sty/estilopoke.css">
        <script src="js/jsonpokemonmultijugador.js"></script>
        <header class="header">
         <a href="index.jsp"><img class= "logo" src="img/International_Pokemon_logo.svg.png"></a>
         <div class="botones">
         <a href='index.jsp'><button class='mi-boton'>Singleplayer</button></a>
         <button class="mi-boton" id="imagen-seleccionada">Estadio</button>
         <% 
        if(session.getAttribute("admin") != null)
        {
            if((Boolean)session.getAttribute("admin")){
                out.println("<a href='registration.jsp'><button class='mi-boton'>Registro</button></a>");
            }
        }else{
            out.println("<a href='login.jsp'><button class='mi-boton'>Login</button></a>");
         }
       %>
          </div>
        
    </header>
     <div class="container">
         <div id="contenedor-imagenes">
            <div id="batallaestadio">
                <div id="divpokemon1">
                    <img src="" id="pokemonb1" class="pokemonb1">
                    <div class="stats1">
                        <div class="loader1" id="loader1">
                            <img class="logo1" src="img/descarga-removebg-preview.png" alt=""/>
                        </div>
                        <p id="nombret1"></p>
                        <p id="vida1"></p>
                        <p id="defensat1"></p>
                        <p id="ataquet1"></p>
                        <p id="velocidad1"></p>
                    </div>
                    <p id="mensaje1"></p>
                    <input type="button" id="ataque1" value="ATAQUE">
                    <input type="button" id="defensa1" value="ESQUIVAR">
                    <input type="button" id="especial1" value="ESPECIAL">
                </div>
                <div id="divpokemon2">
                    <img src="" id="pokemonb2" class="pokemonb2">
                    <div class="stats2">
                        <div class="loader2" id="loader2">
                            <img class="logo2" src="img/descarga-removebg-preview.png" alt=""/>
                        </div>
                        <p id="nombret2"></p>
                        <p id="vida2"></p>
                        <p id="defensat2"></p>
                        <p id="ataquet2"></p>
                        <p id="velocidad2"></p>
                    </div>
                    <p id="mensaje2"></p>
                    <input type="button" id="ataque2" value="ATAQUE">
                    <input type="button" id="defensa2" value="ESQUIVAR">
                    <input type="button" id="especial2" value="ESPECIAL">
                </div>
                <input type="button" id="terminar" value="TERMINAR PARTIDA">
                <!--  <input type="button" id="IA" value="JUGAR CONTRA IA"> -->
                <img src="img/estadios/estadio1.jpg" id ="imagengorda">
            </div>
          </div>
     <section class="section">
       <select name="seleccionpokemon" id="seleccion">
         </select>  
     <div class="azul" id="azul">
         
         <img src="" alt="" id="pokemon1"/>
         </div>
         
        
         <input type="button" id="batalla" value="COMENZAR">

         <div class="loader" id="pokeball">
                <img class="logo" src="img/descarga-removebg-preview.png" alt=""/>
            </div>
         
         <select name="seleccionpokemon" id="seleccionm1">
         </select>
     <div class="cianm" id="cian">
         
         <img src="" alt="" id="pokemon2"/>
         </div> 
         <div class="chat">        
         </div>
         
         <div class="inputMessage"><input type="text" id="inputMessage"></div> 
     
     
     </section>
         
</div>
     <footer class="footer">
      <img class= "pika" src="img/pokebarra-removebg-preview.png">
     </footer>
          <script src="js/Batalla.js"></script>
          <script src="js/estadios.js"></script>
    </body>
</html>