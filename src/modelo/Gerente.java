package modelo;

public class Gerente {
  
    private String codeGerente;
    private String sucursal;

    public Gerente(String codeGerente) {
        this.codeGerente = codeGerente;
    }

    
    
    public Gerente(String codeGerente, String sucursal) {
        this.codeGerente = codeGerente;
        this.sucursal=sucursal;
    }

    public Gerente() {
    }
    
    //GETS

    public String getCodeGerente() {
        return codeGerente;
    }

    public String getSucursal() {
        return sucursal;
    }
    
    
    //SETS

    public void setCodeGerente(String codeGerente) {
        this.codeGerente = codeGerente;
    }

    public void setSucursal(String sucursal) {
        this.sucursal = sucursal;
    }
    
    
}
