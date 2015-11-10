/*
 * To change this license header, choose License Headers inimigos Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template inimigos the editor.
 */
package space;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ListIterator;
import jplay.*;
import jplay.Window;

/*
 *
 * @author batista
 *
 */
public class Nave extends Sprite {

    public double live;//Vida quando a variavel resistencia zera ela é decrementada na classe controleInimigo
    public int resistencia;//Essa variavel decrementa 1 a cada asteroide que ele colide
    public double velocidade = 1.5;//Velocidade de movimentação da nave
    public static double points = 0;
    boolean movendo = false;//variavel para saber se movimentando
    ControleTiro tiros = new ControleTiro();//Objeto da classe controle de tiros
    Scene cena; //Objeto do tipo scene utilizado no construtor da classe nave

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
        if (teclado.keyDown(Keyboard.SPACE_KEY)) { //Pergunta se a tecla space esta precionada se sim atira
            tiros.adicionaTiro(x + 110, y + 35, cena);
        }

    }

    public void update(ControleInimigos inimigo, Nave nave) {//Chamada do método que verifica se o tiro colidiu com a nave
        tiros.updateCollsionShort(ControleInimigos.inimigos, nave);
        tiros.updateCollsionShortsIni2(ControleInimigos.inimigos2, nave);
    }

    Font font = new Font("Calibri", Font.TRUETYPE_FONT, 25);

    public void printPoints(Window janela) {//Método que printa na tela a quantidade de pontos e de vidas do jogador.
        janela.drawText("Pontos: " + (int) points, 30, 30, Color.WHITE, font);
        janela.drawText("Live: " + (int) live, 190, 30, Color.WHITE, font);
    }

    public void mover(Window janela, Keyboard teclado) {
        if (teclado.keyDown(KeyEvent.VK_LEFT)) {
            if (this.x > 0) {
                this.x -= velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(KeyEvent.VK_RIGHT)) {
            if (this.x < janela.getWidth() - 800) {
                this.x += velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(KeyEvent.VK_UP)) {
            if (this.y > 0) {
                this.y -= velocidade;
            }
            movendo = true;
        } else if (teclado.keyDown(KeyEvent.VK_DOWN)) {
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
