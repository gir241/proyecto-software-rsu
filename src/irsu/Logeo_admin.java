/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author rsuinformatica
 */
public class Logeo_admin extends javax.swing.JFrame {

    /**
     * Creates new form Logeo_admin
     */
    public String rut;
    public String contraseña;
     public void actualizar_variables(){
    
    contraseña = new String(Contraseña.getPassword());
     }
    public Logeo_admin() {
        initComponents();
       CrearBdd();
        
    }
    
    public void CrearBdd(){
    
        SQL sql = new SQL();

        sql.CrearBDD();// TODO add your handling code here:
    
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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        rud = new javax.swing.JTextField();
        jButton_Iniciar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        Contraseña = new javax.swing.JPasswordField();
        dv = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Inicio de sesion");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("iRSU");

        jLabel3.setText("Run de usuario:");

        jLabel4.setText("Contraseña:");

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

        jButton_Iniciar.setText("Iniciar sesion");
        jButton_Iniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_IniciarActionPerformed(evt);
            }
        });

        jLabel6.setText("Informatica Responsabilidad Social Universitaria");

        Contraseña.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ContraseñaActionPerformed(evt);
            }
        });
        Contraseña.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                ContraseñaKeyTyped(evt);
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

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .add(layout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(192, 192, 192))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createSequentialGroup()
                                .add(rud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 97, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                                .add(dv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel6)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                                .add(jButton_Iniciar)
                                .add(Contraseña, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 126, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE))))
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jSeparator1))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(2, 2, 2)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(22, 22, 22)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(rud, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(dv, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jLabel4, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Contraseña, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jButton_Iniciar)
                .add(61, 61, 61))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_IniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_IniciarActionPerformed
        
        // TODO add your handling code here:
         Boolean continuar= true;
    Crear_admin error = new Crear_admin();
    if(rud.getText().equals("")){
      JOptionPane.showMessageDialog(error,"Debe completar el run");
      continuar= false;
    }
    else{
        int rut1 = Integer.parseInt(rud.getText());//parseo tipo entero el run y guardo en rut
        String verificador = dv.getText();//guardo digito verificador en digito del tipo string
        validaRut comprobar = new validaRut();//instancio la clase validaRut
       
           if(comprobar.digitoVerificador(rut1).equals(verificador)){
            
               try
                {                   
                    //chekar si el usuario escrbio el nombre de usuario y pw
                    if (rud.getText().length() > 0 && Contraseña.getText().length() > 0 && dv.getText().length()>0 )

                    {
                        rut = rud.getText().toString() + dv.getText().toString() ;
                        // Si el usuario si fue validado correctamente
                        if( validarUsuario( rut, Contraseña.getText()) )    //enviar datos a validar
                        {
                            // Codigo para mostrar la ventana principal
                            
                            Pantalla_principal log = new Pantalla_principal();
                            log.setVisible(true);
                            Logeo_admin.this.dispose();
 
 
                        }
                        else
                        {
                            JOptionPane.showMessageDialog(null, "El nombre de usuario y/o contraseña no son validos.");
                          //  JOptionPane.showMessageDialog(null, rut+" " +contraseña );
                            rud.setText("");    //limpiar campos
                            Contraseña.setText("");       
                            dv.setText("");
                            rud.requestFocusInWindow();
                        }
 
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Debe escribir nombre de usuario y contrasenia.\n" +
                            "NO puede dejar ningun campo vacio");
                    }
 
                } catch (Exception e)
                {
                    e.printStackTrace();
                }
            // en vez de que nos envie ese mensaje nos puede mandar que esta correcto en un label con algun signo positivo
           }
           else{
            JOptionPane.showMessageDialog(error,"Ingrese correctamente el RUN");
             continuar= false;
           }
    }

    
    
    
        
    }//GEN-LAST:event_jButton_IniciarActionPerformed

    private void rudKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_rudKeyTyped
        // TODO add your handling code here:
        int limite=8;
          char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||rud.getText().length()== limite)
        {evt.consume();} 
        

     
    }//GEN-LAST:event_rudKeyTyped

    private void dvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyReleased
        // TODO add your handling code here:
        dv.setText(dv.getText().toUpperCase());//transorma a mayusculas
    }//GEN-LAST:event_dvKeyReleased

    private void dvKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_dvKeyTyped
        // TODO add your handling code here:
        int limite=1;
        if (dv.getText().length()== limite){evt.consume();}
    }//GEN-LAST:event_dvKeyTyped

    private void ContraseñaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_ContraseñaKeyTyped
        // TODO add your handling code here:
       
       int limite = 15;
        char car = evt.getKeyChar();
        if (car==' ' ||Contraseña.getPassword().length == limite){evt.consume();}
    }//GEN-LAST:event_ContraseñaKeyTyped

    private void ContraseñaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ContraseñaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ContraseñaActionPerformed

    private void rudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rudActionPerformed

    /**
     * @param args the command line arguments
     */
    
    boolean validarUsuario(String rut, String contraseña)  throws IOException

    {

        try

        {

            //nombre de la BD: bdlogin

             //nombre de la tabla: usuarios

             //                             id      integer auto_increment not null     <--llave primaria

             //                   campos:    usuario    char(25)

             //                              password char(50)

              Connection con = null;

            con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");

            // Preparamos la consulta

            Statement instruccionSQL = con.createStatement();

            ResultSet resultadosConsulta = instruccionSQL.executeQuery ("SELECT * FROM admin WHERE run_admin='"+rut+"' AND contraseña='"+ contraseña+"'");

 

            if( resultadosConsulta.first() )        // si es valido el primer reg. hay una fila, tons el usuario y su pw existen

                return true;        //usuario validado correctamente

            else

                return false;        //usuario validado incorrectamente

                 

        } catch (Exception e)

        {

            e.printStackTrace();

            return false;

        }

 

    }

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
            java.util.logging.Logger.getLogger(Logeo_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Logeo_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Logeo_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Logeo_admin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Logeo_admin().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Contraseña;
    private javax.swing.JTextField dv;
    private javax.swing.JButton jButton_Iniciar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField rud;
    // End of variables declaration//GEN-END:variables
}
