/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.LinkedList;
import java.util.ListIterator;
import jplay.*;



/**
 *
 * @author batista
 */
public class ControleTiro {

    LinkedList<Tiro> tiros = new LinkedList<>();
    Inimigos ini = new Inimigos();
    Nave nave;
    Scene cena;
    Explosion explosion = new Explosion();

    public void adicionaTiro(double x, double y, Scene cena) {//Scene cena (paramentro removido temp)
        Tiro tiro = new Tiro(x, y);
        this.cena = cena;
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        new Sound(URL.audio("tiro2.wav")).play();
    }

    public void updateCollsionShort(LinkedList<Inimigos> inimigos, Nave nave) {//Metodo verifica a colisão do inimigo com o tiro
        this.nave = nave;
        ListIterator<Tiro> it = tiros.listIterator();
        while (it.hasNext()) {
            Tiro tiro = it.next();
            tiro.mover();
            for (Inimigos j : inimigos) {
                if (tiro.collided(j)) {
                    it.remove();
                    nave.points += 5;//Incrementa os pontos do jogador na partida
                    System.out.println("Pontos: " + nave.points);
                    new Sound(URL.audio("explosion.wav")).play();
                    cena.removeOverlay(j);
                    inimigos.remove(j);
                    cena.removeOverlay(tiro);
                    break;
                }
            }
        }

    }
}
