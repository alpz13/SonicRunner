/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

/**
 *
 * @author Marco David
 */

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class Juego {
    
    VentanaJuego ventana;
    
   Heroe heroe;
   Escenario escenario;
   
   MultiThreadSystem sounds;
   Thread sound_player;
   
   private static boolean ganarPerder = false;
   
   String [] listaEnemigos;
   Enemigo [] enemigo;
   
   Item []item;
  
   LinkedList balas= new LinkedList();
   
   Sonidos s;
   String[][] sonidos; 
   
   
   
   private boolean pausa;
   private Font fontscore;
   private int fontsize, nivel,score;
   
    
  
    public Juego(VentanaJuego ventana){
        this.ventana=ventana;
        s = new Sonidos();
        sonidos= s.getLista();
        nivel=1;
        fontsize=50;
        pausa=true;
        
   }

    public void setPausa(boolean pausa) {
        this.pausa = pausa;
    }

    public void setNivel(int x){
        nivel=x;
    }
    
    public int getNivel(){
        return nivel;
    }
    
    
    public void setHeroe(String nombreImagenHeroe, int x, int y, int vida){
       
       heroe = new Heroe (nombreImagenHeroe, vida, x, y);
    }
    
   public void setEscenario(String nombreImagenEscenario, int xf, int yf){
        escenario= new Escenario(nombreImagenEscenario, xf, yf);
    } 
   
   public void setItem(int num){
       Random r= new Random ();
       item= new Item[num];
       
       int i=0;
       
       while(i<num){
           item[i]= new Item((1+r.nextInt(3))+".png", 1000+i*500, 0);
           
           i++;
       }
   }
   
   public void setEnemigo(int num){
       try{
       
       String f[];
       Enemigo singleton= new Enemigo();
       listaEnemigos=singleton.cargaEnemigos();
       enemigo=new Enemigo[num];
       
       Random r= new Random();
       
       for(int i=0; i<num; i++){
           
           f=listaEnemigos[r.nextInt(2)].split("_");
           enemigo[i]=new Enemigo(f[0], Integer.parseInt(f[1]), 800+(i*400), 0);
           
           switch(Integer.parseInt(f[0])){
               case 2: enemigo[i].setY(450+r.nextInt(2)*100);
                       enemigo[i].setLimSalto(50);
           }
       }
       }catch(Exception e){
           
           System.out.println(e.getMessage());
       }
   }
   
   public void setMusica(String mus){
       
        sounds = new MultiThreadSystem();
        sounds.NewThread(mus);
        sound_player = new Thread(sounds);
        
       
   }
   
   public void actualiza(){
        
        
       
        BufferStrategy preparacion = ventana.getBufferStrategy();
        
        Graphics dibujar= preparacion.getDrawGraphics();
      
        if(!pausa){
        
        heroe.setY(heroe.getY()+heroe.getDy());
        
        heroe.move(escenario);
        
        pintarEscenario(dibujar);

        colisionesItems(dibujar);
        
        colisionesEnemigos(dibujar);
        
        pintadoScore(dibujar);
        
            if(heroe.getVida()<0){
            pausa=true;
            JOptionPane.showMessageDialog(ventana,"Perdiste");
            
            }
        
            if(heroe.getX()>=7000){
                    
                    pausa=true;
                    
                    JOptionPane.showMessageDialog(ventana,"¡¡¡Ganaste el nivel "+nivel+"!!!");
                    nivel++;
                    ventana.niveles.setVisible(true);
                   
                    
                    
            }
        
        }
            
            
            
        
        preparacion.show();
       
    }
    
    public void pintarEscenario(Graphics dibujar){
      
         if((heroe.getX() - (heroe.getLeft()/2) ) % (escenario.getImagen().getWidth()*2) == 0)
        {
            escenario.setNx(0);
        }
         
        if((heroe.getX() - (escenario.getImagen().getWidth()+heroe.getLeft()/2)) % (escenario.getImagen().getWidth()*2) == 0)
        {
            escenario.setNx2(0);
        }
         dibujar.drawImage(escenario.getImagen(), (escenario.getImagen().getWidth())-escenario.getNx2(), 0, ventana);
        if(heroe.getX() >= (heroe.getLeft()/2))
        {
             dibujar.drawImage(escenario.getImagen(), (escenario.getImagen().getWidth())-escenario.getNx(), 0, ventana);
        }
        
        if(heroe.isAlive()){
         dibujar.drawImage(heroe.getImagen(), heroe.getLeft(), heroe.getY(), ventana);
        }
        
        if(heroe.getDx() >-1)
        {
            dibujar.drawImage(escenario.getImagen(), (escenario.getImagen().getWidth()) - escenario.getNx2(), 0, ventana);
            
        }
            dibujar.drawImage(heroe.getImagen(), heroe.getLeft(), heroe.getY(), ventana);
            
                
            
        
        
    }
    
    public void colisionesItems(Graphics dibujar){
        
        for(int b=0; b<item.length; b++){
            
            
           if(item[b]!=null && item[b].getX()<-10){
                item[b]=null;
            }
            
            if(item[b]!=null){
              
                 
                item[b].move(escenario, heroe);
                item[b].piso(escenario);
                
                dibujar.drawImage(item[b].getImagen(), item[b].getX(), item[b].getY(), ventana);
            
            
            
            if( heroe.getBounds().intersects(item[b].getBounds())){
                item[b].acciones(heroe, sonidos);
                item[b]=null;
                
                if(heroe.getVida()>5){
                    heroe.setVida(5);
                }
            }
            
           
            
           }
            
            
            
        }
        
    }
    
    public void colisionesEnemigos(Graphics dibujar){
        
    
               
        
        for(int i=0; i<enemigo.length; i++){
            
            pintadoBalas(dibujar, enemigo[i]);
            
            if(enemigo[i]!=null && (!enemigo[i].isAlive() || enemigo[i].getX()<(0-enemigo[i].getImagen().getWidth()))){
                
                if(enemigo[i].muerte()){
                enemigo[i]=null;
                }
            }
           
            
         if(enemigo[i]!=null){
             
            enemigo[i].move(heroe, escenario);
            
             
            if(! (enemigo[i].getX()>(ventana.getWidth()+enemigo[i].getImagen().getWidth()) )){
            dibujar.drawImage(enemigo[i].getImagen(), enemigo[i].getX(), enemigo[i].getY(), ventana);
            }
         
            
            if(heroe.getBounds().intersects(enemigo[i].getBounds())){
           
             if(enemigo[i].isAlive()){
            heroe.setVida(heroe.getVida()-1);
            
            
            enemigo[i].setVida(enemigo[i].getVida()-1);
            
             }
            if(!enemigo[i].isAlive()){
                
                
               if(enemigo[i].muerte()){
                    setScore(500);
                    enemigo[i]=null; 
                }
            }
         }
         
         }
        
          
         
        }
       
        heroe.piso(escenario);
        
    }
    
    public void pintadoBalas(Graphics dibujar, Enemigo enemigo){
       
        Item a;
        
        if(!balas.isEmpty()){
            
            for(int j=0; j<balas.size(); j++){
          
                             
                a=(Item)balas.get(j);
                dibujar.drawImage(a.getImagen(), a.getX(), a.getY(), ventana);
                a.move(escenario, heroe);
                
                if(a.getX()>ventana.getWidth()+20){
                    balas.remove(j);
                }else{
               
               if(enemigo!=null && a.getBounds().intersects(enemigo.getBounds())){
                    
                    enemigo.setVida(enemigo.getVida()-1);
                    setScore(500);
                    balas.remove(j);
                }else{
                    balas.set(j, a);
                }
                }
             }
        
            }
        
    }
    
    Item corazon= new Item("10.png",5, 30);
    Item pistola = new Item("1.png",10, 110);
    
   public void pintadoScore(Graphics dibujar){
        
       fontsize=54;
        if(fontscore==null){
        try{
        fontscore = (Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("Font/001.ttf")))).deriveFont(Font.BOLD,fontsize);
        }catch(IOException | FontFormatException e)
        {
            System.out.println("Error al cargar : " + e.toString());
        }
        
        }
        
        int i=0;
        while(i<heroe.getVida()){
            
            dibujar.drawImage(corazon.getImagen(), corazon.getX()+corazon.getImagen().getWidth()*i, corazon.getY(), ventana);
            i++;
        }
        
        dibujar.drawImage(pistola.getImagen(), pistola.getX(), pistola.getY(), ventana);
        
        dibujar.setFont(fontscore);
        dibujar.setColor(Color.ORANGE);
        
        if(heroe.getLeft()>=150){
        score+=heroe.getDx();
        }
        
        
        
            
        dibujar.drawString("SCORE    "+String.format("%08d", score), 400, 70);
        
        
        dibujar.drawString(heroe.getMuniciones()+"", 60, 135);
        
        
    }
   
   public void setScore(int x){
       score+=x;
   }
    
    public void accion(int tecla){
        
      
        
            
            if(tecla==KeyEvent.VK_ESCAPE){ 
                System.exit(0);
            }
                
            if(tecla==KeyEvent.VK_ENTER){
                pausa=!pausa;
                ventana.pausar.setVisible(true);
            }
            
            
                
            if(tecla==KeyEvent.VK_UP){
                
               if(heroe.isJumpable()){
               heroe.saltar();
               
               heroe.setDireccion(Heroe.Direccion.saltar);
               }
                
            }
                
            if(tecla==KeyEvent.VK_RIGHT){
                heroe.setDx(1);
                heroe.setDireccion(Heroe.Direccion.correr);
                
            }
            
            if(tecla==KeyEvent.VK_SPACE){
                
                if(heroe.getMuniciones()>0){
                heroe.setDireccion(Heroe.Direccion.disparar);
                
                }
                heroe.dispara(balas);
                
            }
                
            if(tecla==KeyEvent.VK_A){
                heroe.setDx(2);
                
                heroe.setDireccion(Heroe.Direccion.acelerar);
                
            }
            
            if(tecla==KeyEvent.VK_LEFT){
                heroe.setDx(-1);
                heroe.setDireccion(Heroe.Direccion.correr);
            }
            
            if(tecla==KeyEvent.VK_S){
                
            }
            
        
    }
   
    public void desaccion(int tecla){
        
        switch(tecla){
            
            case KeyEvent.VK_A:
                heroe.setPaso(0);
                heroe.setDx(0);
                heroe.setDireccion(Heroe.Direccion.parado);break;
                
            case KeyEvent.VK_SPACE:
                heroe.setPaso(0);
                heroe.setDireccion(Heroe.Direccion.parado);break;
                
            case KeyEvent.VK_RIGHT:
                heroe.setPaso(0);
                heroe.setDx(0);
                heroe.setDireccion(Heroe.Direccion.parado);break;
                
            case KeyEvent.VK_UP:
                heroe.setDy(2);break;
                
            case KeyEvent.VK_LEFT:
                heroe.setPaso(0);
                heroe.setDx(0);
                heroe.setDireccion(Heroe.Direccion.parado);break;
                
        }
    }
    
}

