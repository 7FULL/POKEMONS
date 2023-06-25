package controllers;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import modelos.Pokemon;

public class AtaqueSinglePlayerServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    
	    BufferedReader reader = request.getReader();
	    StringBuilder requestBody = new StringBuilder();
	    
	    String line;
	    while ((line = reader.readLine()) != null) {
	        requestBody.append(line);
	    }
	    
	    Gson gson = new Gson();
	    
	    JsonObject data = gson.fromJson(requestBody.toString(), JsonObject.class);
	    
	    String action = data.get("accion").getAsString();
	    
	    Pokemon pokemon1 = (Pokemon) request.getSession().getAttribute("pokemon1");
	    Pokemon pokemon2 = (Pokemon) request.getSession().getAttribute("pokemon2");
	    
	    System.out.println(action);
	    
	    switch (action){
	        case "especial1":
	            Batalla.atacarEspecial(pokemon1, pokemon2);
	            break;
	        case "especial2":
	            Batalla.atacarEspecial(pokemon2, pokemon1);
	            break;
	        case "atacar1":
	            Batalla.atacar(pokemon1, pokemon2);
	            break;
	        case "atacar2":
	            Batalla.atacar(pokemon2, pokemon1);
	            break;
	        case "esquivar1":
	            Batalla.esquivar(pokemon1, pokemon2);
	            break;
	        case "esquivar2":
	            Batalla.esquivar(pokemon2, pokemon1);
	            break;
	    }
	    
	    HttpSession session = request.getSession();
	    
	    session.setAttribute("pokemon1", pokemon1);
	    
	    session.setAttribute("pokemon2", pokemon2);
	    
	    Pokemon[] pokemons = new Pokemon[]{pokemon1,pokemon2};
	            
	    String json = gson.toJson(pokemons);
	    
	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    
	    response.getWriter().write(json);
	}
}

