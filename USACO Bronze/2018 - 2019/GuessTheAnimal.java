/*
SACO 2019 January Contest, Bronze
Problem 3. Guess the Animal

SAMPLE INPUT:
4
bird 2 flies eatsworms
cow 4 eatsgrass isawesome makesmilk goesmoo
sheep 1 eatsgrass
goat 2 makesmilk eatsgrass
SAMPLE OUTPUT:
3

submission
1   10/10
*/

import java.util.*;
import java.io.*;
public class GuessTheAnimal {
    /**
     * find the maximum similar trait of any pairs of animals within the feasible set. 
     * @param args
     * @throws IOException
     */
    static ArrayList<String> traits  = new ArrayList<>();
    public static void main(String args[]) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader br = new BufferedReader(new FileReader("guess.in"));
        PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter("guess.out")));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            int k = Integer.parseInt(st.nextToken());
            for (int j = 0; j < k; j++) {
                a[i][j] = findIndex(st.nextToken());
            }
        }
        int max = 0; 
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int count = 0;
                for (int k = 0; k < 100; k++) {
                    for (int m = 0; m < 100; m++) {
                        if (a[i][k] == (a[j][m]) && a[i][k] != 0) count++;
                    }
                }
                max = Math.max(max, count); 
            }
        }
        pw.println(max+1);
        pw.close();
    }
    static int findIndex(String s) {
        for (int i = 0; i < traits.size(); i++) {
            if (s.equals(traits.get(i))) return i+1; 
        }
        traits.add(s);
        return traits.size();
    }
}
