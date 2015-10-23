/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.util.LinkedList;
import java.util.ListIterator;
import jplay.Scene;
import jplay.Sound;
import jplay.URL;

/**
 *
 * @author batista
 */
public class ControleTiro {
        LinkedList<Tiro> tiros = new LinkedList<>();
    ObjInimigos  ini = new ObjInimigos();
    Scene cena;
    
    public void adicionaTiro(double x, double y, Scene cena ){//Scene cena (paramentro removido temp)
        Tiro tiro = new Tiro(x, y);
        this.cena = cena;
        tiros.addFirst(tiro);
        cena.addOverlay(tiro);
        
      //somDisparo();
    }
    
 
    public void update(LinkedList<ObjInimigos> inimigos){
        ListIterator<Tiro> it = tiros.listIterator();
        while (it.hasNext()) {
            Tiro tiro = it.next();
            tiro.mover();
            for (ObjInimigos j : inimigos)
                if (tiro.collided(j)){
                    cena.removeOverlay(j);
                    inimigos.remove(j);
                    cena.removeOverlay(tiro);
                    it.remove();
                    break;
                }
        }
       
    }
    
    private void somDisparo(){
        new Sound(URL.audio("flecha.wav")).play();
    }
}
