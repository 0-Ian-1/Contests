/*
USACO 2020 December Contest, Bronze
Problem 2. Daisy Chains
*/
import java.util.*;
import java.io.*;
public class DaisyChains {
    static int[] a;
    static int n;
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        a = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int count = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                double avg = avg(i, j);
                for (int k = i; k <= j; k++) {
                    if (a[k] == avg) { count++; break;}
                }
            }
        }
        System.out.println(count);
    }

    public static double avg(int i, int j) {
        if (i == j) return a[i];
        int sum = 0;
        for (int k = i; k <= j; k++) {
            sum += a[k];
        }
        return (double)sum / (j - i + 1); 
    }
}
