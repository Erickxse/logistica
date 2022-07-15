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
    DBCollection coleccionPaquete;
    DBCollection coleccionEmpleado;
    DBCollection coleccionTransporte;
    DBCollection coleccionGerente;
    
    public ConexionBD(){
        MongoClient mongo = new MongoClient ("localhost",27017);
        baseDatos = mongo.getDB("logiX");
        coleccionCliente = baseDatos.getCollection("clientes");
        coleccionPaquete = baseDatos.getCollection("paquetes");
        coleccionEmpleado = baseDatos.getCollection("empleados");
        coleccionTransporte = baseDatos.getCollection("transportes");
        coleccionGerente = baseDatos.getCollection("gerentes");
        System.out.println("Conexion a BD Exitosa!");
    }
}
