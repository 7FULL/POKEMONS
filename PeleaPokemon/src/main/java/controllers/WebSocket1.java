package controllers;

import java.io.IOException;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnError;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;
import jakarta.websocket.server.ServerEndpoint;

/**
 * Servlet implementation class WebSocket
 */
@ServerEndpoint("/websocket1")
public class WebSocket1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static Set<Session> userSessions = Collections.newSetFromMap(new ConcurrentHashMap<Session, Boolean>());
	@OnOpen
    public void onOpen(Session session) {
        System.out.println("WebSocket opened: " + session.getId());
        userSessions.add(session);
    }

    @OnClose
    public void onClose(Session session) {
        System.out.println("WebSocket closed: " + session.getId());
        userSessions.remove(session);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        System.out.println("WebSocket error: " + session.getId() + ", " + throwable.getMessage());
    }
	
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
    	for(Session ses : userSessions)
        {
    		System.out.println("/*****************************WEB SOCKET RECIBIDO*******************************/");
    		ses.getAsyncRemote().sendText(message);
        }
    }
}
