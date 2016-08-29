package leetcode;

/**
 * There are N children standing in a line. Each child is assigned a rating value.
 * <p/>
 * You are giving candies to these children subjected to the following requirements:
 * <p/>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * What is the minimum candies you must give?
 * <p/>
 * Created by kevin on 2016/3/7.
 */
public class L135_Candy {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int total = 1, len = 1, cur = 1, beforeDec = cur;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] < ratings[i - 1]) {
                total += len;
                if (beforeDec <= len) total++;
                len++;
                cur = 1;
            } else {
                if (ratings[i] == ratings[i - 1]) {
                    cur = 1;
                    total++;
                } else {
                    cur++;
                    total += cur;
                }
                len = 1;
                beforeDec = cur;
            }
        }
        return total;
    }

    public int candy02(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        if (ratings.length == 1) return 1;
        int[] cans = new int[ratings.length];
        cans[0] = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) cans[i] = cans[i - 1] + 1;
            else cans[i] = 1;
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1] && cans[i] <= cans[i + 1]) cans[i] = cans[i + 1] + 1;
        }

        int sum = 0;
        for (int i = 0; i < ratings.length; i++) {
            sum += cans[i];
        }
        return sum;
    }
}
