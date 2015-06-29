
import java.awt.AWTException;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.List;
import java.awt.PrintJob;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.text.JTextComponent;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author gwen
 */
public class Sav_ajout_mod_supp_aff extends javax.swing.JFrame {

    /**
     * Creates new form Sav_ajout
     */
    Connection conn = null;
    ResultSet Rs;
    PreparedStatement pst;
    
    static Locale locale = Locale.getDefault();
    //static Date date_actuelle = new Date();
    //static Date heure_actuelle = new Date();
    
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
    
    public static boolean isValidHeure(String inHeure) {
        SimpleDateFormat HeureFormat = new SimpleDateFormat("HH:mm");
        HeureFormat.setLenient(false);
        try {
          HeureFormat.parse(inHeure.trim());
        } catch (ParseException pe) {
            System.out.println("false");
            return false;
        }
        System.out.println("true");
        return true;
    }
    
    static DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy");
    public static String date()
	{
                Date date_actuelle = new Date();
		String la_date_actuelle = dateFormat.format(date_actuelle);
		return la_date_actuelle;
	}
    
    static DateFormat heureFormat = new SimpleDateFormat("HH:mm");
    public static String heure()
	{
		Date heure_actuelle = new Date();
                String la_heure_actuelle = heureFormat.format(heure_actuelle);
		return la_heure_actuelle;
	}
    
    public static String sav_agence_selection;
    public static String sav_numero_selection;
    public static String sav_nom_selection_pour_modif;
    
    
    
