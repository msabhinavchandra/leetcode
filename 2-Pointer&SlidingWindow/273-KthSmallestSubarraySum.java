import java.util.*;

class KthSmallestSubarraySum {
    public int kthSmallestSubarraySum(int[] nums, int k) {
        int min = Integer.MAX_VALUE, sum = 0;
        for (int num : nums) {
            min = Math.min(min, num);
            sum += num;
        }
        int low = min, high = sum;
        while (low < high) {
            int mid = (low + high) / 2;
            int count = countSubarrays(nums, mid);
            if (count < k)
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }

    public int countSubarrays(int[] nums, int mid) {
        int count = 0;
        int sum = 0;
        int length = nums.length;
        int left = 0, right = 0;
        while (right < length) {
            sum += nums[right];
            while (sum > mid) {
                sum -= nums[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int array[] = new int[n];
        int k = sc.nextInt();

        for (int i = 0; i < n; i++)
            array[i] = sc.nextInt();

        System.out.println(new KthSmallestSubarraySum().kthSmallestSubarraySum(array, k));
    }
}
