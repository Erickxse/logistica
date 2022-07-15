package modelo;

import com.mongodb.BasicDBObject;

public class TransporteDAO {
    
    public void insertarTransporte(Transporte t){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nUnidadT", t.getnUnidad());
        documento.put("placa", t.getPlaca());
        objCon.coleccionTransporte.insert(documento);
    }
}
