/*
USACO 2016 February Contest, Silver
Problem 2. Load Balancing

SAMPLE INPUT:
7
7 3
5 5
7 13
3 1
11 7
5 3
9 1
SAMPLE OUTPUT:
2
*/

/**
 * Initial Idea: Sort Array of Cows, start y = b in between Y[0] and Y[1]
 * start x = a in between X[0] and X[1] and increment between 
 * each row and column of Y. 
 * idealy keep track of number of cows in each region in O(1)
 * this can be done because everytime a increment we add one column
 * of new points, adding that many points to quadrant 2; 
 * each time increment y, add one to quadrant 4 and remove one from
 * quadrant 2. Q3 = n - Q1 - Q2 - Q4.
 * 
 * this is called a line sweep, use nested loops to sweep from X.lo to X.hi, 
 * Y.lo to Y.hi.
 * 
 * 2D graph problem, use array int[] x and int[] y to store all the x and y values. 
 * go through (nested loop) the arrays WITHOUT SORTING THEM and put y = b and x = a 
 * at b = y[j] + 1 and a = x[i] + 1 and find the optimal solution. 
 */
import java.util.*;
import java.io.*;
public class LoadBalancing {
    static int n;
    static Cow[] X;
    static Cow[] Y;
    static class Cow implements Comparable<Cow> {                       // in the standard solution this is useless. Two int arrays are sufficient.
        int x, y;
        public Cow(int xcor, int ycor) {
            x = xcor; 
            y = ycor;
        }
        public int compareTo(Cow that) {
            return this.x - that.x;
        }
    }
    public static void main(String args[]) throws IOException {
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("balancing.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("balancing.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        n = Integer.parseInt(st.nextToken());
        X = new Cow[n];
        Y = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            X[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Y[i] = X[i];
        }
        Arrays.sort(X);                                                 // no need to sort
        Arrays.sort(X, new Comparator<Cow>() {
            public int compare(Cow one, Cow two) {
                return one.y - two.y;
            }
        });

        int a, b;                                                       // line sweep
        int M = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a = X[i].x + 1;
                b = Y[j].y + 1;
                int c1 = 0; int c2 = 0; int c3 = 0; int c4 = 0;
                for (int k = 0; k < n; k++) {
                    if (X[k].x > a && X[k].y > b) c1++;
                    else if (X[k].x < a && X[k].y > b) c2++;
                    else if (X[k].x < a && X[k].y < b) c3++;
                    else c4++;
                }
                M = Math.min(M, Math.max(Math.max(c1, c2), Math.max(c3, c4)));
            }
        }
        
        pw.println(M);
        pw.close();
    }
}
