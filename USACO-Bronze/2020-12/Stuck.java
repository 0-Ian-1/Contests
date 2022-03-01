/*
USACO 2020 December Contest, Bronze
Problem 3. Stuck in a Rut
*/
import java.util.*;
import java.io.*;
public class Stuck {
    static class Cow implements Comparable<Cow> {
        char dir; 
        int x0; 
        int y0; 
        int length = Integer.MAX_VALUE;
        public Cow(char d, int x, int y) {
            dir = d; 
            x0 = x; 
            y0 = y;
        }
        public int compareTo(Cow that) {
            return this.x0 - that.x0;
        }
    }
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        Cow[] cow = new Cow[n];
        Cow[] E = new Cow[n];       // going in E direction
        Cow[] N = new Cow[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            char d = st.nextToken().charAt(0);
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            cow[i] = new Cow(d, x, y);
            if (d == 'N') N[i] = cow[i];
            else if (d == 'E') E[i] = cow[i];
        }
        Arrays.sort(N);
        Arrays.sort(E, new Comparator<Cow>() {
            public int compare(Cow a, Cow b) {
                return a.y0 - b.y0;
            }
        });
        /**
         * start with E[0] and N[0], if E[0] blocked N[0], try E[0] and N[1]
         */
        int counterE = 0;
        int counterN = 0;
        while (counterE < E.length && counterN < N.length) {
            int interx = Math.max(E[counterE].x0, N[counterN].x0); 
            int intery = Math.max(E[counterE].y0, N[counterN].y0);
            int lE = interx - E[counterE].x0;
            int lN = intery - N[counterN].y0;
            if (lE > lN) { E[counterE].length = lE; counterE++; }
            else if (lE < lN) {N[counterN].length = lN; counterN++; }
        }
        for (int i = 0; i < n; i++) {
            if (cow[i].length == Integer.MAX_VALUE) System.out.println("Infinity");
            else System.out.println(cow[i].length);
        }
    }
}
