package modelo;

public class Transporte {
    
    private int nUnidad;
    private String placa;

    public Transporte(int nUnidad, String placa) {
        this.nUnidad = nUnidad;
        this.placa = placa;
    }

    public Transporte() {
    }
    
    
    //GETS

    public int getnUnidad() {
        return nUnidad;
    }

    public String getPlaca() {
        return placa;
    }
    
    //sets

    public void setnUnidad(int nUnidad) {
        this.nUnidad = nUnidad;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    
}
