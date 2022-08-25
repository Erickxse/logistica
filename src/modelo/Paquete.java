package modelo;

public class Paquete {
    
    private String cedula1;
    private String cedula2;
    private String codigoP;
    private double pesoP;
    private String ciudadP1;
    private String ciudadP2;
    private String direccionP1;
    private String direccionP2;

    public Paquete(String codigoP, double pesoP, String ciudadP1, String ciudadP2, String direccionP1, String direccionP2) {
        this.codigoP = codigoP;
        this.pesoP = pesoP;
        this.ciudadP1 = ciudadP1;
        this.ciudadP2 = ciudadP2;
        this.direccionP1 = direccionP1;
        this.direccionP2 = direccionP2;
    }

    public Paquete(String cedula1, String cedula2, String codigoP, double pesoP, String ciudadP1, String ciudadP2, String direccionP1, String direccionP2) {
        this.cedula1 = cedula1;
        this.cedula2 = cedula2;
        this.codigoP = codigoP;
        this.pesoP = pesoP;
        this.ciudadP1 = ciudadP1;
        this.ciudadP2 = ciudadP2;
        this.direccionP1 = direccionP1;
        this.direccionP2 = direccionP2;
    }
    
    

    public Paquete() {
    }
    
    //GETS 

    public String getCedula1() {
        return cedula1;
    }

    public String getCedula2() {
        return cedula2;
    }

    
    public String getCodigoP() {
        return codigoP;
    }

    public double getPesoP() {
        return pesoP;
    }

    public String getCiudadP1() {
        return ciudadP1;
    }

    public String getCiudadP2() {
        return ciudadP2;
    }

    public String getDireccionP1() {
        return direccionP1;
    }

    public String getDireccionP2() {
        return direccionP2;
    }
    
    
    //SETS

    public void setCedula1(String cedula1) {
        this.cedula1 = cedula1;
    }

    public void setCedula2(String cedula2) {
        this.cedula2 = cedula2;
    }

    
        
    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public void setPesoP(double pesoP) {
        this.pesoP = pesoP;
    }

    public void setCiudad1(String ciudadP1) {
        this.ciudadP1 = ciudadP1;
    }

    public void setCiudad2(String ciudadP2) {
        this.ciudadP2 = ciudadP2;
    }

    public void setDireccionP1(String direccionP1) {
        this.direccionP1 = direccionP1;
    }

    public void setDireccionP2(String direccionP2) {
        this.direccionP2 = direccionP2;
    }

    @Override
    public String toString() {
        return "Paquete{" + "cedula1=" + cedula1 + ", cedula2=" + cedula2 + ", codigoP=" + codigoP + ", pesoP=" + pesoP + ", ciudadP1=" + ciudadP1 + ", ciudadP2=" + ciudadP2 + ", direccionP1=" + direccionP1 + ", direccionP2=" + direccionP2 + '}';
    }   
}
