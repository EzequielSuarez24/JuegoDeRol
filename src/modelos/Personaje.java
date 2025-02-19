package modelos;

public abstract class Personaje {
    protected String nombre;
    protected String tipo;
    protected String apodo;
    protected int velocidad;
    protected int destreza;
    protected int fuerza;
    protected int nivel;
    protected int salud;
    protected int poderDefensa;

    // Constructor
    public Personaje(String nombre, String tipo, String apodo, int velocidad, int destreza, int fuerza, int nivel, int salud, int poderDefensa) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.apodo = apodo;
        this.velocidad = velocidad;
        this.destreza = destreza;
        this.fuerza = fuerza;
        this.nivel = nivel;
        this.salud = salud;
        this.poderDefensa = poderDefensa;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getDestreza() {
        return destreza;
    }

    public void setDestreza(int destreza) {
        this.destreza = destreza;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public int getSalud() {
        return salud;
    }

    public void setSalud(int salud) {
        this.salud = Math.max(salud, 0); // Evita que la salud sea negativa
    }

    public int getPoderDefensa() {
        return poderDefensa;
    }

    public void setPoderDefensa(int poderDefensa) {
        this.poderDefensa = poderDefensa;
    }

    // Método para recibir daño
    public void recibirDanio(int danio) {
        this.salud = Math.max(this.salud - danio, 0);
    }

    // Método toString para mostrar la información del personaje
    @Override
    public String toString() {
        return "Nombre: " + nombre + " | Tipo: " + tipo + " | Apodo: " + apodo +
                " | Velocidad: " + velocidad + " | Destreza: " + destreza +
                " | Fuerza: " + fuerza + " | Nivel: " + nivel + " | Salud: " + salud +
                " | Defensa: " + poderDefensa;
    }
}
