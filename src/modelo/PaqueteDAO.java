
package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class PaqueteDAO {
    
    public void insertarPaquete(Paquete p){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("cedula1", p.getEmisorCI());
        documento.put("cedula2", p.getReceptorCI());
        documento.put("codigoP", p.getCodigo());
        documento.put("pesoP", p.getPeso());
        documento.put("ciudadP1", p.getCiudad1());
        documento.put("ciudadP2", p.getCiudad2());
        documento.put("direccionP1", p.getDireccion1());
        documento.put("direccionP2", p.getDireccion2());
        objCon.coleccionPaquete.insert(documento); //insertar paquete A BD
    }
    
    public Paquete buscarPaquete(Paquete paquetevr){
        ArrayList<Paquete> listapaquete = new ArrayList<Paquete>();
        Paquete p1;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("codigoP", paquetevr.getCodigo());
        DBCursor cursor = objCon.coleccionPaquete.find(buscado);
        while(cursor.hasNext()){
            p1= new Paquete((String)cursor.next().get("cogidoP"), (Double)cursor.curr().get("pesoP"),
            (String)cursor.curr().get("ciudadP1"), (String)cursor.curr().get("ciudadP2"),
            (String)cursor.curr().get("direccionP1"), (String)cursor.curr().get("direccionP2"));
            
           listapaquete.add(0, p1);
        }
        return listapaquete.get(0);
    }
}
