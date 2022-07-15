package modelo;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import javax.swing.JOptionPane;

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
        
        try{
        MongoClient mongo = new MongoClient ("localhost",27017);
        baseDatos = mongo.getDB("logiX");
        coleccionCliente = baseDatos.getCollection("clientes");
        coleccionPaquete = baseDatos.getCollection("paquetes");
        coleccionEmpleado = baseDatos.getCollection("empleados");
        coleccionTransporte = baseDatos.getCollection("transportes");
        coleccionGerente = baseDatos.getCollection("gerentes");
        System.out.println("Conexion a BD Exitosa!");
        
        }catch (MongoException e){
            JOptionPane.showMessageDialog(null, "Error en la conexion a BD!" +e.toString());
        }
    }
}
