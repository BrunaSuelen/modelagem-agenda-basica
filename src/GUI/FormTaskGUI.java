package GUI;

import DAOs.*;
import classes.Tag;
import classes.Task;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JMenuItem;

public class FormTaskGUI extends javax.swing.JFrame {
    JMenuItem item_timeline, item_tags ,item_exit;
    TagsDAO tagsDAO = new TagsDAO();
    List<Tag> tagsList = new ArrayList<Tag>();
    boolean isEdition = false;    
    int idTaskForEdition = 0;

    
    public FormTaskGUI() {
        initComponents();
        initCombobox();
        initJFrame("Criar Tarefa");
        menu();
    }
    
    public FormTaskGUI(Task task) {
        initComponents();
        initJFrame("Editar Tarefa");
        initCombobox();
        initFieldsToEdition(task);
        menu();
        isEdition = true;
        idTaskForEdition = task.getId();
        JB_cancel_or_delete.setText("Excluir");
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        JTF_title = new javax.swing.JTextField();
        nxns1 = new java.awt.Label();
        nxns2 = new java.awt.Label();
        JCB_month = new javax.swing.JComboBox<>();
        nxns3 = new java.awt.Label();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        JTA_description = new javax.swing.JTextArea();
        JB_save = new javax.swing.JButton();
        nxns = new java.awt.Label();
        JCB_tag = new javax.swing.JComboBox<>();
        JCB_day = new javax.swing.JComboBox<>();
        JCB_year = new javax.swing.JComboBox<>();
        JB_cancel_or_delete = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        JTF_title.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N

        nxns1.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        nxns1.setText("Descrição");

        nxns2.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        nxns2.setText("Data Final");

        JCB_month.setEditable(true);
        JCB_month.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JCB_month.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
        JCB_month.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_monthActionPerformed(evt);
            }
        });

        nxns3.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        nxns3.setText("Etiqueta");

        jLabel1.setFont(new java.awt.Font("Poppins", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Criar nova Tarefa");

        jPanel2.setBackground(new java.awt.Color(255, 154, 20));
        jPanel2.setPreferredSize(new java.awt.Dimension(8, 354));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 8, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 354, Short.MAX_VALUE)
        );

        JTA_description.setColumns(20);
        JTA_description.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JTA_description.setRows(5);
        jScrollPane1.setViewportView(JTA_description);

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

        nxns.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        nxns.setText("Titulo");

        JCB_tag.setEditable(true);
        JCB_tag.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JCB_tag.setModel(JCB_tag.getModel());

        JCB_day.setEditable(true);
        JCB_day.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JCB_day.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));

        JCB_year.setEditable(true);
        JCB_year.setFont(new java.awt.Font("Poppins", 0, 11)); // NOI18N
        JCB_year.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030" }));
        JCB_year.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JCB_yearActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(JCB_day, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_month, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(JCB_year, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(nxns3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                            .addComponent(JB_cancel_or_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(JB_save, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nxns, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(nxns1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JTF_title, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(nxns2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(JCB_tag, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 332, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(nxns, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addComponent(JTF_title, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(nxns1, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(nxns2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(JCB_day, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCB_month, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(JCB_year, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(19, 19, 19)
                        .addComponent(nxns3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(9, 9, 9)
                        .addComponent(JCB_tag, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JB_cancel_or_delete, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JB_save, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
              
    public void initJFrame(String titlePage) {                
        setTitle(titlePage);
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }
     
    public void initFieldsToEdition(Task task) {
        LocalDateTime date = task.getFinalDate();
        Tag tag = task.getTag();
        
        JTF_title.setText(task.getTitle());
        JTA_description.setText(task.getDescription());
        JCB_year.getModel().setSelectedItem(date.format(DateTimeFormatter.ofPattern("yyyy")));
        JCB_month.getModel().setSelectedItem(date.format(DateTimeFormatter.ofPattern("MM")));
        JCB_day.getModel().setSelectedItem(date.format(DateTimeFormatter.ofPattern("dd")));
        if (tag != null) {
            JCB_tag.getModel().setSelectedItem(tag.getName());
        }
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
    
    public void initCombobox() {
        tagsList = tagsDAO.getTags();
        String[] tags = new String[tagsList.size()];
        
        for (int i = 0; i < tagsList.size(); i++) {
            Tag tag = tagsList.get(i);
            JCB_tag.addItem(tag.getName());
        }
    } 
    
    public LocalDateTime getDate() {
        String dateTimeValue = JCB_year.getSelectedItem().toString() 
                + "-" + JCB_month.getSelectedItem().toString() 
                + "-" + JCB_day.getSelectedItem().toString()
                + " 00:00";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(dateTimeValue, formatter);
        return dateTime;
    }
    
    private Task getValuesForm() {
        String tagSelected = JCB_tag.getSelectedItem().toString();
        int tag_id = tagsList.get(0).getId();
        
        for (int i = 0; i < tagsList.size(); i++) {
            Tag tag = tagsList.get(i);
            if (tag.getName() == tagSelected) {
                tag_id = tag.getId();
            }
        }
        
        Task task = new Task(
            JTF_title.getText(),
            JTA_description.getText(),
            getDate(),
            0,
            tag_id
        );
        
        return task;
    }
    
    private void JB_saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_saveActionPerformed
        Task task = getValuesForm();
        
        if (isEdition) {
            task.setId(idTaskForEdition);
            task.updateTask(task);
        } 
        else { 
            task.createTask(task);
        }
        
        TaskListGUI taskListGUI = new TaskListGUI();
        setVisible(false);
    }//GEN-LAST:event_JB_saveActionPerformed

    private void JCB_monthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_monthActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_monthActionPerformed

    private void JCB_yearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JCB_yearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JCB_yearActionPerformed

    private void JB_cancel_or_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JB_cancel_or_deleteActionPerformed
        Task task = getValuesForm();
        
        if (isEdition) { task.deleteTask(idTaskForEdition); }
        
        TaskListGUI taskListGUI = new TaskListGUI();
        setVisible(false);
    }//GEN-LAST:event_JB_cancel_or_deleteActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(FormTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTaskGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTaskGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JB_cancel_or_delete;
    private javax.swing.JButton JB_save;
    private javax.swing.JComboBox<String> JCB_day;
    private javax.swing.JComboBox<String> JCB_month;
    private javax.swing.JComboBox<String> JCB_tag;
    private javax.swing.JComboBox<String> JCB_year;
    private javax.swing.JTextArea JTA_description;
    private javax.swing.JTextField JTF_title;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label nxns;
    private java.awt.Label nxns1;
    private java.awt.Label nxns2;
    private java.awt.Label nxns3;
    // End of variables declaration//GEN-END:variables
}
