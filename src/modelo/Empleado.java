package modelo;


public class Empleado {
    
    private String nombre;
    private String apellido;
    private String codigoemp;
    private String clave;
    private Ciudad ciudad;

    public Empleado(String nombre, String apellido, String codigoemp, String clave, Ciudad ciudad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.codigoemp = codigoemp;
        this.clave = clave;
        this.ciudad = ciudad;
    }

    public Empleado(String codigoemp, String clave) {
        this.codigoemp = codigoemp;
        this.clave = clave;
    }

    public Empleado() {
    }
    
    
    
    //GETS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getCodigoemp() {
        return codigoemp;
    }

    public String getClave() {
        return clave;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }
    
    
    //SETS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCodigoemp(String codigoemp) {
        this.codigoemp = codigoemp;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }
    
    
}
