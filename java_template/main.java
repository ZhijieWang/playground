import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;import java.io.InputStreamReader;
class main
 {
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
