package controlador;

import conexiones.ControlToModel;
import conexiones.ControlToView;
import conexiones.ModelToControl;
import conexiones.ViewToControl;
import model.Modelo;
import model.remanencia.bd.tablas.Equipo;
import model.remanencia.bd.tablas.Futbolista;
import vista.panatalla;

import java.util.ArrayList;

public class controlador implements ViewToControl, ModelToControl {
    ControlToView vista;
    ControlToModel model;

    public controlador() {
        this.model = new Modelo(this);
        this.vista = new panatalla(this);
        model.getAll("af");
    }


    @Override
    public void find(String text) {

    }

    @Override
    public void update(int i) {

    }

    @Override
    public void insert(int i) {

    }

    @Override
    public void delete(int i) {

    }

    @Override
    public void showTable(ArrayList<Object> tabla) {
        Object dato = tabla.get(0);
        if (dato instanceof Equipo)
        {

        }else if(dato instanceof Futbolista)
        {

        }
        else {

        }
    }
}
