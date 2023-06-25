package modelos;

import BBDD.PokemonDao;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.SQLException;

public class Pokemon{
    
        private int id;

	private String nombre;
    
	private String tipo;
	
	private int ataque;
	
	private int defensa;
	
	private int velocidad;
	
	private float vida;
        
        private String fotod;
        
        private String fotof;
        
        private boolean esquivar;
        
        private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
        
        

    public boolean isEsquivar() {
        return esquivar;
    }

    public void setEsquivar(boolean esquivar) {
        this.esquivar = esquivar;
    }
        
        

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public float getVida() {
		return vida;
	}

	public void setVida(float vida) {
		this.vida = vida;
	}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getFotod() {
            return fotod;
        }

        public void setFotod(String fotod) {
            this.fotod = fotod;
        }

        public String getFotof() {
            return fotof;
        }

        public void setFotof(String fotof) {
            this.fotof = fotof;
        }
        
        public void insertar() throws SQLException, FileNotFoundException, ClassNotFoundException{
            PokemonDao.getInstance().register(this);
        } 

    public Pokemon(String nombre, String tipo, int ataque, int defensa, int velocidad, float vida) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.ataque = ataque;
        this.defensa = defensa;
        this.velocidad = velocidad;
        this.vida = vida;
    }
    
    public Pokemon(){
        
    }
        
        

    @Override
    public String toString() {
        return "Pokemon{" + "id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", ataque=" + ataque + ", defensa=" + defensa + ", velocidad=" + velocidad + ", vida=" + vida + ", fotod=" + fotod + ", fotof=" + fotof + '}';
    }
        
}
