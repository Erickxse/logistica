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
    
    
    
    
    
    
}
