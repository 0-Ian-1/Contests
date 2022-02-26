/*
USACO 2019 December Contest, Bronze
Problem 3. Livestock Lineup

SAMPLE INPUT:
3
Buttercup must be milked beside Bella
Blue must be milked beside Bella
Sue must be milked beside Beatrice
SAMPLE OUTPUT:
Beatrice
Sue
Belinda
Bessie
Betsy
Blue
Bella
Buttercup

(complete search also works)
*/

import java.util.*;
import java.io.*;
public class LivestockLineup {
    static String[] cow = { "Beatrice", "Belinda", "Bella", "Bessie", "Betsy", "Blue", "Buttercup", "Sue" };
    static int[][] in = new int[8][2];
    static boolean[] added = new boolean[8];
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("lineup.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("lineup.out")));
        int n = Integer.parseInt(br.readLine());
        Arrays.sort(cow);
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            String[] words = s.split(" ");  
            String a = words[0];
            String b = words[5];
            int ia = index(a);
            int ib = index(b);
            assign(ia, ib);
            assign(ib, ia);
        }

    }
    static int index(String s) {
        for (int i = 0; i < 8; i++) { 
            if (s.equals(cow[i])) return i;
        }
        return -1;
    }
    static void assign(int a, int b) {
        if (in[a][0] == 0) in[a][0] = b;
        else in[a][1] = b;
    }
    static boolean isValid(index i) {
        
    }
    static void permutation()
}
