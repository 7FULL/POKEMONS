    
    let x = document.getElementById("pokemon");
    let y = document.getElementById("tipos");
    let z = document.getElementById("elegir");
    let form = document.getElementById("forms");
 
    console.log(x);
    console.log(y);
    console.log(z);
    
    let pokemonboton = document.getElementsByClassName("toggle-btn")[0];
    pokemonboton.addEventListener("click",pokemon);
    
    let tipoboton = document.getElementsByClassName("toggle-btn")[1];
    tipoboton.addEventListener("click",tipo);
 
    function pokemon(){
            z.style.left = "0px";
            y.style.left = "450px";
            x.style.left = "50px";
            form.style.height = "550px";
    }

    function tipo(){
            z.style.left = "120px";
            y.style.left = "50px";
            x.style.left = "-400px";
            form.style.height = "200px";          
    }



