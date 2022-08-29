package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.EnumCiudad;
import modelo.Cliente;
import modelo.ClienteDAO;
import modelo.EnumEstado;
import modelo.Paquete;
import modelo.PaqueteDAO;
import modelo.Precio;
import vista.FrmIngresoC;
import vista.FrmInicio;
import vista.FrmInterfazCliente;
import vista.FrmRecibo;
import vista.FrmRegistroPaquete;

/**
 *
 * @author SR. MORA
 */

    

public class ControladorIngresoC implements ActionListener{
    FrmInicio objVistaInicio = new FrmInicio();
    FrmIngresoC objVistaIngresoC = new FrmIngresoC();
    FrmInterfazCliente objVistaInterfazC = new FrmInterfazCliente();
    FrmRegistroPaquete objVistaRegistroP = new FrmRegistroPaquete();
    FrmRecibo objVistaRecibo = new FrmRecibo();
    ClienteDAO objClienteDAO = new ClienteDAO();
    PaqueteDAO objPaqueteDAO = new PaqueteDAO();
    String nombreC;
    public static DefaultTableModel modelo;
    public ControladorIngresoC(FrmIngresoC ingreso, FrmInicio inicio, FrmInterfazCliente interfazC, 
            FrmRegistroPaquete registrop, FrmRecibo recibo, ClienteDAO cdao, PaqueteDAO pdao){
        objVistaIngresoC = ingreso;
        objVistaInicio = inicio;
        objVistaInterfazC = interfazC;
        objVistaRegistroP = registrop;
        objVistaRecibo = recibo;
        objClienteDAO = cdao;
        objPaqueteDAO = pdao;
        
            JTable tablaRecibo = objVistaRecibo.jTablaRecibo;
                modelo = (DefaultTableModel) tablaRecibo.getModel();
        
        objVistaIngresoC.btnIngresarC.addActionListener(this);
        objVistaIngresoC.btnRegresar.addActionListener(this);
        objVistaInterfazC.btnCerrarSesion.addActionListener(this);
        objVistaInterfazC.btnRegistrarP.addActionListener(this);
        objVistaInterfazC.btnRetirarP.addActionListener(this);
        objVistaRegistroP.btnRegistrarP.addActionListener(this);
        objVistaRegistroP.btnCerrar.addActionListener(this);
        objVistaInterfazC.btnVerRecibos.addActionListener(this);
        objVistaRecibo.btnBuscarCodigo.addActionListener(this);
        objVistaRecibo.btnRegresar.addActionListener(this);
        objVistaRecibo.btnBorrarElementos.addActionListener(this);
        
        

        
        //CIUDAD 1
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.AMBATO.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.AZOGUES.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.CUENCA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.ESMERALDAS.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.GUARANDA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.GUAYAQUIL.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.IBARRA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.LATACUNGA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.LOJA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.MACHALA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.MANTA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.QUITO.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.RIOBAMBA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.STO_DOMINGO.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.TENA.name());
        objVistaRegistroP.cmbCiudad1.addItem(EnumCiudad.TULCAN.name());
        
        //CIUDAD 2
        
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.AMBATO.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.AZOGUES.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.CUENCA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.ESMERALDAS.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.GUARANDA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.GUAYAQUIL.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.IBARRA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.LATACUNGA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.LOJA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.MACHALA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.MANTA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.QUITO.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.RIOBAMBA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.STO_DOMINGO.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.TENA.name());
        objVistaRegistroP.cmbCiudad2.addItem(EnumCiudad.TULCAN.name());
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
            
            Cliente clientecheck = objClienteDAO.verificarCliente(clientevr);
            
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
            double precioP = pesoP*Precio.PRECIO;
                System.out.println("Precio Final: "+precioP);
            Paquete objPaquete = new Paquete(emisorU, receptorU, codigoP, pesoP, ciudad1,
            ciudad2, direccion1, direccion2, precioP, EnumEstado.CLIENTE.toString());
            objPaqueteDAO.insertarPaquete(objPaquete);
            objClienteDAO.ObtenerNombre(objVistaInterfazC.jLnombreSet.getText());
            objClienteDAO.insertarPaqueteC(objPaquete);
            JOptionPane.showMessageDialog(null, "Paquete Registrado");  
            limpiarElementosPaquete();
            }
            
            if(e.getSource()==objVistaInterfazC.btnVerRecibos){
                objVistaInterfazC.setVisible(false);
                objVistaRecibo.setVisible(true);
            }
            
            if(e.getSource()==objVistaRecibo.btnRegresar){
                objVistaRecibo.setVisible(false);
                objVistaInterfazC.setVisible(true);
            }
            if(e.getSource()==objVistaRecibo.btnBuscarCodigo){
                String texto = objVistaRecibo.txtCodigoBuscar.getText();
                Paquete pq = null;
                System.out.println(texto);
                if(!texto.equals("")&&!texto.equals(null)){
                    System.out.println("INGRESO");
                pq = objPaqueteDAO.obtenerPaquete(texto);
                String vector[] = new String[5];
                vector[0]=pq.getCodigoP();
                vector[1]=pq.getCiudadP1();
                vector[2]=pq.getCiudadP2();
                vector[3]=String.valueOf(pq.getpFinal());
                vector[4]=pq.getEstado();
                modelo.addRow(vector);
                }
                    
            }
            
            if(e.getSource()==objVistaInterfazC.btnRetirarP){
                Paquete p1 = objPaqueteDAO.obtenerPaquete(objVistaInterfazC.txtCodigoRetiro.getText());
                Cliente c1 = objClienteDAO.obtenerCliente(objVistaInterfazC.jLnombreSet.getText());
                String cedulaC1 = c1.getnCedula();
                String ciudadC1 = c1.getCiudad();
                String ciudadPq2 = p1.getCiudadP2();
                String cedulaPq = p1.getCedula2();
                if(cedulaC1 == null ? cedulaPq == null : cedulaC1.equals(cedulaPq)
                        && ciudadC1 == null ? ciudadPq2 == null : ciudadC1.equals(ciudadPq2)){
                objPaqueteDAO.cambiarEstadoR(objVistaInterfazC.txtCodigoRetiro.getText());
                JOptionPane.showMessageDialog(null, "RETIRADO");
                }else if(cedulaC1 == null ? cedulaPq != null : !cedulaC1.equals(cedulaPq)
                        && ciudadC1 == null ? ciudadPq2 != null : !ciudadC1.equals(ciudadPq2)){
                    JOptionPane.showMessageDialog(null, "Identidad No Valida");
                }
                objVistaInterfazC.txtCodigoRetiro.setText("");
            }
            
            if(e.getSource()==objVistaRecibo.btnBorrarElementos){
                //BORRAR
            }
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
    


