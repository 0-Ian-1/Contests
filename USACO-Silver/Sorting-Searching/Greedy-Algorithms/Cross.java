/**
 * USACO 2017 February Contest, Silver
 * Problem 1. Why Did the j Cross the Road
 */
import java.util.*;
import java.io.*;
public class Cross {
    public static void main(String arg[]) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader("helpcross.in"));
        PrintWriter pw = new PrintWriter("helpcross.out");
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[] chi = new int[C];
        Cow[] co = new Cow[N];
        for (int i = 0; i < C; i++) {
            chi[i] = Integer.parseInt(br.readLine());
        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            co[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        br.close();
        Arrays.sort(chi);
        Arrays.sort(co, new Comparator<Cow>() {
            public int compare(Cow one, Cow two) {
                return one.B - two.B;
            }
        });
        int pair, i, j;
        pair = i = j = 0;
        while (i < C && j < N) {
            if (co[j].A <= chi[i] && chi[i] < co[j].B) {
                pair++;
                i++; 
                j++;
            }
            if (co[j].A >= chi[i]) i++;
            if (co[j].B <= chi[i]) j++;
        }
        pw.println(pair);
        pw.close();
    }
}
class Cow {
    public int A, B;
    public Cow(int a, int b) {
        A = a; 
        B = b;
    }
}