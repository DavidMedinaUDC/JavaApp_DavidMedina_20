/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package vistas;

import java.sql.Connection;
import sql.conexionsql;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;;
/**
 *
 * @author david
 */ 
public class consulta_avanzada extends javax.swing.JFrame {
    PreparedStatement pst = null;
    ResultSet rst = null;
    Connection connDbc = null;
    conexionsql dbc = new conexionsql();
    String cbColumna = null;
    String cbOrden = null;
    String cbOperadorNUM = null;
    String cbOperadorString = null;
    Integer tfParametroINT = null;
    String tfParametroString = null;
    String tfParametro = null;
    String cbOperador = null;
    
    public consulta_avanzada() {
  
        initComponents();
        
    }
      
    public void populateJTableOrdenar(String columna, String orden){
        
            connDbc = dbc.conectar();    
        
            try{
                
            DefaultTableModel dftable = (DefaultTableModel) tabla_productores.getModel();
            dftable.setRowCount(0);
            
            String sqlSelectDataFromDatabase = "SELECT * FROM productor ORDER BY "+columna+" "+orden+" ;";
            pst = connDbc.prepareStatement(sqlSelectDataFromDatabase);
            rst = pst.executeQuery();
            
            while(rst.next()){
                String id = rst.getString("productorid");
                String nombre = rst.getString("nombre");
                String dirección = rst.getString("dirección");
                String tipoactividad = rst.getString("tipoactividad");
                String fecharegistro = rst.getString("fecharegistro");
                        
                Object[] obj = {id,nombre,dirección,tipoactividad,fecharegistro};
                dftable.addRow(obj);
            }
            
            rst.close();
            pst.close();
            connDbc.close();
            
        }catch(Exception e){
            
        }
        
    }

