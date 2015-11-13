package space;

import java.awt.event.KeyEvent;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import jplay.Keyboard;
import jplay.Window;

public class Cliente {

    Scanner scan = new Scanner(System.in);
    String pergunta, resposta;
    boolean loopCliente = true, loop = true;
//    Window janela;
    Keyboard teclado;
    Nave nave;

    public Cliente(Keyboard teclado) {
//        this.janela = janela;
        this.teclado = teclado;
        while (loop) {

//            System.out.println("Alguns IP:\nThomas: 10.11.27.70\nVinicius: 10.11.16.81\nTaciano: 10.11.15.11");
//
//            System.out.println("Digite o IP");
//            String ip = scan.next();

            try {
                Socket serve = new Socket("localhost", 8888);
                System.out.println("Cliente se conectou ao servidor.");

//                while (loopCliente) {

                    nave.x += Cenario.cena.getXOffset();
                    nave.y += Cenario.cena.getYOffset();
                    nave.mover(Servidor.janela, teclado);
                    nave.atirar(Servidor.janela, Cenario.cena, teclado, Cenario.objInimigo);
                    nave.atirar(Servidor.janela, Cenario.cena, teclado, Cenario.objInimigo2);
                    nave.update(Cenario.ConIni, nave);
                    nave.printPoints(Servidor.janela);
                    nave.draw();
                    nave.updateCollisionNave();
                    nave.updateCollisionNave2();

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

            if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
                loop = false;
            }
//            System.out.println("Deseja conectar: [1]Sim | [0]Não");
//            loop = scan.nextInt();

        }

    }

}
