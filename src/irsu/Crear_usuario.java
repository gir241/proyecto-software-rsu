/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

import java.awt.Color;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author rsuinformatica
 */
public class Crear_usuario extends javax.swing.JFrame {
    public String rut;
    public String nombre;
    public String apellido;
    public String actividad;
    public String ciudad;
    public String comuna;
    public String carrera;
    public String telefono;
    public String celular;
    public String direccion;
    public String email;

    
    public Boolean validacion(){
        
        if(!jTextField_Nombres.getText().toString().isEmpty()) {return false;}
        if(!jTextField_Apellidos.getText().toString().isEmpty()) {return false;}
        if(!jTextField_email.getText().toString().isEmpty()){ return false;}
        
        return true;
    }
    
    public void actualizar_variables(){
    rut = rud.getText() + dv.getText();
    nombre = jTextField_Nombres.getText();
    apellido = jTextField_Apellidos.getText();
    actividad = jComboBox_Actividad.getSelectedItem().toString();
    comuna  = jComboBox_Comuna.getSelectedItem().toString();
    carrera = jComboBox_Carrera.getSelectedItem().toString();
    telefono = jTextField_Telefono.getText();
    celular = jTextField_Celular.getText();
    direccion = jTextField_Direccion.getText();
    email = jTextField_email.getText();
    }
    
