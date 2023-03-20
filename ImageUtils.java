

package photoViewer.photoHandler.despliegueDeImagenes;

import java.awt.geom.AffineTransform;
import java.io.*;         //estas son para archivos y 
import javax.imageio.*;   //la conversi�n de tif a jpg
import java.awt.image.*;
/**

*/
public class ImageUtils 
{


/*
* devuelve una imagen (buffer) en funci�n de la ruta de un archivo
* mejoras
* @param la ruta del archivo con su nombre
* @return BufferedImage la imagen en el buffer
*/
public static BufferedImage loadBufferedImage(String fileName) {
BufferedImage image = null;
try {

image = ImageIO.read( new File( fileName ) );
}
catch (Exception e) {
System.err.println("error al intentar leer la im�gen "+fileName+" "+e);
return null;
}
return image;

}

/*
* escala una imagen en porcentaje.
*/
public static BufferedImage scale(double scale, BufferedImage srcImg) {
if (scale == 1 ) {
    return srcImg;
}
if (scale<=0 || scale>1.445f)
    return null;

try{
    AffineTransformOp op = new AffineTransformOp(AffineTransform.getScaleInstance(scale, scale), null);
    return op.filter(srcImg, null);
    }
catch(Exception e){
    System.err.println("Error en scale "+e);
    }

return null;
}

public static void saveImageToDisk(BufferedImage bi, String str, String format) {
if (bi != null && str != null) {


try {
ImageIO.write( bi, format /* formato */, new File( str ) /* destino */ );
} catch (Exception e){}
}
}


}

