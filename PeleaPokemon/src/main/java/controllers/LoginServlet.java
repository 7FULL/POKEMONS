package controllers;

import BBDD.BDDConnector;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/



/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String usuario = request.getParameter("usuario");
		String contraseña = request.getParameter("contr");

		String query = "SELECT * FROM `admin` WHERE `usuario` LIKE '"+usuario+"'";
                
                boolean x = false;
                
		try {
			ResultSet rs = BDDConnector.recibirQuery(query);
                                               
			while (rs.next()){
				if (rs.getString("contraseña").equals(contraseña)){
                                    x = true;
                                    HttpSession session = request.getSession();
                                    session.setAttribute("admin", true);
                                    RequestDispatcher rd = request.getRequestDispatcher("/index.jsp");
                                    rd.forward(request, response);
				}
			}

		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
                
                if(!x){
                    RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
                    rd.forward(request, response);
                }
	}
}
