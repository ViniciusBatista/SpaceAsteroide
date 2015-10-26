/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Random;
import jplay.*;

/**
 *
 * @author batista
 */
public class ControleInimigos {

    static LinkedList<Inimigos> inimigos = new LinkedList<>();
    public static Inimigos objIni;
    private int dificuldade = 500;
    private int cont = 0;

    private Scene cena;

    public void adicionaInimigo(Scene cena) {
        objIni = new Inimigos();
        inimigos.addFirst(objIni);
        cena.addOverlay(objIni);
        this.cena = cena;
    }
    //Implementar esse metodo na classe nave

    public void inimigo(Scene cena) {
        Random random = new Random();
        int num = random.nextInt(100);
        if (num == 1) {
            adicionaInimigo(cena);
 
        }
//        if (cont < dificuldade) {
//            if (cont == 3 && dificuldade == 500) {
//                dificuldade = 300;
//            }
//            if (cont == 5 && dificuldade == 300) {
//                dificuldade = 200;
//            }
//            cont++;
//        } else {
//            adicionaInimigo(cena);
//            cont = 0;
//        }
              run();
    }

    public void run() {
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).movendo();
        }
    }

}
