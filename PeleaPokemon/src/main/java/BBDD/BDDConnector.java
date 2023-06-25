package BBDD;

import  java.sql.Connection;
import  java.sql.SQLException;
import  java.sql.DriverManager;
import  java.sql.ResultSet;
import  java.sql.Statement;
import java.util.Properties;

public class BDDConnector{
    private static Connection instance = null;
    
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/pokemon?autoReconnect=true&useSSL=false";
    
    public static Connection connect() throws SQLException, ClassNotFoundException{
        if(instance == null){
			//Class.forName("com.mysql.cj.jdbc.Driver");
        	
            Properties prop = new Properties();
            prop.put("user", "pi");
            prop.put("password", "678041577");
            instance = DriverManager.getConnection(JDBC_URL, prop);
        }
        return instance;
    }
    
    /*public static void lanzarQuery(String x) throws SQLException, ClassNotFoundException{
    	
    	//Class.forName("com.mysql.cj.jdbc.Driver");
    	//Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pruebas", "pi", "678041577");
    	
        Connection connection = Connect();
        Statement st = connection.createStatement();
        
        //ExecuteUpdate Modificar o actualizar base de datos --->  SELECT
        //ExecuteQuery Recibirdatos de la base de datos ----> INSERT, UPDATE, DELETE, CREATE y ALTER
        //Execute Ambas ---> todo
        
        st.executeUpdate(x);
        
        cerrarConexion(st,connection);
    }*/
    
    public static ResultSet recibirQuery(String x) throws SQLException, ClassNotFoundException {
    	if(instance == null){
            instance = connect();
        }
    	
    	Statement st = instance.createStatement();
    	
    	ResultSet rs = st.executeQuery(x);
    	
    	return rs;
    }
    
    //Lo hacemos una funcion para poder llamarla desde los jsp despues de utilizar el resultset
    /*public static void cerrarConexion(Statement st, Connection connection) throws SQLException {
    	st.close();
    	connection.close();
    }*/
    
}


