package model;

import conexiones.ControlToModel;
import conexiones.ModelToControl;
import model.remanencia.BaseDatos;
import model.remanencia.bd.tablas.Futbolista;
import model.remanencia.files.Ficheros;

import javax.jws.Oneway;
import java.util.ArrayList;

public class Modelo implements ControlToModel {
    BaseDatos baseDatos;
    Ficheros ficheros;
    ModelToControl control;

    public Modelo(ModelToControl control) {
        baseDatos = new BaseDatos();
        this.control = control;
    }


    @Override
    public void getAll(String tablaName) {
            control.showTable(new ArrayList<>( baseDatos.getAllFutbolistas()));
    }
}
