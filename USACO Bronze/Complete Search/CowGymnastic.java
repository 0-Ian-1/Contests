/*
USACO 2019 December Contest, Bronze
Problem 1. Cow Gymnastics

submission
1   10/10
*/
import java.io.*;
import java.util.*;
public class CowGymnastic {
    static int[][] p;
    static int k; 
    static int n;
    public static void main(String args[]) throws Exception {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("gymnastics.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("gymnastics.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        p = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                p[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                int one = p[0][i]; int two = p[0][j];           // one > two always
                if (consistent(one, two)) count++;
            }
        }
        pw.println(count);
        pw.close();
    }

    /**
     * for every pair of cows, loop through the matrix and find their location. 
     * if one cow is always greater then the other one, count++.
     * @param a
     * @param b
     * @return
     */
    public static boolean consistent(int a, int b) {
        for (int i = 0; i < k; i++) {                           // for every row, 
            for (int j = 0; j < n-1; j++) {                     // for every cow, 
                for (int k = j; k < n; k++) {                   // for every other cow ranked lower than this
                    if (p[i][j] == b && p[i][k] == a) return false;
                }
            }
        }
        return true;
    } 
}
