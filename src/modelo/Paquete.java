package modelo;

public class Paquete {
    
    private String emisorCI;
    private String receptorCI;
    private String codigo;
    private double peso;
    private String ciudad1;
    private String ciudad2;
    private String direccion1;
    private String direccion2;

    public Paquete(String codigo, double peso, String ciudad1, String ciudad2, String direccion1, String direccion2) {
        this.codigo = codigo;
        this.peso = peso;
        this.ciudad1 = ciudad1;
        this.ciudad2 = ciudad2;
        this.direccion1 = direccion1;
        this.direccion2 = direccion2;
    }

    public Paquete(String emisorCI, String receptorCI, String codigo, double peso, String ciudad1, String ciudad2, String direccion1, String direccion2) {
        this.emisorCI = emisorCI;
        this.receptorCI = receptorCI;
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

    public String getEmisorCI() {
        return emisorCI;
    }

    public String getReceptorCI() {
        return receptorCI;
    }

    
    public String getCodigo() {
        return codigo;
    }

    public double getPeso() {
        return peso;
    }

    public String getCiudad1() {
        return ciudad1;
    }

    public String getCiudad2() {
        return ciudad2;
    }

    public String getDireccion1() {
        return direccion1;
    }

    public String getDireccion2() {
        return direccion2;
    }
    
    
    //SETS

    public void setEmisorCI(String emisorCI) {
        this.emisorCI = emisorCI;
    }

    public void setReceptorCI(String receptorCI) {
        this.receptorCI = receptorCI;
    }

    
        
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setCiudad1(String ciudad1) {
        this.ciudad1 = ciudad1;
    }

    public void setCiudad2(String ciudad2) {
        this.ciudad2 = ciudad2;
    }

    public void setDireccion1(String direccion1) {
        this.direccion1 = direccion1;
    }

    public void setDireccion2(String direccion2) {
        this.direccion2 = direccion2;
    }
    
    
}
