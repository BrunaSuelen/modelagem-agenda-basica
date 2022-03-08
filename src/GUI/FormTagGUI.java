package GUI;

import DAOs.TagsDAO;
import DAOs.TaskDAO;
import classes.Tag;
import classes.Task;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class FormTagGUI extends javax.swing.JFrame {
    JMenuItem item_timeline, item_tags ,item_exit;
    TagsDAO tagsDAO = new TagsDAO();
    List<Tag> tagsList = new ArrayList<Tag>();
    boolean isEdition = false;    
    int idTagForEdition = 0;

    public FormTagGUI() {
        initComponents();
        initJFrame("Criar Etiqueta");
        menu();
    }
    
    public FormTagGUI(Tag tag) {
        initComponents();
        initJFrame("Editar Etiqueta");
        initFieldsToEdition(tag);
        menu();
        isEdition = true;
        idTagForEdition = tag.getId();
        JB_cancel_or_delete1.setText("Excluir");
    }
                  
    public void initJFrame(String titlePage) {                
        setTitle(titlePage);
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        errorTag.setVisible(false);
    }
     
    public void initFieldsToEdition(Tag tag) {
        JTName.setText(tag.getName());
        JTColor.setText(tag.getColor());
    }
    
    public void menu() {
        menuActions();
        
        jMenuBar1.add(item_timeline);
        jMenuBar1.add(item_tags);
        jMenuBar1.add(item_exit);

        setJMenuBar(jMenuBar1);        
    }
    
    public void menuActions() { 
        item_timeline = new JMenuItem(new AbstractAction("Linha do Tempo") {
            public void actionPerformed(ActionEvent e) {
                TaskListGUI taskListGUI = new TaskListGUI();
                setVisible(false);
            }
        }); 
        
        item_tags = new JMenuItem(new AbstractAction("Etiquetas") {
            public void actionPerformed(ActionEvent e) {
                TagGUI tagGUI = new TagGUI();
                setVisible(false);
            }
        });
        
        item_exit = new JMenuItem(new AbstractAction("Sair") {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }
    
    public void removeValidation(Tag tag) {        
        List<Task> taskList = new ArrayList<Task>();
        taskList = TaskDAO.getTaskByTag(idTagForEdition);
        if (taskList.isEmpty()) {
            tag.deleteTag(idTagForEdition);
            errorTag.setVisible(false);
            TagGUI tagListGUI = new TagGUI();
            setVisible(false);
        }else {
            errorTag.setVisible(true);
        }
    }
            
    private Tag getValuesForm() {        
        Tag tag = new Tag(
            JTName.getText(),
            JTColor.getText()
        );
        
        return tag;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        JB_cancel_or_delete = new javax.swing.JButton();
        JB_save = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        titleName = new java.awt.Label();
        JTName = new javax.swing.JTextField();
        titleColor = new java.awt.Label();
        JTColor = new javax.swing.JTextField();
        JB_cancel_or_delete1 = new javax.swing.JButton();
        JB_save1 = new javax.swing.JButton();
        errorDeteteTag = new javax.swing.JLabel();
        errorTag = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();

        JB_cancel_or_delete.setBackground(new java.awt.Color(255, 0, 0));
        JB_cancel_or_delete.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        JB_cancel_or_delete.setForeground(new java.awt.Color(255, 0, 0));
        JB_cancel_or_delete.setText("Cancelar");
        JB_cancel_or_delete.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        JB_cancel_or_delete.setContentAreaFilled(false);
        JB_cancel_or_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_cancel_or_deleteActionPerformed(evt);
            }
        });

        JB_save.setBackground(new java.awt.Color(255, 154, 19));
        JB_save.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        JB_save.setForeground(new java.awt.Color(255, 154, 19));
        JB_save.setText("Salvar");
        JB_save.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 154, 19), 1, true));
        JB_save.setContentAreaFilled(false);
        JB_save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_saveActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(450, 450));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Criar nova Tarefa");

        titleName.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        titleName.setText("Nome da Etiqueta");

        JTName.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JTName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTNameActionPerformed(evt);
            }
        });

        titleColor.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        titleColor.setText("Cor");

        JTColor.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        JB_cancel_or_delete1.setBackground(new java.awt.Color(255, 0, 0));
        JB_cancel_or_delete1.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        JB_cancel_or_delete1.setForeground(new java.awt.Color(255, 0, 0));
        JB_cancel_or_delete1.setText("Cancelar");
        JB_cancel_or_delete1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 0, 0), 1, true));
        JB_cancel_or_delete1.setContentAreaFilled(false);
        JB_cancel_or_delete1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_cancel_or_delete1ActionPerformed(evt);
            }
        });

        JB_save1.setBackground(new java.awt.Color(255, 154, 19));
        JB_save1.setFont(new java.awt.Font("Poppins Light", 1, 14)); // NOI18N
        JB_save1.setForeground(new java.awt.Color(255, 154, 19));
        JB_save1.setText("Salvar");
        JB_save1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 154, 19), 1, true));
        JB_save1.setContentAreaFilled(false);
        JB_save1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JB_save1ActionPerformed(evt);
            }
        });

        errorDeteteTag.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        errorDeteteTag.setForeground(new java.awt.Color(255, 0, 0));

        errorTag.setFont(new java.awt.Font("Poppins", 1, 11)); // NOI18N
        errorTag.setForeground(new java.awt.Color(255, 0, 0));
        errorTag.setText("Está etiqueta está em uso, por favor remova suas referências");

        jPanel3.setBackground(new java.awt.Color(255, 154, 20));
        jPanel3.setPreferredSize(new java.awt.Dimension(8, 354));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(errorDeteteTag)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(JB_cancel_or_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(JB_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(titleColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTColor, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(JTName, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addComponent(errorTag))
                            .addComponent(jLabel1))))
                .addGap(42, 42, 42))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(errorDeteteTag))
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addGap(6, 6, 6)
                        .addComponent(errorTag, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(titleName, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(JTName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(titleColor, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(JTColor, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(38, 38, 38)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JB_save1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JB_cancel_or_delete1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(93, Short.MAX_VALUE))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void JB_cancel_or_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cancel_or_deleteActionPerformed
    }//GEN-LAST:event_JB_cancel_or_deleteActionPerformed

    private void JB_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_saveActionPerformed
    }//GEN-LAST:event_JB_saveActionPerformed

    private void JB_cancel_or_delete1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cancel_or_delete1ActionPerformed
        Tag tag = getValuesForm();

        if (isEdition) { 
            removeValidation(tag);
        } else {
            TagGUI tagListGUI = new TagGUI();
            setVisible(false);
        }
    }//GEN-LAST:event_JB_cancel_or_delete1ActionPerformed

    private void JB_save1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_save1ActionPerformed
        Tag tag = getValuesForm();

        if (isEdition) {
            tag.setId(idTagForEdition);
            tag.updateTag(tag);
        }
        else {
            tag.createTag(tag);
        }

        TagGUI tagListGUI = new TagGUI();
        setVisible(false);
    }//GEN-LAST:event_JB_save1ActionPerformed

    private void JTNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTNameActionPerformed

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
            java.util.logging.Logger.getLogger(FormTagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTagGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTagGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_cancel_or_delete;
    private javax.swing.JButton JB_cancel_or_delete1;
    private javax.swing.JButton JB_save;
    private javax.swing.JButton JB_save1;
    private javax.swing.JTextField JTColor;
    private javax.swing.JTextField JTName;
    private javax.swing.JLabel errorDeteteTag;
    private javax.swing.JLabel errorTag;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private java.awt.Label titleColor;
    private java.awt.Label titleName;
    // End of variables declaration//GEN-END:variables
}
