
//https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
/*
    题目：
        给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
        如果你最多只允许完成一笔交易（即买入和卖出一支股票），
        设计一个算法来计算你所能获取的最大利润。
        注意你不能在买入股票前卖出股票。
        示例 1:
        输入: [7,1,5,3,6,4]
        输出: 5
        解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
             注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。

    思路：
        动态规划 前i天的最大收益 = max{前i-1天的最大收益，第i天的价格-前i-1天中的最小价格}
        找数组中最大的，和最小的，记录数组位置，保证最小的在最大的前面，做差
        注意：top要从low之后开始选，也就是说什么时候赋值的low，什么时候重新赋值top
        防止变量覆盖的方法：三目运算符 

*/


 public int maxProfit(int[] prices) {
        
        int minprices=Integer.MAX_VALUE;
        int max=0;
        
        for(int i=0;i<prices.length;i++){
            if(prices[i]<minprices)		//更新最小值
                minprices=prices[i];
            else if(prices[i]-minprices>max){	//只有两个选项 确保最大值在最小值的后面选
                max=prices[i]-minprices;
            }
        }
        return max;
 }



int maxProfit(int* prices, int pricesSize){
    if(pricesSize<2)
        return 0;
    int low, top, i, max, gain;
	max = low = gain = 0;
    top=1;
	for (i = 1; i < pricesSize; ++i)    //for循环中i=1,之前必须进行数组个数判断，否则会出现数组越界错误
	{
		if (prices[i] < prices[low])
			top = low = i;              //注意要对top重新赋值  
		if (prices[i]>prices[top])
			top = i;
		if (top>low)
		{
			gain = prices[top] - prices[low];
			max = max > gain ? max : gain;      //相当于第i天最大利润跟第i-1天最大利润比较
		}	
	}
	return max;
}




/*
    C的正常思路
    执行用时 :12 ms, 在所有 C 提交中击败了68.52%的用户
    内存消耗 :8 MB, 在所有 C 提交中击败了5.25%的用户
*/
int maxProfit(int* prices, int pricesSize){
    if(pricesSize<2)
        return 0;
    int i,max,min,temp;
    max=min=prices[0];
    temp=0;
    for(i=1;i<pricesSize;i++){
        if(min>prices[i]){
            max=min=prices[i];
        }
        if(max<prices[i]){
            max=prices[i];
            temp=temp>max-min?temp:max-min;
	    }
    }
    return temp;
}

//JAVA
//注意java中求max和min的表示方法
//Math.max()   Math.min()
class Solution {
    public int maxProfit(int[] prices) {
        int len=prices.length;
        int dp_i_0,dp_i_1;
        dp_i_0=0;
        dp_i_1=Integer.MIN_VALUE;       //注意dp_i_1表示买入价格，要保证初值最小   
        //注意java中int最大最小值的表示方法 
        //Integer.MIN_VALUE Integer.MAX_VALUE
        for(int i=0;i<len;i++){
            dp_i_0=Math.max(dp_i_0,dp_i_1+prices[i]);
            dp_i_1=Math.max(dp_i_1,-prices[i]);
        }
        return dp_i_0;
    }
}