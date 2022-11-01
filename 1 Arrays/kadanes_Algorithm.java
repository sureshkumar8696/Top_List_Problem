
/*
Example 1:

Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 

Output: 6 

Explanation: [4,-1,2,1] has the largest sum = 6. 

Examples 2: 

Input: arr = [1] 

Output: 1 

Explanation: Array has only one element and which is giving positive sum of 1
*/
import java.util.*;

public class kadanes_Algorithm {
    public static int maxSubArray(int[] nums, ArrayList<Integer> subarray) {
        int max_sum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr_sum = 0;
            for (int j = i; j < nums.length; j++) {
                curr_sum += nums[j];
                if (curr_sum > max_sum) {
                    subarray.clear();
                    max_sum = curr_sum;
                    subarray.add(i);
                    subarray.add(j);
                }
            }
        }
        return max_sum;
    }

    public static int maxSubArray2(int[] nums, ArrayList<Integer> subarray) {
        int msf = Integer.MIN_VALUE, meh = 0;
        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            meh += nums[i];

            if (meh > msf) {
                subarray.clear();
                msf = meh;
                subarray.add(s);
                subarray.add(i);
            }
            if (meh < 0) {
                meh = 0;
                s = i + 1;

            }
        }

        return msf;
    }

    public static void main(String[] args) {
        int arr[] = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        ArrayList<Integer> subarray = new ArrayList<>();
        // brute force
        // int lon = maxSubArray(arr, subarray);

        // optimal
        int lon = maxSubArray2(arr, subarray);
        System.out.println("The longest subarray with maximum sum is " + lon);
        System.out.println("The subarray is ");
        for (int i = subarray.get(0); i <= subarray.get(1); i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
