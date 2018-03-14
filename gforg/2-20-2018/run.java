//Given an array of N elements, you are required to find the sumimum count of lengths of all non-overlapping subarrays with K as the maximum element in the subarray.
// in easier to understand english, find all non-overlapping subarrays, count their lengths
//Input:
//First line of the input contains an integer T, denoting the number of the total test cases. Then T test case follows. First line of the test case contains an integer N, denoting the number of elements in the array. Then next line contains N space separated integers denoting the elements of the array. The last line of each test case contains an integer K.
//
//Output:
//For each test case ouptut a single line denoting the count of the length of all such subarrays.
//
//Constraints:
//1<=T<=100
//1<=N<=105
//1<=A[]<=105
//
//Example:
//Input:
//3
//9 
//2 1 4 9 2 3 8 3 4
//4
//7
//1 2 3 2 3 4 1
//4
//10
//4 5 7 1 2 9 8 4 3 1
//4
//Output:
//5
//7
//4
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
        while (numCases > 0){
            numCases --;
            int numElements = scanner.nextInt();
            int[] input = new int[numElements];
            for (int i = 0; i<numElements; i++){
                input[i] = scanner.nextInt();
            }
            int k = scanner.nextInt();
            int count = 0;
            int sum = count;
            boolean encounter = false;
            for (int i = 0; i<numElements; i++){
                if (input[i]<k){
                    count ++;
                }else if (input[i]==k){
                    encounter = true;
                    count++;
                }else{
                    if(encounter){
                        encounter = false;
                        sum += count;
                        count = 0;
                    }else{
                        count = 0;
                    }
                }
            } 
            if (encounter){
                sum +=count;
            }
            System.out.println(sum);
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
