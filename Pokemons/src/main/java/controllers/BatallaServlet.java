/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controllers;

import BBDD.PokemonDao;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.BufferedReader;
import modelos.Pokemon;
/**
 *
 * @author phgfu
 */
@WebServlet("/BatallaServlet")
public class BatallaServlet extends HttpServlet {
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
        
        Pokemon pokemon1 = PokemonDao.recibirPokemonPorNombre(data.get("nombre1").getAsString());
        
        Pokemon pokemon2 = PokemonDao.recibirPokemonPorNombre(data.get("nombre2").getAsString());
    
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
