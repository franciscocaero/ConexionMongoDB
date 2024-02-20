package org.example;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

import javax.swing.*;

public class Main {
    static JFrame frame=new JFrame("Ingreso de calificaciones");
    public static void main(String[] args) {

        frame.setContentPane(new Registro().regCal);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1040,780);

        frame.pack();
        frame.setVisible(true);


    }
}