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
public class Explosion {
    private LinkedList<Sprite> explosion;
    
    public Explosion(){
        explosion = new LinkedList<Sprite>();
    }
    
    public void appendExplosion (int x, int y){
        System.out.println("Explosão");
        Sprite sprite = new Sprite(URL.sprite("explosion.png"), 74);
        sprite.x = x;
        sprite.y = y;
        sprite.setTotalDuration(400);
        sprite.setLoop(false);
        sprite.setSequence(0, 74);
        explosion.add(sprite);
    }
    
    public void update (){
        ListIterator<Sprite> s = explosion.listIterator();
        while (s.hasNext()){
            Sprite e = s.next();
            e.update();
            if (!e.isPlaying()){
                s.remove();
                
            }
        }
    }
    
    public void draw(){
        ListIterator<Sprite> s = explosion.listIterator();
        while (s.hasNext()){
            Sprite e = s.next();
            e.draw();
        }
    }
}
