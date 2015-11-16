package space;

import java.awt.event.KeyEvent;
import java.util.List;
import jplay.*;

public class Ranking {

      private Window janela;
    private GameImage imgMenu;
    private Keyboard teclado;
    private boolean sair;
    private Player player;
    private List<Player> ranking;

    public Ranking() {
        this.janela = Main.janela;
        this.teclado = janela.getKeyboard();
        this.player = new Player();
        sair = true;
        int cont = 0;
        while (sair) {
            imgMenu = new GameImage(URL.sprite("Ranking.png"));
            imgMenu.draw();
            if (cont < 1){
            player.printRanking(janela);
            janela.update();
            cont++;
            }
            
            if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                sair = false;
            }

        }

    }

    public void print(Window janela) {
        player.printRanking(janela);

    }
}
