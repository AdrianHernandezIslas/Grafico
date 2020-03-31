/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.grafico;

import java.awt.Graphics;
import java.io.Serializable;
import java.awt.Color;
import javax.swing.JComponent;
import javax.swing.JLabel;

/**
 *
 * @author adrian
 */
public class Grafico extends JComponent implements Serializable{

    private int nfiguras;
    private JLabel [] etis;
    private int valo[] = {10,20,30,40};
    private static Color color[] = {Color.BLUE, Color.BLACK, Color.CYAN, Color.GREEN, Color.MAGENTA,
                                    Color.YELLOW, Color.ORANGE, Color.RED, Color.DARK_GRAY, Color.PINK};
    private static JLabel leyendaBarra[];
    private static JLabel colorB[];
    private JLabel titulo;
    private String tTitulo = "Este es un titulo";;
    private String tLeyenda[];
    
    public Grafico(){
       tLeyenda = new String[]{"Leyenda 1","Leyenda 2","Leyenda 3","Leyenda 4"};
       iniciarElementos();
        
    }
    
    //Constructor, pasamos como valores titulo del grafico y leyendas, y valores por omision
    public Grafico(String encabezado, String[] tLeyenda){
        this.tLeyenda = tLeyenda;
        tTitulo = encabezado;
    }
    
            
    @Override
    public void paintComponent(Graphics f) {
        titulo.setBounds((int)((getWidth()-f.getFontMetrics().stringWidth(titulo.getText()))/2), 10, f.getFontMetrics().stringWidth(titulo.getText())*2,20);
        
        int ancho = getWidth();
        int alto = getHeight();
        
        int separa = (int) (ancho / (nfiguras)*0.10);
        int anchoB = (int) (ancho / (nfiguras)*0.9);
        int fila = 70,columna = 45;
        
        for (int k = 0; k < nfiguras; k++) {
            f.setColor(color[k]);
            etis[k].setBounds(separa+k*(anchoB+separa)+(anchoB/2), (alto-100-valo[k]), 30, 20);
            f.fill3DRect(separa+k*(anchoB+separa), (alto-80-valo[k]), anchoB, valo[k], true);
            
            f.fill3DRect(columna-20, alto-fila,15 , 15, true);
            leyendaBarra[k].setBounds(columna, alto-fila,70 , 15);
            fila-=20;
            
            if((k % 2 == 0) && k != 0){
                columna += 115;
                fila = 70;
            }
        }   
        
        
    }
    
    public void iniciarElementos(){
        
        titulo = new JLabel(tTitulo);
        nfiguras = valo.length;
        etis = new JLabel[valo.length];
        leyendaBarra = new JLabel[valo.length];
        
        for (int i = 0; i < nfiguras; i++) {
           etis[i] = new JLabel(String.valueOf(valo[i]));
           leyendaBarra[i] = new JLabel(tLeyenda[i]);
           add(leyendaBarra[i]);
           add(etis[i]);
            
        }
        add(titulo);
    }
    
    //Metodos Get y Set
    public void setLeyendas(String[] tLeyenda){
        this.tLeyenda = tLeyenda;
        iniciarElementos();
    }
    
    public void setTitulo(String encabezado){
        titulo.setText(tTitulo);
    }
    
    public void setValores(int valores[]){
       valo = valores;
       iniciarElementos();
    }
    
}
