
package usuarios.modelo_datos;


public class Usuario
{
    private String id;
    private String nombre;
    private String Apellido;
    private String nivel;
    private String password;

    public Usuario(String id, String nombre, String Apellido, String nivel, String password) 
    {
        this.id = id;
        this.nombre = nombre;
        this.Apellido = Apellido;
        this.nivel = nivel;
        this.password = password;
    }

    
    public String getPassword() 
    {
        return password;
    }

    public void setPassword(String password) 
    {
        this.password = password;
    }


    public String getNivel() 
    {
        return nivel;
    }

    public void setNivel(String nivel)
    {
        this.nivel = nivel;
    }


    public String getApellido() 
    {
        return Apellido;
    }

    public void setApellido(String Apellido)
    {
        this.Apellido = Apellido;
    }

    
    public String getNombre() 
    {
        return nombre;
    }

    public void setNombre(String nombre) 
    {
        this.nombre = nombre;
    }


    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }
}
