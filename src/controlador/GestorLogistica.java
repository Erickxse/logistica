package controlador;

import modelo.ClienteDAO;
import vista.FrmIngresoC;
import vista.FrmInicio;

public class GestorLogistica {
 
        public static void main(String args[]){
            FrmInicio in = new FrmInicio();
            ClienteDAO cdao = new ClienteDAO();
            FrmIngresoC inc = new FrmIngresoC();
            ControladorLogistica cl = new ControladorLogistica(in, cdao, inc);
            
            in.setVisible(true);
            in.setLocationRelativeTo(in);
        }
        
}
