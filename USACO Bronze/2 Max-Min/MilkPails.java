/*
USACO 2016 February Contest, Bronze
Problem 1. Milk Pails
*/
import java.util.*;
import java.io.*;

public class MilkPails {

    public static int simulation(int x, int y, int m)
    {
        int max = 0;
        int count;
        for (int i = 0; i*x <= m; i++)
        {
            for (int j = 0; j*y <= m-i*x; j++)
            {
                count = i*x + j*y;
                if (count > max) max = count; // or, max = Math.max(max, count);
            }
        }
        return max;
    }
    public static void main(String args[]) throws IOException
    {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader("pails.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("pails.out")));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // System.out.println(simulation(x, y, m));
        pw.println(simulation(x, y, m));
        pw.close();
    }
    
}
