//Geek has an array Arr, where Arr[i] (1-based indexing) denotes the number of chocolates corresponding to each station. When he move from station i to station i+1 he get A[i] - A[i+1] chocolates for free, if this number is negative, he looses that many chocolates also.
//He can only move from station i to station i+1, if he has non-negative number of chocolates with him.
//Given the cost of one chocolate is Rs. P, help geek to find the minimum cost incurred in reaching last station from the first station (station 1).
//Note: Initially Geek has 0 chocolate.
//
//Input:
//The first line of the input contains an integer T, denoting the number of Test cases. Then T test case follows. The first line of each test case contains an integer N, denoting the total number of stations. Then next line contains N space separated integers denoting the elements of the array. The next line contains an integer P denoting the cost of a chocolate.
//
//Output:
//For each test case output a single line containing an integer denoting the total minimum cost ncurred in reaching last station from the first station.
//
//Constraints:
//1<=T<=103
//1<=N<=105
//0<=A[i]<=105
//0<=P<=100
//
//Example:
//Input:
//2
//3
//1 2 3
//10
//6
//10 6 11 4 7 1
//5
//Output:
//30
//55
//Explanation:
//Test Case 1:
//To reach the first station from the starting point, we need to buy 1 chocolate,
//To reach station 2 form station 1, we get A[1] - A[2] = -1 chocolates i.e. we lose 1 chocolate. Hence, we need to buy 1 chocolate.
//Similarly, we need to buy 1 chocolate to reach station 3 from station 2.
//   Hence, total cost incurred = (1+1+1)*10 = 30
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
    public static void main (String[] args) throws IOException
    {
        //code
        int numCases;
        Reader scanner  = new Reader();
        numCases = scanner.nextInt();
        int numElements;
        while(numCases>0){
            numCases --;
            int hold = 0;
            int next;
            numElements = scanner.nextInt();
            while(numElements >0){     
                numElements --;                
                next = scanner.nextInt();
                // check how many we will have
                // and if we need to buy
                if ( hold < next ){
                    hold = next;
                }
            }
        System.out.println(hold*scanner.nextInt());
        }
        scanner.close();
    }
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
