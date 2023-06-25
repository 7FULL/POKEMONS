package controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import modelos.Pokemon;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import BBDD.PokemonDao;

/**
 * Servlet implementation class BatallaMultijugadorServlet
 */
public class BatallaMultijugadorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			
			System.out.println("AUIAGYFHUIAGFH(AYIGVHAYIBVHNAIYUVBAIBVNIAUOJVNHJA");
		
			BufferedReader reader = request.getReader();
		    StringBuilder requestBody = new StringBuilder();
		        
		    String line;
		    while ((line = reader.readLine()) != null) {
		         requestBody.append(line);
		     }
		        
		     Gson gson = new Gson();
		        
		     JsonObject data = gson.fromJson(requestBody.toString(), JsonObject.class);
		
		     String x = data.get("lobbieId").getAsString();

			try {
				
				ServletContext context = request.getServletContext();
				
				Pokemon pokemon1 = PokemonDao.getInstance().recibirPokemonPorNombre(context.getAttribute("pokemon1"+x).toString());
				
				Pokemon pokemon2 = PokemonDao.getInstance().recibirPokemonPorNombre(context.getAttribute("pokemon2"+x).toString());
		        
				context.setAttribute("pokemon1object"+x, pokemon1);
				context.setAttribute("pokemon2object"+x, pokemon2);
				
				System.out.println(x);
				
		        Pokemon[] pokemons = new Pokemon[]{pokemon1,pokemon2};
		                
		        String json = gson.toJson(pokemons);
		        
		        System.out.println(json);
		        
		        response.setContentType("application/json");
		        response.setCharacterEncoding("UTF-8");
		        
		        response.getWriter().write(json);
			} catch (ClassNotFoundException | IOException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	}
