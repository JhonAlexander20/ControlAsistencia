package mx.itson.controlasistencia.activities;

public class ListaAsistenciaAlumno {
    private int id;
    private int id_lista;
    private int id_alumno;
    private String estado;

    public ListaAsistenciaAlumno(int id, int id_lista, int id_alumno, String estado) {
        this.id = id;
        this.id_lista = id_lista;
        this.id_alumno = id_alumno;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_lista() {
        return id_lista;
    }

    public void setId_lista(int id_lista) {
        this.id_lista = id_lista;
    }

    public int getId_alumno() {
        return id_alumno;
    }

    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
