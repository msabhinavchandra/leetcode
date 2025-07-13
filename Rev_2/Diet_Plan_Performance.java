package Rev_2;

import java.util.*;

class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {
        int points = 0;
        int sum = 0;
        for (int i = 0; i < k; i++)
            sum += calories[i];
        if (sum > upper)
            points++;
        else if (sum < lower)
            points--;
        int length = calories.length;
        for (int i = k; i < length; i++) {
            sum += calories[i];
            sum -= calories[i - k];
            if (sum > upper)
                points++;
            else if (sum < lower)
                points--;
        }
        return points;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int calories[] = new int[n];

        for (int i = 0; i < n; i++) {
            calories[i] = sc.nextInt();
        }
        int k = sc.nextInt();
        int l = sc.nextInt();
        int u = sc.nextInt();
        System.out.println(new DietPlanPerformance().dietPlanPerformance(calories, k, l, u));
    }
}