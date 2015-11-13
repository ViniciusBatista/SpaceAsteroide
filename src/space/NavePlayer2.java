package space;

import java.awt.Color;
import java.awt.Font;
import jplay.Keyboard;
import jplay.Scene;
import jplay.Window;
import static space.Nave.points;

public class NavePlayer2 extends Nave{

    public NavePlayer2(int x, int y, Scene cena) {
        super(x, y, cena);
    }

    @Override
    public void updateCollisionNaveAsteroid1() {
        super.updateCollisionNaveAsteroid1();
    }

    @Override
    public void updateCollisionNaveAsteroid2() {
        super.updateCollisionNaveAsteroid2();
    }

    @Override
    public void atirar(Window janela, Scene cena, Keyboard teclado, Inimigos inimigo) {
        super.atirar(janela, cena, teclado, inimigo);
    }

    @Override
    public void update(ControleInimigos inimigo, Nave nave) {
        super.update();
    }

    Font font = new Font("Calibri", Font.TRUETYPE_FONT, 25);

    @Override
    public void printPoints(Window janela) {
        janela.drawText("Pontos: " + (int) points, 1180, 30, Color.WHITE, font);
        janela.drawText("Live: " + (int) live, 1240, 30, Color.WHITE, font);
    }

    @Override
    public void mover(Window janela, Keyboard teclado) {
        super.mover(janela, teclado);
    }

}
