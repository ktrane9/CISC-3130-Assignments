/*Class: CISC 3130
 * Section: TY9
 * EmplId: 23668586
 * Kohl Elie
*/
import java.io.*;
import java.util.*;
import java.util.Scanner;
public class Assignment_2 {
  public static void main(String [] args) throws IOException {
    File read = new File("Top Global Songs.csv");
    File read2 = new File("Top US Songs.csv");
    //File read = new File("trackList.csv");
    PrintWriter out = new PrintWriter("dataReport.csv");
    //PrintWriter out = new PrintWriter("dataReport.txt");
    Scanner in = new Scanner(read);
    Scanner in2 = new Scanner(read2);
    ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();
    
    readTracks(read, read2, in, in2, myList); 
    
    WeeklyQueue q = new WeeklyQueue();
    
    sort(q, myList); 
    
    Stack<String> myStack = new Stack();
    
    play(q, myStack);
    
    //songHistory(myStack);
    
    //printList(top, out);
    
    in.close();
    out.close();
  }
  
  public static void readTracks(File read, File read2, Scanner in, Scanner in2,
  ArrayList<ArrayList<String>> myList) throws IOException {
    /***Input: Takes in File read, Scanner in, and 2D arraylist of Strings
      * 
      * Process: Reads in items of a line and then tokenizes them into an array of strings. 
      * Then the arrays are added to the arraylist.
      * 
      * Output: This method returns nothing.
    ***/
    
    String line;
    ArrayList<String> list;
    int count = 0;
    
    while(in.hasNext()) {
      line = in.nextLine();
      list = new ArrayList<String>();
      
      String token [] = line.split(",");
     
        list.add(token[1]);
        //list.add(token[2]);
        System.out.print(token[1]);
      
      myList.add(list);
      //System.out.println(myList.get(count));
      //count++;
    }
    
    while(in2.hasNext()) {
      line = in2.nextLine();
      list = new ArrayList<String>();
      
      String token [] = line.split(",");
      
      //for(int i = 0; i<3; i++) {
        list.add(token[1]);
        //list.add(token[2]);
        //System.out.print(token[i]);
      //}
      
      myList.add(list);
      //System.out.println(myList.get(count));
      //count++;
    }
  }
  
  public static void sort(WeeklyQueue q, ArrayList<ArrayList<String>> myList) {
    /***Input: Takes in the object of Top_Artists, and 2D arraylist of Strings
      * 
      * Process: The method uses the bubble sorting method to sort through which
      * string of artists comes first alphabetically, then it places the 
      * string into a linked list.
      * 
      * Output: This method returns nothing.
    ***/

    String s1, sa, s2, sb, temp;
    char c1, c2;
    
      
    for(int i = 0; i<myList.size(); i++) {
      String a = myList.get(i).toString();
      String [] token = a.split(",");
      int toRemove = 0;
      s1 = token[0];
      //c1 = s1.charAt(0);
      //sa = Character.toString(c1);
      
      for(int j = i+1; j<myList.size(); j++) {
        String b = myList.get(j).toString();
        String [] token2 = b.split(",");
        s2 = token2[0];
        //c2 = s2.charAt(0);
        //sb = Character.toString(c2);
        
        if(s1.compareTo(s2) > 0) {
          //System.out.println(s1 + " is less than" + s2 + ".");
          temp = s1;
          s1 = s2;
          s2 = temp;
          toRemove = j;
          //must remove swapped item somehow to stop repetition
        }
        
        else if(s1.compareTo(s2) == 0) {
          //System.out.println(s1 + " and" + s2 + " are equal.");
        }
        
        else {
          //System.out.println(s1 + " is greater than" + s2 + ".");
        }
          
      }
      
      q.insert(s1);
      myList.remove(toRemove);
    }
  }
  
  public static void play(WeeklyQueue q, Stack myStack) {
    /***Input: Takes in the object of WeeklyQueue, and Stack, myStack
      * 
      * Process: The Queue will poll out it's top value and place it
      * in the stack. Then the stack will be able to keep track of 
      * which song was played last.
      * 
      * Output: This method returns nothing.
    ***/
    String answer;
    Scanner in = new Scanner(System.in);
    do {
      String song = q.getSong();
      System.out.println("Now Playing: " + song);
      
      myStack.push(song);
      
      System.out.println("...");
      System.out.println("Would you like to stop listening?");
      
      answer = in.nextLine();
      
    } while(answer.charAt(0) != 'y' && answer.charAt(0) != 'Y');
    
    System.out.println("Playlist stopped.");
    
    System.out.println("Would you like to check the Song History?");
    
    answer = in.nextLine();
    
    if(answer.charAt(0) == 'y' || answer.charAt(0) == 'Y') {
      songHistory(myStack);
    }
    
    in.close();
  }
  
  public static void songHistory(Stack myStack) {
    System.out.println("Previous Song: " + myStack.peek());
  }
}