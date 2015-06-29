
import java.awt.Component;
import java.awt.Container;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author gwen
 */
public class Agence_jframe extends javax.swing.JFrame {

    /**
     * Creates new form Agence_jframe
     */
    Connection conn = null;
    ResultSet Rs;
    PreparedStatement pst;
    
    private String txt_numero_agence_verif;
    
    
    public static void setNumero_agence(String un_numero){
        txt_numero_agence.setText(un_numero);
    }
    
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
    public static String numero_agence_affichage;
    public Agence_jframe() {
        initComponents();
        
        if (Principal_jframe.choix_option_agence == 1){
            txt_numero_agence.setEnabled(false);
            button_chercher_agence.setEnabled(false);
            button_modifier_agence.setEnabled(false);
            button_supprimer_agence.setEnabled(false);
            
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
        
            
            
            txt_nom.requestFocus();
        }
        
        if (Principal_jframe.choix_option_agence == 2){
            button_ajouter_agence.setEnabled(false);
            
            jTabbedPane1.setVisible(false);
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
            
            
            
        }
        
        txt_numero_agence.setDocument(new testDocument(10));
        
        txt_nom.setDocument(new testDocument(100));
        txt_inter1.setDocument(new testDocument(30));
        txt_inter2.setDocument(new testDocument(30));
        txt_inter3.setDocument(new testDocument(30));
        txt_inter4.setDocument(new testDocument(30));
        txt_inter5.setDocument(new testDocument(30));
        txt_inter6.setDocument(new testDocument(30));
        txt_inter7.setDocument(new testDocument(30));
        txt_inter8.setDocument(new testDocument(30));
        txt_inter9.setDocument(new testDocument(30));
        txt_inter10.setDocument(new testDocument(30));
        txt_inter11.setDocument(new testDocument(30));
        txt_niv_inter1.setDocument(new testDocument(15));
        txt_niv_inter2.setDocument(new testDocument(15));
        txt_niv_inter3.setDocument(new testDocument(15));
        txt_niv_inter4.setDocument(new testDocument(15));
        txt_niv_inter5.setDocument(new testDocument(15));
        txt_niv_inter6.setDocument(new testDocument(15));
        txt_niv_inter7.setDocument(new testDocument(15));
        txt_niv_inter8.setDocument(new testDocument(15));
        txt_niv_inter9.setDocument(new testDocument(15));
        txt_niv_inter10.setDocument(new testDocument(15));
        txt_niv_inter11.setDocument(new testDocument(15));
        txt_tel_inter1.setDocument(new testDocument(15));
        txt_tel_inter2.setDocument(new testDocument(15));
        txt_tel_inter3.setDocument(new testDocument(15));
        txt_tel_inter4.setDocument(new testDocument(15));
        txt_tel_inter5.setDocument(new testDocument(15));
        txt_tel_inter6.setDocument(new testDocument(15));
        txt_tel_inter7.setDocument(new testDocument(15));
        txt_tel_inter8.setDocument(new testDocument(15));
        txt_tel_inter9.setDocument(new testDocument(15));
        txt_tel_inter10.setDocument(new testDocument(15));
        txt_tel_inter11.setDocument(new testDocument(15));
        txt_version_logi.setDocument(new testDocument(15));
        txt_version_remon.setDocument(new testDocument(15));
        txt_version_remon2.setDocument(new testDocument(15));
        txt_IP_1.setDocument(new testDocument(25));
        txt_IP_2.setDocument(new testDocument(25));
        txt_info.setDocument(new testDocument(255));
        //txt_actif.setDocument(new testDocument(10));
        txt_tel_ag.setDocument(new testDocument(40));
        txt_fax_ag.setDocument(new testDocument(40));
        txt_mail_ag.setDocument(new testDocument(80));
        txt_maintenance.setDocument(new testDocument(80));
        txt_mail_inter1.setDocument(new testDocument(80));
        txt_mail_inter2.setDocument(new testDocument(80));
        txt_mail_inter3.setDocument(new testDocument(80));
        txt_mail_inter4.setDocument(new testDocument(80));
        txt_mail_inter5.setDocument(new testDocument(80));
        txt_mail_inter6.setDocument(new testDocument(80));
        txt_mail_inter7.setDocument(new testDocument(80));
        txt_mail_inter8.setDocument(new testDocument(80));
        txt_mail_inter9.setDocument(new testDocument(80));
        txt_mail_inter10.setDocument(new testDocument(80));
        txt_mail_inter11.setDocument(new testDocument(80));
        txt_instal_pers.setDocument(new testDocument(40));
        txt_adr1.setDocument(new testDocument(40));
        txt_adr2.setDocument(new testDocument(40));
        txt_adr3.setDocument(new testDocument(40));
        txt_adr4.setDocument(new testDocument(40));
        txt_cp.setDocument(new testDocument(10));
        txt_ville.setDocument(new testDocument(80));
        txt_pays.setDocument(new testDocument(80));
        txt_info_ag.setDocument(new testDocument(255));
        txt_user_version.setDocument(new testDocument(15));
        txt_user_recup.setDocument(new testDocument(15));
        txt_code_int_ag.setDocument(new testDocument(10));
        txt_nb_licence.setDocument(new testDocument(40));
        txt_version_migration.setDocument(new testDocument(15));
        txt_user_recup2.setDocument(new testDocument(15));
        
        
        
        if (Principal_jframe.choix_option_agence == 0){
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
            
            setNumero_agence(numero_agence_affichage);
            
            Chercher_agence();
            button_aide_agence.setEnabled(false);
            button_ajouter_agence.setEnabled(false);
            button_chercher_agence.setEnabled(false);
            button_modifier_agence.setEnabled(false);
            button_supprimer_agence.setEnabled(false);   
        }
        if (Sav_ajout_mod_supp_aff.option_aide == 1){
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);

            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
            
            
            setNumero_agence(Sav_ajout_mod_supp_aff.numero_de_lagence_a_afficher);
            Chercher_agence();
            button_aide_agence.setEnabled(false);
            button_ajouter_agence.setEnabled(false);
            button_chercher_agence.setEnabled(false);
            button_modifier_agence.setEnabled(false);
            button_supprimer_agence.setEnabled(false);
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
        jTextArea1 = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        button_aide_agence = new javax.swing.JButton();
        button_ajouter_agence = new javax.swing.JButton();
        button_modifier_agence = new javax.swing.JButton();
        button_chercher_agence = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        txt_nom = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        txt_tel_ag = new javax.swing.JTextField();
        jLabel58 = new javax.swing.JLabel();
        txt_fax_ag = new javax.swing.JTextField();
        jLabel59 = new javax.swing.JLabel();
        txt_mail_ag = new javax.swing.JTextField();
        jLabel60 = new javax.swing.JLabel();
        txt_adr1 = new javax.swing.JTextField();
        txt_adr2 = new javax.swing.JTextField();
        txt_adr3 = new javax.swing.JTextField();
        txt_adr4 = new javax.swing.JTextField();
        jLabel64 = new javax.swing.JLabel();
        txt_cp = new javax.swing.JTextField();
        jLabel65 = new javax.swing.JLabel();
        txt_ville = new javax.swing.JTextField();
        jLabel66 = new javax.swing.JLabel();
        txt_pays = new javax.swing.JTextField();
        jLabel67 = new javax.swing.JLabel();
        txt_IP_1 = new javax.swing.JTextField();
        jLabel68 = new javax.swing.JLabel();
        txt_IP_2 = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel72 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        txt_version_logi = new javax.swing.JTextField();
        txt_version_remon = new javax.swing.JTextField();
        txt_user_version = new javax.swing.JTextField();
        txt_user_recup = new javax.swing.JTextField();
        txt_date_version = new javax.swing.JFormattedTextField();
        txt_date_recup = new javax.swing.JFormattedTextField();
        txt_date_version_install = new javax.swing.JFormattedTextField();
        txt_date_recup_install = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        txt_version_migration = new javax.swing.JTextField();
        txt_date_migration = new javax.swing.JFormattedTextField();
        jLabel51 = new javax.swing.JLabel();
        txt_maintenance = new javax.swing.JTextField();
        jLabel50 = new javax.swing.JLabel();
        txt_statut_maintenance = new javax.swing.JComboBox();
        jLabel80 = new javax.swing.JLabel();
        txt_instal = new javax.swing.JFormattedTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        txt_instal_pers = new javax.swing.JTextField();
        txt_type_recup = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txt_type_recup2 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        txt_version_remon2 = new javax.swing.JTextField();
        txt_date_recup2 = new javax.swing.JFormattedTextField();
        txt_date_recup2_install = new javax.swing.JFormattedTextField();
        txt_user_recup2 = new javax.swing.JTextField();
        jLabel78 = new javax.swing.JLabel();
        txt_actif = new javax.swing.JComboBox();
        jLabel83 = new javax.swing.JLabel();
        txt_nb_licence = new javax.swing.JTextField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        txt_fin_maint = new javax.swing.JFormattedTextField();
        jLabel77 = new javax.swing.JLabel();
        jLabel81 = new javax.swing.JLabel();
        jLabel82 = new javax.swing.JLabel();
        txt_code_int_ag = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_info_ag = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        txt_info = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel2 = new javax.swing.JPanel();
        txt_inter1 = new javax.swing.JTextField();
        txt_inter2 = new javax.swing.JTextField();
        txt_inter3 = new javax.swing.JTextField();
        txt_inter4 = new javax.swing.JTextField();
        txt_inter5 = new javax.swing.JTextField();
        txt_inter6 = new javax.swing.JTextField();
        txt_inter7 = new javax.swing.JTextField();
        txt_inter8 = new javax.swing.JTextField();
        txt_inter9 = new javax.swing.JTextField();
        txt_inter10 = new javax.swing.JTextField();
        txt_inter11 = new javax.swing.JTextField();
        txt_niv_inter1 = new javax.swing.JTextField();
        txt_niv_inter2 = new javax.swing.JTextField();
        txt_niv_inter3 = new javax.swing.JTextField();
        txt_niv_inter4 = new javax.swing.JTextField();
        txt_niv_inter5 = new javax.swing.JTextField();
        txt_niv_inter6 = new javax.swing.JTextField();
        txt_niv_inter7 = new javax.swing.JTextField();
        txt_niv_inter8 = new javax.swing.JTextField();
        txt_niv_inter9 = new javax.swing.JTextField();
        txt_niv_inter10 = new javax.swing.JTextField();
        txt_niv_inter11 = new javax.swing.JTextField();
        txt_tel_inter1 = new javax.swing.JTextField();
        txt_tel_inter2 = new javax.swing.JTextField();
        txt_tel_inter3 = new javax.swing.JTextField();
        txt_tel_inter4 = new javax.swing.JTextField();
        txt_tel_inter5 = new javax.swing.JTextField();
        txt_tel_inter6 = new javax.swing.JTextField();
        txt_tel_inter7 = new javax.swing.JTextField();
        txt_tel_inter8 = new javax.swing.JTextField();
        txt_tel_inter9 = new javax.swing.JTextField();
        txt_tel_inter10 = new javax.swing.JTextField();
        txt_tel_inter11 = new javax.swing.JTextField();
        txt_mail_inter1 = new javax.swing.JTextField();
        txt_mail_inter2 = new javax.swing.JTextField();
        txt_mail_inter3 = new javax.swing.JTextField();
        txt_mail_inter4 = new javax.swing.JTextField();
        txt_mail_inter5 = new javax.swing.JTextField();
        txt_mail_inter6 = new javax.swing.JTextField();
        txt_mail_inter7 = new javax.swing.JTextField();
        txt_mail_inter8 = new javax.swing.JTextField();
        txt_mail_inter9 = new javax.swing.JTextField();
        txt_mail_inter10 = new javax.swing.JTextField();
        txt_mail_inter11 = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_numero_agence = new javax.swing.JTextField();
        button_supprimer_agence = new javax.swing.JButton();
        button_quitter_agence = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Agence");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Numéro de l'agence :");

