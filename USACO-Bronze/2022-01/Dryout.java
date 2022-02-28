import java.util.*;
public class Dryout {
    public static void main(String arg[]) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        ArrayList<ArrayList<Integer>> h = new ArrayList<ArrayList<Integer>>(T);
        for (int i = 0; i < T; i++) {
            int c = scan.nextInt();
            for (int j = 0; j < c; j++) {
                h.get(i).add(scan.nextInt());
            }
        }
        int count = 0;
        for (int i = 0; i < T; i++) {
            int N = h.get(i).size();
            for (int j = 0; j < N-1; j++) {
                int index = fmax(h.get(j));
                if (index == -1) break;
                else if (h.get(i).get(0) > h.get(i).get(1) || h.get(i).get(N-1) > h.get(i).get(N-2)) break;
                else {
                    h.get(i).set(index, h.get(i).get(index)-1);
                    h.get(i).set(Math.max(index+1, index-1), h.get(i).get(Math.max(index+1, index-1))-1);
                    count++;
                }
            }
            if (count==0)System.out.println("-1");
            else System.out.println(count);
        }
    }
    static int fmax(ArrayList<Integer> a) {
        int index = -1;
        int max = -1;
        for (int i = 0; i < a.size(); i++) {
            if (max < a.get(i)) {
                max = a.get(i);
                index = i;
            }
        }
        return index;
    }
}
