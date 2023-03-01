window.onload = function(){
    let x = document.getElementById("tipo");
    
    fetch("RecibirTiposServlet",{
        method: "POST"
    })
            .then(response=>response.json())
            .then(datos=>{
                for(let i = 0;i<datos.length;i++){
                    x.innerHTML = x.innerHTML + "<option value="+datos[i]+">"+datos[i]+"</option>";
                }
    })
            .catch(error=>console.error("Se ha producido un error a la hora de procesar el JSON de tipo: "+error));
};