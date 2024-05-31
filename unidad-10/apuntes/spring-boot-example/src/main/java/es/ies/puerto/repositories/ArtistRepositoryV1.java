package es.ies.puerto.repositories;

import es.ies.puerto.models.Artist;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
 @Repository("artistRepository")
public class ArtistRepository {
    public List<Artist> list;


    public ArtistRepository() {
        list = new ArrayList<>();
        list.add(new Artist("1", "Pepe Benavente"));
        list.add(new Artist("2", "Michael Jackson"));
    }

    public List<Artist> getAll(){
        return list;
    }
}
