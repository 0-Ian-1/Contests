/*
USACO 2019 February Contest, Bronze
Problem 1. Sleepy Cow Herding

SAMPLE INPUT:
4 7 9
SAMPLE OUTPUT:
1
2

submission
1   09/10   did not consider if the initial positions of the cow satisfies the conditions.
2   10/10
*/

import java.util.*;
import java.io.*;
public class SleepyCowHerding {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("herding.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("herding.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] a = new int[3];
        for (int i = 0; i < 3; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a);
        int max = Math.max(a[1]-a[0], a[2]-a[1]) - 1;
        int min;
        if (a[1] - a[0] == 1 && a[2] - a[1] == 1) min = 0; 
        else if (a[1] - a[0] == 2 || a[2] - a[1] == 2) min = 1;
        else min = 2;
        pw.println(min);
        pw.println(max);
        pw.close();
    }
}
