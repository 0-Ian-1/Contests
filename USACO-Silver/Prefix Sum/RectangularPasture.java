/**
 * USACO 2020 December Contest, Silver
 * Problem 2. Rectangular Pasture
 */
import java.util.*;
public class RectangularPasture {
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int[] x = new int[N];
        int[] y = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = scan.nextInt();
            y[i] = scan.nextInt();
        }
        int[] rankX = compress(x);
        int[] rankY = compress(y);
        int[][] sum = new int[N+1][N+1];
        for (int i = 0; i < N; i++) {
            sum[rankX[i]][rankY[i]]++;
        }
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                if (i > 0) sum[i][j] += sum[i-1][j];
                if (j > 0) sum[i][j] += sum[i][j-1];
                if (i > 0 && j > 0) sum[i][j] -= sum[i-1][j-1];
            }
        }
        for (int i = 0; i < N+1; i++) {
            for (int j = 0; j < N+1; j++) {
                System.out.print(sum[i][j] + " ");
            }
            System.out.println();
        }
    }
    static int[] compress(int[] a) {
        int[] c = new int[a.length];
        int[] sort = new int[a.length];
        for (int i = 0; i < a.length; i++) sort[i] = a[i];
        Arrays.sort(sort);
        for (int i = 0; i < a.length; i++) {
            c[i] = Arrays.binarySearch(sort, a[i]);
        }
        return c;
    }
}