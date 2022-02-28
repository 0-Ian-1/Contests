/*
USACO 2016 January Contest, Bronze
Problem 2. Angry Cows

SAMPLE INPUT:
6
8
5
6
13
3
4
SAMPLE OUTPUT:
5

submission
1
*/

import java.util.*;
import java.io.*;
public class AngryCows {
    static int n;
    static int[] p;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("measurement.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("measurement.out")));
        n = Integer.parseInt(br.readLine());
        p = new int[n];
        for (int i = 0; i < n; i++) { p[i] = Integer.parseInt(br.readLine()); }
        Arrays.sort(p);
        System.out.println(Arrays.toString(p));
        int max = 1; 
        for (int i = 0; i < n; i++) {   // start explosion at p[i]
            int r = 1;                  // explosion radius
            max = Math.max(max, (explode(i, r, 1)) - (explode(i, r, -1) + 1));
        }
        System.out.println(max);
    }
    /**
     * input starting index of explosion, then split the explosion into 
     * two streams – one going left and one going right.
     * @param i     explosion centers at index i.
     * @param r 
     * @param dir   either +1 or -1, indicating going right or left
     * @return      index of last explosion
     */
    static int explode(int i, int r, int dir) {     
        int j = i + dir;
        while (j >= 0 && j < n && Math.abs(p[j]-p[i]) <= r) {
            j += dir;
        }
        if (i == j) return j; 
        else { r++; return explode(j, r, dir); }
    }
}
