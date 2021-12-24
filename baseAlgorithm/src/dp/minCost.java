package dp;

/**
 * 最小花费上楼梯
 */

public class minCost {
    public int minCostClimbingStairs(int[] cost) {
        if (cost == null || cost.length == 0) {
            return 0;
        }

        if (cost.length == 1) {
            return cost[0];
        }

        int dp[] = new int[cost.length];
        //初始化dp数组
        dp[0] = cost[0];
        dp[1] = cost[1];
        //初始化前两步，之后开始遍历，第一次循环遍历到i前两个楼梯的值，并且比较谁的cost少，再加上本次跨步的cost
        for (int i = 2; i < cost.length; i++) {
            dp[i] = Math.min(dp[i - 1], dp[i - 2]) + cost[i];
        }
        //最后两步，取他们的最小值进行跨步
        return Math.min(dp[cost.length - 1], dp[cost.length - 2]);
    }
}
