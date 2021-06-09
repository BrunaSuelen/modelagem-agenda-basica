package classes;

import DAOs.TagsDAO;
import java.time.LocalDateTime;

public class Task {
  private int task_id;
  private String title;
  private String description;
  private LocalDateTime final_date;
  private boolean complete;
  private int tag_id;

  public Task(String title, String description, LocalDateTime final_date, boolean complete, int tag_id) {
    this.title = title;
    this.description = description;
    this.final_date = final_date;
    this.complete = complete;
    this.tag_id = tag_id;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public void setDescription(String description) {
    this.description = description;
  }
  
  public void setFinalDate(LocalDateTime final_date) {
    this.final_date = final_date;
  }
  
  public void setComplete(boolean complete) {
    this.complete = complete;
  }
  
  public void setTagId(int tag_id) {
    this.tag_id = tag_id;
  }

  public int getId() {
    return task_id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public LocalDateTime getFinalDate() {
    return final_date;
  }

  public boolean geComplete() {
    return complete;
  }

  public int getTagId() {
    return tag_id;
  }

  public Tag getTag() {
    TagsDAO tagDao = new TagsDAO();
    return tagDao.getTagById(this.tag_id);
  }
}
