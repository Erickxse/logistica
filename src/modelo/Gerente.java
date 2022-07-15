package modelo;

public class Gerente {
  
    private String codeGerente;

    public Gerente(String codeGerente) {
        this.codeGerente = codeGerente;
    }

    public Gerente() {
    }
    
    //GETS

    public String getCodeGerente() {
        return codeGerente;
    }
    
    
    //SETS

    public void setCodeGerente(String codeGerente) {
        this.codeGerente = codeGerente;
    }
    
    
}
