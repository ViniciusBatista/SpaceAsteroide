/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.Random;
import javax.swing.JOptionPane;
import jplay.Sprite;
import jplay.URL;

/**
 *
 * @author batista
 */
public class ObjInimigos extends Sprite {

    private double velocidade = 0.3;
    public double energia  = 100;
//    public double energia = 1000;
    private boolean movendo = false;
    private final int yPos;

    private int geraY(){
        Random gerador = new Random();
        int valor = gerador.nextInt(640);
        return valor;
    }
    
    public ObjInimigos() {
        super(URL.sprite("asteroide1.png"));
        yPos = geraY();
        this.x = 1200;
        this.y = yPos;
        this.setTotalDuration(2000);
    }
    
       public void morrer (){
        if (energia <= 0){
            this.velocidade = 0;
            //this.ataque = 0;
            this.movendo = false;
            this.x = 1000000;
        }
    }

    public void movendo() {
        this.x -= velocidade;
        movendo = true;

        if (movendo) {
            update();
            movendo = false;

        }

    }

}
