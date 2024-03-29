
package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;

public class PaqueteDAO {
    
    public void insertarPaquete(Paquete p){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("cedula1", p.getCedula1());
        documento.put("cedula2", p.getCedula2());
        documento.put("codigoP", p.getCodigoP());
        documento.put("pesoP", p.getPesoP());
        documento.put("ciudadP1", p.getCiudadP1());
        documento.put("ciudadP2", p.getCiudadP2());
        documento.put("direccionP1", p.getDireccionP1());
        documento.put("direccionP2", p.getDireccionP2());
        documento.put("precioP", p.getpFinal());
        documento.put("estado", p.getEstado());
        objCon.coleccionPaquete.insert(documento); 
    }
    
    public Paquete buscarPaquete(Paquete paquetevr){
        ArrayList<Paquete> listapaquete = new ArrayList<Paquete>();
        Paquete p1;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("codigoP", paquetevr.getCodigoP());
        DBCursor cursor = objCon.coleccionPaquete.find(buscado);
        while(cursor.hasNext()){
            p1= new Paquete((String)cursor.next().get("codidoP"), (Double)cursor.curr().get("pesoP"),
            (String)cursor.curr().get("ciudadP1"), (String)cursor.curr().get("ciudadP2"),
            (String)cursor.curr().get("direccionP1"), (String)cursor.curr().get("direccionP2"));
            
           listapaquete.add(0, p1);
        }
        return listapaquete.get(0);
    }
    
    public Paquete obtenerPaquete(String codigoP){
       ArrayList<Paquete> listapaq = new ArrayList<Paquete>();
       Paquete p1;
       ConexionBD objCon = new ConexionBD();
       BasicDBObject buscado = new BasicDBObject("codigoP", codigoP);
       DBCursor cursor = objCon.coleccionPaquete.find(buscado);
       while(cursor.hasNext()){
           p1 = new Paquete((String)cursor.next().get("cedula1"),(String)cursor.curr().get("cedula2"),
                   (String)cursor.curr().get("codigoP"), (Double)cursor.curr().get("pesoP"),
            (String)cursor.curr().get("ciudadP1"), (String)cursor.curr().get("ciudadP2"),
            (String)cursor.curr().get("direccionP1"), (String)cursor.curr().get("direccionP2"), 
                   (double)cursor.curr().get("precioP"),(String)cursor.curr().get("estado"));
           
           listapaq.add(0, p1);
       }
        
        return listapaq.get(0);
    }
    
    public void cambiarEstadoB(String codigo){
       
        ConexionBD objCon = new ConexionBD();
        DBObject buscado = new BasicDBObject("codigoP", codigo);
        DBObject updated = new BasicDBObject().append("$set", 
                new BasicDBObject().append("estado", EnumEstado.BODEGA.toString()));
        objCon.coleccionPaquete.update(buscado, updated);
        }
    
    public void cambiarEstadoR(String codigo){
       
        ConexionBD objCon = new ConexionBD();
        DBObject buscado = new BasicDBObject("codigoP", codigo);
        DBObject updated = new BasicDBObject().append("$set", 
                new BasicDBObject().append("estado", EnumEstado.RETIRADO.toString()));
        objCon.coleccionPaquete.update(buscado, updated);
        }
    
    public void cambiarEstadoT(String codigo){
       
        ConexionBD objCon = new ConexionBD();
        DBObject buscado = new BasicDBObject("codigoP", codigo);
        DBObject updated = new BasicDBObject().append("$set", 
                new BasicDBObject().append("estado", EnumEstado.CAMINO.toString()));
        objCon.coleccionPaquete.update(buscado, updated);
        }
        
    
//    public String obtenerCedula(String codigo){
//        ArrayList<Paquete> listapaq = new ArrayList<Paquete>();
//        String cedula;
//        ConexionBD objCon = new ConexionBD();
//    
//    }
}
