package modelo;

import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.List;
import java.lang.reflect.Array;
import java.util.ArrayList;
import javax.swing.text.Document;
import vista.FrmInterfazCliente;

public class ClienteDAO {
    
    private ArrayList<Cliente> listaClientes;
    String usuarioC;
    FrmInterfazCliente objVistaInterfazC;

    public ClienteDAO() {
        
        listaClientes = new ArrayList();
    }
    
    
    
    public void insertarCliente(Cliente c){ 
    
        ConexionBD objCon = new ConexionBD();
        BasicDBObject documento = new BasicDBObject();
        documento.put("nombreC", c.getNombre());
        documento.put("apellidoC", c.getApellido());
        documento.put("usuarioC", c.getUsuario());
        documento.put("claveC", c.getClave());
        documento.put("ciudadC", c.getCiudad());
        documento.put("direccionC", c.getDireccion());
        documento.put("nCedulaC", c.getnCedula());
        documento.put("celularC", c.getnCelular());
        objCon.coleccionCliente.insert(documento); 
    }
    
    public Cliente verificarCliente(Cliente clientevr){ 
        ArrayList<Cliente> listacliente = new ArrayList<Cliente>(); 
        Cliente c1; 
        String usuarioCheck, claveCheck; 
        ConexionBD objCon = new ConexionBD(); 
        BasicDBObject buscado = new BasicDBObject("usuarioC", clientevr.getUsuario()); 
        DBCursor cursor = objCon.coleccionCliente.find(buscado); 
        while(cursor.hasNext()){
            c1= new Cliente((String)cursor.next().get("nombreC"),(String)cursor.curr().get("apellidoC"), (String)cursor.curr().get("usuarioC"),(String)cursor.curr().get("claveC")
            ,(String)cursor.curr().get("ciudadC"),(String)cursor.curr().get("direccionC"),(String)cursor.curr().get("nCedulaC"),(String)cursor.curr().get("celularC"));
            listacliente.add(0, c1); 
            
        }
        usuarioCheck = listacliente.get(0).getUsuario();
        claveCheck = listacliente.get(0).getClave();
        Cliente clientecheck = new Cliente(usuarioCheck, claveCheck);
        return clientecheck;
        }
    
    public void ObtenerNombre(String usuario){
        usuarioC=usuario;
    }
        
    public void insertarPaqueteC(Paquete p){
        
        String cedula1 = p.getCedula1();
        String cedula2 = p.getCedula2();
        String codigoP = p.getCodigoP();
        double pesoP = p.getPesoP();
        String ciudadP1 = p.getCiudadP1();
        String ciudadP2 = p.getCiudadP2();
        String direccionP1 = p.getDireccionP1();
        String direccionP2 = p.getDireccionP2();
        double precioP = p.getpFinal();

        ConexionBD objCon = new ConexionBD();
        
        DBObject findQuery = new BasicDBObject("usuarioC",usuarioC);
        ArrayList matriz = new ArrayList();
        DBObject objpaquete = new BasicDBObject("cedula1",cedula1).append("cedula2", cedula2).append("codigoP", codigoP)
                .append("pesoP", pesoP).append("ciudadP1", ciudadP1).append("ciudadP2", ciudadP2).append("direccionP1", direccionP1).append("direccionP2", direccionP2)
                .append("precioP", precioP);
                        matriz.add(objpaquete);
        DBObject listapaque = new BasicDBObject("paquetesC", matriz);
          
        DBObject updateQuery = new BasicDBObject("$push",listapaque);
        objCon.coleccionCliente.update(findQuery, updateQuery);
    }
    
    
    public DBObject buscarPaquete(String codigo){
            
        ConexionBD objCon = new ConexionBD();
        DBObject findQuery = new BasicDBObject("usuarioC",usuarioC);
        DBObject findPackage = new BasicDBObject("codidgoP",codigo);
        return objCon.coleccionCliente.findOne(findQuery,findPackage);
    }
    
    public Cliente obtenerCliente (String usuario){
        ArrayList<Cliente> listacliente = new ArrayList<Cliente>();
        Cliente c1;
        ConexionBD objCon = new ConexionBD();
        BasicDBObject buscado = new BasicDBObject("usuarioC",usuario);
        DBCursor cursor = objCon.coleccionCliente.find(buscado);
        while(cursor.hasNext()){
            c1 = new Cliente((String)cursor.next().get("nombreC"),(String)cursor.curr().get("apellidoC"),
            (String)cursor.curr().get("usuarioC"),(String)cursor.curr().get("claveC"),
            (String)cursor.curr().get("ciudadC"),(String)cursor.curr().get("direccionC"),
            (String)cursor.curr().get("nCedulaC"),(String)cursor.curr().get("celularC"));
            
            listacliente.add(0,c1);
        }
        return listacliente.get(0);
    }
    
    }

