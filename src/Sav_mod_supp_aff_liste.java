
import java.awt.List;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import static java.nio.file.Files.lines;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
public class Sav_mod_supp_aff_liste extends javax.swing.JFrame {

    /**
     * Creates new form Sav_mod_supp_aff_liste
     */
    Connection conn = null;
    ResultSet Rs;
    PreparedStatement pst;
    MyTableModel model = new MyTableModel();
    
    
    static Locale locale = Locale.getDefault();
    static Date date_actuelle = new Date();
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    public static String date()
	{
		String la_date_actuelle = dateFormat.format(date_actuelle);
		return la_date_actuelle;
	}
    
    private void InsertUserInComboBox(){
        try{
            conn = javaconnect.ConnectDb();
            String sql_query = ("SELECT user FROM utilisateur");
            pst = conn.prepareStatement(sql_query);
            Rs = pst.executeQuery();
            while(Rs.next()){
                txt_tri_utilisateur.addItem(Rs.getString("user"));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    
    private void UpdateTable(){
        model.getDataVector().removeAllElements();
        conn = javaconnect.ConnectDb();
        try{
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("SELECT cd_site, regle, date_sav, utilis, interloc, pblme, numero FROM sav WHERE 1=1 ");

            if (tri_par_agence == true){
                sqlBuilder.append("AND cd_site = '"+txt_tri_agence.getText().replace("'", "''")+"' ");
            }

            if (tri_par_regle == true){
                int regle_tri = 0;
                if (txt_tri_regle.getSelectedItem() == "Oui"){
                    regle_tri = 1;
                }
                if (txt_tri_regle.getSelectedItem() == "Non"){
                    regle_tri = 2;
                }
                sqlBuilder.append("AND regle = '"+regle_tri+"' ");
            }

            if (tri_par_utlisateur == true){
                sqlBuilder.append("AND utilis = '"+txt_tri_utilisateur.getSelectedItem()+"' ");
            }

            if (tri_par_date == true){
                sqlBuilder.append("AND date_sav >= '"+Date_Francais_Anglais(txt_tri_date_du.getText())
                        +"' AND date_sav <= '"+Date_Francais_Anglais(txt_tri_date_au.getText())+"' ");
            }
            
            if (tri_par_agence == false && tri_par_regle == false && tri_par_utlisateur == false && tri_par_date == false){
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                table_sav_mod_supp_aff.setModel(model);
            }
            else{
                model.getDataVector().removeAllElements();
                model.fireTableDataChanged();
                String sql = sqlBuilder.toString();
                pst = conn.prepareStatement(sql);
                Rs = pst.executeQuery(sql);
                while(Rs.next()){
                    String regle = "";
                    if (Rs.getInt("regle") == 1){
                        regle = "Oui";
                    }
                    if (Rs.getInt("regle") == 2){
                        regle = "Non";
                    }
                    model.addRow(new Object[]{Rs.getString("cd_site"), regle, Date_Anglais_Francais(Rs.getString("date_sav")),
                    Rs.getString("utilis"), Rs.getString("interloc"), FirstLine(Rs.getString("pblme")), Rs.getInt("numero")});
                }
                table_sav_mod_supp_aff.setModel(model);
            }
            if (tri_par_agence == true || tri_par_regle == true || tri_par_utlisateur == true || tri_par_date == true){
                if (table_sav_mod_supp_aff.getRowCount() == 0){
                    JOptionPane.showMessageDialog(null, "Aucun resultat.");
                }
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    
    public Sav_mod_supp_aff_liste() {
        initComponents();
        txt_tri_date_du.setText(date());
        txt_tri_date_au.setText(date());
        
        conn = javaconnect.ConnectDb();
        
        model.addColumn("Agence");
        model.addColumn("Réglé");
        model.addColumn("Date");
        model.addColumn("Utilisateur");
        model.addColumn("Interlocuteur");
        model.addColumn("Problème");
        model.addColumn("N°");
        //UpdateTable();
        
        button_tri_agence_desactiver.setEnabled(false);
        button_tri_regle_desactiver.setEnabled(false);
        button_tri_utilisateur_desactiver.setEnabled(false);
        InsertUserInComboBox();
        button_tri_date_desactiver.setEnabled(false);
        
        tri_par_date = true;
        button_tri_date_desactiver.setEnabled(true);
        button_tri_date_activer.setEnabled(false);
        UpdateTable();
        
        txt_tri_agence.requestFocus();
        
        
    }
    
    
    public final String FirstLine(String inputstring){ 
        String[] strarray = inputstring.split("\n");
        return strarray[0];
    }
    
    public final String Date_Anglais_Francais(String date_en_anglais){
        /*String string = date_en_anglais;
        String[] parts = string.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        String date_en_francais = part3+"-"+part2+"-"+part1;
        return date_en_francais;*/
        String dateStr = date_en_anglais;
        try{
        DateFormat srcDf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = srcDf.parse(dateStr);
        
        DateFormat destDf = new SimpleDateFormat("dd-MM-yy");
        dateStr = destDf.format(date);
        System.out.println("Converted date is : " + dateStr);
        
        }
        catch (ParseException e) {
             e.printStackTrace();
        }  
        return dateStr;
    }
    public final String Date_Francais_Anglais(String date_en_francais){
        /*String string = date_en_francais;
        String[] parts = string.split("-");
        String part1 = parts[0];
        String part2 = parts[1];
        String part3 = parts[2];
        String date_en_anglais = part3+"-"+part2+"-"+part1;
        return date_en_anglais;*/
        String dateStr = date_en_francais;
        try{
        DateFormat srcDf = new SimpleDateFormat("dd-MM-yy");
        Date date = srcDf.parse(dateStr);
        
        DateFormat destDf = new SimpleDateFormat("yyyy-MM-dd");
        dateStr = destDf.format(date);
        System.out.println("Converted date is : " + dateStr);
        
        }
        catch (ParseException e) {
             e.printStackTrace();
        }  
        return dateStr;
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
        table_sav_mod_supp_aff = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        txt_tri_agence = new javax.swing.JTextField();
        button_tri_agence_activer = new javax.swing.JButton();
        button_tri_agence_desactiver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_tri_regle = new javax.swing.JComboBox();
        button_tri_regle_activer = new javax.swing.JButton();
        button_tri_regle_desactiver = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        txt_tri_utilisateur = new javax.swing.JComboBox();
        button_tri_utilisateur_activer = new javax.swing.JButton();
        button_tri_utilisateur_desactiver = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txt_tri_date_du = new javax.swing.JFormattedTextField();
        txt_tri_date_au = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        button_tri_date_activer = new javax.swing.JButton();
        button_tri_date_desactiver = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Liste des S.A.V");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        table_sav_mod_supp_aff.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Agence", "Réglé", "Date", "Utilisateur", "Interlocuteur", "Probème", "N°"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        table_sav_mod_supp_aff.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table_sav_mod_supp_affMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table_sav_mod_supp_aff);

        jLabel1.setText("Tri par agence :");

        txt_tri_agence.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tri_agenceFocusGained(evt);
            }
        });
        txt_tri_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tri_agenceKeyPressed(evt);
            }
        });

