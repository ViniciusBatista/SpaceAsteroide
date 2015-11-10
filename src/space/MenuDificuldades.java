package space;

import java.awt.event.KeyEvent;
import jplay.*;

public class MenuDificuldades {
        private final Window janela;
        private Cenario cenario;
        private final Keyboard teclado;
        private KeyEvent evt;
        private GameImage imgMenu;
        private boolean loop = true;
        private int menu = 1;
//        public static int dificuldade;

    public MenuDificuldades(Window janela) {
        this.janela = janela;
        imgMenu = new GameImage(URL.sprite("menuEasy.png"));
        teclado = janela.getKeyboard();
        
        run();
    }
    
    public void run(){
        //menu = 1;
        loop = true;
        
        while(loop){
            switch(menu){
                case 1:
                    imgMenu = new GameImage(URL.sprite("menuEasy.png"));
                    break;
                case 2:
                    imgMenu = new GameImage(URL.sprite("menuNormal.png"));
                    break;
                case 3:
                    imgMenu = new GameImage(URL.sprite("menuHard.png"));
                    break;
            }
            
            if (teclado.keyDown(KeyEvent.VK_DOWN)) {
                if (menu == 1) {
                    menu = 2;
                }else if (menu == 2) {
                    menu = 3;
                }
            }

            if (teclado.keyDown(KeyEvent.VK_UP)) {
                if (menu == 3) {
                    menu = 2;
                }else  if (menu == 2) {
                    menu = 1;
                }
            }
            
            if (teclado.keyDown(KeyEvent.VK_ENTER)) {
                switch (menu) {
                    case 1:
//                        dificuldade = 1;
                        cenario = new Cenario(janela);
                        break;
                    case 2:
//                        dificuldade = 2;
//                        dificuldade = 2;
                        cenario = new Cenario(janela);
                        break;
                    case 3:
//                        dificuldade = 3;
                        cenario = new Cenario(janela);
                        break;
                }
            }
            
            if(teclado.keyDown(KeyEvent.VK_ESCAPE)){
                loop = false;
            }
            
//            if(evt.getKeyCode() == KeyEvent.VK_ESCAPE){
//                loop = false;
//            }

            imgMenu.draw();
            janela.update();
            
            
        }
        
    }

}
