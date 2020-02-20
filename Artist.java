public class Artist {
  private String name;
  private Artist next;
  
  public Artist() {
    
  }
  
  public Artist(String n) {
    name = n;
  }
  
  public String display() {
    return name;
  }
}