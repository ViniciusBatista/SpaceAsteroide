package space;

import java.awt.Color;
import java.awt.Font;
import jplay.*;

import static space.Nave.points;

public class NavePlayer1 extends Nave {

    public NavePlayer1(int x, int y, Scene cena, String tipoNave) {
        super(x, y, cena, tipoNave);
    }

    @Override
    public void updateCollisionNaveAsteroid1() {//Método que verifica a colisão da nave com o asteroide 
        super.updateCollisionNaveAsteroid1();
    }

    @Override
    public void updateCollisionNaveAsteroid2() {//Método que verifica a colisão da nave com o asteroide 
        super.updateCollisionNaveAsteroid2();
    }

    @Override
    public void atirar(Window janela, Scene cena, Keyboard teclado, Inimigos inimigo) {//Método que adiciona o tiro
        super.atirar(janela, cena, teclado, inimigo);
    }
    @Override
    public void restart(){
        super.restart();
    }
    
    public void update(ControleInimigos inimigo, NavePlayer1 nave1) {//Chamada do método que verifica se o tiro colidiu com a nave
        tiros.updateCollsionShort(ControleInimigos.inimigos, nave1);
        tiros.updateCollsionShortsIni2(ControleInimigos.inimigos2, nave1);
    }

    Font font = new Font("Calibri", Font.TRUETYPE_FONT, 25);
    @Override
    public void printPoints(Window janela) {//Método que printa na tela a quantidade de pontos e de vidas do jogador.
        janela.drawText("Pontos: " + (int) points, 30, 30, Color.WHITE, font);
        janela.drawText("Live: " + (int) live, 190, 30, Color.WHITE, font);
    }

    @Override
    public void mover(Window janela, Keyboard teclado) {
        super.mover(janela, teclado);
    }
}
