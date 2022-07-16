package controlador;

import modelo.ClienteDAO;
import vista.FrmGerencia;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmRegistroCliente;

public class GestorLogistica {
 
        public static void main(String args[]){
            FrmInicio in = new FrmInicio();
            FrmIngresoC inc = new FrmIngresoC();
            FrmRegistroCliente registroCliente = new FrmRegistroCliente();
            FrmIngresoE ingresoe = new FrmIngresoE();
            FrmGerencia gerencia = new FrmGerencia();
            

                //DAO
            ClienteDAO objClienteDAO = new ClienteDAO();
            
            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoe, gerencia);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in, objClienteDAO);
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoe, in);
            ControladorGerencia gerenciaCont = new ControladorGerencia(gerencia, in);


            
            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
           
      
            inc.setVisible(false);
            inc.setLocationRelativeTo(in);
            
            
            registroCliente.setVisible(false);
            registroCliente.setLocationRelativeTo(in);
            
            ingresoe.setVisible(false);
            ingresoe.setLocationRelativeTo(in);
            
            gerencia.setVisible(false);
            gerencia.setLocationRelativeTo(in);
            
            
        }
        
}
