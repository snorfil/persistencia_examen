package model.remanencia.bd;

import model.remanencia.bd.tablas.Socio;
import model.remanencia.persistencia;

import java.util.ArrayList;

public class SocioBD implements persistencia<Socio> {
    @Override
    public Socio find(String who) {
        return null;
    }

    @Override
    public void update(int id, Socio dato) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean add(Socio dato) {
        return false;
    }

    @Override
    public void saveAll(ArrayList<Socio> lista) {

    }

    @Override
    public ArrayList<Socio> loadAll() {
        return null;
    }
}
