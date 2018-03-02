import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;

class run 
 {
    public static boolean debug = false;
    public static void println(Object o){
        if (debug){
            System.out.println(o.toString());
        }
    }
     public static void main (String[] args)
	 {
	 //code
     String input = "";
      BufferedReader br = null;
      try{  
        br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();
      } catch (IOException e){
        e.printStackTrace();
      }
      System.out.println("Hi");
      System.out.println(input);
	 }
}
