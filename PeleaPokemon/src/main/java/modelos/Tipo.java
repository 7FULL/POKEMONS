package modelos;

import BBDD.TipoDao;
import java.sql.SQLException;

public class Tipo {
    
    private int id;
    
    private String nombre;


	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void insertar() throws SQLException, ClassNotFoundException{
            System.out.print("1");
            TipoDao.getInstance().register(this);
        }
}
