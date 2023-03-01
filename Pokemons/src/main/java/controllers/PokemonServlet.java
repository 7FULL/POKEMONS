
package controllers;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import jakarta.servlet.RequestDispatcher;
import modelos.Pokemon;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*import javax.servlet.annotation.WebServlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
*/
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.InputStream;

@WebServlet("/registerpokemon")

@MultipartConfig(maxFileSize = 16177215)
public class PokemonServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
    	 
        String nombre = request.getParameter("nombre");
        
        String tipo = request.getParameter("tipo");
        
        int defensa = Integer.parseInt(request.getParameter("defensa"));
        
        int ataque = Integer.parseInt(request.getParameter("ataque"));
        
        int velocidad = Integer.parseInt(request.getParameter("velocidad"));
        
        float vida = Float.parseFloat(request.getParameter("vida"));
        
        InputStream fotod = request.getPart("fotod").getInputStream();
        
        InputStream fotof = request.getPart("fotof").getInputStream();
        
        Pokemon pokemon = new Pokemon();
        
        pokemon.setAtaque(ataque);
        
        pokemon.setDefensa(defensa);
        
        pokemon.setNombre(nombre);
        
        pokemon.setTipo(tipo);
        
        pokemon.setVelocidad(velocidad);
        
        pokemon.setVida(vida);
        
        pokemon.setFotod(fotod);
        
        pokemon.setFotof(fotof);
        
        System.out.println(pokemon.toString());
        
            try {
                pokemon.insertar();
            } catch (SQLException ex) {
                Logger.getLogger(PokemonServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
        rd.forward(request, response);
    }

}
