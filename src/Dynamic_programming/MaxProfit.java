package Dynamic_programming;

public class MaxProfit {
    public int maxProfit(int[] prices) {
        if(prices.length <= 1)
            return 0;
        int buy = -prices[0], sell = 0;
        for(int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, -prices[i]);
            sell = Math.max(sell, prices[i] + buy);

        }
        return sell;
    }
//    对于买卖股票的最佳时期III，这里限制了最多两笔交易。
    public int maxProfitIII(int[] prices){
        int firstBuy = Integer.MIN_VALUE, firstSell = 0;
        int secondBuy = Integer.MIN_VALUE, secondSell = 0;
        for (int price : prices) {
            firstBuy = Math.max(firstBuy, -price);
            firstSell = Math.max(firstSell, firstBuy + price);
            secondBuy = Math.max(secondBuy, firstSell - price);
            secondSell = Math.max(secondSell, secondBuy + price);
        }
        return secondSell;
    }

    public static void main(String[] args) {
        int[] prices = {7,6,4,3,1};
        int[] pricesIII = {3,3,5,0,0,5,1,4,6};
        int result = new MaxProfit().maxProfit(prices);
        int resultIII = new MaxProfit().maxProfitIII(pricesIII);
        System.out.println(result);
        System.out.println(resultIII);
    }
}
