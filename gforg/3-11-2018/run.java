//Given an unsorted array. The task is to find all the star and super star elements in the array. Star are those elements which are strictly greater than all the elements on its right side. Super star are those elements which are strictly greater than all the elements on its left and right side.
//
//Note: Assume first element (A[0]) is greater than all the elements on its left side, And last element (A[n-1]) is greater than all the elements on its right side.
//
//Input:
//The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. First line of each test case contains an Integer N denoting size of array and the second line contains N space separated elements.
//
//Output:
//For each test case, print the space separated star elements and then in new line print super star elements. If no super star element present in array then print "-1".
//
//Constraints:
//1<=T<=200
//1<=N<=106
//1<=A[i]<=106
//
//Example:
//Input:
//2
//6
//4 2 5 7 2 1
//3
//8 6 5
//
//Output:
//7 2 1
//7
//8 6 5
//8
import java.util.*;
import java.io.IOException;
import java.lang.*;
import java.io.*;
import java.io.InputStreamReader;
import java.util.Arrays;

class run 
{
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
        while (numCases >0){
            numCases--;
            int numElements = scanner.nextInt();
            int[] elements = new int[numElements];
            for (int i = 0; i < numElements; i++){
                elements[i] = scanner.nextInt();
            }
            Stack<Integer> star = new Stack<Integer>();
            // adding the right most one to the star stack
            int current = Integer.MIN_VALUE;
            // star.push(current);
            int index = numElements-1;
            int superStar = -1;
            while(index>=0){
                if (elements[index]> current){
                    star.push(elements[index]);
                    current = elements[index];
                    superStar = current;
                }else if (elements[index]==current){
                    superStar = -1;
                }
                index--;
            }
            String output = "";
            
            Integer[] result = new Integer[star.size()];
            for(int i = 0; i < result.length; ++i){
                result[i] = star.pop();
            }
            //     output = output + " " + star.pop();
            // }
            for (Integer s: result){
                System.out.print(s);
                System.out.print(" ");
            }
            System.out.println();
            // System.out.println(output.substring(1)); 
            System.out.println(superStar);
            //System.out.println(star);
            //System.out.println(elements[result]);
        }
        scanner.close();
    }
    public static int checkSuperStar(int[] elements, int index){
        if (index==0){
            return 0;
        }
        // search through the left half of the array
        // if there is anything greater thani or equal to the start (referenced by index)
        // note it down
        for(int i = index-1; i >=0; i --){
            if (elements[i]>= elements[index]){
                return i;
            }
        }
        return index;

    }
}
