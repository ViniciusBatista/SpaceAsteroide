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
public class Cenario {

    private Window janela;
    public static Scene cena;
    private final NavePlayer1 nave1;
   // private final Nave nave;
    public static Inimigo objInimigo;
    public static Inimigo2 objInimigo2;
    private final Keyboard teclado;
    public static ControleInimigos ConIni;
    public ControleTiro conTir;
    private Explosion explosion;
    private GameImage imgMenu;
    private boolean sair, pause, gameOver;
    private int menu, cont;

    public Cenario() {
        cont = 4;
        this.janela = Main.janela;
        cena = new Scene();
        nave1 = new NavePlayer1(100, 280, cena, "naveAzul.png");
        //nave = new Nave(100, 280, cena, "naveAzul.png");
        cena.loadFromFile(URL.scenario("cenario.scn"));
        objInimigo = new Inimigo("asteroide1.png");
        objInimigo2 = new Inimigo2("asteroide2.png");
        teclado = janela.getKeyboard();
        explosion = new Explosion();
        ConIni = new ControleInimigos();
        conTir = new ControleTiro();
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
                        String nick = JOptionPane.showInputDialog(null, "Informe o Nick");
                        Conexao.execute(nick, (int)Nave.points);
                        ConIni.deleteAsteroide();
                        nave1.restart();
                        gameOver = false;
                        sair = false;
                        break;
                }
            }

            imgMenu.draw();
            
            janela.update();
        }

        if (gameOver) {
            String nick = JOptionPane.showInputDialog(null, "Informe o Nick");
            Conexao.execute(nick, (int)Nave.points);
            ConIni.deleteAsteroide(); //Deletar asteroids
            nave1.restart(); //Resetar os pontos
            gameOver = false;
            new Cenario(); //Recomecar o jogo
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
