package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class GerenteDAO {
     private ArrayList<Gerente> listaGerente;

    public GerenteDAO() {
        
        listaGerente = new ArrayList();
    }
    
    
    public void insertarGerente(Gerente g){
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("codeGerente", g.getCodeGerente());
        objCon.coleccionGerente.insert(documento);
        
    }
    public Gerente codigoGerente(Gerente codigGerente){
        ArrayList <Gerente> listaGerente = new ArrayList <Gerente>();
        Gerente g1;
        String codeGerente;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("codeGerente", codigGerente.getCodeGerente());
        DBCursor cursor = objCon.coleccionGerente.find(buscado);
        while (cursor.hasNext()) {
            g1 = new Gerente((String)cursor.next().get("codeGerente"));
            listaGerente.add(0, g1);            
        }
        codeGerente = listaGerente.get(0).getCodeGerente();
        Gerente gerenteCode = new Gerente(codeGerente);
        return gerenteCode;
        
    }
}
