// https://www.hackerearth.com/practice/algorithms/graphs/graph-representation/practice-problems/algorithm/split-the-bill-3-5a0690ff/

//Brute-force approach
import java.util.*;

public class SplitwiseBruteForce {
    public static void solve(int N, List<Map<String, Object>> transactions) {
        Map<Integer, Integer> balance = new HashMap<>();

        // Step 1: Calculate the net balance for each person
        for (Map<String, Object> transaction : transactions) {
            List<List<Integer>> paidBy = (List<List<Integer>>) transaction.get("paid_by");
            List<List<Integer>> splitAs = (List<List<Integer>>) transaction.get("split_as");

            for (List<Integer> entry : paidBy) {
                balance.put(entry.get(0), balance.getOrDefault(entry.get(0), 0) + entry.get(1));
            }
            for (List<Integer> entry : splitAs) {
                balance.put(entry.get(0), balance.getOrDefault(entry.get(0), 0) - entry.get(1));
            }
        }

        // Step 2: Extract debtors and creditors
        List<int[]> debtors = new ArrayList<>();
        List<int[]> creditors = new ArrayList<>();

        for (int person : balance.keySet()) {
            if (balance.get(person) < 0) {
                debtors.add(new int[]{person, -balance.get(person)});
            } else if (balance.get(person) > 0) {
                creditors.add(new int[]{person, balance.get(person)});
            }
        }

        // Step 3: Settle debts one by one (Brute force matching)
        List<int[]> transactionsList = new ArrayList<>();
        for (int[] debtor : debtors) {
            for (int[] creditor : creditors) {
                if (debtor[1] == 0) break;
                if (creditor[1] == 0) continue;

                int amount = Math.min(debtor[1], creditor[1]);
                transactionsList.add(new int[]{debtor[0], creditor[0], amount});
                debtor[1] -= amount;
                creditor[1] -= amount;
            }
        }

        // Output result
        System.out.println(transactionsList.size());
        for (int[] t : transactionsList) {
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}


// time complexity: O(N^2)
// space complexity: O(N)

//Optimized approach

import java.io.*;
import java.util.*;

public class SplitwiseSolution {
    public static void main(String[] args) throws IOException {
        // Reading input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // Number of people
        int M = Integer.parseInt(st.nextToken()); // Number of transactions
        
        Map<Integer, Integer> balance = new HashMap<>();

        // Read transactions
        for (int i = 0; i < M; i++) {
            String transactionId = br.readLine(); // Read transaction ID
            st = new StringTokenizer(br.readLine());
            int n_payers = Integer.parseInt(st.nextToken());
            int n_splits = Integer.parseInt(st.nextToken());

            // Process payments
            for (int j = 0; j < n_payers; j++) {
                st = new StringTokenizer(br.readLine());
                int payer = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                balance.put(payer, balance.getOrDefault(payer, 0) + amount);
            }

            // Process splits
            for (int j = 0; j < n_splits; j++) {
                st = new StringTokenizer(br.readLine());
                int borrower = Integer.parseInt(st.nextToken());
                int amount = Integer.parseInt(st.nextToken());
                balance.put(borrower, balance.getOrDefault(borrower, 0) - amount);
            }
        }

        // Separate debtors (negative balance) and creditors (positive balance)
        List<int[]> debtors = new ArrayList<>();
        List<int[]> creditors = new ArrayList<>();

        for (Map.Entry<Integer, Integer> entry : balance.entrySet()) {
            int person = entry.getKey();
            int netAmount = entry.getValue();
            if (netAmount < 0) {
                debtors.add(new int[]{person, -netAmount});
            } else if (netAmount > 0) {
                creditors.add(new int[]{person, netAmount});
            }
        }

        // Sort both lists lexicographically by person ID
        debtors.sort(Comparator.comparingInt(a -> a[0]));
        creditors.sort(Comparator.comparingInt(a -> a[0]));

        // Settling debts using two-pointer technique
        List<int[]> transactions = new ArrayList<>();
        int i = 0, j = 0;

        while (i < debtors.size() && j < creditors.size()) {
            int debtorId = debtors.get(i)[0];
            int creditorId = creditors.get(j)[0];
            int amount = Math.min(debtors.get(i)[1], creditors.get(j)[1]);

            transactions.add(new int[]{debtorId, creditorId, amount});

            // Deduct the settled amount
            debtors.get(i)[1] -= amount;
            creditors.get(j)[1] -= amount;

            // Move to the next debtor/creditor if the current one's balance is settled
            if (debtors.get(i)[1] == 0) i++;
            if (creditors.get(j)[1] == 0) j++;
        }

        // Output the result
        // System.out.println(transactions.size());
        for (int[] t : transactions) {
            System.out.println(t[0] + " " + t[1] + " " + t[2]);
        }
    }
}
