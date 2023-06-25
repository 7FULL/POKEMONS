
    let x = document.getElementById("seleccion");
    
    let chat = document.getElementsByClassName("chat")[0];
    
    let nombre1;
    let nombre2;
    
    let foto1 = document.getElementById("pokemon1");
    let foto2 = document.getElementById("pokemon2");
    
    let pokemon1 = document.getElementById("pokemonb1");
    let pokemon2 = document.getElementById("pokemonb2");
    
    let imagenesFrontales = [];
    
    let imagenesEspalda = [];
    
    let nombres = [];
    
    let ataque1 = document.getElementById("ataque1");
    let ataque2 = document.getElementById("ataque2");
    
    let defensa1 = document.getElementById("defensa1");
    let defensa2 = document.getElementById("defensa2");
    
    let especial1 = document.getElementById("especial1");
    let especial2 = document.getElementById("especial2");
    
    let imagen1 = document.getElementById("loader1");
    let nombret1 = document.getElementById("nombret1");
    let vida1 = document.getElementById("vida1");
    let ataquet1 = document.getElementById("ataquet1");
    let defensat1 = document.getElementById("defensat1");
    let velocidad1 = document.getElementById("velocidad1");
    let mensaje1 = document.getElementById("mensaje1");
    
    let imagen2 = document.getElementById("loader2");
    let nombret2 = document.getElementById("nombret2");
    let vida2 = document.getElementById("vida2");
    let ataquet2 = document.getElementById("ataquet2");
    let defensat2 = document.getElementById("defensat2");
    let velocidad2 = document.getElementById("velocidad2");
    let mensaje2 = document.getElementById("mensaje2");
    
    let terminarPartida = document.getElementById("terminar");
    
    let audioBatalla = document.getElementById("comenzarBatalla");
    
    let especialbool1 = true;
    let especialbool2 = true;
    
    let tuTurno = true;
    
    let esquivar1 = false;
    let esquivar2 = false;
    
    let terminado = false;
    
        let lobbieId = 0;
        
        let personas = 0;
    
    //var socket = new WebSocket("ws://192.168.43.110:8080/ProyectoPokemon/websocket");
    
    //var socket1 = new WebSocket("ws://192.168.1.22:8080/ProyectoPokemon/websocket");
    
    var socket  = new WebSocket("ws://192.168.1.22:8080/ProyectoPokemon/websocket" + lobbieId);
    
    let segundoJugador = false;
    
    let chatInput = document.getElementById("inputMessage");
    
    let cambio = false;
    
    let lobbieIdJson = {
            			lobbieId: lobbieId,
        			};
    
    socket.onopen = function(){
	socket.send("persona");
};

