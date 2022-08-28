
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Paquete;
import modelo.PaqueteDAO;
import modelo.Transporte;
import modelo.TransporteDAO;
import vista.FrmIngresoE;
import vista.FrmInicioTransporte;
import vista.FrmInterfazGerencia;
import vista.FrmInterfazTransporte;
import vista.FrmTransporte;

public class ControladorTransporte implements ActionListener{

    FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
    TransporteDAO objTransporteDAO = new TransporteDAO();
    PaqueteDAO objPaqueteDAO = new PaqueteDAO();
    EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    FrmTransporte objVistaTransporte = new FrmTransporte();
    FrmInterfazTransporte objVistaITransporte = new FrmInterfazTransporte();
    FrmInicioTransporte objVistaInicioT = new FrmInicioTransporte();
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    Transporte objT = new Transporte();
    String codigoT;
    public ControladorTransporte(FrmTransporte vista, TransporteDAO dao, FrmInterfazGerencia interfaz,
            FrmInterfazTransporte inTrans, FrmInicioTransporte wtrans, FrmIngresoE ingresoE){
        objVistaTransporte = vista;
        objTransporteDAO = dao;
        objVistaInterfazGerencia = interfaz;
        objVistaITransporte = inTrans;
        objVistaInicioT = wtrans;
        objVistaIngresoE = ingresoE;
        
        //REGISTRO TRANSPORTE
        objVistaTransporte.btnAgregarT.addActionListener(this);
        objVistaTransporte.btnRegresar.addActionListener(this);
        
        //INICIO TRANSPORTE
        objVistaInicioT.btnIngresarT.addActionListener(this);
        objVistaInicioT.btnRegresar.addActionListener(this);
        
        //INTERFAZ TRANSPORTE
        objVistaIngresoE.btnTransporte.addActionListener(this);
        objVistaITransporte.btnRegresar.addActionListener(this);
        objVistaITransporte.btnDescargar.addActionListener(this);
    }
    
    public void limpiarElementos(){
        objVistaTransporte.txtPlacas.setText("");
        objVistaTransporte.txtnUnidad.setText("");
    
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaTransporte.btnAgregarT){
            String placa = objVistaTransporte.txtPlacas.getText();
            String codigoT = objVistaTransporte.txtnUnidad.getText();
            Transporte objTransporte = new Transporte(placa, codigoT);
            objTransporteDAO.insertarTransporte(objTransporte);
            JOptionPane.showMessageDialog(null, "Transporte Registrado");
            limpiarElementos();
        }
        if(e.getSource()==objVistaTransporte.btnRegresar){
            objVistaInterfazGerencia.setVisible(true);
            objVistaTransporte.setVisible(false);
        }
        if(e.getSource()==objVistaIngresoE.btnTransporte){
            objVistaIngresoE.setVisible(false);
            objVistaInicioT.setVisible(true);
        }
        if(e.getSource()==objVistaInicioT.btnRegresar){
            objVistaInicioT.setVisible(false);
            objVistaIngresoE.setVisible(true);
        }
        if(e.getSource()==objVistaInicioT.btnIngresarT){
        
            Transporte transportevr = new Transporte(objVistaInicioT.txtCodigoT.getText());
            
            Transporte transportecheck = objTransporteDAO.verificarTransporte(transportevr);
            
            if(transportecheck.getCodigoUnidad().equals(objVistaInicioT.txtCodigoT.getText())){
                JOptionPane.showMessageDialog(null, "Datos Correctos en la BD");
                codigoT=objVistaInicioT.txtCodigoT.getText();
                    objVistaInicioT.setVisible(false);
                    insertarCodigo();
                    objVistaITransporte.setVisible(true);
            }else{
            JOptionPane.showMessageDialog(null, "ERROR, No existe esta Unidad");
            
            }
        }
        
        if(e.getSource()==objVistaITransporte.btnRegresar){
            objVistaITransporte.setVisible(false);
            objVistaInicioT.setVisible(true);
            JOptionPane.showMessageDialog(null, "SESION CERRADA");
            objVistaInicioT.txtCodigoT.setText("");
        }
        if(e.getSource()==objVistaITransporte.btnDescargar){
           Paquete p1 = objPaqueteDAO.obtenerPaquete(
                   objVistaITransporte.txtCodigoPaq.getText());
           String ciudadp2 = p1.getCiudadP2();
           Empleado e1 = objEmpleadoDAO.obtenerEmpleado
        (objVistaITransporte.txtIDEmpleado.getText());
           String ciudade = e1.getCiudad();
           if(ciudadp2 == null ? ciudade == null : ciudadp2.equals(ciudade)){
               objEmpleadoDAO.ObtenerNombre
        (objVistaITransporte.txtIDEmpleado.getText());
               objEmpleadoDAO.insertarPaquete(p1);
               JOptionPane.showMessageDialog(null, "DESCARGADO");
               objPaqueteDAO.cambiarEstadoB(p1.getCodigoP());
              
           }else if(ciudadp2 == null ? ciudade != null : !ciudadp2.equals(ciudade)){
               JOptionPane.showMessageDialog(null, "Este Paquete va a "+ciudadp2);
           }
        }
         objVistaITransporte.txtCodigoPaq.setText("");
               objVistaITransporte.txtIDEmpleado.setText("");
    }
    
    public void insertarCodigo(){
        objVistaITransporte.jLblCodigo.setText(codigoT);
    }
    
}
