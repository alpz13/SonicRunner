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
public class Escenario {
    
    private int xi, yi, nx, nx2; 
    private String nombreImagen;
    private BufferedImage imagen;
    
    


    public Escenario(String nombre_imagen, int x_f, int y_f){
        
        nombreImagen= nombre_imagen;
        xi=yi=0;        
        imagen =Imagenes.cargaImagen("fondos/"+nombre_imagen);
        nx=0;
        nx2=imagen.getWidth();
       
    }

    public BufferedImage getImagen() {
        return imagen;
    }

    public void setImagen(BufferedImage imagen) {
        this.imagen = imagen;
    }
    
     public Rectangle getBounds() {
        return new Rectangle(0, 696, 20000, imagen.getHeight()-696 );
    }

    public String getNombreimagen() {
        return nombreImagen;
    }

    public void setNombreimagen(String nombreimagen) {
        this.nombreImagen = nombreimagen;
        imagen=Imagenes.cargaImagen(nombreimagen);
    }

   
    public int getXi() {
        return xi;
    }

    public void setXi(int xi) {
        this.xi = xi;
    }

    

    public int getYi() {
        return yi;
    }

    public void setYi(int yi) {
        this.yi = yi;
    }

    public int getNx() {
        return nx;
    }

    public void setNx(int nx) {
        this.nx = nx;
    }

    public int getNx2() {
        return nx2;
    }

    public void setNx2(int nx2) {
        this.nx2 = nx2;
    }
    
    
   public BufferedImage cargaImagen(){
        //Recupera la imagen del archivo llamado nombreimagen
        
        try{
            BufferedImage leer = ImageIO.read(new File(nombreImagen));
            return leer;
        }catch(Exception e){
            System.out.print("Error al cargar"+nombreImagen+":"+e.toString());
            return null;
        }
    }

    public String getNombreImagen() {
        return nombreImagen;
    }

    public void setNombreImagen(String nombreImagen) {
        this.nombreImagen = nombreImagen;
    }

}
