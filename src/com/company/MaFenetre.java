package com.company;

// Servez vous la mif ;) faites gaffe à pas tout copier tel quel,
// j'ai fait un peu de zèle ça va se voir !

import javax.print.attribute.standard.JobImpressions;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Vector;

public class MaFenetre extends JFrame {

    public MaFenetre(String s){
        super(s);

        int width = 800;
        int height = 500;

        setSize(width, height);
        setLayout(null); // gestion absolue des coordonnées
                        // des composants dans la JFrame
        JButton quit = new JButton("Quitter"); // positionnement et dimt manuel du bouton
        quit.setBounds(width-width/10-20, height-height/10-20, 80, 30);

        // traitement d'un clic sur le bouton
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
            });
        getContentPane().add(quit);



        String[] bookTitles = new String[] {"Effective Java","Head First Java","Thinking in Java","Débutez la programmation avec Java"};

        JComboBox listBDF = new JComboBox(bookTitles);
        listBDF.setBounds(width/10, 40+height/10, 200, 50);
        getContentPane().add(listBDF);

        JLabel labcb = new JLabel(bookTitles[1]);
        labcb.setBounds(width/10, 70+height/10, 200, 50);
        getContentPane().add(labcb);

        listBDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();

                Object selected = cb.getSelectedItem();
                labcb.setText("Selected: " + selected);
                String command = e.getActionCommand();
                System.out.println("Action Command: " + command);
            }
        });

        JLabel textBDF = new JLabel("Base de Faits");
        textBDF.setBounds(width/10, height/10, 200, 50);
        getContentPane().add(textBDF);

        JList listDeduits = new JList();
        listDeduits.setBounds(width/2, 50+height/10, 200, 50);
        getContentPane().add(listDeduits);

        JLabel faitsDeduits = new JLabel("Faits Déduits");
        faitsDeduits.setBounds(width/2, height/10, 200, 50);
        getContentPane().add(faitsDeduits);

        // Initulé des colonnes
        Vector<String> colonnes = new Vector<String>();
        colonnes.add("Nom"); colonnes.add("Prénom"); colonnes.add("Age");

        // Contenu de la table
        Vector<Vector<String>> tablData = new  Vector<Vector<String>>();
        Vector<String> data1 = new Vector<String>();
        data1.add("Arthur"); data1.add("Louedec"); data1.add("62");
        Vector<String> data2 = new Vector<String>();
        data2.add("Glenn"); data2.add("Louradou"); data2.add("22");
        tablData.add(data1);tablData.add(data2);

        JTable table = new JTable(tablData, colonnes);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(width/10, height-height/3, 200+4*width/10, height/3-50);
        getContentPane().add(pane);

        JLabel textBDR = new JLabel("Base de Règles");
        textBDR.setBounds(width/10, height-height/3-50, 200, 50);
        getContentPane().add(textBDR);

        JButton chainAvant = new JButton("Chainage Avant");
        JButton chainArriere = new JButton("Chainage Arrière");
        chainAvant.setBounds(width-width/10-90, height/2, 150, 30);
        chainArriere.setBounds(width-width/10-90, 30+height/2, 150, 30);
        getContentPane().add(chainAvant);
        getContentPane().add(chainArriere);

        JTextField field = new JTextField();
        field.setBounds(width-width/10-90, 80+height/2, 150, 30);
        getContentPane().add(field);





        setVisible(true);
    }

}
