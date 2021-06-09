package GUI;

import GUI.*;
import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import DAOs.TaskDAO;

import classes.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.EmptyBorder;

public class TimeLineGUI extends JFrame implements ActionListener {
    static TaskDAO dp = new TaskDAO();
    JButton jbAddTask = new JButton("+");
    JMenuBar menuBar = new JMenuBar();
    JMenu item_timeline, item_tags ,item_exit;
    static String[] array = { "Titulo", "Descrição", "Data Final", "Etiqueta" };
    
    public TimeLineGUI() {
      setTitle("Linha do Tempo");
      setSize(550, 450);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setResizable(false);
      Menu();
      teste();
//      taskList();
      addTask();
      setVisible(true);
    }

    public void taskList() {
      List<Task> taskList = new ArrayList<Task>();
      taskList = dp.getTimeLine();

      setLayout(new GridLayout(taskList.size(), 3));

      for(int i = 0; i < taskList.size(); i++) {
        Task task = taskList.get(i);
        String final_date = task.getFinalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        Tag tag = task.getTag();

        JPanel panel = new JPanel();  
        panel.setBackground(Color.white);  

        JLabel label_title = new JLabel(task.getTitle());
        JLabel label_description = new JLabel(task.getDescription());
        JLabel label_final_date = new JLabel(final_date);

        panel.add(label_title);
        panel.add(label_description);
        panel.add(label_final_date);

        if(tag != null) {
          JLabel label_tag = new JLabel(tag.getName());
          panel.add(label_tag);
        }

        add(panel);
      }
    }
  
    public void addTask() {
        jbAddTask.setBounds(20,100,150,20);
        jbAddTask.addActionListener(this);
        jbAddTask.setMnemonic(KeyEvent.VK_V);
        jbAddTask.setBounds(100, 400, 50, 10);
        add(jbAddTask);
    }
    
    public void Menu() {
        item_timeline = new JMenu("Linha do Tempo");  
        item_tags = new JMenu("Etiquetas");  
        item_exit = new JMenu("Sair");

        menuBar.add(item_timeline);
        menuBar.add(item_tags);
        menuBar.add(item_exit);

        setJMenuBar(menuBar);
        setSize(400,400);
        setLayout(null);
    }
    
    public void actionPerformed(ActionEvent event){
       if (event.getSource() == jbAddTask){
            CreateTaskGUI t = new CreateTaskGUI();
       }
       if (event.getSource() == item_exit){
            System.exit(0);
       }
    }
    
    public void teste() {
        List<Task> taskList = new ArrayList<Task>();
        taskList = dp.getTimeLine();
        
        setLayout(new GridLayout(taskList.size(), 4));
        
        Object[][] tableList = new Object[taskList.size()][4];
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            String final_date = task.getFinalDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            Tag tag = task.getTag();
            
            tableList[i][0] = task.getTitle().toUpperCase();
            tableList[i][1] = task.getDescription().toUpperCase();
            tableList[i][2] = final_date.toUpperCase();
            
            if(tag != null) {
              tableList[i][3] = tag.getName();
            }
        }
        
        JTable timeLine = new JTable(tableList, array);
        add(timeLine);
    }
} 
