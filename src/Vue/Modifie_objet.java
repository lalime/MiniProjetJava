/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Vue;

import Modele.Dao.ObjetDao;
import Modele.Dao.PretDao;
import Modele.modele.Objet;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Modifie_objet extends javax.swing.JFrame {

    /**
     * Creates new form Formulaire_objet
     */
    
    ObjetDao obdao= new ObjetDao();
    
    
    public Modifie_objet() {
        initComponents();
        this.setLocationRelativeTo(null);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        type = new javax.swing.JTextField();
        quantite = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        description = new javax.swing.JTextArea();
        annuler = new javax.swing.JButton();
        modifier = new javax.swing.JButton();
        afficher = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        comboObjet = new javax.swing.JComboBox();
        quitter1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Modifier objet");

        jLabel2.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel2.setText("Selectionner l'objet");

        jLabel3.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel3.setText("Description");

        jLabel4.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel4.setText("Quantite");

        description.setColumns(20);
        description.setRows(5);
        jScrollPane1.setViewportView(description);

        annuler.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        annuler.setText("Annuler");
        annuler.setBorder(new javax.swing.border.MatteBorder(null));
        annuler.addActionListener(new ControleModificationObjet());
        annuler.setActionCommand("annuler");
        annuler.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        modifier.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        modifier.setText("Modifier");
        modifier.setBorder(new javax.swing.border.MatteBorder(null));
        modifier.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        modifier.setActionCommand("modifier");
        modifier.addActionListener(new ControleModificationObjet());

        afficher.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        afficher.setText("Afficher");
        afficher.setBorder(new javax.swing.border.MatteBorder(null));
        afficher.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        afficher.setActionCommand("afficher");
        afficher.addActionListener(new ControleModificationObjet());

        jLabel5.setFont(new java.awt.Font("Verdana", 3, 12)); // NOI18N
        jLabel5.setText("Type");

        comboObjet.setModel(new javax.swing.DefaultComboBoxModel(new ObjetDao().getObjetName()));

        quitter1.setFont(new java.awt.Font("Verdana", 3, 11)); // NOI18N
        quitter1.setText("Terminer");
        quitter1.setBorder(new javax.swing.border.MatteBorder(null));
        quitter1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        quitter1.setActionCommand("quitter");
        quitter1.addActionListener(new ControleModificationObjet());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(type, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                                .addComponent(quantite, javax.swing.GroupLayout.Alignment.LEADING))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboObjet, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                                .addComponent(afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 437, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39)
                        .addComponent(quitter1, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboObjet, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(afficher, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(type, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(quantite, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(modifier, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(annuler, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(quitter1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void Reset(){
        type.setText("");
        description.setText("");
        quantite.setText("");
    }
    
    public Object[][] getData(){
        
        return new ObjetDao().getListObjet();
        
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Formulaire_objet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Formulaire_objet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Formulaire_objet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Formulaire_objet.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Modifie_objet().setVisible(true);
            }
        });
    }
    /*Controller class et evènement*/
    private class ControleModificationObjet implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            // action à faire lorsqu'on presse le boutton modifier
            int id=0;
            
            if(e.getActionCommand().equals("afficher")){
            
           String obj= comboObjet.getSelectedItem().toString();
            
         int k=0,id_objet=0;
           for(int i=0;i<obj.length();i++){
                
                if(obj.charAt(i)=='-'){
                   
                  id_objet=Integer.parseInt(obj.substring(k, i));
                  break;
                  
                }
            }
           
           Objet objet=new ObjetDao().getObjetById(id_objet);
           id=id_objet;
           
           quantite.setText(objet.getQte()+"");
           description.setText(objet.getDescription());
           type.setText(objet.getTypes());
           
        } 
            
            
            if(e.getActionCommand().equals("modifier")){
            
            
            String typeobjet= type.getText().trim();
            String des=description.getText().trim();
            int qte=0, test=0;
            try{
                
                 qte=Integer.parseInt(quantite.getText());
                
            }catch(NumberFormatException ex){
                
                JOptionPane.showMessageDialog(null, "la quantite doit etre un entier ") ;
                test=1;
                
            }
            
            String obj= comboObjet.getSelectedItem().toString();
            
         int k=0,id_objet=0;
           for(int i=0;i<obj.length();i++){
                
                if(obj.charAt(i)=='-'){
                   
                  id_objet=Integer.parseInt(obj.substring(k, i));
                  break;
                  
                }
            }
           
           Objet objet=new ObjetDao().getObjetById(id_objet);
            
            
            if((typeobjet.length()<50)&&(des.length()<255)&&(test==0)){
              
                System.out.println(id);
                objet.setId_user(1);
                objet.setDescription(des);
                objet.setQte(qte);
                objet.setTypes(typeobjet);
                if(obdao.update(objet)){
               JOptionPane.showMessageDialog(null, "la modification s'est terminée avec succès ") ;
               Reset();
               } else JOptionPane.showMessageDialog(null, "ehec de la modification ") ;
            }else JOptionPane.showMessageDialog(null, "ehec de la modification ") ;
           
        } 
            //action à faire lorsqu'on presse le boutton afficher
            
            
            //action à faire lorsqu'on presse le boutton terminer
            if(e.getActionCommand().equals("quitter")){
            
            dispose();
        }
        
            
            
            //action à faire lorsqu'on presse le boutton annuler 
            
            if(e.getActionCommand().equals("annuler")){
                Reset();
            }
       }
        
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton afficher;
    private javax.swing.JButton annuler;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox comboObjet;
    private javax.swing.JTextArea description;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifier;
    private javax.swing.JTextField quantite;
    private javax.swing.JButton quitter1;
    private javax.swing.JTextField type;
    // End of variables declaration//GEN-END:variables
}