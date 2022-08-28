package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;
import modelo.Empleado;
import modelo.EmpleadoDAO;
import modelo.Paquete;
import modelo.PaqueteDAO;
import modelo.TransporteDAO;
import vista.FrmEnviarP;
import vista.FrmIngresarPaquete;
import vista.FrmIngresoE;
import vista.FrmInicio;
import vista.FrmInterfazEmpleado;

public class ControladorIngresoE implements ActionListener, KeyListener{
    FrmIngresoE objVistaIngresoE = new FrmIngresoE();
    FrmInicio objVistaInicio= new FrmInicio();
    FrmInterfazEmpleado objVistaEmpleadoP = new FrmInterfazEmpleado();
    FrmIngresarPaquete objVistaIngresarP = new FrmIngresarPaquete();
    FrmEnviarP objVistaEnviarP = new FrmEnviarP();
    EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    PaqueteDAO objPaqueteDAO = new PaqueteDAO();
    TransporteDAO objTransporteDAO = new TransporteDAO();
    
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
        objVistaEmpleadoP.btnEnviarPqt.addActionListener(this);
        
        //INGRESO TRANSPORTE
        
        objVistaIngresoE.btnTransporte.addActionListener(this);
        //INGRESO PAQUETE
        objVistaIngresarP.btnRegresarE.addActionListener(this);
        objVistaIngresarP.btnVerRecibo.addActionListener(this);
        objVistaIngresarP.btnIngresar.addActionListener(this);
        
        //ENVIO PAQUETE
        objVistaEnviarP.btnRegresar.addActionListener(this);
        objVistaEnviarP.btnEnviarT.addActionListener(this);
        
        
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
        
            System.out.println("INGRESANDO PAQUETE A EMPLEADO");
            String codigoP = objVistaIngresarP.txtIngresar.getText();
            
            String emisorU = objPaqueteDAO.obtenerPaquete(codigoP).getCedula1();
            String receptorU = objPaqueteDAO.obtenerPaquete(codigoP).getCedula2();
            double pesoP = Double.valueOf(objPaqueteDAO.obtenerPaquete(codigoP).getPesoP());
            String ciudad1 = objPaqueteDAO.obtenerPaquete(codigoP).getCiudadP1();
            String ciudad2= objPaqueteDAO.obtenerPaquete(codigoP).getCiudadP2();
            String direccion1 = objPaqueteDAO.obtenerPaquete(codigoP).getDireccionP1();
            String direccion2 = objPaqueteDAO.obtenerPaquete(codigoP).getDireccionP2();
            
            Paquete objPaquete = new Paquete(emisorU, receptorU, codigoP, pesoP, ciudad1,
                    ciudad2, direccion1, direccion2);
            
            objEmpleadoDAO.ObtenerNombre(objVistaEmpleadoP.jLcodigoEmpset.getText());
            objEmpleadoDAO.insertarPaquete(objPaquete);
            JOptionPane.showMessageDialog(null, "Paquete Agregado");
        }
        
        if(e.getSource()==objVistaEmpleadoP.btnEnviarPqt){
            objVistaEmpleadoP.setVisible(false);
            objVistaEnviarP.setVisible(true);
        }
        
        if(e.getSource()==objVistaEnviarP.btnRegresar){
            objVistaEnviarP.setVisible(false);
            objVistaEmpleadoP.setVisible(true);
        }
        
        if(e.getSource()==objVistaEnviarP.btnEnviarT){
            System.out.println("ENVIANDO A TRANSPORTE");
            String codigoP = objVistaEnviarP.txtCodigoP.getText();
            String emisorU = objPaqueteDAO.obtenerPaquete(codigoP).getCedula1();
            String receptorU = objPaqueteDAO.obtenerPaquete(codigoP).getCedula2();
            double pesoP = Double.valueOf(objPaqueteDAO.obtenerPaquete(codigoP).getPesoP());
            String ciudad1 = objPaqueteDAO.obtenerPaquete(codigoP).getCiudadP1();
            String ciudad2 = objPaqueteDAO.obtenerPaquete(codigoP).getCiudadP2();
            String direccion1 = objPaqueteDAO.obtenerPaquete(codigoP).getDireccionP1();
            String direccion2 = objPaqueteDAO.obtenerPaquete(codigoP).getDireccionP2();
            
            Paquete objPaquete = new Paquete(emisorU, receptorU, codigoP, pesoP, ciudad1,
            ciudad2, direccion1, direccion2);
            
           objTransporteDAO.obtenerCodigoT(objVistaEnviarP.txtCodigoV.getText());
           objTransporteDAO.insertarPaquete(objPaquete);
           JOptionPane.showMessageDialog(null, "Paquete Enviado a Transporte "+codigoP);
           
           objVistaEnviarP.txtCodigoP.setText("");
           objVistaEnviarP.txtCodigoV.setText("");
            
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
