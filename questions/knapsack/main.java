import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;import java.io.InputStreamReader;
class main
 {
     public static int K[][];
	public static void main (String[] args)
    {
        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int  W = 50;
        int n = val.length;
        knapSack(W, wt, val, n);
    }
    public static int max(int a, int b) { return (a > b)? a : b; }
    public static void knapSack(int W, int wt[], int val[], int n){
        K = new int[n+1][W+1];
        for (int i =0; i<= n; i++){
            for (int w = 0; w<=W; w++){
                if(i==0 || w == 0){
                    K[i][w] = 0;
            }else if(wt[i-1]<=w){
               K[i][w] = max(val[i-1]+K[i-1][w-wt[i-1]], K[i-1][w]); 
            }else{
            K[i][w] = K[i-1][w];
            }
        }
        
        }
    System.out.println(K[n][W]);
    } 

}
