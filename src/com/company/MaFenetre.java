package com.company;

import javax.print.attribute.standard.JobImpressions;
import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;

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

        listBDF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox) e.getSource();

                Object selected = cb.getSelectedItem();
                System.out.println("Selected: " + selected);
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

        JTable table = new JTable();
        table.setBounds(width/10, height-height/3, 200+4*width/10, height/3-50);
        getContentPane().add(table);

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