        button_tri_agence_activer.setText("Activer");
        button_tri_agence_activer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_agence_activerActionPerformed(evt);
            }
        });

        button_tri_agence_desactiver.setText("Desactiver");
        button_tri_agence_desactiver.setNextFocusableComponent(table_sav_mod_supp_aff);
        button_tri_agence_desactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_agence_desactiverActionPerformed(evt);
            }
        });

        jLabel2.setText("(F2 - aide)");

        jLabel3.setText("Tri par réglé (oui/non) :");

        txt_tri_regle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Oui", "Non" }));
        txt_tri_regle.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_tri_regle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tri_regleFocusGained(evt);
            }
        });

        button_tri_regle_activer.setText("Activer");
        button_tri_regle_activer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_regle_activerActionPerformed(evt);
            }
        });

        button_tri_regle_desactiver.setText("Desactiver");
        button_tri_regle_desactiver.setNextFocusableComponent(table_sav_mod_supp_aff);
        button_tri_regle_desactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_regle_desactiverActionPerformed(evt);
            }
        });

        jLabel4.setText("Tri par utilisateur :");

        txt_tri_utilisateur.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tri_utilisateurFocusGained(evt);
            }
        });

        button_tri_utilisateur_activer.setText("Activer");
        button_tri_utilisateur_activer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_utilisateur_activerActionPerformed(evt);
            }
        });

        button_tri_utilisateur_desactiver.setText("Desactiver");
        button_tri_utilisateur_desactiver.setNextFocusableComponent(table_sav_mod_supp_aff);
        button_tri_utilisateur_desactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_utilisateur_desactiverActionPerformed(evt);
            }
        });

        jLabel5.setText("Tri par date :");

        try {
            txt_tri_date_du.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tri_date_du.setNextFocusableComponent(txt_tri_date_au);
        txt_tri_date_du.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tri_date_duFocusGained(evt);
            }
        });
        txt_tri_date_du.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tri_date_duKeyPressed(evt);
            }
        });

        try {
            txt_tri_date_au.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_tri_date_au.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_tri_date_auFocusGained(evt);
            }
        });
        txt_tri_date_au.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tri_date_auKeyPressed(evt);
            }
        });

        jLabel6.setText("au :");

        button_tri_date_activer.setText("Activer");
        button_tri_date_activer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_date_activerActionPerformed(evt);
            }
        });

        button_tri_date_desactiver.setText("Desactiver");
        button_tri_date_desactiver.setNextFocusableComponent(table_sav_mod_supp_aff);
        button_tri_date_desactiver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_tri_date_desactiverActionPerformed(evt);
            }
        });

        jLabel7.setText("Du :");

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_fond/1797393.png"))); // NOI18N
        jLabel8.setText("jLabel8");

        jMenu1.setText("Fichier");

        jMenuItem1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem1.setText("Export .csv");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(layout.createSequentialGroup()
                .addGap(236, 236, 236)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tri_date_du, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_tri_date_au, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(txt_tri_agence)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2))
                    .addComponent(txt_tri_utilisateur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tri_regle, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(button_tri_utilisateur_activer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_tri_regle_activer, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(button_tri_date_activer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_tri_date_desactiver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(button_tri_regle_desactiver, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_tri_utilisateur_desactiver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(button_tri_agence_activer, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_tri_agence_desactiver, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(236, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 1027, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jSeparator1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txt_tri_agence, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_tri_agence_desactiver)
                            .addComponent(jLabel2)
                            .addComponent(button_tri_agence_activer))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tri_regle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(button_tri_regle_activer)
                                .addComponent(button_tri_regle_desactiver)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_tri_utilisateur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_tri_utilisateur_activer)
                            .addComponent(button_tri_utilisateur_desactiver))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_tri_date_du, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(button_tri_date_desactiver)
                            .addComponent(button_tri_date_activer)
                            .addComponent(txt_tri_date_au, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 521, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 648, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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

    private void table_sav_mod_supp_affMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table_sav_mod_supp_affMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            try{
                int row = table_sav_mod_supp_aff.getSelectedRow();
                String table_click = (table_sav_mod_supp_aff.getModel().getValueAt(row, 6).toString());
                Sav_ajout_mod_supp_aff.sav_numero_selection = table_click;
                
                
                String table_click2 = (table_sav_mod_supp_aff.getModel().getValueAt(row, 0).toString());
                Sav_ajout_mod_supp_aff.sav_nom_selection_pour_modif = table_click2;
                
                Sav_ajout_mod_supp_aff fenetre_sav = new Sav_ajout_mod_supp_aff();
                fenetre_sav.setLocationRelativeTo(null);
                fenetre_sav.setVisible(true);
                this.dispose();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, "Vide");
            } 
        }
    }//GEN-LAST:event_table_sav_mod_supp_affMouseClicked
    //private boolean tri_active = false;
    private boolean tri_par_agence = false;
    private void button_tri_agence_activerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_agence_activerActionPerformed
        // TODO add your handling code here:
       
        tri_par_agence = true;
        button_tri_agence_desactiver.setEnabled(true);
        button_tri_agence_activer.setEnabled(false);
        UpdateTable();
    }//GEN-LAST:event_button_tri_agence_activerActionPerformed

    private void button_tri_agence_desactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_agence_desactiverActionPerformed
        // TODO add your handling code here:
        tri_par_agence = false;
        button_tri_agence_desactiver.setEnabled(false);
        button_tri_agence_activer.setEnabled(true);
        UpdateTable();
        button_tri_agence_desactiver.transferFocus();
    }//GEN-LAST:event_button_tri_agence_desactiverActionPerformed

    private void txt_tri_agenceFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tri_agenceFocusGained
        // TODO add your handling code here:
        tri_par_agence = false;
        button_tri_agence_desactiver.setEnabled(false);
        button_tri_agence_activer.setEnabled(true);
        //UpdateTable();
    }//GEN-LAST:event_txt_tri_agenceFocusGained

    public static int tri_agence_aide = 0;
    private void txt_tri_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tri_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_F2){
            tri_agence_aide = 1;
            Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
            fenetre_sav_ajout_liste.setLocationRelativeTo(null);
            fenetre_sav_ajout_liste.setVisible(true);
        }
        if (c == KeyEvent.VK_F4){
            Principal_jframe.button_sav_afficher.setEnabled(true);
            Principal_jframe.button_sav_ajouter.setEnabled(true);
            Principal_jframe.button_sav_mod_supp.setEnabled(true);
            
            Principal_jframe.button_agence_afficher.setEnabled(true);
            Principal_jframe.button_agence_ajouter.setEnabled(true);
            Principal_jframe.button_agence_mod_supp.setEnabled(true);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
            Principal_jframe.button_mon_compte.setEnabled(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_txt_tri_agenceKeyPressed

    private boolean tri_par_regle = false;
    private void button_tri_regle_activerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_regle_activerActionPerformed
        // TODO add your handling code here:
        tri_par_regle = true;
        button_tri_regle_desactiver.setEnabled(true);
        button_tri_regle_activer.setEnabled(false);
        UpdateTable();
    }//GEN-LAST:event_button_tri_regle_activerActionPerformed

    private void button_tri_regle_desactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_regle_desactiverActionPerformed
        // TODO add your handling code here:
        tri_par_regle = false;
        button_tri_regle_desactiver.setEnabled(false);
        button_tri_regle_activer.setEnabled(true);
        UpdateTable();
        button_tri_regle_desactiver.transferFocus();
    }//GEN-LAST:event_button_tri_regle_desactiverActionPerformed

    private void txt_tri_regleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tri_regleFocusGained
        // TODO add your handling code here:
        tri_par_regle = false;
        button_tri_regle_desactiver.setEnabled(false);
        button_tri_regle_activer.setEnabled(true);
        //UpdateTable();
    }//GEN-LAST:event_txt_tri_regleFocusGained

    private boolean tri_par_utlisateur = false;
    private void button_tri_utilisateur_activerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_utilisateur_activerActionPerformed
        // TODO add your handling code here:
        tri_par_utlisateur = true;
        button_tri_utilisateur_desactiver.setEnabled(true);
        button_tri_utilisateur_activer.setEnabled(false);
        UpdateTable();
    }//GEN-LAST:event_button_tri_utilisateur_activerActionPerformed

    private void button_tri_utilisateur_desactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_utilisateur_desactiverActionPerformed
        // TODO add your handling code here:
        tri_par_utlisateur = false;
        button_tri_utilisateur_desactiver.setEnabled(false);
        button_tri_utilisateur_activer.setEnabled(true);
        UpdateTable();
        button_tri_utilisateur_desactiver.transferFocus();
    }//GEN-LAST:event_button_tri_utilisateur_desactiverActionPerformed

    private void txt_tri_utilisateurFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tri_utilisateurFocusGained
        // TODO add your handling code here:
        tri_par_utlisateur = false;
        button_tri_utilisateur_desactiver.setEnabled(false);
        button_tri_utilisateur_activer.setEnabled(true);
        //UpdateTable();
    }//GEN-LAST:event_txt_tri_utilisateurFocusGained

    private boolean tri_par_date = false;
    private void button_tri_date_activerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_date_activerActionPerformed
        // TODO add your handling code here:
        
        if (isValidDate(txt_tri_date_du.getText()) == false){
            if (!"  -  -  ".equals(txt_tri_date_du.getText())){
                JOptionPane.showMessageDialog(null, "La date \"Du :\" n'existe pas."); 
                txt_tri_date_du.setText("");
                txt_tri_date_du.requestFocus();
            }
        }
        else if (isValidDate(txt_tri_date_au.getText()) == false){
            if (!"  -  -  ".equals(txt_tri_date_au.getText())){
                JOptionPane.showMessageDialog(null, "La date`\"Au :\" n'existe pas."); 
                txt_tri_date_au.setText("");
                txt_tri_date_au.requestFocus();
            }
        }
        else{
            tri_par_date = true;
            button_tri_date_desactiver.setEnabled(true);
            button_tri_date_activer.setEnabled(false);
            UpdateTable();
        }
        
        
        
        
                
        /*tri_par_date = true;
        button_tri_date_desactiver.setEnabled(true);
        button_tri_date_activer.setEnabled(false);
        UpdateTable();*/
    }//GEN-LAST:event_button_tri_date_activerActionPerformed

    private void button_tri_date_desactiverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_tri_date_desactiverActionPerformed
        // TODO add your handling code here:
        tri_par_date = false;
        button_tri_date_desactiver.setEnabled(false);
        button_tri_date_activer.setEnabled(true);
        UpdateTable();
        button_tri_date_desactiver.transferFocus();
    }//GEN-LAST:event_button_tri_date_desactiverActionPerformed

    private void txt_tri_date_duFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tri_date_duFocusGained
        // TODO add your handling code here:
        tri_par_date = false;
        button_tri_date_desactiver.setEnabled(false);
        button_tri_date_activer.setEnabled(true);
        //UpdateTable();
    }//GEN-LAST:event_txt_tri_date_duFocusGained

    private void txt_tri_date_auFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_tri_date_auFocusGained
        // TODO add your handling code here:
        tri_par_date = false;
        button_tri_date_desactiver.setEnabled(false);
        button_tri_date_activer.setEnabled(true);
        //UpdateTable();
    }//GEN-LAST:event_txt_tri_date_auFocusGained
    //private boolean bug_entrer_txt_tri_date_du = false;
    private void txt_tri_date_duKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tri_date_duKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tri_date_du.transferFocus();
        }
        
    }//GEN-LAST:event_txt_tri_date_duKeyPressed
    //private boolean bug_entrer_txt_tri_date_au = false;
    private void txt_tri_date_auKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tri_date_auKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_F4){
            txt_tri_date_au.transferFocusBackward();
        }
    }//GEN-LAST:event_txt_tri_date_auKeyPressed

    private final String COMMA_DELIMITER = ";";

    private void generateCsvFile(String sFileName)
   {
	try
	{
	    FileWriter writer = new FileWriter(sFileName);
            
            
            writer.append("AGENCE");
            writer.append(COMMA_DELIMITER);
            writer.append("DATE DE DEMANDE");
            writer.append(COMMA_DELIMITER);
            writer.append("HEURE DE DEMANDE");
            writer.append(COMMA_DELIMITER);
            writer.append("DATE DEBUT SAV");
            writer.append(COMMA_DELIMITER);
            writer.append("HEURE DEBUT SAV");
            writer.append(COMMA_DELIMITER);
            writer.append("CONTACT");
            writer.append(COMMA_DELIMITER);
            writer.append("INTERLOCUTEUR");
            writer.append(COMMA_DELIMITER);
            writer.append("UTILISATEUR");
            writer.append(COMMA_DELIMITER);
            writer.append("PROBLEME");
            writer.append(COMMA_DELIMITER);
            writer.append("REGLE");
            writer.append(COMMA_DELIMITER);
            writer.append("HEURE DE FIN");
            writer.append(COMMA_DELIMITER);
            writer.append("TEMPS");
            writer.append('\n');
            
            
            int i = 0;
            while (i < table_sav_mod_supp_aff.getRowCount()){
                
                
                
                
                int ligne = i;
                String table_click_agence = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 0).toString());
                String table_click_regle = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 1).toString());
                String table_click_date = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 2).toString());
                String table_click_utilisateur = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 3).toString());
                String table_click_interlocuteur = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 4).toString());
                String table_click_probleme = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 5).toString());
                String table_click_numero = (table_sav_mod_supp_aff.getModel().getValueAt(ligne, 6).toString());
                
                String hre_deb = "";
                String hre_fin = "";
                String tps = "";
                String date_demande = "";
                String heureSAV = "";
                String typsav = "";
                String interlocuteur = "";
                
                
                try{
                    conn = javaconnect.ConnectDb();
                    String sql_query = ("SELECT * FROM sav WHERE numero = '"+table_click_numero+"';");
                    pst = conn.prepareStatement(sql_query);
                    Rs = pst.executeQuery();
                    while(Rs.next()){
                        hre_deb = Rs.getString("hre_deb");
                        hre_fin = Rs.getString("hre_fin");
                        tps = Rs.getString("tps");
                        date_demande = Rs.getString("date_demande");
                        heureSAV = Rs.getString("heureSAV");
                        typsav = Rs.getString("typsav");
                        interlocuteur = Rs.getString("interlocuteur");
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                
                Charset.forName("ISO-8859-1").encode(table_click_agence);
                writer.append(table_click_agence);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(date_demande);
                writer.append(date_demande);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(heureSAV);
                writer.append(heureSAV);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(table_click_date);
                writer.append(table_click_date);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(hre_deb);
                writer.append(hre_deb);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(interlocuteur);
                writer.append(interlocuteur);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(table_click_interlocuteur);
                writer.append(table_click_interlocuteur);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(table_click_utilisateur);
                writer.append(table_click_utilisateur);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(table_click_probleme);
                writer.append(table_click_probleme);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(table_click_regle);
                writer.append(table_click_regle);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(hre_fin);
                writer.append(hre_fin);
                Charset.forName("ISO-8859-1").encode(COMMA_DELIMITER);
                writer.append(COMMA_DELIMITER);
                
                Charset.forName("ISO-8859-1").encode(tps);
                writer.append(tps);
                writer.append('\n');
                i = i + 1;
            }
            
	    writer.close();
            
            JOptionPane.showMessageDialog(null, "Liste exporté avec succès."); 
	}
	catch(IOException e)
	{
	      JOptionPane.showMessageDialog(null, e);
	} 
    }
    
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        generateCsvFile("C:\\partage\\test.csv");
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    
    public static boolean isValidDate(String inDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
        dateFormat.setLenient(false);
        try {
          dateFormat.parse(inDate.trim());
        } catch (ParseException pe) {
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }
    
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
            java.util.logging.Logger.getLogger(Sav_mod_supp_aff_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sav_mod_supp_aff_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sav_mod_supp_aff_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sav_mod_supp_aff_liste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sav_mod_supp_aff_liste().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_tri_agence_activer;
    private javax.swing.JButton button_tri_agence_desactiver;
    private javax.swing.JButton button_tri_date_activer;
    private javax.swing.JButton button_tri_date_desactiver;
    private javax.swing.JButton button_tri_regle_activer;
    private javax.swing.JButton button_tri_regle_desactiver;
    private javax.swing.JButton button_tri_utilisateur_activer;
    private javax.swing.JButton button_tri_utilisateur_desactiver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable table_sav_mod_supp_aff;
    public static javax.swing.JTextField txt_tri_agence;
    private javax.swing.JFormattedTextField txt_tri_date_au;
    private javax.swing.JFormattedTextField txt_tri_date_du;
    private javax.swing.JComboBox txt_tri_regle;
    private javax.swing.JComboBox txt_tri_utilisateur;
    // End of variables declaration//GEN-END:variables
}
