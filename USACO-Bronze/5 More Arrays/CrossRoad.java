/*
USACO 2017 February Contest, Bronze
Problem 1. Why Did the Cow Cross the Road

SAMPLE INPUT:
8
3 1
3 0
6 0
2 1
4 1
3 0
4 0
3 1
SAMPLE OUTPUT:
3
*/

import java.io.*;
import java.util.*;
public class CrossRoad {
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("crossroad.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("crossroad.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        int n = Integer.parseInt(st.nextToken());
        int[] cows = new int[11];                                       // array to keep track of location of each cow 1-10. 
        int count = 0; 
        for (int i = 0; i < n; i++)                                     // index number indicates cow's ID number, quick access
        {                                                               // the value of array will either be 0 or 1. 
            st = new StringTokenizer(br.readLine());                    
            int id = Integer.parseInt(st.nextToken());
            int location = Integer.parseInt(st.nextToken()) + 1;        // initially all entries of cows is 0, unvisited. after visited, location will be 1 or 2.
            if (cows[id] == 0) cows[id] = location;                     // if first spotting a cow, record its location
            else                                                        // otherwise, if location changes count++, update location. 
            {
                if (location != cows[id])
                {
                    cows[id] = location;
                    count++;
                }
            }
        } 
        pw.println(count);
        pw.close();
    }
}
