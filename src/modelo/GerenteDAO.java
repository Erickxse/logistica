package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.util.ArrayList;

public class GerenteDAO {
     private ArrayList<Gerente> listaGerente;
     String codigoG;

    public GerenteDAO() {
        
        listaGerente = new ArrayList();
    }
    
    
    public void insertarGerente(Gerente g){
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("codeGerente", g.getCodeGerente());
        objCon.coleccionGerente.insert(documento);
        
    }
    public Gerente codigoGerente(Gerente codigGerente){
        ArrayList <Gerente> listaGerente = new ArrayList <Gerente>();
        Gerente g1;
        String codeGerente;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("codeGerente", codigGerente.getCodeGerente());
        DBCursor cursor = objCon.coleccionGerente.find(buscado);
        while (cursor.hasNext()) {
            g1 = new Gerente((String)cursor.next().get("codeGerente"));
            listaGerente.add(0, g1);            
        }
        codeGerente = listaGerente.get(0).getCodeGerente();
        Gerente gerenteCode = new Gerente(codeGerente);
        return gerenteCode;
        
    }
    
    public void obtenerCodigoG(String codigo){
            codigoG=codigo;
    }
    
    public void insertarEmpleado(Empleado e){
    
        String nombreE = e.getNombre();
        String apellidoE = e.getApellido();
        String nCedula = e.getNcedula();
        String ciudadE = e.getCiudad();
        String direccionE = e.getDireccion();
        String codigoE = e.getCodigoemp();
        String claveE = e.getClave();
        
        ConexionBD objCon = new ConexionBD();
        
        DBObject findQuery = new BasicDBObject("codeGerente",codigoG);
        ArrayList matriz = new ArrayList();
        DBObject objEmpleado = new BasicDBObject("nombreE",nombreE).append("apellidoE", apellidoE)
                .append("nCedula", nCedula).append("ciudadE", ciudadE).append("direccionE", direccionE)
                .append("codigoE", codigoE).append("claveE", claveE);
        matriz.add(objEmpleado);
        DBObject listaempleado = new BasicDBObject("empleadosG",matriz);
        DBObject updateQuery = new BasicDBObject("$push",listaempleado);
        objCon.coleccionGerente.update(findQuery, updateQuery);
    }
}
