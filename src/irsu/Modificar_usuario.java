/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Gonzalo Pradena
 */
public class Modificar_usuario extends javax.swing.JFrame {

    String auxiliar=null;
    String rut=null;
    String nombre=null;
    String apellido=null;
    String actividad=null;
    String ciudad=null;
    String comuna=null;
    String carrera=null;
    String telefono=null;
    String celular=null;
    String direccion=null;
    String email=null;
    String pass="inforsu";
    
    /**
     * Creates new form Modificar_usuario
     */
    public Modificar_usuario() {
        initComponents();
    }
    
     public void actualizar_variables(){
    rut = run.getText() + dv.getText();
    nombre = jTetxField_Nombre.getText();
    apellido = jTextField_Apellido.getText();
    actividad = jTextField_Actividad.getText();
    comuna  = jTextField_Comuna.getText();
    carrera = jTextField_Carrera.getText();
    telefono = jTextField_Telefono.getText();
    celular = jTextField_Celular.getText();
    direccion = jTextField_Direccion.getText();
    email = jTextField_email.getText();
    }
    
    //    st = con.createStatement();            
      //    st.executeUpdate("UPDATE ARTICULO SET estado = '"+formula+"' where codigo ='"+codigo+"'");
 
   public void Modificar_user(){
        
    Connection con = null;
    Statement st = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        st = con.createStatement();
        st.executeUpdate("UPDATE USUARIO SET run_usuario='"+rut+ "',nombre='"+nombre+
                "',apellido='"+apellido+"',actividad='"+actividad+"',comuna='"+comuna+"',carrera='"+carrera+ 
                "',telefono='"+telefono +"',celular='"+celular+"',direccion='"+direccion+"',email='"+ email+"';");
        JOptionPane.showMessageDialog(null,"Datos modificados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){
          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al modificar usuario");

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
    
    public void consulta_datos(String consulta, String condicion ,String variable){
        
    //realizar consulta SQL:
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;
 
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        st = con.createStatement();
        
       rs = st.executeQuery("Select "+consulta+" from usuario where "+condicion       
        + " = '"+variable+"'");
        
     
   
        if(rs.next()){
               auxiliar=rs.getString(consulta);
           
           
        }
        else
            auxiliar = " ";
      }
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error en cargar datos");

      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
      finally{
          rs.close();
          st.close();
          con.close();
      }
    }
        catch (Exception e){
        e.printStackTrace();
    }    
         }
    
   
        public void cargausuario(String r){

   consulta_datos("nombre","run_usuario",r);
   jTetxField_Nombre.setText(auxiliar);
   
   consulta_datos("apellido","run_usuario",r);
   jTextField_Apellido.setText(auxiliar);
   
    consulta_datos("actividad","run_usuario",r);
   jTextField_Actividad.setText(auxiliar);
   
   consulta_datos("comuna","run_usuario",r);
   jTextField_Comuna.setText(auxiliar);
   
   consulta_datos("carrera","run_usuario",r);
   jTextField_Carrera.setText(auxiliar);
   
   consulta_datos("telefono","run_usuario",r);
   jTextField_Telefono.setText(auxiliar);
   
   consulta_datos("celular","run_usuario",r);
   jTextField_Celular.setText(auxiliar);
   
   consulta_datos("direccion","run_usuario",r);
   jTextField_Direccion.setText(auxiliar);
   
   consulta_datos("email","run_usuario",r);
   jTextField_email.setText(auxiliar);
  
   
   }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jTextField_Apellido = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jTextField_Actividad = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jTextField_Celular = new javax.swing.JTextField();
        jTextField_email = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jTextField_Comuna = new javax.swing.JTextField();
        jTextField_Telefono = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        run = new javax.swing.JTextField();
        jTetxField_Nombre = new javax.swing.JTextField();
        jTextField_Direccion = new javax.swing.JTextField();
        jTextField_Carrera = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        btnguardar = new javax.swing.JButton();
        btncargar = new javax.swing.JButton();
        dv = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTextField_Apellido.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Apellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ApellidoKeyReleased(evt);
            }
        });

        jLabel13.setText("Apellido:");

        jLabel14.setText("Actividad:");

        jLabel16.setText("Telefono:");

        jTextField_Actividad.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Actividad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ActividadKeyTyped(evt);
            }
        });

        jLabel20.setText("Direccion:");

        jTextField_Celular.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Celular.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_CelularKeyReleased(evt);
            }
        });

        jTextField_email.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_email.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_emailKeyReleased(evt);
            }
        });

        jLabel21.setText("email:");

        jLabel18.setText("Carrera:");

        jTextField_Comuna.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Comuna.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField_ComunaKeyReleased(evt);
            }
        });

        jTextField_Telefono.setBackground(new java.awt.Color(255, 255, 255));
        jTextField_Telefono.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_TelefonoKeyTyped(evt);
            }
        });

        jLabel19.setText("Celular:");

        jLabel17.setText("Comuna:");

        jLabel1.setText("Nombre:");

        run.setBackground(new java.awt.Color(255, 255, 255));

        jTetxField_Nombre.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_Direccion.setBackground(new java.awt.Color(255, 255, 255));

        jTextField_Carrera.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setText("Rut:");

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        btnguardar.setText("Guardar");
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        btncargar.setText("Cargar");
        btncargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncargarActionPerformed(evt);
            }
        });

        dv.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(19, 19, 19)
                                .addComponent(jTextField_Actividad, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel17)
                                .addGap(24, 24, 24)
                                .addComponent(jTextField_Comuna, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel21)
                                    .addGap(38, 38, 38)
                                    .addComponent(jTextField_email))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel19)
                                        .addComponent(jLabel16))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(20, 20, 20)
                                            .addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel3Layout.createSequentialGroup()
                                            .addGap(18, 18, 18)
                                            .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(jPanel3Layout.createSequentialGroup()
                                    .addComponent(jLabel20)
                                    .addGap(21, 21, 21)
                                    .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel18)
                                    .addComponent(jLabel3))
                                .addGap(24, 24, 24)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(dv, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jTextField_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jTetxField_Nombre, javax.swing.GroupLayout.DEFAULT_SIZE, 181, Short.MAX_VALUE)
                                            .addComponent(jTextField_Carrera)))))
                            .addComponent(jLabel13))
                        .addContainerGap(31, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btnguardar)
                                .addGap(18, 18, 18)
                                .addComponent(jButton5)
                                .addGap(61, 61, 61))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(btncargar)
                                .addGap(100, 100, 100))))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(run, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(dv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btncargar)
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTetxField_Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Apellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jTextField_Carrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField_Actividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jTextField_Comuna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(jTextField_Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 36, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jTextField_Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jTextField_Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jTextField_email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(btnguardar))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(15, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_ApellidoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ApellidoKeyReleased
        // TODO add your handling code here:
        jTextField_Apellido.setText(jTextField_Apellido.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_ApellidoKeyReleased

    private void jTextField_ActividadKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ActividadKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')) {evt.consume();}
    }//GEN-LAST:event_jTextField_ActividadKeyTyped

    private void jTextField_CelularKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CelularKeyReleased
        // TODO add your handling code here:
        jTextField_Celular.setText(jTextField_Celular.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_CelularKeyReleased

    private void jTextField_emailKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_emailKeyReleased
        // TODO add your handling code here:
        jTextField_email.setText(jTextField_email.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_jTextField_emailKeyReleased

    private void jTextField_ComunaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ComunaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_ComunaKeyReleased

    private void jTextField_TelefonoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_TelefonoKeyTyped
        // TODO add your handling code here:
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')) {evt.consume();}
    }//GEN-LAST:event_jTextField_TelefonoKeyTyped

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Pantalla_principal vl = new Pantalla_principal();
        vl.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        actualizar_variables();
        Modificar_user();
    }//GEN-LAST:event_btnguardarActionPerformed

    private void btncargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncargarActionPerformed
        // TODO add your handling code here:
        rut=run.getText() + dv.getText();
        cargausuario(rut);
    }//GEN-LAST:event_btncargarActionPerformed

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
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Modificar_usuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Modificar_usuario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncargar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JTextField dv;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTetxField_Nombre;
    private javax.swing.JTextField jTextField_Actividad;
    private javax.swing.JTextField jTextField_Apellido;
    private javax.swing.JTextField jTextField_Carrera;
    private javax.swing.JTextField jTextField_Celular;
    private javax.swing.JTextField jTextField_Comuna;
    private javax.swing.JTextField jTextField_Direccion;
    private javax.swing.JTextField jTextField_Telefono;
    private javax.swing.JTextField jTextField_email;
    private javax.swing.JTextField run;
    // End of variables declaration//GEN-END:variables
}
