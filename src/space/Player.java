/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Iterator;
import jplay.Window;

/**
 *
 * @author batista
 */
public class Player {

    private String nome;
    private int points;
    private ArrayList<Player> ranking;

    public Player() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    Font font = new Font("verdana", Font.ROMAN_BASELINE, 30);
    int x = 510, y = 200, cont = 0, contP = 0;

    public void printRanking(Window janela) {//Método que printa na tela a quantidade de pontos e de vidas do jogador.

        if (cont < 1) {
            System.out.println("Passou");
            ranking = Conexao.consulta();
            System.out.println("Chegou no FOR");
            cont++;
        }
            for (int i = 0; i < ranking.size(); i++) {
                janela.drawText( i+1 + "-" + ranking.get(i).getNome() + ":"+ "   "+ ranking.get(i).getPoints(), x, y, Color.white, font);
                y += 35;
            }
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
