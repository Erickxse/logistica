package controlador;

import modelo.ClienteDAO;
import vista.FrmGerencia;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmInterfazCliente;
import vista.FrmRegistroCliente;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;

import vista.FrmInterfazEmpleado;

import vista.FrmRegistroCliente;
import vista.FrmTransporte;

public class GestorLogistica {
 
        public static void main(String args[]){
            
            
            FrmInicio in = new FrmInicio();
            
            //frm ingresos
            FrmIngresoC inc = new FrmIngresoC();
            FrmIngresoE ingresoE = new FrmIngresoE();
            FrmGerencia gerencia = new FrmGerencia();
            //FRM REGISTROS
            FrmRegistroCliente registroCliente = new FrmRegistroCliente();
            FrmRegistrarE regE = new FrmRegistrarE();
            FrmIngresarPaquete ingresarP = new FrmIngresarPaquete();
        
            //FRM INTERFACES
            FrmInterfazGerencia interfaz = new FrmInterfazGerencia();
            FrmInterfazCliente interfazC = new FrmInterfazCliente();
            
            
            FrmInterfazEmpleado continuarE = new FrmInterfazEmpleado();
            
                //DAO
            ClienteDAO objClienteDAO = new ClienteDAO();
            
            //controladoresCliente
            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoE, continuarE,
                    ingresarP, gerencia);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in, interfazC, objClienteDAO);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in, objClienteDAO);
            
            
            
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoE, in, continuarE, ingresarP);
            ControladorGerencia gerenciaCont = new ControladorGerencia(gerencia, in, interfaz);
            //ControladorInterfazGerencia interfazGerencia = new ControladorInterfazGerencia(interfaz, gerencia, regE, tran);

            
            
            


            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
            
            inc.setVisible(false);
            inc.setLocationRelativeTo(in);
            
            interfazC.setVisible(false);
            interfazC.setLocationRelativeTo(in);
            
            registroCliente.setVisible(false);
            registroCliente.setLocationRelativeTo(in);
            
            ingresoE.setVisible(false);
            ingresoE.setLocationRelativeTo(in);
            
            continuarE.setVisible(false);
            continuarE.setLocationRelativeTo(in);
            
            ingresarP.setVisible(false);
            ingresarP.setLocationRelativeTo(in);
            
            gerencia.setVisible(false);
            gerencia.setLocationRelativeTo(in);
            
            interfaz.setVisible(false);
            interfaz.setLocationRelativeTo(in);
            
            
        }
        
}
