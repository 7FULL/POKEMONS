
package controllers;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import jakarta.servlet.RequestDispatcher;
/*import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import modelos.Pokemon;

@MultipartConfig(maxFileSize = 16177215)

//1024 *1024 * 5 --> 5MB
//1024 *1024 * 50 --> 50MB
public class PokemonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	
    	String pathFiles = request.getServletContext().getRealPath("");
    	
        String nombre = request.getParameter("nombre");
        
        String tipo = request.getParameter("tipo");
        
        int defensa = Integer.parseInt(request.getParameter("defensa"));
        
        int ataque = Integer.parseInt(request.getParameter("ataque"));
        
        int velocidad = Integer.parseInt(request.getParameter("velocidad"));
        
        float vida = Float.parseFloat(request.getParameter("vida"));
        
        Part filepartPartd = request.getPart("fotod");
        
        Part filepartPartf = request.getPart("fotof");
        
        filepartPartd.write(pathFiles+File.separator+"img/pokemons"+File.separator+filepartPartd.getSubmittedFileName());
        
        filepartPartf.write(pathFiles+File.separator+"img/pokemons"+File.separator+filepartPartf.getSubmittedFileName());
        
        System.out.println("/********************"+pathFiles+File.separator+filepartPartd.getSubmittedFileName()+"************************/");
        
        Pokemon pokemon = new Pokemon();
        
        pokemon.setAtaque(ataque);
        
        pokemon.setDefensa(defensa);
        
        pokemon.setNombre(nombre);
        
        pokemon.setTipo(tipo);
        
        pokemon.setVelocidad(velocidad);
        
        pokemon.setVida(vida);
        
        pokemon.setFotod(filepartPartd.getSubmittedFileName());
        
        pokemon.setFotof(filepartPartf.getSubmittedFileName());
        
        System.out.println(pokemon.toString());
        
            try {
                pokemon.insertar();
            } catch (SQLException ex) {
                Logger.getLogger(PokemonServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        
        RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
        rd.forward(request, response);
    }

}
