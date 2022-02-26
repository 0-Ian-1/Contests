import java.util.*;
public class Herdle {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        char[] a = new char[9];
        char[] g = new char[9];
        int[] guess = new int[26];
        int[] answer = new int[26];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < 3; j++) {
                char c = s.charAt(j);
                a[k] = c;
                answer[c-65]++;
                k++;
            }
        }
        k=0;
        for (int i = 0; i < 3; i++) {
            String s = scan.nextLine();
            for (int j = 0; j < 3; j++) {
                char c = s.charAt(j);
                g[k] = c;
                guess[c-65]++;
                k++;
            }
        }
        int yellow = 0;
        int green = 0;
        for (int i = 0; i < 9; i++) {
            if (a[i]==g[i]) green++;
        }
        for (int i = 0; i < 26; i++) {
            yellow += Math.min(answer[i], guess[i]);
        }

        System.out.println(green);
        System.out.println(yellow-green);
    }
}