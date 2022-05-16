package vista;

import com.github.javafaker.Faker;
import conexiones.ControlToView;
import conexiones.ViewToControl;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;

public class panatalla extends JFrame implements ControlToView {
    JScrollPane scrollPanel;
    ViewToControl controlador;
    static int columnas = 5;
    static int filas = 1000;


    public panatalla(ViewToControl control) {
        this.controlador = control;

        init();
        setViews();
        initCaracteristics();
        showTable();

    }

    private void setViews() {
        add(new Menu_tabla(controlador), BorderLayout.NORTH);
        add(scrollPanel,BorderLayout.CENTER);
    }

    private void initCaracteristics() {
        setSize(500,500);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void init() {
        scrollPanel = new JScrollPane();

    }


    public void showTable(){


    }

    private ArrayList<ArrayList<Object>> TestgenerateData(){
        Faker f = new Faker();
        ArrayList<ArrayList<Object>> dat = new ArrayList<>();
        for (int i = 0; i < filas; i++) {
            dat.add(new ArrayList<>());
            for (int j = 0; j < columnas; j++) {
                dat.get(i).add(f.name().firstName());

            }

        }
        return dat;
    }

    private ArrayList<String> TestgenerateNombres(){
        Faker f = new Faker();
        ArrayList<String> names = new ArrayList<>();
        for (int i = 0; i < columnas; i++) {
            names.add(f.name().firstName());
        }
        return names;
    }


    @Override
    public void showTable(Object[][] datos, String[] titulos) {
        TableModel t = new TablaPersonalizada(datos,titulos);
        JTable tabla = new JTable(t);
        scrollPanel.setViewportView(tabla);
        revalidate();

    }
}
