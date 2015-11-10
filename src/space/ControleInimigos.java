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
    static LinkedList<Inimigos> inimigos2 = new LinkedList<>();

    public static Inimigo objIni;
    public static Inimigo2 objIni2;

    private Scene cena;
    private int num = 0, num2 = 0;

    public void adicionaInimigo(Scene cena) {
        objIni = new Inimigo("asteroide1.png");
        inimigos.addFirst(objIni);
        cena.addOverlay(objIni);
        this.cena = cena;
    }

    public void adicionaInimigo2(Scene cena) {
        objIni2 = new Inimigo2("asteroide2.png");
        inimigos2.addFirst(objIni2);
        cena.addOverlay(objIni2);
        this.cena = cena;
    }

    public void inimigo(Scene cena) {//Sorteia a frequencia em que os asteroides serão adicionados
        Random random = new Random();
        if (Nave.points < 200) {
            num = random.nextInt(130);
        } else {
            if (Nave.points > 200 && Nave.points < 500) {
                num = random.nextInt(80);
            } else {
                if (Nave.points > 500) {
                    num = random.nextInt(40);
                }
            }
        }
        if (num == 10) {
            adicionaInimigo(cena);
        }
        run();
    }

    public void inimigo2(Scene cena) {//Sorteia a frequencia em que os asteroides serão adicionados
        Random random = new Random();
//        if (Nave.points < 1000) {
        num2 = random.nextInt(1000);
//        } else {
//            if (Nave.points > 1000 && Nave.points < 2000) {
//                num2 = random.nextInt(500);
//            }
//        }
        if (num2 == 10) {
            adicionaInimigo2(cena);
        }
        run2();
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

    public void run2() {
        System.out.println("Metodo run 2");
        for (int j = 0; j < inimigos2.size(); j++) {
            System.out.println("Segundo for");
            inimigos2.get(j).movendo();
            if (inimigos2.get(j).x < -50) {//Verifica se o asteroide é menor do que o ponto x, se sim remove o objeto da sena e remove da lista
                cena.removeOverlay(inimigos2.get(j));//Remove da cena
                inimigos2.remove(inimigos2.get(j));//Remove do LinkedList
                break;
            }
        }
    }

}
