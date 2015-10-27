/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;


/**
 *
 * @author batista
 */
public class Cenario {

    private final Window janela;
    private final Scene cena;
    private final Nave nave;
    private Inimigos objInimigo;
    private final Keyboard teclado;
    private final ControleInimigos ConIni;
    private Explosion explosion;
 
    public Cenario(Window janela) {
        this.janela = janela;
        cena = new Scene();
        nave = new Nave(100, 280, cena);
        objInimigo = new Inimigos();
        cena.loadFromFile(URL.scenario("cenario.scn"));//Só para testes esse não sera o cenario do jogo
        teclado = janela.getKeyboard();
        explosion = new Explosion();
        ConIni = new ControleInimigos();
        Som.play("song.wav");
    }

    public void run() {
        while (true) {
            //cena.draw();

            cena.moveScene(nave);
            
            nave.x += cena.getXOffset();
            nave.y += cena.getYOffset();
            nave.mover(janela, teclado);
            nave.atirar(janela, cena, teclado, objInimigo);

            
            nave.update(ConIni, nave);
            nave.printPoints(janela);
            nave.draw();
            ConIni.inimigo(cena);
            nave.updateCollision();
            objInimigo.morrer();
            
            explosion.update();
            explosion.draw();

//            ConIni.update(nave);
//            objInimigo.draw();
            
            //janela.delay(1);
            janela.update();
            
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                break;
            }
            
        }
    }
}
