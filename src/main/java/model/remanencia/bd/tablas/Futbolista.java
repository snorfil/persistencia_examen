package model.remanencia.bd.tablas;

public class Futbolista {

    private final int id;
    private final String nombre;
    private final int birth;
    private final String apellido;
    private final float idequipo;
    private final int dorsal;
    private final String mote;

    public Futbolista(int idFutbolista, int anioNacimiento, String apellido, int dorsal, float idEquipo, String mote, String nombre) {
        this.id = idFutbolista;
        this.birth = anioNacimiento;
        this.apellido = apellido;
        this.dorsal = dorsal;
        this.idequipo = idEquipo;
        this.mote  = mote;
        this.nombre = nombre;



    }
}
