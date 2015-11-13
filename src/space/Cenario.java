/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import jplay.*;

/**
 *
 * @author batista
 */
public class Cenario {

    private static Window janela;
    public static Scene cena;
    private final NavePlayer1 nave1;
    public static Inimigo objInimigo;
    public static Inimigo2 objInimigo2;
    private final Keyboard teclado;
    public static  ControleInimigos ConIni;
    private Explosion explosion;

    private GameImage imgMenu;
    private boolean sair, pause;
    private int menu, cont;

    public Cenario(Window janela) {
        cont = 4;
        Cenario.janela = janela;
        cena = new Scene();
        nave1 = new NavePlayer1(100, 280, cena);
        cena.loadFromFile(URL.scenario("cenario.scn"));
        objInimigo = new Inimigo("asteroide1.png");
        objInimigo2 = new Inimigo2("asteroide2.png");
        teclado = janela.getKeyboard();
        explosion = new Explosion();
        ConIni = new ControleInimigos();

        ContagemRegressiva();

        Som.play("song.wav");
        run();
    }

    public void run() {
        sair = true;
        pause = true;
        menu = 0;
        while (sair) {
            while (pause) {
                cena.moveScene(nave1);

                ConIni.inimigo(cena);
                ConIni.inimigo2(cena);

                nave1.x += cena.getXOffset();
                nave1.y += cena.getYOffset();
                nave1.mover(janela, teclado);
                nave1.atirar(janela, cena, teclado, objInimigo);
                nave1.atirar(janela, cena, teclado, objInimigo2);
                nave1.update(ConIni, nave1);
                nave1.printPoints(janela);
                nave1.draw();
                nave1.updateCollisionNaveAsteroid1();
                nave1.updateCollisionNaveAsteroid2();

                explosion.update();
                explosion.draw();

                janela.update();

                if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                    imgMenu = new GameImage(URL.sprite("telaFundo.png"));
                    imgMenu.draw();
                    janela.update();
                    menu = 0;
                    pause = false;
                }
            }

            switch (menu) {
                case 0:
                    imgMenu = new GameImage(URL.sprite("pauseSim.png"));
                    break;
                case 1:
                    imgMenu = new GameImage(URL.sprite("pauseNao.png"));
                    break;
            }

            if (teclado.keyDown(KeyEvent.VK_RIGHT)) {
                menu = 1;
            }
            if (teclado.keyDown(KeyEvent.VK_LEFT)) {
                menu = 0;
            }
            if (teclado.keyDown(KeyEvent.VK_ENTER)) {
                switch (menu) {
                    case 0:
                        pause = true;
                        break;
                    case 1:
                        Som.stop();
                        sair = false;
                        ConIni.deleteAsteroide();
                        break;

                }
            }

            imgMenu.draw();
            janela.update();

        }

    }

    private void ContagemRegressiva(){
        while (cont > 0) { // Contagem regressiva para o inicio do game
            try {
                switch (cont) {
                    case 4:
                        LimparImgMenu();
                        imgMenu = new GameImage(URL.sprite("start3.png"));
                        break;
                    case 3:
                        LimparImgMenu();
                        imgMenu = new GameImage(URL.sprite("start2.png"));
                        break;
                    case 2:
                        LimparImgMenu();
                        imgMenu = new GameImage(URL.sprite("start1.png"));
                        break;
                    case 1:
                        LimparImgMenu();
                        imgMenu = new GameImage(URL.sprite("startGo.png"));
                        break;
                }
                imgMenu.draw();
                janela.update();
                Thread.sleep(500); //Tempo em espera
            } catch (InterruptedException ex) {
                Logger.getLogger(Cenario.class.getName()).log(Level.SEVERE, null, ex);
            }
            cont--;
        }
    }
    
    private void LimparImgMenu() {
        cena.moveScene(nave1);
        nave1.draw();
        imgMenu = new GameImage(URL.sprite("telaFundo.png"));
        imgMenu.draw();
    }

}
