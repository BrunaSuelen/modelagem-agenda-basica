package classes;

import DAOs.TagsDAO;

public class Tag {
  private int tag_id;
  private String name;
  private String color;

  private TagsDAO tagDao = new TagsDAO();
  
  public Tag(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public Tag(int tag_id, String name, String color) {
    this.tag_id = tag_id;
    this.name = name;
    this.color = color;
  }

  public void setId(int tag_id) {
    this.tag_id = tag_id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setColor(String color) {
    this.color = color;
  }

  public int getId() {
    return tag_id;
  }

  public String getName() {
    return name;
  }

  public String getColor() {
    return color;
  }
  
  public void createTag(Tag tag) {
    tagDao.createTag(tag);
  }
  
  public void updateTag(Tag tag) {
    tagDao.updateTag(tag);
  }
  
  public void deleteTag(int tag_id) {
    tagDao.deleteTag(tag_id);
  }
}
