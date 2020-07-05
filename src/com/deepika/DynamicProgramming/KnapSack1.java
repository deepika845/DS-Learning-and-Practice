package com.deepika.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
class Knapsack1 {
    public static void main(String[] args) {
        int[] profits = {3, 5, 7, 9, 11, 12};
        int[] weights = {100, 110, 120, 220, 90, 100};

        int maximumCapacity = 300;

        int maxProfit = findMaxProfit(profits, weights, 0, maximumCapacity, 0, new HashMap<>());
        System.out.println(maxProfit);
    }

    //2^N (Exponential)
    private static int findMaxProfit(int[] profits, int[] weights, int currentProfit, int capacityRemaining,
                                     int index, Map<Pair, Integer> cache) {
        if (capacityRemaining < 0)
            return currentProfit - profits[index - 1];

        if (profits.length == 0)
            return 0;

        if (capacityRemaining == 0)
            return currentProfit;

        Pair key = new Pair(currentProfit, capacityRemaining);

        if (cache.containsKey(key)) {
            return cache.get(key);//Dp = recursion + memoization

        } else {

            int profitWhenWeStoleCurrentItem = findMaxProfit(profits, weights, currentProfit + profits[index],
                    capacityRemaining - weights[index], index++, cache);

            int profitWhenWeDidNotStoleCurrentItem = findMaxProfit(profits, weights, currentProfit,
                    capacityRemaining, index++, cache);

            int finalResult = Math.max(profitWhenWeStoleCurrentItem, profitWhenWeDidNotStoleCurrentItem);

            Pair key1 = new Pair(currentProfit, capacityRemaining);
            cache.put(key1, finalResult);

            return finalResult;
        }
    }

    static class Pair {
        int currentProfit;
        int capacityRemaining;

        public Pair(int currentProfit, int capacityRemaining) {
            this.currentProfit = currentProfit;
            this.capacityRemaining = capacityRemaining;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Pair)) return false;
            Pair pair = (Pair) o;
            return currentProfit == pair.currentProfit &&
                    capacityRemaining == pair.capacityRemaining;
        }

        @Override
        public int hashCode() {
            return Objects.hash(currentProfit, capacityRemaining);
        }
    }
}