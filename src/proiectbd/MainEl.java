/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proiectbd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class MainEl extends javax.swing.JFrame {

    /**
     * Creates new form MainEl
     */
    public MainEl() {
        initComponents();
        getConnection();
        Show_Elev();
    }
    int pos = 0;
    
     public Connection getConnection(){
        Connection con=null;
        
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/examencapacitate","root","");
           // JOptionPane.showMessageDialog(null,"Connected");
            return con;
        } catch (SQLException ex) {
            Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE, null, ex);
           // JOptionPane.showMessageDialog(null, "Not Connected");
            return null;
        }
    }
     
      public boolean checkInputs(){
        if( txt_nre.getText()==null ||
                txt_numee.getText()==null
                ||txt_prene.getText()==null
                ||txt_init.getText()==null
                ||txt_nrsc1.getText()==null)
        {return false;}else
        {
        return true;}
        
    }
      
      public ArrayList<Elev> getElevList(){
             ArrayList<Elev> elevList= new ArrayList<Elev>();
            Connection con= getConnection();
            String query = "SELECT * FROM elev";
            
            Statement st;
            ResultSet rs;
        try {
            
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            Elev elev;
            while(rs.next()){
                elev = new Elev(rs.getInt("nr_e"),rs.getString("nume_e"),rs.getString("prenume_e"),rs.getString("init_t"),rs.getInt("nr_sc"));
                elevList.add(elev);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return elevList;
        
    }
    
    
    public void Show_Elev(){
        ArrayList<Elev> list = getElevList();
        DefaultTableModel model= (DefaultTableModel)tbl_elev.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[5];
        for (int i= 0;i< list.size();i++){
            row[0]= list.get(i).getEnr();
            row[1]= list.get(i).getNumee();
            row[2]= list.get(i).getPrene();
            row[3]= list.get(i).getInit();
            row[4]= list.get(i).getScnr();
         
            
            model.addRow(row);
            
            
        }
        
    }
    
    
    public void ShowItem(int index){
        txt_nre.setText(Integer.toString(getElevList().get(index).getEnr()));
        txt_numee.setText(getElevList().get(index).getNumee());
        txt_prene.setText(getElevList().get(index).getPrene());
        txt_init.setText(getElevList().get(index).getInit());
        txt_nrsc1.setText(Integer.toString(getElevList().get(index).getScnr()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_nre = new javax.swing.JTextField();
        txt_numee = new javax.swing.JTextField();
        txt_prene = new javax.swing.JTextField();
        txt_init = new javax.swing.JTextField();
        btn_insert = new javax.swing.JButton();
        btn_update = new javax.swing.JButton();
        btn_delete = new javax.swing.JButton();
        btn_primul = new javax.swing.JButton();
        btn_urmatorul = new javax.swing.JButton();
        btn_anteriorul = new javax.swing.JButton();
        btn_ultimul = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_nrsc1 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_elev = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        btn_inapoi_e = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(254, 254, 242));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Nume Elev:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Numar Elev:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Prenume elev:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Initiala tatalui:");

        txt_nre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nreActionPerformed(evt);
            }
        });

        txt_numee.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_prene.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        txt_init.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        btn_insert.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_insert.setText("Insert");
        btn_insert.setToolTipText("");
        btn_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_insertActionPerformed(evt);
            }
        });

        btn_update.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_update.setText("Update");
        btn_update.setToolTipText("");
        btn_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_updateActionPerformed(evt);
            }
        });

        btn_delete.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_delete.setText("Delete");
        btn_delete.setToolTipText("");
        btn_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleteActionPerformed(evt);
            }
        });

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

        btn_anteriorul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_anteriorul.setText("Anteriorul");
        btn_anteriorul.setToolTipText("");
        btn_anteriorul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_anteriorulActionPerformed(evt);
            }
        });

        btn_ultimul.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btn_ultimul.setText("Ultimul");
        btn_ultimul.setToolTipText("");
        btn_ultimul.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ultimulActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Numar Scoala:");

        txt_nrsc1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txt_nrsc1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nrsc1ActionPerformed(evt);
            }
        });

        tbl_elev.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Numar elev", "Nume elev", "Prenume elev", "Initiala tatalui", "Numar scoala"
            }
        ));
        tbl_elev.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_elevMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_elev);

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setText("ELEVI");

        btn_inapoi_e.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_inapoi_e.setText("Inapoi");
        btn_inapoi_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inapoi_eActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(jLabel2)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_inapoi_e)
                                .addComponent(jLabel3)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(38, 38, 38)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_prene, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_numee, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_init, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nre, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nrsc1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(jLabel4))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_primul, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(btn_urmatorul)
                        .addGap(32, 32, 32)
                        .addComponent(btn_anteriorul, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(btn_ultimul, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(45, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(btn_inapoi_e))
                .addGap(16, 16, 16)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_numee, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_prene, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_init, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nrsc1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_insert, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_update, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_primul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_urmatorul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_anteriorul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_ultimul, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(108, 108, 108))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nreActionPerformed

    private void btn_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_insertActionPerformed

        if(checkInputs() && txt_nre !=null){
            Connection con=getConnection();

            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO elev (nume_e,prenume_e,init_t,nr_sc)"
                    +" values (?,?,?,?);");
               
                ps.setString(1, txt_numee.getText());
                ps.setString(2,txt_prene.getText());
                ps.setString(3,txt_init.getText());
                ps.setString(4,txt_nrsc1.getText());
                ps.executeUpdate();
                Show_Elev();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Unul sau mai multe campuri sunt goale");
        }
        
    }//GEN-LAST:event_btn_insertActionPerformed

    private void btn_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_updateActionPerformed
        if(checkInputs() && txt_nre.getText()!= null){
            String update= null;
            PreparedStatement ps=null;
            Connection con= getConnection();
            try{
                update="UPDATE elev SET nume_e =?, prenume_e = ?, init_t = ?,nr_sc =? WHERE nr_e = ?";
                ps=con.prepareStatement(update);
                ps.setString(1, txt_numee.getText());
                ps.setString(2, txt_prene.getText());
                ps.setString(3, txt_init.getText());
                ps.setString(4 ,txt_nrsc1.getText());
                ps.setInt(5, Integer.parseInt( txt_nre.getText()));
                ps.executeUpdate();
                Show_Elev();}
            catch(SQLException ex){
                Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }//GEN-LAST:event_btn_updateActionPerformed

    private void btn_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleteActionPerformed
        if(!txt_nre.getText().equals("")){
            try {
                Connection con= getConnection();
                PreparedStatement ps= con.prepareStatement("DELETE FROM elev WHERE nr_e = ?");
                int nr_e= Integer.parseInt(txt_nre.getText());
                ps.setInt(1, nr_e);
                ps.executeUpdate();
                Show_Elev();
                JOptionPane.showMessageDialog(null,"Elevul a fost sters.");

            } catch (SQLException ex) {
                Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Elevul nu a fost sters.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Elevul nu a fost sters, introduceti numarul elevului.");
        }
    }//GEN-LAST:event_btn_deleteActionPerformed

    private void btn_primulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_primulActionPerformed

        pos= 0;
        ShowItem(pos);
    }//GEN-LAST:event_btn_primulActionPerformed

    private void btn_urmatorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_urmatorulActionPerformed

        pos++;
        if(pos >=getElevList().size()){
            pos = getElevList().size()-1;

        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_urmatorulActionPerformed

    private void btn_anteriorulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_anteriorulActionPerformed

        pos--;
        if(pos < 0){
            pos= 0;
        }
        ShowItem(pos);
    }//GEN-LAST:event_btn_anteriorulActionPerformed

    private void btn_ultimulActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ultimulActionPerformed

        pos= getElevList().size()-1;
        ShowItem(pos);
    }//GEN-LAST:event_btn_ultimulActionPerformed

    private void txt_nrsc1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nrsc1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nrsc1ActionPerformed

    private void tbl_elevMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_elevMouseClicked
        int i= tbl_elev.getSelectedRow();
        TableModel model= tbl_elev.getModel();
        txt_nre.setText(model.getValueAt(i, 0).toString());
        txt_numee.setText(model.getValueAt(i, 1).toString());
        txt_prene.setText(model.getValueAt(i, 2).toString());
        txt_init.setText(model.getValueAt(i, 3).toString());
        txt_nrsc1.setText(model.getValueAt(i, 4).toString());
            
    }//GEN-LAST:event_tbl_elevMouseClicked

    private void btn_inapoi_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inapoi_eActionPerformed
        // TODO add your handling code here:
        new MainProiectBD().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inapoi_eActionPerformed

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
            java.util.logging.Logger.getLogger(MainEl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainEl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainEl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainEl.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainEl().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_anteriorul;
    private javax.swing.JButton btn_delete;
    private javax.swing.JButton btn_inapoi_e;
    private javax.swing.JButton btn_insert;
    private javax.swing.JButton btn_primul;
    private javax.swing.JButton btn_ultimul;
    private javax.swing.JButton btn_update;
    private javax.swing.JButton btn_urmatorul;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_elev;
    private javax.swing.JTextField txt_init;
    private javax.swing.JTextField txt_nre;
    private javax.swing.JTextField txt_nrsc1;
    private javax.swing.JTextField txt_numee;
    private javax.swing.JTextField txt_prene;
    // End of variables declaration//GEN-END:variables
}
