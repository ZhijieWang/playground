
//Given a decimal number m. Convert it in binary string and apply n iterations, in each iteration 0 becomes 01 and 1 becomes 10. Find kth character in the string after nth iteration.

//Input:
//The first line consists of an integer T i.e number of test cases. The first and only line of each test case consists of three integers m,k,n. 
//
//Output:
//Print the required output.
//
//Constraints: 
//1<=T<=100
//1<=m<=50
//1<=n<=10
//0<=k<=|Length of final string|
//
//Example:
//Input:
//2
//5 5 3
//11 6 4
//
//Output:
//1
//1
import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;

class run 
{
    public static boolean debug = true;
    public static void println(Object o){
        if (debug){
            System.out.println(o.toString());
        }
    }
    public static void main (String[] args)
    {
        //code
        int numCases;
        Scanner scanner  = new Scanner(System.in);
        numCases = scanner.nextInt();
        scanner.nextLine();
        int m, n , k;
        // m is less or equal to 50, can be represented in 6 bits
        // kth bit after n iteration (expanding list length by 2 each iteration)
        // 3th bit after 1 transformation is linked to 2nd bit of original number
        // 3th bit after 2 transformation is linked to 1st bit of original number
        // 5th bit after 2 transformation is linked to 2nd
        for (; numCases>0; numCases--){
            m = scanner.nextInt();
            k = scanner.nextInt();
            n = scanner.nextInt();
            // figure out which original bit affected the number
            // get the ith bit
            System.out.println(findBit(m, n, k));
        }
        scanner.close();
    }
    public static int countBit(int m){
        int counter = 0;
        while(m >0){
             m = m >>1;
             counter++;
        }
        return counter;}
    public static int findBit(int m, int n, int k){
        int counter = 0;
        while(n>0){
            if( (k&1)>0){
                counter ++;
            }
            k /= 2;
            n--;
        }
        m = 1&( m>>(countBit(m)-k-1));
           if ((counter&1) >0){
               return m^1;
           }
           else{
               return m;
           }
    }
//    public static int findBit(int m, int n, int k){
//        int i  = k / (int)Math.pow(2,n) ;
//        println(i+"th bit"); 
//        int remainder = k%((int) Math.pow(2, n));
//        println("Remainder "+remainder);
//
//        int b = 2&(m >>(countBit(m) - 1 -i));
//        println(i+"th bit is "+b);
//        while(n>0){
//            if((remainder %2)>0){
//                println("Reaminder " + remainder+"flip");
//                b = b^1;
//            }
//            remainder /=2;
//            n--;
//        }
//        return b;
//
//
//    }
}
