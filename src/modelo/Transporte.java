package modelo;

public class Transporte {
    
    private String placa;
    private String codigoUnidad;

    public Transporte(String placa, String codigoUnidad) {
        this.placa = placa;
        this.codigoUnidad = codigoUnidad;
    }

    

    public Transporte(){
    }

    public Transporte(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }
    
    
    //GETS
    public String getPlaca() {
        return placa;
    }

    public String getCodigoUnidad() {
        return codigoUnidad;
    }
    
   

    //sets
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setCodigoUnidad(String codigoUnidad) {
        this.codigoUnidad = codigoUnidad;
    }
    
    
    
    
}
