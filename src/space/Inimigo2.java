/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

/**
 *
 * @author batista
 */
public class Inimigo2 extends Inimigos {

    /**
     *
     * @param img
     */
    public static int energia = 2;

    public Inimigo2(String img) {
        super(img);
    }

    @Override
    public void movendo() {
        super.movendo();

    }

    public static int getEnergia() {
        return energia;
    }

    public static void setEnergia(int energia) {
        Inimigo2.energia = energia;
    }
    
}
