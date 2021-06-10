package DAOs;

import classes.Tag;
import connectionFactory.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class TagsDAO {
  public static List<Tag> getTags() {
    List<Tag> tags = new ArrayList<Tag>();

    ResultSet rset = null;
    Connection conn = null;
    PreparedStatement pstm = null;

    try {
      conn = ConnectionDb.createConnection();
      pstm = conn.prepareStatement("SELECT * FROM tag");
      rset = pstm.executeQuery();

      while (rset.next()) {
        Tag tag = new Tag(
          rset.getInt("tag_id"),
          rset.getString("name"),
          rset.getString("color")
        );
        tags.add(tag);
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

    return tags;
  }

  public static Tag getTagById(int tag_id) {
    Connection conn = null;
    PreparedStatement pstm = null;
    ResultSet rset = null;

    try {
      conn = ConnectionDb.createConnection();
      pstm = conn.prepareStatement("SELECT * FROM tag WHERE tag_id = " + tag_id);
      rset = pstm.executeQuery();

      if (rset.next()) {
        Tag tag = new Tag(
          rset.getInt("tag_id"),
          rset.getString("name"),
          rset.getString("color")
        );
        return tag;
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

    return null;
  }
}
