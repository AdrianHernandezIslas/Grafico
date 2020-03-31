package com.grafico;

import java.awt.FlowLayout;
import java.awt.HeadlessException;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author adrian
 */
public class Vista extends JFrame{
    
    private Grafico grafico = new Grafico("Titulo OTRO",new String[]{"Chingadera","LimonPuto"});

    public Vista()  {
        super();
        setSize(800, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        grafico.setValores(new int[]{500,600});
        grafico.iniciarElementos();
        add(grafico);
        setVisible(true);
        
    }
    
    
    
}
