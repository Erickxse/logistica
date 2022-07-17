package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmInterfazEmpleado;

public class ControladorIngresoE implements ActionListener, KeyListener{
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    FrmInicio objVistaInicio= new FrmInicio();
    FrmInterfazEmpleado objVistaEmpleadoP = new FrmInterfazEmpleado();
    FrmIngresarPaquete objVistaIngresarP = new FrmIngresarPaquete();

    public ControladorIngresoE(FrmIngresoE ingresoe, FrmInicio inicio, FrmInterfazEmpleado empleadoP, FrmIngresarPaquete ingresarPaquete) {
        objVistaIngresoE = ingresoe;
        objVistaInicio = inicio;
        objVistaEmpleadoP = empleadoP;
        objVistaIngresarP = ingresarPaquete;
        
        objVistaIngresoE.btnContinuarE.addActionListener(this);
        objVistaIngresoE.btnRegresar.addActionListener(this);
        objVistaEmpleadoP.btnRegresarIE.addActionListener(this);
        objVistaEmpleadoP.btnIngresarPaquete.addActionListener(this);
        objVistaIngresarP.btnRegresarE.addActionListener(this);
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==objVistaIngresoE.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoE.setVisible(false);
        }
        if(e.getSource()==objVistaEmpleadoP.btnRegresarIE){
            objVistaIngresoE.setVisible(true);
            objVistaEmpleadoP.setVisible(false);
        }
        if(e.getSource()==objVistaIngresarP.btnRegresarE){
            objVistaEmpleadoP.setVisible(true);
            objVistaIngresarP.setVisible(false);
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
