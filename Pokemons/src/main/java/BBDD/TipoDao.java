package BBDD;

import com.google.gson.Gson;
import controllers.RecibirTiposServlet;
import java.sql.Connection;
import modelos.Tipo;

import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TipoDao {
    private Connection con = null;
    
    private static TipoDao instance = null;
    
    public TipoDao() throws SQLException{
        con = BDDConnector.connect();
    }
    
    public static TipoDao getInstance() throws SQLException{
        if(instance == null){
            instance = new TipoDao();
        }
        return instance;
    }
    
    public void register(Tipo tipo) throws SQLException{
        System.out.print("3");
        
        String nombre = tipo.getNombre();  
        
        PreparedStatement pt = con.prepareStatement("INSERT INTO `tipo` (`nombre`, `cualidad`) VALUES (?,NULL)");
        
        pt.setString(1, nombre);
        
        pt.execute();
    }
    
    public static String recibirTodosNombres(){
        String query ="SELECT * FROM `tipo`";
        
        ArrayList<String> x = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
                x.add(rs.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(x);
        return json;
    }
}
