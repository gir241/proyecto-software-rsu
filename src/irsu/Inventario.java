/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package irsu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rsuinformatica
 */
public class Inventario extends javax.swing.JFrame {

    
    String codigo;
    String codigo_utem;
    String categoria;
    String producto;
    String descripcion;
    String estado;
    String pass = "inforsu";
    
     public void cargar_Jtable(){
        
        //realizar consulta SQL:
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;

    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
        st = con.createStatement();
        
        rs = st.executeQuery("select * from ARTICULO ");
            // reasigno un modelo en blanco:
            DefaultTableModel modelo = new DefaultTableModel();
             jTable1.setModel(modelo);
            //creamos la columnas de nuestra tabla:
                 modelo.addColumn("COD. RSU");
                 modelo.addColumn("COD. UTEM");
                 modelo.addColumn("CATEGORIA");
                 modelo.addColumn("PRODUCTO");
                 modelo.addColumn("DESCRIPCION");
                 modelo.addColumn("ESTADO");
            //asigno el tamaño del arreglo co la cantidad de columnas:
                Object[] filas = new Object[6];
            //escribo las filas:

                int j = 0;
                Boolean existencias = false;
            while (rs.next())
            {   
                existencias = true;
                //cantidad de columnas
                 for (int i=0;i<6;i++)
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
              //   JOptionPane.showMessageDialog(null,"No se Encuentran articulos en stock", 
              //  "alert", JOptionPane.OK_OPTION);  
                 }
         }  
      catch (SQLException s){

          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error en la base de datos");

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
     public void Agregar_articulo(){     
        Connection con = null;
       Statement st = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
        st = con.createStatement();
        st.executeUpdate("INSERT INTO ARTICULO Values ('"+codigo +"','"+codigo_utem+"','"+categoria+
            "','" + producto+ "','"+ descripcion+"','"+estado+"');");
        
        JOptionPane.showMessageDialog(null,"Datos agregados Exitosamente", 
                "alert", JOptionPane.OK_OPTION);
         }  
      catch (SQLException s){
          SQL_FORM error = new SQL_FORM();
      JOptionPane.showMessageDialog(error,"error al agregar producto");

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
     
     codigo = jTextField_CodigoAgre1.getText();
     codigo_utem  = jTextField_CodigoUTEM.getText();
     categoria = jTextField_Categoria2.getText();
     producto = jTextField_Producto1.getText();
     descripcion = jTextField_Descripcion1.getText();
     estado = "0";
     }
     
    
    
   
     
     public void eliminar (){
     Statement st = null;
     Connection con = null;
      ResultSet rs = null;
    try{
         Class.forName("com.mysql.jdbc.Driver").newInstance();
         con = DriverManager.getConnection
         ("jdbc:mysql://localhost/rsu_inventario","root",pass);
      try{
          
        st = con.createStatement();
        
        
        rs= st.executeQuery("SELECT * FROM ARTICULO WHERE codigo = '"+codigo+"';");  
                 
          if (rs.next()) {
                     
        String codigo_interno = rs.getString("codigo");
        String codigo_utem_interno = rs.getString("codigoutem");
        String categoria_interno = rs.getString("categoria");
        String producto_interno = rs.getString("producto");
        String descripcion_interno = rs.getString("descripcion");
        String estado_interno = rs.getString("estado");
        
        st.executeUpdate("INSERT INTO Trash_ARTICULO Values ('"+codigo_interno+"','"
        +codigo_utem_interno+"','"+categoria_interno+
       "','" + producto_interno+ "','"+ descripcion_interno+"','"+estado_interno+"');");
        
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
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("/imagenes/icono.png")).getImage());
          Fecha iniciar = new Fecha();
       jLabel_Fecha.setText(iniciar.fechaActual()); 
         cargar_Jtable();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jTextField_CodigoAgre1 = new javax.swing.JTextField();
        jTextField_Producto1 = new javax.swing.JTextField();
        jTextField_Descripcion1 = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jTextField_Categoria2 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextField_CodigoUTEM = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel6.setText("Informatica Responsabilidad Social Universitaria");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("iRSU");

        jLabel_Fecha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel_Fecha.setText("00/00/00");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Eliminar producto"));

        jLabel8.setText("Codigo RSU:");

        jTextField_CodigoElim.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_CodigoElimFocusLost(evt);
            }
        });
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
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                                .add(jLabel8)
                                .add(18, 18, 18)
                                .add(jTextField_CodigoElim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(42, 42, 42))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel1))
                        .addContainerGap())
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel2Layout.createSequentialGroup()
                        .add(jButton2)
                        .add(27, 27, 27))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel2Layout.createSequentialGroup()
                .add(29, 29, 29)
                .add(jPanel2Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel8)
                    .add(jTextField_CodigoElim, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 127, Short.MAX_VALUE)
                .add(jButton2)
                .addContainerGap())
        );

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Inventario:");

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
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Agregar producto"));

        jLabel9.setText("Codigo rsu:");

        jLabel11.setText("Producto:");

        jLabel12.setText("Descripcion:");

        jTextField_CodigoAgre1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CodigoAgre1ActionPerformed(evt);
            }
        });
        jTextField_CodigoAgre1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_CodigoAgre1FocusLost(evt);
            }
        });
        jTextField_CodigoAgre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoAgre1KeyTyped(evt);
            }
        });

        jTextField_Producto1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Producto1FocusLost(evt);
            }
        });
        jTextField_Producto1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Producto1KeyTyped(evt);
            }
        });

        jTextField_Descripcion1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Descripcion1ActionPerformed(evt);
            }
        });
        jTextField_Descripcion1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Descripcion1FocusLost(evt);
            }
        });
        jTextField_Descripcion1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Descripcion1KeyTyped(evt);
            }
        });

        jButton3.setText("Agregar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel17.setText("Categoria");

        jTextField_Categoria2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_Categoria2ActionPerformed(evt);
            }
        });
        jTextField_Categoria2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_Categoria2FocusLost(evt);
            }
        });
        jTextField_Categoria2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_Categoria2KeyTyped(evt);
            }
        });

        jLabel10.setText("Codigo Utem:");

        jTextField_CodigoUTEM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_CodigoUTEMActionPerformed(evt);
            }
        });
        jTextField_CodigoUTEM.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_CodigoUTEMFocusLost(evt);
            }
        });
        jTextField_CodigoUTEM.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField_CodigoUTEMKeyTyped(evt);
            }
        });

        org.jdesktop.layout.GroupLayout jPanel3Layout = new org.jdesktop.layout.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jButton3)
                .add(19, 19, 19))
            .add(jPanel3Layout.createSequentialGroup()
                .add(18, 18, 18)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(jPanel3Layout.createSequentialGroup()
                        .add(jLabel10)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jTextField_CodigoUTEM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                        .add(jTextField_Categoria2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jPanel3Layout.createSequentialGroup()
                                .add(jLabel17)
                                .add(304, 304, 304))
                            .add(jPanel3Layout.createSequentialGroup()
                                .add(1, 1, 1)
                                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(jLabel11)
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jTextField_Producto1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                    .add(jPanel3Layout.createSequentialGroup()
                                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(jLabel12)
                                            .add(jLabel9))
                                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_Descripcion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                            .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_CodigoAgre1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 229, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))))))
                .add(0, 52, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(jPanel3Layout.createSequentialGroup()
                .add(24, 24, 24)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_Categoria2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel17))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(jTextField_Producto1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jTextField_Descripcion1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel12))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel9, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jTextField_CodigoAgre1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .add(jPanel3Layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 28, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jTextField_CodigoUTEM, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .add(18, 18, 18)
                .add(jButton3))
        );

        jButton5.setText("Volver");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(6, 6, 6)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jSeparator1)
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, jLabel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .add(layout.createSequentialGroup()
                        .add(jLabel7)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(jLabel_Fecha))
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jButton5)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                                .add(jLabel6)
                                .add(layout.createSequentialGroup()
                                    .add(20, 20, 20)
                                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                    .add(jPanel2, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 727, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(0, 0, Short.MAX_VALUE)))
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
                .add(20, 20, 20)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(jLabel7)
                    .add(jLabel_Fecha))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(jScrollPane1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 263, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(1, 1, 1)
                .add(jButton5)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jPanel3, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jPanel2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(18, Short.MAX_VALUE))
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

    private void jTextField_CodigoAgre1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CodigoAgre1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_CodigoAgre1ActionPerformed

    private void jTextField_CodigoAgre1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoAgre1KeyTyped
        // TODO add your handling code here:
        int limite=10;
        char car = evt.getKeyChar();//bloque el jtextfiel para que acepte solo numeros
        if((car<'0' || car>'9')||jTextField_CodigoAgre1.getText().length()== limite)
        {evt.consume();}
    }//GEN-LAST:event_jTextField_CodigoAgre1KeyTyped

    private void jTextField_Producto1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Producto1KeyTyped
        // TODO add your handling code here:
        int limite = 23;
        char car = evt.getKeyChar();
        if (!(car<'0' || car>'9')||jTextField_Producto1.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_Producto1KeyTyped

    private void jTextField_Descripcion1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Descripcion1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Descripcion1ActionPerformed

    private void jTextField_Descripcion1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Descripcion1KeyTyped
        // TODO add your handling code here:
        int limite = 40;
        char car = evt.getKeyChar();
        if (jTextField_Descripcion1.getText().length() == limite){evt.consume();}
    }//GEN-LAST:event_jTextField_Descripcion1KeyTyped

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
     if(!jTextField_Categoria2.getText().equals("") && !jTextField_Producto1.getText().equals("")
             && !jTextField_Descripcion1.getText().equals("") && !jTextField_CodigoAgre1.getText().equals("")
             && !jTextField_CodigoUTEM.getText().equals("")  )
     {   
      SQL consulta = new SQL();    
      codigo = jTextField_CodigoAgre1.getText();
      codigo_utem = jTextField_CodigoUTEM.getText();
        try {
            try {
                if(!consulta.validar("codigo","ARTICULO","codigo",codigo ) &&
                      !consulta.validar("codigoutem","ARTICULO","codigoutem",codigo_utem )  )
                {  
                Carga_agregar();
                Agregar_articulo();
                cargar_Jtable();
                }
                      else{
                         JOptionPane.showMessageDialog(this,"codigos de producto ya existentes");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (IOException ex) {
            Logger.getLogger(Inventario.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     else   JOptionPane.showMessageDialog(this,"Rellene todos los campos para agregar producto");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        carga_eliminar();
        eliminar();
        cargar_Jtable();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Pantalla_principal cancelar= new Pantalla_principal();
        cancelar.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jTextField_Categoria2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Categoria2FocusLost
        // TODO add your handling code here:
        String a = jTextField_Categoria2.getText().trim();
        jTextField_Categoria2.setText(a);
    }//GEN-LAST:event_jTextField_Categoria2FocusLost

    private void jTextField_Producto1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Producto1FocusLost
        // TODO add your handling code here:
          String a = jTextField_Producto1.getText().trim();
        jTextField_Producto1.setText(a);
    }//GEN-LAST:event_jTextField_Producto1FocusLost

    private void jTextField_Descripcion1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_Descripcion1FocusLost
        // TODO add your handling code here:
         String a = jTextField_Descripcion1.getText().trim();
        jTextField_Descripcion1.setText(a);
    }//GEN-LAST:event_jTextField_Descripcion1FocusLost

    private void jTextField_CodigoAgre1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_CodigoAgre1FocusLost
        // TODO add your handling code here:
        String a = jTextField_CodigoAgre1.getText().trim();
        jTextField_CodigoAgre1.setText(a);
    }//GEN-LAST:event_jTextField_CodigoAgre1FocusLost

    private void jTextField_CodigoElimFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_CodigoElimFocusLost
        // TODO add your handling code here:
        String a = jTextField_CodigoElim.getText().trim();
        jTextField_CodigoElim.setText(a);
    }//GEN-LAST:event_jTextField_CodigoElimFocusLost

    private void jTextField_CodigoUTEMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_CodigoUTEMActionPerformed
        // TODO add your handling code here:
        
    }//GEN-LAST:event_jTextField_CodigoUTEMActionPerformed

    private void jTextField_CodigoUTEMFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_CodigoUTEMFocusLost
        // TODO add your handling code here:
        String a = jTextField_CodigoElim.getText().trim();
        jTextField_CodigoElim.setText(a);
    }//GEN-LAST:event_jTextField_CodigoUTEMFocusLost

    private void jTextField_CodigoUTEMKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_CodigoUTEMKeyTyped
        // TODO add your handling code here:
         int limite = 15;
        char car = evt.getKeyChar();
        if (car==' ' ||jTextField_CodigoUTEM.getText().length()== limite){evt.consume();}
    }//GEN-LAST:event_jTextField_CodigoUTEMKeyTyped

    private void jTextField_Categoria2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_Categoria2KeyTyped
        // TODO add your handling code here:
                 int limite = 15;
        char car = evt.getKeyChar();
        if (car==' ' ||jTextField_Categoria2.getText().length()== limite){evt.consume();}
    }//GEN-LAST:event_jTextField_Categoria2KeyTyped

    private void jTextField_Categoria2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_Categoria2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_Categoria2ActionPerformed

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
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_Fecha;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextField_Categoria2;
    private javax.swing.JTextField jTextField_CodigoAgre1;
    private javax.swing.JTextField jTextField_CodigoElim;
    private javax.swing.JTextField jTextField_CodigoUTEM;
    private javax.swing.JTextField jTextField_Descripcion1;
    private javax.swing.JTextField jTextField_Producto1;
    // End of variables declaration//GEN-END:variables
}
