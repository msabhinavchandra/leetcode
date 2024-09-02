

class Solution {

    static long topDown(int n) {
        // code here
        long mod=1000000000+7;
        List<Long> dp=new ArrayList<Long>();
        //initializing dp
        for(int i=0;i<=n;i++){
            dp.add(-1L);
        }
        //calling rec func
        long res=func(n,dp,mod)%mod;
        return res;
    }
    
    static long func(int n,List<Long> dp,Long mod){
        //Rec base condition
        if(n<=1) return n;
        if(dp.get(n)!=-1L) return dp.get(n);
        dp.set(n,(func(n-1,dp,mod)+func(n-2,dp,mod))%mod);
        return dp.get(n);
    }

    static long bottomUp(int n) {
        // code here
        long mod=1000000000+7;
        List<Long> dp=new ArrayList<Long>();
        dp.add(0L);dp.add(1L);
        for(int i=2;i<=n;i++){
            dp.add((dp.get(i-1)+dp.get(i-2))%mod);
        }
        return dp.get(n);
    }
}
