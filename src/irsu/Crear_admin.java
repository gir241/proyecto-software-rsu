/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author joel
 */
public class Crear_admin extends javax.swing.JFrame {
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
    public String contraseña;
    
    public void actualizar_variables(){
    rut = rud.getText().toString() + dv.getText().toString() ;
    nombre = jTextField_Nombres.getText();
    apellido = jTextField_Apellidos.getText();
    actividad = jComboBox_Actividad.getSelectedItem().toString();
    comuna  = jComboBox_Comuna.getSelectedItem().toString();
    carrera = jComboBox_Carrera.getSelectedItem().toString();
    telefono = jTextField_Telefono.getText();
    celular = jTextField_Celular.getText();
    direccion = jTextField_Direccion.getText();
    email = jTextField_email.getText();
    contraseña = new String(jPasswordField_Contraseña.getPassword());
    }
    
    public void Agregar_admin(){
        
    Statement st = null;
    Connection con = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        st = con.createStatement();
       st.executeUpdate("INSERT INTO ADMIN "
                + "VALUES ('"+rut+ "','"+nombre+
                "','"+apellido+"','"+actividad+"','"+comuna+"','"+carrera+ 
                "','"+telefono +"','"+celular+"','"+direccion+"','"+ email+"','"
                +contraseña+"');");
        JOptionPane.showMessageDialog(null,"Datos agregados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al crear administrador");

      
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
     * Creates new form Crear_admin
     */
    public Crear_admin() {
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

        jLabel8 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        dv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField_Celular = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton_Guardar = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        rud = new javax.swing.JTextField();
        jTextField_Nombres = new javax.swing.JTextField();
        jTextField_Apellidos = new javax.swing.JTextField();
        jComboBox_Actividad = new javax.swing.JComboBox();
        jComboBox_Carrera = new javax.swing.JComboBox();
        jComboBox_Comuna = new javax.swing.JComboBox();
        jTextField_Direccion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel_Fecha = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPasswordField_Contraseña = new javax.swing.JPasswordField();
        jPasswordField_RepContraseña = new javax.swing.JPasswordField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel_email = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel8.setText("Apellidos:");

        jLabel15.setText("email:");

        jTextField_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelefonoKeyTyped(evt);
            }
        });

        jLabel7.setText("Carrera:");

        jLabel13.setText("Celular:");

        jLabel3.setText("Nombres:");

        jLabel14.setText("Telefono:");

        jLabel4.setText("Run:");

        dv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dvActionPerformed(evt);
            }
        });
        dv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                dvKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                dvKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("iRSU");

        jLabel6.setText("Informatica Responsabilidad Social Universitaria");

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

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Registro de administrador:");

        jLabel10.setText("Direccion:");

        jLabel9.setText("Actividad:");

        jButton_Guardar.setText("Guardar");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });

        jLabel11.setText("Comuna:");

        rud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rudActionPerformed(evt);
            }
        });
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

        jComboBox_Actividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Estudiante ", "Profesor" }));

        jComboBox_Carrera.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "21030", "21041" }));

        jComboBox_Comuna.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alhué", "Buin", "Calera de Tango", "Cerrillos", "Cerro Navia", "Colina", "Conchalí", "Curacaví", "El Bosque", "El Monte", "Estación Central", "Huechuraba", "Independencia", "Isla de Maipo", "La Cisterna", "La Florida", "La Granja", "Lampa", "La Pintana", "La Reina", "Las Condes", "Lo Barnechea", "Lo Espejo", "Lo Prado", "Macul", "Maipú", "María Pinto", "Melipilla", "Ñuñoa", "Paine", "Padre Hurtado", "Pedro Aguirre Cerda", "Peñaflor", "Peñalolén", "Pirque", "Providencia", "Pudahuel", "Puente Alto", "Quilicura", "Quinta Normal", "Recoleta", "Renca", "San Bernardo", "San Joaquín", "San José de Maipo", "San Miguel", "San Pedro", "San Ramón", "Santiago", "Talagante", "Til Til" }));

        jTextField_Direccion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_DireccionKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DireccionKeyTyped(evt);
            }
        });

        jLabel16.setText("Contraseña:");

        jLabel17.setText("Repetir contraseña:");

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Fecha.setText("00/00/00");

        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPasswordField_Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField_ContraseñaKeyTyped(evt);
            }
        });

        jPasswordField_RepContraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jPasswordField_RepContraseñaKeyTyped(evt);
            }
        });

        jLabel_email.setText("                  ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel17))
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPasswordField_RepContraseña, javax.swing.GroupLayout.DEFAULT_SIZE, 107, Short.MAX_VALUE)
                            .addComponent(jPasswordField_Contraseña))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton_Guardar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rud, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dv, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField_Apellidos, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
                                    .addComponent(jTextField_Nombres)))
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel_Fecha))
                            .addComponent(jLabel6)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jLabel14))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jComboBox_Actividad, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jComboBox_Comuna, 0, 1, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel13)
                                                    .addComponent(jLabel7))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(20, 20, 20)
                                                        .addComponent(jComboBox_Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                    .addGroup(layout.createSequentialGroup()
                                                        .addGap(24, 24, 24)
                                                        .addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jLabel15)
                                                        .addGap(18, 18, 18)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel_email, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(jLabel11))
                                .addGap(137, 137, 137)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel_Fecha))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(rud, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField_Nombres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextField_Apellidos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(52, 52, 52)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel13)
                                    .addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jComboBox_Actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel7)
                                        .addComponent(jComboBox_Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(jComboBox_Comuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel14))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel_email)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(jPasswordField_Contraseña, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel17))
                    .addComponent(jPasswordField_RepContraseña, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton_Guardar)
                    .addComponent(jButton1))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed
        Boolean continuar= true;
    Crear_admin error = new Crear_admin();
    if(rud.getText().equals("")){
      JOptionPane.showMessageDialog(error,"Debe completar el run");
      continuar= false;
    }
    else{
        int rut = Integer.parseInt(rud.getText());//parseo tipo entero el run y guardo en rut
        String verificador = dv.getText();//guardo digito verificador en digito del tipo string
        validaRut comprobar = new validaRut();//instancio la clase validaRut
       
           if(comprobar.digitoVerificador(rut).equals(verificador)){
            JOptionPane.showMessageDialog(error,"RUN correcto");
            // en vez de que nos envie ese mensaje nos puede mandar que esta correcto en un label con algun signo positivo
           }
           else{
            JOptionPane.showMessageDialog(error,"Ingrese correctamente el RUN");
             continuar= false;
           }
    }

    if(continuar){
        actualizar_variables();
       Agregar_admin();
       }
    }//GEN-LAST:event_jButton_GuardarActionPerformed

    private void dvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dvActionPerformed
        // TODO add your handling code here:
         
        
    }//GEN-LAST:event_dvActionPerformed

    private void rudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rudActionPerformed

    private void rudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rudKeyTyped
        // TODO add your handling code here:
        int limite=8;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||rud.getText().length()== limite) 
        {evt.consume();}        
    }//GEN-LAST:event_rudKeyTyped

    private void dvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyTyped
         int limite =1;
         if (dv.getText().length() == limite){evt.consume();}      
    }//GEN-LAST:event_dvKeyTyped

    private void dvKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyPressed

    }//GEN-LAST:event_dvKeyPressed

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

    private void jTextField_NombresKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_NombresKeyReleased
        // TODO add your handling code here:
        //jTextField_Nombres.setText(jTextField_Nombres.getText().toUpperCase());//transorma a mayusculas
        
    }//GEN-LAST:event_jTextField_NombresKeyReleased

    private void jTextField_ApellidosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApellidosKeyReleased
        // TODO add your handling code here:
        //jTextField_Apellidos.setText(jTextField_Apellidos.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_ApellidosKeyReleased

    private void jTextField_DireccionKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DireccionKeyReleased
        // TODO add your handling code here
       // jTextField_Direccion.setText(jTextField_Direccion.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_DireccionKeyReleased

    private void jTextField_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyReleased
        // TODO add your handling code here:
        //jTextField_email.setText(jTextField_email.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_emailKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Pantalla_principal cancelar= new Pantalla_principal();
            cancelar.setVisible(true); 
            Crear_admin.this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void jTextField_DireccionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DireccionKeyTyped
        // TODO add your handling code here:
        int limite = 35;
        if (jTextField_Direccion.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_DireccionKeyTyped

    private void jTextField_emailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyTyped
        // TODO add your handling code here
        int limite = 35;
        if (jTextField_email.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_emailKeyTyped

    private void jPasswordField_ContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_ContraseñaKeyTyped
        // TODO add your handling code here:
        int limite = 15;
        if (jPasswordField_Contraseña.getPassword().length == limite){evt.consume();}
    }//GEN-LAST:event_jPasswordField_ContraseñaKeyTyped

    private void jPasswordField_RepContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordField_RepContraseñaKeyTyped
        // TODO add your handling code here:
        int limite = 15;
        if (jPasswordField_Contraseña.getPassword().length == limite){evt.consume();}
    }//GEN-LAST:event_jPasswordField_RepContraseñaKeyTyped

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
            java.util.logging.Logger.getLogger(Crear_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Crear_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Crear_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Crear_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Crear_admin().setVisible(true);
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
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JLabel jLabel_email;
    private javax.swing.JPasswordField jPasswordField_Contraseña;
    private javax.swing.JPasswordField jPasswordField_RepContraseña;
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