    private boolean date_depasser = false;
    
    
    
    
    public Sav_ajout_mod_supp_aff() {
        /*txt_interlocuteur.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyReleased(java.awt.event.KeyEvent evt) {
            //txt_interlocuteurKeyPressed(evt);
            }
        });*/
        
        
        
        initComponents();
                
        txt_interlocuteur.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txt_interlocuteurKeyPressed(evt);
            }
        });
        
        txt_interloc.getEditor().getEditorComponent().addKeyListener(new java.awt.event.KeyAdapter() {
        public void keyPressed(java.awt.event.KeyEvent evt) {
            txt_interlocKeyPressed(evt);
            }
        });
        
        if(Principal_jframe.sav_option == 1){
            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
            
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);
            
            
            button_ajouter_sav.setEnabled(false);
            button_modifier_sav.setEnabled(false);
            button_supprimer_sav.setEnabled(false);
            button_aide_sav.setEnabled(false);
            
            txt_date_demande.setFocusable(false);
            txt_heureSAV.setFocusable(false);
            txt_interlocuteur.setFocusable(false);
            txt_date_sav.setFocusable(false);      
            txt_hre_deb.setFocusable(false);
            txt_interloc.setFocusable(false);      
            txt_pblme.setFocusable(false);
            txt_hre_fin.setFocusable(false);
            
            try{
                conn = javaconnect.ConnectDb();
                String sql_query = ("SELECT * FROM sav WHERE numero = '"+sav_numero_selection+"';");
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                if(Rs.next()){
                    label_sav_agence_selection.setText(Rs.getString("cd_site").replace("'", "''"));
                    
                    txt_date_demande.setText(Date_Anglais_Francais(Rs.getString("date_demande")));
                    
                    txt_heureSAV.setText(Rs.getString("heureSAV"));
                    txt_typsav.setSelectedItem(Rs.getString("typsav"));
                    txt_interlocuteur.setSelectedItem(Rs.getString("interlocuteur"));
                    
                    txt_date_sav.setText(Date_Anglais_Francais(Rs.getString("date_sav")));
                    
                    txt_hre_deb.setText(Rs.getString("hre_deb"));
                    txt_interloc.setSelectedItem(Rs.getString("interloc"));
                    txt_pblme.setText(Rs.getString("pblme"));
                    
                    if(Rs.getInt("regle") == 1){
                        txt_regle_oui.setSelected(true);
                        txt_regle_non.setEnabled(false);
                    }
                    else if (Rs.getInt("regle") == 2){
                        txt_regle_non.setSelected(true);
                        txt_regle_oui.setEnabled(false);
                    }
                    
                    
                    txt_hre_fin.setText(Rs.getString("hre_fin"));
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
        }
        
        
        if(Principal_jframe.sav_option == 2){
            boolean sav_possible = false;
            try {
                conn = javaconnect.ConnectDb();
                String sql_test_sav_possible = ("SELECT nom,statut_maintenance FROM agence WHERE nom = '"+sav_agence_selection.replace("'", "''")+"';");
                pst = conn.prepareStatement(sql_test_sav_possible);
                Rs = pst.executeQuery();
                if(Rs.next()){
                    if(Rs.getInt("statut_maintenance") == 0){
                        sav_possible = false;
                    }
                    else{
                        sav_possible = true;
                    }
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            if (sav_possible == true){
                //Ici mettre code pour test de la date.
                try{
                    conn = javaconnect.ConnectDb();
                    String sql_query_test_date = ("SELECT fin_maint FROM agence WHERE nom = '"+sav_agence_selection.replace("'", "''")+"';");
                    pst = conn.prepareStatement(sql_query_test_date);
                    Rs = pst.executeQuery();
                    if (Rs.next()){
                        SimpleDateFormat date_format_test_maint = new SimpleDateFormat("dd-MM-yy");
                        
                        Date date_maint = date_format_test_maint.parse(Date_Anglais_Francais(Rs.getString("fin_maint")));
                        Date date_actu_pour_maint = date_format_test_maint.parse(date());
                        
                        if (date_maint.before(date_actu_pour_maint)){
                            date_depasser = true;
                        }
                        else if (date_maint.equals(date_actu_pour_maint)){
                            date_depasser = false;
                        }
                        else if (date_maint.after(date_actu_pour_maint)){
                            date_depasser = false;
                        }
                    } 
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                }
                Principal_jframe.button_sav_afficher.setEnabled(false);
                Principal_jframe.button_sav_ajouter.setEnabled(false);
                Principal_jframe.button_sav_mod_supp.setEnabled(false);
                
                Principal_jframe.button_agence_afficher.setEnabled(false);
                Principal_jframe.button_agence_ajouter.setEnabled(false);
                Principal_jframe.button_agence_mod_supp.setEnabled(false);

                Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
                Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
                Principal_jframe.button_mon_compte.setEnabled(false);
                

                button_modifier_sav.setEnabled(false);
                button_supprimer_sav.setEnabled(false);
                button_imprimer_sav.setEnabled(false);

                label_sav_agence_selection.setText(sav_agence_selection);
                txt_date_demande.setText(date());
                txt_heureSAV.setText(heure());

                txt_date_sav.setText(date());
                txt_hre_deb.setText(heure());


                try{
                    conn = javaconnect.ConnectDb();
                    String sql_query = ("SELECT inter1,inter2,inter3,"
                            + "inter4,inter5,inter6,inter7,inter8,inter9,"
                            + "inter10,inter11 FROM agence WHERE nom = '"+sav_agence_selection.replace("'", "''")+"';");
                    pst = conn.prepareStatement(sql_query);
                    Rs = pst.executeQuery();
                    if(Rs.next()){
                        txt_interlocuteur.addItem("");
                        txt_interloc.addItem("");
                        if(!"".equals(Rs.getString("inter1"))){
                            txt_interlocuteur.addItem(Rs.getString("inter1"));
                            txt_interloc.addItem(Rs.getString("inter1"));}
                        if(!"".equals(Rs.getString("inter2"))){
                            txt_interlocuteur.addItem(Rs.getString("inter2"));
                            txt_interloc.addItem(Rs.getString("inter2"));}
                        if(!"".equals(Rs.getString("inter3"))){
                            txt_interlocuteur.addItem(Rs.getString("inter3"));
                            txt_interloc.addItem(Rs.getString("inter3"));}
                        if(!"".equals(Rs.getString("inter4"))){
                            txt_interlocuteur.addItem(Rs.getString("inter4"));
                            txt_interloc.addItem(Rs.getString("inter4"));}
                        if(!"".equals(Rs.getString("inter5"))){
                            txt_interlocuteur.addItem(Rs.getString("inter5"));
                            txt_interloc.addItem(Rs.getString("inter5"));}
                        if(!"".equals(Rs.getString("inter6"))){
                            txt_interlocuteur.addItem(Rs.getString("inter6"));
                            txt_interloc.addItem(Rs.getString("inter6"));}
                        if(!"".equals(Rs.getString("inter7"))){
                            txt_interlocuteur.addItem(Rs.getString("inter7"));
                            txt_interloc.addItem(Rs.getString("inter7"));}
                        if(!"".equals(Rs.getString("inter8"))){
                            txt_interlocuteur.addItem(Rs.getString("inter8"));
                            txt_interloc.addItem(Rs.getString("inter8"));}
                        if(!"".equals(Rs.getString("inter9"))){
                            txt_interlocuteur.addItem(Rs.getString("inter9"));
                            txt_interloc.addItem(Rs.getString("inter9"));}
                        if(!"".equals(Rs.getString("inter10"))){
                            txt_interlocuteur.addItem(Rs.getString("inter10"));
                            txt_interloc.addItem(Rs.getString("inter10"));}
                        if(!"".equals(Rs.getString("inter11"))){
                            txt_interlocuteur.addItem(Rs.getString("inter11"));
                            txt_interloc.addItem(Rs.getString("inter11"));}
                    }
                    if (date_depasser == true){
                        JOptionPane.showMessageDialog(null, "Attention la date de maintenance est dépassée pour cette agence.");
                        date_depasser = false;
                    }
                }
                catch(Exception e){
                    JOptionPane.showMessageDialog(null, e);
                } 
                
                //txt_interlocuteur.scrollRectToVisible(null);
                
                txt_date_demande.requestFocus();
            }  
            
            else{
                JOptionPane.showMessageDialog(null, "Cette agence est interdite de sav.");
                
                Principal_jframe.button_sav_afficher.setEnabled(false);
                Principal_jframe.button_sav_ajouter.setEnabled(false);
                Principal_jframe.button_sav_mod_supp.setEnabled(false);
                
                Principal_jframe.button_agence_afficher.setEnabled(false);
                Principal_jframe.button_agence_ajouter.setEnabled(false);
                Principal_jframe.button_agence_mod_supp.setEnabled(false);

                Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
                Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
                Principal_jframe.button_mon_compte.setEnabled(false);
                
                label_sav_agence_selection.setText(sav_agence_selection);
                
                button_imprimer_sav.setEnabled(false);
                button_ajouter_sav.setEnabled(false);
                button_modifier_sav.setEnabled(false);
                button_supprimer_sav.setEnabled(false);
                txt_date_demande.setEnabled(false);
                txt_heureSAV.setEnabled(false);
                txt_interlocuteur.setEnabled(false);
                txt_date_sav.setEnabled(false);      
                txt_hre_deb.setEnabled(false);
                txt_interloc.setEnabled(false);      
                txt_pblme.setEnabled(false);
                txt_hre_fin.setEnabled(false);
                txt_regle_non.setEnabled(false);
                txt_regle_oui.setEnabled(false);
                txt_typsav.setEnabled(false);
            }
        }   
            
            
        
        if(Principal_jframe.sav_option == 3){
            Principal_jframe.button_sav_afficher.setEnabled(false);
            Principal_jframe.button_sav_ajouter.setEnabled(false);
            Principal_jframe.button_sav_mod_supp.setEnabled(false);
            
            Principal_jframe.button_agence_afficher.setEnabled(false);
            Principal_jframe.button_agence_ajouter.setEnabled(false);
            Principal_jframe.button_agence_mod_supp.setEnabled(false);

            Principal_jframe.button_utilisateur_ajouter.setEnabled(false);
            Principal_jframe.button_utilisateur_supprimer.setEnabled(false);
            Principal_jframe.button_mon_compte.setEnabled(false);
            
            button_ajouter_sav.setEnabled(false);
            button_aide_sav.setEnabled(false);
            button_imprimer_sav.setEnabled(false);
            
            
            
            try{
                conn = javaconnect.ConnectDb();
                String sql_query_combo = ("SELECT inter1,inter2,inter3,"
                        + "inter4,inter5,inter6,inter7,inter8,inter9,"
                        + "inter10,inter11 FROM agence WHERE nom = '"+sav_nom_selection_pour_modif.replace("'", "''")+"';");
                pst = conn.prepareStatement(sql_query_combo);
                Rs = pst.executeQuery();
                if(Rs.next()){
                    txt_interlocuteur.addItem("");
                    txt_interloc.addItem("");
                    if(!"".equals(Rs.getString("inter1"))){
                        txt_interlocuteur.addItem(Rs.getString("inter1"));
                        txt_interloc.addItem(Rs.getString("inter1"));}
                    if(!"".equals(Rs.getString("inter2"))){
                        txt_interlocuteur.addItem(Rs.getString("inter2"));
                        txt_interloc.addItem(Rs.getString("inter2"));}
                    if(!"".equals(Rs.getString("inter3"))){
                        txt_interlocuteur.addItem(Rs.getString("inter3"));
                        txt_interloc.addItem(Rs.getString("inter3"));}
                    if(!"".equals(Rs.getString("inter4"))){
                        txt_interlocuteur.addItem(Rs.getString("inter4"));
                        txt_interloc.addItem(Rs.getString("inter4"));}
                    if(!"".equals(Rs.getString("inter5"))){
                        txt_interlocuteur.addItem(Rs.getString("inter5"));
                        txt_interloc.addItem(Rs.getString("inter5"));}
                    if(!"".equals(Rs.getString("inter6"))){
                        txt_interlocuteur.addItem(Rs.getString("inter6"));
                        txt_interloc.addItem(Rs.getString("inter6"));}
                    if(!"".equals(Rs.getString("inter7"))){
                        txt_interlocuteur.addItem(Rs.getString("inter7"));
                        txt_interloc.addItem(Rs.getString("inter7"));}
                    if(!"".equals(Rs.getString("inter8"))){
                        txt_interlocuteur.addItem(Rs.getString("inter8"));
                        txt_interloc.addItem(Rs.getString("inter8"));}
                    if(!"".equals(Rs.getString("inter9"))){
                        txt_interlocuteur.addItem(Rs.getString("inter9"));
                        txt_interloc.addItem(Rs.getString("inter9"));}
                    if(!"".equals(Rs.getString("inter10"))){
                        txt_interlocuteur.addItem(Rs.getString("inter10"));
                        txt_interloc.addItem(Rs.getString("inter10"));}
                    if(!"".equals(Rs.getString("inter11"))){
                        txt_interlocuteur.addItem(Rs.getString("inter11"));
                        txt_interloc.addItem(Rs.getString("inter11"));}
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            } 
            
            
            
            
            try{
                conn = javaconnect.ConnectDb();
                String sql_query = ("SELECT * FROM sav WHERE numero = '"+sav_numero_selection+"';");
                pst = conn.prepareStatement(sql_query);
                Rs = pst.executeQuery();
                if(Rs.next()){
                    label_sav_agence_selection.setText(Rs.getString("cd_site").replace("'", "''"));
                    
                    txt_date_demande.setText(Date_Anglais_Francais(Rs.getString("date_demande")));
                    
                    txt_heureSAV.setText(Rs.getString("heureSAV"));
                    txt_typsav.setSelectedItem(Rs.getString("typsav"));
                    txt_interlocuteur.setSelectedItem(Rs.getString("interlocuteur"));
                    
                    txt_date_sav.setText(Date_Anglais_Francais(Rs.getString("date_sav")));
                    
                    txt_hre_deb.setText(Rs.getString("hre_deb"));
                    txt_interloc.setSelectedItem(Rs.getString("interloc"));
                    txt_pblme.setText(Rs.getString("pblme"));
                    
                    if(Rs.getInt("regle") == 1){
                        txt_regle_oui.setSelected(true);
                    }
                    else if (Rs.getInt("regle") == 2){
                        txt_regle_non.setSelected(true);
                    }
                    
                    txt_hre_fin.setText(Rs.getString("hre_fin"));
                
                }
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            
            txt_date_demande.requestFocus();
        }
        
        
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
    public String Calcul_interval_temps(String heure_debut, String heure_fin){
        String[] parts_temps_deb = heure_debut.split(":");
        String part_heure_deb = parts_temps_deb[0];
        String part_minute_deb = parts_temps_deb[1];
        
        String[] parts_temps_fin = heure_fin.split(":");
        String part_heure_fin = parts_temps_fin[0];
        String part_minute_fin = parts_temps_fin[1];
        
        double heure_deb_nombre = Double.parseDouble(part_heure_deb);
        double minute_deb_nombre = Double.parseDouble(part_minute_deb);
        
        double heure_fin_nombre = Double.parseDouble(part_heure_fin);
        double minute_fin_nombre = Double.parseDouble(part_minute_fin);
        
        double interval_en_minute = ((heure_fin_nombre*60) + minute_fin_nombre) - ((heure_deb_nombre*60) + minute_deb_nombre);
        String interval_en_minute_string = String.valueOf(interval_en_minute);
        return interval_en_minute_string;
    }
            
            
    public void Ajouter_sav(){
        if("  -  -    ".equals(txt_date_demande.getText())){
            JOptionPane.showMessageDialog(null, "Le champ \"Demande le :\" est vide.");
            txt_date_demande.requestFocus();
        }
        else{
            if("  :  ".equals(txt_heureSAV.getText())){
                JOptionPane.showMessageDialog(null, "Le champ \"A :\" est vide.");
                txt_heureSAV.requestFocus();
            }
            else{
                if(txt_interlocuteur.getSelectedItem() == ""){
                    JOptionPane.showMessageDialog(null, "Le champ \"Contact :\" est vide.");
                    txt_interlocuteur.requestFocus();
                }
                else{
                    if("  -  -    ".equals(txt_date_sav.getText())){
                        JOptionPane.showMessageDialog(null, "Le champ \"SAV commence le :\" est vide.");
                        txt_date_sav.requestFocus();
                    }
                    else{
                        if("  :  ".equals(txt_hre_deb.getText())){
                            JOptionPane.showMessageDialog(null, "Le champ \"A\" est vide.");
                            txt_hre_deb.requestFocus();
                        }
                        else{
                            if(txt_interloc.getSelectedItem() == ""){
                                JOptionPane.showMessageDialog(null, "Le champ \"Interlocuteur :\" est vide.");
                                txt_interloc.requestFocus();
                            }
                            else{
                                if(txt_pblme.getText().length() < 3){
                                    JOptionPane.showMessageDialog(null, "Le champ \"Problème\" doit comporter au moins 3 caractères.");
                                    txt_pblme.requestFocus();
                                }else{
                                    int regle = 0;
                                    if(txt_regle_oui.isSelected()){
                                        regle = 1;
                                    }
                                    else if(txt_regle_non.isSelected()){
                                        regle = 2;
                                    }
                                    if (regle == 0){
                                        JOptionPane.showMessageDialog(null, "Vous n'avez pas indiqué si le problème était réglé.");
                                        txt_regle_oui.requestFocus();
                                    }
                                    else{
                                        if("  :  ".equals(txt_hre_fin.getText())){
                                            JOptionPane.showMessageDialog(null, "Le champ \"Heure de fin :\" est vide.");
                                            txt_hre_fin.requestFocus();
                                        }
                                        else{
                                            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous ajouter ce S.A.V ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
                                            if(option == JOptionPane.OK_OPTION){
                                                String tps = Calcul_interval_temps(txt_hre_deb.getText(), txt_hre_fin.getText());
                                                try{
                                                    String sql_ajout_sav = ("INSERT INTO sav (utilis, date_sav, hre_deb, hre_fin, tps, cd_site, interloc, regle, pblme, typsav, interlocuteur, date_demande, heureSAV) VALUES('"
                                                            +Login_jframe.getUtilisateur_conn()+"','"+Date_Francais_Anglais(txt_date_sav.getText())+"','"+txt_hre_deb.getText()+"','"+txt_hre_fin.getText()
                                                            +"','"+tps+"','"+sav_agence_selection.replace("'", "''")+"','"+txt_interloc.getSelectedItem()+"','"+regle
                                                            +"','"+txt_pblme.getText().replace("'", "''")+"','"+txt_typsav.getSelectedItem()+"','"+txt_interlocuteur.getSelectedItem()
                                                            +"','"+Date_Francais_Anglais(txt_date_demande.getText())+"','"+txt_heureSAV.getText()+"');");
                                                    pst = conn.prepareStatement(sql_ajout_sav);
                                                    pst.executeUpdate();
                                                    JOptionPane.showMessageDialog(null, "SAV ajouté avec succès.");
                                                    //Principal_jframe.button_sav_afficher.setEnabled(true);
                                                    //Principal_jframe.button_sav_ajouter.setEnabled(true);
                                                    //Principal_jframe.button_sav_mod_supp.setEnabled(true);
                                                    Principal_jframe.sav_option = 2;
                                                    Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
                                                    fenetre_sav_ajout_liste.setLocationRelativeTo(null);
                                                    fenetre_sav_ajout_liste.setVisible(true);
                                                    this.dispose();
                                                }
                                                catch(Exception e){
                                                    JOptionPane.showMessageDialog(null, e);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    
    public void Supprimer_sav(){
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous supprimer ce S.A.V ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            try{
                String sql_supprimer_sav = ("DELETE FROM sav WHERE numero = '"+sav_numero_selection+"';");
                pst = conn.prepareStatement(sql_supprimer_sav);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "SAV supprimé avec succès.");
                Principal_jframe.button_sav_afficher.setEnabled(true);
                Principal_jframe.button_sav_ajouter.setEnabled(true);
                Principal_jframe.button_sav_mod_supp.setEnabled(true);
                
                Principal_jframe.button_agence_afficher.setEnabled(true);
                Principal_jframe.button_agence_ajouter.setEnabled(true);
                Principal_jframe.button_agence_mod_supp.setEnabled(true);

                Principal_jframe.button_utilisateur_ajouter.setEnabled(true);
                Principal_jframe.button_utilisateur_supprimer.setEnabled(true);
                Principal_jframe.button_mon_compte.setEnabled(true);
                
                Principal_jframe.sav_option = 3; 
                Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                fenetre_sav_mod_supp_aff_liste.setVisible(true);
                this.dispose();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    
    public void Modifier_sav(){
        if("  -  -    ".equals(txt_date_demande.getText())){
            JOptionPane.showMessageDialog(null, "Le champ \"Demande le :\" est vide.");
            txt_date_demande.requestFocus();
        }
        else{
            if("  :  ".equals(txt_heureSAV.getText())){
                JOptionPane.showMessageDialog(null, "Le champ \"A :\" est vide.");
                txt_heureSAV.requestFocus();
            }
            else{
                if(txt_interlocuteur.getSelectedItem() == ""){
                    JOptionPane.showMessageDialog(null, "Le champ \"Contact :\" est vide.");
                    txt_interlocuteur.requestFocus();
                }
                else{
                    if("  -  -    ".equals(txt_date_sav.getText())){
                        JOptionPane.showMessageDialog(null, "Le champ \"SAV commence le :\" est vide.");
                        txt_date_sav.requestFocus();
                    }
                    else{
                        if("  :  ".equals(txt_hre_deb.getText())){
                            JOptionPane.showMessageDialog(null, "Le champ \"A\" est vide.");
                            txt_hre_deb.requestFocus();
                        }
                        else{
                            if(txt_interloc.getSelectedItem() == ""){
                                JOptionPane.showMessageDialog(null, "Le champ \"Interlocuteur :\" est vide.");
                                txt_interloc.requestFocus();
                            }
                            else{
                                if(txt_pblme.getText().length() < 3){
                                    JOptionPane.showMessageDialog(null, "Le champ \"Problème\" doit comporter au moins 3 caractères.");
                                    txt_pblme.requestFocus();
                                }else{
                                    int regle = 0;
                                    if(txt_regle_oui.isSelected()){
                                        regle = 1;
                                    }
                                    else if(txt_regle_non.isSelected()){
                                        regle = 2;
                                    }
                                    if (regle == 0){
                                        JOptionPane.showMessageDialog(null, "Vous n'avez pas indiqué si le problème était réglé.");
                                        txt_regle_oui.requestFocus();
                                    }
                                    else{
                                        if("  :  ".equals(txt_hre_fin.getText())){
                                            JOptionPane.showMessageDialog(null, "Le champ \"Heure de fin :\" est vide.");
                                            txt_hre_fin.requestFocus();
                                        }
                                        else{
                                            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous modifier ce S.A.V ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
                                            if(option == JOptionPane.OK_OPTION){
                                                String tps = Calcul_interval_temps(txt_hre_deb.getText(), txt_hre_fin.getText());
                                                try{
                                                    String sql_modifier_sav = ("UPDATE sav SET utilis = '"+Login_jframe.getUtilisateur_conn()
                                                            +"', date_sav = '"+Date_Francais_Anglais(txt_date_sav.getText())
                                                            +"', hre_deb = '"+txt_hre_deb.getText()
                                                            +"', hre_fin = '"+txt_hre_fin.getText()
                                                            +"', tps = '"+tps
                                                            +"', cd_site = '"+label_sav_agence_selection.getText().replace("'", "''")
                                                            +"', interloc = '"+txt_interloc.getSelectedItem()
                                                            +"', regle = '"+regle
                                                            +"', pblme = '"+txt_pblme.getText().replace("'", "''")
                                                            +"', typsav = '"+txt_typsav.getSelectedItem()
                                                            +"', interlocuteur = '"+txt_interlocuteur.getSelectedItem()
                                                            +"', date_demande = '"+Date_Francais_Anglais(txt_date_demande.getText())
                                                            +"', heureSAV = '"+txt_heureSAV.getText()
                                                            +"' WHERE numero = '"+sav_numero_selection+"';");
                                                    pst = conn.prepareStatement(sql_modifier_sav);
                                                    pst.executeUpdate();
                                                    JOptionPane.showMessageDialog(null, "SAV modifié avec succès.");
                                                    
                                                    Principal_jframe.sav_option = 3; 
                                                    Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                                                    fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                                                    fenetre_sav_mod_supp_aff_liste.setVisible(true);
                                                    this.dispose();
                                                }
                                                catch(Exception e){
                                                    JOptionPane.showMessageDialog(null, e);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        buttonGroup4 = new javax.swing.ButtonGroup();
        buttonGroup5 = new javax.swing.ButtonGroup();
        buttonGroup6 = new javax.swing.ButtonGroup();
        buttonGroup7 = new javax.swing.ButtonGroup();
        buttonGroup8 = new javax.swing.ButtonGroup();
        buttonGroup9 = new javax.swing.ButtonGroup();
        buttonGroup10 = new javax.swing.ButtonGroup();
        buttonGroup11 = new javax.swing.ButtonGroup();
        Panel_impression = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt_pblme = new javax.swing.JTextArea();
        button_ajouter_sav = new javax.swing.JButton();
        txt_interloc = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        button_quitter_sav = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        button_modifier_sav = new javax.swing.JButton();
        txt_interlocuteur = new javax.swing.JComboBox();
        txt_heureSAV = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_date_sav = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_hre_deb = new javax.swing.JFormattedTextField();
        txt_typsav = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        txt_regle_oui = new javax.swing.JRadioButton();
        txt_regle_non = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        txt_hre_fin = new javax.swing.JFormattedTextField();
        button_aide_sav = new javax.swing.JButton();
        label_sav_agence_selection = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        button_imprimer_sav = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txt_date_demande = new javax.swing.JFormattedTextField();
        button_supprimer_sav = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("S.A.V");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txt_pblme.setColumns(20);
        txt_pblme.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txt_pblme.setLineWrap(true);
        txt_pblme.setRows(5);
        txt_pblme.setNextFocusableComponent(txt_regle_oui);
        txt_pblme.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_pblmeFocusLost(evt);
            }
        });
        txt_pblme.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_pblmeKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(txt_pblme);

        button_ajouter_sav.setText("Ajouter(F6)");
        button_ajouter_sav.setNextFocusableComponent(button_modifier_sav);
        button_ajouter_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_ajouter_savActionPerformed(evt);
            }
        });
        button_ajouter_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_ajouter_savKeyPressed(evt);
            }
        });

        txt_interloc.setEditable(true);
        txt_interloc.setMaximumRowCount(13);
        txt_interloc.setNextFocusableComponent(txt_pblme);

        jLabel8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel8.setText("Interlocuteur :");

        button_quitter_sav.setText("Quitter");
        button_quitter_sav.setNextFocusableComponent(txt_date_demande);
        button_quitter_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_quitter_savActionPerformed(evt);
            }
        });
        button_quitter_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_quitter_savKeyPressed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel3.setText("A :");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel4.setText("Par :");

        button_modifier_sav.setText("Modifier(F7)");
        button_modifier_sav.setNextFocusableComponent(button_supprimer_sav);
        button_modifier_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_modifier_savActionPerformed(evt);
            }
        });
        button_modifier_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_modifier_savKeyPressed(evt);
            }
        });

        txt_interlocuteur.setEditable(true);
        txt_interlocuteur.setMaximumRowCount(13);
        txt_interlocuteur.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        txt_interlocuteur.setNextFocusableComponent(txt_date_sav);

        try {
            txt_heureSAV.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_heureSAV.setNextFocusableComponent(txt_typsav);
        txt_heureSAV.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_heureSAVFocusLost(evt);
            }
        });
        txt_heureSAV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_heureSAVKeyPressed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel6.setText("SAV commence le :");

        try {
            txt_date_sav.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_sav.setNextFocusableComponent(txt_hre_deb);
        txt_date_sav.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_savFocusLost(evt);
            }
        });
        txt_date_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_savKeyPressed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel2.setText("Demande le :");

        try {
            txt_hre_deb.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_hre_deb.setNextFocusableComponent(txt_interloc);
        txt_hre_deb.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_hre_debFocusLost(evt);
            }
        });
        txt_hre_deb.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hre_debKeyPressed(evt);
            }
        });

        txt_typsav.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Téléphone", "Mail", "Fax", "Interne" }));
        txt_typsav.setNextFocusableComponent(txt_interlocuteur);
        txt_typsav.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_typsavFocusGained(evt);
            }
        });
        txt_typsav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_typsavKeyPressed(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));

        jLabel9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel9.setText("Réglé :");

        buttonGroup1.add(txt_regle_oui);
        txt_regle_oui.setText("Oui");
        txt_regle_oui.setNextFocusableComponent(txt_regle_non);
        txt_regle_oui.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_regle_ouiFocusGained(evt);
            }
        });
        txt_regle_oui.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_regle_ouiKeyPressed(evt);
            }
        });

        buttonGroup1.add(txt_regle_non);
        txt_regle_non.setText("Non");
        txt_regle_non.setNextFocusableComponent(txt_hre_fin);
        txt_regle_non.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_regle_nonFocusGained(evt);
            }
        });
        txt_regle_non.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_regle_nonKeyPressed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel10.setText("Heure de fin :");

        try {
            txt_hre_fin.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##:##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_hre_fin.setNextFocusableComponent(button_ajouter_sav);
        txt_hre_fin.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_hre_finFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_hre_finFocusLost(evt);
            }
        });
        txt_hre_fin.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_hre_finKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_regle_oui, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_regle_non)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_hre_fin, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txt_regle_oui)
                    .addComponent(jLabel10)
                    .addComponent(txt_regle_non)
                    .addComponent(txt_hre_fin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        button_aide_sav.setText("Aide (F2)");
        button_aide_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_aide_savActionPerformed(evt);
            }
        });

        label_sav_agence_selection.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel7.setText("A :");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel5.setText("Contact :");

        jLabel12.setText(" (CTRL + TAB pour passer au champ suivant)");

        button_imprimer_sav.setText("Imprimer");
        button_imprimer_sav.setNextFocusableComponent(button_quitter_sav);
        button_imprimer_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_imprimer_savActionPerformed(evt);
            }
        });
        button_imprimer_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_imprimer_savKeyPressed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        jLabel1.setText("Site :");

        try {
            txt_date_demande.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##-##-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        txt_date_demande.setNextFocusableComponent(txt_heureSAV);
        txt_date_demande.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txt_date_demandeFocusLost(evt);
            }
        });
        txt_date_demande.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_date_demandeKeyPressed(evt);
            }
        });

        button_supprimer_sav.setText("Supprimer(F8)");
        button_supprimer_sav.setNextFocusableComponent(button_imprimer_sav);
        button_supprimer_sav.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_supprimer_savActionPerformed(evt);
            }
        });
        button_supprimer_sav.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                button_supprimer_savKeyPressed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image_fond/1797393.png"))); // NOI18N
        jLabel11.setText("jLabel11");

        javax.swing.GroupLayout Panel_impressionLayout = new javax.swing.GroupLayout(Panel_impression);
        Panel_impression.setLayout(Panel_impressionLayout);
        Panel_impressionLayout.setHorizontalGroup(
            Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_impressionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Panel_impressionLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(label_sav_agence_selection, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button_aide_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, Panel_impressionLayout.createSequentialGroup()
                        .addComponent(button_ajouter_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_modifier_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_supprimer_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(button_imprimer_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                        .addComponent(button_quitter_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_impressionLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_date_demande, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_heureSAV, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_typsav, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_interlocuteur, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(Panel_impressionLayout.createSequentialGroup()
                        .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12)
                            .addGroup(Panel_impressionLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_date_sav, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_hre_deb, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_interloc, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 680, Short.MAX_VALUE))
        );
        Panel_impressionLayout.setVerticalGroup(
            Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Panel_impressionLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(label_sav_agence_selection, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1))
                    .addComponent(button_aide_sav))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(txt_typsav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txt_interlocuteur, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date_demande, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_heureSAV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8)
                    .addComponent(txt_interloc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_date_sav, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_hre_deb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button_ajouter_sav)
                    .addComponent(button_quitter_sav)
                    .addComponent(button_modifier_sav)
                    .addComponent(button_supprimer_sav)
                    .addComponent(button_imprimer_sav))
                .addContainerGap())
            .addGroup(Panel_impressionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 640, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_impression, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Panel_impression, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private int focus_set_heure_fin = 0;
    
    private void txt_regle_ouiFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_regle_ouiFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_regle_ouiFocusGained

    private void txt_regle_nonFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_regle_nonFocusGained
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txt_regle_nonFocusGained

    private void button_quitter_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_quitter_savActionPerformed
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            if (Principal_jframe.sav_option == 1){
                Principal_jframe.sav_option = 1;
                Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                fenetre_sav_mod_supp_aff_liste.setVisible(true);
                this.dispose();
            }
            else if (Principal_jframe.sav_option == 2){
                Principal_jframe.sav_option = 2;
                Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
                fenetre_sav_ajout_liste.setLocationRelativeTo(null);
                fenetre_sav_ajout_liste.setVisible(true);
                this.dispose();
            }
            else if (Principal_jframe.sav_option == 3){
                Principal_jframe.sav_option = 3; 
                Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                fenetre_sav_mod_supp_aff_liste.setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_button_quitter_savActionPerformed

    private void button_ajouter_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_ajouter_savActionPerformed
        // TODO add your handling code here:
        Ajouter_sav();
    }//GEN-LAST:event_button_ajouter_savActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
        if(option == JOptionPane.OK_OPTION){
            if (Principal_jframe.sav_option == 1){
                Principal_jframe.sav_option = 1;
                Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                fenetre_sav_mod_supp_aff_liste.setVisible(true);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
            else if (Principal_jframe.sav_option == 2){
                Principal_jframe.sav_option = 2;
                Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
                fenetre_sav_ajout_liste.setLocationRelativeTo(null);
                fenetre_sav_ajout_liste.setVisible(true);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
            else if (Principal_jframe.sav_option == 3){
                Principal_jframe.sav_option = 3; 
                Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                fenetre_sav_mod_supp_aff_liste.setVisible(true);
                this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
            }
        }
        else{
            this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        }
    }//GEN-LAST:event_formWindowClosing

    private void txt_hre_finFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_hre_finFocusGained
        // TODO add your handling code here:
        if (Principal_jframe.sav_option != 3){
                txt_hre_fin.setText(heure());
        }
    }//GEN-LAST:event_txt_hre_finFocusGained

    public static String numero_de_lagence_a_afficher = "";
    public static int option_aide = 0;
    
    public void aide_sav_agence(){
        try{
            conn = javaconnect.ConnectDb();
            String sql_query = ("SELECT numero FROM agence WHERE nom = '"+label_sav_agence_selection.getText().replace("'", "''")+"';");
            pst = conn.prepareStatement(sql_query);
            Rs = pst.executeQuery();
            if(Rs.next()){
                numero_de_lagence_a_afficher = Rs.getString("numero");
                System.out.println(numero_de_lagence_a_afficher);
                option_aide = 1;
                Agence_jframe fenetre_agence = new Agence_jframe();
                fenetre_agence.setLocationRelativeTo(null);
                fenetre_agence.setVisible(true);
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void button_aide_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_aide_savActionPerformed
        // TODO add your handling code here:
        aide_sav_agence();
    }//GEN-LAST:event_button_aide_savActionPerformed

    private void button_supprimer_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_supprimer_savActionPerformed
        // TODO add your handling code here:
        Supprimer_sav();
    }//GEN-LAST:event_button_supprimer_savActionPerformed

    private void button_modifier_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_modifier_savActionPerformed
        // TODO add your handling code here:
        Modifier_sav();
    }//GEN-LAST:event_button_modifier_savActionPerformed
    
    public void Imprimer_sav(){
        Toolkit tkp = Panel_impression.getToolkit();
        PrintJob pjp = tkp.getPrintJob(this, null, null);
        Graphics g = pjp.getGraphics();
        Panel_impression.print(g);
        g.dispose();
        pjp.end();
    }
    
    private void button_imprimer_savActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_imprimer_savActionPerformed
        Imprimer_sav();
    }//GEN-LAST:event_button_imprimer_savActionPerformed

    private void txt_typsavFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_typsavFocusGained
        // TODO add your handling code here:
        if (Principal_jframe.sav_option == 1){
            button_imprimer_sav.requestFocus();
        }
    }//GEN-LAST:event_txt_typsavFocusGained
    private boolean bug_entrer_txt_date_demande = false;
    private void txt_date_demandeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_demandeKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_date_demande = true;
            if (isValidDate(txt_date_demande.getText()) == false){
                if (!"  -  -  ".equals(txt_date_demande.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_demande.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_date_demande.transferFocus();
                }
            }
            else{
                txt_date_demande.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.OK_OPTION){
                if (Principal_jframe.sav_option == 1){
                    Principal_jframe.sav_option = 1;
                    Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                    fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                    fenetre_sav_mod_supp_aff_liste.setVisible(true);
                    this.dispose();
                }
                else if (Principal_jframe.sav_option == 2){
                    Principal_jframe.sav_option = 2;
                    Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
                    fenetre_sav_ajout_liste.setLocationRelativeTo(null);
                    fenetre_sav_ajout_liste.setVisible(true);
                    this.dispose();
                }
                else if (Principal_jframe.sav_option == 3){
                    Principal_jframe.sav_option = 3; 
                    Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                    fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                    fenetre_sav_mod_supp_aff_liste.setVisible(true);
                    this.dispose();
                }
            }
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_date_demandeKeyPressed
    private boolean bug_entrer_txt_heureSAV = false;
    private void txt_heureSAVKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_heureSAVKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_heureSAV = true;
            if (isValidHeure(txt_heureSAV.getText()) == false){
                if (!"  :  ".equals(txt_heureSAV.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_heureSAV.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_heureSAV.transferFocus();
                }
            }
            else{
                txt_heureSAV.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_heureSAV.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_heureSAVKeyPressed

    private void txt_typsavKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_typsavKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_typsav.transferFocus();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_typsav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_typsavKeyPressed
    private boolean bug_entrer_txt_date_sav = false;
    private void txt_date_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_date_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_date_sav = true;
            if (isValidDate(txt_date_sav.getText()) == false){
                if (!"  -  -  ".equals(txt_date_sav.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_sav.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_date_sav.transferFocus();
                }
            }
            else{
                txt_date_sav.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_date_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_date_savKeyPressed
    private boolean bug_entrer_txt_hre_deb = false;
    private void txt_hre_debKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hre_debKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_hre_deb = true;
            if (isValidHeure(txt_hre_deb.getText()) == false){
                if (!"  :  ".equals(txt_hre_deb.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_hre_deb.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_hre_deb.transferFocus();
                }
            }
            else{
                txt_hre_deb.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_hre_deb.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_hre_debKeyPressed

    private void txt_pblmeKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_pblmeKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_pblme.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
        if (evt.isControlDown() && evt.getKeyCode() == KeyEvent.VK_ENTER){
            txt_pblme.transferFocus();
        }
    }//GEN-LAST:event_txt_pblmeKeyPressed

    private void txt_regle_ouiKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_regle_ouiKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_regle_oui.setSelected(true);
            txt_hre_fin.requestFocus();
        }
        if (c == KeyEvent.VK_RIGHT){
            txt_regle_non.requestFocus();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_regle_oui.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_regle_ouiKeyPressed

    private void txt_regle_nonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_regle_nonKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            txt_regle_non.setSelected(true);
            txt_hre_fin.requestFocus();
        }
        if (c == KeyEvent.VK_LEFT){
            txt_regle_oui.requestFocus();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_regle_non.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_regle_nonKeyPressed
    private boolean bug_entrer_txt_hre_fin = false;
    private void txt_hre_finKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_hre_finKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            bug_entrer_txt_hre_fin = true;
            if (isValidHeure(txt_hre_fin.getText()) == false){
                if (!"  :  ".equals(txt_hre_fin.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_hre_fin.setText("");
                    //txt_instal.requestFocus();
                }
                else{
                    txt_hre_fin.transferFocus();
                }
            }
            else{
                txt_hre_fin.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_hre_fin.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_txt_hre_finKeyPressed

    private void txt_date_demandeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_demandeFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_demande == false){
            if (isValidDate(txt_date_demande.getText()) == false){
                if (!"  -  -  ".equals(txt_date_demande.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_demande.setText("");
                    txt_date_demande.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_demande = false;
    }//GEN-LAST:event_txt_date_demandeFocusLost

    private void txt_date_savFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_date_savFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_date_sav == false){
            if (isValidDate(txt_date_sav.getText()) == false){
                if (!"  -  -  ".equals(txt_date_sav.getText())){
                    JOptionPane.showMessageDialog(null, "Cette date n'existe pas."); 
                    txt_date_sav.setText("");
                    txt_date_sav.requestFocus();
                }
            }
        }
        bug_entrer_txt_date_sav = false;
    }//GEN-LAST:event_txt_date_savFocusLost

    private void txt_heureSAVFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_heureSAVFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_heureSAV == false){
            if (isValidHeure(txt_heureSAV.getText()) == false){
                if (!"  :  ".equals(txt_heureSAV.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_heureSAV.setText("");
                    txt_heureSAV.requestFocus();
                }
            }
        }
        bug_entrer_txt_heureSAV = false;
    }//GEN-LAST:event_txt_heureSAVFocusLost

    private void txt_hre_debFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_hre_debFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_hre_deb == false){
            if (isValidHeure(txt_hre_deb.getText()) == false){
                if (!"  :  ".equals(txt_hre_deb.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_hre_deb.setText("");
                    txt_hre_deb.requestFocus();
                }
            }
        }
        bug_entrer_txt_hre_deb = false;
    }//GEN-LAST:event_txt_hre_debFocusLost

    private void txt_hre_finFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_hre_finFocusLost
        // TODO add your handling code here:
        if (bug_entrer_txt_hre_fin == false){
            if (isValidHeure(txt_hre_fin.getText()) == false){
                if (!"  :  ".equals(txt_hre_fin.getText())){
                    JOptionPane.showMessageDialog(null, "Cette heure n'existe pas."); 
                    txt_hre_fin.setText("");
                    txt_hre_fin.requestFocus();
                }
            }
        }
        bug_entrer_txt_hre_fin = false;
    }//GEN-LAST:event_txt_hre_finFocusLost

    private void button_ajouter_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_ajouter_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Ajouter_sav();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            button_ajouter_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_button_ajouter_savKeyPressed

    private void button_modifier_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_modifier_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Modifier_sav();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            button_modifier_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_button_modifier_savKeyPressed

    private void button_supprimer_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_supprimer_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Supprimer_sav();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            button_supprimer_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_button_supprimer_savKeyPressed

    private void button_imprimer_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_imprimer_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            Imprimer_sav();
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            button_imprimer_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_button_imprimer_savKeyPressed

    private void button_quitter_savKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_button_quitter_savKeyPressed
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (c == KeyEvent.VK_ENTER){
            int option = JOptionPane.showConfirmDialog(null, "Voulez-vous quitter cette fenêtre ?","Message de confirmation",JOptionPane.YES_NO_OPTION);
            if(option == JOptionPane.OK_OPTION){
                if (Principal_jframe.sav_option == 1){
                    Principal_jframe.sav_option = 1;
                    Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                    fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                    fenetre_sav_mod_supp_aff_liste.setVisible(true);
                    this.dispose();
                }
                else if (Principal_jframe.sav_option == 2){
                    Principal_jframe.sav_option = 2;
                    Sav_ajout_liste fenetre_sav_ajout_liste = new Sav_ajout_liste();
                    fenetre_sav_ajout_liste.setLocationRelativeTo(null);
                    fenetre_sav_ajout_liste.setVisible(true);
                    this.dispose();
                }
                else if (Principal_jframe.sav_option == 3){
                    Principal_jframe.sav_option = 3; 
                    Sav_mod_supp_aff_liste fenetre_sav_mod_supp_aff_liste = new Sav_mod_supp_aff_liste();
                    fenetre_sav_mod_supp_aff_liste.setLocationRelativeTo(null);
                    fenetre_sav_mod_supp_aff_liste.setVisible(true);
                    this.dispose();
                }
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            button_quitter_sav.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }
    }//GEN-LAST:event_button_quitter_savKeyPressed

    private void txt_pblmeFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_pblmeFocusLost
        // TODO add your handling code here:
        if (Principal_jframe.sav_option != 3){
                txt_hre_fin.setText(heure());
        }
    }//GEN-LAST:event_txt_pblmeFocusLost
    
    private void txt_interlocuteurKeyPressed(java.awt.event.KeyEvent evt) {                                              
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (txt_interlocuteur.getSelectedItem() != ""){
            if (c == KeyEvent.VK_ENTER){
                txt_interlocuteur.transferFocus();
            }
        }
        /*if (c == KeyEvent.VK_DOWN){
           
        }*/
        
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_interlocuteur.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }  
    }
    
    private void txt_interlocKeyPressed(java.awt.event.KeyEvent evt) {                                              
        // TODO add your handling code here:
        int c = evt.getKeyCode();
        if (txt_interloc.getSelectedItem() != ""){
            if (c == KeyEvent.VK_ENTER){
                txt_interloc.transferFocus();
            }
        }
        if (c == KeyEvent.VK_F2){
            if (Principal_jframe.sav_option == 2){
                aide_sav_agence();
            }
        }
        if (c == KeyEvent.VK_F4){
            txt_interloc.transferFocusBackward();
        }
        if (Principal_jframe.sav_option == 2){
            if (c == KeyEvent.VK_F6){
                Ajouter_sav();
            }
        }
        if (Principal_jframe.sav_option == 3){
            if (c == KeyEvent.VK_F7){
                Modifier_sav();
            }
            if (c == KeyEvent.VK_F8){
                Supprimer_sav();
            }
        }  
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
            java.util.logging.Logger.getLogger(Sav_ajout_mod_supp_aff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_mod_supp_aff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_mod_supp_aff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sav_ajout_mod_supp_aff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sav_ajout_mod_supp_aff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel_impression;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup10;
    private javax.swing.ButtonGroup buttonGroup11;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.ButtonGroup buttonGroup4;
    private javax.swing.ButtonGroup buttonGroup5;
    private javax.swing.ButtonGroup buttonGroup6;
    private javax.swing.ButtonGroup buttonGroup7;
    private javax.swing.ButtonGroup buttonGroup8;
    private javax.swing.ButtonGroup buttonGroup9;
    private javax.swing.JButton button_aide_sav;
    private javax.swing.JButton button_ajouter_sav;
    private javax.swing.JButton button_imprimer_sav;
    private javax.swing.JButton button_modifier_sav;
    private javax.swing.JButton button_quitter_sav;
    private javax.swing.JButton button_supprimer_sav;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel label_sav_agence_selection;
    private javax.swing.JFormattedTextField txt_date_demande;
    private javax.swing.JFormattedTextField txt_date_sav;
    private javax.swing.JFormattedTextField txt_heureSAV;
    private javax.swing.JFormattedTextField txt_hre_deb;
    private javax.swing.JFormattedTextField txt_hre_fin;
    private javax.swing.JComboBox txt_interloc;
    private javax.swing.JComboBox txt_interlocuteur;
    private javax.swing.JTextArea txt_pblme;
    private javax.swing.JRadioButton txt_regle_non;
    private javax.swing.JRadioButton txt_regle_oui;
    private javax.swing.JComboBox txt_typsav;
    // End of variables declaration//GEN-END:variables
}
