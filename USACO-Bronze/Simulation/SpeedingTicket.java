/*
USACO 2015 December Contest, Bronze
Problem 2. Speeding Ticket

SAMPLE INPUT:
3 3
40 75
50 35
10 45
40 76
20 30
40 40
SAMPLE OUTPUT:
5

Submission: 
1   10/10
 */

import java.util.*;
import java.io.*;
public class SpeedingTicket {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("speeding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("speeding.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lim = new int[100];
        int[] cow = new int[100];
        int it = 0; 
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int hi = it + s;
            while (it < hi) {
                lim[it] = l;
                it++;
            }
        }
        it = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int hi = it + s;
            while (it < hi) {
                cow[it] = l;
                it++;
            }
        }
        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (cow[i] - lim[i] > max) max = cow[i] - lim[i]; 
        }
        pw.println(max);
        pw.close();
    }
}
