package vista;

import conexiones.ViewToControl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu_tabla extends JPanel implements ActionListener {

    JButton borrar,actualizar,buscar,introducir;
    JTextField textField;
    ViewToControl control;

    public Menu_tabla(ViewToControl controlador) {

        control = controlador;
        init();
        listeners();

        setLayout(new GridLayout());
        add(borrar);
        add(actualizar);
        add(introducir);
        add(buscar);
        add(textField);
    }
    private void init(){
        borrar = new JButton("BORARR");
        actualizar = new JButton("ACTUALIZAR");
        introducir = new JButton("INTRODUCIR");
        buscar = new JButton("BUSCAR");
        textField = new JTextField(30);
    }

    private void listeners() {
        borrar.addActionListener(this);
        borrar.setActionCommand("d");
        actualizar.addActionListener(this);
        actualizar.setActionCommand("u");
        introducir.addActionListener(this);
        introducir.setActionCommand("i");
        buscar.addActionListener(this);
        buscar.setActionCommand("f");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        switch (action){
            case "d":
                control.delete(0);
                JOptionPane.showMessageDialog(this,"Has borrado");
                System.out.println("Has señalado borrar");
                break;
            case "i":
                control.insert(2);
                System.out.println("has señalada insertar");
                break;
            case "u":
                control.update(0);
                System.out.println("has señalado update ");
                break;
            case "f":
                control.find(textField.getText());
                System.out.println("has señalada find");
                break;

        }


    }
}
