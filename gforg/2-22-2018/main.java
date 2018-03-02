//Rahul and Ankit are the only two waiters in Royal Restaurant. Today, the restaurant received N orders. The amount of tips may differ when handled by different waiters, if Rahul takes the ith order, he would be tipped Ai rupees and if Ankit takes this order, the tip would be Bi rupees.
//In order to maximize the total tip value they decided to distribute the order among themselves. One order will be handled by one person only. Also, due to time constraints Rahul cannot take more than X orders and Ankit cannot take more than Y orders. It is guaranteed that X + Y is greater than or equal to N, which means that all the orders can be handled by either Rahul or Ankit. Find out the maximum possible amount of total tip money after processing all the orders.
//
//Input:
//
//    The first line contains one integer, number of test cases.
//    The second line contains three integers N, X, Y.
//    The third line contains N integers. The ith integer represents Ai.
//    The fourth line contains N integers. The ith integer represents Bi.
//
//Output:
//Print a single integer representing the maximum tip money they would receive.
//
//Constraints:
//1 <= N <= 105
//1 <= X, Y <= N; X + Y >= N
//1 <= Ai, Bi <= 104
//
//Example:
//
//Input:
//
//2
//5 3 3
//1 2 3 4 5
//5 4 3 2 1
//8 4 4
//1 4 3 2 7 5 9 6 
//1 2 3 6 5 4 9 8

//Output:
//21
//43
import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.util.stream.*;
import java.io.InputStreamReader;
import java.util.Arrays;
class main
{
    public static void main (String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        int numCases = scanner.nextInt();
        for (; numCases>0; numCases--){
            int numElements = scanner.nextInt();
            int X = scanner.nextInt();
            int Y = scanner.nextInt();
            int maxTip = 0;
            scanner.nextLine();
            int[] A = Arrays.copyOfRange(Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, numElements);
            int[] B = Arrays.copyOfRange(Stream.of(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(), 0, numElements);
          // A take all the jobs
          // if A < N then B have to take at least N-A jobs, 
          // but no more than B that B is better than A or some jobs that B is not as good as A, but with least lost
          // Given A + B >= N
          // this will make all jobs
            int[] diff = IntStream.range(0, A.length).map(i-> A[i]-B[i]).sorted().toArray();
            maxTip = IntStream.of(A).sum();
            // adding required jobs to make sure all N jobs can be handled
            int start = 0;
            for (; start< (numElements-X); start++){
                maxTip -= diff[start];
            }
            //System.out.println(maxTip);
            // now add the optional jobs that B can help optimize
            if (diff[numElements-start]<0){
            // B can help do better than A
                for (; start < Y; start++){
                    if (diff[start] >0){
                        maxTip-=diff[start];
                    }else{
                        break;
                    }
                }
           }
        }
        scanner.close();
    }
}
