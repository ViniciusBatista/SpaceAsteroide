/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import jplay.Window;

/**
 *
 * @author batista
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Window janela = new Window(1280, 720); //A janela ja é criada para melhor controle

        Run iniciar = new Run(janela); //Cria a instancia da class Run
//        iniciar.run(); //Inicia o metodo run();

    }

}
