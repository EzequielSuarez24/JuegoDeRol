package modelos;
import java.util.ArrayList;
import java.util.List;

public class Humano extends Personaje {
    public Humano(String nombre, String apodo, String fechaNacimiento, int edad, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    public static List<Humano> generarHumanos() {
        List<Humano> humanos = new ArrayList<>();
        humanos.add(new Humano("Arthur", "El Humano Valiente", "01-01-1200", 35, 7, 3, 8, 5, 6));
        humanos.add(new Humano("Elena", "La Humano Espada", "12-03-1250", 27, 6, 4, 7, 6, 5));
        humanos.add(new Humano("Ricardo", "Humano Puño de Hierro", "22-07-1180", 50, 5, 5, 6, 7, 8));
        humanos.add(new Humano("Beatriz", "La Humana Rápida", "04-05-1270", 29, 9, 2, 5, 4, 4));
        humanos.add(new Humano("Carlos", "El Humano Sabio", "30-08-1220", 45, 4, 4, 6, 5, 7));
        return humanos;
    }
}
