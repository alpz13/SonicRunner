/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

/**
 *
 * @author Marco David
 */
import java.util.*;
import java.io.*;
public class Sonidos {
    
    private String lista[][]; 
    
    public Sonidos(){
        getTamaño();
        imprimeLista();
    }
    
    public void getTamaño(){
        int i=0, j=0;
        File folder = null;
        String temp[], temp2[], s;
        
        try{
        
            folder = new File("sonidos");
            
       
        temp=folder.list();
        lista=new String[folder.list().length][];
        
        while(i<lista.length){
            j=0;
            folder=new File("sonidos/"+temp[i]);
            temp2=folder.list();
            lista[i]= new String [temp2.length];
                    
            while(j<temp2.length){
                
                lista[i][j]="sonidos/"+temp[i]+"/"+temp2[j];
                j++;
            }
            
            i++;
        }
         }catch(Exception e){
            e.printStackTrace();
            }
  }

    public void imprimeLista(){
        
        int i=0, j=0;
        
        while(i<lista.length){
            j=0;
            while(j<lista[i].length){
                System.out.print(lista[i][j]+"    ");
                j++;
            }
            i++;
            System.out.println();
        }
        
    }
    
    public String [][] getLista(){
        return lista;
    }
            
}
