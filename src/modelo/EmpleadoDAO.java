package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;
import vista.FrmInterfazEmpleado;

public class EmpleadoDAO {
    
    private ArrayList<Empleado> listaEmpleados;
    String codigoE;
    FrmInterfazEmpleado objVistaInterfazE;
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
    
    public Empleado verificarEmpleado(Empleado empleadovr){
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
    
    public void ObtenerNombre(String codigo){
        codigoE=codigo;
    }
    
    public Empleado obtenerEmpleado(String codigo){
        ArrayList<Empleado> listaemp = new ArrayList<Empleado>();
        Empleado e1;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("codigoE",codigo);
        DBCursor cursor = objCon.coleccionEmpleado.find(buscado);
        while(cursor.hasNext()){
         e1 = new Empleado ((String)cursor.next().get("nombreE"),(String)cursor.curr().get("apellidoE"),
         (String)cursor.curr().get("nCedula"),(String)cursor.curr().get("ciudadE"),
                 (String)cursor.curr().get("direccionE"),(String)cursor.curr().get("codigoE"),
                 (String)cursor.curr().get("claveE"));
                 listaemp.add(0,e1);
        }
            return listaemp.get(0);
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
        
            DBObject findQuery = new BasicDBObject("codigoE", codigoE);
            ArrayList matriz = new ArrayList();
            DBObject objPaquete = new BasicDBObject("cedula1",cedula1).append("cedula2", cedula2).append("codigoP", codigoP)
                .append("pesoP", pesoP).append("ciudadP1", ciudadP1).append("ciudadP2", ciudadP2).append("direccionP1", direccionP1).append("direccionP2", direccionP2);
            matriz.add(objPaquete);
            DBObject listapaque = new BasicDBObject("paquetesC",matriz);
            DBObject updateQuery = new BasicDBObject("$push",listapaque);
            objCon.coleccionEmpleado.update(findQuery, updateQuery);
    }
    
    public void eliminarEmpleado(String codigo){
       
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("codigoE", codigo);
        objCon.coleccionEmpleado.remove(documento);
            
    }
   }

    