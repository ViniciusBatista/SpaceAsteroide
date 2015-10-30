/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.Random;
import jplay.*;

/**
 *
 * @author batista
 */
public class Inimigos extends Sprite {

    private double velocidade = 0.8;
    public double energia = 100;
    private boolean movendo = false;
    private final int yPos;

    private int geraY() {
        Random gerador = new Random();
        int valor = gerador.nextInt(640);
        return valor;
    }

    public Inimigos() {
        super(URL.sprite("asteroide1.png"));
        yPos = geraY();
        this.x = 1200;
        this.y = yPos;
        this.setTotalDuration(2000);
        if(MenuDificuldades.dificuldade == 1){
            this.velocidade = 0.6;
        }else{
            if(MenuDificuldades.dificuldade == 2){
                this.velocidade = 1;
            }else{
                if(MenuDificuldades.dificuldade == 3){
                    this.velocidade = 1.3;
                }
            }
        }
    }

    public void morrer() {
        if (energia <= 0) {
            this.velocidade = 0;
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
