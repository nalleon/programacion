package es.ies.puerto.modelo.db.dao;

import es.ies.puerto.exception.MarvelException;
import es.ies.puerto.modelo.db.abstracts.DaoAbstract;
import es.ies.puerto.modelo.db.entidades.Poder;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;
@Repository
public class DaoPoder extends DaoAbstract {
    public DaoPoder() throws MarvelException {
        super();
    }

    public Set<Poder> findAllPoder() throws MarvelException {
        String query;
        query  = "select p.id, p.nombre from Poder as p";
        return obtener(query);
    }

    public Poder findPoder(Poder poder) throws MarvelException {
        String query = "select p.id, p.nombre from poder as p" +
                " where p.id='"+poder.getId()+"'";
        Set<Poder> lista = obtener(query);
        if(lista.isEmpty()) {
            return null;
        }
        return lista.iterator().next();
    }

    public boolean updatePoder(Poder poder) throws MarvelException {

        String query = "INSERT INTO poder as p (id,nombre)" +
                " VALUES ('"+poder.getId()+"','"
                + poder.getNombre()+"')";
        Poder findPoder = findPoder(poder);
        if (findPoder!= null) {
            query = "update poder set nombre='"+poder.getNombre()+"' " +
                    "where id='"+poder.getId()+"'";
        }

        //Si existe actualiza
        //Si NO existe inserta
        return actualizar(query);
    }

    public boolean deletePoder(Poder poder) throws MarvelException {
        String query = "delete FROM Poder as p" +
                " where p.id='"+poder.getId()+"'";
        return actualizar(query);
    }

    private Set<Poder> obtener(String query) throws MarvelException {
        Set<Poder> lista = new HashSet<>();
        Statement statement = null;
        ResultSet rs = null;
        try {
            statement = getConexion().createStatement();
            rs = statement.executeQuery(query);
            while (rs.next()) {
                String id = rs.getString("id");
                String nombre = rs.getString("nombre");

                Poder Poder = new Poder(id, nombre);
                lista.add(Poder);
            }
        } catch (SQLException exception) {
            throw new MarvelException(exception.getMessage(), exception);
        } finally {
            try {
                closeResources(rs,statement);
            } catch (SQLException e) {
                throw new MarvelException(e.getMessage(), e);
            }
        }
        return lista;
    }
}
