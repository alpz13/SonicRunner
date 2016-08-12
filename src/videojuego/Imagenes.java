/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package videojuego;

import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

/**
 *
 * @author Marco David
 */
public class Imagenes {
    
    public static BufferedImage cargaImagen(String nombreImagen){
        
        try{
            BufferedImage leer = ImageIO.read(new File(nombreImagen));
            return leer;
            
        }catch(Exception e){
            System.out.print("Error al cargar"+nombreImagen+":"+e.toString());
            return null;
        }
        
    }
    
}
