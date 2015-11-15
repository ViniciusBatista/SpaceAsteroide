/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import static space.Inimigo2.energia;

/**
 *
 * @author batista
 */
public class InimigoBoss extends Inimigos {

    public static int energia = 25;

    public InimigoBoss(String img) {
        super(img);
    }

    public static int getEnergia() {
        return energia;
    }

    public static void setEnergia(int energia) {
        Inimigo2.energia = energia;
    } 

    @Override
    public void movendo() {
        if (super.y < 1120) {
            super.y++;
        } else if (super.y > 154) {
            super.y--;
        }
    }
}
