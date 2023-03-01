window.onload = function(){
    let x = document.getElementById("seleccion");
    let y = document.getElementById("seleccion1");
    
    let nombre1;
    let nombre2;
    
    let foto1 = document.getElementById("pokemon1");
    let foto2 = document.getElementById("pokemon2");
    
    let pokemon1 = document.getElementById("pokemonb1");
    let pokemon2 = document.getElementById("pokemonb2");
    
    let imagenesFrontales = [];
    
    let imagenesEspalda = [];
    
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
    
    let IA = document.getElementById("IA");
    
    let audioBatalla = document.getElementById("comenzarBatalla");
    
    let especialbool1 = true;
    let especialbool2 = true;
    
    let tuTurno = true;
    
    let esquivar1 = false;
    let esquivar2 = false;
    
    let terminado = false;
    
    let IAb = false;
    
    terminarPartida.addEventListener("click",function(){
        location.reload();
    });
    
    IA.addEventListener("click",function(){
        if(!IAb){
            IAb = true;
            IA.value = "JUGAR SIN IA";
            ataque2.style.visibility = "hidden";
            defensa2.style.visibility = "hidden";
            especial2.style.visibility = "hidden";
            if(!tuTurno){
            ataque2f();
            }
        }else{
            IAb = false;
            IA.value = "JUGAR CONTRA IA";
            ataque2.style.visibility = "visible";
            defensa2.style.visibility = "visible";
            especial2.style.visibility = "visible";
        }
    })
    ;
    function actualizar(x){
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
                pokemon1.style.marginTop = "282px";
            },210);
            
            setTimeout(function(){
                pokemon1.style.marginLeft = "520px";
                pokemon1.style.marginTop = "285px";
            },220);
    }
    
    ataque1.addEventListener("click",function(){
        if(tuTurno && !terminado){
            accion("atacar1");
            cambiar();
            recibirDano(2);
        }
    });
    
    ataque2.addEventListener("click",ataque2f);
    
    function ataque2f(){
        if(!tuTurno&& !terminado){
            accion("atacar2");
            cambiar();
            recibirDano(1);
        }
    }
    
    defensa1.addEventListener("click",function(){
        if(tuTurno&& !terminado){
            esquivar1 =true;
            mensaje1.innerText = nombre1 + " se prepara para esquivar";
            setTimeout(function(){
                mensaje1.innerText = "";
            },2000);
            cambiar();
        }
    });
    
    defensa2.addEventListener("click",defensa2f);
    
    function defensa2f(){
        if(!tuTurno&& !terminado){
            esquivar2 =true;
            mensaje2.innerText = nombre2 + " se prepara para esquivar";
            setTimeout(function(){
                mensaje2.innerText = "";
            },2000);
            cambiar();
        }
    }
    
    especial1.addEventListener("click",function(){
        if(tuTurno && especialbool1&& !terminado){
            especial1.style.backgroundColor = "gray";
            accion("especial1");
            especialbool1 = false;
            cambiar();
            recibirDano(2);
        }
    });
    
    especial2.addEventListener("click",especial2f);
    
    function especial2f(){
        if(!tuTurno&& especialbool2&& !terminado){
            especial2.style.backgroundColor = "gray";
            accion("especial2");
            especialbool2 = false;
            cambiar();
            recibirDano(1);
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
            if(IAb){
                setTimeout(function(){
                    let probabilidad = Math.random();
                    
                    if(especialbool2){
                        if(probabilidad < 0.33){
                            ataque2f();
                        }else if(probabilidad < 0.45){
                            defensa2f();
                        }else{
                            especial2f();
                        }
                    }else{
                        if(probabilidad < 0.8){
                            ataque2f();
                        }else{
                            defensa2f();
                        }
                    }
                },3000);
            }
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
            accion: x
        };

        fetch('AtaqueServlet', {
            method: "POST",
            body: JSON.stringify(accion),
            headers: {"Content-type": "application/json; charset=UTF-8"}
        })
        .then(response => response.json()) 
        .then(datos => {
            console.log(datos);
    
            actualizar(datos);
        })
        .catch(err => console.log(err));

        esquivar1 = false;
        esquivar2 = false;
    }
    
    fetch("RecibirPokemonsServlet",{
        method: "POST"
    })
            .then(response=>response.json())
            .then(datos=>{
                for(let i = 0;i<datos.length;i++){
                    x.innerHTML = x.innerHTML + "<option value="+datos[i]+">"+datos[i]+"</option>";
                    y.innerHTML = y.innerHTML + "<option value="+datos[i]+">"+datos[i]+"</option>";
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
                let blob = new Blob([new Uint8Array(imagenesFrontales[x.selectedIndex])], { type: 'image/gif' });
        
                let url = URL.createObjectURL(blob);
        
                foto1.src = url;
                
                let blob2 = new Blob([new Uint8Array(imagenesFrontales[y.selectedIndex])], { type: 'image/gif' });
        
                let url2 = URL.createObjectURL(blob2);
        
                foto2.src = url2;
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
        let blob = new Blob([new Uint8Array(imagenesFrontales[x.selectedIndex])], { type: 'image/gif' });
        
        let url = URL.createObjectURL(blob);
        
        foto1.src = url;
    });
    
    y.addEventListener("change",function(){  
        let blob = new Blob([new Uint8Array(imagenesFrontales[y.selectedIndex])], { type: 'image/gif' });
        
        let url = URL.createObjectURL(blob);
        
        foto2.src = url;
    });
    
    let batalla = document.getElementById("batalla");
    
    batalla.addEventListener("click", function(){
        
        document.getElementById("azul").className = "azulanim";
        
        document.getElementById("cian").className = "ciananim";
        
        nombre1 = x.value;
        
        x.style.visibility = "hidden";
        
        nombre2 = y.value;
        
        y.style.visibility = "hidden";
        
        batalla.style.visibility = "hidden";
        
        document.getElementById("pokeball").style.visibility = "hidden";
        
        setTimeout(function(){
            document.getElementById("batallaestadio").style.visibility = "visible";
        
        audioBatalla.play();
        
        foto1.style.visibility = "hidden";
        foto2.style.visibility = "hidden";
        
        let blob = new Blob([new Uint8Array(imagenesEspalda[x.selectedIndex])], { type: 'image/gif' });
        
        let url = URL.createObjectURL(blob);
        
        pokemon1.src = url;
        
        let blob2 = new Blob([new Uint8Array(imagenesFrontales[y.selectedIndex])], { type: 'image/gif' });
        
        let url2 = URL.createObjectURL(blob2);
        
        pokemon2.src = url2;
        
        let nombres = {
            nombre1: x.value,
            nombre2: y.value, 
        };

        fetch('BatallaServlet', {
            method: "POST",
            body: JSON.stringify(nombres),
            headers: {"Content-type": "application/json; charset=UTF-8"}
        })
        .then(response => response.json()) 
        .then(datos => {
            console.log(datos);
    
            actualizar(datos);
        })
        .catch(err => console.log(err));
        },4010);
    });
};