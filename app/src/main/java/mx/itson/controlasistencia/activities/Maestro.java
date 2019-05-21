package mx.itson.controlasistencia.activities;

public class Maestro {

    private int id;
    private String telefono, contrasena;

    public Maestro(int id, String telefono, String contrasena) {
        this.id = id;
        this.telefono = telefono;
        this.contrasena = contrasena;
    }

    public int getId() {
        return id;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getContrasena() {
        return contrasena;
    }
}
