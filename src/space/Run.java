package space;

import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import jplay.GameImage;
import jplay.Keyboard;
import jplay.URL;
import jplay.Window;

public class Run {

    //Inicializando as variaveis

    private Window janela;
    private Keyboard teclado;
    private Cenario cenario;
<<<<<<< HEAD
    private GameImage imgMenu; 
    private GameImage ranking;
=======
    private GameImage imgMenu;
>>>>>>> 194a371d34e67427c8aa1ac9024764fcf20aa044
    private boolean sair = true; //Variavel para finalizar o jogo
    private int menu = 1; //Variavel para identificar e mostrar cada menu
    private Servidor sever;
    private Cliente cliente;
    private Thread s;
<<<<<<< HEAD
    private Player player;
    
=======
    private Ranking ranking;

>>>>>>> 194a371d34e67427c8aa1ac9024764fcf20aa044
    public Run() { //Metodo run(); Para inicar o jogo
        this.janela = Main.janela;
        player = new Player();
        teclado = janela.getKeyboard();
        imgMenu = new GameImage(URL.sprite("menuPlayer.png")); //Coloca a imagem do menu inicial (Para comecar ja com o menu)
        

        while (sair) { //While para o jogo ficar sempre rodando
            Som.stop(); //Sempre q entrar no menu parar o som
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
                        } else {
                            if (menu == 4) {
                                menu = 1;
                            }
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
                        } else {
                            if (menu == 1) {
                                menu = 4;
                            }
                        }
                    }
                }
            }

            if (teclado.keyDown(KeyEvent.VK_ENTER)) { //Determinar quando o jogador apertar enter
                switch (menu) { //Verifica em qual menu está, e excuta uma função correspondente
                    case 1: //1 Player
                        teclado.addKey(KeyEvent.VK_DOWN, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        teclado.addKey(KeyEvent.VK_UP, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        cenario = new Cenario(); //Cria o cenario do jogo
                        break;
                    case 2: //MultiPlayer
                        //progresso
                        teclado.addKey(KeyEvent.VK_DOWN, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        teclado.addKey(KeyEvent.VK_UP, KeyEvent.KEY_RELEASED); //Coloca o botao para voltar a ser KeyReleased
                        System.out.println("Menu Multi");
                        String op = JOptionPane.showInputDialog(null, "Server[1] ou cliente[2]");
                        if (op.equals("1")) {
                            System.out.println("Sever");
                            s = new Thread(sever);
                            s.start();
//                            sever = new Servidor();
//                            sever.servidor();
                        } else {
                            if (op.equals("2")) {
                                System.out.println("Cliente");
                                cliente = new Cliente(teclado);
                            }
                        }
                        break;
                    case 3: //Ranking
                        //progreso
                        //player.printRanking(janela);
                        System.out.println("Menu Ranking");
                        ranking = new Ranking();
                        break;
                    case 4: //Sair
                        sair = false;
                        janela.exit();
                        break;
                }
            }

        }
    }

}
