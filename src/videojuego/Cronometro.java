/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

/**
 *
 * @author Marco David
 */
public class Cronometro {
    
    private long retardo, arranque;
    
    public Cronometro(int frames){
        
        retardo=1000/frames;
        arranque=System.currentTimeMillis();
        
    }
    
    public boolean esTiempo(){
        
        long ahora=System.currentTimeMillis();
        
        if((ahora-arranque)>=retardo){
            arranque=ahora;
            return true;
        }
        return false;
    }
    
}
