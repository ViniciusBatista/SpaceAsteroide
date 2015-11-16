package space;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;
import jplay.Keyboard;
import jplay.Window;

public class Servidor implements Runnable {

    private Window janela;
    Keyboard teclado;
    Cenario cenario;
    Run iniciar;
    Scanner scan = new Scanner(System.in);
    Calendar calendar = Calendar.getInstance();
    String mensagem;
    boolean loopSever = true, loop = true;
    ServerSocket socketServidor;
    Thread x;

    public void servidor() {
        this.janela = Main.janela;
//       this.teclado = teclado;
        try {
            socketServidor = new ServerSocket(3000);
//            while (loop) {  
            System.out.println("Aguardando conexao....");
            Socket socketCliente = socketServidor.accept(); //Fica aguardando conexao com o cliente
////                System.out.println("IP: " + socketCliente.getInetAddress().getHostAddress() + ":" + socketCliente.getPort());
////                System.out.println("HostName: " + socketCliente.getInetAddress().getHostName());
////                System.out.println("HostName: " + socketCliente.getInetAddress().getCanonicalHostName());
////                System.out.print("\n");
            System.out.println("Cliente conectou-se.");
            cenario = new Cenario();
            cenario.Cenario();
            
//            x = new Thread(cenario);
//            x.start();
//            cenario = new Cenario(); //Inicia o jogo
//            cenario.run();
            //mandar para o cliente
//            iniciar = new Run(); //Volta ao menu
////                iniciar = new Run();
////                iniciar.run();
//                while (loopSever) {
//                    
//                    System.out.println("Entrou neste");
//                    BufferedReader entrada = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
//                    mensagem = entrada.readLine();
//                    mensagem = mensagem.toLowerCase();
//                    System.out.println(mensagem);
//                    if (mensagem.equals("olá") || mensagem.equals("ola")) {
//
//                        int time = calendar.get(Calendar.HOUR_OF_DAY);
//
//                        if (time > 6 && time < 12) {
//                        } else {
//                            if (time > 12 && time < 6) {
//                                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                                ps.println("Boa Tarde");
//                            } else {
//                                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                                ps.println("Boa Noite");
//                            }
//                        }
//
//                    } else {
//                        if (mensagem.equals("que horas sao?") || mensagem.equals("que")) {
//                            PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                            String data = "" + calendar.getTime();
//                            ps.println(data.substring(11, 19));
//                        } else {
//
//                            if (mensagem.equals("sair")) {
//                                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                                ps.println("Saindo...");
//                                loopSever = false;
//                            } else {
//                                PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                                ps.println("Pergunta não encontrada no Servidor");
//                            }//else do sair
//
//                        }//else da hora
//
//                    }//else do ola
//
//                }
//
//                if (teclado.keyDown(KeyEvent.VK_ESCAPE)) {
//                    System.out.println("Deseja continuar: [1]Sim | [0]Não");
//                    loopSever = false;
//                    loop = false;
//                }
//
//            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public void run() {
        servidor();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    }
}
