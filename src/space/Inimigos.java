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
    public double energia = 1;
    private boolean movendo = false;
    private final int yPos;

    private int geraY() {
        Random gerador = new Random();
        int valor = gerador.nextInt(640);
        return valor;
    }

    public Inimigos(String img) {
        super(URL.sprite(img));
        yPos = geraY();
        this.x = 1300;
        this.y = yPos;
        this.setTotalDuration(2000);
//        if(MenuDificuldades.dificuldade == 1){ //dificuldade facil
            this.velocidade = 0.5;
//        }else{
//            if(MenuDificuldades.dificuldade == 2){ //dificuldade medio
//                this.velocidade = 1;
//            }else{
//                if(MenuDificuldades.dificuldade == 3){ //dificuldade dificil
//                    this.velocidade = 1.2;
//                }
//            }
//        }
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
