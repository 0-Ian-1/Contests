/*
USACO 2019 US Open Contest, Bronze
Problem 2. Milk Factory
*/

import java.util.*;
import java.io.*;
public class MilkFactory {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("factory.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("factory.out")));
        int n = Integer.parseInt(br.readLine());
        int[] innei = new int[n];
        int[] outnei = new int[n];
        for (int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            outnei[a]++;
            innei[b]++;
        }
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (outnei[i] == 0 && index != -1) { index = -2; break; } 
            if (outnei[i] == 0) index = i;
        }
        pw.println(index+1);
        pw.close();
    }
}

