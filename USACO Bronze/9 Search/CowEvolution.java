/*
USACO 2019 US Open Contest, Bronze
Problem 3. Cow Evolution
*/

/**
 * analysis: it is easier to find out when the tree is not proper. 
 * the two ways a cow can have some trait is that he either developed
 * it or he inherited from his parents. hence if a cow has the traits 
 * A and B and there exists two other cows that has trait A only and
 * trait B only, then the tree can not be a proper tree. an example 
 * of a improper tree looks will be: 
 *                          root
 *                          /  \
 *                         /    \
 *                        A      B
 *                              / \
 *                             /   \
 *                          A&&B   B&&C
 * where the child of trait B has trait A ("A&&B") as well. 
 */
import java.util.*;
import java.io.*;
public class CowEvolution {
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("evolution.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("evolution.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        // if cow i has trait j, e[i,j] = true
        boolean[][] e = new boolean[n][26];
        // match trait to a number
        String[] t = new String[26];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                String s = st.nextToken();
                for (int m = 0; m < 26; m++) {
                    if (t[m] == null) { t[m] = s; e[i][m] = true; break; }
                    else if (t[m].equals(s)) { e[i][m] = true; break; }
                }
            }
        }
        boolean cross = false; 
        // three cows and two traits.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int p = 0; p < 26; p++) {
                        for (int q = 0; q < 26; q++) {
                            if ((e[i][p] && !e[i][q]) && (e[j][q] && !e[j][p]) && (e[k][p] && e[k][q])) { cross = true; break; }
                        }
                    }
                }
            }
        }
        if (!cross) pw.println("yes");
        else pw.println("no");
        pw.close();
    }
}
