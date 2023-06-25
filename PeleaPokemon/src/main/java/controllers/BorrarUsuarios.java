package controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class BorrarUsuarios
 */
public class BorrarUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContext context = request.getServletContext();
		
		BufferedReader reader = request.getReader();
	    StringBuilder requestBody = new StringBuilder();
	        
	    String line;
	    while ((line = reader.readLine()) != null) {
	         requestBody.append(line);
	     }
	        
	     Gson gson = new Gson();
	        
	     JsonObject data = gson.fromJson(requestBody.toString(), JsonObject.class);
	     
	     System.out.println(data);
	     
	     String x = data.get("lobbieId").getAsString();
	     
	     LobbieManager.borrarLobbie(Integer.parseInt(x));
		
		if (context.getAttribute("jugador1Ready"+x) != null) {
			context.removeAttribute("jugador1Ready"+x);
		}
		
		if (context.getAttribute("jugador2Ready"+x) != null) {
			context.removeAttribute("jugador2Ready"+x);
		}
	}

}
