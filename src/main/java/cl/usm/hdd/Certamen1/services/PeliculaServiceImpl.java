package cl.usm.hdd.Certamen1.services;

import cl.usm.hdd.Certamen1.entities.Pelicula;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeliculaServiceImpl implements PeliculaService {
    private static List<Pelicula> peliculas = new ArrayList<>();

    public List<Pelicula> ver() {
        return peliculas;
    }

    public Pelicula crear(Pelicula pelicula) {
        peliculas.add(pelicula);
        return pelicula;
    }

    public List<Pelicula> verPorEdad(int edad) {
        // TODO
    }
}
