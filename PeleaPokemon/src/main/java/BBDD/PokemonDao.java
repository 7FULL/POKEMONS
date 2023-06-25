package BBDD;

import com.google.gson.Gson;
import com.mysql.cj.jdbc.Blob;
import controllers.RecibirTiposServlet;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import modelos.Pokemon;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PokemonDao {
    private Connection con = null;
    
    private static PokemonDao instance = null;
    
    public PokemonDao() throws SQLException, ClassNotFoundException{
        con = BDDConnector.connect();
    }
    
    public static PokemonDao getInstance() throws SQLException, ClassNotFoundException{
        if(instance == null){
            instance = new PokemonDao();
        }
        return instance;
    }
    
    public void register(Pokemon pokemon) throws SQLException, FileNotFoundException{
        String nombre = pokemon.getNombre();
        
    	String tipo = pokemon.getTipo();
    	
    	int ataque = pokemon.getAtaque();
    	
    	int defensa = pokemon.getDefensa();
    	
    	int velocidad = pokemon.getVelocidad();
    	
    	float vida = pokemon.getVida();
        
        String fotod = pokemon.getFotod();
        
        String fotof = pokemon.getFotof();
        
        //BDDConnector.lanzarQuery("INSERT INTO `pokemon` (`nombre`, `ataque`, `defensa`, `velocidad`, `vida`, `tipo_nombre`) VALUES ('"+nombre+"', '"+ataque+"', '"+defensa+"', '"+velocidad+"', '"+vida+"', '"+tipo+"')");
    
        PreparedStatement pt = con.prepareStatement("INSERT INTO `pokemon` (`nombre`, `ataque`, `defensa`, `velocidad`, `vida`, `fotoDeFrente`,`fotoDeEspaldas`, `tipo_nombre`) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
    
        pt.setString(1, nombre);
        pt.setInt(2, ataque);
        pt.setInt(3, defensa);
        pt.setInt(4, velocidad);
        pt.setFloat(5, vida);    
        pt.setString(6, fotof);
        pt.setString(7, fotod);
        pt.setString(8,tipo);
        
        pt.execute();
    }
    
   
    
    //Devuelve un json con todos los nombres de los pokemons
    public String recibirTodosNombres(){
        String query ="SELECT nombre FROM `pokemon` order by nombre";
        
        ArrayList<String> x = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
                x.add(rs.getString(1));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(x);
        return json;
    }
    
    //Devuelve un json conteniendo un arraylist de arrays de bytes con todas las imagenes frontales
    public String recibirTodosImagenesFrontales() throws IOException{
        String query ="SELECT fotoDeFrente FROM `pokemon` order by nombre";
        
        ArrayList<String> x = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
            	String blob = rs.getString(1);
                x.add(blob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(x);
        return json;
    }
    
    //Devuelve un json conteniendo un arraylist de arrays de bytes con todas las imagenes de atras
    public String recibirTodosImagenesEspalda() throws IOException{
        String query ="SELECT fotoDeEspaldas FROM `pokemon` order by nombre";
        
        ArrayList<String> x = new ArrayList<>();
        ResultSet rs = null;
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
            	String blob =  rs.getString(1);
                x.add(blob);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(x);
        return json;
    }
    
    public Pokemon recibirPokemonPorNombre(String nombre)throws IOException{
        String query ="SELECT * FROM `pokemon` where nombre like '"+nombre+"'";
        
        Pokemon pokemon = new Pokemon();
        ResultSet rs = null;
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
                pokemon.setNombre(nombre);
                pokemon.setAtaque(rs.getInt("ataque"));
                pokemon.setDefensa(rs.getInt("defensa"));
                pokemon.setVida(rs.getFloat("vida"));
                pokemon.setVelocidad(rs.getInt("velocidad"));
                pokemon.setTipo(rs.getString("tipo_nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pokemon;
    }
    
    public String recibirPokemons()throws IOException{
        String query ="SELECT * FROM `pokemon`";
        
        
        ResultSet rs = null;
        
        ArrayList<Pokemon> pokemons = new ArrayList<Pokemon>();
        try {
            rs = BDDConnector.recibirQuery(query);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            while (rs.next()){
            	Pokemon pokemon = new Pokemon();
                pokemon.setNombre(rs.getString("nombre"));
                pokemon.setAtaque(rs.getInt("ataque"));
                pokemon.setDefensa(rs.getInt("defensa"));
                pokemon.setVida(rs.getFloat("vida"));
                pokemon.setVelocidad(rs.getInt("velocidad"));
                pokemon.setTipo(rs.getString("tipo_nombre"));
                
                pokemons.add(pokemon);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RecibirTiposServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        Gson gson = new Gson();
        String json = gson.toJson(pokemons);
        return json;
    }
    
}
