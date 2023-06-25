package controllers;

import modelos.Pokemon;

public class Batalla {
    
    // Función para atacar a un Pokemon
        public static void atacar(Pokemon atacante, Pokemon defensor) { 
        	System.out.println(atacante.toString());
        	System.out.println(defensor.toString());
        
            atacante.setMensaje(null);
            defensor.setMensaje(null);
                    
            double x = Math.round((Math.random()*0.3f+0.1f)*100);

            x /= 100;

            double y = Math.round((Math.random()*0.3f+0.1f)*100);

            y /= 100;
            float daño = (float) (atacante.getAtaque() * x - defensor.getDefensa() * y);
            
            
            if (daño > 0) {
                float vida = (defensor.getVida() - daño)*100;
                    
                    vida = Math.round(vida);
                    
                    vida /= 100;
                    
                    defensor.setVida(vida);
                    
                     if(daño < 0.5f){
                         atacante.setMensaje("El ataque de "+atacante.getNombre()+" infligio "+ daño + " de daño");
                     }else{
                         atacante.setMensaje("El ataque de "+atacante.getNombre()+" fue crítico");
                     }
            }else{
                atacante.setMensaje("El ataque de "+atacante.getNombre()+" no fue efectivo");
            }
            
            if(defensor.getVida() < 0.01f){
                defensor.setMensaje("DERROTA");
                atacante.setMensaje("VICTORIA");
            }
            System.out.println(daño);
            
            System.out.println(defensor.getVida());
        }

            // Función para esquivar un ataque de un Pokemon
            public static void esquivar (Pokemon atacante, Pokemon defensor){
                atacante.setMensaje(null);
                defensor.setMensaje(null);
                
                float probabilidadEsquiva = Float.parseFloat(String.valueOf(Math.random() * defensor.getVelocidad()));
                if (probabilidadEsquiva > 1.7f) {
                    defensor.setMensaje(defensor.getNombre()+" consiguio esquivar el ataque");
                    System.out.println(defensor.getNombre() + " ha esquivado el ataque de " + atacante.getNombre() + "!");
                } else {
                    float daño = atacante.getAtaque() * 0.65f;

                    float vida = (defensor.getVida() - daño)*100;
                    
                    vida = Math.round(vida);
                    
                    vida /= 100;
                    
                    if(daño > 0){
                        defensor.setVida(vida);
                    }
                    
                    if(defensor.getVida() < 0.01f){
                        defensor.setMensaje("DERROTA");
                        atacante.setMensaje("VICTORIA");
                    }
                    System.out.println(daño);
                    
                    defensor.setMensaje(defensor.getNombre()+" no consiguio esquivar el ataque");
                }
                
                
            
            System.out.println(defensor.getVida());
            }

            // Función para atacar con un ataque especial a un Pokemon
            public static void atacarEspecial (Pokemon atacante, Pokemon defensor){
                atacante.setMensaje(null);
                defensor.setMensaje(null);
                
                double x = Math.round((Math.random()*0.5f+0.3f)*100);

                 x /= 100;

                double y = Math.round((Math.random()*0.3f+0.1f)*100);

                y /= 100;
                float daño = (float) (atacante.getAtaque() * x - defensor.getDefensa() * y);
                if (daño > 0) {
                    
                    float vida = (defensor.getVida() - daño)*100;
                    
                    vida = Math.round(vida);
                    
                    vida /= 100;
                    
                    defensor.setVida(vida);
                    
                    defensor.setVida((defensor.getVida() - daño));
                    
                    atacante.setMensaje("El ataque especial de "+atacante.getNombre()+" infligio "+ daño + " de daño");
                }else{
                    atacante.setMensaje("El ataque especial de "+atacante.getNombre()+" no fue efectivo");
                }
            System.out.println(daño);
            
            System.out.println(defensor.getVida());
            
            if(defensor.getVida() < 0.01f){
                defensor.setMensaje("DERROTA");
                atacante.setMensaje("VICTORIA");
            }
            }
    
}
