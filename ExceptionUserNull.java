package Excepciones;

public class ExceptionUserNull extends Exception {
    
    public ExceptionUserNull(){
        super("El usuario o contraseña ingresado está vacío.");
    }
}
