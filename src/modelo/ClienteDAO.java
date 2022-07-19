package modelo;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import java.awt.List;
import java.util.ArrayList;
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
        BasicDBObject buscado = new BasicDBObject("claveC", clientevr.getClave()); //Creo un BasicDB para localizar la clave
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
        ArrayList<Paquete> paquetesC = new ArrayList<Paquete>();
        paquetesC.add(p);
        ConexionBD objCon = new ConexionBD();
        System.out.println(usuarioC);
        DBObject buscado = new BasicDBObject("usuarioC", usuarioC);
        //DBObject buscado = new BasicDBObject("usuarioC", usuarioC);
        DBObject agregado = new BasicDBObject().append("$set", 
                new BasicDBObject().append("paquetesC", paquetesC));
        objCon.coleccionCliente.update(buscado, agregado );
    
    }
}
