/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

/**
 *
 * @author Marco David
 */

import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class Enemigo extends Personaje{
    
    public enum Direccion {muere, parado};
    private Direccion direccion;
    private int mov;
    
    public Enemigo(){
        
    }
    
    public Enemigo(String nombre_carpeta, int vida, int posX, int posY){
        
        super("enemigos/enemigo"+nombre_carpeta+"/", vida, posX, posY);
        cargaLista("enemigos/enemigo"+nombre_carpeta+"/");
        paso=0;
        direccion=Direccion.parado;
        s=lista[direccion.ordinal()]; 
        f=s.split("\\.");
        sprites=Integer.parseInt(f[1]); 
        im=Imagenes.cargaImagen(nombreCarpeta+s);
        imagen=getImagen();
        mov=Integer.parseInt(nombre_carpeta);
        
        
    }
    
     public Rectangle getBounds() {
        return new Rectangle(x, y, imagen.getWidth(), imagen.getHeight() );
    }

   public String [] cargaEnemigos(){
        
        String [] list=null;
        int i=0;
        String s;
        try{
            BufferedReader leer = new BufferedReader(new FileReader("datosEnemigos.txt"));
            while(leer.readLine()!=null){
               i++;
            }
            
            leer.close();
            
            leer = new BufferedReader(new FileReader("datosEnemigos.txt"));
            
            list=new String[i];
            i=0;
            
            while((s=leer.readLine())!=null){
                list[i]=s;
                i++;
            }
            leer.close();
            
        }catch(Exception e){
            System.out.println("Error al leer datosEnemigos");
        }
        return list;
    }
   
   public void cargaLista(String nombre){
        
        
        try{
        
            File folder = new File(nombre);
            lista= folder.list();
           
            
        }catch(Exception e){
            
            System.out.println("Error al cargar subimagen");
        }
        
    }
   
    public void setDireccion(Direccion dir){
       if(direccion!=dir){
           paso=0;
       
       direccion=dir;
       s=lista[direccion.ordinal()]; 
       f=s.split("\\.");
       sprites=Integer.parseInt(f[1]); 
       im=Imagenes.cargaImagen(nombreCarpeta+s);
       }
   }
   
   public boolean muerte(){
       
      if(direccion!=Direccion.muere){
       setDireccion(Direccion.muere);
       tiempoPaso= new Cronometro(1);
       
      }
      
       if(++paso%sprites==0){
           
           return true;
       }
           return false;
       
   }
   
   public void move(Heroe heroe, Escenario escenario){
       
      
       switch(mov){
           
           case 1: piso(escenario);break;
               
           case 2:volar();break;
           
       }
       
       if(tiempoAvance.esTiempo()){
            x-=4;
       }
       
            if(heroe.getLeft()>= 150){
                
                if(heroe.getDx()>0){
                x-=heroe.getDx();
                
                }
        
            }
   }
   
   public void volar(){
       
       y+=dy;
       
       if(dy>0 && y>=limSalto){
           dy=-1;
           setLimSalto(-100);
       }
       
       if(dy<0 && y<=limSalto){
           dy=1;
           setLimSalto(100);
       }
    }
   
   public void piso(Escenario escenario){
       
    if(getBounds().intersects(escenario.getBounds())){
             
            m=y=escenario.getBounds().y-this.getImagen().getHeight();
            jumpable=true;
            dy=0;
            setLimSalto(-200);
            
        }else{
                
                
                
            if(y<=limSalto){
                jumpable=false;
                dy=2;
            }
        }
    
    y+=dy;
        
       
    }
   
}
