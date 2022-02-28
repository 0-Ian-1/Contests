/*
USACO 2016 February Contest, Bronze
Problem 2. Circular Barn

SAMPLE INPUT:
5
4
7
8
6
4
SAMPLE OUTPUT:
48
*/

import java.util.*;
import java.io.*;
public class CircularBarn {
    static int n;
    static int[] r;                                                     // LinkedList or Array? 
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cbarn.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cbarn.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        n = Integer.parseInt(st.nextToken());
        r = new int[n];
        for (int i = 0; i < n; i++)
        {
            r[i] = Integer.parseInt(br.readLine());
        }
        int minDis = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++)
        {
            minDis = Math.min(minDis, totalDis(i));
        }
        pw.println(minDis);
        pw.close();
    }

    public static int totalDis(int index)                               // simulate each starting position
    {
        int dis = 0; 
        int tdis = 0;
        for (int i = index; i < n; i++)
        {
            tdis += dis * r[i];
            dis++;
        }
        for (int i = 0; i < index; i++)
        {
            tdis += dis * r[i];
            dis++;
        }
        return tdis;
    }
}
