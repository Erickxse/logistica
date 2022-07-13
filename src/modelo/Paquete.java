package modelo;

public class Paquete {
    
    private String codigo;
    private double peso;
    private Ciudad ciudad1;
    private Ciudad ciudad2;
    private String direccion1;
    private String direccion2;

    public Paquete(String codigo, double peso, Ciudad ciudad1, Ciudad ciudad2, String direccion1, String direccion2) {
        this.codigo = codigo;
        this.peso = peso;
        this.ciudad1 = ciudad1;
        this.ciudad2 = ciudad2;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
    }

    public Paquete() {
    }
    
    
}
