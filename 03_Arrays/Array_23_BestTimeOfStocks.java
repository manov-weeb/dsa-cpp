public class Array_23_BestTimeOfStocks {
     public static void main(String args[]) {
          int arr[] = { 7, 1, 5, 3, 6, 4 };
          System.out.println("Profit: " + optimalSolution(arr));
     }

     public static int bruteForce(int arr[]) {
          int maxProfit = 0;

          for (int i = 0; i < arr.length; i++) {
               int profit = 0;
               for (int j = i+1; j < arr.length; j++) {
                    profit = arr[j] - arr[i];
                    if (profit > maxProfit) {
                         maxProfit = profit;

                    }

               }
          }

          return maxProfit;
     }

     public static int optimalSolution(int arr[]) {
          int n = arr.length;
          int bestBuy = arr[0];
          int maxProfit = 0;

          for (int i = 1; i < n; i++) {
               int sell = arr[i];
               int profit = sell - bestBuy;

               maxProfit = Math.max(profit, maxProfit);

               bestBuy = Math.min(arr[i], bestBuy);
          }

          return maxProfit;

     }
}
