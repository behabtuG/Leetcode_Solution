package leetcode.com.Hard.MaximumProfitinJobScheduling;

import java.util.Arrays;

//Approach 1: Top-down
// Time: O(nlog⁡n)O(nlogn)
// Space: O(n)O(n)
public class Solution {
    public static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        final int n = startTime.length;
        dp = new int[n + 1];
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; ++i)
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

        Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
        for (int i = 0; i < n; ++i)
            startTime[i] = jobs[i].startTime;
        return jobScheduling(jobs, startTime, 0);
    }

    private static int[] dp;

    private static int jobScheduling(Job[] jobs, int[] startTime, int i) {
        if (i == jobs.length)
            return 0;
        if (dp[i] > 0)
            return dp[i];

        final int j = firstGreaterEqual(startTime, i + 1, jobs[i].endTime);
        final int choose = jobs[i].profit + jobScheduling(jobs, startTime, j);
        final int skip = jobScheduling(jobs, startTime, i + 1);
        return dp[i] = Math.max(choose, skip);
    }

    private static int firstGreaterEqual(int[] A, int startFrom, int target) {
        int l = startFrom;
        int r = A.length;
        while (l < r) {
            final int m = (l + r) / 2;
            if (A[m] >= target)
                r = m;
            else
                l = m + 1;
        }
        return l;
    }

    public static void main(String[] args) {
        int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60}; //Output: 150
        System.out.println(jobScheduling(startTime, endTime, profit));
    }
}

class Job {
    public int startTime;
    public int endTime;
    public int profit;

    public Job(int startTime, int endTime, int profit) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.profit = profit;
    }
}
//Approach 2: Bottom-up
//   Time: O(nlog⁡n)O(nlogn)
//   Space: O(n)O(n)
/**
 * struct Job {
 * int startTime;
 * int endTime;
 * int profit;
 * Job(int startTime, int endTime, int profit)
 * : startTime(startTime), endTime(endTime), profit(profit) {}
 * };
 * <p>
 * class Solution {
 * public:
 * int jobScheduling(vector<int>& startTime, vector<int>& endTime,
 * vector<int>& profit) {
 * const int n = startTime.size();
 * // dp[i] := max profit to schedule jobs[i:]
 * vector<int> dp(n + 1);
 * vector<Job> jobs;
 * <p>
 * for (int i = 0; i < n; ++i)
 * jobs.emplace_back(startTime[i], endTime[i], profit[i]);
 * <p>
 * sort(begin(jobs), end(jobs), [](const auto& a, const auto& b) {
 * return a.startTime < b.startTime;
 * });
 * <p>
 * // Will use binary search to find the first available startTime
 * for (int i = 0; i < n; ++i)
 * startTime[i] = jobs[i].startTime;
 * <p>
 * for (int i = n - 1; i >= 0; --i) {
 * const int j = firstGreaterEqual(startTime, i + 1, jobs[i].endTime);
 * const int choose = jobs[i].profit + dp[j];
 * const int skip = dp[i + 1];
 * dp[i] = max(choose, skip);
 * }
 * <p>
 * return dp[0];
 * }
 * <p>
 * int firstGreaterEqual(const vector<int>& A, int startFrom, int target) {
 * return lower_bound(begin(A) + startFrom, end(A), target) - begin(A);
 * }
 * };
 * class Job {
 * public int startTime;
 * public int endTime;
 * public int profit;
 * public Job(int startTime, int endTime, int profit) {
 * this.startTime = startTime;
 * this.endTime = endTime;
 * this.profit = profit;
 * }
 * }
 * <p>
 * class Solution {
 * public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
 * final int n = startTime.length;
 * <p>
 * Job[] jobs = new Job[n];
 * <p>
 * for (int i = 0; i < n; ++i)
 * jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
 * <p>
 * Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
 * <p>
 * // Will use binary search to find the first available startTime
 * for (int i = 0; i < n; ++i)
 * startTime[i] = jobs[i].startTime;
 * <p>
 * return getMaxProfit(jobs);
 * }
 * <p>
 * private int getMaxProfit(Job[] jobs) {
 * int maxProfit = 0;
 * Queue<Job> minHeap = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
 * <p>
 * for (Job job : jobs) {
 * while (!minHeap.isEmpty() && job.startTime >= minHeap.peek().endTime)
 * maxProfit = Math.max(maxProfit, minHeap.poll().profit);
 * minHeap.offer(new Job(job.startTime, job.endTime, job.profit + maxProfit));
 * }
 * <p>
 * while (!minHeap.isEmpty())
 * maxProfit = Math.max(maxProfit, minHeap.poll().profit);
 * <p>
 * return maxProfit;
 * }
 * }
 * class Job {
 * public int startTime;
 * public int endTime;
 * public int profit;
 * public Job(int startTime, int endTime, int profit) {
 * this.startTime = startTime;
 * this.endTime = endTime;
 * this.profit = profit;
 * }
 * }
 * <p>
 * class Solution {
 * public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
 * final int n = startTime.length;
 * <p>
 * Job[] jobs = new Job[n];
 * <p>
 * for (int i = 0; i < n; ++i)
 * jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
 * <p>
 * Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);
 * <p>
 * // Will use binary search to find the first available startTime
 * for (int i = 0; i < n; ++i)
 * startTime[i] = jobs[i].startTime;
 * <p>
 * return getMaxProfit(jobs);
 * }
 * <p>
 * private int getMaxProfit(Job[] jobs) {
 * int maxProfit = 0;
 * Queue<Job> minHeap = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);
 * <p>
 * for (Job job : jobs) {
 * while (!minHeap.isEmpty() && job.startTime >= minHeap.peek().endTime)
 * maxProfit = Math.max(maxProfit, minHeap.poll().profit);
 * minHeap.offer(new Job(job.startTime, job.endTime, job.profit + maxProfit));
 * }
 * <p>
 * while (!minHeap.isEmpty())
 * maxProfit = Math.max(maxProfit, minHeap.poll().profit);
 * <p>
 * return maxProfit;
 * }
 * }
 */
//Approach 3: Heap
//   Time: O(nlog⁡n)O(nlogn)
//   Space: O(n)O(n)
/**class Job {
 public int startTime;
 public int endTime;
 public int profit;
 public Job(int startTime, int endTime, int profit) {
 this.startTime = startTime;
 this.endTime = endTime;
 this.profit = profit;
 }
 }

 class Solution {
 public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
 final int n = startTime.length;

 Job[] jobs = new Job[n];

 for (int i = 0; i < n; ++i)
 jobs[i] = new Job(startTime[i], endTime[i], profit[i]);

 Arrays.sort(jobs, (a, b) -> a.startTime - b.startTime);

 // Will use binary search to find the first available startTime
 for (int i = 0; i < n; ++i)
 startTime[i] = jobs[i].startTime;

 return getMaxProfit(jobs);
 }

 private int getMaxProfit(Job[] jobs) {
 int maxProfit = 0;
 Queue<Job> minHeap = new PriorityQueue<>((a, b) -> a.endTime - b.endTime);

 for (Job job : jobs) {
 while (!minHeap.isEmpty() && job.startTime >= minHeap.peek().endTime)
 maxProfit = Math.max(maxProfit, minHeap.poll().profit);
 minHeap.offer(new Job(job.startTime, job.endTime, job.profit + maxProfit));
 }

 while (!minHeap.isEmpty())
 maxProfit = Math.max(maxProfit, minHeap.poll().profit);

 return maxProfit;
 }
 }
 */