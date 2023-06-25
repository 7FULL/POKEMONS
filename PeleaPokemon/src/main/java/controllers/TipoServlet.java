package controllers;

import java.io.IOException;
import java.sql.SQLException;
/*
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;*/

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.RequestDispatcher;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Tipo;

public class TipoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
            System.out.print("2");
            
			String nombre = request.getParameter("nombre");
			
			Tipo tipo = new Tipo();
			
			tipo.setNombre(nombre);
			
            try {
                tipo.insertar();
            } catch (SQLException ex) {
                Logger.getLogger(TipoServlet.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
                        
            RequestDispatcher rd = request.getRequestDispatcher("/registration.jsp");
            rd.forward(request, response);
	}

}
