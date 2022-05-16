import com.github.javafaker.Faker;
import controlador.controlador;
import model.remanencia.BaseDatos;
import vista.panatalla;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class Principal {
    static Faker f = new Faker();
    public static void main(String[] args) {
        ArrayList<Persona> lista = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            lista.add(new Persona(f.number().numberBetween(10,5000)
                    ,f.name().firstName()));
        }

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(""+lista.get(i).getId() + " and ");

        }
        Collections.sort(lista);

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(" |||"+lista.get(i).getId());

        }
//        write();
//        read();
    }

    class compara implements Comparator<Persona>
    {

        @Override
        public int compare(Persona o1, Persona o2) {
            return 0;
        }
    }
    static class Persona implements Comparable<Persona>{
        String name;
        Integer id;

        public Persona(int i, String firstName) {
            this.name = firstName;
            this.id = i;
        }

        @Override
        public int compareTo(Persona o) {
            if (id < o.getId()) {
                return -1;
            } else if (id > o.getId()) {
                return 1;
            } else {
                return 0;
            }
        }

        public Integer getId() {
            return id;
        }
    }















    public static void read(){
        File f = new File("archivo.csv");
        try {
            FileReader fr = new FileReader(f);
            BufferedReader br = new BufferedReader(fr);
            String linea;
            StringBuffer b = new StringBuffer();
            boolean isDone =false;
            while (!isDone)
            {
                    linea = br.readLine();
                    if (linea==null) isDone = true;
                    System.out.println(linea);

            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public static void write(){
        Faker faker = new Faker();
        File f = new File("archivo.csv");
        FileWriter fw = null;
        PrintWriter pw;
        try {
            fw = new FileWriter(f,true);
            pw = new PrintWriter(fw);
            for (int i = 0; i < 3; i++) {
                pw.println(faker.name().firstName() +  ","+faker.name().firstName() +"," + faker.name().firstName());

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
