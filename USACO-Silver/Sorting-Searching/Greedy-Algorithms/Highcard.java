/**
 * USACO 2015 December Contest, Silver
 * Problem 2. High Card Wins
 */
import java.util.*;
import java.io.*;
public class Highcard {
    public static void main (String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("highcard.in"));
        PrintWriter pw = new PrintWriter("highcard.out");
        int N = Integer.parseInt(br.readLine());
        int[] index = new int[N*2];
        for (int i = 0; i < N; i++) {
            index[Integer.parseInt(br.readLine())-1] = 1;
        }
        int count, total;
        count = total = 0; 
        for (int i = N*2-1; i > -1; i--) {
            if (index[i] == 0) count++;
            if (count > 0 && index[i] == 1) {
                count--;
                total++;
            }
        }
        pw.println(total);
        pw.close();
        br.close();
    }
}