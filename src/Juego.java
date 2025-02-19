import modelos.Personaje;
import modelos.Humano;
import modelos.Orco;
import modelos.Elfo;
import utils.Logger;
import utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Juego {
    private List<Personaje> jugador1Personajes = new ArrayList<>();
    private List<Personaje> jugador2Personajes = new ArrayList<>();
    private Random random = new Random();

    public Juego() {
        // Se seleccionan 3 personajes para cada jugador al azar
        jugador1Personajes.addAll(Humano.generarHumanos().subList(0, 3));
        jugador2Personajes.addAll(Orco.generarOrcos().subList(0, 3));
    }

    public void iniciar() {
        Logger.info("¡Bienvenido al Juego de Rol!");
        Logger.info("Se han generado los siguientes personajes:");

        Logger.info("📌 Jugador 1:");
        for (Personaje p : jugador1Personajes) {
            Logger.info(p.toString());
        }

        Logger.info("📌 Jugador 2:");
        for (Personaje p : jugador2Personajes) {
            Logger.info(p.toString());
        }

        // Determinar quién empieza atacando
        boolean turnoJugador1 = random.nextBoolean();
        Logger.info(turnoJugador1 ? "El sistema sorteó al Jugador 1 para iniciar la ronda."
                : "El sistema sorteó al Jugador 2 para iniciar la ronda.");

        // Iniciar rondas hasta que un jugador se quede sin personajes
        while (!jugador1Personajes.isEmpty() && !jugador2Personajes.isEmpty()) {
            jugarRonda(turnoJugador1);
            turnoJugador1 = !turnoJugador1; // Alternar quien ataca primero
        }

        if (jugador1Personajes.isEmpty()) {
            Logger.info("🎉 ¡Jugador 2 gana la partida! 🎉");
        } else {
            Logger.info("🎉 ¡Jugador 1 gana la partida! 🎉");
        }
    }

    private void jugarRonda(boolean turnoJugador1) {
        Logger.info("\n🔴 Nueva Ronda 🔴");

        // Seleccionar un personaje al azar de cada jugador
        Personaje p1 = jugador1Personajes.get(random.nextInt(jugador1Personajes.size()));
        Personaje p2 = jugador2Personajes.get(random.nextInt(jugador2Personajes.size()));

        Logger.info("El sistema eligió a " + p1.getNombre() + " (Jugador 1) y a " + p2.getNombre() + " (Jugador 2) para esta ronda.");

        int ataquesPorJugador = 7;
        boolean rondaFinalizada = false;

        while (ataquesPorJugador > 0 && !rondaFinalizada) {
            if (turnoJugador1) {
                rondaFinalizada = realizarAtaque(p1, p2);
            } else {
                rondaFinalizada = realizarAtaque(p2, p1);
            }
            ataquesPorJugador--;

            // Alternar turnos
            turnoJugador1 = !turnoJugador1;
        }

        if (p1.getSalud() <= 0) {
            Logger.info("💀 " + p1.getNombre() + " ha sido eliminado de la partida.");
            jugador1Personajes.remove(p1);
            mejorarPersonaje(p2);
        } else if (p2.getSalud() <= 0) {
            Logger.info("💀 " + p2.getNombre() + " ha sido eliminado de la partida.");
            jugador2Personajes.remove(p2);
            mejorarPersonaje(p1);
        } else {
            Logger.info("Ambos personajes sobreviven la ronda.");
        }
    }

    private boolean realizarAtaque(Personaje atacante, Personaje defensor) {
        if (random.nextDouble() < 0.2) { // 20% de probabilidad de evadir
            Logger.info("⚡ " + defensor.getNombre() + " esquiva el ataque de " + atacante.getNombre() + "!");
            return false;
        }

        int danio = calcularDanio(atacante, defensor);
        defensor.recibirDanio(danio);

        Logger.info("🔥 " + atacante.getNombre() + " ataca a " + defensor.getNombre() + " y le quita " + danio + " de salud.");
        Logger.info("💙 " + defensor.getNombre() + " ahora tiene " + defensor.getSalud() + " de salud.");

        return defensor.getSalud() <= 0; // Retorna true si el defensor ha sido derrotado
    }

    private int calcularDanio(Personaje atacante, Personaje defensor) {
        double baseDanio = ((atacante.getVelocidad() * atacante.getDestreza()) - defensor.getPoderDefensa()) / 500.0 * 100;

        switch (atacante.getClass().getSimpleName()) {
            case "Humano":
                return (int) baseDanio;
            case "Elfo":
                return (int) (baseDanio * 1.05);
            case "Orco":
                return (int) (baseDanio * 1.1);
            default:
                return (int) baseDanio;
        }
    }

    private void mejorarPersonaje(Personaje ganador) {
        int mejora = random.nextInt(3);

        switch (mejora) {
            case 0:
                ganador.setSalud(ganador.getSalud() + 10);
                Logger.info("🏆 " + ganador.getNombre() + " ha ganado +10 de salud, ahora tiene " + ganador.getSalud());
                break;
            case 1:
                ganador.setDestreza(ganador.getDestreza() + 2);
                Logger.info("🏆 " + ganador.getNombre() + " ha mejorado su destreza, ahora tiene " + ganador.getDestreza());
                break;
            case 2:
                ganador.setVelocidad(ganador.getVelocidad() + 2);
                Logger.info("🏆 " + ganador.getNombre() + " ha aumentado su velocidad, ahora tiene " + ganador.getVelocidad());
                break;
        }
    }
}
