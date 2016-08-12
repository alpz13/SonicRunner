/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

/**
 *
 * @author Marco David
 */
public class Tiempo {
    
    private long tiempoAnterior;
    private long tiempoTranscurrido;
    private long diferenciaMaxima;

    public Tiempo() {
        tiempoAnterior = 0;
        tiempoTranscurrido = 0;
        diferenciaMaxima = 0;
    }

    public long getDiferenciaMaxima() {
        return diferenciaMaxima;
    }

    public long getTiempoAnterior() {
        return tiempoAnterior;
    }

    public long getTiempoTranscurrido() {
        return tiempoTranscurrido;
    }
    
    public void calculaTiempo(){
        //Calcula el tiempo transcurrido desde la última llamada
        //y la diferencia máxima de tiempos
        
        if(tiempoAnterior==0)
            tiempoAnterior= System.currentTimeMillis();
        long tiempoActual= System.currentTimeMillis();
        long diferencia= tiempoActual-tiempoAnterior;
        
        if(diferencia>diferenciaMaxima){
            diferenciaMaxima=diferencia;
        }
        
        tiempoAnterior= tiempoActual;
        tiempoTranscurrido+= diferencia;
    }
   
}
