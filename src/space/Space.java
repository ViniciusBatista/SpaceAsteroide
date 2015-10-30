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
public class Space {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Window janela = new Window(1280, 720);
        GameImage imgMenu;
        Keyboard teclado = janela.getKeyboard();
        Cenario cenario;
//        boolean menuPlayer = true, menuMulti, menuSair, parada1, parada2, parada3;
        boolean loop = true;
        int menu = 1;
        imgMenu = new GameImage(URL.sprite("menuPlayer.png"));

        while (loop) {
            imgMenu.draw();
            janela.update();

            if (teclado.keyDown(KeyEvent.VK_DOWN)) {
                switch (menu) {
                    case 1:
                        imgMenu = new GameImage(URL.sprite("menuMulti.png"));
                        menu = 2;
                        break;

                    case 2:
                        imgMenu = new GameImage(URL.sprite("menuSair.png"));
                        menu = 0;
                        break;
                }
            }

            if (teclado.keyDown(KeyEvent.VK_UP)) {
                switch (menu) {
                    case 2:
                        imgMenu = new GameImage(URL.sprite("menuPlayer.png"));
                        menu = 1;
                        break;

                    case 0:
                        imgMenu = new GameImage(URL.sprite("menuMulti.png"));
                        menu = 2;
                        break;
                }
            }

            if (teclado.keyDown(KeyEvent.VK_ENTER)) {
                switch (menu) {
                    case 1:
                        cenario = new Cenario(janela);
                        break;

                    case 2:
                        //não faz nada
                        break;

                    case 0:
                        loop = false;
                        janela.exit();
                        break;
                }
            }

        }

    }

}