        button_aide_agence.setText("Aide (F2)");
        button_aide_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aide_agenceActionPerformed(evt);
            }
        });
        button_aide_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_aide_agenceKeyPressed(evt);
            }
        });

        button_ajouter_agence.setText("Ajouter(F6)");
        button_ajouter_agence.setNextFocusableComponent(button_modifier_agence);
        button_ajouter_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajouter_agenceActionPerformed(evt);
            }
        });
        button_ajouter_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_ajouter_agenceKeyPressed(evt);
            }
        });

        button_modifier_agence.setText("Modifier(F7)");
        button_modifier_agence.setNextFocusableComponent(button_supprimer_agence);
        button_modifier_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modifier_agenceActionPerformed(evt);
            }
        });
        button_modifier_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_modifier_agenceKeyPressed(evt);
            }
        });

        button_chercher_agence.setText("Afficher");
        button_chercher_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_chercher_agenceActionPerformed(evt);
            }
        });
        button_chercher_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_chercher_agenceKeyPressed(evt);
            }
        });

        txt_nom.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_nom.setNextFocusableComponent(txt_adr1);
        txt_nom.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_nomFocusGained(evt);
            }
        });
        txt_nom.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nomKeyPressed(evt);
            }
        });

        jLabel4.setText("Nom* :");

        jLabel57.setText("Tel :");

        txt_tel_ag.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_ag.setNextFocusableComponent(txt_fax_ag);
        txt_tel_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_agKeyPressed(evt);
            }
        });

        jLabel58.setText("Fax :");

        txt_fax_ag.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_fax_ag.setNextFocusableComponent(txt_mail_ag);
        txt_fax_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fax_agKeyPressed(evt);
            }
        });

        jLabel59.setText("Mail :");

        txt_mail_ag.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_ag.setNextFocusableComponent(txt_instal);
        txt_mail_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_agKeyPressed(evt);
            }
        });

        jLabel60.setText("Adr :");

        txt_adr1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_adr1.setNextFocusableComponent(txt_adr2);
        txt_adr1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_adr1KeyPressed(evt);
            }
        });

        txt_adr2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_adr2.setNextFocusableComponent(txt_adr3);
        txt_adr2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_adr2KeyPressed(evt);
            }
        });

        txt_adr3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_adr3.setNextFocusableComponent(txt_adr4);
        txt_adr3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_adr3KeyPressed(evt);
            }
        });

        txt_adr4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_adr4.setNextFocusableComponent(txt_cp);
        txt_adr4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_adr4KeyPressed(evt);
            }
        });

        jLabel64.setText("CP :");

        txt_cp.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_cp.setNextFocusableComponent(txt_ville);
        txt_cp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_cpKeyPressed(evt);
            }
        });

        jLabel65.setText("Ville :");

        txt_ville.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_ville.setNextFocusableComponent(txt_pays);
        txt_ville.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_villeKeyPressed(evt);
            }
        });

        jLabel66.setText("Pays :");

        txt_pays.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_pays.setNextFocusableComponent(txt_tel_ag);
        txt_pays.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_paysKeyPressed(evt);
            }
        });

        jLabel67.setText("IP 1 :");

        txt_IP_1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_IP_1.setNextFocusableComponent(txt_IP_2);
        txt_IP_1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IP_1KeyPressed(evt);
            }
        });

        jLabel68.setText("IP 2 :");

        txt_IP_2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_IP_2.setNextFocusableComponent(txt_code_int_ag);
        txt_IP_2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_IP_2KeyPressed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jLabel72.setText("Date version logiciel");

        jLabel74.setText("Utilisateur");

        jLabel73.setText("Date installation");

        jLabel69.setText("Sogetour");

        jLabel71.setText("Version");

        jLabel70.setText("Recup");

        txt_version_logi.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_version_logi.setNextFocusableComponent(txt_date_version);
        txt_version_logi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_version_logiKeyPressed(evt);
            }
        });

        txt_version_remon.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_version_remon.setNextFocusableComponent(txt_date_recup);
        txt_version_remon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_version_remonKeyPressed(evt);
            }
        });

        txt_user_version.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_user_version.setNextFocusableComponent(txt_type_recup);
        txt_user_version.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_user_versionKeyPressed(evt);
            }
        });

        txt_user_recup.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_user_recup.setNextFocusableComponent(txt_type_recup2);
        txt_user_recup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_user_recupKeyPressed(evt);
            }
        });

        try {
            txt_date_version.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_version.setNextFocusableComponent(txt_date_version_install);
        txt_date_version.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_versionFocusLost(evt);
            }
        });
        txt_date_version.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_versionKeyPressed(evt);
            }
        });

        try {
            txt_date_recup.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_recup.setNextFocusableComponent(txt_date_recup_install);
        txt_date_recup.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_recupFocusLost(evt);
            }
        });
        txt_date_recup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_recupKeyPressed(evt);
            }
        });

        try {
            txt_date_version_install.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_version_install.setNextFocusableComponent(txt_user_version);
        txt_date_version_install.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_version_installFocusLost(evt);
            }
        });
        txt_date_version_install.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_version_installKeyPressed(evt);
            }
        });

        try {
            txt_date_recup_install.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_recup_install.setNextFocusableComponent(txt_user_recup);
        txt_date_recup_install.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_recup_installFocusLost(evt);
            }
        });
        txt_date_recup_install.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_recup_installKeyPressed(evt);
            }
        });

        jLabel3.setText("Version migration :");

        jLabel49.setText("Date migration :");

        txt_version_migration.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_version_migration.setNextFocusableComponent(txt_date_migration);
        txt_version_migration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_version_migrationKeyPressed(evt);
            }
        });

        try {
            txt_date_migration.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_migration.setNextFocusableComponent(txt_maintenance);
        txt_date_migration.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_migrationFocusLost(evt);
            }
        });
        txt_date_migration.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_migrationKeyPressed(evt);
            }
        });

        jLabel51.setText("Maintenance :");

        txt_maintenance.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_maintenance.setNextFocusableComponent(txt_statut_maintenance);
        txt_maintenance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_maintenanceKeyPressed(evt);
            }
        });

        jLabel50.setText("Statut maintenance :");

        txt_statut_maintenance.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Interdite", "Possible", "Retard de paiement", "Autre" }));
        txt_statut_maintenance.setNextFocusableComponent(txt_fin_maint);
        txt_statut_maintenance.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_statut_maintenanceKeyPressed(evt);
            }
        });

        jLabel80.setText("Fin maintenance :");

        try {
            txt_instal.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_instal.setNextFocusableComponent(txt_instal_pers);
        txt_instal.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_instalFocusLost(evt);
            }
        });
        txt_instal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_instalKeyPressed(evt);
            }
        });

        jLabel75.setText("Instal :");

        jLabel76.setText("Instal pers :");

        txt_instal_pers.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_instal_pers.setNextFocusableComponent(txt_actif);
        txt_instal_pers.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_instal_persKeyPressed(evt);
            }
        });

        txt_type_recup.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucune", "Amadeus", "Galileo", "Sabre" }));
        txt_type_recup.setName(""); // NOI18N
        txt_type_recup.setNextFocusableComponent(txt_version_remon);
        txt_type_recup.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_type_recupKeyPressed(evt);
            }
        });

        jLabel8.setText("Type recup");

        txt_type_recup2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Aucune", "Amadeus", "Galileo", "Sabre" }));
        txt_type_recup2.setToolTipText("");
        txt_type_recup2.setNextFocusableComponent(txt_version_remon2);
        txt_type_recup2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_type_recup2KeyPressed(evt);
            }
        });

        jLabel9.setText("Recup 2");

        txt_version_remon2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_version_remon2.setNextFocusableComponent(txt_date_recup2);
        txt_version_remon2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_version_remon2KeyPressed(evt);
            }
        });

        try {
            txt_date_recup2.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_recup2.setNextFocusableComponent(txt_date_recup2_install);
        txt_date_recup2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_recup2FocusLost(evt);
            }
        });
        txt_date_recup2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_recup2KeyPressed(evt);
            }
        });

        try {
            txt_date_recup2_install.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_recup2_install.setNextFocusableComponent(txt_user_recup2);
        txt_date_recup2_install.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_recup2_installFocusLost(evt);
            }
        });
        txt_date_recup2_install.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_recup2_installKeyPressed(evt);
            }
        });

        txt_user_recup2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_user_recup2.setNextFocusableComponent(txt_version_migration);
        txt_user_recup2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_user_recup2KeyPressed(evt);
            }
        });

        jLabel78.setText("Actif :");

        txt_actif.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Inactif", "Actif" }));
        txt_actif.setNextFocusableComponent(txt_nb_licence);
        txt_actif.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_actifKeyPressed(evt);
            }
        });

        jLabel83.setText("Nbr licence :");

        txt_nb_licence.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_nb_licence.setNextFocusableComponent(txt_version_logi);
        txt_nb_licence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_nb_licenceKeyPressed(evt);
            }
        });

        try {
            txt_fin_maint.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_fin_maint.setNextFocusableComponent(txt_IP_1);
        txt_fin_maint.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_fin_maintFocusLost(evt);
            }
        });
        txt_fin_maint.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_fin_maintKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel80)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_fin_maint, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(369, 369, 369))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel75)
                        .addGap(10, 10, 10)
                        .addComponent(txt_instal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel76)
                        .addGap(4, 4, 4)
                        .addComponent(txt_instal_pers, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel78)
                        .addGap(4, 4, 4)
                        .addComponent(txt_actif, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel83)
                        .addGap(4, 4, 4)
                        .addComponent(txt_nb_licence, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(99, 99, 99)
                        .addComponent(jLabel8)
                        .addGap(61, 61, 61)
                        .addComponent(jLabel71)
                        .addGap(39, 39, 39)
                        .addComponent(jLabel72)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel73)
                        .addGap(34, 34, 34)
                        .addComponent(jLabel74))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addComponent(jLabel3)
                        .addGap(4, 4, 4)
                        .addComponent(txt_version_migration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addComponent(jLabel49)
                        .addGap(4, 4, 4)
                        .addComponent(txt_date_migration, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_type_recup2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_version_remon2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(29, 29, 29)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel69)
                                        .addGap(110, 110, 110))
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel70)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_type_recup, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_version_remon, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txt_version_logi))))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_date_recup2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(txt_date_version)
                            .addComponent(txt_date_recup))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_date_recup2_install, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                            .addComponent(txt_date_version_install)
                            .addComponent(txt_date_recup_install))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_user_recup, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                            .addComponent(txt_user_version)
                            .addComponent(txt_user_recup2)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 624, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel51)
                                    .addComponent(jLabel50))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(txt_statut_maintenance, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(195, 195, 195))
                                    .addComponent(txt_maintenance))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txt_instal, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_instal_pers, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel78)
                        .addComponent(txt_actif, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txt_nb_licence, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel83))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76))))
                .addGap(20, 20, 20)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel71)
                    .addComponent(jLabel72)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel73)
                        .addComponent(jLabel74)))
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jLabel69))
                    .addComponent(txt_version_logi, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date_version, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date_version_install, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_user_version, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel70))
                            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_version_remon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_type_recup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_date_recup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_date_recup_install, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_user_recup, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel9))
                            .addComponent(txt_version_remon2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_date_recup2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_date_recup2_install, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_user_recup2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_version_migration, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_date_migration, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel49))))
                        .addGap(6, 6, 6)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_statut_maintenance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel50))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel80)
                            .addComponent(txt_fin_maint, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(txt_type_recup2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel77.setText("Information :  (CTRL + TAB pour passer au champ suivant)");

        jLabel81.setText("Information agence : (CTRL + TAB pour passer au champ suivant)");

        jLabel82.setText("Code agence :");

        txt_code_int_ag.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_code_int_ag.setNextFocusableComponent(txt_info_ag);
        txt_code_int_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_code_int_agKeyPressed(evt);
            }
        });

        txt_info_ag.setColumns(20);
        txt_info_ag.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_info_ag.setLineWrap(true);
        txt_info_ag.setRows(5);
        txt_info_ag.setNextFocusableComponent(txt_info);
        txt_info_ag.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_info_agKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(txt_info_ag);

        txt_info.setColumns(20);
        txt_info.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_info.setLineWrap(true);
        txt_info.setRows(5);
        txt_info.setNextFocusableComponent(button_ajouter_agence);
        txt_info.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_infoKeyPressed(evt);
            }
        });
        jScrollPane3.setViewportView(txt_info);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(27, 27, 27)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel60)
                                    .addComponent(jLabel57)
                                    .addComponent(jLabel64)
                                    .addComponent(jLabel59)
                                    .addComponent(jLabel4))
                                .addGap(4, 4, 4)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_tel_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel58)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_fax_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_cp)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel65)
                                        .addGap(4, 4, 4)
                                        .addComponent(txt_ville, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(4, 4, 4)
                                        .addComponent(jLabel66)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_pays, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_nom)
                                    .addComponent(txt_adr1)
                                    .addComponent(txt_adr2)
                                    .addComponent(txt_adr3)
                                    .addComponent(txt_adr4)
                                    .addComponent(txt_mail_ag)))
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel82)
                                    .addComponent(jLabel67))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_IP_1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel68)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txt_IP_2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txt_code_int_ag)))
                            .addComponent(jScrollPane2)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel81)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel77)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_nom, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(jLabel60))
                            .addComponent(txt_adr1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(txt_adr2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_adr3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_adr4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txt_cp, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel64))
                                .addComponent(txt_ville, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(5, 5, 5)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel65)
                                        .addComponent(jLabel66))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txt_pays, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(1, 1, 1)))
                        .addGap(7, 7, 7)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_fax_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_tel_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel58)
                                .addComponent(jLabel57)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_mail_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59))
                        .addGap(11, 11, 11)
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 8, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_IP_1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel67)
                            .addComponent(jLabel68)
                            .addComponent(txt_IP_2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel82)
                            .addComponent(txt_code_int_ag, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel81)
                    .addComponent(jLabel77))
                .addGap(5, 5, 5)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Informations générales", jPanel1);

        txt_inter1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter1.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter1KeyPressed(evt);
            }
        });

        txt_inter2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter2.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter2KeyPressed(evt);
            }
        });

        txt_inter3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter3.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter3KeyPressed(evt);
            }
        });

        txt_inter4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter4.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter4KeyPressed(evt);
            }
        });

        txt_inter5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter5.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter5KeyPressed(evt);
            }
        });

        txt_inter6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter6.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter6KeyPressed(evt);
            }
        });

        txt_inter7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter7.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter7KeyPressed(evt);
            }
        });

        txt_inter8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter8.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter8KeyPressed(evt);
            }
        });

        txt_inter9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter9.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter9KeyPressed(evt);
            }
        });

        txt_inter10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter10.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter10KeyPressed(evt);
            }
        });

        txt_inter11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_inter11.setPreferredSize(new java.awt.Dimension(180, 20));
        txt_inter11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_inter11KeyPressed(evt);
            }
        });

        txt_niv_inter1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter1.setName(""); // NOI18N
        txt_niv_inter1.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter1KeyPressed(evt);
            }
        });

        txt_niv_inter2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter2.setName(""); // NOI18N
        txt_niv_inter2.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter2KeyPressed(evt);
            }
        });

        txt_niv_inter3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter3.setName(""); // NOI18N
        txt_niv_inter3.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter3KeyPressed(evt);
            }
        });

        txt_niv_inter4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter4.setName(""); // NOI18N
        txt_niv_inter4.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter4KeyPressed(evt);
            }
        });

        txt_niv_inter5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter5.setName(""); // NOI18N
        txt_niv_inter5.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter5KeyPressed(evt);
            }
        });

        txt_niv_inter6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter6.setName(""); // NOI18N
        txt_niv_inter6.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter6KeyPressed(evt);
            }
        });

        txt_niv_inter7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter7.setName(""); // NOI18N
        txt_niv_inter7.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter7KeyPressed(evt);
            }
        });

        txt_niv_inter8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter8.setName(""); // NOI18N
        txt_niv_inter8.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter8KeyPressed(evt);
            }
        });

        txt_niv_inter9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter9.setName(""); // NOI18N
        txt_niv_inter9.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter9KeyPressed(evt);
            }
        });

        txt_niv_inter10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter10.setName(""); // NOI18N
        txt_niv_inter10.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter10KeyPressed(evt);
            }
        });

        txt_niv_inter11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_niv_inter11.setName(""); // NOI18N
        txt_niv_inter11.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_niv_inter11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_niv_inter11KeyPressed(evt);
            }
        });

        txt_tel_inter1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter1.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter1KeyPressed(evt);
            }
        });

        txt_tel_inter2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter2.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter2KeyPressed(evt);
            }
        });

        txt_tel_inter3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter3.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter3KeyPressed(evt);
            }
        });

        txt_tel_inter4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter4.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter4KeyPressed(evt);
            }
        });

        txt_tel_inter5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter5.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter5KeyPressed(evt);
            }
        });

        txt_tel_inter6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter6.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter6KeyPressed(evt);
            }
        });

        txt_tel_inter7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter7.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter7KeyPressed(evt);
            }
        });

        txt_tel_inter8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter8.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter8KeyPressed(evt);
            }
        });

        txt_tel_inter9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter9.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter9KeyPressed(evt);
            }
        });

        txt_tel_inter10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter10.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter10KeyPressed(evt);
            }
        });

        txt_tel_inter11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_tel_inter11.setPreferredSize(new java.awt.Dimension(100, 20));
        txt_tel_inter11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_tel_inter11KeyPressed(evt);
            }
        });

        txt_mail_inter1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter1.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter1KeyPressed(evt);
            }
        });

        txt_mail_inter2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter2.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter2KeyPressed(evt);
            }
        });

        txt_mail_inter3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter3.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter3KeyPressed(evt);
            }
        });

        txt_mail_inter4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter4.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter4KeyPressed(evt);
            }
        });

        txt_mail_inter5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter5.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter5KeyPressed(evt);
            }
        });

        txt_mail_inter6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter6.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter6KeyPressed(evt);
            }
        });

        txt_mail_inter7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter7.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter7KeyPressed(evt);
            }
        });

        txt_mail_inter8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter8.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter8KeyPressed(evt);
            }
        });

        txt_mail_inter9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter9.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter9KeyPressed(evt);
            }
        });

        txt_mail_inter10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter10.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter10.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter10KeyPressed(evt);
            }
        });

        txt_mail_inter11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_mail_inter11.setPreferredSize(new java.awt.Dimension(150, 20));
        txt_mail_inter11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_mail_inter11KeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Interlocuteur(s)");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Niveau(x)");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Télephone(s)");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Adresse(s) mail");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(51, 51, 51)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(txt_inter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_inter3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txt_inter1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_niv_inter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter9, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_niv_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txt_tel_inter1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txt_tel_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel6)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txt_mail_inter2, javax.swing.GroupLayout.DEFAULT_SIZE, 540, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter10, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txt_mail_inter9, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(51, 51, 51))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(jLabel7)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel1)
                        .addComponent(jLabel5)
                        .addComponent(jLabel6))
                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(txt_tel_inter2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_tel_inter3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addComponent(txt_tel_inter4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_tel_inter10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(txt_tel_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_niv_inter1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_inter1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tel_inter1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_niv_inter2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_mail_inter2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_inter2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_inter3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(txt_niv_inter3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txt_mail_inter3, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter4, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter9, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter10, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_niv_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_mail_inter11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Interlocuteurs", jPanel2);

        txt_numero_agence.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        txt_numero_agence.setHorizontalAlignment(javax.swing.JTextField.RIGHT);
        txt_numero_agence.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        txt_numero_agence.setNextFocusableComponent(button_chercher_agence);
        txt_numero_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_numero_agenceKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txt_numero_agenceKeyTyped(evt);
            }
        });

        button_supprimer_agence.setText("Supprimer(F8)");
        button_supprimer_agence.setNextFocusableComponent(button_quitter_agence);
        button_supprimer_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_supprimer_agenceActionPerformed(evt);
            }
        });
        button_supprimer_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_supprimer_agenceKeyPressed(evt);
            }
        });

        button_quitter_agence.setText("Quitter");
        button_quitter_agence.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_quitter_agenceActionPerformed(evt);
            }
        });
        button_quitter_agence.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_quitter_agenceKeyPressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_fond/1797393.png"))); // NOI18N
        jLabel10.setText("jLabel10");

        jLabel11.setFont(new java.awt.Font("Arial", 2, 11)); // NOI18N
        jLabel11.setText("* Champ obligatoire");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(336, 336, 336)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txt_numero_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_chercher_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(button_aide_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button_ajouter_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_modifier_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(button_supprimer_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(270, 270, 270)
                                .addComponent(button_quitter_agence, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(28, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 1163, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_aide_agence)
                    .addComponent(txt_numero_agence, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(button_chercher_agence))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 530, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_ajouter_agence)
                        .addComponent(jLabel11))
                    .addComponent(button_modifier_agence)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(button_supprimer_agence)
                        .addComponent(button_quitter_agence)))
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 608, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void supprimerAgence(){
        if ("".equals(txt_numero_agence.getText())){
            JOptionPane.showMessageDialog(null, "Inserez d'abord le numéro d'agence à supprimer.");
            txt_numero_agence.requestFocus();
        }else{
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer cette agence ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.OK_OPTION){
                try{
                    conn = javaconnect.ConnectDb();
                    String sql_supprimer_agence = ("DELETE FROM agence WHERE numero = '"+txt_numero_agence.getText()+"';");
                    pst = conn.prepareStatement(sql_supprimer_agence);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Agence supprimé avec succès.");
                    clearTextFields(this.getContentPane());
                    clearTextArea(this.getContentPane());
                    clearComboBox();
                    txt_numero_agence.setEnabled(true);
                    button_chercher_agence.setEnabled(true);
                    button_aide_agence.setEnabled(true);
                    txt_numero_agence.requestFocus();
                    
                    jTabbedPane1.setVisible(false);
                    
                }
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }
    
    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            Principal_jframe.choix_option_agence = 0;
            Sav_ajout_mod_supp_aff.option_aide = 0;
            Principal_jframe.button_agence_afficher.setEnabled(true);
            Principal_jframe.button_agence_ajouter.setEnabled(true);
            Principal_jframe.button_agence_mod_supp.setEnabled(true);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
            Principal_jframe.button_mon_compte.setEnabled(true);

            Principal_jframe.button_sav_afficher.setEnabled(true);
            Principal_jframe.button_sav_ajouter.setEnabled(true);
            Principal_jframe.button_sav_mod_supp.setEnabled(true);
            
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void button_aide_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aide_agenceActionPerformed
        // TODO add your handling code here:
        Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
        fenetre_agence_aide.setLocationRelativeTo(null);
        fenetre_agence_aide.setVisible(true);
    }//GEN-LAST:event_button_aide_agenceActionPerformed

    public void AjouterAgence(){
        if ("".equals(txt_nom.getText())){
            JOptionPane.showMessageDialog(null, "Le champ nom est obligatoire.");
            txt_nom.requestFocus();
        }
        else{
            int option = JOptionPane.showConfirmDialog(null, "Confirmation de l'ajout de l'agence.");
            if(option == JOptionPane.OK_OPTION){
                try {
                    int actif = 0 ;
                    if (txt_actif.getSelectedItem() == "Inactif"){
                        actif = 0;
                    }
                    else if (txt_actif.getSelectedItem() == "Actif"){
                        actif = 1;
                    }

                    int statut_maintenance = 0;
                    if (txt_statut_maintenance.getSelectedItem() == "Interdite"){
                        statut_maintenance = 0;
                    }
                    else if (txt_statut_maintenance.getSelectedItem() == "Possible"){
                        statut_maintenance = 1;
                    }
                    else if (txt_statut_maintenance.getSelectedItem() == "Retard de paiement"){
                        statut_maintenance = 2;
                    }
                    else if (txt_statut_maintenance.getSelectedItem() == "Autre"){
                        statut_maintenance = 3;
                    }
                    
                    int type_recup = 0;
                    if (txt_type_recup.getSelectedItem() == "Aucune"){
                        type_recup = 0;
                    }
                    else if (txt_type_recup.getSelectedItem() == "Amadeus"){
                        type_recup = 1;
                    }
                    else if (txt_type_recup.getSelectedItem() == "Galileo"){
                        type_recup = 2;
                    }
                    else if (txt_type_recup.getSelectedItem() == "Sabre"){
                        type_recup = 3;
                    }
                    
                    int type_recup2 = 0;
                    if (txt_type_recup2.getSelectedItem() == "Aucune"){
                        type_recup2 = 0;
                    }
                    else if (txt_type_recup2.getSelectedItem() == "Amadeus"){
                        type_recup2 = 1;
                    }
                    else if (txt_type_recup2.getSelectedItem() == "Galileo"){
                        type_recup2 = 2;
                    }
                    else if (txt_type_recup2.getSelectedItem() == "Sabre"){
                        type_recup2 = 3;
                    }
                    
                    

                    String date_version = txt_date_version.getText();
                    if ("  -  -  ".equals(date_version)){
                        date_version = "0001-01-01";
                    }
                    else{
                        date_version = Date_Francais_Anglais(date_version);
                    }

                    String date_version_install = txt_date_version_install.getText();
                    if ("  -  -  ".equals(date_version_install)){
                        date_version_install = "0001-01-01";
                    }
                    else{
                        date_version_install = Date_Francais_Anglais(date_version_install);
                    }

                    String date_recup = txt_date_recup.getText();
                    if ("  -  -  ".equals(date_recup)){
                        date_recup = "0001-01-01";
                    }
                    else{
                        date_recup = Date_Francais_Anglais(date_recup);
                    }

                    String date_recup_install = txt_date_recup_install.getText();
                    if ("  -  -  ".equals(date_recup_install)){
                        date_recup_install = "0001-01-01";
                    }
                    else{
                        date_recup_install = Date_Francais_Anglais(date_recup_install);
                    }

                    String instal = txt_instal.getText();
                    if ("  -  -  ".equals(instal)){
                        instal = "0001-01-01";
                    }
                    else{
                        instal = Date_Francais_Anglais(instal);
                    }

                    String date_migration = txt_date_migration.getText();
                    if ("  -  -  ".equals(date_migration)){
                        date_migration = "0001-01-01";
                    }
                    else{
                        date_migration = Date_Francais_Anglais(date_migration);
                    }

                    String fin_maint = txt_fin_maint.getText();
                    if ("  -  -  ".equals(fin_maint)){
                        fin_maint = "0001-01-01";
                    }
                    else{
                        fin_maint = Date_Francais_Anglais(fin_maint);
                    }
                    
                    String date_recup2 = txt_date_recup2.getText();
                    if ("  -  -  ".equals(date_recup2)){
                        date_recup2 = "0001-01-01";
                    }
                    else{
                        date_recup2 = Date_Francais_Anglais(date_recup2);
                    }
                    
                    String date_recup2_install = txt_date_recup2_install.getText();
                    if ("  -  -  ".equals(date_recup2_install)){
                        date_recup2_install = "0001-01-01";
                    }
                    else{
                        date_recup2_install = Date_Francais_Anglais(date_recup2_install);
                    }

                   



                    conn = javaconnect.ConnectDb();
                    String sql_ajout_agence = ("INSERT INTO agence VALUES (numero,'" + txt_nom.getText().replace("'", "''")
                        + "','" + txt_inter1.getText().replace("'", "''") + "','" + txt_inter2.getText().replace("'", "''") + "','" + txt_inter3.getText().replace("'", "''") + "','" + txt_inter4.getText().replace("'", "''")
                        + "','" + txt_inter5.getText().replace("'", "''") + "','" + txt_inter6.getText().replace("'", "''") + "','" + txt_inter7.getText().replace("'", "''") + "','" + txt_inter8.getText().replace("'", "''")
                        + "','" + txt_inter9.getText().replace("'", "''") + "','" + txt_inter10.getText().replace("'", "''") + "','" + txt_inter11.getText().replace("'", "''") + "','" + txt_niv_inter1.getText().replace("'", "''")
                        + "','" + txt_niv_inter2.getText().replace("'", "''") + "','" + txt_niv_inter3.getText().replace("'", "''") + "','" + txt_niv_inter4.getText().replace("'", "''") + "','" + txt_niv_inter5.getText().replace("'", "''")
                        + "','" + txt_niv_inter6.getText().replace("'", "''") + "','" + txt_niv_inter7.getText().replace("'", "''") + "','" + txt_niv_inter8.getText().replace("'", "''") + "','" + txt_niv_inter9.getText().replace("'", "''")
                        + "','" + txt_niv_inter10.getText().replace("'", "''") + "','" + txt_niv_inter11.getText().replace("'", "''")
                        + "','" + txt_tel_inter1.getText().replace("'", "''") + "','" + txt_tel_inter2.getText().replace("'", "''") + "','" + txt_tel_inter3.getText().replace("'", "''") + "','" + txt_tel_inter4.getText().replace("'", "''")
                        + "','" + txt_tel_inter5.getText().replace("'", "''") + "','" + txt_tel_inter6.getText().replace("'", "''") + "','" + txt_tel_inter7.getText().replace("'", "''") + "','" + txt_tel_inter8.getText().replace("'", "''")
                        + "','" + txt_tel_inter9.getText().replace("'", "''") + "','" + txt_tel_inter10.getText().replace("'", "''") + "','" + txt_tel_inter11.getText().replace("'", "''")
                        + "','" + txt_version_logi.getText().replace("'", "''") + "','" + date_version + "','" + txt_version_remon.getText().replace("'", "''")
                        + "','" + date_recup + "','" + txt_IP_1.getText().replace("'", "''") + "','" + txt_IP_2.getText().replace("'", "''") + "','" + txt_info.getText().replace("'", "''")
                        + "','" + actif + "','" + txt_tel_ag.getText().replace("'", "''") + "','" + txt_fax_ag.getText().replace("'", "''") + "','" + txt_mail_ag.getText().replace("'", "''")
                        + "','" + txt_maintenance.getText().replace("'", "''")
                        + "','" + txt_mail_inter1.getText().replace("'", "''") + "','" + txt_mail_inter2.getText().replace("'", "''") + "','" + txt_mail_inter3.getText().replace("'", "''")
                        + "','" + txt_mail_inter4.getText().replace("'", "''") + "','" + txt_mail_inter5.getText().replace("'", "''") + "','" + txt_mail_inter6.getText().replace("'", "''")
                        + "','" + txt_mail_inter7.getText().replace("'", "''") + "','" + txt_mail_inter8.getText().replace("'", "''") + "','" + txt_mail_inter9.getText().replace("'", "''")
                        + "','" + txt_mail_inter10.getText().replace("'", "''") + "','" + txt_mail_inter11.getText().replace("'", "''")
                        + "','" + instal + "','" + txt_instal_pers.getText().replace("'", "''") + "','" + fin_maint
                        + "','" + txt_adr1.getText().replace("'", "''") + "','" + txt_adr2.getText().replace("'", "''") + "','" + txt_adr3.getText().replace("'", "''") + "','" + txt_adr4.getText().replace("'", "''")
                        + "','" + txt_cp.getText().replace("'", "''") + "','" + txt_ville.getText().replace("'", "''") + "','" + txt_pays.getText().replace("'", "''") + "','" + txt_info_ag.getText().replace("'", "''")
                        + "','" + txt_user_version.getText().replace("'", "''") + "','" + txt_user_recup.getText().replace("'", "''")
                        + "','" + date_version_install + "','" + date_recup_install
                        + "','" + txt_code_int_ag.getText().replace("'", "''") + "','" + txt_nb_licence.getText().replace("'", "''")
                        + "','" + txt_version_migration.getText().replace("'", "''") + "','" + date_migration + "','" + statut_maintenance + "','" + type_recup
                        + "','" + type_recup2 + "','" + txt_version_remon2.getText().replace("'", "''") + "','" + date_recup2
                        + "','" + date_recup2_install + "','" + txt_user_recup2.getText().replace("'", "''") + "');");
                    pst = conn.prepareStatement(sql_ajout_agence);
                    pst.executeUpdate();
                    
                    clearTextFields(this.getContentPane());
                    clearTextArea(this.getContentPane());
                    clearComboBox();
                    txt_nom.requestFocus();
                    JOptionPane.showMessageDialog(null, "Agence ajouté avec succès.");    
                } 
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e);
                }
            }
        }
    }
    
    private void button_ajouter_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajouter_agenceActionPerformed
        // TODO add your handling code here:
        AjouterAgence();
    }//GEN-LAST:event_button_ajouter_agenceActionPerformed
    
    public String Date_Anglais_Francais(String date_en_anglais){
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
    public String Date_Francais_Anglais(String date_en_francais){
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
    
    public final void Chercher_agence(){
        if (txt_numero_agence.getText().length() == 0){
            if (Sav_ajout_mod_supp_aff.option_aide != 1){
                JOptionPane.showMessageDialog(null, "Entrez un numéro d'agence.");
                txt_numero_agence.requestFocus();
            }
        }
        else{
            try {
                conn = javaconnect.ConnectDb();
                
                String sql_chercher_agence = ("SELECT * FROM agence WHERE numero =" + txt_numero_agence.getText() + ";");
                
                pst = conn.prepareStatement(sql_chercher_agence);
                Rs = pst.executeQuery();
                if (Rs.next()) {
                    txt_numero_agence_verif = Rs.getString("numero");
                    txt_nom.setText(Rs.getString("nom"));
                    txt_inter1.setText(Rs.getString("inter1"));
                    txt_inter2.setText(Rs.getString("inter2"));
                    txt_inter3.setText(Rs.getString("inter3"));
                    txt_inter4.setText(Rs.getString("inter4"));
                    txt_inter5.setText(Rs.getString("inter5"));
                    txt_inter6.setText(Rs.getString("inter6"));
                    txt_inter7.setText(Rs.getString("inter7"));
                    txt_inter8.setText(Rs.getString("inter8"));
                    txt_inter9.setText(Rs.getString("inter9"));
                    txt_inter10.setText(Rs.getString("inter10"));
                    txt_inter11.setText(Rs.getString("inter11"));
                    txt_niv_inter1.setText(Rs.getString("niveau_inter1"));
                    txt_niv_inter2.setText(Rs.getString("niveau_inter2"));
                    txt_niv_inter3.setText(Rs.getString("niveau_inter3"));
                    txt_niv_inter4.setText(Rs.getString("niveau_inter4"));
                    txt_niv_inter5.setText(Rs.getString("niveau_inter5"));
                    txt_niv_inter6.setText(Rs.getString("niveau_inter6"));
                    txt_niv_inter7.setText(Rs.getString("niveau_inter7"));
                    txt_niv_inter8.setText(Rs.getString("niveau_inter8"));
                    txt_niv_inter9.setText(Rs.getString("niveau_inter9"));
                    txt_niv_inter10.setText(Rs.getString("niveau_inter10"));
                    txt_niv_inter11.setText(Rs.getString("niveau_inter11"));
                    txt_tel_inter1.setText(Rs.getString("tel_inter1"));
                    txt_tel_inter2.setText(Rs.getString("tel_inter2"));
                    txt_tel_inter3.setText(Rs.getString("tel_inter3"));
                    txt_tel_inter4.setText(Rs.getString("tel_inter4"));
                    txt_tel_inter5.setText(Rs.getString("tel_inter5"));
                    txt_tel_inter6.setText(Rs.getString("tel_inter6"));
                    txt_tel_inter7.setText(Rs.getString("tel_inter7"));
                    txt_tel_inter8.setText(Rs.getString("tel_inter8"));
                    txt_tel_inter9.setText(Rs.getString("tel_inter9"));
                    txt_tel_inter10.setText(Rs.getString("tel_inter10"));
                    txt_tel_inter11.setText(Rs.getString("tel_inter11"));
                    txt_version_logi.setText(Rs.getString("version_logi"));
                    
                    if ("0001-01-01".equals(Rs.getString("date_version"))){
                        txt_date_version.setText("");
                    }
                    else
                    {
                        String date_date_version = Date_Anglais_Francais(Rs.getString("date_version"));
                        txt_date_version.setText(date_date_version);
                    }
                    
                    txt_version_remon.setText(Rs.getString("version_remon"));
                    
                    if ("0001-01-01".equals(Rs.getString("date_recup"))){
                        txt_date_recup.setText("");
                    }
                    else{
                        String date_date_recup = Date_Anglais_Francais(Rs.getString("date_recup"));
                        txt_date_recup.setText(date_date_recup);
                    }
                    
                    txt_IP_1.setText(Rs.getString("IP_1"));
                    txt_IP_2.setText(Rs.getString("IP_2"));
                    txt_info.setText(Rs.getString("info"));
                    if (Rs.getInt("actif") == 0){
                        txt_actif.setSelectedItem("Inactif");
                    }
                    else if(Rs.getInt("actif") == 1){
                        txt_actif.setSelectedItem("Actif");
                    }
                    txt_tel_ag.setText(Rs.getString("tel_ag"));
                    txt_fax_ag.setText(Rs.getString("fax_ag"));
                    txt_mail_ag.setText(Rs.getString("mail_ag"));
                    txt_maintenance.setText(Rs.getString("maintenance"));
                    txt_mail_inter1.setText(Rs.getString("mail_1"));
                    txt_mail_inter2.setText(Rs.getString("mail_2"));
                    txt_mail_inter3.setText(Rs.getString("mail_3"));
                    txt_mail_inter4.setText(Rs.getString("mail_4"));
                    txt_mail_inter5.setText(Rs.getString("mail_5"));
                    txt_mail_inter6.setText(Rs.getString("mail_6"));
                    txt_mail_inter7.setText(Rs.getString("mail_7"));
                    txt_mail_inter8.setText(Rs.getString("mail_8"));
                    txt_mail_inter9.setText(Rs.getString("mail_9"));
                    txt_mail_inter10.setText(Rs.getString("mail_10"));
                    txt_mail_inter11.setText(Rs.getString("mail_11"));
                    
                    if ("0001-01-01".equals(Rs.getString("instal"))){
                        txt_instal.setText("");
                    }
                    else{
                        String date_instal = Date_Anglais_Francais(Rs.getString("instal"));
                        txt_instal.setText(date_instal);
                    }
                    
                    txt_instal_pers.setText(Rs.getString("instal_pers"));
                    
                    if ("0001-01-01".equals(Rs.getString("fin_maint"))){
                        txt_fin_maint.setText("");
                    }
                    else{
                        String date_fin_maint = Date_Anglais_Francais(Rs.getString("fin_maint"));
                        txt_fin_maint.setText(date_fin_maint);
                    }
                    
                    txt_adr1.setText(Rs.getString("adr1"));
                    txt_adr2.setText(Rs.getString("adr2"));
                    txt_adr3.setText(Rs.getString("adr3"));
                    txt_adr4.setText(Rs.getString("adr4"));
                    txt_cp.setText(Rs.getString("cp"));
                    txt_ville.setText(Rs.getString("ville"));
                    txt_pays.setText(Rs.getString("pays"));
                    txt_info_ag.setText(Rs.getString("info_ag"));
                    txt_user_version.setText(Rs.getString("user_version"));
                    txt_user_recup.setText(Rs.getString("user_recup"));
                    
                    if ("0001-01-01".equals(Rs.getString("date_version_install"))){
                        txt_date_version_install.setText("");
                    }
                    else{
                        String date_date_version_install = Date_Anglais_Francais(Rs.getString("date_version_install"));
                        txt_date_version_install.setText(date_date_version_install);
                    }
                    
                    if ("0001-01-01".equals(Rs.getString("date_recup_install"))){
                        txt_date_recup_install.setText("");
                    }
                    else{
                        String date_date_recup_install = Date_Anglais_Francais(Rs.getString("date_recup_install"));
                        txt_date_recup_install.setText(date_date_recup_install);
                    }
                    
                    txt_code_int_ag.setText(Rs.getString("code_int_ag"));
                    txt_nb_licence.setText(Rs.getString("nb_licence"));
                    txt_version_remon2.setText(Rs.getString("version_remon2"));
                    
                    txt_version_migration.setText(Rs.getString("version_migration"));
                    
                    if ("0001-01-01".equals(Rs.getString("date_migration"))){
                        txt_date_migration.setText("");
                    }
                    else{
                        String date_date_migration = Date_Anglais_Francais(Rs.getString("date_migration"));
                        txt_date_migration.setText(date_date_migration);
                    }
                    
                    if ("0001-01-01".equals(Rs.getString("date_recup2"))){
                        txt_date_recup2.setText("");
                    }
                    else{
                        String date_date_recup2 = Date_Anglais_Francais(Rs.getString("date_recup2"));
                        txt_date_recup2.setText(date_date_recup2);
                    }
                    
                    if ("0001-01-01".equals(Rs.getString("date_recup2_install"))){
                        txt_date_recup2_install.setText("");
                    }
                    else{
                        String date_date_recup2_install = Date_Anglais_Francais(Rs.getString("date_recup2_install"));
                        txt_date_recup2_install.setText(date_date_recup2_install);
                    }
                    
                    txt_user_recup2.setText(Rs.getString("user_recup2"));
                    
                    if (Rs.getInt("statut_maintenance") == 0){
                        txt_statut_maintenance.setSelectedItem("Interdite");
                    }
                    else if(Rs.getInt("statut_maintenance") == 1){
                        txt_statut_maintenance.setSelectedItem("Possible");
                    }
                    else if(Rs.getInt("statut_maintenance") == 2){
                        txt_statut_maintenance.setSelectedItem("Retard de paiement");
                    }
                    else if(Rs.getInt("statut_maintenance") == 3){
                        txt_statut_maintenance.setSelectedItem("Autre");
                    }
                    
                    
                    if (Rs.getInt("type_recup") == 0){
                        txt_type_recup.setSelectedItem("Aucune");
                    }
                    else if(Rs.getInt("type_recup") == 1){
                        txt_type_recup.setSelectedItem("Amadeus");
                    }
                    else if(Rs.getInt("type_recup") == 2){
                        txt_type_recup.setSelectedItem("Galileo");
                    }
                    else if(Rs.getInt("type_recup") == 3){
                        txt_type_recup.setSelectedItem("Sabre");
                    }
                    
                    if (Rs.getInt("type_recup2") == 0){
                        txt_type_recup2.setSelectedItem("Aucune");
                    }
                    else if(Rs.getInt("type_recup2") == 1){
                        txt_type_recup2.setSelectedItem("Amadeus");
                    }
                    else if(Rs.getInt("type_recup2") == 2){
                        txt_type_recup2.setSelectedItem("Galileo");
                    }
                    else if(Rs.getInt("type_recup2") == 3){
                        txt_type_recup2.setSelectedItem("Sabre");
                    }
                    jTabbedPane1.setVisible(true);
                    txt_nom.requestFocus();
                } 
                else {
                    JOptionPane.showMessageDialog(null, "Cette agence n'existe pas.");
                    txt_numero_agence.setText("");
                    txt_numero_agence.requestFocus();
                }
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    private void button_chercher_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_chercher_agenceActionPerformed
        // TODO add your handling code here:
        Chercher_agence();   
    }//GEN-LAST:event_button_chercher_agenceActionPerformed
    
    public void ModifierAgence(){
        if ("".equals(txt_numero_agence.getText())){
            JOptionPane.showMessageDialog(null, "Inscrivez d'abord un numéro d'agence.");
            txt_numero_agence.requestFocus();
        }else{
            if ("".equals(txt_nom.getText())){
                JOptionPane.showMessageDialog(null, "Le champ nom est obligatoire.");
                txt_nom.requestFocus();
            }
            else{
                int option = JOptionPane.showConfirmDialog(null, "Confirmer la modification de l'agence.");
                if(option == JOptionPane.OK_OPTION){
                    try{
                        int actif = 0 ;
                        if (txt_actif.getSelectedItem() == "Inactif"){
                            actif = 0;
                        }
                        else if (txt_actif.getSelectedItem() == "Actif"){
                            actif = 1;
                        }

                        int statut_maintenance = 0;
                        if (txt_statut_maintenance.getSelectedItem() == "Interdite"){
                            statut_maintenance = 0;
                        }
                        else if (txt_statut_maintenance.getSelectedItem() == "Possible"){
                            statut_maintenance = 1;
                        }
                        else if (txt_statut_maintenance.getSelectedItem() == "Retard de paiement"){
                            statut_maintenance = 2;
                        }
                        else if (txt_statut_maintenance.getSelectedItem() == "Autre"){
                            statut_maintenance = 3;
                        }
                        
                        int type_recup = 0;
                        if (txt_type_recup.getSelectedItem() == "Aucune"){
                            type_recup = 0;
                        }
                        else if (txt_type_recup.getSelectedItem() == "Amadeus"){
                            type_recup = 1;
                        }
                        else if (txt_type_recup.getSelectedItem() == "Galileo"){
                            type_recup = 2;
                        }
                        else if (txt_type_recup.getSelectedItem() == "Sabre"){
                            type_recup = 3;
                        }
                        
                        int type_recup2 = 0;
                        if (txt_type_recup2.getSelectedItem() == "Aucune"){
                            type_recup2 = 0;
                        }
                        else if (txt_type_recup2.getSelectedItem() == "Amadeus"){
                            type_recup2 = 1;
                        }
                        else if (txt_type_recup2.getSelectedItem() == "Galileo"){
                            type_recup2 = 2;
                        }
                        else if (txt_type_recup2.getSelectedItem() == "Sabre"){
                            type_recup2 = 3;
                        }

                        String date_version = txt_date_version.getText();
                        if ("  -  -  ".equals(date_version)){
                            date_version = "0001-01-01";
                        }
                        else{
                            date_version = Date_Francais_Anglais(date_version);
                        }

                        String date_version_install = txt_date_version_install.getText();
                        if ("  -  -  ".equals(date_version_install)){
                            date_version_install = "0001-01-01";
                        }
                        else{
                            date_version_install = Date_Francais_Anglais(date_version_install);
                        }

                        String date_recup = txt_date_recup.getText();
                        if ("  -  -  ".equals(date_recup)){
                            date_recup = "0001-01-01";
                        }
                        else{
                            date_recup = Date_Francais_Anglais(date_recup);
                        }

                        String date_recup_install = txt_date_recup_install.getText();
                        if ("  -  -  ".equals(date_recup_install)){
                            date_recup_install = "0001-01-01";
                        }
                        else{
                            date_recup_install = Date_Francais_Anglais(date_recup_install);
                        }

                        String instal = txt_instal.getText();
                        if ("  -  -  ".equals(instal)){
                            instal = "0001-01-01";
                        }
                        else{
                            instal = Date_Francais_Anglais(instal);
                        }

                        String date_migration = txt_date_migration.getText();
                        if ("  -  -  ".equals(date_migration)){
                            date_migration = "0001-01-01";
                        }
                        else{
                            date_migration = Date_Francais_Anglais(date_migration);
                        }

                        String fin_maint = txt_fin_maint.getText();
                        if ("  -  -  ".equals(fin_maint)){
                            fin_maint = "0001-01-01";
                        }
                        else{
                            fin_maint = Date_Francais_Anglais(fin_maint);
                        }
                        
                        String date_recup2 = txt_date_recup2.getText();
                        if ("  -  -  ".equals(date_recup2)){
                            date_recup2 = "0001-01-01";
                        }
                        else{
                            date_recup2 = Date_Francais_Anglais(date_recup2);
                        }
                        
                        String date_recup2_install = txt_date_recup2_install.getText();
                        if ("  -  -  ".equals(date_recup2_install)){
                            date_recup2_install = "0001-01-01";
                        }
                        else{
                            date_recup2_install = Date_Francais_Anglais(date_recup2_install);
                        }

                        

                        conn = javaconnect.ConnectDb();
                        String sql_modifier_agence = ("UPDATE agence SET nom = '" + txt_nom.getText().replace("'", "''")
                            + "',inter1 = '" + txt_inter1.getText().replace("'", "''") + "',inter2 = '" + txt_inter2.getText().replace("'", "''") + "',inter3 = '" + txt_inter3.getText().replace("'", "''") + "',inter4 = '" + txt_inter4.getText().replace("'", "''")
                            + "',inter5 = '" + txt_inter5.getText().replace("'", "''") + "',inter6 = '" + txt_inter6.getText().replace("'", "''") + "',inter7 = '" + txt_inter7.getText().replace("'", "''") + "',inter8 = '" + txt_inter8.getText().replace("'", "''")
                            + "',inter9 = '" + txt_inter9.getText().replace("'", "''") + "',inter10 = '" + txt_inter10.getText().replace("'", "''") + "',inter11 = '" + txt_inter11.getText().replace("'", "''") + "',niveau_inter1 = '" + txt_niv_inter1.getText().replace("'", "''")
                            + "',niveau_inter2 = '" + txt_niv_inter2.getText().replace("'", "''") + "',niveau_inter3 = '" + txt_niv_inter3.getText().replace("'", "''") + "',niveau_inter4 = '" + txt_niv_inter4.getText().replace("'", "''") + "',niveau_inter5 = '" + txt_niv_inter5.getText().replace("'", "''")
                            + "',niveau_inter6 = '" + txt_niv_inter6.getText().replace("'", "''") + "',niveau_inter7 = '" + txt_niv_inter7.getText().replace("'", "''") + "',niveau_inter8 = '" + txt_niv_inter8.getText().replace("'", "''") + "',niveau_inter9 = '" + txt_niv_inter9.getText().replace("'", "''")
                            + "',niveau_inter10 = '" + txt_niv_inter10.getText().replace("'", "''") + "',niveau_inter11 = '" + txt_niv_inter11.getText().replace("'", "''")
                            + "',tel_inter1 = '" + txt_tel_inter1.getText().replace("'", "''") + "',tel_inter2 = '" + txt_tel_inter2.getText().replace("'", "''") + "',tel_inter3 = '" + txt_tel_inter3.getText().replace("'", "''") + "',tel_inter4 = '" + txt_tel_inter4.getText().replace("'", "''")
                            + "',tel_inter5 = '" + txt_tel_inter5.getText().replace("'", "''") + "',tel_inter6 = '" + txt_tel_inter6.getText().replace("'", "''") + "',tel_inter7 = '" + txt_tel_inter7.getText().replace("'", "''") + "',tel_inter8 = '" + txt_tel_inter8.getText().replace("'", "''")
                            + "',tel_inter9 = '" + txt_tel_inter9.getText().replace("'", "''") + "',tel_inter10 = '" + txt_tel_inter10.getText().replace("'", "''") + "',tel_inter11 = '" + txt_tel_inter11.getText().replace("'", "''")
                            + "',version_logi = '" + txt_version_logi.getText().replace("'", "''") + "',date_version = '" + date_version + "',version_remon = '" + txt_version_remon.getText().replace("'", "''")
                            + "',date_recup = '" + date_recup + "',IP_1 = '" + txt_IP_1.getText().replace("'", "''") + "',IP_2 = '" + txt_IP_2.getText().replace("'", "''") + "',info = '" + txt_info.getText().replace("'", "''")
                            + "',actif = '" + actif + "',tel_ag = '" + txt_tel_ag.getText().replace("'", "''") + "',fax_ag = '" + txt_fax_ag.getText().replace("'", "''") + "',mail_ag = '" + txt_mail_ag.getText().replace("'", "''")
                            + "',maintenance = '" + txt_maintenance.getText().replace("'", "''")
                            + "',mail_1 = '" + txt_mail_inter1.getText().replace("'", "''") + "',mail_2 = '" + txt_mail_inter2.getText().replace("'", "''") + "',mail_3 = '" + txt_mail_inter3.getText().replace("'", "''")
                            + "',mail_4 = '" + txt_mail_inter4.getText().replace("'", "''") + "',mail_5 = '" + txt_mail_inter5.getText().replace("'", "''") + "',mail_6 = '" + txt_mail_inter6.getText().replace("'", "''")
                            + "',mail_7 = '" + txt_mail_inter7.getText().replace("'", "''") + "',mail_8 = '" + txt_mail_inter8.getText().replace("'", "''") + "',mail_9 = '" + txt_mail_inter9.getText().replace("'", "''")
                            + "',mail_10 = '" + txt_mail_inter10.getText().replace("'", "''") + "',mail_11 = '" + txt_mail_inter11.getText().replace("'", "''")
                            + "',instal = '" + instal + "',instal_pers = '" + txt_instal_pers.getText().replace("'", "''") + "',fin_maint = '" + fin_maint
                            + "',adr1 = '" + txt_adr1.getText().replace("'", "''") + "',adr2 = '" + txt_adr2.getText().replace("'", "''") + "',adr3 = '" + txt_adr3.getText().replace("'", "''") + "',adr4 = '" + txt_adr4.getText().replace("'", "''")
                            + "',cp = '" + txt_cp.getText().replace("'", "''") + "',ville = '" + txt_ville.getText().replace("'", "''") + "',pays = '" + txt_pays.getText().replace("'", "''") + "',info_ag = '" + txt_info_ag.getText().replace("'", "''")
                            + "',user_version = '" + txt_user_version.getText().replace("'", "''") + "',user_recup = '" + txt_user_recup.getText().replace("'", "''")
                            + "',date_version_install = '" + date_version_install + "',date_recup_install = '" + date_recup_install
                            + "',code_int_ag = '" + txt_code_int_ag.getText().replace("'", "''") + "',nb_licence = '" + txt_nb_licence.getText().replace("'", "''")
                            + "',version_migration = '" + txt_version_migration.getText().replace("'", "''") + "',date_migration = '" + date_migration
                            + "',statut_maintenance = '" + statut_maintenance + "',type_recup = '" + type_recup
                            + "',type_recup2 = '" + type_recup2 + "',version_remon2 = '" + txt_version_remon2.getText().replace("'", "''")
                            + "',date_recup2 = '" + date_recup2 + "',date_recup2_install = '" + date_recup2_install
                            + "',user_recup2 = '" + txt_user_recup2.getText().replace("'", "''") + "' WHERE numero = '" + txt_numero_agence_verif + "';");
                        pst = conn.prepareStatement(sql_modifier_agence);
                        pst.executeUpdate();
                        
                        txt_numero_agence.setEnabled(true);
                        button_chercher_agence.setEnabled(true);
                        button_aide_agence.setEnabled(true);
                        clearTextFields(this.getContentPane());
                        clearTextArea(this.getContentPane());
                        clearComboBox();
                        txt_numero_agence.requestFocus();
                        
                        JOptionPane.showMessageDialog(null, "Agence modifié avec succès.");   
                        jTabbedPane1.setVisible(false);
                    }
                    catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e);
                    }   
                }
            }    
        }
    }
    
    private void button_modifier_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modifier_agenceActionPerformed
        // TODO add your handling code here:
        ModifierAgence();       
    }//GEN-LAST:event_button_modifier_agenceActionPerformed

    private void txt_numero_agenceKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numero_agenceKeyTyped
        // TODO add your handling code here:
        char c = evt.getKeyChar();
        if(!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)){
            evt.consume();
        }   
    }//GEN-LAST:event_txt_numero_agenceKeyTyped

    private void button_chercher_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_chercher_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Chercher_agence();
        }
        if (c == KeyEvent.VK_F2){
            Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
            fenetre_agence_aide.setLocationRelativeTo(null);
            fenetre_agence_aide.setVisible(true);
        }
        if (c == KeyEvent.VK_F8){
            supprimerAgence();
        }
    }//GEN-LAST:event_button_chercher_agenceKeyPressed

    private void txt_numero_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_numero_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Chercher_agence();  
        }
        if (c == KeyEvent.VK_F2){
            Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
            fenetre_agence_aide.setLocationRelativeTo(null);
            fenetre_agence_aide.setVisible(true);
        }
        if (c == KeyEvent.VK_F4){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.OK_OPTION){
            Principal_jframe.choix_option_agence = 0;
            Principal_jframe.button_agence_afficher.setEnabled(true);
            Principal_jframe.button_agence_ajouter.setEnabled(true);
            Principal_jframe.button_agence_mod_supp.setEnabled(true);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
            Principal_jframe.button_mon_compte.setEnabled(true);

            Principal_jframe.button_sav_afficher.setEnabled(true);
            Principal_jframe.button_sav_ajouter.setEnabled(true);
            Principal_jframe.button_sav_mod_supp.setEnabled(true);
            
            this.dispose();
            }
        }
        if (c == KeyEvent.VK_F8){
            supprimerAgence();
        }
    }//GEN-LAST:event_txt_numero_agenceKeyPressed

    private void button_aide_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_aide_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Chercher_agence();
        }
        if (c == KeyEvent.VK_F2){
            Agence_Aide_jframe fenetre_agence_aide = new Agence_Aide_jframe();
            fenetre_agence_aide.setLocationRelativeTo(null);
            fenetre_agence_aide.setVisible(true);
        }
        if (c == KeyEvent.VK_F8){
            supprimerAgence();
        }
    }//GEN-LAST:event_button_aide_agenceKeyPressed

    private void txt_nomFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_nomFocusGained
        // TODO add your handling code here:
        txt_numero_agence.setEnabled(false);
        button_chercher_agence.setEnabled(false);
        button_aide_agence.setEnabled(false);
    }//GEN-LAST:event_txt_nomFocusGained
    
    public void clearTextFields (Container container){
        for(Component c : container.getComponents()){
            if(c instanceof JTextField){
                JTextField f = (JTextField) c;
                f.setText("");
            } 
            else if (c instanceof Container){
                clearTextFields((Container)c);
            }        
        }
    }
    public void clearTextArea (Container container){
        for(Component c : container.getComponents()){
            if(c instanceof JTextArea){
                JTextArea a = (JTextArea) c;
                a.setText("");
            } 
            else if (c instanceof Container){
                clearTextArea((Container)c);   
            }
        }
    }
    public void clearComboBox(){
        txt_actif.setSelectedItem("Inactif");
        txt_statut_maintenance.setSelectedItem("Interdite");
        txt_type_recup.setSelectedItem("Aucune");
    }
    
    private void txt_nomKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nomKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_nom.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            if (Principal_jframe.choix_option_agence == 1){
                int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
                if(option == JOptionPane.OK_OPTION){
                    Principal_jframe.choix_option_agence = 0;
                    Principal_jframe.button_agence_afficher.setEnabled(true);
                    Principal_jframe.button_agence_ajouter.setEnabled(true);
                    Principal_jframe.button_agence_mod_supp.setEnabled(true);
                    
                    Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
                    Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
                    Principal_jframe.button_mon_compte.setEnabled(true);

                    Principal_jframe.button_sav_afficher.setEnabled(true);
                    Principal_jframe.button_sav_ajouter.setEnabled(true);
                    Principal_jframe.button_sav_mod_supp.setEnabled(true);
                    
                    this.dispose();
                }
            }
            if (Principal_jframe.choix_option_agence == 2){
                txt_numero_agence.setEnabled(true);
                button_chercher_agence.setEnabled(true);
                button_aide_agence.setEnabled(true);
                clearTextFields(this.getContentPane());
                clearTextArea(this.getContentPane());
                clearComboBox();
                txt_numero_agence.requestFocus();
                jTabbedPane1.setVisible(false);
            }
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_nomKeyPressed

    private void button_supprimer_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_supprimer_agenceActionPerformed
        // TODO add your handling code here:
        supprimerAgence();
    }//GEN-LAST:event_button_supprimer_agenceActionPerformed

    private void button_quitter_agenceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_quitter_agenceActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            Sav_ajout_mod_supp_aff.option_aide = 0;
            Principal_jframe.choix_option_agence = 0;
            Principal_jframe.button_agence_afficher.setEnabled(true);
            Principal_jframe.button_agence_ajouter.setEnabled(true);
            Principal_jframe.button_agence_mod_supp.setEnabled(true);
            
            Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
            Principal_jframe.button_mon_compte.setEnabled(true);

            Principal_jframe.button_sav_afficher.setEnabled(true);
            Principal_jframe.button_sav_ajouter.setEnabled(true);
            Principal_jframe.button_sav_mod_supp.setEnabled(true);
            
            this.dispose();
        }
    }//GEN-LAST:event_button_quitter_agenceActionPerformed

    private void button_quitter_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_quitter_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.OK_OPTION){
                Principal_jframe.choix_option_agence = 0;
                Principal_jframe.button_agence_afficher.setEnabled(true);
                Principal_jframe.button_agence_ajouter.setEnabled(true);
                Principal_jframe.button_agence_mod_supp.setEnabled(true);
                
                Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
                Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
                Principal_jframe.button_mon_compte.setEnabled(true);

                Principal_jframe.button_sav_afficher.setEnabled(true);
                Principal_jframe.button_sav_ajouter.setEnabled(true);
                Principal_jframe.button_sav_mod_supp.setEnabled(true);
                
                this.dispose();
            }
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
        
    }//GEN-LAST:event_button_quitter_agenceKeyPressed

    private void txt_adr1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adr1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_adr1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_adr1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_adr1KeyPressed

    private void txt_adr2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adr2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_adr2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_adr2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_adr2KeyPressed

    private void txt_adr3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adr3KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_adr3.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_adr3.transferFocusBackward();
        }
    }//GEN-LAST:event_txt_adr3KeyPressed

    private void txt_adr4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_adr4KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_adr4.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_adr4.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_adr4KeyPressed

    private void txt_cpKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cpKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_cp.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_cp.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_cpKeyPressed

    private void txt_villeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_villeKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_ville.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_ville.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_villeKeyPressed

    private void txt_paysKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_paysKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_pays.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_pays.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_paysKeyPressed

    private void txt_tel_agKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_agKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_ag.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_ag.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_agKeyPressed

    private void txt_fax_agKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fax_agKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_fax_ag.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_fax_ag.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_fax_agKeyPressed

    private void txt_mail_agKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_agKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_ag.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_ag.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_agKeyPressed
    private boolean bug_entrer_txt_instal = false;
    private void txt_instalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_instalKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_instal = true;
            if (isValidDate(txt_instal.getText()) == false){
                if (!"  -  -  ".equals(txt_instal.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_instal.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_instal.transferFocus();
                }
            }
            else{
                txt_instal.transferFocus();
            }  
        }
        if (c == KeyEvent.VK_F4){
            txt_instal.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_instalKeyPressed

    private void txt_instal_persKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_instal_persKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_instal_pers.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_instal_pers.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_instal_persKeyPressed

    private void txt_actifKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_actifKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_actif.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_actif.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_actifKeyPressed

    private void txt_nb_licenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nb_licenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_nb_licence.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_nb_licence.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_nb_licenceKeyPressed

    private void txt_version_logiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_version_logiKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_version_logi.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_version_logi.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_version_logiKeyPressed
    private boolean bug_entrer_txt_date_version = false;
    private void txt_date_versionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_versionKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_version.transferFocus();
            bug_entrer_txt_date_version = true;
            if (isValidDate(txt_date_version.getText()) == false){
                if (!"  -  -  ".equals(txt_date_version.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_version.setText("");
                }
                else{
                    txt_date_version.transferFocus();
                }
            }
            else{
                txt_date_version.transferFocus();
            }  
            
            
        }
        if (c == KeyEvent.VK_F4){
            txt_date_version.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_versionKeyPressed
    private boolean bug_entrer_txt_date_version_install = false;
    private void txt_date_version_installKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_version_installKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_version_install.transferFocus();
            bug_entrer_txt_date_version_install = true;
            if (isValidDate(txt_date_version_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_version_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_version_install.setText("");
                    
                }
                else{
                    txt_date_version_install.transferFocus();
                }
            }
            else{
                txt_date_version_install.transferFocus();
            } 
            
        }
        if (c == KeyEvent.VK_F4){
            txt_date_version_install.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_version_installKeyPressed

    private void txt_user_versionKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_versionKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_user_version.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_user_version.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_user_versionKeyPressed

    private void txt_type_recupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_type_recupKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_type_recup.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_type_recup.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_type_recupKeyPressed

    private void txt_version_remonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_version_remonKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_version_remon.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_version_remon.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_version_remonKeyPressed
    private boolean bug_entrer_txt_date_recup = false;
    private void txt_date_recupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_recupKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_recup.transferFocus();
            bug_entrer_txt_date_recup = true;
            if (isValidDate(txt_date_recup.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup.setText("");
                    
                }
                else{
                    txt_date_recup.transferFocus();
                }
            }
            else{
                txt_date_recup.transferFocus();
            } 
            
        }
        if (c == KeyEvent.VK_F4){
            txt_date_recup.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_recupKeyPressed
    private boolean bug_entrer_txt_date_recup_install = false;
    private void txt_date_recup_installKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_recup_installKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_recup_install.transferFocus();
            bug_entrer_txt_date_recup_install = true;
            if (isValidDate(txt_date_recup_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup_install.setText("");
                    
                }
                else{
                    txt_date_recup_install.transferFocus();
                }
            }
            else{
                txt_date_recup_install.transferFocus();
            }
            
        }
        if (c == KeyEvent.VK_F4){
            txt_date_recup_install.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_recup_installKeyPressed

    private void txt_user_recupKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_recupKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_user_recup.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_user_recup.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_user_recupKeyPressed

    private void txt_type_recup2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_type_recup2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_type_recup2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_type_recup2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_type_recup2KeyPressed

    private void txt_version_remon2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_version_remon2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_version_remon2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_version_remon2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_version_remon2KeyPressed
    private boolean bug_entrer_txt_date_recup2 = false;
    private void txt_date_recup2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_recup2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_recup2.transferFocus();
            bug_entrer_txt_date_recup2 = true;
            if (isValidDate(txt_date_recup2.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup2.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup2.setText("");
                    
                }
                else{
                    txt_date_recup2.transferFocus();
                }
            }
            else{
                txt_date_recup2.transferFocus();
            }
            
            
        }
        if (c == KeyEvent.VK_F4){
            txt_date_recup2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_recup2KeyPressed
    private boolean bug_entrer_txt_date_recup2_install = false;
    private void txt_date_recup2_installKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_recup2_installKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_recup2_install.transferFocus();
            bug_entrer_txt_date_recup2_install = true;
            if (isValidDate(txt_date_recup2_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup2_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup2_install.setText("");
                    
                }
                else{
                    txt_date_recup2_install.transferFocus();
                }
            }
            else{
                txt_date_recup2_install.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_date_recup2_install.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_recup2_installKeyPressed

    private void txt_user_recup2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_user_recup2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_user_recup2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_user_recup2.transferFocusBackward();
        }
    }//GEN-LAST:event_txt_user_recup2KeyPressed

    private void txt_version_migrationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_version_migrationKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_version_migration.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_version_migration.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_version_migrationKeyPressed
    private boolean bug_entrer_txt_date_migration = false;
    private void txt_date_migrationKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_migrationKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_date_migration.transferFocus();
            bug_entrer_txt_date_migration = true;
            if (isValidDate(txt_date_migration.getText()) == false){
                if (!"  -  -  ".equals(txt_date_migration.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_migration.setText("");
                    
                }
                else{
                    txt_date_migration.transferFocus();
                }
            }
            else{
                txt_date_migration.transferFocus();
            }   
        }
        if (c == KeyEvent.VK_F4){
            txt_date_migration.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_date_migrationKeyPressed

    private void txt_maintenanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_maintenanceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_maintenance.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_maintenance.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_maintenanceKeyPressed

    private void txt_statut_maintenanceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_statut_maintenanceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_statut_maintenance.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_statut_maintenance.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_statut_maintenanceKeyPressed

    private void txt_IP_1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IP_1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_IP_1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_IP_1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_IP_1KeyPressed

    private void txt_IP_2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_IP_2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_IP_2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_IP_2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_IP_2KeyPressed

    private void txt_code_int_agKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_code_int_agKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_code_int_ag.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_code_int_ag.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_code_int_agKeyPressed

    private void txt_info_agKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_info_agKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_F4){
            txt_info_ag.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_info_ag.transferFocus();
        }
    }//GEN-LAST:event_txt_info_agKeyPressed

    private void txt_infoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_infoKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_F4){
            txt_info.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_info.transferFocus();
        }
    }//GEN-LAST:event_txt_infoKeyPressed

    private void txt_inter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter1KeyPressed

    private void txt_niv_inter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter1KeyPressed

    private void txt_tel_inter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter1KeyPressed

    private void txt_mail_inter1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter1KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter1.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter1.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter1KeyPressed

    private void txt_inter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter2KeyPressed

    private void txt_niv_inter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter2KeyPressed

    private void txt_tel_inter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter2KeyPressed

    private void txt_mail_inter2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter2KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter2.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter2.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter2KeyPressed

    private void txt_inter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter3KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter3.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter3.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter3KeyPressed

    private void txt_niv_inter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter3KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter3.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter3.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter3KeyPressed

    private void txt_tel_inter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter3KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter3.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter3.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter3KeyPressed

    private void txt_mail_inter3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter3KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter3.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter3.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter3KeyPressed

    private void txt_inter4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter4KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter4.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter4.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter4KeyPressed

    private void txt_niv_inter4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter4KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter4.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter4.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter4KeyPressed

    private void txt_tel_inter4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter4KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter4.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter4.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter4KeyPressed

    private void txt_mail_inter4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter4KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter4.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter4.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter4KeyPressed

    private void txt_inter5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter5KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter5.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter5.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter5KeyPressed

    private void txt_niv_inter5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter5KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter5.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter5.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter5KeyPressed

    private void txt_tel_inter5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter5KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter5.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter5.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter5KeyPressed

    private void txt_mail_inter5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter5KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter5.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter5.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter5KeyPressed

    private void txt_inter6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter6KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter6.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter6.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter6KeyPressed

    private void txt_niv_inter6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter6KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter6.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter6.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter6KeyPressed

    private void txt_tel_inter6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter6KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter6.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter6.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter6KeyPressed

    private void txt_mail_inter6KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter6KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter6.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter6.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter6KeyPressed

    private void txt_inter7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter7KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter7.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter7.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter7KeyPressed

    private void txt_niv_inter7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter7KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter7.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter7.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter7KeyPressed

    private void txt_tel_inter7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter7KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter7.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter7.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter7KeyPressed

    private void txt_mail_inter7KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter7KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter7.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter7.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter7KeyPressed

    private void txt_inter8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter8KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter8.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter8.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter8KeyPressed

    private void txt_niv_inter8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter8KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter8.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter8.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter8KeyPressed

    private void txt_tel_inter8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter8KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter8.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter8.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter8KeyPressed

    private void txt_mail_inter8KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter8KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter8.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter8.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter8KeyPressed

    private void txt_inter9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter9KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter9.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter9.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter9KeyPressed

    private void txt_niv_inter9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter9KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter9.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter9.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter9KeyPressed

    private void txt_tel_inter9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter9KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter9.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter9.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter9KeyPressed

    private void txt_mail_inter9KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter9KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter9.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter9.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter9KeyPressed

    private void txt_inter10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter10KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter10.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter10.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter10KeyPressed

    private void txt_niv_inter10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter10KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter10.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter10.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter10KeyPressed

    private void txt_tel_inter10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter10KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter10.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter10.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter10KeyPressed

    private void txt_mail_inter10KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter10KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter10.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter10.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter10KeyPressed

    private void txt_inter11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_inter11KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_inter11.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_inter11.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_inter11KeyPressed

    private void txt_niv_inter11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_niv_inter11KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_niv_inter11.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_niv_inter11.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_niv_inter11KeyPressed

    private void txt_tel_inter11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_tel_inter11KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_tel_inter11.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_tel_inter11.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_tel_inter11KeyPressed

    private void txt_mail_inter11KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_mail_inter11KeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_mail_inter11.transferFocus();
        }
        if (c == KeyEvent.VK_F4){
            txt_mail_inter11.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_mail_inter11KeyPressed

    private void button_ajouter_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_ajouter_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
           AjouterAgence();
        }
        if (c == KeyEvent.VK_F6){
            AjouterAgence();
        }
    }//GEN-LAST:event_button_ajouter_agenceKeyPressed

    private void button_modifier_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_modifier_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            ModifierAgence();
        }
        if (c == KeyEvent.VK_F7){
            ModifierAgence();
        }
        if (c == KeyEvent.VK_F8){
            supprimerAgence();
        }
    }//GEN-LAST:event_button_modifier_agenceKeyPressed

    private void button_supprimer_agenceKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_supprimer_agenceKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            supprimerAgence();
        }
        if (c == KeyEvent.VK_F7){
            ModifierAgence();
        }
        if (c == KeyEvent.VK_F8){
            supprimerAgence();
        }
    }//GEN-LAST:event_button_supprimer_agenceKeyPressed
    private boolean bug_entrer_txt_fin_maint = false;
    private void txt_fin_maintKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_fin_maintKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            //txt_fin_maint.transferFocus();
            bug_entrer_txt_fin_maint = true;
            if (isValidDate(txt_fin_maint.getText()) == false){
                if (!"  -  -  ".equals(txt_fin_maint.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_fin_maint.setText("");
                    
                }
                else{
                    txt_fin_maint.transferFocus();
                }
            }
            else{
                txt_fin_maint.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_fin_maint.transferFocusBackward();
        }
        if (Principal_jframe.choix_option_agence == 1){
            if (c == KeyEvent.VK_F6){
                AjouterAgence();
            }
        }
        if (Principal_jframe.choix_option_agence == 2){
            if (c == KeyEvent.VK_F7){
                ModifierAgence();
            }
            if (c == KeyEvent.VK_F8){
                supprimerAgence();
            }
        }
    }//GEN-LAST:event_txt_fin_maintKeyPressed

    private void txt_instalFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_instalFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_instal == false){
            if (isValidDate(txt_instal.getText()) == false){
                if (!"  -  -  ".equals(txt_instal.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_instal.setText("");
                    txt_instal.requestFocus();
                }
            }
        }
        bug_entrer_txt_instal = false;
    }//GEN-LAST:event_txt_instalFocusLost

    private void txt_date_versionFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_versionFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_version == false){
            if (isValidDate(txt_date_version.getText()) == false){
                if (!"  -  -  ".equals(txt_date_version.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_version.setText("");
                    txt_date_version.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_version = false;
    }//GEN-LAST:event_txt_date_versionFocusLost

    private void txt_date_version_installFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_version_installFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_version_install == false){
            if (isValidDate(txt_date_version_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_version_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_version_install.setText("");
                    txt_date_version_install.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_version_install = false;
    }//GEN-LAST:event_txt_date_version_installFocusLost

    private void txt_date_recupFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_recupFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_recup == false){
            if (isValidDate(txt_date_recup.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup.setText("");
                    txt_date_recup.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_recup = false;
    }//GEN-LAST:event_txt_date_recupFocusLost

    private void txt_date_recup_installFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_recup_installFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_recup_install == false){
            if (isValidDate(txt_date_recup_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup_install.setText("");
                    txt_date_recup_install.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_recup_install = false;
    }//GEN-LAST:event_txt_date_recup_installFocusLost

    private void txt_date_recup2FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_recup2FocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_recup2 == false){
            if (isValidDate(txt_date_recup2.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup2.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup2.setText("");
                    txt_date_recup2.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_recup2 = false;
    }//GEN-LAST:event_txt_date_recup2FocusLost

    private void txt_date_recup2_installFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_recup2_installFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_recup2_install == false){
            if (isValidDate(txt_date_recup2_install.getText()) == false){
                if (!"  -  -  ".equals(txt_date_recup2_install.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_recup2_install.setText("");
                    txt_date_recup2_install.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_recup2_install = false;
    }//GEN-LAST:event_txt_date_recup2_installFocusLost

    private void txt_date_migrationFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_migrationFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_migration == false){
            if (isValidDate(txt_date_migration.getText()) == false){
                if (!"  -  -  ".equals(txt_date_migration.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_migration.setText("");
                    txt_date_migration.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_migration = false;
    }//GEN-LAST:event_txt_date_migrationFocusLost

    private void txt_fin_maintFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_fin_maintFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_fin_maint == false){
            if (isValidDate(txt_fin_maint.getText()) == false){
                if (!"  -  -  ".equals(txt_fin_maint.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_fin_maint.setText("");
                    txt_fin_maint.requestFocus();
                }
            }
        }
        bug_entrer_txt_fin_maint = false;
    }//GEN-LAST:event_txt_fin_maintFocusLost

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
            java.util.logging.Logger.getLogger(Agence_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Agence_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Agence_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Agence_jframe.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Agence_jframe().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton button_aide_agence;
    private javax.swing.JButton button_ajouter_agence;
    private javax.swing.JButton button_chercher_agence;
    private javax.swing.JButton button_modifier_agence;
    private javax.swing.JButton button_quitter_agence;
    private javax.swing.JButton button_supprimer_agence;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField txt_IP_1;
    private javax.swing.JTextField txt_IP_2;
    private javax.swing.JComboBox txt_actif;
    private javax.swing.JTextField txt_adr1;
    private javax.swing.JTextField txt_adr2;
    private javax.swing.JTextField txt_adr3;
    private javax.swing.JTextField txt_adr4;
    private javax.swing.JTextField txt_code_int_ag;
    private javax.swing.JTextField txt_cp;
    private javax.swing.JFormattedTextField txt_date_migration;
    private javax.swing.JFormattedTextField txt_date_recup;
    private javax.swing.JFormattedTextField txt_date_recup2;
    private javax.swing.JFormattedTextField txt_date_recup2_install;
    private javax.swing.JFormattedTextField txt_date_recup_install;
    private javax.swing.JFormattedTextField txt_date_version;
    private javax.swing.JFormattedTextField txt_date_version_install;
    private javax.swing.JTextField txt_fax_ag;
    private javax.swing.JFormattedTextField txt_fin_maint;
    private javax.swing.JTextArea txt_info;
    private javax.swing.JTextArea txt_info_ag;
    private javax.swing.JFormattedTextField txt_instal;
    private javax.swing.JTextField txt_instal_pers;
    private javax.swing.JTextField txt_inter1;
    private javax.swing.JTextField txt_inter10;
    private javax.swing.JTextField txt_inter11;
    private javax.swing.JTextField txt_inter2;
    private javax.swing.JTextField txt_inter3;
    private javax.swing.JTextField txt_inter4;
    private javax.swing.JTextField txt_inter5;
    private javax.swing.JTextField txt_inter6;
    private javax.swing.JTextField txt_inter7;
    private javax.swing.JTextField txt_inter8;
    private javax.swing.JTextField txt_inter9;
    private javax.swing.JTextField txt_mail_ag;
    private javax.swing.JTextField txt_mail_inter1;
    private javax.swing.JTextField txt_mail_inter10;
    private javax.swing.JTextField txt_mail_inter11;
    private javax.swing.JTextField txt_mail_inter2;
    private javax.swing.JTextField txt_mail_inter3;
    private javax.swing.JTextField txt_mail_inter4;
    private javax.swing.JTextField txt_mail_inter5;
    private javax.swing.JTextField txt_mail_inter6;
    private javax.swing.JTextField txt_mail_inter7;
    private javax.swing.JTextField txt_mail_inter8;
    private javax.swing.JTextField txt_mail_inter9;
    private javax.swing.JTextField txt_maintenance;
    private javax.swing.JTextField txt_nb_licence;
    private javax.swing.JTextField txt_niv_inter1;
    private javax.swing.JTextField txt_niv_inter10;
    private javax.swing.JTextField txt_niv_inter11;
    private javax.swing.JTextField txt_niv_inter2;
    private javax.swing.JTextField txt_niv_inter3;
    private javax.swing.JTextField txt_niv_inter4;
    private javax.swing.JTextField txt_niv_inter5;
    private javax.swing.JTextField txt_niv_inter6;
    private javax.swing.JTextField txt_niv_inter7;
    private javax.swing.JTextField txt_niv_inter8;
    private javax.swing.JTextField txt_niv_inter9;
    private javax.swing.JTextField txt_nom;
    private static javax.swing.JTextField txt_numero_agence;
    private javax.swing.JTextField txt_pays;
    private javax.swing.JComboBox txt_statut_maintenance;
    private javax.swing.JTextField txt_tel_ag;
    private javax.swing.JTextField txt_tel_inter1;
    private javax.swing.JTextField txt_tel_inter10;
    private javax.swing.JTextField txt_tel_inter11;
    private javax.swing.JTextField txt_tel_inter2;
    private javax.swing.JTextField txt_tel_inter3;
    private javax.swing.JTextField txt_tel_inter4;
    private javax.swing.JTextField txt_tel_inter5;
    private javax.swing.JTextField txt_tel_inter6;
    private javax.swing.JTextField txt_tel_inter7;
    private javax.swing.JTextField txt_tel_inter8;
    private javax.swing.JTextField txt_tel_inter9;
    private javax.swing.JComboBox txt_type_recup;
    private javax.swing.JComboBox txt_type_recup2;
    private javax.swing.JTextField txt_user_recup;
    private javax.swing.JTextField txt_user_recup2;
    private javax.swing.JTextField txt_user_version;
    private javax.swing.JTextField txt_version_logi;
    private javax.swing.JTextField txt_version_migration;
    private javax.swing.JTextField txt_version_remon;
    private javax.swing.JTextField txt_version_remon2;
    private javax.swing.JTextField txt_ville;
    // End of variables declaration//GEN-END:variables
}
