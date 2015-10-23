/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos.cenario;

import jplay.Keyboard;
import jplay.Scene;
import jplay.URL;
import jplay.Window;
import space.ControleInimigos;
import space.Nave;
import space.ObjInimigos;
import space.Tiro;

/**
 *
 * @author batista
 */
public class Cenario {

    private final Window janela;
    private final Scene cena;
//    private GameImage imgCena;
    private final Nave nave;
    private ObjInimigos objInimigo;
    private final Keyboard teclado;
    private final ControleInimigos ConIni;

    public Cenario(Window janela) {
        this.janela = janela;
        cena = new Scene();
        nave = new Nave(100, 280);
        objInimigo = new ObjInimigos();
        cena.loadFromFile(URL.scenario("cenario.scn"));//Só para testes esse não sera o cenario do jogo
        teclado = janela.getKeyboard();
        ConIni = new ControleInimigos();
    }

    public void run() {
        while (true) {
            //cena.draw();

            cena.moveScene(nave);
            
            nave.x += cena.getXOffset();
            nave.y += cena.getYOffset();
            nave.mover(janela, teclado);
            nave.atirar(janela, cena, teclado, objInimigo);
            
            nave.update(ConIni);
            nave.draw();
            ConIni.inimigo(cena);
            objInimigo.morrer();
            
//            objInimigo.draw();
            
            janela.delay(1);
            janela.update();
            
            if(teclado.keyDown(Keyboard.ESCAPE_KEY)){
                break;
            }
            
        }
    }
}
