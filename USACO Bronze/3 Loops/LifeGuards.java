/*
USACO 2018 January Contest, Bronze
Problem 2. Lifeguards

SAMPLE INPUT:
3
5 9
1 4
3 7
SAMPLE OUTPUT:
7

 */

import java.util.*;
import java.io.*;

public class LifeGuards {

    static int[][] intervals;
    static int n; 
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lifeguards.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lifeguards.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());           // n, number of lifeguards
        intervals = new int[n][2];
        for (int i = 0; i < n; i++)
        {
            st = new StringTokenizer(br.readLine());       // read each line
            int a = Integer.parseInt(st.nextToken());                        // starting point
            int b = Integer.parseInt(st.nextToken());                        // ending point
            intervals[i][0] = a;                           // assign a, b to intervals
            intervals[i][1] = b;
        }

        int max = 0;
        for (int i = 0; i < n; i++)
        {
            max = Math.max(max, removedInterval(i));
        }
        pw.println(max);
        pw.close();
    }

    // remove i calculates the remaining hours? 

    // create a n * 1000 matrix??

    // brute force search: remove one at a time and count. 
    // time reduced = time that interval is by itself. 
    // if there exists some interval overlay, find time reduced to remove that interval compared to the smallest interval
    // -- this should return 0 if two intervals completely overlay each other
    // otherwise remove the smallest interval? 

    // brute force simulation
    public static int removedInterval(int index)
    {
        boolean[] isCovered = new boolean[1000];           // keep track of whether one time block is covered
        int count = 0;
        for (int i = 0; i < n; i++)
        {
            if (i != index)
            {
                int a = intervals[i][0];                   // start of interval
                int b = intervals[i][1];                   // end of interval
                for (int j = a; j < b; j++)                // have the boolean value under this interval equal true, increment count
                {
                    if (! isCovered[j])
                    {
                        isCovered[j] = true;
                        count++; 
                    }
                }
            }
        }
        return count;
    }

}
