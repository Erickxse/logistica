package modelo;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private Ciudad ciudad;
    private String direccion;
    private String nCedula;
    private String nCelular;

    
        // constructor
    public Cliente(String nombre, String apellido, String usuario, String clave, 
            Ciudad ciudad, String direccion, String nCedula, String nCelular) {
        
        this.nombre = nombre;
        this.apellido = apellido;
        this.usuario = usuario;
        this.clave = clave;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.nCedula = nCedula;
        this.nCelular = nCelular;
    }

    public Cliente() {
    }

        // constructor para ingresar
    public Cliente(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }
    
    
    //GETS

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getClave() {
        return clave;
    }

    public Ciudad getCiudad() {
        return ciudad;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getnCedula() {
        return nCedula;
    }

    public String getnCelular() {
        return nCelular;
    }
    
    //SETS

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setnCedula(String nCedula) {
        this.nCedula = nCedula;
    }

    public void setnCelular(String nCelular) {
        this.nCelular = nCelular;
    }
    
    
    //to string
    
    
    
    
    
}
