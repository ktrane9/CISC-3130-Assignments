/*Class: CISC 3130
 * Section: TY9
 * EmplId: 23668586
 * Kohl Elie
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Assignment_1 {
  public static void main(String [] args) throws IOException {
    File read = new File("Top Global Songs.csv");
    //File read = new File("Top US Songs.csv");
    //File read = new File("trackList.csv");
    PrintWriter out = new PrintWriter("dataReport.csv");
    //PrintWriter out = new PrintWriter("dataReport.txt");
    Scanner in = new Scanner(read);
    ArrayList<ArrayList<String>> myList = new ArrayList<ArrayList<String>>();
    
    readTracks(read, in, myList); 
    
    Top_Artists top = new Top_Artists();
    
    printData(out, myList); 
    
    sort(top, myList); 
    
    printList(top, out);
    
    in.close();
    out.close();
  }
  
  public static void readTracks(File read, Scanner in, ArrayList<ArrayList<String>> myList) throws IOException {
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
    
    while(count<80) {
      line = in.nextLine();
      list = new ArrayList<String>();
      
      String token [] = line.split(",");
      
      for(int i = 0; i<token.length; i++) {
        list.add(token[i]);
        //System.out.print(token[i]);
      }
      
      myList.add(list);
      //System.out.println(myList.get(count));
      count++;
    }
    
    int amount = 1;
    for(int j = 0; j<myList.size(); j++) {
      
      String a = myList.get(j).toString();
      String [] token = a.split(",");
      
      for(int k = j+1; k<myList.size(); k++) {
        
        String b = myList.get(k).toString();
        String [] token2 = b.split(",");
      
        if(token[2].equals(token2[2])){
          myList.remove(k);
          amount++;
          k--;
        }
      }
      list = myList.get(j);
      list.add(Integer.toString(amount));
      myList.set(j, list);
      amount = 1;
    }
  }
  
  public static void printData(PrintWriter out, ArrayList<ArrayList<String>> myList) 
  throws IOException {
    /***Input: Takes in PrintWriter out, and 2D arraylist of Strings
      * 
      * Process: Prints out the items of an array using a for loop to cycle through
      * all stored arrays.
      * 
      * Output: This method returns nothing.
    ***/
    
    System.out.println("Position\t  Track Name \t Artist\t \tStreams \t\tURL");
    System.out.println("-------------------------------------------------" +
                       "----------------------------");
    
    for(int i = 0; i<myList.size(); i++) {
      
      System.out.println();
      System.out.print(myList.get(i).get(0));
      System.out.print("," + myList.get(i).get(1));
      System.out.print("," + myList.get(i).get(2));
      System.out.print("," + myList.get(i).get(3));
      System.out.print("," + myList.get(i).get(4));
      System.out.println();
      
      out.println();
      out.print(myList.get(i).get(0));
      out.print("," + myList.get(i).get(1));
      out.print("," + myList.get(i).get(2));
      out.print("," + myList.get(i).get(3));
      out.print("," + myList.get(i).get(4));
      out.println();
    }
  }
  
  public static void sort(Top_Artists top, ArrayList<ArrayList<String>> myList) {
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
      s1 = token[2];
      //c1 = s1.charAt(0);
      //sa = Character.toString(c1);
      
      for(int j = i+1; j<myList.size(); j++) {
        String b = myList.get(j).toString();
        String [] token2 = b.split(",");
        s2 = token2[2];
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
        
      Artist artist = new Artist(s1);
      top.insert(artist);
      myList.remove(toRemove);
    }
  }
  
  public static void printList(Top_Artists top, PrintWriter out) {
    /***Input: Takes in the object of Top_Artists, and 2D arraylist of Strings
      * 
      * Process: Prints out the top 10 items in the linked list that is stored in 
      * the Top_Artist object, top.
      * 
      * Output: This method returns nothing.
    ***/
    
    String artist;
    System.out.println();
    System.out.println("Top 10 Artists");
    System.out.println("-----------------");
    
    out.println();
    out.println("Top 10 Artists");
    out.println("-----------------");
    for(int i = 0; i<10; i++) {
      Artist name = top.getArt(i);
      System.out.println(name.display());
      out.println(name.display());
    }
  }
}