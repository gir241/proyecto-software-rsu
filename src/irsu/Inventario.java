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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsuinformatica
 */
public class Inventario extends javax.swing.JFrame {

      String codigo;
    String categoria;
    String producto;
    String descripcion;
    String   estado;
    
     public void cargar_Jtable(){
        
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
        
        rs = st.executeQuery("select * from ARTICULO ");
            // reasigno un modelo en blanco:
            DefaultTableModel modelo = new DefaultTableModel();
             jTable1.setModel(modelo);
            //creamos la columnas de nuestra tabla:
                 modelo.addColumn("CODIGO");
                 modelo.addColumn("CATEGORIA");
                 modelo.addColumn("PRODUCTO");
                 modelo.addColumn("DESCRIPCION");
                 modelo.addColumn("ESTADO");
            //asigno el tamaño del arreglo co la cantidad de columnas:
                Object[] filas = new Object[5];
            //escribo las filas:

                int j = 0;
                Boolean existencias = false;
            while (rs.next())
            {   
                existencias = true;
                //cantidad de columnas
                 for (int i=0;i<5;i++)
                 {
                     filas[i] = rs.getObject(i+1);
                 }
             //    modelo.addRow(filas); 
                 modelo.insertRow(j, filas);
             j++;     
            }
                 //escribo las filas del resultado SQL//
                 jTable1.setModel(modelo);
                 if(!existencias){
                 JOptionPane.showMessageDialog(null,"No se Encuentran articulos en stock", 
                "alert", JOptionPane.OK_OPTION);  
                 }
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error en cargar inventario");

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
     public void Agregar_artiuclo(){     
        Connection con = null;
       Statement st = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
        st = con.createStatement();
        st.executeUpdate("INSERT INTO ARTICULO Values ('"+codigo +"','"+categoria+
            "','" + producto+ "','"+ descripcion+"','"+estado+"');");
        
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
     public void Carga_agregar(){
     
     codigo = jTextField_CodigoAgre.getText();
     categoria = jTextField_Categoria.getText();
     producto = jTextField_Producto.getText();
     descripcion = jTextField_Descripcion.getText();
     estado = "0";
     }
     
     public void eliminar (){
     Statement st = null;
     Connection con = null;
      ResultSet rs = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root","inforsu");
      try{
          
        st = con.createStatement();
        
        
        rs= st.executeQuery("SELECT codigo FROM ARTICULO WHERE codigo = '"+codigo+"';");  
       
                 
          if (rs.next()) {
        st.executeUpdate("DELETE FROM ARTICULO WHERE codigo = '"+codigo+"';"); 
        JOptionPane.showMessageDialog(null,"Dato eliminados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);}
         else{
         JOptionPane.showMessageDialog(null,"Error al eliminar producto, compruebe"
              + " el codigo ingresado. Para mas informacion consulte al administrador", 
                "alert", JOptionPane.OK_OPTION);}
  
             
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error con la base de datos , "
              + " Para mas informacion consulte al administrador");

        //SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,s, "alert", JOptionPane.ERROR_MESSAGE);

    }
      finally{
          st.close();
          con.close();
          rs.close();
      }
  }
        catch (Exception e){
        e.printStackTrace();
    }
  }
     public void carga_eliminar(){
     codigo = jTextField_CodigoElim.getText(); 

     }
     
    
    /**
     * Creates new form Inventario
     */
    public Inventario() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel_Fecha = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jTextField_CodigoElim = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField_CodigoAgre = new javax.swing.JTextField();
        jTextField_Producto = new javax.swing.JTextField();
        jTextField_Descripcion = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jTextField_Categoria = new javax.swing.JTextField();
        Carga = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "CODIGO", "CATEGORIA", "PRODUCTO", "DESCRIPCION", "ESTADO."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jLabel6.setText("Informatica Responsabilidad Social Universitaria");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("iRSU");

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Fecha.setText("00/00/00");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar producto"));

        jLabel8.setText("Codigo:");

        jTextField_CodigoElim.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoElimKeyTyped(evt);
            }
        });

        jButton2.setText("Eliminar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel1.setForeground(new java.awt.Color(64, 64, 64));
        jLabel1.setText("(Ingrese codigo del producto)");

        org.jdesktop.layout.GroupLayout jPanel2Layout = new org.jdesktop.layout.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .addContainerGap(79, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jButton2)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jLabel8)
                        .add(18, 18, 18)
                        .add(jTextField_CodigoElim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(42, 42, 42))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(35, 35, 35)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel8)
                    .add(jTextField_CodigoElim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 50, Short.MAX_VALUE)
                .add(jButton2)
                .add(45, 45, 45))
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Inventario:");

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar producto"));

        jLabel3.setText("Codigo:");

        jLabel4.setText("Producto:");

        jLabel5.setText("Descripcion:");

        jTextField_CodigoAgre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CodigoAgreActionPerformed(evt);
            }
        });
        jTextField_CodigoAgre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoAgreKeyTyped(evt);
            }
        });

        jTextField_Producto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_ProductoKeyTyped(evt);
            }
        });

        jTextField_Descripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DescripcionActionPerformed(evt);
            }
        });
        jTextField_Descripcion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_DescripcionKeyTyped(evt);
            }
        });

        jButton1.setText("Agregar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel10.setText("Categoria");

        org.jdesktop.layout.GroupLayout jPanel1Layout = new org.jdesktop.layout.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel1Layout.createSequentialGroup()
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel4)
                                    .add(jLabel10))
                                .add(75, 75, 75)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_Producto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jPanel1Layout.createSequentialGroup()
                                .add(1, 1, 1)
                                .add(jLabel5)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_Descripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_CodigoAgre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(jLabel3))
                        .add(0, 219, Short.MAX_VALUE))
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(0, 0, Short.MAX_VALUE)
                        .add(jButton1))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel10)
                    .add(jTextField_Categoria, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(5, 5, 5)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel4)
                    .add(jTextField_Producto, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel1Layout.createSequentialGroup()
                        .add(jTextField_Descripcion, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jPanel1Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(jTextField_CodigoAgre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(jLabel5))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .add(jPanel1Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton1)
                .add(40, 40, 40))
        );

        Carga.setText("Cargar");
        Carga.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CargaActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jScrollPane1)
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jSeparator1)
                                    .add(jLabel7)
                                    .add(jLabel6))
                                .add(237, 237, 237)
                                .add(jLabel_Fecha))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(layout.createSequentialGroup()
                                        .add(20, 20, 20)
                                        .add(Carga)))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(19, 19, 19)
                .add(jLabel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 32, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(4, 4, 4)
                .add(jLabel6)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jLabel_Fecha))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 337, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(Carga, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 21, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(3, 3, 3)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(jPanel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_CodigoElimKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoElimKeyTyped
        // TODO add your handling code here:
        int limite=10;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||jTextField_CodigoElim.getText().length()== limite) 
        {evt.consume();}
    }//GEN-LAST:event_jTextField_CodigoElimKeyTyped

    private void jTextField_CodigoAgreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CodigoAgreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CodigoAgreActionPerformed

    private void jTextField_CodigoAgreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoAgreKeyTyped
        // TODO add your handling code here:
        int limite=10;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||jTextField_CodigoAgre.getText().length()== limite)
        {evt.consume();}
    }//GEN-LAST:event_jTextField_CodigoAgreKeyTyped

    private void jTextField_ProductoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_ProductoKeyTyped
        // TODO add your handling code here:
        int limite = 23;
        char car = evt.getKeyChar();
        if (!(car<'0' || car>'9')||jTextField_Producto.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_ProductoKeyTyped

    private void jTextField_DescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DescripcionActionPerformed

    private void jTextField_DescripcionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_DescripcionKeyTyped
        // TODO add your handling code here:
        int limite = 40;
        char car = evt.getKeyChar();
        if (!(car<'0' || car>'9')||jTextField_Descripcion.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_DescripcionKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Carga_agregar();
        Agregar_artiuclo();
        cargar_Jtable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void CargaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CargaActionPerformed
         cargar_Jtable();
    }//GEN-LAST:event_CargaActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        carga_eliminar();
        eliminar();
        cargar_Jtable();
    }//GEN-LAST:event_jButton2ActionPerformed

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
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Inventario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Inventario().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Carga;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_Categoria;
    private javax.swing.JTextField jTextField_CodigoAgre;
    private javax.swing.JTextField jTextField_CodigoElim;
    private javax.swing.JTextField jTextField_Descripcion;
    private javax.swing.JTextField jTextField_Producto;
    // End of variables declaration//GEN-END:variables
}
