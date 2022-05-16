package model.remanencia;

import model.remanencia.bd.FutbolistaBD;
import model.remanencia.bd.tablas.Futbolista;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class BaseDatos  {
    FutbolistaBD bd_futbolista;
    public void initAll(){

    }

    public BaseDatos() {
        this.bd_futbolista = new FutbolistaBD();

    }
    public ArrayList<Futbolista> getAllFutbolistas(){

        return this.bd_futbolista.loadAll();
    }

}
