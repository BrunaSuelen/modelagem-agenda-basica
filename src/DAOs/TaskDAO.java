package DAOs;

import java.sql.*;
import java.util.*;

import classes.*;
import connectionFactory.ConnectionDb;

public class TaskDAO {

  public static List<Task> getTasks() {
    List<Task> tasks = new ArrayList<Task>();

    ResultSet rset = null;
    Connection conn = null;
    PreparedStatement pstm = null;

    try {
      conn = ConnectionDb.createConnection();
      pstm = conn.prepareStatement("SELECT * FROM task");
      rset = pstm.executeQuery();

      while (rset.next()) {
        Task task = new Task(
          rset.getString("title"),
          rset.getString("description"),
          rset.getTimestamp("final_date").toLocalDateTime(),
          rset.getBoolean("complete"),
          rset.getInt("tag_id")
        );
        tasks.add(task);
      }

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        if (rset != null) rset.close();
        if (pstm != null) pstm.close();
        if (conn != null) conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

    return tasks;
  }
}