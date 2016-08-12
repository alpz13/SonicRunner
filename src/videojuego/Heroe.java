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
import java.io.File;
import java.util.*;


public class Heroe extends Personaje{
    
   
    private int left, municiones;
    public enum Direccion {parado, correr, saltar, acelerar, deslizar, disparar};
    private Direccion direccion;
    
    public Heroe(String nombre_carpeta, int vida, int posX, int posY){
        super(nombre_carpeta, vida, posX, posY);
        cargaLista();
           paso=0;
       
       direccion=Direccion.parado;
       s=lista[direccion.ordinal()]; 
       f=s.split("\\.");
       sprites=Integer.parseInt(f[1]); 
       im=Imagenes.cargaImagen(nombreCarpeta+s);
        imagen=getImagen();
        left=150;
        municiones=0;
      }
    
    
    public void mas10(){
        
       municiones+=10;
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
    
   public void dispara(LinkedList balas){
        
        if(municiones>0){
        
        municiones--;
        balas.addLast(new Item("0.png", left, y+imagen.getHeight()/2));
        
        }
    }
    
    public Rectangle getBounds() {
        return new Rectangle(left, y, imagen.getWidth(), imagen.getHeight() );
    }
    
    public void piso(Escenario escenario){
       
    if(getBounds().intersects(escenario.getBounds())){
             
            m=y=escenario.getBounds().y-this.getImagen().getHeight()+1;
            jumpable=true;
            dy=0;
            setLimSalto(-200);
            
             switch(dx){
                case -1: setDireccion(Direccion.correr);break;
                case 0: setDireccion(Direccion.parado);break;
                case 1: setDireccion(Direccion.correr);break;
                case 2: setDireccion(Direccion.acelerar);break;
            }
        
            
            
        }else{
                setDireccion(Direccion.saltar);
            
                if(y<=limSalto){
                
                dy=2;
            }
                jumpable=false;
         }
    }

    public void cargaLista(){
        
        
        try{
        
            File folder = new File("sonic");
            lista= folder.list();
            
            
            }catch(Exception e){
            
            System.out.println("Error al cargar subimagen");
        }
        
    }
   
    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }
    
    public int getMuniciones(){
       return municiones;
    }
    
    public void move(Escenario escenario){
        if(dx >=0)
        {
            if(left+ dx <= 150)
            {
                left+=dx;
            }
            else
            {
                
                x+=dx;
                escenario.setNx(escenario.getNx()+dx);
                escenario.setNx2(escenario.getNx2()+dx);
                
                if(escenario.getNx()>(escenario.getImagen().getWidth()*2)){
                    escenario.setNx(0);
                }
                
                if(escenario.getNx2()>(escenario.getImagen().getWidth()*2)){
                    escenario.setNx2(0);
                }
                
                
                
            }
        }
        else
        {
            if(left + dx> 0)
            {
                left+=dx;
                
            }
        }
    }
   
}
