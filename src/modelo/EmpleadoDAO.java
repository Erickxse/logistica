package modelo;

import com.mongodb.BasicDBObject;

public class EmpleadoDAO {
    
    public void insertarEmpleado(Empleado e){
    
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombreE", e.getNombre());
        documento.put("apellidoE", e.getApellido());
        documento.put("codigoE", e.getCodigoemp());
        documento.put("claveE", e.getClave());
        documento.put("ciudadE", e.getCiudad());
        objCon.coleccionEmpleado.insert(documento);
    }
}
