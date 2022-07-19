
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.Transporte;
import modelo.TransporteDAO;
import vista.FrmInterfazGerencia;
import vista.FrmTransporte;

public class ControladorTransporte implements ActionListener{

    FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
    
    TransporteDAO objTransporteDAO = new TransporteDAO();
    FrmTransporte objVistaTransporte = new FrmTransporte();
    Transporte objT = new Transporte();
    
    public ControladorTransporte(FrmTransporte vista, TransporteDAO dao, FrmInterfazGerencia interfaz){
        objVistaTransporte = vista;
        objTransporteDAO = dao;
        objVistaInterfazGerencia = interfaz;
        
        objVistaTransporte.btnAgregarT.addActionListener(this);
        objVistaTransporte.btnRegresar.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaTransporte.btnAgregarT){
            String placa = objVistaTransporte.txtPlacas.getText();
            int numero = Integer.valueOf(objVistaTransporte.txtnUnidad.getText());
            Transporte objTransporte = new Transporte(placa, numero);
            objTransporteDAO.insertarTransporte(objTransporte);
        }
        if(e.getSource()==objVistaTransporte.btnRegresar){
            objVistaInterfazGerencia.setVisible(true);
            objVistaTransporte.setVisible(false);
        }
        
    }
    
    
    
}
