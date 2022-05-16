package model.remanencia;

import java.util.ArrayList;

public interface persistencia <T>{
    T find(String who);
    void update(int id,T dato);
    void delete(int id);
    boolean add(T dato);
    void saveAll(ArrayList<T> lista);
     ArrayList<T> loadAll();
}
