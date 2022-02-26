/*
USACO 2016 US Open Contest, Bronze
Problem 3. Field Reduction

SAMPLE INPUT:
4
2 4
1 1
5 2
17 25
SAMPLE OUTPUT:
12
*/

/**
 * Initial Solution: 
 *  create class Cow(int x, int y), sort them in order of x and y coordinates. 
 *  try to remove the cows with greatest x, y, or smallest x, y, coordinates. 
 */

import java.util.*;
import java.io.*;
public class FieldReduction {
    static int n;
    static Cow[] cowX;
    static Cow[] cowY;
    static class Cow implements Comparable<Cow> {
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
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("reduce.in"));
        //PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("reduce.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());        //n
        n = Integer.parseInt(st.nextToken());
        cowX = new Cow[n];
        cowY = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            cowX[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            cowY[i] = cowX[i];
        }
        Arrays.sort(cowX);
        Arrays.sort(cowY, new Comparator<Cow>() {
            public int compare(Cow one, Cow two) {
                return one.y - two.y;
            }
        });
        System.out.println(area());
        //System.out.println(area());
        //pw.println(area());
        //pw.close();
    }

    public static int area() {                                 // let the corner points equal to the second in the list
        if (n < 2 || cowX[0].x == cowX[n-1].x || cowY[0].y == cowY[n-1].y) return 0;
        int a = Integer.MAX_VALUE;
        if (cowX[0].y < cowY[1].y) a = (cowX[n-1].x - cowX[1].x) * (cowY[n-1].y - cowY[1].y);                       // remove lower left
        else if (cowX[0].y > cowY[n-2].y) a = Math.min((cowX[n-1].x - cowX[1].x) * (cowY[n-2].y - cowX[0].y), a);   // remove upper left
        else a = Math.min((cowX[n-1].x - cowX[1].x) * (cowY[n-1].y - cowY[0].y), a);                                // otherwise removing this point shortens x only.
        if (cowY[0].x > cowX[n-2].x) a = Math.min((cowY[n-1].y - cowY[1].y) * (cowX[n-2].x - cowX[0].x), a);        // remove lower right
        else a = Math.min((cowY[n-1].y - cowY[1].y) * (cowX[n-1].x - cowX[0].x), a);                                // otherwise removing this point shortens y only

        if (cowX[n-1].y > cowY[n-2].y) a = Math.min((cowX[n-2].x - cowX[0].x) * (cowY[n-2].y - cowY[0].y), a);      // removing upper right
        else if (cowX[n-1].y <= cowY[n-2].y && cowX[n-1].y >= cowY[0].y) a = Math.min((cowY[n-1].y - cowY[0].y) * (cowX[n-2].x - cowX[0].x), a); // otherwise removing this point shortens x only
        if (cowY[n-1].x <= cowX[n-2].x && cowY[n-1].x >= cowX[0].x) a = Math.min((cowX[n-1].x - cowX[0].x) * (cowY[n-2].y - cowY[0].y), a); // otherwise removing this point shortens y only
        return a;
    }
}
