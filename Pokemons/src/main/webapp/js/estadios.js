
let miBoton = document.getElementById("imagen-seleccionada");
let contasor = 0;
let imagenes = ["img/estadios/estadio1.jpg","img/estadios/estadio2.jpg","img/estadios/estadio3.jpg","img/estadios/estadio4.jpg","img/estadios/estadio5.jpg","img/estadios/estadio6.jpg","img/estadios/estadio7.jpg","img/estadios/estadio8.jpg"];
miBoton.addEventListener("click", function() { 
  console.log("aaaaa");
  contasor ++; 
  if (contasor > imagenes.length - 1) {
      contasor = 0;
   }
   let imagenSeleccionada = document.getElementById("imagengorda");
   imagenSeleccionada.src = imagenes[contasor];
});

