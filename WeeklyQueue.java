import java.util.*;
/*Using the sort method in main, a playlist is put 
 * together for the client using this class.
 * You can add songs and check the most recently
 * played here.
 */
public class WeeklyQueue {
  private Queue<String> myQueue;
  
  public WeeklyQueue() {
    myQueue = new LinkedList<String>();
  }
  
  public void insert(String song) {
    myQueue.add(song);
  }
  
  public String getSong() {
    return myQueue.poll();
  }
}