package leetcode.dp;

/**
 * @program: about_algorithms
 * @author: cdx
 * @create: 2018-09-11 21:35
 **/
public class BestTimeToBuyAndSellStock_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = minPrice <= price ? minPrice : price;
            maxProfit = maxProfit >= (price - minPrice) ? maxProfit : price - minPrice;
        }
        return maxProfit;
    }
}
