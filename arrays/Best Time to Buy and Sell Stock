class Solution(object):
    def maxProfit(self, prices):
  
        lf=0
        rt=1
        profit=0
        maxprofit=0
        while rt<len(prices):
           
            if prices[lf]>prices[rt]:
                lf=rt
       
            else:
                profit=prices[rt]-prices[lf]
                maxprofit=max(maxprofit,profit)
    

            rt=rt+1
 
        return maxprofit
