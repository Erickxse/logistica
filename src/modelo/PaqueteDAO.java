
package modelo;

import com.mongodb.BasicDBObject;

public class PaqueteDAO {
    
    public void insertarPaquete(Paquete p){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("codigoP", p.getCodigo());
        documento.put("pesoP", p.getPeso());
        documento.put("ciudadP1", p.getCiudad1());
        documento.put("ciudadP2", p.getCiudad2());
        documento.put("direccionP1", p.getDireccion1());
        documento.put("direccionP2", p.getDireccion2());
        objCon.coleccionPaquete.insert(documento); //insertar paquete A BD
    }
}
