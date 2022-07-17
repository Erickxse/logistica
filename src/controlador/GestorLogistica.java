package controlador;

import modelo.ClienteDAO;
import vista.FrmGerencia;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoC;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmRegistroCliente;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;

import vista.FrmInterfazEmpleado;

import vista.FrmRegistroCliente;
import vista.FrmTransporte;

public class GestorLogistica {
 
        public static void main(String args[]){
            FrmInicio in = new FrmInicio();
            FrmIngresoC inc = new FrmIngresoC();
            FrmRegistroCliente registroCliente = new FrmRegistroCliente();
            FrmIngresoE ingresoE = new FrmIngresoE();
            FrmGerencia gerencia = new FrmGerencia();

            FrmInterfazGerencia interfaz = new FrmInterfazGerencia();
            FrmRegistrarE regE = new FrmRegistrarE();
            FrmTransporte tran = new FrmTransporte();
            FrmInterfazEmpleado continuarE = new FrmInterfazEmpleado();
            FrmIngresarPaquete ingresarP = new FrmIngresarPaquete();
                //DAO
            ClienteDAO objClienteDAO = new ClienteDAO();

            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoE, continuarE,
                    ingresarP, gerencia);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in, objClienteDAO);
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoE, in, continuarE, ingresarP);
            ControladorGerencia gerenciaCont = new ControladorGerencia(gerencia, in, interfaz);
            ControladorInterfazGerencia interfazGerencia = new ControladorInterfazGerencia(interfaz, gerencia, regE, tran);

            
            
            


            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
            
            inc.setVisible(false);
            inc.setLocationRelativeTo(in);
            
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