console.log("Hello");
    
    chatInput.addEventListener("keyup", function(event){
	if(event.key === "Enter"){
		socket.send(chatInput.value);
		chatInput.value = "";
	}
})
    
    terminarPartida.addEventListener("click",function(){
		socket.send("terminar");
    });
    
    function actualizar(x){
		console.log("ACTUALIZANDOOOOOOOOOOOOOOOO");
	
        nombret1.innerText = x[0].nombre;
        vida1.innerText = "Vida: "+x[0].vida.toFixed(2);
        ataquet1.innerText = "Ataque: "+x[0].ataque;
        defensat1.innerText = "Defensa: "+x[0].defensa;
        velocidad1.innerText = "Velocidad: "+x[0].velocidad;
        
        nombret2.innerText = x[1].nombre;
        vida2.innerText = "Vida: "+x[1].vida.toFixed(2);
        ataquet2.innerText = "Ataque: "+x[1].ataque;
        defensat2.innerText = "Defensa: "+x[1].defensa;
        velocidad2.innerText = "Velocidad: "+x[1].velocidad;
        
        if(x[0].mensaje != null){
            mensaje1.innerText = x[0].mensaje;
        }
        
        if(x[1].mensaje != null){
            mensaje2.innerText = x[1].mensaje;
        }
        
        if(x[0].mensaje == "VICTORIA" || x[1].mensaje == "VICTORIA"){
            terminado = true;
            console.log("Terminado");
            if(x[0].mensaje == "VICTORIA"){
                vida2.innerText = "Vida: 0.00";
            }else if (x[1].mensaje == "VICTORIA"){
                vida1.innerText = "Vida: 0.00";
            }
            fetch('BorrarUsuarios', {
            			method: "POST",
        			})
       .catch(err => console.log(err));
            setTimeout(function(){
                mensaje1.innerText = "";
                mensaje2.innerText = "";
                location.reload();
            },5000);
        }else{
            setTimeout(function(){
            mensaje1.innerText = "";
            mensaje2.innerText = "";
            },2000);
        }
    }
    
    function animaciondano2(){
        
        setTimeout(function(){
                pokemon2.style.marginLeft = "873px";
                pokemon2.style.marginTop = "165px";
            },10);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "870px";
                pokemon2.style.marginTop = "167px";
            },20);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "868px";
                pokemon2.style.marginTop = "170px";
            },30);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "865px";
                pokemon2.style.marginTop = "173px";
            },40);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "863px";
                pokemon2.style.marginTop = "175px";
            },50);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "860px";
                pokemon2.style.marginTop = "178px";
            },60);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "857px";
                pokemon2.style.marginTop = "180px";
            },70);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "855px";
                pokemon2.style.marginTop = "182px";
            },80);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "853px";
                pokemon2.style.marginTop = "185px";
            },90);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "850px";
                pokemon2.style.marginTop = "188px";
            },100);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "847px";
                pokemon2.style.marginTop = "190px";
            },110);
            
            /*-------------------------------------*/
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "850px";
                pokemon2.style.marginTop = "188px";
            },120);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "853px";
                pokemon2.style.marginTop = "185px";
            },130);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "855px";
                pokemon2.style.marginTop = "182px";
            },140);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "857px";
                pokemon2.style.marginTop = "180px";
            },150);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "860px";
                pokemon2.style.marginTop = "178px";
            },160);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "863px";
                pokemon2.style.marginTop = "175px";
            },170);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "865px";
                pokemon2.style.marginTop = "173px";
            },180);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "868px";
                pokemon2.style.marginTop = "170px";
            },190);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "870px";
                pokemon2.style.marginTop = "167px";
            },200);
            
            setTimeout(function(){
                pokemon2.style.marginLeft = "873px";
                pokemon2.style.marginTop = "165px";
            },210);
    }
    
    function animaciondano1(){
         setTimeout(function(){
                pokemon1.style.marginLeft = "520px";
                pokemon1.style.marginTop = "275px";
            },10);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "523px";
                pokemon1.style.marginTop = "272px";
            },20);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "525px";
                pokemon1.style.marginTop = "270px";
            },30);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "527px";
                pokemon1.style.marginTop = "267px";
            },40);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "530px";
                pokemon1.style.marginTop = "265px";
            },50);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "532px";
                pokemon1.style.marginTop = "262px";
            },60);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "535px";
                pokemon1.style.marginTop = "260px";
            },70);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "538px";
                pokemon1.style.marginTop = "257px";
            },80);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "540px";
                pokemon1.style.marginTop = "255px";
            },90);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "542px";
                pokemon1.style.marginTop = "252px";
            },100);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "545px";
                pokemon1.style.marginTop = "250px";
            },110);
                   
            /*--------------------------------------*/
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "545px";
                pokemon1.style.marginTop = "250px";
            },120);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "542px";
                pokemon1.style.marginTop = "252px";
            },130);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "540px";
                pokemon1.style.marginTop = "255px";
            },140);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "537px";
                pokemon1.style.marginTop = "257px";
            },150);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "535px";
                pokemon1.style.marginTop = "260px";
            },160);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "532px";
                pokemon1.style.marginTop = "262px";
            },170);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "530px";
                pokemon1.style.marginTop = "265px";
            },180);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "528px";
                pokemon1.style.marginTop = "267px";
            },190);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "525px";
                pokemon1.style.marginTop = "270px";
            },200);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "522px";
                pokemon1.style.marginTop = "272px";
            },210);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "520px";
                pokemon1.style.marginTop = "275px";
            },220);
    }
    
    ataque1.addEventListener("click",function(){
        if(tuTurno && !terminado){
            accion("atacar1");
            socket.send("atacar1");
        }
    });
    
    ataque2.addEventListener("click",ataque2f);
    
    function ataque2f(){
        if(!tuTurno&& !terminado){
            accion("atacar2");
            socket.send("atacar2");
        }
    }
    
    defensa1.addEventListener("click",function(){
        if(tuTurno&& !terminado){
            socket.send("defensa1");
        }
    });
    
    defensa2.addEventListener("click",defensa2f);
    
    function defensa2f(){
        if(!tuTurno&& !terminado){
            socket.send("defensa2");
        }
    }
    
    especial1.addEventListener("click",function(){
        if(tuTurno && especialbool1&& !terminado){

            accion("especial1");
			socket.send("especial1");
        }
    });
    
    especial2.addEventListener("click",especial2f);
    
    function especial2f(){
        if(!tuTurno&& especialbool2&& !terminado){
            
            accion("especial2");
            socket.send("especial2");
        }
    }
    
    function recibirDano(x){
        if(x == 1){
            
            animaciondano2();
            
            /*--------------------------------------*/
            
            setTimeout(function(){
                pokemon1.style.visibility = "visible";
            },100);
            setTimeout(function(){
                pokemon1.style.visibility = "hidden";
            },300);
            setTimeout(function(){
                pokemon1.style.visibility = "visible";
            },500);
            setTimeout(function(){
                pokemon1.style.visibility = "hidden";
            },700);
            setTimeout(function(){
                pokemon1.style.visibility = "visible";
            },900);
            setTimeout(function(){
                pokemon1.style.visibility = "hidden";
            },1100);
            setTimeout(function(){
                pokemon1.style.visibility = "visible";
            },1300);
        }else{
            
            animaciondano1();
            
            /*------------------------------------*/
            
            setTimeout(function(){
                pokemon2.style.visibility = "visible";
            },100);
            setTimeout(function(){
                pokemon2.style.visibility = "hidden";
            },300);
            setTimeout(function(){
                pokemon2.style.visibility = "visible";
            },500);
            setTimeout(function(){
                pokemon2.style.visibility = "hidden";
            },700);
            setTimeout(function(){
                pokemon2.style.visibility = "visible";
            },900);
            setTimeout(function(){
                pokemon2.style.visibility = "hidden";
            },1100);
            setTimeout(function(){
                pokemon2.style.visibility = "visible";
            },1300);
        }
    }
    
    function cambiar(){
        if(tuTurno){
            imagen2.style.visibility = "visible";
            imagen1.style.visibility = "hidden";
            tuTurno = false;
        }else{
            imagen1.style.visibility = "visible";
            imagen2.style.visibility = "hidden";
            tuTurno = true;
        }
    }
    
    function accion(x){
        if(x == "atacar1" && esquivar2){
            x = "esquivar1";
        }
        
        if(x == "atacar2" && esquivar1){
            x = "esquivar2";
        }
        
            let accion = {
            accion: x,
            lobbieId: lobbieId,
        };

        fetch('AtaqueServlet', {
            method: "POST",
            body: JSON.stringify(accion),
            headers: {"Content-type": "application/json; charset=UTF-8"}
        })
        .then(response => response.json()) 
        .then(datos => {
			console.log("Datos pokemons");
            console.log(datos);
            
            let datosJSON = JSON.stringify(datos);
    
            socket.send(datosJSON);
        })
        .catch(err => console.log(err));

        esquivar1 = false;
        esquivar2 = false;
    }
    /*
    fetch("RecibirPokemonsServlet",{
        method: "POST"
    })
            .then(response=>response.json())
            .then(datos=>{
				console.log(datos);
                for(let i = 0;i<datos.length;i++){
                    x.innerHTML = x.innerHTML + "<option value="+datos[i]+">"+datos[i]+"</option>";
                    nombres.push(datos[i]);
                }
    })
            .catch(error=>console.error("Se ha producido un error a la hora de procesar el JSON de nombres de pokemons: "+error));
    
    fetch("RecibirImagenesFrontales",{
        method: "POST"
    })
            .then(response=>response.json())
            .then(datos=>{
                for(let i = 0;i<datos.length;i++){
                    imagenesFrontales.push(datos[i]);
                }
                let url = "img/pokemons/"+imagenesFrontales[0];
        
                foto1.src = url;
    })
            .catch(error=>console.error("Se ha producido un error a la hora de procesar el JSON de imagenes frontales: "+error));
    
    fetch("RecibirImagenesEspalda",{
        method: "POST"
    })
            .then(response=>response.json())
            .then(datos=>{
                for(let i = 0;i<datos.length;i++){
                    imagenesEspalda.push(datos[i]);
                }
    })

            .catch(error=>console.error("Se ha producido un error a la hora de procesar el JSON de imagenes de espaldas: "+error));
    x.addEventListener("change",function(){
        let url = "img/pokemons/"+imagenesFrontales[x.selectedIndex];
        
       	foto1.src = url;
    });
    
    let batalla = document.getElementById("batalla");
    
    batalla.addEventListener("click", function(){
					batalla.value = "Esperando"
	
	        		let nombres = {
            			nombre1: x.value,
        			};
	
	  fetch('RegistrarUsuario', {
            			method: "POST",
            			body: JSON.stringify(nombres),
            			headers: {"Content-type": "application/json; charset=UTF-8"}
        			})
       .then(datos => datos.text())
       .then(datos => {
	
	let datosResult = datos.slice(0,datos.length -1);
	
	lobbieId = datos.charAt(datos.length - 1);
	
	//socket.close();
	
		console.log(datos);
		
            			if(datosResult === "true"){
							segundoJugador = true;
							console.log("Bien");
							
							socket.send("cambio");
					}
        			})
       .catch(err => console.log(err));   
    		});
    		
	/*socket.onopen = function(){
		socket.send("cambio");
		console.log("socket abierto");
	};*/
    		
			socket.onmessage = function(event) {
				console.log("WebSocket Recibido");
				console.log(event.data);
  			if (event.data == "cambio") {
    			Cambio();
  			}else if(event.data == "atacar1"){
				
            	cambiar();
            	recibirDano(2);
			}else if(event.data == "persona"){
				console.log("persona");
				
            	personas++;
            	
            	if(personas == 2){
						socket.send("cambio");
				}
			}
			else if(event.data == "atacar2"){
				
            	cambiar();
            	recibirDano(1);
			}else if(event.data == "defensa1"){
				esquivar1 =true;
            	mensaje1.innerText = nombre1 + " se prepara para esquivar";
            	setTimeout(function(){
                	mensaje1.innerText = "";
            	},2000);
            	cambiar();
			}else if(event.data == "defensa2"){
				esquivar2 =true;
           		mensaje2.innerText = nombre2 + " se prepara para esquivar";
            	setTimeout(function(){
                	mensaje2.innerText = "";
            	},2000);
            	cambiar();
			}else if(event.data == "especial1"){
				especial1.style.backgroundColor = "gray";
            	
            	especialbool1 = false;
            	cambiar();
            	recibirDano(2);
			}else if(event.data == "especial2"){
				especial2.style.backgroundColor = "gray";
            	especialbool2 = false;
            	cambiar();
            	recibirDano(1);
            }else if(event.data == "terminar"){
				fetch('BorrarUsuarios', {
            			method: "POST",
            			body: JSON.stringify(lobbieIdJson),
            			headers: {"Content-type": "application/json; charset=UTF-8"}
        			})
       			.catch(err => console.log(err));
        		location.reload();
			}else{
				try{
					let dataJSON = JSON.parse(event.data);
					console.log(dataJSON);
				
					actualizar(dataJSON);
				}catch(error){
					chat.innerHTML += "<p>"+event.data+"</p>";
				}
			}
			};
			
			socket.onerror = function(event) {
				console.log("Error ",event);
			};

			function Cambio() {
					chat.style.visibility = "hidden";
					
					chatInput.style.visibility = "hidden";
				
 					document.getElementById("azul").className = "azulanim";
        
        			document.getElementById("cian").className = "ciananim";
        			
        			document.getElementById("cian").visibility = "visible";
        
        			x.style.visibility = "hidden";
        	
        			batalla.style.visibility = "hidden";
        
        			document.getElementById("pokeball").style.visibility = "hidden";
        			
        			fetch('BatallaMultijugadorServlet', {
            			method: "POST",
            			body: JSON.stringify(lobbieIdJson),
            			headers: {"Content-type": "application/json; charset=UTF-8"}
        			})
        			.then(response => response.json()) 
        			.then(datos => {
            			console.log(datos);
    
            			actualizar(datos);
            			
            		nombre2 = datos[1].nombre;
            		nombre1 = datos[0].nombre;
            		
            		let index1;
            		
            		let index2;
            		
            		console.log(nombres);
            		console.log(nombre2);
            		console.log(nombre1);
            		
            		for(let i = 0;i<nombres.length;i++){
                    	if(nombres[i] == nombre2){
							index2 = i;
						}
						if(nombres[i] == nombre1){
							index1= i;
						}
                	}
            			
            	    pokemon1.src = "img/pokemons/"+imagenesEspalda[index1];
        
        			pokemon2.src = "img/pokemons/"+imagenesFrontales[index2];
        			
        			
        
        				foto1.src = "img/pokemons/"+imagenesFrontales[index1];
        				
        				foto2.src = "img/pokemons/"+imagenesFrontales[index2];
					
        			})
        			.catch(err => console.log(err));
        
        			if(segundoJugador){
						ataque1.style.visibility ="hidden";
						defensa1.style.visibility ="hidden";
						especial1.style.visibility ="hidden";
					}else{
						ataque2.style.visibility ="hidden";
						defensa2.style.visibility ="hidden";
						especial2.style.visibility ="hidden";
					}
        
        			setTimeout(function(){
            			document.getElementById("batallaestadio").style.visibility = "visible";
        
        			audioBatalla.play();
        
        			foto1.style.visibility = "hidden";
        			foto2.style.visibility = "hidden";
        			},4010);
			}
