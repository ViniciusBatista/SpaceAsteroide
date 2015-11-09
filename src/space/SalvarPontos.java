/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

/**
 *
 * @author batista
 */
public class SalvarPontos {

    public static void salvarPontos(Double val, String caminho) throws IOException{
//        try {
//            FileOutputStream saveFile = new FileOutputStream(caminho);
//            ObjectOutputStream saveStream = new ObjectOutputStream(saveFile);
//            saveStream.writeDouble(val);
//            saveStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        FileWriter arq = new FileWriter(caminho);
        PrintWriter gravarArq = new PrintWriter(arq);
        gravarArq.printf("+--Pontos--+%n");
        gravarArq.printf("%f" ,val);
        arq.close();
        
    }

    public static Double resgatar(String caminho) {
        Double valor = 0.0;

        try {
            FileReader restFile = new FileReader(caminho);
            //ObjectInputStream restStream = new ObjectInputStream(restFile);
            BufferedReader lerArq = new BufferedReader(restFile);
            // valor = restStream.readDouble();
            String linha = lerArq.readLine();
            while (linha != null) {
                System.out.println("Linha" + linha);
                linha = lerArq.readLine();
            }
            restFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return valor;
    }
}
