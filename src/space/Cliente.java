package space;

//import java.io.BufferedReader;
import java.io.IOException;
//import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;
import jplay.Keyboard;
//import static space.Cenario.ConIni;
//import static space.Cenario.cena;
//import static space.Cenario.objInimigo;
//import static space.Cenario.objInimigo2;

public class Cliente {

    Scanner scan = new Scanner(System.in);
    String pergunta, resposta;
    Cenario cenario;
    boolean loopCliente = true, loop = true;
//    Window janela;
    Keyboard teclado;
    NavePlayer2 nave2;

    public Cliente(Keyboard teclado) {
//        this.janela = janela;
        this.teclado = teclado;
//        while (loop) {

//            System.out.println("Alguns IP:\nThomas: 10.11.27.70\nVinicius: 10.11.16.81\nTaciano: 10.11.15.11");
//
//            System.out.println("Digite o IP");
//            String ip = scan.next();
        try {
            Socket serve = new Socket("localhost", 3000);
            System.out.println("Cliente se conectou ao servidor.");

//                while (loopCliente) {
//                naveCliente = new NavePlayer2(100, 280, Cenario.cena, "naveVermelha.png");
            while (true) {

//                Cenario.cena.moveScene(nave2);
//
//                Cenario.ConIni.inimigo(Cenario.cena);
//                Cenario.ConIni.inimigo2(Cenario.cena);
//
//                nave2 = new NavePlayer2(100, 280, Cenario.cena, "naveVermelha.png");
//                nave2.x += cena.getXOffset();
//                nave2.y += cena.getYOffset();
//                nave2.mover(Cenario.janela, teclado);
//                nave2.atirar(Cenario.janela, cena, teclado, Cenario.objInimigo);
//                nave2.atirar(Cenario.janela, cena, teclado, Cenario.objInimigo2);
//                nave2.update(ConIni, nave2);
//                nave2.printPoints(Cenario.janela);
//                nave2.draw();
//
//                Cenario.janela.update();
//                    if (nave2.updateCollisionNaveAsteroid1() && !gameOver) {
//                        LimparImgMenu();
//                        gameOver = true;
//                        pause = false;
//                    }
//                    if (nave2.updateCollisionNaveAsteroid2() && !gameOver) {
//                        LimparImgMenu();
//                        gameOver = true;
//                        pause = false;
//                    }

            }
//                cenario = new Cenario();

//                while (true) {
//                    Cenario.cena.moveScene(naveCliente);
//
////                ConIni.inimigo(cena);
////                ConIni.inimigo2(cena);
//                    naveCliente.x += Cenario.cena.getXOffset();
//                    naveCliente.y += Cenario.cena.getYOffset();
//                    naveCliente.mover(Cenario.janela, teclado);
//                    naveCliente.atirar(Cenario.janela, Cenario.cena, teclado, Cenario.objInimigo);
//                    naveCliente.atirar(Cenario.janela, Cenario.cena, teclado, Cenario.objInimigo2);
//                    naveCliente.update(Cenario.ConIni, naveCliente);
//                    naveCliente.printPoints(Cenario.janela);
//                    naveCliente.draw();
//
//                    if (naveCliente.updateCollisionNaveAsteroid1()) {
////                    LimparImgMenu();
////                    gameOver = true;
////                    pause = false;
//                    }
//                    if (naveCliente.updateCollisionNaveAsteroid2()) {
////                    LimparImgMenu();
////                    gameOver = true;
////                    pause = false;
//                    }
//
////                explosion.update();
////                explosion.draw();
//                    Cenario.janela.update();
//                janela.update();
//                }
            //teste
//                    System.out.println("Digite sua Pergunta: ");
//                    pergunta = scan.next();
//                    System.out.println(pergunta);
//                    PrintStream ps = new PrintStream(serve.getOutputStream());
//                    ps.println(pergunta);
//
//                    BufferedReader entrada = new BufferedReader(new InputStreamReader(serve.getInputStream()));
//                    resposta = entrada.readLine();
//                    System.out.println("Servidor: " + resposta);
//                    if (resposta.equals("Saindo...")) {
//                        loopMenu = 0;
//                    } else {
//                        System.out.println("Perguntar Novamente: [1]Sim | [0]Nao");
//                        loopMenu = scan.nextInt();
//                    }
//                    if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
//                        loopCliente = false;
//                    }
//                }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

//            if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
//                loop = false;
//            }
//            System.out.println("Deseja conectar: [1]Sim | [0]Não");
//            loop = scan.nextInt();
    }

//    }
}
