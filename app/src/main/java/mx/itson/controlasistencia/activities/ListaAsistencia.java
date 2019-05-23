package mx.itson.controlasistencia.activities;

public class ListaAsistencia {
    private int id;
    private int id_maestro;
    private int id_clase;
    private String fecha;

    public ListaAsistencia(int id, int id_maestro, int id_clase, String fecha) {
        this.setId(id);
        this.setId_maestro(id_maestro);
        this.setId_clase(id_clase);
        this.setFecha(fecha);
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

    public int getId_clase() {
        return id_clase;
    }

    public void setId_clase(int id_clase) {
        this.id_clase = id_clase;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
}
