package es.ies.puerto.modelo;

import es.ies.puerto.config.AppConfig;
import es.ies.puerto.exception.TiendaException;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion extends AppConfig {
    private Connection con;
    private String url;
    public Conexion() throws TiendaException {
        super();
        this.url="jdbc:sqlite:"+getUrlBd();
    }

    public Connection getConexion() throws TiendaException {
        try {
            Class.forName("org.sqlite.JDBC");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            this.con = DriverManager.getConnection(url);
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
            throw new TiendaException("No se ha podido establecer la conexion",
                    exception);
        }
        return con;
    }
}
