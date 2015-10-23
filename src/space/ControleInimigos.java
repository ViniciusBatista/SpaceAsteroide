/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.LinkedList;
import jplay.*;

/**
 *
 * @author batista
 */
public class ControleInimigos {

    LinkedList<ObjInimigos> inimigos = new LinkedList<>();
    public static ObjInimigos objIni;
    private int dificuldade = 500;

//    ControleInimigos inimigosObj = new ControleInimigos();
    private int cont = 0;

    public void adicionaInimigo(Scene cena) {//Scene cena (paramentro removido temp)
        objIni = new ObjInimigos();
        inimigos.addFirst(objIni);
        cena.addOverlay(objIni);

    }

    public void inimigo(Scene cena) {
        
        if (cont < dificuldade) {
            if(cont == 3 && dificuldade == 500){
                dificuldade = 300;
            }
            if(cont == 5 && dificuldade == 300){
                dificuldade = 100;
            }
            cont++;
        } else {
            adicionaInimigo(cena);
            cont = 0;
        }
        run();
    }

    public void run() {
        for (int i = 0; i < inimigos.size(); i++) {
            inimigos.get(i).movendo();
        }
    }

}
