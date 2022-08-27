package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.PaqueteDAO;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmInterfazEmpleado;

public class ControladorIngresoE implements ActionListener, KeyListener{
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    FrmInicio objVistaInicio= new FrmInicio();
    FrmInterfazEmpleado objVistaEmpleadoP = new FrmInterfazEmpleado();
    FrmIngresarPaquete objVistaIngresarP = new FrmIngresarPaquete();
    EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    PaqueteDAO objPaqueteDAO = new PaqueteDAO();
    
    String nombreE, codigoE;
    public ControladorIngresoE(FrmIngresoE ingresoe, FrmInicio inicio, FrmInterfazEmpleado empleadoP, FrmIngresarPaquete ingresarPaquete) {
        objVistaIngresoE = ingresoe;
        objVistaInicio = inicio;
        objVistaEmpleadoP = empleadoP;
        objVistaIngresarP = ingresarPaquete;
        
  
        objVistaIngresoE.btnContinuarE.addActionListener(this);
        objVistaIngresoE.btnRegresar.addActionListener(this);
        objVistaEmpleadoP.btnCerrarSesionE.addActionListener(this);
        objVistaEmpleadoP.btnIngresarPaquete.addActionListener(this);
        
        //INGRESO PAQUETE
        objVistaIngresarP.btnRegresarE.addActionListener(this);
        objVistaIngresarP.btnVerRecibo.addActionListener(this);
        objVistaIngresarP.btnIngresar.addActionListener(this);
        
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==objVistaIngresoE.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoE.setVisible(false);
        }
        if(e.getSource()==objVistaEmpleadoP.btnCerrarSesionE){
            objVistaIngresoE.setVisible(true);
            objVistaEmpleadoP.setVisible(false);
            System.out.println("SESION CERRADA");
            JOptionPane.showMessageDialog(null, "SESION FINALIZADA!");
        }
        if(e.getSource()==objVistaIngresarP.btnRegresarE){
            objVistaEmpleadoP.setVisible(true);
            objVistaIngresarP.setVisible(false);
        }
        if(e.getSource()==objVistaIngresoE.btnContinuarE){
            Empleado empleadovr = new Empleado(objVistaIngresoE.txtCodigoEmpleado.getText(),
            objVistaIngresoE.jPwClaveE.getText());
            
            Empleado empleadocheck = objEmpleadoDAO.verificarEmpleado(empleadovr);
            
            if(empleadocheck.getCodigoemp().equals(objVistaIngresoE.txtCodigoEmpleado.getText())
                    &&empleadocheck.getClave().equals(objVistaIngresoE.jPwClaveE.getText())){
            JOptionPane.showMessageDialog(null, "Datos Correctos en la BD");
            codigoE=objVistaIngresoE.txtCodigoEmpleado.getText();
                objVistaEmpleadoP.setVisible(true);
                insertarNombre();
                objVistaIngresoE.setVisible(false);
            }else{
            JOptionPane.showMessageDialog(null, "ERROR, Clave incorrecta");
            }
            
            limpiarElementos();
            
        }
        
        if(e.getSource()==objVistaEmpleadoP.btnIngresarPaquete){
            objVistaIngresarP.setVisible(true);
            objVistaEmpleadoP.setVisible(false);
        }
        
        if(e.getSource()==objVistaIngresarP.btnIngresar){
        
            System.out.println("INGRESANDO PAQUETE");
            String codigoP = objVistaIngresarP.txtIngresar.getText();
            
            JOptionPane.showMessageDialog(null, "Paquete Agregado");
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
    
    public void limpiarElementos(){
    objVistaIngresoE.txtCodigoEmpleado.setText("");
    objVistaIngresoE.jPwClaveE.setText("");
    }
    
    public void insertarNombre(){
        objVistaEmpleadoP.jLcodigoEmpset.setText(codigoE);
    }
}
