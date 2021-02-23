package com.company;

// Servez vous la mif ;) faites gaffe à pas tout copier tel quel,
// j'ai fait un peu de zèle ça va se voir !
// ( Notamment les noms des variables et les tous les setBounds(x;y;width;height) )
// En modifiant les setbounds vous pouvez refaire une fenêtre à votre sauce !

// Enjoy ;)

import javax.print.attribute.standard.JobImpressions;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.Graphics;

public class MaFenetre extends JFrame {

    private JButton quit;
    private JLabel labcb;
    private JLabel textBDF;
    private JList listDeduits;
    private JComboBox listBDF;
    private JLabel faitsDeduits;
    private Vector<Vector<String>> tablData;
    private Vector<String> colonnes;
    private Vector<String> data1;
    private Vector<String> data2;
    private JTable table;
    private JButton chainAvant;
    private JButton chainArriere;
    private JTextField field;


    public MaFenetre(String s){
        super(s);

        int width = 800;
        int height = 500;

        setSize(width, height);
        setLayout(null); // gestion absolue des coordonnées
                        // des composants dans la JFrame
        quit = new JButton("Quitter"); // positionnement et dimt manuel du bouton
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

        listBDF = new JComboBox(bookTitles);
        listBDF.setBounds(width/10, 40+height/10, 200, 50);
        getContentPane().add(listBDF);

        labcb = new JLabel(bookTitles[0]);
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

        textBDF = new JLabel("Base de Faits");
        textBDF.setBounds(width/10, height/10, 200, 50);
        getContentPane().add(textBDF);

        listDeduits = new JList();
        listDeduits.setBounds(width/2, 50+height/10, 200, 50);
        getContentPane().add(listDeduits);

        faitsDeduits = new JLabel("Faits Déduits");
        faitsDeduits.setBounds(width/2, height/10, 200, 50);
        getContentPane().add(faitsDeduits);

        // Initulé des colonnes
        colonnes = new Vector<String>();
        colonnes.add("Nom"); colonnes.add("Prénom"); colonnes.add("Age");

        // Contenu de la table
        tablData = new  Vector<Vector<String>>();
        data1 = new Vector<String>();
        data1.add("Arthur"); data1.add("Louedec"); data1.add("62");
        data2 = new Vector<String>();
        data2.add("Glenn"); data2.add("Louradou"); data2.add("22");
        tablData.add(data1);tablData.add(data2);

        table = new JTable(tablData, colonnes);
        JScrollPane pane = new JScrollPane(table);
        pane.setBounds(width/10, height-height/3, 200+4*width/10, height/3-50);
        getContentPane().add(pane);

        JLabel textBDR = new JLabel("Base de Règles");
        textBDR.setBounds(width/10, height-height/3-50, 200, 50);
        getContentPane().add(textBDR);

        chainAvant = new JButton("Chaînage Avant");
        chainArriere = new JButton("Chaînage Arrière");
        chainAvant.setBounds(width-width/10-90, height/2, 150, 30);
        chainArriere.setBounds(width-width/10-90, 30+height/2, 150, 30);
        getContentPane().add(chainAvant);
        getContentPane().add(chainArriere);

        chainAvant.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Chainage Avant Pressed");
            }
        });
        chainArriere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Chainage Arriere Pressed");
            }
        });

        field = new JTextField();
        field.setBounds(width-width/10-90, 80+height/2, 150, 30);
        getContentPane().add(field);


        setVisible(true);
    }


}
