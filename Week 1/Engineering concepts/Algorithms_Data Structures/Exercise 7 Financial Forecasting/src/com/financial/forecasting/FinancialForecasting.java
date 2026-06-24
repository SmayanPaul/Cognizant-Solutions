package com.financial.forecasting;

import java.util.HashMap;
import java.util.Map;

public class FinancialForecasting {

    private static Map<Integer, Double> memo = new HashMap<>();

    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative");
        }
        if (periods == 0) {
            return presentValue;
        }
        return calculateFutureValue(presentValue, growthRate, periods - 1) * (1 + growthRate);
    }

    public static double calculateFutureValueOptimized(double presentValue, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative");
        }
        if (periods == 0) {
            return presentValue;
        }
        if (memo.containsKey(periods)) {
            return memo.get(periods);
        }
        double result = calculateFutureValueOptimized(presentValue, growthRate, periods - 1) * (1 + growthRate);
        memo.put(periods, result);
        return result;
    }

    public static double calculateFutureValueIterative(double presentValue, double growthRate, int periods) {
        if (periods < 0) {
            throw new IllegalArgumentException("Periods cannot be negative");
        }
        double futureValue = presentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double presentValue = 1000.0;
        double growthRate = 0.05; // 5% growth rate
        int periods = 10; // 10 years

        System.out.println("==================================================================");
        System.out.println("                 Financial Forecasting Demonstration              ");
        System.out.println("==================================================================");
        System.out.printf("  Present Value: $%.2f\n", presentValue);
        System.out.printf("  Annual Growth Rate: %.1f%%\n", growthRate * 100);
        System.out.printf("  Forecasting Period: %d years\n", periods);
        System.out.println("------------------------------------------------------------------");

        long startTime = System.nanoTime();
        double basicResult = calculateFutureValue(presentValue, growthRate, periods);
        long endTime = System.nanoTime();
        long basicDuration = endTime - startTime;
        System.out.printf("  [Basic Recursion] Future Value: $%.2f (Time: %d ns)\n", basicResult, basicDuration);

        startTime = System.nanoTime();
        memo.clear();
        double memoizedResult = calculateFutureValueOptimized(presentValue, growthRate, periods);
        endTime = System.nanoTime();
        long memoizedDuration = endTime - startTime;
        System.out.printf("  [Memoized Recursion] Future Value: $%.2f (Time: %d ns)\n", memoizedResult, memoizedDuration);

        startTime = System.nanoTime();
        double iterativeResult = calculateFutureValueIterative(presentValue, growthRate, periods);
        endTime = System.nanoTime();
        long iterativeDuration = endTime - startTime;
        System.out.printf("  [Iterative Approach] Future Value: $%.2f (Time: %d ns)\n", iterativeResult, iterativeDuration);
        System.out.println("==================================================================");
    }
}
