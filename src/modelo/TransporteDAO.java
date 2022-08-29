package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;

public class TransporteDAO {
    
    String codigoT;
    public void insertarTransporte(Transporte t){
        
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("placa", t.getPlaca());
        documento.put("nUnidad", t.getCodigoUnidad());
        objCon.coleccionTransporte.insert(documento);
    }
    
    public void obtenerCodigoT(String codigo){
        codigoT=codigo;
    }
    
    public Transporte verificarTransporte(Transporte transportevr){
        ArrayList<Transporte> listaTransporte = new ArrayList<Transporte>();
        Transporte tr;
        String codigocheck;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("nUnidad",transportevr.getCodigoUnidad());
        DBCursor cursor = objCon.coleccionTransporte.find(buscado);
        while(cursor.hasNext()){
            tr = new Transporte((String)cursor.next().get("placa"),(String)cursor.curr().get("nUnidad"));
            listaTransporte.add(0,tr);
        }
        codigocheck = listaTransporte.get(0).getCodigoUnidad();
        Transporte transportecheck = new Transporte(codigocheck);
        return transportecheck;
    }
    
    public void insertarPaquete(Paquete p){
    
        String cedula1 = p.getCedula1();
        String cedula2 = p.getCedula2();
        String codigoP = p.getCodigoP();
        double pesoP = p.getPesoP();
        String ciudadP1 = p.getCiudadP1();
        String ciudadP2 = p.getCiudadP2();
        String direccionP1 = p.getDireccionP1();
        String direccionP2 = p.getDireccionP2();
        
        ConexionBD objCon = new ConexionBD();
        
        DBObject findQuery = new BasicDBObject("nUnidad",codigoT);
        ArrayList matriz = new ArrayList();
        DBObject objpaquete = new BasicDBObject("cedula1",cedula1).append("cedula2", cedula2)
                .append("codigoP", codigoP).append("pesoP", pesoP).append("ciudadP1", ciudadP1)
                .append("ciudadP2", ciudadP2).append("direccionP1", direccionP1).append("direccionP2", direccionP2);
        matriz.add(objpaquete);
        DBObject listapaque = new BasicDBObject("paquetesT",matriz);
        DBObject updateQuery = new BasicDBObject("$push",listapaque);
        objCon.coleccionTransporte.update(findQuery, updateQuery);
    }
    
    public void eliminarTransporte(String nunidad){
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nUnidad", nunidad);
        objCon.coleccionTransporte.remove(documento);
    }
}