    public void populateJTableBuscar(String columna, String operador, String parametro){
        
        connDbc = dbc.conectar();    

        try{
            DefaultTableModel dftable = (DefaultTableModel) tabla_productores.getModel();
            dftable.setRowCount(0);
            
            String sqlSelectDataFromDatabase = "SELECT * FROM productor WHERE "+columna+" "+operador+" "+parametro+";";
            System.out.println("IntruccionSQL: " + sqlSelectDataFromDatabase);
            pst = connDbc.prepareStatement(sqlSelectDataFromDatabase);
            rst = pst.executeQuery();
                        
            while(rst.next()){
                String id = rst.getString("productorid");
                String nombre = rst.getString("nombre");
                String dirección = rst.getString("dirección");
                String tipoactividad = rst.getString("tipoactividad");
                String fecharegistro = rst.getString("fecharegistro");
                
                Object[] obj = {id,nombre,dirección,tipoactividad,fecharegistro};
                dftable.addRow(obj);
            }
        }catch(Exception e){
            
        }
    }

    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabla_productores = new javax.swing.JTable();
        btnregresar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ComboBoxColumna = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        ComboBoxOrden = new javax.swing.JComboBox<>();
        btnOrdenar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ComboBoxOperador = new javax.swing.JComboBox<>();
        ButtonBuscar = new javax.swing.JButton();
        TextFieldParametro = new javax.swing.JTextField();
        SpinnerParametroNumero = new javax.swing.JSpinner();
        ComboBoxOperadorString = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabla_productores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Nombre", "Dirección", "Tipo de Actividad", "Fecha de Registro"
            }
        ));
        jScrollPane2.setViewportView(tabla_productores);

        btnregresar.setText("Regresar");
        btnregresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnregresarActionPerformed(evt);
            }
        });

        jLabel1.setText("Ordenar por:");

        ComboBoxColumna.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "productorid", "nombre", "dirección", "tipoactividad", "fecharegistro" }));
        ComboBoxColumna.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxColumnaActionPerformed(evt);
            }
        });

        jLabel2.setText("de forma:");

        ComboBoxOrden.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ASC", "DESC" }));
        ComboBoxOrden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOrdenActionPerformed(evt);
            }
        });

        btnOrdenar.setText("Ordenar");
        btnOrdenar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdenarActionPerformed(evt);
            }
        });

        jLabel3.setText("Donde:");

        jLabel4.setText("o");

        ComboBoxOperador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "=", "!=", ">", "<", ">=", "<=", " " }));
        ComboBoxOperador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOperadorActionPerformed(evt);
            }
        });

        ButtonBuscar.setText("Buscar");
        ButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonBuscarActionPerformed(evt);
            }
        });

        TextFieldParametro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextFieldParametroActionPerformed(evt);
            }
        });

        ComboBoxOperadorString.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecciona", "Empieza por", "Termina por", "Contiene", "IS NULL", "IS NOT NULL" }));
        ComboBoxOperadorString.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboBoxOperadorStringActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnregresar))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(8, 8, 8)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ComboBoxColumna, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(31, 31, 31)
                                        .addComponent(jLabel2))
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(ComboBoxOperadorString, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(SpinnerParametroNumero)
                                    .addComponent(TextFieldParametro)
                                    .addComponent(ComboBoxOrden, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(btnOrdenar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboBoxOperador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(SpinnerParametroNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(ComboBoxOperadorString, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(TextFieldParametro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(ComboBoxColumna, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3))
                        .addComponent(ComboBoxOrden, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnOrdenar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnregresar)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnregresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnregresarActionPerformed
        MainView objinicio = new MainView();
        objinicio.setVisible(true);
        objinicio.setLocationRelativeTo(null);
        this.setVisible(false);
    }//GEN-LAST:event_btnregresarActionPerformed

    private void ComboBoxColumnaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxColumnaActionPerformed
        //consulta_ordenar objordenar = new consulta_ordenar();
        
    }//GEN-LAST:event_ComboBoxColumnaActionPerformed

    private void ComboBoxOrdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOrdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxOrdenActionPerformed

    private void btnOrdenarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdenarActionPerformed
       
        cbColumna = ComboBoxColumna.getSelectedItem().toString();
        System.out.println("Columna: " + cbColumna);
        
        cbOrden = ComboBoxOrden.getSelectedItem().toString();
        System.out.println("Orden: " + cbOrden);
        
        populateJTableOrdenar(cbColumna, cbOrden);
    }//GEN-LAST:event_btnOrdenarActionPerformed

    private void ComboBoxOperadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOperadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxOperadorActionPerformed

    private void TextFieldParametroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextFieldParametroActionPerformed
        
    }//GEN-LAST:event_TextFieldParametroActionPerformed

    private void ButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonBuscarActionPerformed
        cbColumna = ComboBoxColumna.getSelectedItem().toString();
        System.out.println("Columna: " + cbColumna);
        
        cbOperadorNUM = ComboBoxOperador.getSelectedItem().toString();
        System.out.println("Operador numerico: " + cbOperadorNUM);
        
        cbOperadorString = ComboBoxOperadorString.getSelectedItem().toString();
        System.out.println("Operador de texto: " + cbOperadorString);
        
        tfParametroINT = (Integer) SpinnerParametroNumero.getValue();
        String tfParametroNUM = tfParametroINT.toString();
        System.out.println("Parametro numerico: " + tfParametroNUM);
        
        tfParametroString = TextFieldParametro.getText();
        System.out.println("Parametro en texto: " + tfParametroString);
        
        if(!tfParametroString.isEmpty() && tfParametroINT <= 0){
            
            if("Empieza por".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                tfParametroString = tfParametroString + "%";
                System.out.println("Parametro Final: " + tfParametroString);
            }else if("Termina por".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                tfParametroString = "%" + tfParametroString;
                System.out.println("Parametro Final: " + tfParametroString);
            }else if("Contiene".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                tfParametroString = "%" + tfParametroString + "%";
                System.out.println("Parametro Final: " + tfParametroString);
            }
            
            tfParametro = "'" + tfParametroString + "'";
            System.out.println("Parametro Final: " + tfParametro);
        }else if(tfParametroINT > 0 && tfParametroString.isEmpty()){
            tfParametro = tfParametroNUM;
            System.out.println("Parametro Final: " + tfParametro);
        }else if(tfParametroINT <= 0 && tfParametroString.isEmpty()){
            
            if("IS NULL".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                tfParametro = "";
                System.out.println("Parametro Final: " + tfParametro);
            }else if("IS NOT NULL".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                tfParametro = "";
                System.out.println("Parametro Final: " + tfParametro);
            }
            
        }else if(!tfParametroString.isEmpty() && tfParametroINT > 0){
            JOptionPane.showMessageDialog(null, "No puedes usar los dos parametros a la vez", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        if(!"Selecciona".equals(ComboBoxOperador.getSelectedItem().toString()) && "Selecciona".equals(ComboBoxOperadorString.getSelectedItem().toString())){
            cbOperador = cbOperadorNUM;
            System.out.println("Operador Final: " + cbOperadorNUM);
            System.out.println("Caso 1");
        }else if("Selecciona".equals(ComboBoxOperador.getSelectedItem().toString()) && !"Selecciona".equals(ComboBoxOperadorString.getSelectedItem().toString())){
            
            if("Empieza por".equals(ComboBoxOperadorString.getSelectedItem().toString()) || 
                    "Termina por".equals(ComboBoxOperadorString.getSelectedItem().toString()) || 
                    "Contiene".equals(ComboBoxOperadorString.getSelectedItem().toString())){
                cbOperador = "LIKE";
                System.out.println("Operador Final: " + cbOperadorString);
                System.out.println("Caso 2");
            }else {
                cbOperador = ComboBoxOperadorString.getSelectedItem().toString();
                System.out.println("Operador Final: " + cbOperadorString);
                System.out.println("Caso 2");
            }
            
        }else if(!"Selecciona".equals(ComboBoxOperador.getSelectedItem().toString()) && !"Selecciona".equals(ComboBoxOperadorString.getSelectedItem().toString())){
            System.out.println("Caso 3");
            JOptionPane.showMessageDialog(null, "No puedes usar los dos operadores a la vez", "Mensaje", JOptionPane.ERROR_MESSAGE);
        }
        
        populateJTableBuscar(cbColumna, cbOperador, tfParametro);
    }//GEN-LAST:event_ButtonBuscarActionPerformed

    private void ComboBoxOperadorStringActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboBoxOperadorStringActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ComboBoxOperadorStringActionPerformed

     
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
            java.util.logging.Logger.getLogger(consulta_avanzada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(consulta_avanzada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(consulta_avanzada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(consulta_avanzada.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        
        
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new consulta_avanzada().setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonBuscar;
    public javax.swing.JComboBox<String> ComboBoxColumna;
    private javax.swing.JComboBox<String> ComboBoxOperador;
    private javax.swing.JComboBox<String> ComboBoxOperadorString;
    private javax.swing.JComboBox<String> ComboBoxOrden;
    private javax.swing.JSpinner SpinnerParametroNumero;
    private javax.swing.JTextField TextFieldParametro;
    public javax.swing.JButton btnOrdenar;
    private javax.swing.JButton btnregresar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabla_productores;
    // End of variables declaration//GEN-END:variables
}
