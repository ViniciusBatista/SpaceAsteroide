/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.LinkedList;
import java.util.Random;
import jplay.*;

/**
 *
 * @author batista
 */
public class ControleInimigos {

    static LinkedList<Inimigos> inimigos = new LinkedList<>();
    public static Inimigos objIni;

    private Scene cena;

    public void adicionaInimigo(Scene cena) {
        objIni = new Inimigos();
        inimigos.addFirst(objIni);
        cena.addOverlay(objIni);
        this.cena = cena;
    }

    public void inimigo(Scene cena) {//Sorteia a frequencia em que os asteroides serão adicionados
        Random random = new Random();
        int num = random.nextInt(100);
        if (num == 1) {
            adicionaInimigo(cena);
        }
        run();
    }

    public void run() {
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).movendo();
            if (inimigos.get(i).x < -50) {//Verifica se o asteroide é menor do que o ponto x, se sim remove o objeto da sena e remove da lista
                cena.removeOverlay(inimigos.get(i));//Remove da cena
                inimigos.remove(inimigos.get(i));//Remove do LinkedList
                break;
            }
        }

    }

}
