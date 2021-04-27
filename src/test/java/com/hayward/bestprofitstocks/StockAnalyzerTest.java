package com.hayward.bestprofitstocks;

import static com.hayward.bestprofitstocks.StockAnalyzer.getMaxProfit;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * Unit tests for StockAnalyzer.
 */
public class StockAnalyzerTest {
    @Test
    public void exampleTest() {
        int[] stockPrices = {10,7,5,8,11,9};
        assertEquals(6, getMaxProfit(stockPrices));
    }

    @Test
    public void mustBuyBeforeSell() {
        int[] stockPrices = {9,6,4,2,3};
        assertEquals(1, getMaxProfit(stockPrices));
    }

    @Test
    public void cantBuyLast() {
        int[] stockPrices = {5,6,3,4,1};
        assertEquals(1, getMaxProfit(stockPrices));
    }

    @Test
    public void allPricesSame() {
        int[] stockPrices = {2,2,2,2};
        assertEquals(0,getMaxProfit(stockPrices));
    }

    @Test
    public void longList() {
        int[] stockPrices = {4,6,6,2,4,7,9,7,4,1,4,6,7,8,9,4,5,7,5,4,3};
        assertEquals(8,getMaxProfit(stockPrices));
    }

    @Test
    public void shortList() {
        int[] stockPrices = {1,9};
        assertEquals(8, getMaxProfit(stockPrices));
    }

    @Test
    public void cannotMakeAProfit() {
        int[] stockPrices = {9,6,4,2,1};
        assertEquals(-1, getMaxProfit(stockPrices));
    }

    @Test(expected = IllegalArgumentException.class)
    public void stockListTooSmall() {
        int[] stockPrices = {5};
        getMaxProfit(stockPrices);
    }
    @Test(expected = IllegalArgumentException.class)
    public void stockPriceNegative() {
        int[] stockPrices = {2,3,4,-5};
        getMaxProfit(stockPrices);
    }
}
