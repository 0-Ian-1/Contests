import java.io.IOException;

/*
USACO 2017 February Contest, Bronze
Problem 3. Why Did the Cow Cross the Road III

SAMPLE INPUT:
3
2 1
8 3
5 7
SAMPLE OUTPUT:
15
*/

import java.util.*;
import java.io.*;
public class CrossRoadIII {
    public static void main(String args[]) throws IOException
    {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("cowqueue.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("cowqueue.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        int n = Integer.parseInt(st.nextToken());
        int[][] cowqueue = new int[n][2];                                    // cow queue n, cowqueue[i][0] indicates when the cow came, 
        for (int i = 0; i < n; i++)                                          // cowqueue[i][1] indicates how long that cow takes
        {
            st = new StringTokenizer(br.readLine());
            cowqueue[i][0] = Integer.parseInt(st.nextToken());
            cowqueue[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cowqueue, new Comparator<int[]>() {                     // sorted arrival time using comparator
            public int compare(int[] a, int[] b) {                          // an alternative is to use a static class and implement to Comparable.
                return Integer.compare(a[0], b[0]);                         // static classs are faster
            }
        });
        /**
         * static class Cow implements Comparator<Cow> {
         *  int s, f; 
         *  public Cow(int start, int finish) {s = start; f = finish}
         *  public int compareTo(Cow that) { return s - that.s; }
         * }
         * cows[i] = new Cow(s, f);
         * Arrays.sort(cows);
         */
        int totalTime = 0; 
        for (int i = 0; i < n; i++)
        {
            if (totalTime < cowqueue[i][0]) totalTime = cowqueue[i][0] + cowqueue[i][1];
            else totalTime += cowqueue[i][1];
        }
        pw.println(totalTime);
        pw.close();
    }
}
