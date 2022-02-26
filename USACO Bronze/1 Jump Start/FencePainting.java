/*
 * USACO 2015 December Contest, Bronze
 * Problem 1. Fence Painting
 * 
 */
import java.util.*;
import java.io.*;

public class FencePainting
{
    static int a, b, c, d;

    // simulation
    public static int findLength()
    {
        boolean[] isPainted = new boolean[100];
        int count = 0;
        for (int i = a; i < b; i++) { isPainted[i] = true; }
        for (int i = c; i < d; i++) { isPainted[i] = true; }
        for (int i = 0; i < 100; i++) { 
            if (isPainted[i]) count++; 
        }
        return count;
    }

    public static int getLength()
    {
        if (a > c) { int x = a; a = c; c = x; x = b; b = d; d = x; }
        int count = b - a + d - c;
        if (c < b) return Math.max(b, d) - a;
        return count;
    }

    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("paint.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("paint.out")));
        StringTokenizer st = new StringTokenizer(br.readLine()); // 7 10
        a = Integer.parseInt(st.nextToken());                    // 7
        b = Integer.parseInt(st.nextToken());                    // 10
        st = new StringTokenizer(br.readLine());                 // 4 8
        c = Integer.parseInt(st.nextToken());                    // 4
        d = Integer.parseInt(st.nextToken());                    // 8

        int length = findLength();
        int fence = getLength();
        // System.out.println(length + " " + fence);
        pw.println(length);
        pw.close();
    }
}