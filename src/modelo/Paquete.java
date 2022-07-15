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
    
    //GETS 

    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public Ciudad getCiudad1() {
        return ciudad1;
    }

    public Ciudad getCiudad2() {
        return ciudad2;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }
    
    
    //SETS

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCiudad1(Ciudad ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public void setCiudad2(Ciudad ciudad2) {
        this.ciudad2 = ciudad2;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }
    
    
}
