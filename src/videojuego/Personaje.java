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
import javax.imageio.ImageIO;


/**
 *
 * @author Marco David
 */
public class Personaje {
    
    protected int x, y, dx, dy, m, limSalto, vida, paso, sprites;
    protected String nombreCarpeta, s, f[], lista[];
    protected BufferedImage imagen, im;
    protected Cronometro tiempoAvance, tiempoPaso;
    protected boolean alive, jumpable;
    
    public Personaje(){
        
    }
    
    public Personaje(String nombre_carpeta, int vida, int posX, int posY){
        
        nombreCarpeta= nombre_carpeta;
        x=posX;
        y=posY;
        dx=0;
        dy=2;
        paso=0;
        this.vida=vida;
        limSalto=y-200;
        alive=true;
        jumpable=true;
        tiempoPaso=new Cronometro(10);
        tiempoAvance=new Cronometro(12);
        
    }

    public boolean isJumpable() {
        return jumpable;
    }

    public void setJumpable(boolean jumpable) {
        this.jumpable = jumpable;
    }
    
    public int getDx() {
        return dx;
    }

    public void setDx(int dx) {
        this.dx = dx;
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
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

    public boolean isAlive() {
        
        
        if(vida>0){
            alive=true;
        }else{
            alive=false;
        }
        
        return alive;
    }

    public void saltar(){
         
        if(isJumpable()){
                 
                dy=-2;
        }
                
    }
    
    
    
    public void setLimSalto(int rango){
        limSalto=y+rango;
    }
    
    public int getLimSalto(){
        return limSalto;
    }

    public int getPaso() {
        return paso;
    }
    
    public void setPaso(int paso) {
        this.paso = paso;
    }

   public Cronometro getTiempoAvance() {
        return tiempoAvance;
    }

    public void setTiempoAvance(Cronometro tiempoAvance) {
        this.tiempoAvance = tiempoAvance;
    }

    public Cronometro getTiempoPaso() {
        return tiempoPaso;
    }

    public void setTiempoPaso(Cronometro tiempoPaso) {
        this.tiempoPaso = tiempoPaso;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public BufferedImage getImagen() {
       
        if(tiempoPaso.esTiempo()){
        paso=++paso%sprites;   
        }

        return im.getSubimage(paso*(im.getWidth()/sprites), 0, im.getWidth()/sprites, im.getHeight());
    }
    
   
}
    
   
    

