public class Artist {
  private String name;
  private Artist next;
  
  public Artist() {
    /***Input: Nothing.
      * 
      * Process: Creates an Artist object as a node
      * 
      * Output: This constructor returns nothing.
    ***/
  }
  
  public Artist(String n) {
    name = n;
  }
  
  public String display() {
    return name;
  }
}