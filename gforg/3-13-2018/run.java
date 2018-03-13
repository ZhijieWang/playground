//Given an array containing equal number of positive and negative elements, arrange the array such that every positive element is followed by a negative element.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//Output:
//For each test case, in a new line print the arranged array.
//
//Constraints:
//1<=T<=300
//2<=N<=105
//-105<=A[i]<=105
//
//Example:
//Input:
//2
//6
//-1 2 -3 4 -5 6
//4
//-3 2 -4 1
//Output:
//2 -1 4 -3 6 -5
//2 -3 1 -4
//import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

class run 
{
    public static boolean debug = false;
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
            numCases--;
            numElements = scanner.nextInt();
            LinkedList<Integer> negatives = new LinkedList<Integer>();
            LinkedList<Integer> positives = new LinkedList<Integer>();
            int hold;
            for (int i = 0; i < numElements; i++){
                hold = scanner.nextInt();
                if (hold>0){
                    positives.add(hold);
                }else{
                    negatives.add(hold);
                }
            }
            while(numElements >0){
                numElements = numElements- 2;
            //    System.out.println(numElements);
                System.out.print(positives.remove(0));
                System.out.print(" ");
                System.out.print(negatives.remove(0));
                System.out.print(" ");
            }
            System.out.println();
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
