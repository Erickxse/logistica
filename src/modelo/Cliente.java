package modelo;

public class Cliente {
    
    private String nombre;
    private String apellido;
    private String usuario;
    private String clave;
    private String ciudad;
    private String direccion;
    private String nCedula;
    private String nCelular;

    public Cliente(String nombre, String apellido, String usuario, String clave, 
            String ciudad, String direccion, String nCedula, String nCelular) {
        
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
    
    
    
    
    
    
}
