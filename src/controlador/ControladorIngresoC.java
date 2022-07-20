package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Ciudad;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.Paquete;
import modelo.PaqueteDAO;
import vista.FrmIngresoC;
import vista.FrmInicio;
import vista.FrmInterfazCliente;
import vista.FrmRegistroPaquete;

/**
 *
 * @author SR. MORA
 */
public class ControladorIngresoC implements ActionListener, KeyListener{
    FrmInicio objVistaInicio = new FrmInicio();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmInterfazCliente objVistaInterfazC = new FrmInterfazCliente();
    FrmRegistroPaquete objVistaRegistroP = new FrmRegistroPaquete();
    ClienteDAO objClienteDAO = new ClienteDAO();
    PaqueteDAO objPaqueteDAO = new PaqueteDAO();
    String nombreC;
    
    public ControladorIngresoC(FrmIngresoC ingreso, FrmInicio inicio, FrmInterfazCliente interfazC, 
            FrmRegistroPaquete registrop, ClienteDAO cdao, PaqueteDAO pdao){
        objVistaIngresoC = ingreso;
        objVistaInicio = inicio;
        objVistaInterfazC = interfazC;
        objVistaRegistroP = registrop;
        objClienteDAO = cdao;
        objPaqueteDAO = pdao;
        
        
        objVistaIngresoC.btnIngresarC.addActionListener(this);
        objVistaIngresoC.btnRegresar.addActionListener(this);
        objVistaInterfazC.btnCerrarSesion.addActionListener(this);
        objVistaInterfazC.btnRegistrarP.addActionListener(this);
        
        objVistaRegistroP.btnRegistrarP.addActionListener(this);
        objVistaRegistroP.btnCerrar.addActionListener(this);

        
        //CIUDAD 1
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.AMBATO.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.AZOGUES.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.CUENCA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.ESMERALDAS.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.GUARANDA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.GUAYAQUIL.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.IBARRA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.LATACUNGA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.LOJA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.MACHALA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.MANTA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.QUITO.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.RIOBAMBA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.STO_DOMINGO.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.TENA.name());
        objVistaRegistroP.cmbCiudad1.addItem(Ciudad.TULCAN.name());
        
        //CIUDAD 2
        
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.AMBATO.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.AZOGUES.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.CUENCA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.ESMERALDAS.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.GUARANDA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.GUAYAQUIL.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.IBARRA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.LATACUNGA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.LOJA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.MACHALA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.MANTA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.QUITO.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.RIOBAMBA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.STO_DOMINGO.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.TENA.name());
        objVistaRegistroP.cmbCiudad2.addItem(Ciudad.TULCAN.name());
    }
    //ABSTRACT METODS
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==objVistaIngresoC.btnRegresar){
            objVistaInicio.setVisible(true);
            objVistaIngresoC.setVisible(false);
            
        }
        
        if(e.getSource()==objVistaIngresoC.btnIngresarC){
        
            Cliente clientevr = new Cliente(objVistaIngresoC.txtUsuarioC.getText(),
            objVistaIngresoC.jPwClaveC.getText());
            
            Cliente clientecheck = objClienteDAO.buscarCliente(clientevr);
            
            if(clientecheck.getUsuario().equals(objVistaIngresoC.txtUsuarioC.getText())
                    &&clientecheck.getClave().equals(objVistaIngresoC.jPwClaveC.getText())){
                JOptionPane.showMessageDialog(null, "Datos Correctos en la BD");
    
                nombreC=objVistaIngresoC.txtUsuarioC.getText();
                objVistaInterfazC.setVisible(true);
                insertarNombre();
                objVistaIngresoC.setVisible(false);
                }else{
                JOptionPane.showMessageDialog(null, "ERROR, clave incorrecta");
                }  
            
            limpiarElementos();
            
        }
        
        if(e.getSource()==objVistaInterfazC.btnCerrarSesion){
            objVistaInterfazC.setVisible(false);
            objVistaIngresoC.setVisible(true);
            System.out.println("SESION CERRADA");
            JOptionPane.showMessageDialog(null, "SESION FINALIZADA!");
        }
        
        if(e.getSource()==objVistaInterfazC.btnRegistrarP){
            
            objVistaRegistroP.setVisible(true);
            objVistaInterfazC.setVisible(false);
            
            
            System.out.println("registrar paquete");
        }
         if(e.getSource()==objVistaRegistroP.btnCerrar){
                System.out.println("CERRANDO");
                objVistaRegistroP.setVisible(false);
                objVistaInterfazC.setVisible(true);
            }
            
            if(e.getSource()==objVistaRegistroP.btnRegistrarP){
                System.out.println("REGISTRANDO");
                String emisorU  = objVistaRegistroP.txtEmisor.getText();
            String receptorU = objVistaRegistroP.txtReceptor.getText();
            String codigoP = objVistaRegistroP.txtCodigo.getText();
            double pesoP = Double.valueOf(objVistaRegistroP.txtPeso.getText());
            String ciudad1 = objVistaRegistroP.cmbCiudad1.getSelectedItem().toString();
            String ciudad2 = objVistaRegistroP.cmbCiudad2.getSelectedItem().toString();
            String direccion1 = objVistaRegistroP.txtDireccion1.getText();
            String direccion2 = objVistaRegistroP.txtDireccion2.getText();
            
            Paquete objPaquete = new Paquete(emisorU, receptorU, codigoP, pesoP, ciudad1,
            ciudad2, direccion1, direccion2);
            objPaqueteDAO.insertarPaquete(objPaquete);
            objClienteDAO.ObtenerNombre(objVistaInterfazC.jLnombreSet.getText());
            objClienteDAO.insertarPaquete(objPaquete);
            JOptionPane.showMessageDialog(null, "Paquete Registrado");  
            limpiarElementosPaquete();
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
    objVistaIngresoC.txtUsuarioC.setText("");
    objVistaIngresoC.jPwClaveC.setText("");
    }
    
    public void insertarNombre(){
    objVistaInterfazC.jLnombreSet.setText(nombreC);
    }
    
    public void limpiarElementosPaquete(){
        objVistaRegistroP.txtEmisor.setText("");
        objVistaRegistroP.txtReceptor.setText("");
        objVistaRegistroP.txtCodigo.setText("");
        objVistaRegistroP.txtPeso.setText("");
        objVistaRegistroP.txtDireccion1.setText("");
        objVistaRegistroP.txtDireccion2.setText("");
    }
    }
    


