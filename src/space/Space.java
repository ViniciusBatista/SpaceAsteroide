/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

/**
 *
 * @author batista
 */
public class Space {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Window janela = new Window(1280, 720);
        GameImage imgMenu = new GameImage(URL.sprite("TelaInicial.png"));
        Keyboard teclado = janela.getKeyboard();
        Cenario cenario = new Cenario(janela);
        int newGame;
        boolean primeiraVez = true;

        while (true) {
            imgMenu.draw();
            janela.update();
            if (teclado.keyDown(Keyboard.ENTER_KEY)) {

                if (primeiraVez) {

                    cenario.run();
                    primeiraVez = false;
                    
                }else{
                    newGame = JOptionPane.showConfirmDialog(null, "Deseja Continuar:", "Jogo", 0);
                    if (newGame == 1) {
                        cenario = new Cenario(janela);
                        cenario.run();
                    } else {
                        cenario.run();
                    }
                }

            }
            if (teclado.keyDown(Keyboard.ESCAPE_KEY)) {
                janela.exit();
            }
        }
    }
}
