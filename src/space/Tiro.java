/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import javax.swing.JOptionPane;
import jplay.Sprite;
import jplay.URL;

/**
 *
 * @author batista
 */
public class Tiro extends Sprite{
   
    protected static final int VELOCIDADE_TIRO = 2;
    protected boolean movendo = false;
    protected int direcao = 3;

 
    
    public Tiro(Double x, Double y) {
        super(URL.sprite("tiro_fogo2.png"), 4);
        this.x = x;
        this.y = y;
    }
    
    public void mover(){
        this.x += VELOCIDADE_TIRO;
        setSequence(1, 4);
        movendo = true;
        
        if (movendo){
            update();
            movendo = false;      
        }
    }
    
      
    }
    
