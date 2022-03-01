import java.util.Arrays;

public class Practice {
    public static void main(String args[]) {
        int[] data = {6, 8, 19, 5, 12, 300};
        int[] compressed = compress(data);
        for (int i = 0; i < data.length; i++) {
            System.out.print(compressed[i] + " ");
        }
    }
    static int[] compress(int[] data) {
        int[] copy = new int[data.length];
        int[] compressed = new int[data.length];
        for (int i = 0; i < data.length; i++) {
            copy[i] = data[i];
        }
        Arrays.sort(copy);
        for (int i = 0; i < data.length; i++) {
            compressed[i] = Arrays.binarySearch(copy, data[i]);
        }
        return compressed;
    }
}