package controllers;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * Servlet implementation class RegistrarUsuario
 */
public class RegistrarUsuario extends HttpServlet {
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
	     
	     String x = LobbieManager.unirseAUnLobbie();
	        
	     JsonObject data = gson.fromJson(requestBody.toString(), JsonObject.class);
		
		if (context.getAttribute("jugador1Ready"+x) == null) {
			context.setAttribute("jugador1Ready"+x, request.getSession().getId());
			
			context.setAttribute("pokemon1"+x, data.get("nombre1").getAsString());
			
			System.out.println("/**************\n\n\n\n\n\n\nJugador 1 registrado \n\n\n\n\n\n\n**************/");
	        
			response.setContentType("text/plain");
	        response.setCharacterEncoding("UTF-8");
	        response.getWriter().write("false"+x);
			
		}else if (context.getAttribute("jugador2Ready"+x) == null) {
			if (!context.getAttribute("jugador1Ready"+x).toString().equals(request.getSession().getId())) {
				context.setAttribute("jugador2Ready"+x, request.getSession().getId());
				
				context.setAttribute("pokemon2"+x, data.get("nombre1").getAsString());
				
				System.out.println("/**************\n\n\n\n\n\n\nJugador 2 registrado \n\n\n\n\n\n\n**************/");
		        
				response.setContentType("text/plain");
		        response.setCharacterEncoding("UTF-8");
		        response.getWriter().write("true"+x);
				
				/*String wsUrl = "ws://192.168.1.22:8080/PokemonServidor/websocket";
		        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
		       
		        try {
		            container.connectToServer(WebSocket.class, URI.create(wsUrl));
		            Session session = WebSocket.getSession();

		            session.getAsyncRemote().sendText("cambio");
		        } catch (DeploymentException e) {
		            e.printStackTrace();
//		        }*/
			}
		}
	}
}
