package cl.usm.hdd.Certamen1.entities;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {
    private String nombre;
    private String nombre_abreviado;
    private int edad_minima;
    private String genero;
}
