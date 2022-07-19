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
import vista.FrmInicio;
import vista.FrmRegistroCliente;


public class ControladorRegistroC implements ActionListener, KeyListener{
    
    FrmRegistroCliente objVistaRegistroC = new FrmRegistroCliente();
    FrmInicio objVistaInicio = new FrmInicio();
    ClienteDAO objClienteDAO = new ClienteDAO();
    Paquete pVacio = new Paquete();
    ArrayList<Paquete> listapVacia = new ArrayList();
    

    public ControladorRegistroC(FrmRegistroCliente registro, FrmInicio inicio, ClienteDAO cdao ) {
        objVistaRegistroC = registro;
        objVistaInicio = inicio;
        objClienteDAO = cdao;
        
        
        objVistaRegistroC.btnRegresarIC.addActionListener(this);
        objVistaRegistroC.btnRegistrarC.addActionListener(this);
        
        //combo box
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.AMBATO.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.AZOGUES.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.CUENCA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.ESMERALDAS.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.GUARANDA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.GUAYAQUIL.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.IBARRA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.LATACUNGA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.LOJA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.MACHALA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.MANTA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.QUITO.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.RIOBAMBA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.STO_DOMINGO.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.TENA.name());
        objVistaRegistroC.cmbCiudadC.addItem(Ciudad.TULCAN.name());
        
        //otros
         listapVacia.add(pVacio);
               
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==objVistaRegistroC.btnRegresarIC) {
            objVistaInicio.setVisible(true);
            objVistaRegistroC.setVisible(false);
        }
        
        if(e.getSource()==objVistaRegistroC.btnRegistrarC){
            
          
            String nombre = objVistaRegistroC.txtNombre.getText();
            String apellido = objVistaRegistroC.txtApellido.getText();
            String usuario = objVistaRegistroC.txtUsuario.getText();
            String clave = objVistaRegistroC.txtClave.getText();
            String ciudad = objVistaRegistroC.cmbCiudadC.getSelectedItem().toString();
            String direccion = objVistaRegistroC.txtDireccion.getText();
            String nCedula = objVistaRegistroC.txtCedula.getText();
            String nCelular = objVistaRegistroC.txtTelefono.getText();
            ArrayList<Paquete> paquetesC = null;
                   
            
            Cliente objCliente = new Cliente(nombre, apellido, usuario, clave, ciudad, 
                    direccion, nCedula, nCelular, paquetesC);
            objClienteDAO.insertarCliente(objCliente);
            JOptionPane.showMessageDialog(null, "Registro Exitoso");
            objClienteDAO.inicializarLista(objVistaRegistroC.txtUsuario.getText());
            limpiarElementos();
        
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
    objVistaRegistroC.txtNombre.setText("");
    objVistaRegistroC.txtApellido.setText("");
    objVistaRegistroC.txtUsuario.setText("");
    objVistaRegistroC.txtDireccion.setText("");
    objVistaRegistroC.txtCedula.setText("");
    objVistaRegistroC.txtTelefono.setText("");
    objVistaRegistroC.txtClave.setText("");
    }
}
