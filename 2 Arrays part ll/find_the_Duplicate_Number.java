import java.util.*;

public class find_the_Duplicate_Number {
    static int findDuplicate(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] == arr[i + 1]) {
                return arr[i];
            }
        }
        return 0;
    }

    static int findDuplicate2(int[] arr) {
        int n = arr.length;
        int freq[] = new int[n + 1];
        for (int i = 0; i < n; i++) {
            if (freq[arr[i]] == 0) {
                freq[arr[i]] += 1;
            } else {
                return arr[i];
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        int arr[] = { 1, 3, 4, 2, 2 };
        // System.out.println("The duplicate element is " + findDuplicate(arr));
        System.out.println("The duplicate element is " + findDuplicate2(arr));
    }
}
