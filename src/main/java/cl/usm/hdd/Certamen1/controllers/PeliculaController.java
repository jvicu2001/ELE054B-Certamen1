package cl.usm.hdd.Certamen1.controllers;

import cl.usm.hdd.Certamen1.entities.Pelicula;
import cl.usm.hdd.Certamen1.services.PeliculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class PeliculaController {
    @Autowired
    private PeliculaService peliculaService;

    @GetMapping("/verPeliculas")
    public ResponseEntity<List<Pelicula>> ver() {
        try {
            return ResponseEntity.ok(this.peliculaService.ver());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/crearPelicula")
    public ResponseEntity<Pelicula> crear(@RequestBody Pelicula pelicula) {
        try {
            Pelicula peliculaCreada = this.peliculaService.crear(pelicula);
            return ResponseEntity.ok(peliculaCreada);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @GetMapping("/peliculas/{limite}")
    public ResponseEntity<List<Pelicula>> verPorEdad(@PathVariable String limite) {
        try {
            List<Pelicula> peliculasPorEdad = this.peliculaService.verPorEdad(edadLimiteMapping(limite));
            return ResponseEntity.ok(peliculasPorEdad);
        } catch (AssertionError e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    private int edadLimiteMapping(String rangoEdad) throws AssertionError{
        switch (rangoEdad.toLowerCase()) {
            case "menor_edad":
                return 15;
            case "adolescentes":
                return 17;
            case "mayor":   // Una persona mayor puede ver cualquier película.
                return Integer.MAX_VALUE;
            default:
                throw new AssertionError("Parámetro inválido");
        }
    }
}
