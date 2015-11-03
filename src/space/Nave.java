/*
 * To change this license header, choose License Headers inimigos Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inimigos the editor.
 */
package space;

import java.awt.Color;
import java.awt.Font;
import java.util.ListIterator;
import jplay.*;

/**
 *
 * @author batista
 *
 */
public class Nave extends Sprite {

    public double live;//Vida quando a variavel resistencia zera ela é decrementada na classe controleInimigo
    public int resistencia;//Essa variavel decrementa 1 a cada asteroide que ele colide
    public double velocidade = 1.5;//Velocidade de movimentação da nave
    public double points = 0;
    boolean movendo = false;//variavel para saber se movimentando
    private int limiteTiros = 0;
    ControleTiro tiros = new ControleTiro();
    Scene cena;
    ControleInimigos conInimigos = new ControleInimigos();

    public Nave(int x, int y, Scene cena) {
        super(URL.sprite("naveAzul.png"));
        this.x = x;
        this.y = y;
        this.setTotalDuration(2000);
        this.cena = cena;
        live = 3;
    }

    public void updateCollisionNave() {//Método que verifica a colisão da nave com o asteroide 
        ListIterator<Inimigos> astit = ControleInimigos.inimigos.listIterator();
        while (astit.hasNext()) {
            GameObject asteroid = astit.next();
            if (this.collided(asteroid)) {
                System.out.println("Colisão da nave com o asteroide");
                System.out.println("Live" + live);
                if (--live == 0) {//Verifica se o live da nave é maior que 3, se não game over
                    System.exit(0);
                }
               // super(URL.sprite("naveAzul.png"));
                cena.removeOverlay(asteroid);
                new Sound(URL.audio("explosion.wav")).play();
                astit.remove();
            }
        }
    }
    
        public void updateCollisionNave2() {//Método que verifica a colisão da nave com o asteroide 
        ListIterator<Inimigos> astit = ControleInimigos.inimigos2.listIterator();
        while (astit.hasNext()) {
            GameObject asteroid = astit.next();
            if (this.collided(asteroid)) {
                System.out.println("Colisão da nave com o asteroide");
                System.out.println("Live" + live);
                if (--live == 0) {//Verifica se o live da nave é maior que 3, se não game over
                    System.exit(0);
                }
                cena.removeOverlay(asteroid);
                new Sound(URL.audio("explosion.wav")).play();
                astit.remove();
            }
        }
    }

    public void atirar(Window janela, Scene cena, Keyboard teclado, Inimigos inimigo) {//Método que adiciona o tiro
        if (teclado.keyDown(Keyboard.SPACE_KEY) && limiteTiros < 25) { //Pergunta se o limiteTiros atingiu o limite
            tiros.adicionaTiro(x + 110, y + 35, cena);
//            limiteTiros++; //Incrementa o limiteTiros
        }
//        if(points > 50){ //Ver se os pontos atigiram o record e add mais tiros
//            limiteTiros = 0;
//        } 
            
    }

    public void update(ControleInimigos inimigo, Nave nave) {//Chamada do método que verifica se o tiro colidiu com a nave
        tiros.updateCollsionShort(inimigo.inimigos, nave);
        tiros.updateCollsionShortsIni2(inimigo.inimigos2, nave);
    }

    Font font = new Font("Calibri", Font.TRUETYPE_FONT, 25);

    public void printPoints(Window janela) {//Método que printa na tela a quantidade de pontos e de vidas do jogador.
        janela.drawText("Pontos: " + (int) points, 30, 30, Color.WHITE, font);
      //  SalvarPontos.salvarPontos(points, "C:\\Users\\batista\\Documents\\NetBeansProjects\\space\\dist\\pontos.txt");
        janela.drawText("Live: " + (int) live, 190, 30, Color.WHITE, font);
       // SalvarPontos.resgatar("C:\\Users\\batista\\Documents\\NetBeansProjects\\space\\dist\\pontos.txt");
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
