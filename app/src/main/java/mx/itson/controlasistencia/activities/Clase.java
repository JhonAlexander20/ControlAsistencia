package mx.itson.controlasistencia.activities;

public class Clase {
    int id;
    int id_maestro;
    String nombre;
    String aula;
    String hora_inicio;
    String duracion;
    String carrera;
    String dias;
    String qr;

    public Clase(int id, int id_maestro, String nombre, String aula, String hora_inicio, String duracion, String carrera, String dias, String qr) {
        this.id = id;
        this.id_maestro = id_maestro;
        this.nombre = nombre;
        this.aula = aula;
        this.hora_inicio = hora_inicio;
        this.duracion = duracion;
        this.carrera = carrera;
        this.dias = dias;
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

    public String getHora_inicio() {
        return hora_inicio;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
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

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public String getDias() {
        return dias;
    }

    public void setDias(String dias) {
        this.dias = dias;
    }
}
