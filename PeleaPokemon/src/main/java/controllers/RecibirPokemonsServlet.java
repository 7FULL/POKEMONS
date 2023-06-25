package controllers;

import java.io.IOException;
import java.sql.SQLException;

import BBDD.PokemonDao;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class RecibirPokemonsServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String json;
		try {
			json = PokemonDao.getInstance().recibirTodosNombres();
			
	        response.setContentType("application/json");
	        response.setCharacterEncoding("UTF-8");
	        
	        response.getWriter().write(json);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}