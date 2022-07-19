package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import java.util.ArrayList;

public class EmpleadoDAO {
    
    private ArrayList<Empleado> listaEmpleados;

    public EmpleadoDAO() {
        
        listaEmpleados = new ArrayList();
    }
    
    
    
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
    
    public Empleado buscarEmpleado(Empleado empleadovr){
    ArrayList<Empleado> listaempleado = new ArrayList<Empleado>();
    Empleado e1;
    String codigoCheck, claveCheck;
    ConexionBD objCon = new ConexionBD();
    BasicDBObject buscado = new BasicDBObject("codigoE", empleadovr.getCodigoemp());
    DBCursor cursor = objCon.coleccionEmpleado.find(buscado);
    while(cursor.hasNext()){
        e1= new Empleado((String)cursor.next().get("nombreE"), (String)cursor.curr().get("apellidoE"),
        (String)cursor.curr().get("nCedula"), (String)cursor.curr().get("ciudadE"), 
                (String)cursor.curr().get("direccionE"), (String)cursor.curr().get("codigoE"), (String)cursor.curr().get("claveE"));
        listaempleado.add(0, e1);
    }
    codigoCheck = listaempleado.get(0).getCodigoemp();
    claveCheck = listaempleado.get(0).getClave();
    Empleado empleadocheck = new Empleado(codigoCheck,claveCheck);
    return empleadocheck;
    }
    
    
    public void insertarPaquete(Paquete p){
    
    }
   }

    