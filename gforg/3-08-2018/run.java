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
        for (; numCases>0; numCases--){
            int m, n, k;
            m = scanner.nextInt();
            n = scanner.nextInt();
            k = scanner.nextInt();
            int[][] matrix = new int[m][n];
            for (int i = 0; i < m*n; i++){
                //println("row :"+i/n +" col: " + i%m);
                matrix[i/n][i%n]=scanner.nextInt();
            }
            k = k%n;
            for (int i = 0; i < m*n; i++){
                System.out.print(matrix[i/n][(i+k)%n] +" ");
            }
            System.out.println();
           }
        
        scanner.close();
    }
}
