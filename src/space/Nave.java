/*
 * To change this license header, choose License Headers inimigos Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inimigos the editor.
 */
package space;

import jplay.Keyboard;
import jplay.Scene;
import jplay.Sprite;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author batista
 *
 */
public class Nave extends Sprite {

    public static double life = 1000;
    public double velocidade = 1;
    boolean movendo = false;
    ControleTiro tiros = new ControleTiro();
//    ControleInimigos inimigos = new ControleInimigos();
//    private int cont = 0;

    public Nave(int x, int y) {
        super(URL.sprite("nave.png"));
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
    }
//
//    public void inimigo(Scene cena) {
//        if (cont < 500) {
//            cont++;
//        } else {
//            inimigos.adicionaInimigo(cena);
//            cont = 0;
//        }
//        inimigos.run();
//    }
    public void atirar(Window janela, Scene cena, Keyboard teclado, ObjInimigos inimigo) {
        if (teclado.keyDown(Keyboard.SPACE_KEY)) {
            tiros.adicionaTiro(x + 110, y + 35, cena);
        }
    }
    
    public void update(ControleInimigos inimigo){
        tiros.update(inimigo.inimigos);
    }

    public void mover(Window janela, Keyboard teclado) {
        if (teclado.keyDown(Keyboard.LEFT_KEY)) {
            if (this.x > 0) {
                this.x -= velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.RIGHT_KEY)) {
            if (this.x < janela.getWidth() - 800) {
                this.x += velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.UP_KEY)) {
            if (this.y > 0) {
                this.y -= velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(Keyboard.DOWN_KEY)) {
            if (this.y < janela.getHeight() - 110) {
                this.y += velocidade;
            }
            movendo = true;
        }
        if (movendo) {
            update();
            movendo = false;
        }
    }

}
