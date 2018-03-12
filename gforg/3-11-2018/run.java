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
        while (numCases >0){
            numCases--;
            int numElements = scanner.nextInt();
            int[] elements = new int[numElements];
            for (int i = 0; i < numElements; i++){
                elements[i] = scanner.nextInt();
            }
            String star = ""+elements[numElements-1];
            int result = checkSuperStar(elements, numElements-1);
            int lastIndex = numElements;
            while(lastIndex != result){
                lastIndex= result;
                 star = elements[result] + " " + star;
                result = checkSuperStar(elements, lastIndex);
               // println(result);
            }
            System.out.println(star);
            System.out.println(elements[result]);
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
