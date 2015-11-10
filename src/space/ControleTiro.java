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
    Inimigo ini = new Inimigo("asteroide1.png");
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
                    Nave.points += 5;//Incrementa os pontos do jogador na partida
//                    explosion.appendExplosion((int) j.x, (int) j.y);
//                    explosion.draw();
//                    explosion.update();
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

    public void updateCollsionShortsIni2(LinkedList<Inimigos> inimigos, Nave nave) {//Metodo verifica a colisão do inimigo com o tiro
        this.nave = nave;
        ListIterator<Tiro> it = tiros.listIterator();
        while (it.hasNext()) {
            Tiro tiro = it.next();
            tiro.mover();
            for (Inimigos j : inimigos) {
                if (tiro.collided(j)) {
                    it.remove();
                    System.out.println("Pontos: " + nave.points);
                    new Sound(URL.audio("explosion.wav")).play();
                    if (j.energia == 0) {
                        nave.points += 8;//Incrementa os pontos do jogador na partida
                        cena.removeOverlay(j);
                        inimigos.remove(j);
                    } else {
                        j.energia--;
                    }
                    cena.removeOverlay(tiro);
                    break;
                }
            }
        }

    }
}
