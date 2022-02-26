/*
USACO 2019 January Contest, Silver
Problem 1. Grass Planting

SAMPLE INPUT:
4
1 2
4 3
2 3
SAMPLE OUTPUT:
3

submission
1   10/10
*/

import java.util.*;
import java.io.*;
public class GrassPlanting {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("planting.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("planting.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] neighbour = new int[n];
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            neighbour[a]++;
            neighbour[b]++;
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(neighbour[i], max);
        }
        pw.println(max+1);
        pw.close();
    }
}
