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


public class MainExamen extends javax.swing.JFrame {

    
    ListaElevi a;
    /**
     * Creates new form MainExamen
     */
    public MainExamen() {
        initComponents();
        Show_Examen();
    }
    
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
                ||txt_notar.getText()==null
                ||txt_notam.getText()==null)
        {return false;}else
        {
        return true;}
        
    }
      
       public void ShowItemElev(String exnre,String numeelev,String initt,String prenelev) {        
        txt_nre.setText(exnre);                                                    
        txt_numee.setText(numeelev);
        txt_init.setText(initt);
        txt_prene.setText(prenelev);
      
    }

       public ArrayList<Examen> getExamenList(){
             ArrayList<Examen> examenList= new ArrayList<Examen>();
            Connection con= getConnection();
            String query = "SELECT * FROM examen";
            
            Statement st;
            ResultSet rs;
        try {
            
            
            st = con.createStatement();
            rs = st.executeQuery(query);
            Examen examen;
            while(rs.next()){
                examen = new Examen(rs.getInt("nr_e"),rs.getString("nume_e"),rs.getString("init_t"),rs.getString("prenume_e"),rs.getFloat("nota_romana"),rs.getFloat("nota_matematica"));
                examenList.add(examen);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return examenList;
        
    }
    
    
    public void Show_Examen(){
        ArrayList<Examen> list = getExamenList();
        DefaultTableModel model= (DefaultTableModel)tbl_examen.getModel();
        
        model.setRowCount(0);
        Object[] row = new Object[6];
        for (int i= 0;i< list.size();i++){
            row[0]= list.get(i).getEnr();
            row[1]= list.get(i).getNumee();
            row[2]= list.get(i).getPrene();
            row[3]= list.get(i).getInit();
            row[4]= list.get(i).getNotaR();
            row[5]= list.get(i).getNotaM();
            
            model.addRow(row);
            
            
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_init = new javax.swing.JTextField();
        txt_numee = new javax.swing.JTextField();
        txt_notar = new javax.swing.JTextField();
        txt_notam = new javax.swing.JTextField();
        txt_prene = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        btn_cauta = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_examen = new javax.swing.JTable();
        btn_note = new javax.swing.JButton();
        btn_inapoi_e = new javax.swing.JButton();
        btn_verifica = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(223, 223, 242));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("EXAMEN");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Numar elev:");

        txt_nre.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Nume elev:");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Nota romana:");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Initiala tatalui:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Nota matematica:");

        txt_init.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_numee.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        txt_notar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_notar.setText("0.00");

        txt_notam.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        txt_notam.setText("0.00");

        txt_prene.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Prenume elev:");

        btn_cauta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_cauta.setText("Cauta elev");
        btn_cauta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_cautaMouseClicked(evt);
            }
        });
        btn_cauta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cautaActionPerformed(evt);
            }
        });

        tbl_examen.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Numar elev", "Nume elev", "Prenume elev", "Initiala tatalui", "Nota romana", "Nota matematica"
            }
        ));
        jScrollPane1.setViewportView(tbl_examen);

        btn_note.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_note.setText("Afiseaza notele");
        btn_note.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_noteMouseClicked(evt);
            }
        });
        btn_note.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_noteActionPerformed(evt);
            }
        });

        btn_inapoi_e.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_inapoi_e.setText("Inapoi");
        btn_inapoi_e.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_inapoi_eActionPerformed(evt);
            }
        });

        btn_verifica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btn_verifica.setText("Verifica elev");
        btn_verifica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_verificaActionPerformed(evt);
            }
        });

        jButton1.setText("Sterge");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(545, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(286, 286, 286))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txt_prene, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(btn_inapoi_e)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel3)
                                        .addComponent(jLabel2))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txt_init, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(txt_nre, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(btn_cauta))
                                        .addComponent(txt_numee, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txt_notar, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_notam, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(135, 135, 135))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_verifica)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_note)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton1)
                                .addGap(12, 12, 12)))))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 532, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btn_inapoi_e))
                .addGap(49, 49, 49)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_nre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btn_cauta))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_numee, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_init, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txt_prene, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_notar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_notam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btn_note)
                            .addComponent(btn_verifica)
                            .addComponent(jButton1)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_cautaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_cautaMouseClicked
        // TODO add your handling code here:
       
        
        a = new ListaElevi();
        a.setVisible(true);
        a.getInstance_MainExamen(this);           //am trimis instanta asta de MainExamen catre ListaElevi ca sa poti sa o folosesti acolo (ca sa trimiti inapoi aici de acolo chestii)
       
      
    }//GEN-LAST:event_btn_cautaMouseClicked

    private void btn_inapoi_eActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_inapoi_eActionPerformed
        // TODO add your handling code here:
        new MainProiectBD().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_btn_inapoi_eActionPerformed

    private void btn_noteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_noteMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btn_noteMouseClicked

    private void btn_cautaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cautaActionPerformed
        // TODO add your handling code here:
         
    }//GEN-LAST:event_btn_cautaActionPerformed

    private void btn_verificaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_verificaActionPerformed
        // TODO add your handling code here:
          
       if(checkInputs() && txt_nre !=null){
            Connection con=getConnection();

            try {
                PreparedStatement ps=con.prepareStatement("INSERT INTO examen (nr_e,nume_e,init_t,prenume_e,nota_romana,nota_matematica)"
                    +" values (?,?,?,?,?,?);");
                ps.setString(1, txt_nre.getText());
                ps.setString(2, txt_numee.getText());
                ps.setString(3,txt_init.getText());
                ps.setString(4,txt_prene.getText());
                ps.setString(5,txt_notar.getText());
                ps.setString(6,txt_notam.getText());
                ps.executeUpdate();
                Show_Examen();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        }else{
            JOptionPane.showMessageDialog(null, "Unul sau mai multe campuri sunt goale");
        }
       
    }//GEN-LAST:event_btn_verificaActionPerformed

    private void btn_noteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_noteActionPerformed
        // TODO add your handling code here:
        if(checkInputs() && txt_nre.getText()!= null){
            String update= null;
            PreparedStatement ps=null;
            Connection con= getConnection();
            try{
                update="UPDATE examen SET nota_romana=(SELECT nota FROM lucrare WHERE disciplina='romana' and examen.nr_e=lucrare.nr_e and examen.nr_e=?),nota_matematica=(SELECT nota FROM lucrare WHERE disciplina='matematica' and examen.nr_e=lucrare.nr_e and examen.nr_e=?)";
                ps=con.prepareStatement(update);
                ps.setFloat(1, Float.parseFloat(txt_nre.getText()));
                ps.setFloat(2, Float.parseFloat(txt_nre.getText()));
                int executeUpdate = ps.executeUpdate();
                Show_Examen();}
            catch(SQLException ex){
                Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE,null,ex);
            }
        }
    }//GEN-LAST:event_btn_noteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(!txt_nre.getText().equals("")){
            try {
                Connection con= getConnection();
                PreparedStatement ps= con.prepareStatement("DELETE FROM examen WHERE nr_e = ?");
                int nr_e= Integer.parseInt(txt_nre.getText());
                ps.setInt(1, nr_e);
                ps.executeUpdate();
                Show_Examen();
                JOptionPane.showMessageDialog(null,"Se pot vizualiza alti elevi");

            } catch (SQLException ex) {
                Logger.getLogger(MainSc.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null,"Elevul nu a fost sters.");
            }
        }else{
            JOptionPane.showMessageDialog(null,"Elevul nu a fost sters, introduceti numarul elevului.");
        }
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
            java.util.logging.Logger.getLogger(MainExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainExamen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainExamen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_cauta;
    private javax.swing.JButton btn_inapoi_e;
    private javax.swing.JButton btn_note;
    private javax.swing.JButton btn_verifica;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_examen;
    private javax.swing.JTextField txt_init;
    private javax.swing.JTextField txt_notam;
    private javax.swing.JTextField txt_notar;
    private javax.swing.JTextField txt_nre;
    private javax.swing.JTextField txt_numee;
    private javax.swing.JTextField txt_prene;
    // End of variables declaration//GEN-END:variables
}
