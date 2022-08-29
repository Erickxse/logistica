
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Gerente;
import modelo.GerenteDAO;
import modelo.TransporteDAO;
import vista.FrmBorrarEmpleado;
import vista.FrmBorrarTransporte;
import vista.FrmGerencia;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;
import vista.FrmTransporte;

public class ControladorInterfazGerencia implements ActionListener{
    
    FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
    FrmGerencia objVistaGerencia = new FrmGerencia();
    FrmRegistrarE objVistaRegistrarE = new FrmRegistrarE();
    FrmTransporte objVistaTransporte = new FrmTransporte();
    FrmBorrarEmpleado objVistaBorrarE = new FrmBorrarEmpleado();
    FrmBorrarTransporte objVistaBorrarT = new FrmBorrarTransporte();
    GerenteDAO objGerenteDAO = new GerenteDAO();
    EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    TransporteDAO objTransporteDAO = new TransporteDAO();

    public ControladorInterfazGerencia(FrmInterfazGerencia interfazgerencia, FrmGerencia gerencia, FrmRegistrarE registrar, FrmTransporte transporte,
    FrmBorrarEmpleado borrare, FrmBorrarTransporte borrart){
        objVistaInterfazGerencia = interfazgerencia;
        objVistaGerencia = gerencia;
        objVistaRegistrarE = registrar;
        objVistaTransporte = transporte;
        objVistaBorrarE = borrare;
        objVistaBorrarT = borrart;
        
        objVistaInterfazGerencia.btnAgregarE.addActionListener(this);
        objVistaInterfazGerencia.btnAgregarT.addActionListener(this);
        objVistaInterfazGerencia.btnCerrarSesion.addActionListener(this);
        objVistaInterfazGerencia.btnEliminarE.addActionListener(this);
        objVistaBorrarE.btnEliminarE.addActionListener(this);
        objVistaBorrarE.btnRegresar.addActionListener(this);
        objVistaBorrarT.btnRegresar.addActionListener(this);
        objVistaBorrarT.btnEliminarT.addActionListener(this);
        objVistaInterfazGerencia.btnQuitarT.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaInterfazGerencia.btnAgregarE){
        objVistaRegistrarE.setVisible(true);
        objVistaInterfazGerencia.setVisible(false);
        }
        if(e.getSource()==objVistaInterfazGerencia.btnAgregarT){
        objVistaTransporte.setVisible(true);
        objVistaInterfazGerencia.setVisible(false);
        }
        if(e.getSource()==objVistaInterfazGerencia.btnCerrarSesion){
        objVistaGerencia.setVisible(true);
        objVistaInterfazGerencia.setVisible(false);
        }
        if(e.getSource()==objVistaInterfazGerencia.btnEliminarE){
            //objVistaInterfazGerencia.setVisible(false);
            objVistaBorrarE.setVisible(true);
        }
        if(e.getSource()==objVistaBorrarE.btnEliminarE){
            String codigoE = objVistaBorrarE.txtCodigoE.getText();
            String codigoG = objVistaInterfazGerencia.lblAdmiGerente.getText();
            Empleado e1 = objEmpleadoDAO.obtenerEmpleado(codigoE);
            Gerente g1 = objGerenteDAO.obtenerGerente(codigoG);
            String ciudadE = e1.getCiudad();
            String ciudadG = g1.getSucursal();
            if(ciudadE == null ? ciudadG == null : ciudadE.equals(ciudadG)){
            objEmpleadoDAO.eliminarEmpleado(codigoE);
            JOptionPane.showMessageDialog(null, "Empleado Eliminado");
            }else if(ciudadE == null ? ciudadG == null : !ciudadE.equals(ciudadG)){
                    JOptionPane.showMessageDialog(null, "El Empleado no trabaja en Esta Sucursal");
        }
            objVistaBorrarT.txtCodigoT.setText("");
        }
        if(e.getSource()==objVistaBorrarE.btnRegresar){
            objVistaBorrarE.setVisible(false);
        }
        if(e.getSource()==objVistaInterfazGerencia.btnQuitarT){
            objVistaBorrarT.setVisible(true);
        }
        if(e.getSource()==objVistaBorrarT.btnRegresar){
            objVistaBorrarT.setVisible(false);
        }
        if(e.getSource()==objVistaBorrarT.btnEliminarT){
            objTransporteDAO.eliminarTransporte(objVistaBorrarT.txtCodigoT.getText());
            JOptionPane.showMessageDialog(null, "Vehiculo Eliminado");
            objVistaBorrarT.txtCodigoT.setText("");
        }
    }
 
}
