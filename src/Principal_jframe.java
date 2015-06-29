/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Principal_jframe extends javax.swing.JFrame {

    /**
     * Creates new form Principal_jframe
     */
    Connection conn = null;
    ResultSet Rs;
    PreparedStatement pst;
    
    
    public static int utilisateur_option = 0;
    public static int utilisateur_button_blocage = 0;
    
    
    
    public Principal_jframe() {
        initComponents();
        
        carre_image.requestFocus();
        
        ImageIcon imageIcon = new ImageIcon(Login_jframe.getImageUser()); // load the image to a imageIcon
        Image image = imageIcon.getImage(); // transform it 
        Image newimg = image.getScaledInstance(256, 256,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
        imageIcon = new ImageIcon(newimg);  // transform it back 
        carre_image.setIcon(imageIcon);
        
        jLabel2.setText("Bienvenue " + Login_jframe.getLibUser());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        carre_image = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        button_mon_compte = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        button_utilisateur_ajouter = new javax.swing.JButton();
        button_utilisateur_supprimer = new javax.swing.JButton();
        button_quitter = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        button_agence_afficher = new javax.swing.JButton();
        button_agence_ajouter = new javax.swing.JButton();
        button_agence_mod_supp = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        button_sav_afficher = new javax.swing.JButton();
        button_sav_ajouter = new javax.swing.JButton();
        button_sav_mod_supp = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Accueil");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        carre_image.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204), 5));
        carre_image.setNextFocusableComponent(button_agence_afficher);
        carre_image.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                carre_imageMouseClicked(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        button_mon_compte.setText("Mon compte");
        button_mon_compte.setNextFocusableComponent(button_utilisateur_ajouter);
        button_mon_compte.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_mon_compteActionPerformed(evt);
            }
        });
        button_mon_compte.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_mon_compteKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Utilisateur(s)");

        button_utilisateur_ajouter.setText("Ajouter");
        button_utilisateur_ajouter.setNextFocusableComponent(button_utilisateur_supprimer);
        button_utilisateur_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_utilisateur_ajouterActionPerformed(evt);
            }
        });
        button_utilisateur_ajouter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_utilisateur_ajouterKeyPressed(evt);
            }
        });

        button_utilisateur_supprimer.setText("Afficher/Supprimer");
        button_utilisateur_supprimer.setNextFocusableComponent(button_quitter);
        button_utilisateur_supprimer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_utilisateur_supprimerActionPerformed(evt);
            }
        });
        button_utilisateur_supprimer.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_utilisateur_supprimerKeyPressed(evt);
            }
        });

        button_quitter.setText("Quitter (F4)");
        button_quitter.setNextFocusableComponent(button_agence_afficher);
        button_quitter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_quitterActionPerformed(evt);
            }
        });
        button_quitter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_quitterKeyPressed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Agence(s)");

        button_agence_afficher.setText("Afficher");
        button_agence_afficher.setNextFocusableComponent(button_agence_ajouter);
        button_agence_afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agence_afficherActionPerformed(evt);
            }
        });
        button_agence_afficher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_agence_afficherKeyPressed(evt);
            }
        });

        button_agence_ajouter.setText("Ajouter");
        button_agence_ajouter.setNextFocusableComponent(button_agence_mod_supp);
        button_agence_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agence_ajouterActionPerformed(evt);
            }
        });
        button_agence_ajouter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_agence_ajouterKeyPressed(evt);
            }
        });

        button_agence_mod_supp.setText("Modifier/Supprimer");
        button_agence_mod_supp.setNextFocusableComponent(button_sav_afficher);
        button_agence_mod_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_agence_mod_suppActionPerformed(evt);
            }
        });
        button_agence_mod_supp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_agence_mod_suppKeyPressed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("S.A.V");

        button_sav_afficher.setText("Afficher");
        button_sav_afficher.setNextFocusableComponent(button_sav_ajouter);
        button_sav_afficher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sav_afficherActionPerformed(evt);
            }
        });
        button_sav_afficher.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_sav_afficherKeyPressed(evt);
            }
        });

        button_sav_ajouter.setText("Ajouter");
        button_sav_ajouter.setNextFocusableComponent(button_sav_mod_supp);
        button_sav_ajouter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sav_ajouterActionPerformed(evt);
            }
        });
        button_sav_ajouter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_sav_ajouterKeyPressed(evt);
            }
        });

        button_sav_mod_supp.setText("Modifier/Supprimer");
        button_sav_mod_supp.setNextFocusableComponent(button_mon_compte);
        button_sav_mod_supp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_sav_mod_suppActionPerformed(evt);
            }
        });
        button_sav_mod_supp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_sav_mod_suppKeyPressed(evt);
            }
        });

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_fond/1797393.png"))); // NOI18N
        jLabel3.setText("jLabel3");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_quitter, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(185, 185, 185))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(carre_image, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(57, 57, 57)
                                .addComponent(jLabel5))
                            .addComponent(button_sav_afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_sav_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_sav_mod_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(jLabel4))
                            .addComponent(button_agence_afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_agence_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(button_agence_mod_supp, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(button_mon_compte, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_utilisateur_ajouter, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(button_utilisateur_supprimer, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addGap(36, 36, 36)))))
                .addContainerGap(40, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 590, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(carre_image, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_agence_afficher)
                            .addComponent(button_mon_compte))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_agence_ajouter)
                            .addComponent(button_utilisateur_ajouter))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(button_agence_mod_supp)
                            .addComponent(button_utilisateur_supprimer)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(button_sav_afficher)
                        .addGap(6, 6, 6)
                        .addComponent(button_sav_ajouter)
                        .addGap(6, 6, 6)
                        .addComponent(button_sav_mod_supp)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button_quitter)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 468, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private String chemin_image;
    private void carre_imageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_carre_imageMouseClicked
        // TODO add your handling code here:
        if (evt.getClickCount() == 2){
            JButton open = new JButton();
            JFileChooser browser = new JFileChooser();
            browser.setDialogTitle("Choisir chemin pour image");
            browser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            if (browser.showOpenDialog(open) == JFileChooser.APPROVE_OPTION){
                //
            }
            chemin_image = browser.getSelectedFile().getAbsolutePath();
            chemin_image = chemin_image.replaceAll("\\\\", "\\\\\\\\");
            
            try{
                conn = javaconnect.ConnectDb();
                
                String sql_modifier_image_utilisateur = ("UPDATE utilisateur SET image = '"+chemin_image+
                        "' WHERE user = '"+Login_jframe.getUtilisateur_conn()+"';");
                pst = conn.prepareStatement(sql_modifier_image_utilisateur);
                pst.executeUpdate();
                
                ImageIcon imageIcon = new ImageIcon(chemin_image); // load the image to a imageIcon
                Image image = imageIcon.getImage(); // transform it 
                Image newimg = image.getScaledInstance(256, 256,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
                imageIcon = new ImageIcon(newimg);  // transform it back 
                carre_image.setIcon(imageIcon);
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_carre_imageMouseClicked

    private void button_mon_compteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_mon_compteActionPerformed
        // TODO add your handling code here:
        Mon_Compte_jframe fenetre_mon_compte = new Mon_Compte_jframe();
        fenetre_mon_compte.setLocationRelativeTo(null);
        fenetre_mon_compte.setVisible(true);
    }//GEN-LAST:event_button_mon_compteActionPerformed

    private void button_utilisateur_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_utilisateur_ajouterActionPerformed
        // TODO add your handling code here:
        Utilisateur_jframe fenetre_utilisateur = new Utilisateur_jframe();
        fenetre_utilisateur.setLocationRelativeTo(null);
        fenetre_utilisateur.setVisible(true);
        
    }//GEN-LAST:event_button_utilisateur_ajouterActionPerformed

    private void button_utilisateur_supprimerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_utilisateur_supprimerActionPerformed
        // TODO add your handling code here:
        utilisateur_option = 1;
        Utilisateur_jframe fenetre_utilisateur = new Utilisateur_jframe();
        fenetre_utilisateur.setLocationRelativeTo(null);
        fenetre_utilisateur.setVisible(true);
    }//GEN-LAST:event_button_utilisateur_supprimerActionPerformed

    private void button_quitterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_quitterActionPerformed
        // TODO add your handling code here:
        System.exit(0);
        //this.dispose();
    }//GEN-LAST:event_button_quitterActionPerformed

    private void button_quitterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_quitterKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            System.exit(0);
            //this.dispose();
        }
        if (c == KeyEvent.VK_F4){
            System.exit(0);
            //this.dispose();
        }
    }//GEN-LAST:event_button_quitterKeyPressed
    
    public static int choix_option_agence = 0;
            
    private void button_agence_afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agence_afficherActionPerformed
        // TODO add your handling code here:
        choix_option_agence = 0;
        Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
        fenetre_agence_aide.setLocationRelativeTo(null);
        fenetre_agence_aide.setVisible(true);
        
    }//GEN-LAST:event_button_agence_afficherActionPerformed

    private void button_agence_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agence_ajouterActionPerformed
        // TODO add your handling code here:
        choix_option_agence = 1;
        Agence_jframe fenetre_agence = new Agence_jframe();
        fenetre_agence.setLocationRelativeTo(null);
        fenetre_agence.setVisible(true);
    }//GEN-LAST:event_button_agence_ajouterActionPerformed

    private void button_agence_mod_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_agence_mod_suppActionPerformed
        // TODO add your handling code here:
        choix_option_agence = 2;
        Agence_jframe fenetre_agence = new Agence_jframe();
        fenetre_agence.setLocationRelativeTo(null);
        fenetre_agence.setVisible(true);
    }//GEN-LAST:event_button_agence_mod_suppActionPerformed

    public static int sav_option = 0; 
    private void button_sav_afficherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_sav_afficherActionPerformed
        // TODO add your handling code here:
        sav_option = 1;
        Principal_jframe.button_sav_afficher.setEnabled(false);
        Principal_jframe.button_sav_ajouter.setEnabled(false);
        Principal_jframe.button_sav_mod_supp.setEnabled(false);
        
        Principal_jframe.button_agence_afficher.setEnabled(false);
        Principal_jframe.button_agence_ajouter.setEnabled(false);
        Principal_jframe.button_agence_mod_supp.setEnabled(false);
        
        Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
        Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
        Principal_jframe.button_mon_compte.setEnabled(false);
        
        Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
        fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
        fenetre_sav_mod_supp_aff_liste.setVisible(true);
    }//GEN-LAST:event_button_sav_afficherActionPerformed

    private void button_sav_ajouterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_sav_ajouterActionPerformed
        // TODO add your handling code here:
        sav_option = 2; 
        Principal_jframe.button_sav_afficher.setEnabled(false);
        Principal_jframe.button_sav_ajouter.setEnabled(false);
        Principal_jframe.button_sav_mod_supp.setEnabled(false);
        
        Principal_jframe.button_agence_afficher.setEnabled(false);
        Principal_jframe.button_agence_ajouter.setEnabled(false);
        Principal_jframe.button_agence_mod_supp.setEnabled(false);
        
        Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
        Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
        Principal_jframe.button_mon_compte.setEnabled(false);
        
        Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
        fenetre_sav_ajout_liste.setLocationRelativeTo(null);
        fenetre_sav_ajout_liste.setVisible(true);
    }//GEN-LAST:event_button_sav_ajouterActionPerformed

    private void button_sav_mod_suppActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_sav_mod_suppActionPerformed
        // TODO add your handling code here:
        sav_option = 3; 
        Principal_jframe.button_sav_afficher.setEnabled(false);
        Principal_jframe.button_sav_ajouter.setEnabled(false);
        Principal_jframe.button_sav_mod_supp.setEnabled(false);
        
        Principal_jframe.button_agence_afficher.setEnabled(false);
        Principal_jframe.button_agence_ajouter.setEnabled(false);
        Principal_jframe.button_agence_mod_supp.setEnabled(false);
        
        Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
        Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
        Principal_jframe.button_mon_compte.setEnabled(false);
        
        Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
        fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
        fenetre_sav_mod_supp_aff_liste.setVisible(true);
    }//GEN-LAST:event_button_sav_mod_suppActionPerformed

    private void button_agence_afficherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_agence_afficherKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            choix_option_agence = 0;
            Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
            fenetre_agence_aide.setLocationRelativeTo(null);
            fenetre_agence_aide.setVisible(true);
        }
    }//GEN-LAST:event_button_agence_afficherKeyPressed

    private void button_agence_ajouterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_agence_ajouterKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            choix_option_agence = 1;
            Agence_jframe fenetre_agence = new Agence_jframe();
            fenetre_agence.setLocationRelativeTo(null);
            fenetre_agence.setVisible(true);
        }
    }//GEN-LAST:event_button_agence_ajouterKeyPressed

    private void button_agence_mod_suppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_agence_mod_suppKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            choix_option_agence = 2;
            Agence_jframe fenetre_agence = new Agence_jframe();
            fenetre_agence.setLocationRelativeTo(null);
            fenetre_agence.setVisible(true);
        }
    }//GEN-LAST:event_button_agence_mod_suppKeyPressed

    private void button_sav_afficherKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_sav_afficherKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            sav_option = 1;
            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);

            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
            fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
            fenetre_sav_mod_supp_aff_liste.setVisible(true);
        }
    }//GEN-LAST:event_button_sav_afficherKeyPressed

    private void button_sav_ajouterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_sav_ajouterKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            sav_option = 2; 
            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);

            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
            fenetre_sav_ajout_liste.setLocationRelativeTo(null);
            fenetre_sav_ajout_liste.setVisible(true);
        }
    }//GEN-LAST:event_button_sav_ajouterKeyPressed

    private void button_sav_mod_suppKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_sav_mod_suppKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            sav_option = 3; 
            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);

            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
            fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
            fenetre_sav_mod_supp_aff_liste.setVisible(true);
        }
    }//GEN-LAST:event_button_sav_mod_suppKeyPressed

    private void button_mon_compteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_mon_compteKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Mon_Compte_jframe fenetre_mon_compte = new Mon_Compte_jframe();
            fenetre_mon_compte.setLocationRelativeTo(null);
            fenetre_mon_compte.setVisible(true);
        }
    }//GEN-LAST:event_button_mon_compteKeyPressed

    private void button_utilisateur_ajouterKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_utilisateur_ajouterKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Utilisateur_jframe fenetre_utilisateur = new Utilisateur_jframe();
            fenetre_utilisateur.setLocationRelativeTo(null);
            fenetre_utilisateur.setVisible(true);
        }
    }//GEN-LAST:event_button_utilisateur_ajouterKeyPressed

    private void button_utilisateur_supprimerKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_utilisateur_supprimerKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            utilisateur_option = 1;
            Utilisateur_jframe fenetre_utilisateur = new Utilisateur_jframe();
            fenetre_utilisateur.setLocationRelativeTo(null);
            fenetre_utilisateur.setVisible(true);
        }
    }//GEN-LAST:event_button_utilisateur_supprimerKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_formWindowClosing

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
            java.util.logging.Logger.getLogger(Principal_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal_jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton button_agence_afficher;
    public static javax.swing.JButton button_agence_ajouter;
    public static javax.swing.JButton button_agence_mod_supp;
    public static javax.swing.JButton button_mon_compte;
    private javax.swing.JButton button_quitter;
    public static javax.swing.JButton button_sav_afficher;
    public static javax.swing.JButton button_sav_ajouter;
    public static javax.swing.JButton button_sav_mod_supp;
    public static javax.swing.JButton button_utilisateur_ajouter;
    public static javax.swing.JButton button_utilisateur_supprimer;
    private javax.swing.JLabel carre_image;
    private javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    // End of variables declaration//GEN-END:variables
}
