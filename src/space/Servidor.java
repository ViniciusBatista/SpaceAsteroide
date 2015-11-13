package space;

import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Calendar;
import java.util.Scanner;
import jplay.Keyboard;
import jplay.Window;

public class Servidor {

    public static Window janela;
    Keyboard teclado;
    Cenario cenario;
    Run iniciar;
    Scanner scan = new Scanner(System.in);
    Calendar calendar = Calendar.getInstance();
    String mensagem;
    boolean loopSever = true, loop = true;
    ServerSocket socketServidor;

    public Servidor(Window janela) {
       this.janela = janela;
//       this.teclado = teclado;
        try {
            socketServidor = new ServerSocket(8888);
//            while (loop) {  
//                System.out.println("Aguardando conexao....");
//                Socket socketCliente = socketServidor.accept();
////                System.out.println("IP: " + socketCliente.getInetAddress().getHostAddress() + ":" + socketCliente.getPort());
////                System.out.println("HostName: " + socketCliente.getInetAddress().getHostName());
////                System.out.println("HostName: " + socketCliente.getInetAddress().getCanonicalHostName());
////                System.out.print("\n");
//                System.out.println("Cliente conectou-se.");
//                
//                cenario = new Cenario(janela);
//                iniciar = new Run(janela);
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
//                            PrintStream ps = new PrintStream(socketCliente.getOutputStream());
//                            ps.println("Bom dia");
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

}
