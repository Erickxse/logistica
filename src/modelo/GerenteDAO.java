package modelo;

import com.mongodb.BasicDBObject;

public class GerenteDAO {
    
    public void insertarGerente(Gerente g){
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("codeGerente", g.getCodeGerente());
        objCon.coleccionGerente.insert(documento);
    }
}
