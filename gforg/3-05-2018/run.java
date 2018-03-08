//Given two integers 'L' and 'R', write a program that finds the count of numbers having prime number of set bits in their binary representation in the range [L, R].
//
//Input:
//The first line consists of an integer T i.e number of test cases. The first and only line of each test case consists of two integers L and R. 
//
//Output:
//Print the required output.
//
//Constraints: 
//1<=T<=100
//1<=L<=R<=100000
//
//Example:
//Input:
//2
//6 10
//10 15 
//
//Output:
//4
//5
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
    public static void main (String[] args){
        //code
        int numCases, L, R;
        Scanner scanner  = new Scanner(System.in);
        numCases = scanner.nextInt();
        List<Integer> primes = Arrays.asList( 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31);
        for (; numCases>0; numCases --){
            L = scanner.nextInt(); 
            R = scanner.nextInt();
            int counter  = 0;
            for(int i =L; i <=R; i++){
               if (primes.contains(countBits(i))) {
                   println( " int "+i +" , bits "+countBits(i));
                   counter ++;
               }
            }
            System.out.println(counter);
        }
        scanner.close();
    }
    public static int countBits(int a){
        int counter = 0;
        while(a >0){
            a&=(a-1);
            counter++;
        }
        return counter;
    }
}