    public void Agregar_usuario(){
        
    Connection con = null;
    Statement st = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        st = con.createStatement();
        st.executeUpdate("INSERT INTO USUARIO VALUES ('"+rut+ "','"+nombre+
                "','"+apellido+"','"+actividad+"','"+comuna+"','"+carrera+ 
                "','"+telefono +"','"+celular+"','"+direccion+"','"+ email+"');");
        JOptionPane.showMessageDialog(null,"Datos agregados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){
          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al crear usuario");

      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
       finally{
          st.close();
          con.close();
      }
  }
        catch (Exception e){
        e.printStackTrace();
    }
    
    }
    /**
     * Creates new form Crear_usuario
     */
    public Crear_usuario() {
        initComponents();
          Fecha iniciar = new Fecha();
          jLabel_Fecha.setText(iniciar.fechaActual()); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        rud = new javax.swing.JTextField();
        jTextField_Nombres = new javax.swing.JTextField();
        jTextField_Apellidos = new javax.swing.JTextField();
        jComboBox_Actividad = new javax.swing.JComboBox();
        jComboBox_Carrera = new javax.swing.JComboBox();
        jComboBox_Comuna = new javax.swing.JComboBox();
        jTextField_Direccion = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jTextField_Celular = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        dv = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        jLabel_Fecha = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_email = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Registro de usuario:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("iRSU");

        jLabel6.setText("Informatica Responsabilidad Social Universitaria");

        jLabel3.setText("*Nombres:");

        jLabel4.setText("*Run:");

        jLabel7.setText("Carrera:");

        jLabel8.setText("*Apellidos:");

        jLabel9.setText("Actividad:");

        jLabel10.setText("Direccion:");

        jLabel11.setText("Comuna:");

        rud.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                rudKeyTyped(evt);
            }
        });

        jTextField_Nombres.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_NombresKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_NombresKeyTyped(evt);
            }
        });

        jTextField_Apellidos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ApellidosKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ApellidosKeyTyped(evt);
            }
        });

        jComboBox_Actividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ESTUDIANTE", "PROFESOR ", "OTRO" }));

        jComboBox_Carrera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21030", "21041" }));

        jComboBox_Comuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alhué", "Buin", "Calera de Tango", "Cerrillos", "Cerro Navia", "Colina", "Conchalí", "Curacaví", "El Bosque", "El Monte", "Estación Central", "Huechuraba", "Independencia", "Isla de Maipo", "La Cisterna", "La Florida", "La Granja", "Lampa", "La Pintana", "La Reina", "Las Condes", "Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "María Pinto", "Melipilla", "Ñuñoa", "Paine", "Padre Hurtado", "Pedro Aguirre Cerda", "Peñaflor", "Peñalolén", "Pirque", "Providencia", "Pudahuel", "Puente Alto", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "San Bernardo", "San Joaquín", "San José de Maipo", "San Miguel", "San Pedro", "San Ramón", "Santiago", "Talagante", "Til Til" }));

        jTextField_Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_DireccionKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DireccionKeyTyped(evt);
            }
        });

        jLabel13.setText("Celular:");

        jLabel14.setText("Telefono:");

        jLabel15.setText("*email:");

        jTextField_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelefonoKeyTyped(evt);
            }
        });

        jTextField_Celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CelularKeyTyped(evt);
            }
        });

        jTextField_email.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_emailFocusLost(evt);
            }
        });
        jTextField_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_emailKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_emailKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_emailKeyTyped(evt);
            }
        });

        dv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                dvKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dvKeyTyped(evt);
            }
        });

        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Fecha.setText("00/00/00");

        jLabel_email.setText("                  ");

        jButton1.setText("Volver");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel_email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel3)
                                    .add(jLabel8))
                                .add(14, 14, 14)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                    .add(jTextField_Nombres, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .add(jTextField_Apellidos)))
                            .add(jLabel6)
                            .add(jLabel1)
                            .add(layout.createSequentialGroup()
                                .add(jLabel4)
                                .add(37, 37, 37)
                                .add(rud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(dv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 25, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                                        .add(layout.createSequentialGroup()
                                            .add(jButton_Guardar)
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .add(jButton1))
                                        .add(layout.createSequentialGroup()
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jLabel14)
                                                .add(jLabel9))
                                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                                .add(jTextField_Telefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 89, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jComboBox_Actividad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(jComboBox_Comuna, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                                    .add(jLabel11))
                                .add(27, 27, 27)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(layout.createSequentialGroup()
                                        .add(jLabel7)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                        .add(jComboBox_Carrera, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 77, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(layout.createSequentialGroup()
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel10)
                                            .add(jLabel13))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jTextField_Direccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(layout.createSequentialGroup()
                                                .add(jTextField_Celular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                                .add(22, 22, 22)
                                                .add(jLabel15)
                                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                                .add(jTextField_email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 207, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 83, Short.MAX_VALUE)
                        .add(jLabel_Fecha)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(19, 19, 19)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel1)
                    .add(jLabel_Fecha))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(rud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel3)
                            .add(jTextField_Nombres, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField_Apellidos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel8))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel9)
                            .add(jComboBox_Actividad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel11)
                            .add(jComboBox_Comuna, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField_Telefono, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel14)))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jLabel7)
                            .add(jComboBox_Carrera, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel10)
                            .add(jTextField_Direccion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField_Celular, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel15)
                            .add(jTextField_email, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel13))))
                .add(26, 26, 26)
                .add(jLabel_email)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 43, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jButton_Guardar)
                    .add(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rudKeyTyped
        // TODO add your handling code here:
        int limite=8;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||rud.getText().length()== limite) 
        {evt.consume();}        
    }//GEN-LAST:event_rudKeyTyped

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        // TODO add your handling code here:
          Boolean continuar= true;
          SQL consulta = new SQL();
          try {
            try {
                if(consulta.validar("run_admin","ADMIN","run_admin",rut))  //enviar datos a validar
                {
                    continuar=false;
                    JOptionPane.showMessageDialog(this,"El rut de usuario ya se encuentra ingresado");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Crear_usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Crear_admin.class.getName()).log(Level.SEVERE, null, ex);
        }
;
    if(rud.getText().equals("")){
      JOptionPane.showMessageDialog(this,"Debe completar el run");
      continuar= false;
    }
     if(validacion())
   {continuar = false;}
    else{
        int rut = Integer.parseInt(rud.getText());//parseo tipo entero el run y guardo en rut
        String verificador = dv.getText();//guardo digito verificador en digito del tipo string
        validaRut comprobar = new validaRut();//instancio la clase validaRut
       
           if(comprobar.digitoVerificador(rut).equals(verificador)){
            //JOptionPane.showMessageDialog(error,"RUN correcto");
            // en vez de que nos envie ese mensaje nos puede mandar que esta correcto en un label con algun signo positivo
           }
           else{
            JOptionPane.showMessageDialog(this,"Ingrese correctamente el RUN");
             continuar= false;
           }
    }

    if(continuar){
        actualizar_variables();
       Agregar_usuario();
       }
        
   
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void jTextField_TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TelefonoKeyTyped
        // TODO add your handling code here:
         int limite = 10;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||jTextField_Telefono.getText().length() == limite) 
        {evt.consume();}
    }//GEN-LAST:event_jTextField_TelefonoKeyTyped

    private void jTextField_CelularKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CelularKeyTyped
        // TODO add your handling code here:
        int limite =10;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||jTextField_Celular.getText().length() == limite) 
        {evt.consume();}
    }//GEN-LAST:event_jTextField_CelularKeyTyped

    private void dvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyReleased
        // TODO add your handling code here:
        dv.setText(dv.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_dvKeyReleased

    private void jTextField_NombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombresKeyReleased
        // TODO add your handling code here:
         //jTextField_Nombres.setText(jTextField_Nombres.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_NombresKeyReleased

    private void jTextField_ApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApellidosKeyReleased
        // TODO add your handling code here:
         //jTextField_Apellidos.setText(jTextField_Apellidos.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_ApellidosKeyReleased

    private void jTextField_DireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DireccionKeyReleased
        // TODO add your handling code here:
        //jTextField_Direccion.setText(jTextField_Direccion.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_DireccionKeyReleased

    private void jTextField_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyReleased
        // TODO add your handling code here:
        //jTextField_email.setText(jTextField_email.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_emailKeyReleased

    private void dvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyTyped
        // TODO add your handling code here:
        int limite =1;
        if (dv.getText().length() == limite){evt.consume();} 
    }//GEN-LAST:event_dvKeyTyped

    private void jTextField_NombresKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombresKeyTyped
        // TODO add your handling code here:
        int limite = 23;
        char car = evt.getKeyChar();
        if (!(car<'0' || car>'9')||jTextField_Nombres.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_NombresKeyTyped

    private void jTextField_ApellidosKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApellidosKeyTyped
        // TODO add your handling code here:
        int limite = 23;
        char car = evt.getKeyChar();
        if (!(car<'0' || car>'9')||jTextField_Apellidos.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_ApellidosKeyTyped

    private void jTextField_DireccionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DireccionKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DireccionKeyPressed

    private void jTextField_DireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DireccionKeyTyped
        // TODO add your handling code here:
        int limite = 35;
        if (jTextField_Direccion.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_DireccionKeyTyped

    private void jTextField_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyTyped
        // TODO add your handling code here:
        int limite = 35;
        if (jTextField_email.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_emailKeyTyped

    private void jTextField_emailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_emailFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField_emailFocusLost

    private void jTextField_emailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyPressed
        // TODO add your handling code here:
        validaMail valida = new validaMail();
       //jLabel_email.setText( valida.Alerta(valida.isEmail(jTextField_email.getText())));
         boolean a = valida.isEmail(jTextField_email.getText());
         if(a==true)
        {
            jLabel_email.setForeground(Color.green);
            jLabel_email.setText("email Correcto");                  
        }
        else
        {          
            jLabel_email.setForeground(Color.red);
            jLabel_email.setText("email Incorrecto"); 
        }    
    }//GEN-LAST:event_jTextField_emailKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Pantalla_principal cancelar= new Pantalla_principal();
        cancelar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_usuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField dv;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JComboBox jComboBox_Actividad;
    private javax.swing.JComboBox jComboBox_Carrera;
    private javax.swing.JComboBox jComboBox_Comuna;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField_Apellidos;
    private javax.swing.JTextField jTextField_Celular;
    private javax.swing.JTextField jTextField_Direccion;
    private javax.swing.JTextField jTextField_Nombres;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField rud;
    // End of variables declaration//GEN-END:variables
}
