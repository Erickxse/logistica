package modelo;

import com.mongodb.BasicDBObject;

public class TransporteDAO {
    
    public void insertarTransporte(Transporte t){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("placa", t.getPlaca());
        documento.put("nUnidad", t.getnUnidad());
        objCon.coleccionTransporte.insert(documento);
    }
}
