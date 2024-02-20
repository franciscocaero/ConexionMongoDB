package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ModCalif {
    public JPanel modifica;
    private JTextField textField1;
    private JLabel BuscApel;
    private JTextField textField2;
    private JTextField textField3;
    private JLabel Calificacion1;
    private JLabel Calificacion2;
    private JButton realizarLaModificaciónButton;

    public ModCalif() {
        realizarLaModificaciónButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String apellido=textField1.getText();
                float cal1=Float.parseFloat(textField2.getText());
                float cal2=Float.parseFloat(textField3.getText());
                modifDatos(apellido,cal1,cal2);
                JOptionPane.showMessageDialog(null, "Datos modificados exitosamente");
                textField1.setText("");
                textField2.setText("");
                textField3.setText("");
            }
        });
    }

    public static void modifDatos(String apellido, float cal1, float cal2){
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = mongoClient.getDatabase("mydb2");
        MongoCollection<Document> collection = database.getCollection("notas");

        Document filtro=new Document("Apellidos",apellido);  //Para realizar la actualizacion, se busca por los apellidos
        Document nuevasNotas = new Document()
                .append("Calificación 1", cal1)
                .append("Calificación 2",cal2);
        Document update = new Document("$set", nuevasNotas);
        collection.updateOne(filtro,update);

    }
}
