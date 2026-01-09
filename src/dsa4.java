public class dsa4 {

    public static int tappedRainWater(int arr[]){
        int trappedwater = 0 ;
        // Max left boundary
        int arr1 [] =  new int[arr.length];
        arr1[0] = arr[0];
        for(int i = 1 ; i <arr.length ; i++) {
            arr1[i]=Math.max(arr1[i-1],arr[i]);
        }
        System.out.println("Max left array");
        for(int num : arr1){
            System.out.print(num+" ");
        }
        // Max right Boundary
        int arr2 [] =  new int[arr.length];
        arr2[(arr.length)-1] = arr[(arr.length)-1];
        for(int i = arr.length-2 ; i >=0 ; i--) {
            arr2[i]=Math.max(arr2[i+1],arr[i]);
        }
        System.out.println("Max right array");
        for(int num : arr2){
            System.out.print(num+" ");
        }
        // main logic part - calculating the trapped water
        //trapped water = waterlevel - height of tower
        for(int i = 0 ; i<arr.length ; i++){
//            waterlevel=Math.min(arr1[i],arr2[i]);
            trappedwater += (Math.min(arr1[i],arr2[i])) - arr[i];

        }
        return trappedwater ;
    }

    public static int BuyAndSellStocks(int prices[]){
        int max_profit = 0 , buyPrice = Integer.MAX_VALUE;
        for(int i = 0 ; i<prices.length ; i++){
            int profit;
            if(buyPrice < prices[i]){
                profit = prices[i] - buyPrice;
                max_profit = Math.max(profit,max_profit);
            }else{
                buyPrice = prices[i];
            }
        }
        return max_profit;
    }
    public static void main(String[] args){
        int height[] ={4,2,0,6,3,2,5};
        int prices[]= {7,1,5,3,6,4};
//        System.out.println(tappedRainWater(height));
        System.out.println("Max profit = "+BuyAndSellStocks(prices));
    }
}
