package modelos;
import java.util.ArrayList;
import java.util.List;

public class Elfo extends Personaje {
    public Elfo(String nombre, String apodo, String fechaNacimiento, int edad, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    public static List<Elfo> generarElfos() {
        List<Elfo> elfos = new ArrayList<>();
        elfos.add(new Elfo("Legolas", "El Elfo Arquero", "03-04-1500", 250, 10, 5, 6, 9, 4));
        elfos.add(new Elfo("Eldrin", "El Elfo Sabio", "21-07-1480", 270, 8, 4, 5, 8, 5));
        elfos.add(new Elfo("Thalir", "El Elfo Sombrío", "19-02-1520", 230, 7, 3, 6, 7, 6));
        elfos.add(new Elfo("Anwen", "La Elfa Hechicera", "05-06-1450", 290, 9, 5, 5, 6, 5));
        elfos.add(new Elfo("Fenrir", "El Elfo Astuto", "14-09-1495", 260, 8, 4, 6, 5, 4));
        return elfos;
    }
}
