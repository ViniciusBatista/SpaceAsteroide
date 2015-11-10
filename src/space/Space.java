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
public class Space {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Window janela = new Window(1280, 720);
        GameImage imgMenu;
        Keyboard teclado = janela.getKeyboard();
        Cenario cenario;
        boolean sair = true;
        int menu = 1;
        imgMenu = new GameImage(URL.sprite("menuPlayer.png"));

        while (sair) {
            switch (menu) {
                case 1:
                    imgMenu = new GameImage(URL.sprite("menuPlayer.png"));
                    break;
                case 2:
                    imgMenu = new GameImage(URL.sprite("menuMulti.png"));
                    break;
                case 3:
                    imgMenu = new GameImage(URL.sprite("menuRanking.png"));
                    break;
                case 4:
                    imgMenu = new GameImage(URL.sprite("menuSair.png"));
                    break;
            }

            if (teclado.keyDown(KeyEvent.VK_DOWN)) {
                if (menu == 1) {
//                    teclado.removeKey(KeyEvent.VK_DOWN);
                    menu = 2;
                } else {
                    if (menu == 2) {
//                        teclado.removeKey(KeyEvent.VK_ DOWN);
                        menu = 3;
                    } else {
                        if (menu == 3) {
//                            teclado.removeKey(KeyEvent.VK_ DOWN);
                            menu = 4;
                        }
                    }
                }
            } else {
                teclado.addKey(KeyEvent.VK_DOWN);
            }

            if (teclado.keyDown(KeyEvent.VK_UP)) {
                if (menu == 4) {
                    menu = 3;
                } else {
                    if (menu == 3) {
                        menu = 2;
                    } else {
                        if (menu == 2) {
                            menu = 1;
                        }
                    }
                }
            }else{
                teclado.addKey(KeyEvent.VK_UP);
            }

            if (teclado.keyDown(KeyEvent.VK_ENTER)) {
                switch (menu) {
                    case 1:
                        cenario = new Cenario(janela);
                        break;
                    case 2:
                        //progresso
                        break;
                    case 3:
                        //progreso
                        break;
                    case 4:
                        sair = false;
                        janela.exit();
                        break;
                }
            }

            imgMenu.draw();
            janela.update();

        }

    }

}
