/**
 * USACO 2019 February Contest, Silver
 * Problem 2. Painting the Barn
 * 
 * Key: Using 2-D prefix sum to simulate painting wall. 
 * add 1 at x1, y1 indicating the start of painting,
 * and 0 at both x1, y2 and x2, y1 indicating the boundary.
 * lastly, add 1 to x2, y2 so that the coordinate is "regular"
 */
import java.io.*;
import java.lang.*;
import java.util.*;
public class PaintBarn {
    public static void main(String args[]) throws Exception{
        Scanner scan = new Scanner(new File("paintbarn.in"));
        PrintWriter pw = new PrintWriter("paintbarn.out");
        int N = scan.nextInt();
        int K = scan.nextInt();
        int[][] barn = new int[1002][1002];
        for (int i = 0; i < N; i++) {
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();
            int x2 = scan.nextInt();
            int y2 = scan.nextInt();
            barn[x1][y1]++;
            barn[x2][y2]++;
            barn[x1][y2]--;
            barn[x2][y1]--;
        }
        int[][] sum = new int[1002][1002];
        int k = 0;
        for (int i = 0; i < 1002; i++) {
            for (int j = 0; j < 1002; j++) {
                sum[i][j] = barn[i][j];
                if (i > 0) sum[i][j] += sum[i-1][j];
                if (j > 0) sum[i][j] += sum[i][j-1];
                if (i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1];
                if (sum[i][j] == K) k++;
            }
        }
        pw.println(k);
        pw.close();
    }
}
