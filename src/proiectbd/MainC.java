/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectbd;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class MainC extends javax.swing.JFrame {

    /**
     * Creates new form MainC
     */
    public MainC() {
        initComponents();
        getConnection();
        Show_Corector();
    }
    int pos = 0;

    public Connection getConnection(){
        Connection con=null;
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examencapacitate","root","");
           // JOptionPane.showMessageDialog(null,"Connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MainC.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
    }
 //Check input fields
    
    public boolean checkInputs(){
        if( txt_nrc.getText()==null ||
                txt_numec.getText()==null
                ||txt_prenc.getText()==null)
        {return false;}else
        {
        return true;}
        
    }
    
    public ArrayList<Corector> getCorectorList(){
             ArrayList<Corector> corectorList= new ArrayList<Corector>();
            Connection con= getConnection();
            String query = "SELECT * FROM corector";
            
            Statement st;
            ResultSet rs;
        try {
            
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            Corector corector;
            while(rs.next()){
                corector = new Corector(rs.getInt("nr_c"),rs.getString("nume_c"),rs.getString("prenume_c"),rs.getString("disciplina"));
                corectorList.add(corector);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainC.class.getName()).log(Level.SEVERE, null, ex);
        }
        return corectorList;
        
    }
    
    
    public void Show_Corector(){
        ArrayList<Corector> list = getCorectorList();
        DefaultTableModel model= (DefaultTableModel)tbl_c.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[4];
        for (int i= 0;i< list.size();i++){
            row[0]= list.get(i).getCnr();
            row[1]= list.get(i).getNumec();
            row[2]= list.get(i).getPrenc();
            row[3]= list.get(i).getDisc();
            
            
            model.addRow(row);
            
            
        }
        
    }
    
    
    public void ShowItem(int index){
        txt_nrc.setText(Integer.toString(getCorectorList().get(index).getCnr()));
        txt_numec.setText(getCorectorList().get(index).getNumec());
        txt_prenc.setText(getCorectorList().get(index).getPrenc());
        //txt_disc.setText(getCorectorList().get(index).getDisc());
        //combo_disc.getSelectedItem(getCorectorList().get(index).getDisc());
        combo_disc.setSelectedItem(getCorectorList().get(index).getDisc());
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_insert = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btn_update = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btn_delete = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        btn_primul = new javax.swing.JButton();
        btn_urmatorul = new javax.swing.JButton();
        txt_nrc = new javax.swing.JTextField();
        btn_anteriorul = new javax.swing.JButton();
        txt_numec = new javax.swing.JTextField();
        btn_ultimul = new javax.swing.JButton();
        txt_prenc = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_c = new javax.swing.JTable();
        btn_inapoi_c = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        combo_disc = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btn_insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_insert.setText("Insert");
        btn_insert.setToolTipText("");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nume Corector:");

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.setToolTipText("");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Numar Corector:");

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setToolTipText("");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Disciplina:");

        btn_primul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_primul.setText("Primul");
        btn_primul.setToolTipText("");
        btn_primul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_primulActionPerformed(evt);
            }
        });

        btn_urmatorul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_urmatorul.setText("Urmatorul");
        btn_urmatorul.setToolTipText("");
        btn_urmatorul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_urmatorulActionPerformed(evt);
            }
        });

        txt_nrc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nrc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nrcActionPerformed(evt);
            }
        });

        btn_anteriorul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_anteriorul.setText("Anteriorul");
        btn_anteriorul.setToolTipText("");
        btn_anteriorul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorulActionPerformed(evt);
            }
        });

        txt_numec.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_ultimul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ultimul.setText("Ultimul");
        btn_ultimul.setToolTipText("");
        btn_ultimul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimulActionPerformed(evt);
            }
        });

        txt_prenc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        tbl_c.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numar Corector", "Nume Corector", "Prenume Corector", "Disciplina"
            }
        ));
        tbl_c.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_cMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_c);

        btn_inapoi_c.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_inapoi_c.setText("Inapoi");
        btn_inapoi_c.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inapoi_cActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel4.setText("CORECTOR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Prenume Corector:");

        combo_disc.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        combo_disc.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romana", "Matematica" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(btn_inapoi_c)
                            .addGap(63, 63, 63)))
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel2))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(combo_disc, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_numec, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                            .addComponent(txt_nrc, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_prenc))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_primul, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_urmatorul)
                        .addGap(32, 32, 32)
                        .addComponent(btn_anteriorul, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_ultimul, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(388, 388, 388)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nrc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_numec, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txt_prenc, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(2, 2, 2)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(combo_disc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(btn_inapoi_c))
                        .addGap(13, 13, 13)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_primul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_urmatorul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_anteriorul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ultimul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed

        if(checkInputs() && txt_nrc !=null){
            Connection con=getConnection();

            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO corector (nume_c,prenume_c,disciplina)"
                    +" values (?,?,?);");
               
                ps.setString(1, txt_numec.getText());
                ps.setString(2,txt_prenc.getText());
                ps.setString(3,combo_disc.getSelectedItem().toString());
                ps.executeUpdate();
                Show_Corector();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "unul sau mai multe campuri sunt goale");
        }
    
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(checkInputs() && txt_nrc.getText()!= null){
            String update= null;
            PreparedStatement ps=null;
            Connection con= getConnection();
            try{
                update="UPDATE corector SET nume_c =?, prenume_c = ?,disciplina=? WHERE nr_c = ?";
                ps=con.prepareStatement(update);
                ps.setString(1, txt_numec.getText());
                ps.setString(2, txt_prenc.getText());
                ps.setString(3,combo_disc.getSelectedItem().toString());
                ps.setInt(4, Integer.parseInt( txt_nrc.getText()));
                ps.executeUpdate();
                Show_Corector();}
            catch(SQLException ex){
                Logger.getLogger(MainC.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(!txt_nrc.getText().equals("")){
            try {
                Connection con= getConnection();
                PreparedStatement ps= con.prepareStatement("DELETE FROM corector WHERE nr_c = ?");
                int nr_c= Integer.parseInt(txt_nrc.getText());
                ps.setInt(1, nr_c);
                ps.executeUpdate();
                Show_Corector();
                JOptionPane.showMessageDialog(null,"Corectorul a fost sters.");

            } catch (SQLException ex) {
                Logger.getLogger(MainC.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Corectorul nu a fost sters.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Corectorul nu a fost sters, introduceti numarul corectorului.");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_primulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primulActionPerformed

        pos= 0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_primulActionPerformed

    private void btn_urmatorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urmatorulActionPerformed

        pos++;
        if(pos >=getCorectorList().size()){
            pos = getCorectorList().size()-1;

        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_urmatorulActionPerformed

    private void txt_nrcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nrcActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nrcActionPerformed

    private void btn_anteriorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorulActionPerformed

        pos--;
        if(pos < 0){
            pos= 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_anteriorulActionPerformed

    private void btn_ultimulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimulActionPerformed

        pos= getCorectorList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_ultimulActionPerformed

    private void tbl_cMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_cMouseClicked

        int index = tbl_c.getSelectedRow();
        ShowItem(index);
    }//GEN-LAST:event_tbl_cMouseClicked

    private void btn_inapoi_cActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inapoi_cActionPerformed
        // TODO add your handling code here:
        new MainProiectBD().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inapoi_cActionPerformed

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
            java.util.logging.Logger.getLogger(MainC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anteriorul;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_inapoi_c;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_primul;
    private javax.swing.JButton btn_ultimul;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_urmatorul;
    private javax.swing.JComboBox<String> combo_disc;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_c;
    private javax.swing.JTextField txt_nrc;
    private javax.swing.JTextField txt_numec;
    private javax.swing.JTextField txt_prenc;
    // End of variables declaration//GEN-END:variables
}
