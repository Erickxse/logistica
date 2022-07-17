package controlador;

import modelo.ClienteDAO;
import vista.FrmGerencia;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
<<<<<<< HEAD
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;
=======
import vista.FrmInterfazEmpleado;
>>>>>>> 62f7d0ac52bc5df553a1447870d05993fb2a35f9
import vista.FrmRegistroCliente;
import vista.FrmTransporte;

public class GestorLogistica {
 
        public static void main(String args[]){
            FrmInicio in = new FrmInicio();
            FrmIngresoC inc = new FrmIngresoC();
            FrmRegistroCliente registroCliente = new FrmRegistroCliente();
            FrmIngresoE ingresoE = new FrmIngresoE();
            FrmGerencia gerencia = new FrmGerencia();
<<<<<<< HEAD
            FrmInterfazGerencia interfaz = new FrmInterfazGerencia();
            FrmRegistrarE regE = new FrmRegistrarE();
            FrmTransporte tran = new FrmTransporte();
            
                //DAO
            ClienteDAO objClienteDAO = new ClienteDAO();

            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoE, gerencia);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in, objClienteDAO);
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoE, in);
            ControladorGerencia gerenciaCont = new ControladorGerencia(gerencia, in, interfaz);
            ControladorInterfazGerencia interfazGerencia = new ControladorInterfazGerencia(interfaz, gerencia, regE, tran);
=======
            FrmInterfazEmpleado continuarE = new FrmInterfazEmpleado();
            FrmIngresarPaquete ingresarP = new FrmIngresarPaquete();

                //DAO
            ClienteDAO objClienteDAO = new ClienteDAO();
            
            
            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoe, continuarE, ingresarP, gerencia);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in, objClienteDAO);
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoe, in, continuarE, ingresarP);
            ControladorGerencia gerenciaCont = new ControladorGerencia(gerencia, in);
>>>>>>> 62f7d0ac52bc5df553a1447870d05993fb2a35f9

            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
            
            inc.setVisible(false);
            inc.setLocationRelativeTo(in);
            
            registroCliente.setVisible(false);
            registroCliente.setLocationRelativeTo(in);
            
            ingresoE.setVisible(false);
            ingresoE.setLocationRelativeTo(in);
            
            continuarE.setVisible(false);
            continuarE.setVisible(ingresoe);
            
            ingresarP.setVisible(false);
            ingresarP.setVisible(true);
            
            gerencia.setVisible(false);
            gerencia.setLocationRelativeTo(in);
            
            interfaz.setVisible(false);
            interfaz.setLocationRelativeTo(in);
        }
        
}
