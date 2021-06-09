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

public class TimeLineGUI extends JFrame {
  static TaskDAO dp = new TaskDAO();
  
  public TimeLineGUI() {
    setTitle("Linha do Tempo");
    setSize(600, 500);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setResizable(false);
    taskList();
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
      panel.setBounds( 40 , 80 , 200 , 200 );    
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
}
