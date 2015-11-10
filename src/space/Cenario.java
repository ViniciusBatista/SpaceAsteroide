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
    private int menu;

    public Cenario(Window janela) {
        this.janela = janela;
        cena = new Scene();
        nave = new Nave(100, 280, cena);

        cena.loadFromFile(URL.scenario("cenario.scn")); //Só para testes esse não sera o cenario do jogo

        objInimigo = new Inimigo("asteroide1.png");
        objInimigo2 = new Inimigo2("asteroide2.png");
        cena.loadFromFile(URL.scenario("cenario.scn"));//Só para testes esse não sera o cenario do jogo

        teclado = janela.getKeyboard();
        explosion = new Explosion();
        ConIni = new ControleInimigos();
        Som.play("song.wav");

        run();
    }

    public void run() {
        sair = true;
        pause = true;
        while (sair) {
            while (pause) {
                //cena.draw();

                cena.moveScene(nave);

                nave.x += cena.getXOffset();
                nave.y += cena.getYOffset();
                nave.mover(janela, teclado);
                nave.atirar(janela, cena, teclado, objInimigo);
                nave.atirar(janela, cena, teclado, objInimigo2);

                nave.update(ConIni, nave);
                nave.printPoints(janela);

                nave.draw();
                ConIni.inimigo(cena);
                ConIni.inimigo2(cena);
                nave.updateCollisionNave();
                nave.updateCollisionNave2();

                explosion.update();
                explosion.draw();

                sair = true;
                pause = true;
                menu = 0;
                while (sair) {
                    while (pause) {
                        //cena.draw();

                        cena.moveScene(nave);

                        nave.x += cena.getXOffset();
                        nave.y += cena.getYOffset();
                        nave.mover(janela, teclado);
                        nave.atirar(janela, cena, teclado, objInimigo);
                        nave.atirar(janela, cena, teclado, objInimigo2);

                        nave.update(ConIni, nave);
                        nave.printPoints(janela);
                        nave.draw();
                        ConIni.inimigo(cena);
                        ConIni.inimigo2(cena);
                        nave.updateCollisionNave();
                        nave.updateCollisionNave2();

                        explosion.update();
                        explosion.draw();

//            ConIni.update(nave);
//            objInimigo.draw();
                        //janela.delay(1);
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
    }
}
