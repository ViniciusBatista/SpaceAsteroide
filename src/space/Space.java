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
        boolean sair = true; //Variavel para finalizar o jogo
        int menu = 1;
        imgMenu = new GameImage(URL.sprite("menuPlayer.png"));

        while (sair) {

            teclado.addKey(KeyEvent.VK_DOWN); //Adiciono o botao da seta de baixo para ele virar um KeyPress
            teclado.addKey(KeyEvent.VK_UP); //Adiciono o botao da seta de cima para ele virar um KeyPress
            imgMenu.draw();
            janela.update();

            switch (menu) { //Determinar em qual menu está e colocar a imagem referente a ele
                case 1:
                    imgMenu = new GameImage(URL.sprite("menuPlayer.png")); //Imagem do Menu 1 Player
                    break;
                case 2:
                    imgMenu = new GameImage(URL.sprite("menuMulti.png")); //Imagem do Menu Multiplayer
                    break;
                case 3:
                    imgMenu = new GameImage(URL.sprite("menuRanking.png")); //Imagem do Menu Ranking
                    break;
                case 4:
                    imgMenu = new GameImage(URL.sprite("menuSair.png")); //Imagem do Menu Sair
                    break;
            }

            if (teclado.keyDown(KeyEvent.VK_DOWN)) { //Quando o jogador apertar para baixo é feito a troca para menu referente
                if (menu == 1) {
                    menu = 2;
                } else {
                    if (menu == 2) {
                        menu = 3;
                    } else {
                        if (menu == 3) {
                            menu = 4;
                        }
                    }
                }
            }

            if (teclado.keyDown(KeyEvent.VK_UP)) { //Quando o jogador apertar para cima é feito a troca para o menu referente
                if (menu == 4) {;
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
            }

            if (teclado.keyDown(KeyEvent.VK_ENTER)) { //Determinar quando o jogador apertar enter
                switch (menu) { //Verifica em qual menu está, e excuta uma função correspondente
                    case 1:
                        teclado.addKey(KeyEvent.VK_DOWN, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        teclado.addKey(KeyEvent.VK_UP, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        Cenario cenario = new Cenario(janela); //Cria o cenario do jogo
                        break;
                    case 2:
                        //progresso
                        System.out.println("Menu Multi");
                        break;
                    case 3:
                        //progreso
                        System.out.println("Menu Ranking");
                        break;
                    case 4:
                        sair = false;
                        janela.exit();
                        break;
                }
            }

        }

    }

}
