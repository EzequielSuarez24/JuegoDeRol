package modelos;
import java.util.ArrayList;
import java.util.List;

public class Orco extends Personaje {
    public Orco(String nombre, String apodo, String fechaNacimiento, int edad, int velocidad, int destreza, int fuerza, int nivel, int armadura) {
        super(nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura);
    }

    public static List<Orco> generarOrcos() {
        List<Orco> orcos = new ArrayList<>();
        orcos.add(new Orco("Grom", "El Orco Destructor", "05-10-1300", 80, 5, 2, 10, 8, 9));
        orcos.add(new Orco("Thrall", "El Orco Líder", "15-12-1350", 60, 6, 3, 9, 7, 8));
        orcos.add(new Orco("Narak", "El Orco Feroz", "22-06-1400", 55, 4, 5, 8, 6, 7));
        orcos.add(new Orco("Grukk", "La Bestia Orco", "01-03-1380", 45, 3, 4, 7, 5, 6));
        orcos.add(new Orco("Zogar", "El Rabioso Orco", "10-09-1325", 70, 5, 3, 6, 4, 5));
        return orcos;
    }
}
