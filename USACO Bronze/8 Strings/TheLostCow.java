import java.io.IOException;

/*
USACO 2017 US Open Contest, Bronze
Problem 1. The Lost Cow

SAMPLE INPUT:
3 6
SAMPLE OUTPUT:
9
*/

/**
 * This is a simulation and search problem
 * loop, 
 *  direction, first to right, then to left, then right, ...
 *  check the value within the range of search, to see if we find it
 *  range will be [x, x+step], where step doubles each time. 
 * sample: 
 *  infinite loop: 
 *      search right (x, x+1); if not found, reverse direction, double step.
 *      search left (x, x-2); if not found, reverse direction, double step.
 *      search right, find the cow, break. 
 */
import java.util.*;
import java.io.*;
public class TheLostCow 
{
    public static void main(String args[]) throws IOException
    {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("lostcow.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lostcow.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        y = y - x;
        x = 0;
        if (y > x)
        {
            int count = 1; int dis = 1;
            while (y > dis) 
            {
                count++;
                dis = dis * -2;
            }
            int d = tdis(count) - (dis - y);
            pw.println(d);
        }
        else
        {
            int count = 1; int dis = 1;
            while (y < dis) 
            {
                count++;
                dis = dis * -2;
            }
            int d = tdis(count) - Math.abs(dis - y);
            pw.println(d);
        }
        pw.close();
    }

    public static int tdis(int x)
    {
        if (x == 1) return 1;
        else if (x == 2) return 4;
        else return tdis(x-1) + (int)Math.pow(2, x-2) + (int)Math.pow(2, x-1);
    }
    
    public static int dis(int x)
    {
        if (x == 1) return 1;
        else return dis(x-1) * 2;
    }
}
