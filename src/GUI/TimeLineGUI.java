package GUI;

import java.util.*;
import javax.swing.*;
import java.awt.event.*;
import DAOs.TaskDAO;

import classes.*;
import java.awt.GridLayout;

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
    taskList = dp.getTasks();

    setLayout(new GridLayout(taskList.size(), 2));

    for(int i = 0; i < taskList.size(); i++) {
      Task task = taskList.get(i);
      
      JLabel label_title = new JLabel(task.getTitle());
      JLabel label_description = new JLabel(task.getDescription());

      add(label_title);
      add(label_description);
    }
  }
}
