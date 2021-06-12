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

    public static void createTag(Tag tag) {
    String keys = "(name, color)";
    String sql = "INSERT INTO tag " + keys + " VALUES ('"
      + tag.getName() + "', '"
      + tag.getColor() + "');";

    Connection conn = null;
    PreparedStatement pstm = null;

    try {
      conn = ConnectionDb.createConnection();
      pstm = conn.prepareStatement(sql);
      pstm.execute();
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
      try {
        if (pstm != null) pstm.close();
        if (conn != null) conn.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }

    public static void updateTag(Tag tag) {
        String sql = "UPDATE tag SET "
            + "name = '" + tag.getName() + "', "
            + "color = '" + tag.getColor() + "' "
            + "WHERE tag_id = " + tag.getId();
    
        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionDb.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.addBatch("SET FOREIGN_KEY_CHECKS=0");
            pstm.executeBatch();
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    
    public static void deleteTag(int tag_id) {
        String sql = "DELETE FROM tag WHERE tag_id = " + tag_id + ";";
        Connection conn = null;
        PreparedStatement pstm = null;
        
        try {
            conn = ConnectionDb.createConnection();
            pstm = conn.prepareStatement(sql);
            pstm.addBatch("SET FOREIGN_KEY_CHECKS=0");
            pstm.executeBatch();
            pstm.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
