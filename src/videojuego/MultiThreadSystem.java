/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.event.KeyEvent;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Alejandro
 */
public class MultiThreadSystem implements Runnable {
    
    VentanaJuego soundsEffect;
    Thread t1;
    String musicSoundFX;
    
    
   public void NewThread(String mus) {
      // Create a new, second thread
       
      t1 = new Thread(soundsEffect, "Sound_player");
      musicSoundFX=mus;
      t1.start(); // Start the thread 
   }
   
   public void run(){
            SimpleSoundPlayer.soundKey(musicSoundFX);
   }
   

   
   public void soundKey(String soundEffect){ 
        SimpleSoundPlayer sound = new SimpleSoundPlayer(soundEffect);
        // create the stream to play
        InputStream stream = new ByteArrayInputStream(sound.getSamples());
        // play the sound
        sound.play(stream);
    }
   
   public void KeyCapture(int e){
       
//       int keyCode;
//       keyCode = e.getKeyCode();
       switch(e){
           case KeyEvent.VK_UP:
            SimpleSoundPlayer.soundKey("sonidos/salto.wav");
            break;
//           case KeyEvent.VK_DOWN:
//            SimpleSoundPlayer.soundKey("slide.wav");
//            break;
       }
   }
   
   public static void soundEffect(String soundEffect){
            AudioPlayer MGP = AudioPlayer.player;
            AudioStream BGM;
            AudioData MD;
//            ContinuousAudioDataStream loop= null;
        try {
            
            BGM = new AudioStream(new FileInputStream(soundEffect));
            MD = BGM.getData();
//            loop = new ContinuousAudioDataStream(MD);
            } catch (IOException ex) {}
        
        MGP.start();
 }
    
}
