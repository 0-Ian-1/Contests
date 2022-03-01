import java.util.*;
public class NonTransitiveDice {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        int[][] d = new int[T][8];
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 8; j++) {
                d[i][j] = scan.nextInt();
            }
        }
        for(int i = 0; i < T; i++) {
            String s = "";
            int[] win = winner(d[i]);
            int[] lose = loser(d[i]);
            int[] three = new int[4];
            for (int j = 1; j <= 10; j++) {
                for (int k = 1; k <= 10; k++) {
                    for (int l = 1; l <= 10; l++) {
                        for (int m = 1; m <= 10; m++) {
                            three[0] = j;
                            three[1] = k;
                            three[2] = l;
                            three[3] = m;
                            if (equal(winner(c(lose, three)), lose) && equal(winner(c(three, win)), three)) {
                                s = "yes";
                                break;
                            }
                        }
                    }
                }
            }
            if (s.equals("")) s = "no";
            System.out.println(s);
        }
    }

    static int[] c(int[] a, int[] b) {
        int[] ar = new int[8];
        for (int i = 0; i < 4; i++) {
            ar[i] = a[i];
            ar[i+4] = b[i];
        }
        return ar;
    }
    static boolean equal(int[] a, int[] b) { 
        for (int i = 0; i < 4; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
    static int[] winner(int[] d) {
        int[] win = new int[4];
        int wins = 0;
        int lose = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 4; k < 8; k++) {
                if (d[j] > d[k]) wins++;
                else if (d[j] < d[k]) lose++;
            }
        }
        if (wins > lose) {
            for (int a = 0; a < 4; a++) win[a] = d[a];
        }
        else if (wins < lose) {
            for (int a = 0; a < 4; a++) win[a] = d[a+4];
        }
        return win;
    }
    static int[] loser(int[] d) {
        int[] loss = new int[4];
        int wins = 0;
        int lose = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 4; k < 8; k++) {
                if (d[j] > d[k]) wins++;
                else if (d[j] < d[k]) lose++;
            }
        }
        if (wins > lose) {
            for (int a = 0; a < 4; a++) loss[a] = d[a+4];
        }
        else if (wins < lose) {
            for (int a = 0; a < 4; a++) loss[a] = d[a];
        }
        return loss;
    }
}
