
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import vista.FrmBorrarEmpleado;
import vista.FrmGerencia;
import vista.FrmInterfazGerencia;
import vista.FrmRegistrarE;
import vista.FrmTransporte;

public class ControladorInterfazGerencia implements ActionListener, KeyListener{
    
    FrmInterfazGerencia objVistaInterfazGerencia = new FrmInterfazGerencia();
    FrmGerencia objVistaGerencia = new FrmGerencia();
    FrmRegistrarE objVistaRegistrarE = new FrmRegistrarE();
    FrmTransporte objVistaTransporte = new FrmTransporte();
    FrmBorrarEmpleado objVistaBorrarE = new FrmBorrarEmpleado();

    public ControladorInterfazGerencia(FrmInterfazGerencia interfazgerencia, FrmGerencia gerencia, FrmRegistrarE registrar, FrmTransporte transporte,
    FrmBorrarEmpleado borrare){
        objVistaInterfazGerencia = interfazgerencia;
        objVistaGerencia = gerencia;
        objVistaRegistrarE = registrar;
        objVistaTransporte = transporte;
        objVistaBorrarE = borrare;
        
        objVistaInterfazGerencia.btnAgregarE.addActionListener(this);
        objVistaInterfazGerencia.btnAgregarT.addActionListener(this);
        objVistaInterfazGerencia.btnCerrarSesion.addActionListener(this);
        objVistaBorrarE.btnEliminarE.addActionListener(this);
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
        
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
