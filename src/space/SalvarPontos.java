/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package space;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author batista
 */
public class SalvarPontos {
    
    public static void salvarPontos (Double val, String caminho){
        try{
            FileOutputStream saveFile = new FileOutputStream(caminho);
            ObjectOutputStream saveStream = new ObjectOutputStream(saveFile);
            saveStream.writeDouble(val);
            saveStream.close();
        }catch(IOException e){
            e.printStackTrace();
        } 
    }
    
    public static Double resgatar(String caminho){
        Double valor = 0.0;
        
        try {
            FileInputStream restFile = new FileInputStream(caminho);
            ObjectInputStream restStream = new ObjectInputStream(restFile);
            valor = restStream.readDouble();
        
        }catch (IOException e){
            e.printStackTrace();
        }
        return valor;
    }
}
