package classes;

public class Tag {
  private int tag_id;
  private String name;
  private String color;

  public Tag(String name, String color) {
    this.name = name;
    this.color = color;
  }
  
  public Tag(int tag_id, String name, String color) {
    this.tag_id = tag_id;
    this.name = name;
    this.color = color;
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
}
