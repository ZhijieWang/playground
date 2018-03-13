//Given two strings a and b print whether they contain any common subsequence (non empty) or not.
//
//Input:
//The first line contains an integer T denoting number of testcases. Each of the next T lines contains two strings a and b.
//
//Output:
//Print 1 if they have a common subsequence (non empty) else 0.
//
//Constraints:
//1<=T<=10^5
//1<= |a|=|b| <=30
//a and b consist of uppercase English letters ('A'....'Z')
//
//Example:
//Input:
//1
//ABEF CADE
//Output:
//1
//
//Explanation:
//AE is a subsequence of both the string so the answer is 1.
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
    public static void main (String[] args) throws IOException
    {
        //code
        int numCases;
        Reader scanner  = new Reader();
        numCases = scanner.nextInt();
        while (numCases>0){
            numCases--;
            String[] s = scanner.readLine().split(" ");
            boolean hasCommon = false;
            char[] a = s[0].toCharArray();
            char[] b = s[1].toCharArray();
            
            for (int i = 0 ; i < a.length; i++){
                for ( int j = 0; j < b.length; j++){
                    if (a[i]==b[j]){
                        hasCommon = true;
                        break;
                    }
                }
                if(hasCommon){
                    break;
                }
            }
            if (hasCommon){
                System.out.println(1);
            }else{
                System.out.println(0);
            }
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
