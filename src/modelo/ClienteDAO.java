package modelo;

import com.mongodb.BasicDBObject;

/**
 *
 * @author SR. MORA
 */
public class ClienteDAO {
    
    public void insertarCliente(Cliente c){ //Insertar a Base de Datos
    
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombreC", c.getNombre());
        documento.put("apellidoC", c.getApellido());
        documento.put("usuarioC", c.getUsuario());
        documento.put("claveC", c.getClave());
        documento.put("ciudadC", c.getCiudad());
        documento.put("direccionC", c.getCiudad());
        documento.put("nCedulaC", c.getnCedula());
        documento.put("celularC", c.getnCelular());
        objCon.coleccionCliente.insert(documento); //insertar en base de datos
    }
    
    
    
}
