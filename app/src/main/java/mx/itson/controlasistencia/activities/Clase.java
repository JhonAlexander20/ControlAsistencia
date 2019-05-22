package mx.itson.controlasistencia.activities;

public class Clase {
    int id;
    int id_maestro;
    String nombre;
    String aula;
    String hora;
    String duracion;
    String qr;

    public Clase(int id, int id_maestro, String nombre, String aula, String hora, String duracion, String qr) {
        this.id = id;
        this.id_maestro = id_maestro;
        this.nombre = nombre;
        this.aula = aula;
        this.hora = hora;
        this.duracion = duracion;
        this.qr = qr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_maestro() {
        return id_maestro;
    }

    public void setId_maestro(int id_maestro) {
        this.id_maestro = id_maestro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAula() {
        return aula;
    }

    public void setAula(String aula) {
        this.aula = aula;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getQr() {
        return qr;
    }

    public void setQr(String qr) {
        this.qr = qr;
    }
}
