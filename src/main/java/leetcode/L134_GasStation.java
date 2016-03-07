package leetcode;

import java.util.Locale;

/**
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
 * <p/>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
 * <p/>
 * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
 * <p/>
 * Created by kevin on 2016/3/7.
 */
@Deprecated
public class L134_GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas.length == 0) return -1;
        if (gas.length != cost.length) return -1;
        int max = 0, cur = 0;
        int startLoc = 0, endLoc = -1;
        // 求得最大子串，该子串起点即为旅行起点
        for (int i = 0; i < gas.length; i++) {
            cur += gas[i] - cost[i];
            if (cur < 0) {
                cur = 0;
                startLoc = i + 1;
            } else if (cur > max) {
                max = cur;
                endLoc = i;
            }
        }
        if (endLoc < startLoc) endLoc = gas.length;
        for (int i = endLoc + 1; i < gas.length; i++) {
            max += gas[i] - cost[i];
            if (max < 0)
                return -1;
        }
        for (int i = 0; i < startLoc; i++) {
            max += gas[i] - cost[i];
            if (max < 0)
                return -1;
        }
        return startLoc==gas.length?startLoc-1:startLoc;

        /*int start = 0, count = 0, cur = 0, n = gas.length;
        while (count < n && start < 2 * n) {
            cur += gas[start % n] - cost[start % n];
            if (cur < 0) {
                count = 0;
                cur = 0;
            } else {
                count++;
            }
            start++;
        }
        return count < n ? -1 : start % n;*/
    }
}
