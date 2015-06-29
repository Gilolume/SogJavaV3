
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
public class Sav_ajout_liste extends javax.swing.JFrame {
    
    Connection conn = null;
    ResultSet Rs;
    PreparedStatement pst;
    MyTableModel model = new MyTableModel();
    /**
     * Creates new form Sav_ajout_liste
     */
    
    static Locale locale = Locale.getDefault();
    static Date date_actuelle = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static String date()
	{
		String la_date_actuelle = dateFormat.format(date_actuelle);
		return la_date_actuelle;
	}
    public Sav_ajout_liste() {
        if (Sav_mod_supp_aff_liste.tri_agence_aide == 1){
            conn = javaconnect.ConnectDb();

            model.addColumn("Agence");
            model.addColumn("Sav (aujourd'hui)");

            String sql_query = ("SELECT agence.nom, COUNT(cd_site) AS nb_sav FROM \n" +
                                "agence LEFT JOIN sav ON (agence.nom = cd_site AND sav.date_sav = '"+date()+"')\n" +
                                "GROUP BY agence.nom \n" +
                                "ORDER BY nom");
            try{
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                while(Rs.next()){
                    model.addRow(new Object[]{Rs.getString("nom"), Rs.getString("nb_sav")});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            initComponents();
            table_ajout_liste.setModel(model);
        }
        else{
            conn = javaconnect.ConnectDb();

            model.addColumn("Agence");
            model.addColumn("Sav (aujourd'hui)");

            String sql_query = ("SELECT agence.nom, COUNT(cd_site) AS nb_sav FROM \n" +
                                "agence LEFT JOIN sav ON (agence.nom = cd_site AND sav.date_sav = '"+date()+"')\n" +
                                "WHERE agence.actif = 1\n" +
                                "GROUP BY agence.nom \n" +
                                "ORDER BY nom");
            try{
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                while(Rs.next()){
                    model.addRow(new Object[]{Rs.getString("nom"), Rs.getString("nb_sav")});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            initComponents();
            table_ajout_liste.setModel(model);
        }
    }
    
    public final void UpdateTable(){
        if (Sav_mod_supp_aff_liste.tri_agence_aide == 1){
            model.getDataVector().removeAllElements();
            conn = javaconnect.ConnectDb();
            String agence = txt_sav_ajout_agence_chercher.getText()+"%";
            //String sql_query = ("SELECT nom FROM agence WHERE actif = 1 AND nom LIKE '"+agence+"';");
            String sql_query = ("SELECT agence.nom, COUNT(cd_site) AS nb_sav FROM \n" +
                                "agence LEFT JOIN sav ON (agence.nom = cd_site AND sav.date_sav = '"+date()+"')\n" +
                                "WHERE nom LIKE '"+agence+"'\n" +
                                "GROUP BY agence.nom \n" +
                                "ORDER BY nom");

            try{
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                while(Rs.next()){
                    model.addRow(new Object[]{Rs.getString("nom"), Rs.getString("nb_sav")});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            table_ajout_liste.setModel(model);
        }
        else{
            model.getDataVector().removeAllElements();
            conn = javaconnect.ConnectDb();
            String agence = txt_sav_ajout_agence_chercher.getText()+"%";
            //String sql_query = ("SELECT nom FROM agence WHERE actif = 1 AND nom LIKE '"+agence+"';");
            String sql_query = ("SELECT agence.nom, COUNT(cd_site) AS nb_sav FROM \n" +
                                "agence LEFT JOIN sav ON (agence.nom = cd_site AND sav.date_sav = '"+date()+"')\n" +
                                "WHERE agence.actif = 1 AND nom LIKE '"+agence+"'\n" +
                                "GROUP BY agence.nom \n" +
                                "ORDER BY nom");

            try{
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                while(Rs.next()){
                    model.addRow(new Object[]{Rs.getString("nom"), Rs.getString("nb_sav")});
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            table_ajout_liste.setModel(model);
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

        jScrollPane1 = new javax.swing.JScrollPane();
        table_ajout_liste = new javax.swing.JTable();
        txt_sav_ajout_agence_chercher = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des agences");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table_ajout_liste.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Agence", "Sav (aujourd'hui)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        table_ajout_liste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_ajout_listeMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_ajout_liste);

        txt_sav_ajout_agence_chercher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_sav_ajout_agence_chercherKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sav_ajout_agence_chercherKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_sav_ajout_agence_chercherKeyTyped(evt);
            }
        });

        jLabel1.setText("Recherche dynamique (Par nom d'agence) :");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_fond/1797393.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_sav_ajout_agence_chercher)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 480, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 480, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txt_sav_ajout_agence_chercher, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 503, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 545, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void table_ajout_listeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_ajout_listeMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            if (Sav_mod_supp_aff_liste.tri_agence_aide == 0){
                try{
                    int row = table_ajout_liste.getSelectedRow();
                    String table_click = (table_ajout_liste.getModel().getValueAt(row, 0).toString());
                    Sav_ajout_mod_supp_aff.sav_agence_selection = table_click;
                    Sav_ajout_mod_supp_aff fenetre_sav = new Sav_ajout_mod_supp_aff();
                    fenetre_sav.setLocationRelativeTo(null);
                    fenetre_sav.setVisible(true);
                    this.dispose();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
            else{
                try{
                    int row = table_ajout_liste.getSelectedRow();
                    String table_click = (table_ajout_liste.getModel().getValueAt(row, 0).toString());
                    Sav_mod_supp_aff_liste.txt_tri_agence.setText(table_click);
                    Sav_mod_supp_aff_liste.tri_agence_aide = 0;
                    this.dispose();
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }//GEN-LAST:event_table_ajout_listeMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        Principal_jframe.button_sav_afficher.setEnabled(true);
        Principal_jframe.button_sav_ajouter.setEnabled(true);
        Principal_jframe.button_sav_mod_supp.setEnabled(true);
        
        Principal_jframe.button_agence_afficher.setEnabled(true);
        Principal_jframe.button_agence_ajouter.setEnabled(true);
        Principal_jframe.button_agence_mod_supp.setEnabled(true);
        
        Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
        Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
        Principal_jframe.button_mon_compte.setEnabled(true);
        
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }//GEN-LAST:event_formWindowClosing
    
    private void txt_sav_ajout_agence_chercherKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sav_ajout_agence_chercherKeyTyped
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_txt_sav_ajout_agence_chercherKeyTyped

    private void txt_sav_ajout_agence_chercherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sav_ajout_agence_chercherKeyPressed
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_txt_sav_ajout_agence_chercherKeyPressed

    private void txt_sav_ajout_agence_chercherKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sav_ajout_agence_chercherKeyReleased
        // TODO add your handling code here:
        UpdateTable();
    }//GEN-LAST:event_txt_sav_ajout_agence_chercherKeyReleased

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
            java.util.logging.Logger.getLogger(Sav_ajout_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sav_ajout_liste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table_ajout_liste;
    private javax.swing.JTextField txt_sav_ajout_agence_chercher;
    // End of variables declaration//GEN-END:variables
}
