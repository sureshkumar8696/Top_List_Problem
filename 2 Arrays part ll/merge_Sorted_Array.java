import java.util.Arrays;

/*
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1

practice link=> https://leetcode.com/problems/merge-sorted-array/
*/
public class merge_Sorted_Array {
    public static int[] merge(int[] nums1, int[] nums2, int m, int n) {
        int[] nums = new int[m + n];
        int i = 0, j = 0, k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                nums[k++] = nums1[i++];
            } else {
                nums[k++] = nums2[j++];
            }
        }
        while (i < m) {
            nums[k++] = nums1[i++];
        }
        while (j < n) {
            nums[k++] = nums2[j++];
        }
        for (i = 0; i < nums1.length; i++) {
            nums1[i] = nums[i];
        }

        return nums;
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 4, 7, 8, 10 };
        int arr2[] = { 2, 3, 9 };
        System.out.println("Before merge:");
        for (int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + " ");
        }
        System.out.println();
        int[] res = merge(arr1, arr2, arr1.length, arr2.length);
        System.out.println(Arrays.toString(res));
    }
}
