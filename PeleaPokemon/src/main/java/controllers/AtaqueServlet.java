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

public class AtaqueServlet extends HttpServlet {
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
        
        String x = data.get("lobbieId").getAsString();
        
        System.out.println(data);
        
        System.out.println(x);
        
        Pokemon pokemon1 = (Pokemon) request.getServletContext().getAttribute("pokemon1object"+x);
        Pokemon pokemon2 = (Pokemon) request.getServletContext().getAttribute("pokemon2object"+x);
        
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
        
        ServletContext context = request.getServletContext();
        
        context.setAttribute("pokemon1object"+x, pokemon1);
        
        context.setAttribute("pokemon2object"+x, pokemon2);
        
        Pokemon[] pokemons = new Pokemon[]{pokemon1,pokemon2};
                
        String json = gson.toJson(pokemons);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        
        response.getWriter().write(json);
    }
}
