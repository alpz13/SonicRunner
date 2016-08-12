/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Marco David
 */
public class Item {
    
    private int x, y, dx, dy, paso, sprites, mov, limSalto;
    private String nombreCarpeta;
    private BufferedImage imagen;
    private Cronometro tiempoAvance, tiempoPaso;
    
    
    public Item(){
    
    }
    
    
    public Item(String nombre, int posX, int posY){
        
        nombreCarpeta=nombre;
        imagen=Imagenes.cargaImagen("extras/"+nombre);
        x=posX;
        y=posY;
        dx=1;
        dy=3;
        paso=0;
        tiempoPaso=new Cronometro(2);
        tiempoAvance=new Cronometro(1);
        mov=Integer.parseInt(nombre.substring(0, 1));
        
        
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setLimSalto(){
        limSalto=y-200;
    }
    
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public Rectangle getBounds(){
      
        return new Rectangle(x, y, imagen.getWidth(), imagen.getHeight());
    }
    
    public String getNombreCarpeta() {
        return nombreCarpeta;
    }
    
    public void move(Escenario escenario, Heroe heroe){
       
       
       switch(mov){
           
           case 0: x+=dx;
                   ;
                   break;
               
           case 1: 
                   y+=dy;
                   break;
           case 2: 
            if(y<=limSalto){
                dy=3;
            }
       
            if(getBounds().intersects(escenario.getBounds())){
                dy=-3;
            }
            x-=dx;
            y+=dy;
            break;
           
           case 3: x-=dx;
                   y+=dy;
                   break;
           
       }
       
       
        if(heroe.getLeft()>= 150 && mov!=0){
                
                if(heroe.getDx()>0){
                x-=heroe.getDx();
                
                }
        }
   }
   
   public void movPistola(){
       y+=dy;
   }
    
   public void movBalas(){
       
          x+=dx;
       
   }
   
   public void movVeneno(Escenario escenario){
       
       if(y<=limSalto){
           dy=3;
       }
       
       if(getBounds().intersects(escenario.getBounds())){
           dy=-3;
       }
       x-=dx;
       y+=dy;
   }
   
   public void movMushroom(){
      
                x-=dx;
                y+=dy;
          
   }
  
   public void piso(Escenario escenario){
       
       
       if(getBounds().intersects(escenario.getBounds())){
           y=escenario.getBounds().y-getImagen().getHeight()+1;
           setLimSalto();
       }
       
       
   }
   
   public void acciones(Heroe heroe, String [][] sonido){
       
      
        
       switch(mov){
           
           case 1: heroe.mas10();
                   break;
               
           case 2: heroe.setVida(heroe.getVida()-1);
                   break;
               
           case 3: heroe.setVida(heroe.getVida()+2);
                   break;
       }
       
       
       
   }
   
}
