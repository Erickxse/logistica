package modelo;

public class Transporte {
    
    private String placa;
    private int nUnidad;

    public Transporte(String placa, int nUnidad){
        this.placa = placa;
        this.nUnidad = nUnidad;
    }

    public Transporte(){
    }
    
    //GETS
    public String getPlaca() {
        return placa;
    }
    
    public int getnUnidad() {
        return nUnidad;
    }

    //sets
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    
    public void setnUnidad(int nUnidad) {
        this.nUnidad = nUnidad;
    }
    
    
}
