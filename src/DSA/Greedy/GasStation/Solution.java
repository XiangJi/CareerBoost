package DSA.Greedy.GasStation;

/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).

 You begin the journey with an empty tank at one of the gas stations.

定理1： 如果一个数组的sum 是positve的。 那么一定可以找到一个start index，从它开始一圈的sum一路都是positve的

算一下最后的油-油耗

如何求开始位置

i --- j
1 5 -8
定理2：如果i开始到j到negative不用从i+1开始看，直接从j+1开始看

 */
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0 || cost.length == 0 || gas.length != cost.length) {
            return -1;
        }
        int total = 0;
        int sum = 0;
        int index = -1;
        for (int i = 0; i < gas.length; i++) {
            sum += gas[i] - cost[i];
            total += gas[i] - cost[i];
            //Theorem 2
            if (sum < 0) {
                sum = 0;
                index = i; // index 记录最后一个不行的j位置， sum之后再往前走，一个solution
            }
        }
        // Theorem 1
        if (total < 0) {
            return -1;
        }
        return index + 1; // 结果是index后面那个

    }
}
