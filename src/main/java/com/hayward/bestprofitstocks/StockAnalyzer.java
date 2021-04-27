package com.hayward.bestprofitstocks;

/**
 * Stock Analyzer class for handling stock analysis logic.
 *
 * @author Peter Hayward
 */
public class StockAnalyzer {

    /**
     * Returns the best profit that could have been made from 1 purchase and 1 sale of 1 stock
     * Assumes that 1 purchase and 1 sale MUST be made
     *
     * @param stockPriceList
     * @return int
     */
    public static int getMaxProfit(int[] stockPriceList) {
        validateStockPriceList(stockPriceList);
        validateStockPrice(stockPriceList[0]);
        int buyPrice = stockPriceList[0];
        int profit = Integer.MIN_VALUE;
        for (int i =1; i < stockPriceList.length; i++) {
            validateStockPrice(stockPriceList[i]);
            if (profit < stockPriceList[i] - buyPrice) {
                profit = stockPriceList[i] - buyPrice;
            }
            if (buyPrice > stockPriceList[i]) {
                buyPrice = stockPriceList[i];
            }
        }
        return profit;
    }

    /**
     * Ensures that a stock list is large enough for a purchase and a sale
     *
     * @param stockPriceList
     * @throws IllegalArgumentException When list length is less than 2
     */
    private static void validateStockPriceList(int[] stockPriceList) {
        if (stockPriceList.length < 2) {
            throw new IllegalArgumentException("At least 2 stock prices are needed");
        }
    }

    /**
     * Ensures stock price is not negative
     *
     * @param stockPrice
     * @throws IllegalArgumentException When stock price is negative
     */
    private static void validateStockPrice(int stockPrice) {
        if (stockPrice < 0) {
            throw new IllegalArgumentException("Stock price cannot be negative");
        }
    }
}
