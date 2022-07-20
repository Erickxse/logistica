package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.List;
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
    
    
    
    public void insertarCliente(Cliente c){ //Insertar a Base de Datos
    
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
        documento.put("paquetesC", c.getPaquetes());
        objCon.coleccionCliente.insert(documento); //insertar en base de datos
    }
    
    public Cliente buscarCliente(Cliente clientevr){ //recibe un cliente
        ArrayList<Cliente> listacliente = new ArrayList<Cliente>(); //creo lista de clientes
        Cliente c1; //creo un objeto cliente
        String usuarioCheck, claveCheck; //creo dos strings para Usuario y Clave
        ConexionBD objCon = new ConexionBD(); //Creo un Objeto Conexion
        BasicDBObject buscado = new BasicDBObject("usuarioC", clientevr.getUsuario()); //Creo un BasicDB para localizar la clave
        DBCursor cursor = objCon.coleccionCliente.find(buscado); //creo un DBCursor para situarme en el usuario
        while(cursor.hasNext()){
            c1= new Cliente((String)cursor.next().get("nombreC"),(String)cursor.curr().get("apellidoC"), (String)cursor.curr().get("usuarioC"),(String)cursor.curr().get("claveC")
            ,(String)cursor.curr().get("ciudadC"),(String)cursor.curr().get("direccionC"),(String)cursor.curr().get("nCedulaC"),(String)cursor.curr().get("celularC"));
            //c1= new Cliente((String)cursor.next().get("usuarioC"), (String)cursor.curr().get("claveC"));
            listacliente.add(0, c1);//itero y almaceno los datos en el objeto cliente 
            //y luego los agrego a la arraylist
        }
        usuarioCheck = listacliente.get(0).getUsuario();
        claveCheck = listacliente.get(0).getClave();
        Cliente clientecheck = new Cliente(usuarioCheck, claveCheck);
        return clientecheck;
        }
    
    public void ObtenerNombre(String usuario){
        usuarioC=usuario;
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
        
        ArrayList<Paquete>listp1 = new ArrayList();
        listp1.add(p);
        ConexionBD objCon = new ConexionBD();
//        DBObject buscado = new BasicDBObject("usuarioC", usuarioC);
//        System.out.println("NOMBRE: "+usuarioC);
//        
//        DBObject actual = new BasicDBObject().append("$set", new BasicDBObject().append("paquetesC", listp1.toString()));
//        objCon.coleccionCliente.update(buscado, actual);
//        System.out.println("agregado");

        DBObject findQuery = new BasicDBObject("usuarioC",usuarioC);
        DBObject listapaque = new BasicDBObject("paquetesC", new BasicDBObject("cedula1",cedula1).append("cedula2", cedula2).append("codigoP", codigoP)
        .append("pesoP", pesoP).append("ciudadP1", ciudadP1).append("ciudadP2", ciudadP2).append("direccionP1", direccionP1).append("direccionP2", direccionP2));
        
        DBObject updateQuery = new BasicDBObject("$set",listapaque);
        objCon.coleccionCliente.update(findQuery, updateQuery);
    }
    
    }

