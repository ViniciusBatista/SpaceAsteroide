package space;

import java.awt.event.KeyEvent;
import jplay.*;

public class Ranking {

    private Window janela;
    private GameImage imgMenu;
    private Keyboard teclado;
    private boolean sair;

    public Ranking() {
        this.janela = Main.janela;
        this.teclado = janela.getKeyboard();
        sair = true;
        while (sair) {
            imgMenu = new GameImage(URL.sprite("Ranking.png"));
            imgMenu.draw();
            janela.update();

            if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                sair = false;
            }

        }

    }

}
