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
        // TODO code application logic here
        Window janela = new Window(1280, 720);
        GameImage imgMenu;
        Keyboard teclado = janela.getKeyboard();
        MenuDificuldades menuDificuldade;
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
                    imgMenu = new GameImage(URL.sprite("menuSair.png"));
                    break;
            }

            if (teclado.keyDown(KeyEvent.VK_DOWN)) {
                if (menu == 1) {
                    menu = 2;
                }
                if (menu == 2) {
                    menu = 3;
                }
            }

            if (teclado.keyDown(KeyEvent.VK_UP)) {
                if (menu == 3) {
                    menu = 2;
                }
                if (menu == 2) {
                    menu = 1;
                }
            }
            
            if (teclado.keyDown(KeyEvent.VK_ENTER)) {
                switch (menu) {
                    case 1:
                        menuDificuldade = new MenuDificuldades(janela);
                        break;
                    case 2:
                        //progresso
                        break;
                    case 3:
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
