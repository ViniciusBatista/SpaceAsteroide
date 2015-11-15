/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.awt.Color;
import java.awt.Font;
import java.util.Iterator;
import java.util.List;
import jplay.Window;

/**
 *
 * @author batista
 */
public class Player {

    private String nome;
    private int points;
    private List<Player> ranking;

    public Player() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    Font font = new Font("Calibri", Font.TRUETYPE_FONT, 25);
    int x=200, y = 0;
    public void printRanking(Window janela) {//Método que printa na tela a quantidade de pontos e de vidas do jogador.
        ranking = Conexao.consulta();
        for (int i = 0; i< ranking.size();i++){
            janela.drawText(ranking.get(i).getNome()+ "   " + ranking.get(i).getPoints(), x, y, Color.WHITE, font);
            y+=4;
        } 
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

}
