package GUI;

//import java.awt.*;
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

public class TimeLineGUI extends JFrame {
  static TaskDAO dp = new TaskDAO();
  JButton addTask = new JButton("+");
  
  public TimeLineGUI() {
    setTitle("Linha do Tempo");
    setSize(550, 450);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    Menu();
    taskList();
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
    JPanel gui = new JPanel(new GridLayout(2,0,5,5));
    gui.setBorder(new EmptyBorder(10,10,10,10));
    gui.setBackground(Color.RED);
    gui.add(addTask);
  }
  
    public void Menu() {
        JMenuBar menuBar = new JMenuBar();  
        JMenu item_timeline, item_tags ,item_exit;
        item_timeline = new JMenu("Item 1");  
        item_tags = new JMenu("Item 2");  
        item_exit = new JMenu("Item 3");

        menuBar.add(item_timeline);
        menuBar.add(item_tags);
        menuBar.add(item_exit);

        setJMenuBar(menuBar);
        setSize(400,400);
        setLayout(null);
    }
}
