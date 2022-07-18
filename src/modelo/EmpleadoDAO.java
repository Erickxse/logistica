package modelo;

import com.mongodb.BasicDBObject;

public class EmpleadoDAO {
    
    public void insertarEmpleado(Empleado e){
    
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombreE", e.getNombre());
        documento.put("apellidoE", e.getApellido());
        documento.put("nCedula", e.getNcedula());
        documento.put("ciudadE", e.getCiudad());
        documento.put("direccionE",e.getDireccion());
        documento.put("codigoE", e.getCodigoemp());
        documento.put("claveE", e.getClave());
        
        objCon.coleccionEmpleado.insert(documento);
    }
}
