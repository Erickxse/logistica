package modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

/**
 *
 * @author Grupo 3
 */
public class ConexionBD {
    
    DB baseDatos;
    DBCollection coleccionCliente;
    
    public ConexionBD(){
        MongoClient mongo = new MongoClient ("localhost",27017);
        baseDatos = mongo.getDB("logiX");
        coleccionCliente = baseDatos.getCollection("clientes");
        System.out.println("Conexion a BD Exitosa!");
    }
}
