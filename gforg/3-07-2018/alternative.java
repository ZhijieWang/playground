import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
	    Scanner sc = new Scanner(System.in);
	    int not = sc.nextInt();
	    while(not-- != 0){
	        int num = sc.nextInt();
	        int pos = sc.nextInt();
	        int it = sc.nextInt();
	        
	        int binaryval = 0;
	        int mul = 1;
	        while(num != 0){
	            int rem = num % 2;
	            binaryval += rem * mul;
	            mul *= 10;
	            num /= 2;
	        }
	        String numString = String.valueOf(binaryval);
	        for(int j=0;j<it;j++){
	            String tempString = "";
    	        for(int i=0;i<numString.length();i++){
    	            if(i>pos)break;
    	            if(numString.charAt(i)=='0'){
    	                tempString = tempString + "01";
    	                //sb.append(001);
    	            }
    	            else{
    	                tempString = tempString + "10";
    	                //sb.append(110);
    	            }
    	        }
    	        numString = tempString;
	        }
	        System.out.println(numString.charAt(pos));
	    }
	}
}
