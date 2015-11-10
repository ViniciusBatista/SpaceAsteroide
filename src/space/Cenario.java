/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.event.KeyEvent;
import jplay.*;

/**
 *
 * @author batista
 */
public class Cenario {

    private final Window janela;
    private final Scene cena;
    private final Nave nave;
    private Inimigo objInimigo;
    private Inimigo2 objInimigo2;
    private final Keyboard teclado;
    private final ControleInimigos ConIni;
    private Explosion explosion;

    private GameImage imgMenu;
    private boolean sair, pause;
    private int menu, cont;

    public Cenario(Window janela) {
        cont = 4;
        this.janela = janela;
        cena = new Scene();
        nave = new Nave(100, 280, cena);
        cena.loadFromFile(URL.scenario("cenario.scn"));
        objInimigo = new Inimigo("asteroide1.png");
        objInimigo2 = new Inimigo2("asteroide2.png");
        teclado = janela.getKeyboard();
        explosion = new Explosion();
        ConIni = new ControleInimigos();

//        while (cont > 0) {
//            try {
//                switch (cont) {
//                    case 4:
//                        imgMenu = new GameImage(URL.sprite("start3.png"));
//                        break;
//                    case 3:
//                        imgMenu = new GameImage(URL.sprite("start2.png"));
//                        break;
//                    case 2:
//                        imgMenu = new GameImage(URL.sprite("start1.png"));
//                        break;
//                    case 1:
//                        imgMenu = new GameImage(URL.sprite("startGo.png"));
//                        break;
//                }
//                imgMenu.draw();
//                janela.update();
//                Thread.sleep(1000);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(Cenario.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            cont--;
//        }
        Som.play("song.wav");
        run();
    }

    public void run() {
        sair = true;
        pause = true;
        menu = 0;
        while (sair) {
            while (pause) {

                cena.moveScene(nave);

                ConIni.inimigo(cena);
                ConIni.inimigo2(cena);

                nave.x += cena.getXOffset();
                nave.y += cena.getYOffset();
                nave.mover(janela, teclado);
                nave.atirar(janela, cena, teclado, objInimigo);
                nave.atirar(janela, cena, teclado, objInimigo2);
                nave.update(ConIni, nave);
                nave.printPoints(janela);
                nave.draw();
                nave.updateCollisionNave();
                nave.updateCollisionNave2();

                explosion.update();
                explosion.draw();

                janela.update();

                if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                    imgMenu = new GameImage(URL.sprite("telaFundoPause.png"));
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
                        sair = false;
                        break;

                }
            }
            
            imgMenu.draw();
            janela.update();
            
        }

    }
}
