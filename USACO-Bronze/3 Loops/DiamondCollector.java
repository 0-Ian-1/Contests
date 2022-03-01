/*
USACO 2016 US Open Contest, Bronze
Problem 1. Diamond Collector

SAMPLE INPUT:
5 3
1
6
4
3
1
SAMPLE OUTPUT:
4
 */

import java.util.*;
import java.io.*;

public class DiamondCollector {
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("diamond.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("diamond.out")));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 5, 3
        int size = Integer.parseInt(st.nextToken());             // 5
        int k = Integer.parseInt(st.nextToken());                // 3
        int[] diamonds = new int[size];                          // size of 5
        for (int i = 0; i < size; i++)
        {
            diamonds[i] = Integer.parseInt(br.readLine());       // diamond size
        }
        // System.out.println(bruteForceMax(diamonds, k));
        pw.println(bruteForceMax(diamonds, k));
        pw.close();
        Arrays.sort(diamonds);                                   // sort the array for later use. 
    }

    // brute force algorithm O(n*n)
    public static int bruteForceMax(int[] arr, int k)
    {
        int max = 0; 
        for (int i = 0; i < arr.length; i++)
        {
            int count = 0; 
            for (int j = 0; j < arr.length; j++)
            {
                if (arr[j] <= arr[i] + k && arr[j] >= arr[i]) count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    // divide and conquer on maximum count O(nlgn).
    // take sorted array as input
    // max(findMax diamond.left findMax diamond.right)
    // find max in between, taking n time? - start from diamond.left[lo] to diamond.left[hi-max]
    // another index at diamond.right[max+1] and increament if diamond[max+2] = diamond[max+1] until hi

    /*
    public static int findMax(int[] arr, int k, int lo, int hi)
    {
        if (arr[hi] - arr[lo] <= k) return hi-lo;
        else
        {
            int mid = (hi-lo) / 2;
            int max = Math.max(findMax(arr, k, lo, mid), findMax(arr, k, mid, hi));
            int low = lo; 
            int high = max + 1;
            int count = 0
            while(high < hi && low < mid-max)
            {
                while (high < hi && arr[high+1] == arr[high])
                {
                    high++;                                 // get to the last duplicate element.
                }
                while (low < mid-max && arr[low+1] == arr[low])
                {
                    low++;
                }
                if (high - low == k)
            }
        }
        */
    }
}
