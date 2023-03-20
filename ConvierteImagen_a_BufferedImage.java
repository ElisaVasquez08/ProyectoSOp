
package photoViewer.photoHandler.despliegueDeImagenes;

import java.awt.*;
import java.awt.image.*;
import javax.swing.ImageIcon;

public class ConvierteImagen_a_BufferedImage {


public static boolean hasAlpha(Image image) {
    
    if (image instanceof BufferedImage) {
        BufferedImage bimage = (BufferedImage)image;
        return bimage.getColorModel().hasAlpha();
    }
    // El grabber recupera el modelo de color de la imagen
    PixelGrabber pg = new PixelGrabber(image, 0, 0, 1, 1, false);
    try 
    {
        pg.grabPixels();
    } catch (InterruptedException e) {
    }

    // Get the image's color model
    ColorModel cm = pg.getColorModel();
    return cm.hasAlpha();
}

// Este método devuelve un buffered image con el contenido de una imagen
public static BufferedImage toBufferedImage(Image image) {
    if (image instanceof BufferedImage) {
        return (BufferedImage)image;
    }

    // Este código garantiza que se carguen todos los píxeles de la imagen
    image = new ImageIcon(image).getImage();

    // Determina si la imagen tiene píxeles transparentes
    boolean hasAlpha = hasAlpha(image);
    
    // Crear una buffered image con un formato compatible con la pantalla
    BufferedImage bimage = null;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    try {
        // Determinar el tipo de transparencia de la nueva imagen almacenada en buffer
        int transparency = Transparency.OPAQUE;
        if (hasAlpha) {
            transparency = Transparency.BITMASK;
        }

        // Crea un buffered image
        GraphicsDevice gs = ge.getDefaultScreenDevice();
        GraphicsConfiguration gc = gs.getDefaultConfiguration();
        bimage = gc.createCompatibleImage(
            image.getWidth(null), image.getHeight(null), transparency);
    } catch (HeadlessException e) {
        // The system does not have a screen
    }

    if (bimage == null) {
        // Crear una buffered image usando el modelo de color por defecto
        int type = BufferedImage.TYPE_INT_RGB;
        if (hasAlpha) {
            type = BufferedImage.TYPE_INT_ARGB;
        }
        bimage = new BufferedImage(image.getWidth(null), image.getHeight(null), type);
    }

    // Copia la imagen a buffered image
    Graphics g = bimage.createGraphics();

    // Pinta la image en buffered image
    g.drawImage(image, 0, 0, null);
    g.dispose();

    return bimage;
}
}
