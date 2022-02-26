/*
 * 
 * USACO 2018 January Contest, Bronze
 * Problem 1. Blocked Billboard II
 * 
 */
import java.util.*;
import java.io.*;

public class BlockBillboardII {
    static int cx1, cy1, cx2, cy2; 

    public static int areaBlocked(int ax1, int ay1, int ax2, int ay2)
    {
        if (cx1 >= ax2 || cx2 <= ax1 || cy1 >= ay2 || cy2 <= ay1) return 0;
        else 
        {
            int xlo = Math.max(ax1, cx1);
            int xhi = Math.min(ax2, cx2);
            int ylo = Math.max(ay1, cy1);
            int yhi = Math.min(ay2, cy2);
            return (xhi - xlo) * (yhi - ylo);
        }
    }

    public static int area(int ax1, int ay1, int ax2, int ay2)
    {
        return (ax2 - ax1) * (ay2 - ay1);
    }

    public static int minArea(int ax1, int ay1, int ax2, int ay2)
    {
        if ((ax1 >= cx1 && ax2 <= cx2) || (ay1 >= cy1 && ay2 <= cy2)) return (area(ax1, ay1, ax2, ay2) - areaBlocked(ax1, ay1, ax2, ay2));
        else return area(ax1, ay1, ax2, ay2);
    }

    public static void main(String args[]) throws IOException
    {
        // BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader bf = new BufferedReader(new FileReader("billboard.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("billboard.out")));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ax1 = Integer.parseInt(st.nextToken());
        int ay1 = Integer.parseInt(st.nextToken());
        int ax2 = Integer.parseInt(st.nextToken());
        int ay2 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        cx1 = Integer.parseInt(st.nextToken());
        cy1 = Integer.parseInt(st.nextToken());
        cx2 = Integer.parseInt(st.nextToken());
        cy2 = Integer.parseInt(st.nextToken());
        bf.close();

        // System.out.println(minArea(ax1, ay1, ax2, ay2));
        pw.println(minArea(ax1, ay1, ax2, ay2));
        pw.close();
    }
}
