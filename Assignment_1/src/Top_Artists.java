import java.util.*;
public class Top_Artists {
  private String name;
  private Artist first;
  private LinkedList<Artist> list;
  
  
  public Top_Artists () {
    /***Input: Nothing.
      * 
      * Process: Creates a linked list of Artists
      * 
      * Output: This constructor returns nothing.
    ***/
    
    first = null;
    list = new LinkedList<Artist>();
  }
  
  public boolean isEmpty() {
    return (first == null);
  }
  
  public void insert(Artist a) {
    list.add(a);
  }
  
  public int size() {
    return list.size();
  }
  
  public Artist getArt(int i) {
    return list.get(i);
  }
  
  public void setIn(Artist a, int i) {
   list.set(i, a); 
  }
}