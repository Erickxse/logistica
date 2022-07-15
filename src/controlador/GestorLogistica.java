package controlador;

import vista.FrmIngresoC;
import vista.FrmInicio;

public class GestorLogistica {
 
        public static void main(String args[]){
            FrmInicio in = new FrmInicio();
            FrmIngresoC inc = new FrmIngresoC();
            
            ControladorLogistica cl = new ControladorLogistica(in, inc);
            ControladorIngresoC cic = new ControladorIngresoC(inc, in);
            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
            
            inc.setVisible(false);
            inc.setLocationRelativeTo(inc);
        }
        
}
