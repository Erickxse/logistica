package controlador;

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
            

            ControladorInicio cl = new ControladorInicio(in, inc, registroCliente, ingresoe);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            ControladorRegistroC registroClienteControlador = new ControladorRegistroC(registroCliente, in);
            ControladorIngresoE ingresoEControlador = new ControladorIngresoE(ingresoe, in);

            //ControladorInicio cl = new ControladorInicio(in, inc);

            
            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
            
            //ControladorIngresoC cic = new ControladorIngresoC(inc, in);
      
            inc.setVisible(false);
            inc.setLocationRelativeTo(inc);
            
            
            registroCliente.setVisible(false);
            registroCliente.setLocationRelativeTo(registroCliente);
            
            ingresoe.setVisible(false);
            ingresoe.setLocationRelativeTo(ingresoe);
            
            
        }
        
}
