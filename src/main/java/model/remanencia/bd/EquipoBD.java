package model.remanencia.bd;

import model.remanencia.bd.tablas.Equipo;
import model.remanencia.persistencia;

import java.util.ArrayList;

public class EquipoBD implements persistencia<Equipo> {
    @Override
    public Equipo find(String who) {
        return null;
    }

    @Override
    public void update(int id, Equipo dato) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public boolean add(Equipo dato) {
        return false;
    }

    @Override
    public void saveAll(ArrayList<Equipo> lista) {

    }

    @Override
    public ArrayList<Equipo> loadAll() {
        return null;
    }
}
