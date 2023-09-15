package cl.usm.hdd.Certamen1.services;

import cl.usm.hdd.Certamen1.entities.Pelicula;

import java.util.List;

public interface PeliculaService {
    public List<Pelicula> ver();
    public Pelicula crear();
    public List<Pelicula> verPorEdad(int edad);
}
