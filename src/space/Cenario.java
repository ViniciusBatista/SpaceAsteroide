/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.event.KeyEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import jplay.*;

/**
 *
 * @author batista
 */
public class Cenario{

    private Window janela;
    private Scene cena;
    private NavePlayer1 nave1;
    //private final Nave nave;
    private Inimigo objInimigo;
    private Inimigo2 objInimigo2;
    private Keyboard teclado;
    private ControleInimigos ConIni;
    private Explosion explosion;
    private GameImage imgMenu;
    private boolean sair, pause, gameOver, Player2;
    private int menu, cont;

    public void Cenario() {
        this.cont = 4;
        this.janela = Main.janela;
        this.cena = new Scene();
        this.nave1 = new NavePlayer1(100, 280, cena, "naveAzul.png");
        this.cena.loadFromFile(URL.scenario("cenario.scn"));
        this.objInimigo = new Inimigo("asteroide1.png");
        this.objInimigo2 = new Inimigo2("asteroide2.png");
        this.teclado = janela.getKeyboard();
        this.explosion = new Explosion();
        this.ConIni = new ControleInimigos();
        
        ContagemRegressiva();
        
        Som.play("song.wav");

        run();
    }

    public void run() {
        sair = true;
        pause = true;
        gameOver = false;
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
                if (nave1.updateCollisionNaveAsteroid1() && !gameOver) {
                    LimparImgMenu();
                    gameOver = true;
                    pause = false;
                }
                if (nave1.updateCollisionNaveAsteroid2() && !gameOver) {
                    LimparImgMenu();
                    gameOver = true;
                    pause = false;
                }
                
                explosion.update();
                explosion.draw();

                janela.update();

                if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                    imgMenu = new GameImage(URL.sprite("telaFundo.png"));
                    imgMenu.draw();
                    menu = 0;
                    pause = false;
                }
            }

            switch (menu) {
                case 0:
                    LimparImgMenu();
                    if (gameOver) {
                        imgMenu = new GameImage(URL.sprite("GameOverAgain.png"));
                    } else {
                        imgMenu = new GameImage(URL.sprite("pauseSim.png"));
                    }
                    break;
                case 1:
                    LimparImgMenu();
                    if (gameOver) {
                        imgMenu = new GameImage(URL.sprite("GameOverSair.png"));
                    } else {
                        imgMenu = new GameImage(URL.sprite("pauseNao.png"));
                    }
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
                        if (gameOver) {
                            sair = false;
                        } else {
                            pause = true;
                        }
                        break;
                    case 1:
                        Som.stop();
                        ConIni.deleteAsteroide();
                        nave1.restart();
                        String nick = JOptionPane.showInputDialog(null, "Informe o Nick");
                        System.out.println("NICK: " + nick);
                        Conexao.execute(nick, 300);
                        gameOver = false;
                        sair = false;
                        break;
                }
            }

            imgMenu.draw();
            janela.update();
        }

        if (gameOver) {
            ConIni.deleteAsteroide(); //Deletar asteroids
            nave1.restart(); //Resetar os pontos
            String nick = JOptionPane.showInputDialog(null, "Informe o Nick");
            System.out.println("NICK: " + nick);
            Conexao.execute(nick, 300);
            gameOver = false;
            Cenario(); //Recomecar o jogo
        }

    }

    private void ContagemRegressiva() {
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
        if (gameOver) {
            imgMenu = new GameImage(URL.sprite("telaFundoGameOver.png"));
        } else {
            imgMenu = new GameImage(URL.sprite("telaFundo.png"));
        }
        imgMenu.draw();
    }

}
