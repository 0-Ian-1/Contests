/*
USACO 2019 February Contest, Bronze
Problem 3. Measuring Traffic

SAMPLE INPUT:
4
on 1 1
none 10 14
none 11 15
off 2 3
SAMPLE OUTPUT:
10 13
8 12

submission
1   09/10
*/

import java.util.*;
import java.io.*;
public class MeasuringTraffic {
    static int max = -1; static int min = -1; 
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("traffic.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("traffic.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            if (s.equals("on")) a[i][0] = 0;
            else if (s.equals("none")) a[i][0] = 1;
            else a[i][0] = 2;
            a[i][1] = Integer.parseInt(st.nextToken());
            a[i][2] = Integer.parseInt(st.nextToken());
        }
        for (int i = n-1; i >= 0; i--) {
            while (max == -1) { 
                if (a[i][0] == 1) { max = a[i][2]; min = a[i][1]; }
                i--;
            }
            if (a[i][0] == 0) off(a[i][1], a[i][2]);
            else if (a[i][0] == 1) none(a[i][1], a[i][2]);
            else on(a[i][1], a[i][2]);
        }
        pw.println(min + " " + max);
        max = -1; min = -1;
        for (int i = 0; i < n; i++) {
            while (max == -1) { 
                if (a[i][0] == 1) { max = a[i][2]; min = a[i][1]; }
                i++;
            }
            if (a[i][0] == 0) on(a[i][1], a[i][2]);
            else if (a[i][0] == 1) none(a[i][1], a[i][2]);
            else off(a[i][1], a[i][2]);
        }
        pw.println(min + " " + max);
        pw.close();
    }

    static void on(int a, int b) {
        min += a;
        max += b;
    }

    static void none(int a, int b) {
        min = Math.max(a, min);
        max = Math.min(b, max);
    }

    static void off(int a, int b) {
        min -= b;
        max -= a;
    }
}
