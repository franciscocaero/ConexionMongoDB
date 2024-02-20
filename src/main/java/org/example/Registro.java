package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registro {
    public JPanel regCal;
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    private JTextField textField4;
    private JLabel Calificacion1;
    private JLabel Calificacion2;
    private JLabel Apellidos;
    private JLabel Nombres;
    private JButton ingresarButton;
    private JButton modificarButton;

    public Registro() {
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre=textField1.getText();
                String apellido=textField2.getText();
                float cal1=Float.parseFloat(textField3.getText());
                float cal2=Float.parseFloat(textField4.getText());
                ingresoDatos(nombre,apellido,cal1,cal2);
                JOptionPane.showMessageDialog(null, "Datos insertados exitosamente");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
                textField4.setText("");

            }
        });
        modificarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JFrame frame2=new JFrame("Modificacion de calificaciones");
                frame2.setContentPane(new ModCalif().modifica);
                frame2.setLocationRelativeTo(null);
                frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame2.setSize(1040,780);
                frame2.pack();
                frame2.setVisible(true);
                Main.frame.dispose();
            }
        });
    }

    public static void ingresoDatos(String nombre, String apellido, float cal1, float cal2){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");


        MongoDatabase database = mongoClient.getDatabase("mydb2");
        MongoCollection<Document> collection = database.getCollection("notas");


        Document document = new Document("Nombres", nombre)
                .append("Apellidos", apellido)
                .append("Calificación 1", cal1)
                .append("Calificación 2",cal2);

        collection.insertOne(document);
        System.out.println("Documento insertado");

    }
}
